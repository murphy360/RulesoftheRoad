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
        if(et.getText().toString() == "1"){ //// TODO: 7/17/2016 How to compare string values? 
            return true;
        }
        return false;
    }

    private boolean scoreQuestion4(){

        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox13);//Correct
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox14);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox15);//Correct
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox16);//Correct

        //If right answers are selected then this evaluates to true
        boolean answer = cb1.isChecked() & !cb2.isChecked() & cb3.isChecked() & cb4.isChecked();

        return answer;
    }
    
    public void scoreQuiz(View v){
        boolean q1 = scoreQuestion1();
        boolean q2 = scoreQuestion2();
        boolean q3 = scoreQuestion3();
        boolean q4 = scoreQuestion4();
        TextView scoreText = (TextView) findViewById(R.id.answerText);
        if(q1 & q2 & q3 & q4){
            scoreText.setText("100%");
        }else{
            EditText et = (EditText) findViewById(R.id.questionEditText3);
            scoreText.setText("Question 1: " + boolToString(q1)
                    + "\nQuestion 2: " + boolToString(q2)
                    + "\nQuestion 3: " + boolToString(q3)
                    + "\nQuestion 4: " + boolToString(q4)
                    + "\n" + et.getText().toString()//// TODO: 7/17/2016 Remove test line after figuring out problem 3 
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
