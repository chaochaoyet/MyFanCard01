package com.chao.my_mp3player;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;


public class MainActivity extends ListActivity {
    private static final int UPDATE=1;
    private static final int ABOUT=2;
    private static final String url="http://192.168.1.102:8080/MP3/resources.xml";
    private List<Mp3Info> mp3Infos=null;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0,UPDATE,1,R.string.mp3_update);
        menu.add(0,ABOUT,2,R.string.mp3_about);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if(item.getItemId()==UPDATE){
            //用户点击了更新按钮
            updateListView();




        }
        else if(item.getItemId()==ABOUT){
            //用户点击了关于按钮
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Mp3Info mp3Info=mp3Infos.get(position);
        System.out.println("mp3info--->"+mp3Info);
        super.onListItemClick(l, v, position, id);
    }

    private void updateListView(){
        String xml=downloadXML(url);
        System.out.println("xml--->"+xml);
        mp3Infos= parse(xml);
        SimpleAdapter simpleAdapter=bulidSimpleAdapter(mp3Infos);
        listView.setAdapter(simpleAdapter);


    }
    private SimpleAdapter bulidSimpleAdapter(List<Mp3Info> mp3Infos){
        List<HashMap<String,String>> list=new ArrayList<HashMap<String, String>>();
        for (Iterator iterator=mp3Infos.iterator();iterator.hasNext();){
            Mp3Info mp3Info=(Mp3Info) iterator.next();
            HashMap<String,String> map=new HashMap<String,String>();
            map.put("mp3_name",mp3Info.getMp3name());
            map.put("mp3_size",mp3Info.getMp3size());
            list.add(map);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,list,R.layout.mp3info_item,new String[]{"mp3_name","mp3_size"},new int[]{R.id.mp3_name,R.id.mp3_size});
        return simpleAdapter;
    }
    private String downloadXML(String urlstr){
        HttpDownloader httpDownloader=new HttpDownloader();
        String result=httpDownloader.download(urlstr);
        return result;
    }
    private List<Mp3Info> parse(String xmlstr){
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        List<Mp3Info> infos=new ArrayList<Mp3Info>();
        try{
            XMLReader xmlReader=saxParserFactory.newSAXParser().getXMLReader();


            Mp3ListContentHandler mp3ListContentHandler=new Mp3ListContentHandler(infos);
            xmlReader.setContentHandler(mp3ListContentHandler);
            xmlReader.parse(new InputSource(new StringReader(xmlstr)));
            for(Iterator iterator=infos.iterator();iterator.hasNext();){
                Mp3Info mp3Info=(Mp3Info)iterator.next();
                System.out.println(mp3Info);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return infos;
    }

}
