package com.chao.my_mp3player;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

/**
 * Created by chao on 2015/4/20.
 */
public class Mp3ListContentHandler extends DefaultHandler{
    private List<Mp3Info> infos=null;
    private Mp3Info mp3Info=null;
    private String tagName=null;

    public Mp3ListContentHandler(List<Mp3Info> infos) {
        this.infos = infos;
    }


    public List<Mp3Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Mp3Info> infos) {
        this.infos = infos;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       this.tagName=localName;
        if(tagName.equals("resources")){
            mp3Info=new Mp3Info();
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String temp=new String(ch,start,length);
        if(tagName.equals("id")){


            mp3Info.setId(temp);
        }
        else if(tagName.equals("mp3.name")){
            mp3Info.setMp3name(temp);
        }
        else if(tagName.equals("mp3.size")){
            mp3Info.setMp3size(temp);
        }
        else if (tagName.equals("lrc.name")){
            mp3Info.setLrcname(temp);
        }
        else if(tagName.equals("lrc.size")){
            mp3Info.setLrcsize(temp);
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("----------");
        if(qName.equals("resources")){
            System.out.println("aaaaaaaa");
            infos.add(mp3Info);
        }
        tagName="";
    }
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

    }



}
