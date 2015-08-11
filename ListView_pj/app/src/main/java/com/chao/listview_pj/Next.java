package com.chao.listview_pj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by chao on 2015/4/15.
 */
public class Next extends Activity{
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.text);
        Intent intent1=this.getIntent();
        String str=intent1.getStringExtra("zc");
        textView.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Next.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
