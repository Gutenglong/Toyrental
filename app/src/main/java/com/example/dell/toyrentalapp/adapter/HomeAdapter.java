package com.example.dell.toyrentalapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.dell.toyrentalapp.R;
import com.example.dell.toyrentalapp.activity.GoodsActivity;
import com.example.dell.toyrentalapp.activity.ListActivity;
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
        ImageView image1 = null;
        ImageView image2 = null;
        if (null == view) {
            view = LayoutInflater.from(c).inflate(R.layout.array_item_home, null);
            image1 = (ImageView) view.findViewById(R.id.imag1);
            image2 = (ImageView) view.findViewById(R.id.imag2);
            ViewHolder holder = new ViewHolder(image1, image2);
            view.setTag(holder);
        } else {
            image1 = ((ViewHolder)view.getTag()).img1;
            image2 = ((ViewHolder)view.getTag()).img2;
        }

        image1.setImageResource(friendHoms.get(i).getImage1());
        image2.setImageResource(friendHoms.get(i).getImage2());
        homeclick(image1,image2);
        return view;
    }

    private class ViewHolder {
        public ImageView img1;
        public ImageView img2;

        public ViewHolder(ImageView img1, ImageView img2) {
            this.img1 = img1;
            this.img2 = img2;
        }

    }
    private void homeclick(ImageView img1,ImageView img2){
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(c,ListActivity.class);
                ((Activity)c).startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(c,GoodsActivity.class);
                ((Activity)c).startActivity(intent);
            }
        });
    }



}
