package com.chao.cehuacaidan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private SlidingMenu mMenu;
    private Button menu_bg;
    private TextView menu_text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        menu_bg=(Button)findViewById(R.id.menu_bg);
        menu_text=(TextView)findViewById(R.id.menu_text);
        menu_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_text.setText("zchello");
            }
        });
        mMenu=(SlidingMenu)findViewById(R.id.id_menu);


    }
    public void toggleMenu(View view){
        mMenu.toggle();
    }


}
