package com.chao.button_in_listview;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.chao.button_in_listview.R;

/**
 * Created by chao on 2015/5/28.
 */
public class MyAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private List<Map<String,Object>> mData;
    private int flag;
    public static String title_1[]=new String[]{"菜名0","菜名1","菜名2","菜名3","菜名4","菜名5","菜名6","菜名7","菜名8","菜名9"};
    public static String info[]=new String[]{ "￥：28","￥：28","￥：28","￥：28","￥：28","￥：28","￥：28","￥：28","￥：28","￥：28",};



    public MyAdapter(Context context) {
        this.mInflater=LayoutInflater.from(context);

        init();
    }
    private void  init(){
        mData=getData();
    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0;i<title_1.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("title_1", title_1[i]);
            map.put("info", info[i]);
            list.add(map);}
        return list;
        }

        @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.item,null);
            holder.title_1=(TextView)convertView.findViewById(R.id.title_1);
            holder.info=(TextView)convertView.findViewById(R.id.info);
            holder.viewBtn=(Button)convertView.findViewById(R.id.view_button);
            holder.content=(EditText)convertView.findViewById(R.id.content);
            holder.viewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    System.out.println("hello" + position);
                }
            });
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder)convertView.getTag();
        }
        holder.title_1.setText((String)mData.get(position).get("title_1"));
        holder.info.setText((String)mData.get(position).get("info"));
        holder.viewBtn.setTag(position);
        holder.content.setTag(position);


        return convertView;
    }




    public final class ViewHolder{
        public TextView title_1;
        public TextView info;
        public Button viewBtn;
        public EditText content;
    }


}
