package com.example.tongxunlu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView lv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //得到数据,建立连接
        GetNumber.getNumber(this);
        //显示到listview上
        MyAdapter myAdapter = new MyAdapter(GetNumber.list, this);
        lv_main.setAdapter(myAdapter);
    }

    private void initView() {
        lv_main = (ListView) findViewById(R.id.lv_main);
    }
}
