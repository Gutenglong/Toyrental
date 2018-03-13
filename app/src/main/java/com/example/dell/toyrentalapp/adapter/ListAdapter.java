package com.example.dell.toyrentalapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.toyrentalapp.R;
import com.example.dell.toyrentalapp.bassclass.FriendList;

import java.util.List;

/**
 * Created by dell on 2018/3/13.
 */

public class ListAdapter extends BaseAdapter {
    private List<FriendList> friends;
    private Context c;
    private ImageView image;
    private TextView tails;

    public ListAdapter(List<FriendList> friends, Context c) {
        this.friends = friends;
        this.c = c;
    }


    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null == convertView) {
            convertView= LayoutInflater.from(c).inflate(R.layout.array_item_sct,null);
        }
        image = (ImageView)convertView.findViewById(R.id.imag);
        image.setImageResource(friends.get(position).getImage());
        tails = (TextView)convertView.findViewById(R.id.tails);
        tails.setText(friends.get(position).getTails().toString());
        return convertView;
    }
}
