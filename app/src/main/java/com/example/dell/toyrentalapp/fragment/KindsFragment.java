package com.example.dell.toyrentalapp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.toyrentalapp.R;
import com.example.dell.toyrentalapp.activity.ListActivity;

/**
 * Created by dell on 2018/3/10.
 */

public class KindsFragment extends Fragment {
    private Intent i= new Intent();
    private View view;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kinds, container, false);
      /*  GetId();//获取界面控件
        Onclick();//监听触发事件*/
//      获取界面控件
        TextView text1=(TextView)view.findViewById(R.id.age1);
        TextView text2=(TextView)view.findViewById(R.id.age2);
        TextView text3=(TextView)view.findViewById(R.id.age3);
        TextView text4=(TextView)view.findViewById(R.id.age4);
        TextView text5=(TextView)view.findViewById(R.id.age5);
        TextView text6=(TextView)view.findViewById(R.id.age6);
//        绑定点击监听事件
        text1.setOnClickListener(new mybutton());
        text2.setOnClickListener(new mybutton());
        text3.setOnClickListener(new mybutton());
        text4.setOnClickListener(new mybutton());
        text5.setOnClickListener(new mybutton());
        text6.setOnClickListener(new mybutton());

        return view;
    }
    //        监听事件方法
    private class mybutton implements View.OnClickListener {

        public void onClick(View v) {
            i.setClass(getActivity(), ListActivity.class);
            startActivity(i);
        }
    }
   /* private void Onclick() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.setClass(getActivity(), ListActivity.class);
                startActivity(i);
            }
        });
    }*/





}