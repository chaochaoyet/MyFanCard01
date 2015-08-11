package com.chao.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chao on 2015/4/7.
 */
public class SelfAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<MyGrid> gridlist;
    private LayoutInflater layoutInflater;
    private class Grider{
        ImageView imageView;
        TextView textView;
    }
    public SelfAdapter(Context context){
        super();this.context=context;
    }
    public void setList(ArrayList<MyGrid> gridlist){
        this.gridlist=gridlist;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount(){
        return gridlist.size();
    }
    @Override
    public long getItemId(int index){
        return index;
    }
    @Override
    public Object getItem(int index){
        return gridlist.get(index);
    }
    @Override
    public View getView(int index,View view,ViewGroup parent){
        Grider gridholder;
        if(view!=null){
            gridholder=(Grider)view.getTag();
        }
        else {
            gridholder=new Grider();
            view=layoutInflater.inflate(R.layout.grid,null);
            gridholder.imageView=(ImageView)view.findViewById(R.id.imageview);
            gridholder.textView=(TextView)view.findViewById(R.id.textview);
            view.setTag(gridholder);
        }
        MyGrid grid=gridlist.get(index);
        if(grid!=null){
            gridholder.textView.setText(grid.getObjname());
        }
        return view;
    }
}
