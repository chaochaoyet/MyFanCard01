package com.listview02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import itemperson.person;

import java.util.List;

/**
 * Created by chao on 15-3-26.
 */
public class personadapter extends ArrayAdapter {
    private LayoutInflater layoutInflater=null;
    private List<person> persons;
    public personadapter(Context context, int textViewResourceId, List objects) {
        super(context, textViewResourceId, objects);
        layoutInflater = LayoutInflater.from(context);
        persons = objects;
    }

    /**
     * 获取adapter里有多少个数据项
     */
    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 创建显示的数据界面
     *
     * Adapter的作用就是ListView界面与数据之间的桥梁，
     * 当列表里的每一项显示到页面时，都会调用Adapter的getView方法返回一个View。
     * 想过没有？ 在我们的列表有1000000项时会是什么样的？是不是会占用极大的系统资源？
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        // 优化前
        ViewHolder holder = new ViewHolder();
        convertView = layoutInflater.inflate(R.layout.main, null);
        holder.id = (TextView)convertView.findViewById(R.id.id);
        holder.name = (TextView)convertView.findViewById(R.id.name);
        holder.age = (TextView)convertView.findViewById(R.id.age);
        convertView.setTag(holder);

        holder.id.setText(persons.get(position).getId());
        holder.name.setText(persons.get(position).getName());
        holder.age.setText(persons.get(position).getAge());
        return convertView;
        */

        // 优化后
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.activity_main, null);
            holder = new ViewHolder();
            holder.id = (TextView)convertView.findViewById(R.id.id);
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.age = (TextView)convertView.findViewById(R.id.age);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.id.setText(persons.get(position).getId());
        holder.name.setText(persons.get(position).getName());
        holder.age.setText(persons.get(position).getAge());
        return convertView;
    }

    /**
     * 界面上的显示控件
     *
     * @author jiqinlin
     *
     */
    private static class ViewHolder{
        private TextView id;
        private TextView name;
        private TextView age;
    }


}
