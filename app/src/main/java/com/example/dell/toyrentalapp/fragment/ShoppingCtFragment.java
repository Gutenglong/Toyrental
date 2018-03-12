package com.example.dell.toyrentalapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dell.toyrentalapp.R;
import com.example.dell.toyrentalapp.adapter.ShoppingCtAdapter;
import com.example.dell.toyrentalapp.bassclass.FriendSCt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/3/10.
 */

public class ShoppingCtFragment extends Fragment {
    private List<FriendSCt> friends = new ArrayList<FriendSCt>();
    private static final String TAG = "LifeCycleActivity";
    private int param = 1;
    private ShoppingCtAdapter myadapter;
    private ListView lv;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        friends.clear();
        view = inflater.inflate(R.layout.fragment_shoppingct, container, false);
        findview();
        getdata();
        listview();
        return view;
    }

    private void listview() {
        myadapter=new ShoppingCtAdapter(friends,getActivity());
        lv.setAdapter(myadapter);
    }

    public void findview(){
        lv=(ListView)view.findViewById(R.id.sct);
        Log.e("find","run");
    }
    public void getdata(){
        friends.add(new FriendSCt(R.drawable.a1,"遥控汽车。。。。"));
        friends.add(new FriendSCt(R.drawable.b, "遥控飞机。。。。"));
        Log.e("getdata","run");
    }

//    //退出当前Activity或者跳转到新Activity时被调用  
//    @Override
//    public void onStop() {
//        super.onStop();
//        Log.i(TAG,"onStop called.");
//    }
//    //退出当前Activity时被调用,调用之后Activity就结束了  
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.i(TAG, "onDestory called.");
//    }
//    //表示fragment销毁相关联的UI布局
//    @Override
//    public void onDestroyView() {
//        // TODO Auto-generated method stub
//        super.onDestroyView();
//        Log.i(TAG, "--MyFragment->>onDestroyView");
//    }
//
//    //销毁fragment对象
//    @Override
//    public void onDestroy() {
//        // TODO Auto-generated method stub
//        super.onDestroy();
//        Log.i(TAG, "--MyFragment->>onDestroy");
//    }
//
//    //脱离activity
//    @Override
//    public void onDetach() {
//        // TODO Auto-generated method stub
//        super.onDetach();
//        Log.i(TAG, "--MyFragment->>onDetach");
//    }
}
