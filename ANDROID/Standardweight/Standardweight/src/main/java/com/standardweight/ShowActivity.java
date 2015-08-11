package com.standardweight;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ShowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_weight);
        Bundle bundle=this.getIntent().getExtras();
        String sex=bundle.getString("sex");
        double height=bundle.getDouble("height");
        String sexText;
        if(sex.equals("man")){
            sexText="����";
        }
        else
            sexText="Ů��";
        String weight=getWeight(sex,height);
        TextView tv1=(TextView)findViewById(R.id.text1);
        tv1.setText("����һλ"+sexText+"\n��������"+height+"\n��ı�׼����Ϊ��"+weight);

    }
    private String format(double num){
        NumberFormat numberFormat=new DecimalFormat("0.00");
        String s=numberFormat.format(num);
        return s;
    }
    private String getWeight(String sex,double height){
        String weight;
        if(sex.equals("man")){
            weight=format((height-80)*0.7);
        }
        else
            weight=format((height-70)*0.6);
        return weight;
    }




}
