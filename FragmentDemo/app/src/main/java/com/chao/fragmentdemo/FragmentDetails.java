package com.chao.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chao on 2015/7/20.
 */
public class FragmentDetails extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details,container,false);
    }
    public void setText(String item){
        TextView textView=(TextView)getView().findViewById(R.id.detail_text);
        textView.setText(item);
    }
}
