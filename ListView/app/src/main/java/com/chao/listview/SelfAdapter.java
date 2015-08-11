package com.chao.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chao on 2015/4/7.
 */
public class SelfAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<MyList> list;
    private LayoutInflater layoutInflater;
    private class List{
        ImageView imageView;
        TextView textView;
    }
    public SelfAdapter(Context context){
        super();
        this.context=context;
    }
    public void setList(ArrayList<MyList> list){
        this.list=list;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount(){
        return list.size();
    }
    @Override
    public long getItemId(int index){
        return index;
    }
    @Override
    public Object getItem(int index){
        return list.get(index);
    }
    @Override
    public View getView(int index,View view,ViewGroup viewGroup){
        List listholder;
        if(view!=null){
            listholder=(List)view.getTag();
        }
        else {
            listholder=new List();
            view=layoutInflater.inflate(R.layout.list,null);
            listholder.imageView=(ImageView)view.findViewById(R.id.imageview);
            listholder.textView=(TextView)view.findViewById(R.id.textview);
            view.setTag(listholder);
        }
        MyList list1=list.get(index);
        if(list1!=null){
            listholder.textView.setText(list1.getObjname());
        }
        else {

        }
        return view;
    }
}
