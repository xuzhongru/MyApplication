package com.example.administrator.helloworld.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */

public class Pull extends RelativeLayout {
    ////ygfhgfjgjhhgu
    private float dimension = 25;
    private ImageView head;
    private LayoutParams headparams;
    private ImageView foot;
    private LayoutParams footerparams;
    public SupperRecyclerView supperRecyclerView;
    private LayoutParams recycerParams;


    public Pull(Context context) {
        this(context, null);
    }

    public Pull(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Pull(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        initHead();
        initFooter();
        initContent();

    }


    private void initContent() {
        supperRecyclerView = new SupperRecyclerView(getContext());
        recycerParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        recycerParams.addRule(ABOVE, R.id.footer);
        recycerParams.addRule(BELOW, R.id.header);
        supperRecyclerView.setLayoutParams(recycerParams);

        addView(supperRecyclerView);
    }

    private void initFooter() {
        foot = new ImageView(getContext());
        footerparams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int) dimension);
        footerparams.addRule(CENTER_HORIZONTAL);
        footerparams.addRule(ALIGN_PARENT_BOTTOM);
        footerparams.bottomMargin = (int) -dimension;
        foot.setLayoutParams(footerparams);
        foot.setId(R.id.footer);
        foot.setImageResource(R.mipmap.dota2_y);

        addView(foot);

    }

    private void initHead() {
        head = new ImageView(getContext());
        headparams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int) dimension);
        headparams.addRule(CENTER_HORIZONTAL);
        head.setLayoutParams(headparams);
//        LogUtils.log("asd",dimension+"");
        headparams.topMargin = (int) -dimension;
        head.setId(R.id.header);
        head.setImageResource(R.mipmap.ic_launcher);
//        Log.e("tag","header-->"+images[0]);
        addView(head);
    }

    public void setadapter(RecyclerView.Adapter a) {
        supperRecyclerView.setAdapter(a);
    }

}
