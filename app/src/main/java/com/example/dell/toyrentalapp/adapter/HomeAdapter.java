package com.example.dell.toyrentalapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.dell.toyrentalapp.R;
import com.example.dell.toyrentalapp.bassclass.FriendHome;

import java.util.List;

/**
 * Created by dell on 2018/3/12.
 */

public class HomeAdapter extends BaseAdapter {
    public List<FriendHome> friendHoms;
    public Context c;
    public ImageView image1;
    public ImageView image2;
    public HomeAdapter(List<FriendHome> friendHomes,Context c){
        this.friendHoms=friendHomes;
        this.c=c;
    }

    @Override
    public int getCount() {
        return friendHoms.size();
    }

    @Override
    public Object getItem(int i) {
        return friendHoms.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(null==view){
            view = LayoutInflater.from(c).inflate(R.layout.array_item_home,null);
        }
        image1 = (ImageView)view.findViewById(R.id.imag1);
        image2 = (ImageView)view.findViewById(R.id.imag2);
        image1.setImageResource(friendHoms.get(i).getImage1());
        image2.setImageResource(friendHoms.get(i).getImage2());
        return view;
    }
}
