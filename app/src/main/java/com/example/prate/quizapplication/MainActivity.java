package com.example.prate.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * This app quizzes the user on simple math problems
 */

public class MainActivity extends AppCompatActivity {
    //Initializes global variables for storing the click state of questions three and sixes radio buttons
    private boolean questionThreeChoice = false;
    private boolean questionSixChoice = false;

    // Initializes the global variables for the click state of questions twos check boxes
    private boolean isChoiceQuestionTwoCheckBoxOne = false;
    private boolean isChoiceQuestionTwoCheckBoxTwo = false;
    private boolean isChoiceQuestionTwoCheckBoxThree = false;
    private boolean isChoiceQuestionTwoCheckBoxFour = false;

    // Initializes the global variables for the click state of questions fives check boxes
    private boolean isChoiceQuestionFiveCheckBoxOne = false;
    private boolean isChoiceQuestionFiveCheckBoxTwo = false;
    private boolean isChoiceQuestionFiveCheckBoxThree = false;
    private boolean isChoiceQuestionFiveCheckBoxFour = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method determines the checked state for the checkboxes on questions two and five
     */
    public void onCheckboxClicked(View view) {
        // Initialize local variables for question twos checkboxes
        CheckBox questionTwoCheckBoxOne = findViewById(R.id.question_two_checkbox_one);
        CheckBox questionTwoCheckBoxTwo = findViewById(R.id.question_two_checkbox_two);
        CheckBox questionTwoCheckBoxThree = findViewById(R.id.question_two_checkbox_three);
        CheckBox questionTwoCheckBoxFour = findViewById(R.id.question_two_checkbox_four);

        // Initialize local variables for question sixes checkboxes
        CheckBox questionFiveCheckBoxOne = findViewById(R.id.question_five_checkbox_one);
        CheckBox questionFiveCheckBoxTwo = findViewById(R.id.question_five_checkbox_two);
        CheckBox questionFiveCheckBoxThree = findViewById(R.id.question_five_checkbox_three);
        CheckBox questionFiveCheckBoxFour = findViewById(R.id.question_five_checkbox_four);

        // Check if question two checkbox one is checked
        if (questionTwoCheckBoxOne.isChecked()) {
            isChoiceQuestionTwoCheckBoxOne = true;
        } else {
            isChoiceQuestionTwoCheckBoxOne = false;
        }

        // Check if question two checkbox two is checked
        if (questionTwoCheckBoxTwo.isChecked()) {
            isChoiceQuestionTwoCheckBoxTwo = true;
        } else {
            isChoiceQuestionTwoCheckBoxTwo = false;
        }

        // Check if question two checkbox three is checked
        if (questionTwoCheckBoxThree.isChecked()) {
            isChoiceQuestionTwoCheckBoxThree = true;
        } else {
            isChoiceQuestionTwoCheckBoxThree = false;
        }

        // Check if question two checkbox four is checked
        if (questionTwoCheckBoxFour.isChecked()) {
            isChoiceQuestionTwoCheckBoxFour = true;
        } else {
            isChoiceQuestionTwoCheckBoxFour = false;
        }

        // Check if question five checkbox one is checked
        if (questionFiveCheckBoxOne.isChecked()) {
            isChoiceQuestionFiveCheckBoxOne = true;
        } else {
            isChoiceQuestionFiveCheckBoxOne = false;
        }

        // Check if question five checkbox two is checked
        if (questionFiveCheckBoxTwo.isChecked()) {
            isChoiceQuestionFiveCheckBoxTwo = true;
        } else {
            isChoiceQuestionFiveCheckBoxTwo = false;
        }

        // Check if question five checkbox three is checked
        if (questionFiveCheckBoxThree.isChecked()) {
            isChoiceQuestionFiveCheckBoxThree = true;
        } else {
            isChoiceQuestionFiveCheckBoxThree = false;
        }

        // Check if question five checkbox four is checked
        if (questionFiveCheckBoxFour.isChecked()) {
            isChoiceQuestionFiveCheckBoxFour = true;
        } else {
            isChoiceQuestionFiveCheckBoxFour = false;
        }

    }

    /**
     * This method determines the checked state for the radio buttons on questions three and six
     */
    public void onRadioButtonClicked(View view) {
        // Initialize local variables for the correct radio buttons on questions three and six
        RadioButton questionThreeRadioButton = findViewById(R.id.question_three_radio_four);
        RadioButton questionSixRadioButton = findViewById(R.id.question_six_radio_two);

        // Check if question threes fourth radio button is clicked
        if (questionThreeRadioButton.isChecked()) {
            questionThreeChoice = true;
        } else {
            questionThreeChoice = false;
        }

        // Check if question sixes second radio button is checked
        if (questionSixRadioButton.isChecked()) {
            questionSixChoice = true;
        } else {
            questionSixChoice = false;
        }

    }

    /**
     * This method checks if the users answers are correct when the sumbit button is clicked
     * then displays their score in a toast message
     */
    public void checkAnswers(View view) {

        //Initialize the variables for the users score to be zero
        int score = 0;

        //Get the users response for question one
        EditText userAnswerOneEditText = findViewById(R.id.answer_one_text);
        String userAnswerOne = userAnswerOneEditText.getText().toString();

        //Get the users response for question four
        EditText userAnswerFourEditText = findViewById(R.id.answer_four_text);
        String userAnswerFour = userAnswerFourEditText.getText().toString();

        //These if statements increment the score if the user got the question correct
        // If the user got question one correct increment the score
        if (userAnswerOne.equals("10")) {
            score++;
        }

        // If the user got question two correct increment the score
        if ((isChoiceQuestionTwoCheckBoxOne & isChoiceQuestionTwoCheckBoxFour) & !isChoiceQuestionTwoCheckBoxTwo & !isChoiceQuestionTwoCheckBoxThree) {
            score++;
        }

        // If the user got question three correct increment the score
        if (questionThreeChoice) {
            score++;
        }

        // If the user got question four correct increment the score
        if (userAnswerFour.equals("24")) {
            score++;
        }

        // If the user got question five correct increment the score
        if (isChoiceQuestionFiveCheckBoxOne & isChoiceQuestionFiveCheckBoxTwo & isChoiceQuestionFiveCheckBoxThree & !isChoiceQuestionFiveCheckBoxFour) {
            score++;
        }

        // If the user got question six correct increment the score
        if (questionSixChoice) {
            score++;
        }

        //This toast message displays the users score when the submit button is clicked
        Toast.makeText(getApplicationContext(), "You got " + score + " out of 6 questions correct",
                Toast.LENGTH_LONG).show();
    }
}
