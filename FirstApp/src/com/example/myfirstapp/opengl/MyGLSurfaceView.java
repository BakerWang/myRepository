package com.example.myfirstapp.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;
//2.һ��GLSurfaceView��һ���ض���View����View������Ի���OpenGL ESͼ��
public class MyGLSurfaceView extends GLSurfaceView {

    public MyGLSurfaceView(Context context){
        super(context);

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(new MyGLRenderer());
    }
}