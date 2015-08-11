package com.chao.contextmenu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView textView01,textView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        createComponent();
        register();
    }
    public void init(){
        textView01=null;
        textView02=null;
    }
    public void createComponent(){
        textView01=(TextView)findViewById(R.id.textview01);
        textView02=(TextView)findViewById(R.id.textview02);
    }
    public void register(){
        this.registerForContextMenu(textView01);
        this.registerForContextMenu(textView02);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==textView01) {
            menu.setHeaderIcon(R.drawable.photo1);
            menu.setHeaderTitle("My Menu");
            menu.add(1, 1, 1, "菜单1");
            menu.add(1, 1, 2, "菜单2");
            menu.add(1, 1, 3, "菜单3");
            menu.add(1, 1, 4, "菜单4");
            menu.add(1, 1, 5, "菜单5");
            menu.add(1, 1, 6, "菜单6");
            menu.add(1, 1, 7, "菜单7");
            menu.add(1, 1, 8, "菜单8");
        }
        else if(v==textView02){
            SubMenu subMenu1=menu.addSubMenu("二级菜单1");
            subMenu1.setHeaderIcon(R.drawable.photo2);
            subMenu1.add(0,0,0,"二级菜单1/菜单1");
            subMenu1.add(0,1,1,"二级菜单1/菜单2");
            subMenu1.setGroupCheckable(1,true,true);

            SubMenu subMenu2=menu.addSubMenu("二级菜单2");
            subMenu2.setHeaderIcon(R.drawable.photo2);
            subMenu2.add(1,0,0,"二级菜单2/菜单1");
            subMenu2.add(1,1,1,"二级菜单2/菜单2");
            subMenu2.setGroupCheckable(1,true,true);

            SubMenu subMenu3=menu.addSubMenu("二级菜单3");
            subMenu3.setHeaderIcon(R.drawable.photo2);
            subMenu3.add(1,0,0,"二级菜单3/菜单1");
            subMenu3.add(1,1,1,"二级菜单3/菜单2");
            subMenu3.setGroupCheckable(1,true,true);
        }



    }
}
