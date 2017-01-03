package com.example.administrator.helloworld.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Pull pull;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.pull = (Pull) findViewById(R.id.activity_main);
        TextView headIv=new TextView(MainActivity.this);
        headIv.setText("toujiao");
        pull.supperRecyclerView.addFooter(headIv);
        pull.supperRecyclerView.addHeader(headIv);
        pull.supperRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        initdata();
        initadapter();
    }

    private void initadapter() {
        pull.setadapter(new MyAdaper());
    }

    private void initdata() {
        list = Arrays.asList(getResources().getStringArray(R.array.testData));
    }

    private class MyAdaper extends RecyclerView.Adapter<MyHodler> {
        @Override
        public MyHodler onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHodler(View.inflate(MainActivity.this, android.R.layout.simple_list_item_1, null));
        }

        @Override
        public void onBindViewHolder(MyHodler holder, int position) {
            holder.tv.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class MyHodler extends RecyclerView.ViewHolder {
        TextView tv;

        public MyHodler(View itemView) {
            super(itemView);
            tv = (TextView) itemView;
        }
    }
}
