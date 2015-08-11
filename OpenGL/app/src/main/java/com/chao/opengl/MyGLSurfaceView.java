package com.chao.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by chao on 2015/6/19.
 */
public class MyGLSurfaceView extends GLSurfaceView{
    public  MyGLSurfaceView(Context context){
        super(context);
        try {
            setEGLContextClientVersion(2);
            setRenderer(new MyRenderer());
            setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
