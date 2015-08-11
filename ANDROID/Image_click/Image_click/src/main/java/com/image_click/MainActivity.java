package com.image_click;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ImageButton imageButton;
    private Button button;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton=(ImageButton)findViewById(R.id.image_button);
        button=(Button)findViewById(R.id.normal_button);
        textView=(TextView)findViewById(R.id.show_Textview);
       imageButton.setOnFocusChangeListener(new OnFocusChangeListener() {

           @Override
           public void onFocusChange(View view, boolean b) {
               if(b==true){
                   textView.setText("¿´²»¼û");
                   imageButton.setImageResource(R.drawable.onfocus);
               }
               else {
                   textView.setText(R.string.lostfocus);
                   imageButton.setImageResource(R.drawable.lostfocus);
               }

           }
       });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(R.string.onfocus);
                imageButton.setImageResource(R.drawable.clickimage);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(R.string.lostfocus);
                imageButton.setImageResource(R.drawable.lostfocus);
            }
        });
    }



    
}
