package com.example.quiz
import Question
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Check if views are correctly initialized
        val next = findViewById<ImageButton>(R.id.nextBtn)
        val question = findViewById<TextView>(R.id.question)
        val options = findViewById<RadioGroup>(R.id.options)
        val option1 = findViewById<RadioButton>(R.id.option1)
        val option2 = findViewById<RadioButton>(R.id.option2)
        val option3 = findViewById<RadioButton>(R.id.option3)
        val option4 = findViewById<RadioButton>(R.id.option4)
        val output = findViewById<TextView>(R.id.outputText)

        if (next == null || question == null || options == null || option1 == null || option2 == null || option3 == null || option4 == null) {
            Toast.makeText(this, "Failed to initialize views", Toast.LENGTH_SHORT).show()
            return // Exit if the view is not found
        }

        // List of questions
        val questions = mutableListOf(
            Question(1, "What is the full form of PDF?", "Printable Document Format", "Portable Document Format", "Portable Document file", "Portable Document Formatted", "Portable Document Format"),
            Question(2, "What is the capital city of China?", "Beijing", "Mumbai", "Tokyo", "Bangkok", "Beijing"),
            Question(3, "Who discovered the Rings of Saturn for the first time?", "Galileo Galilei", "Isaac Newton", "Stephen Hawking", "Charles Darwin", "Galileo Galilei"),
            Question(4, "What is the primary purpose of the try and except blocks in Python?", "To handle exceptions", "To define functions", "To create loops", "To test code", "To handle exceptions"),
            Question(5, "What does the print() function do in Python?", "It reads input from the user.", "It prints text to the console.", "It creates a new file.", "It stops the execution of the program.", "It prints text to the console.")
        )

        var i = 0 // Track current question index
        var correctAnswer = 0 // Track correct answers

        // Display the first question
        question.text = questions[i].question
        option1.text = questions[i].option1
        option2.text = questions[i].option2
        option3.text = questions[i].option3
        option4.text = questions[i].option4
        options.clearCheck()

        // Listener for option selection
        options.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId != -1) { // Ensure something is selected
                val selectedOptionText = findViewById<RadioButton>(checkedId)?.text?.toString()

                // Compare the selected option text with the correct answer
                if (selectedOptionText == questions[i].answer) {
                    correctAnswer++
                    output.text = "You got it Correct."
                    output.visibility = TextView.VISIBLE
                } else {
                    output.text = "You got it Incorrect."
                    output.visibility = TextView.VISIBLE
                }
            }
        }

        // Set listener for the "Next" button click
        next.setOnClickListener {
            options.clearCheck()
            if (i < questions.size - 1) {
                // Increment to the next question
                i++

                // Update the question and options
                question.text = questions[i].question
                option1.text = questions[i].option1
                option2.text = questions[i].option2
                option3.text = questions[i].option3
                option4.text = questions[i].option4

                // Clear previous selection
                options.clearCheck()
            } else {
                // End of the quiz
                val intent = Intent(this, finalScreen::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "You've reached the end of the quiz!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
