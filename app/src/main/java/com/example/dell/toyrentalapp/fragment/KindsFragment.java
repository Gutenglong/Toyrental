package com.example.dell.toyrentalapp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dell.toyrentalapp.R;
import com.example.dell.toyrentalapp.activity.ListActivity;

/**
 * Created by dell on 2018/3/10.
 */

public class KindsFragment extends Fragment {
    private Intent i= new Intent();
    private View view;
    private LinearLayout butten1;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kinds, container, false);
        GetId();//获取界面控件
        Onclick();//监听触发事件
        return view;
    }

    private void Onclick() {
        butten1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.setClass(getActivity(), ListActivity.class);
                startActivity(i);
            }
        });
    }

    private void GetId() {
        butten1=(LinearLayout)view.findViewById(R.id.age1);
    }

}