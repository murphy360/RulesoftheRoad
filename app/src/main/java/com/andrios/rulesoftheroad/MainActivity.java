package com.andrios.rulesoftheroad;
/**
 * This is an incredibly inefficient design.
 * need to create question classes and fill in a list view
 * I can pull my database from excel and mass-produce the checkbox answers
 * add them randomly to a list view
 *
 * Author: Corey Murphy
 * eMail: c.murphy360@gmail.com

 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private boolean scoreQuestion1(){
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);//Correct
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);//Correct
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);

        //If right answers are selected then this evaluates to true
        boolean answer = cb1.isChecked() & !cb2.isChecked() & cb3.isChecked() & !cb4.isChecked();
        
        return answer;
    }

    /**
     *
     * @return true is radioButton1 is checked on UI
     */
    private boolean scoreQuestion2(){
        RadioButton rd1 = (RadioButton) findViewById(R.id.radioButton1);

        return rd1.isChecked();
    }

    private boolean scoreQuestion3(){
        EditText et = (EditText) findViewById(R.id.questionEditText3);
        int test = 1;
        if(et.getText().toString().equals("1")){ //// TODO: 7/17/2016 How to compare string values?
            return true;
        }
        return false;
    }

    private boolean scoreQuestion4() {

        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox13);//Correct
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox14);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox15);//Correct
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox16);//Correct

        //If right answers are selected then this evaluates to true
        boolean answer = cb1.isChecked() & !cb2.isChecked() & cb3.isChecked() & cb4.isChecked();

        return answer;
    }

    private boolean scoreQuestion5(){
        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton2);//Correct if checked
        return rb1.isChecked();
    }
    
    public void scoreQuiz(View v){
        boolean q1 = scoreQuestion1();
        boolean q2 = scoreQuestion2();
        boolean q3 = scoreQuestion3();
        boolean q4 = scoreQuestion4();
        boolean q5 = scoreQuestion5();
        float correct = 0;
        TextView scoreText = (TextView) findViewById(R.id.answerText);


        if(q1 & q2 & q3 & q4 & q5){
            scoreText.setText("Great Job! 100%");
        }else{
            EditText et = (EditText) findViewById(R.id.questionEditText3);
            if(q1){
                correct ++;
            }
            if(q2){
                correct ++;
            }
            if(q3){
                correct ++;
            }
            if(q4){
                correct ++;
            }
            if(q5){
                correct ++;
            }
            float score = (correct * 100) / 5;
            scoreText.setText("Question 1: " + boolToString(q1)
                    + "\nQuestion 2: " + boolToString(q2)
                    + "\nQuestion 3: " + boolToString(q3)
                    + "\nQuestion 4: " + boolToString(q4)
                    + "\nQuestion 5: " + boolToString(q5)
                    + "\nTotal: " +  score + "%"
            );
        }


    }


    private String boolToString(boolean b){

        if(b){
            return "Correct";
        }
        return "Incorrect";
    }
}
