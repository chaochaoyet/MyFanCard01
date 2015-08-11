package com.radiobutton;

import android.app.AlertDialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class MainActivity extends Activity {
    private TextView answer_textview;
    private RadioButton radiobutton_boy,radiobutton_girl;
    private RadioGroup radioGroup;
    private Button button_answer,button_clean;
    private String[]   boy_girl;
    private AlertDialog.Builder show_right_or_wrong;
    private MenuItem exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer_textview=(TextView)findViewById(R.id.ask_and_show);
        radioGroup=(RadioGroup)findViewById(R.id.Radiogroup);
        radiobutton_boy=(RadioButton)findViewById(R.id.radiobutton_boy);
        radiobutton_girl=(RadioButton)findViewById(R.id.radiobutton_girl);
        button_answer=(Button)findViewById(R.id.button_answer);
        button_clean=(Button)findViewById(R.id.button_clean);
        show_right_or_wrong=new AlertDialog.Builder(this);
        boy_girl=new String[]{"boy","girl","boy","girl","boy","girl","boy","girl","boy"};
        button_answer.setEnabled(false);
        button_clean.setEnabled(false);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radiobutton_boy.isChecked()){
                    answer_textview.setText(R.string.i_am_a_boy);
                }
                else if(radiobutton_girl.isChecked()){
                    answer_textview.setText(R.string.i_am_a_girl);
                }
            }
        });
        radiobutton_boy.setOnClickListener(new RadioGroup.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_answer.setEnabled(true);
                button_clean.setEnabled(true);
            }
        });
        radiobutton_girl.setOnClickListener(new RadioGroup.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_answer.setEnabled(true);
                button_clean.setEnabled(true);
            }
        });
      button_answer.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


                      if(radiobutton_boy.isChecked()){
                          checkTheAnswer("boy");
                      }
                      else if(radiobutton_girl.isChecked()){
                          checkTheAnswer("girl");
                      }

                  }




      });
        button_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                        radiobutton_girl.setChecked(false);
                        radiobutton_boy.setChecked(false);
                        button_answer.setEnabled(false);
                        button_clean.setEnabled(false);
                        answer_textview.setText(R.string.ask);
                    }



        });




    }

    private void checkTheAnswer(String checkstring){
        Toast.makeText(MainActivity.this,"¼ì²â´ð°¸...",Toast.LENGTH_LONG).show();
        Random random=new Random();
        int index=random.nextInt(9);
        if(boy_girl[index].equals(checkstring)){
            show_right_or_wrong.setIcon(R.drawable.ic_launcher);
            show_right_or_wrong.setTitle(R.string.YES);
            show_right_or_wrong.setPositiveButton(R.string.OK,null);
            show_right_or_wrong.setMessage(R.string.right).show();
            Toast.makeText(this,getString(R.string.anwser_is)+boy_girl[index],Toast.LENGTH_LONG).show();
        }
        else {
            show_right_or_wrong.setIcon(R.drawable.ic_launcher);
            show_right_or_wrong.setTitle(R.string.NO);
            show_right_or_wrong.setPositiveButton(R.string.OK,null);
            show_right_or_wrong.setMessage(R.string.wrong).show();
            Toast.makeText(this,getString(R.string.anwser_is)+boy_girl[index],Toast.LENGTH_LONG).show();
        }
    }





    
}
