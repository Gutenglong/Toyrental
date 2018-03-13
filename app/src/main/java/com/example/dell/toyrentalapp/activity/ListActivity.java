package com.example.dell.toyrentalapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
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
    private ListView lsit_l;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list);
        findId();
        getdata();
        listview();
    }

    private void listview() {
        myadapter=new ListAdapter(friends,this);
        lsit_l.setAdapter(myadapter);
    }

    private void getdata() {
        friends.add(new FriendList(R.drawable.a1,"abc..."));
        friends.add(new FriendList(R.drawable.boy,"bcd..."));
    }

    private void findId() {
        lsit_l=(ListView)findViewById(R.id.list_l2);
    }
}
