package com.example.dell.toyrentalapp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.dell.toyrentalapp.R;
import com.example.dell.toyrentalapp.activity.GoodsActivity;
import com.example.dell.toyrentalapp.adapter.HomeAdapter;
import com.example.dell.toyrentalapp.bassclass.FriendHome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/3/10.
 */

public class HomeFragment extends Fragment {
    private View view;
    private ViewFlipper flipper;
//    private Intent i = new Intent();
    private int[] resId;

    private List<FriendHome> friendHomes =new ArrayList<FriendHome>();
    private ListView listh;
    private HomeAdapter myadapter;
    private ImageView img1;
    private ImageView img2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        friendHomes.clear();
        view = inflater.inflate(R.layout.fragment_home, container, false);
        /**获取控件*/
        GetId();
        /**获取数据*/
        getdata();
        /**滚动图*/
        Flipper();
        /**显示列表*/
        listview();
//        homeclick();
        return view;
    }

    private void listview() {
        myadapter = new HomeAdapter(friendHomes,getActivity());
        listh.setAdapter(myadapter);
    }

    private void getdata() {
        resId= new int[]{R.drawable.b, R.drawable.a1, R.drawable.sct3};
        friendHomes.add(new FriendHome(R.drawable.a1,R.drawable.boy));
        friendHomes.add(new FriendHome(R.drawable.my1,R.drawable.girl));
    }

    /**
     * 获取控件
     */
    private void GetId() {
        flipper = (ViewFlipper)view.findViewById(R.id.flipper);
        listh=(ListView)view.findViewById(R.id.listh);
        img1=(ImageView)view.findViewById(R.id.imag1);
         img2=(ImageView)view.findViewById(R.id.imag2);

    }

    /**
     * 滚动图
     */
    private void Flipper() {
        /**
         * 动态导入的方式为ViewFlipper加入子View
         */
        for (int i=0;i<resId.length;i++){
            flipper.addView(getImageView(i));
        }
        flipper.setInAnimation(getActivity(),R.anim.left_in);
        flipper.setOutAnimation(getActivity(),R.anim.left_out);
        flipper.setFlipInterval(3000);
        flipper.startFlipping();
    }

    private ImageView getImageView(int i) {
        ImageView image = new ImageView(getActivity());
        image.setBackgroundResource(resId[i]);
        return image;
    }

    private void homeclick(){
        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),GoodsActivity.class);
                startActivity(intent);
            }
        });
    }

}