package com.btton_layout;

import android.os.Bundle;
import android.support.annotation.Nulllable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPage3 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater,@Nulllable ViewGroup container,@Nulllable Bundle savedInstaceState){
        return inflater.inflate(R.layout.fragment3,null);
    }
}
