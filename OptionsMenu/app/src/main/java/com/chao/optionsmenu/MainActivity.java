package com.chao.optionsmenu;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Method;


public class MainActivity extends ActionBarActivity {
    private MenuItem item_delete,item_save,item_help;
    private Intent intent_delete,intent_save,intent_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    public void init(){
        item_delete=null;
        item_save=null;
        item_help=null;
        intent_delete=null;
        intent_save=null;
        intent_help=null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setIconEnable(menu, true);
        item_delete=menu.add(Menu.NONE,1,1,"删除");
        item_delete.setIcon(android.R.drawable.ic_menu_delete);
        item_save=menu.add(Menu.NONE,2,1,"保存");
        item_save.setIcon(R.drawable.ic_launcher);
        item_help=menu.add(Menu.NONE,3,1,"帮助");
        item_help.setIcon(android.R.drawable.ic_menu_help);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                intent_delete=new Intent(MainActivity.this,Delete.class);
                startActivity(intent_delete);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        // TODO Auto-generated method stub
        return super.onPrepareOptionsMenu(menu);
    }

    //enable为true时，菜单添加图标有效，enable为false时无效。4.0系统默认无效
    private void setIconEnable(Menu menu, boolean enable)
    {
        try
        {
            Class<?> clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");
            Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            m.setAccessible(true);

            //MenuBuilder实现Menu接口，创建菜单时，传进来的menu其实就是MenuBuilder对象(java的多态特征)
            m.invoke(menu, enable);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
