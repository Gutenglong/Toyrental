package com.example.dell.toyrentalapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dell.toyrentalapp.R;
import com.example.dell.toyrentalapp.adapter.ListAdapter;
import com.example.dell.toyrentalapp.bassclass.FriendList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/3/12.
 */

public class ListActivity extends Activity {
    public List<FriendList>friends=new ArrayList<FriendList>();
    private ListAdapter myadapter;
    private ListView list_l;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list);
        findId();
        getdata();
        listview();
        onclick();

    }
//    设定adapter
    private void listview() {
        myadapter=new ListAdapter(friends,this);
        list_l.setAdapter(myadapter);
    }
//获取数据
    private void getdata() {
        friends.add(new FriendList(R.drawable.a1,"abc..."));
        friends.add(new FriendList(R.drawable.boy,"bcd..."));
    }
//获取listview控件
    private void findId() {
        list_l=(ListView)findViewById(R.id.list_l);
    }
    // listview  item 相应点击事件
    private void onclick (){
        list_l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(ListActivity.this,GoodsActivity.class);
                startActivity(intent);
            }
        });
    }


}

