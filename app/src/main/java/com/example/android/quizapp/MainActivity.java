package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupQuestion1;
    private RadioGroup radioGroupQuestion2;
    private RadioGroup radioGroupQuestion3;
    private RadioButton radioButtonQuestion1;
    private RadioButton radioButtonQuestion2;
    private RadioButton radioButtonQuestion3;
    private Button buttonSubmit;
    String toastMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        radioGroupQuestion1 = (RadioGroup) findViewById(R.id.radioGroupQuestion1Id);
        radioGroupQuestion2 = (RadioGroup) findViewById(R.id.radioGroupQuestion2Id);
        radioGroupQuestion3 = (RadioGroup) findViewById(R.id.radioGroupQuestion3Id);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmitId);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroup
                int selectedIdRadioGroup1 = radioGroupQuestion1.getCheckedRadioButtonId();
                int selectedIdRadioGroup2 = radioGroupQuestion2.getCheckedRadioButtonId();
                int selectedIdRadioGroup3 = radioGroupQuestion3.getCheckedRadioButtonId();
                if (selectedIdRadioGroup1 == -1 || selectedIdRadioGroup2 == -1 || selectedIdRadioGroup3 == -1) {
                    Toast.makeText(MainActivity.this, getString(R.string.toast_Msg), Toast.LENGTH_SHORT).show();
                } else {
                    // find the radiobutton by returned id
                    radioButtonQuestion1 = (RadioButton) findViewById(selectedIdRadioGroup1);
                    radioButtonQuestion2 = (RadioButton) findViewById(selectedIdRadioGroup2);
                    radioButtonQuestion3 = (RadioButton) findViewById(selectedIdRadioGroup3);
                    String selectedAnswerQuestion1 = (String) radioButtonQuestion1.getText();
                    String selectedAnswerQuestion2 = (String) radioButtonQuestion2.getText();
                    String selectedAnswerQuestion3 = (String) radioButtonQuestion3.getText();
                    //Set Correct Answer for all Question
                    String correctAnswerQuestion1 = getString(R.string.answer3);
                    String correctAnswerQuestion2 = getString(R.string.answer2);
                    String correctAnswerQuestion3 = getString(R.string.answer4);
                    Log.v("MainActivity:", "selectedAnswerQuestion1.equals(correctAnswerQuestion1):: " + selectedAnswerQuestion1.equals(correctAnswerQuestion1));
                    //Compare selected answer with correct answer
                    if (selectedAnswerQuestion1.equals(correctAnswerQuestion1) && selectedAnswerQuestion2.equals(correctAnswerQuestion2) && selectedAnswerQuestion3.equals(correctAnswerQuestion3)) {
                        toastMsg = getString(R.string.toast_Msg_score_3);
                        Log.v("MainActivity:", "Option Selected: " + toastMsg);
                        Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();
                    } else if ((selectedAnswerQuestion1.equals(correctAnswerQuestion1) && selectedAnswerQuestion2.equals(correctAnswerQuestion2)) || (selectedAnswerQuestion2.equals(correctAnswerQuestion2) && selectedAnswerQuestion3.equals(correctAnswerQuestion3)) || (selectedAnswerQuestion1.equals(correctAnswerQuestion1) && selectedAnswerQuestion3.equals(correctAnswerQuestion3))) {
                        toastMsg = getString(R.string.toast_Msg_score_2);
                        Log.v("MainActivity:", "Option Selected: " + toastMsg);
                        Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();
                    } else if (selectedAnswerQuestion1.equals(correctAnswerQuestion1) || selectedAnswerQuestion2.equals(correctAnswerQuestion2) || selectedAnswerQuestion3.equals(correctAnswerQuestion3)) {
                        toastMsg = getString(R.string.toast_Msg_score_1);
                        Log.v("MainActivity:", "Option Selected: " + toastMsg);
                        Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();
                    } else {
                        toastMsg = getString(R.string.toast_Msg_score_0);
                        Log.v("MainActivity:", "Option Selected: " + toastMsg);
                        Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
