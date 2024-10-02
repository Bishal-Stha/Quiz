# Quiz Application 🎓

This is an Android-based quiz app that asks a series of questions and provides feedback based on user responses. Users can answer multiple-choice questions and see the correct or incorrect status immediately after selecting an answer. The app supports navigation between questions and displays a final screen after completing the quiz.

## Features 🚀
- **Multiple-choice questions**: The app presents a list of questions, each with four answer options.
- **Immediate feedback**: Users get instant feedback on whether their selected answer is correct or not.
- **Final score screen**: Upon completion, the app displays a congratulatory message and the total score.
- **Edge-to-edge UI**: The app is designed to support modern Android edge-to-edge layouts.
- **Smooth navigation**: Users can navigate through questions using a "Next" button.
  
## Application Structure 🏗️

The application consists of two main screens:
1. **Main Quiz Screen**: Displays questions and answer options, and tracks user progress.
2. **Final Screen**: Shown after the user completes all the questions, it congratulates the user on finishing the quiz.

### 1. MainActivity (`MainActivity.kt`)
- Handles displaying questions, tracking user responses, and navigating to the next question.
- Displays instant feedback if the user's answer is correct or incorrect.
- At the end of the quiz, it transitions to the final screen.

### 2. Final Screen (`finalScreen.kt`)
- Displays a congratulatory message upon completion of the quiz.
- UI is simple, featuring a large image and congratulatory text.

### 3. Data Class (`Question.kt`)
- Defines the `Question` model, which contains the following fields:
  - `id`: Unique identifier for the question.
  - `question`: The quiz question.
  - `option1`, `option2`, `option3`, `option4`: Answer choices.
  - `answer`: The correct answer to the question.

## Layout Design 🖼️

### `activity_main.xml`
- The main layout includes:
  - **CardView** for displaying the question and answer options.
  - **RadioGroup** for presenting multiple-choice answers.
  - **TextView** for feedback on whether the answer is correct or incorrect.
  - **ImageButton** for navigating to the next question.
  
### `activity_final_screen.xml`
- The final screen layout includes:
  - A congratulatory **TextView**.
  - An **ImageView** for visual aesthetics.
  
### Background and Design Elements:
- **Background Gradients**: The app uses custom drawable gradients (`gradient2`, `gradient3`) for its background to enhance visual appeal.
- **Image Assets**: Assets such as `winner` for the final screen and navigation icons are used to enrich the user experience.

## Usage 📱

1. **Start the Quiz**: Launch the app and begin answering the questions.
2. **Select an Answer**: Choose an answer from the provided options.
3. **Receive Feedback**: You will be notified immediately if your answer is correct or incorrect.
4. **Next Question**: Click the "Next" button to proceed to the next question.
5. **Completion**: Upon completing all questions, you will be shown a final screen with a congratulatory message.

## Future Improvements 🔮

- **Scoring System**: Implement a detailed scoring mechanism that shows the user's performance at the end of the quiz.
- **Back Navigation**: Add the ability to revisit and change previous answers before submitting the quiz.
- **Question Timer**: Include a timer for each question to increase the challenge.
- **Category Selection**: Allow users to select different quiz categories or difficulty levels.

## How to Build and Run 🛠️

### Prerequisites
- Android Studio installed on your machine.
- Minimum SDK version: `21` (Android 5.0 Lollipop).

### Steps
1. Clone this repository:
    ```bash
    git clone https://github.com/yourusername/quiz-app.git
    ```
2. Open the project in **Android Studio**.
3. Build the project and run it on an Android emulator or a physical device.
