package com.example.dell.toyrentalapp.fragment;

import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dell.toyrentalapp.R;

/**
 * Created by dell on 2018/3/10.
 */

public class KindsFragment extends Fragment {
    private View view;
    private LinearLayout butten;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kinds, container, false);
        butten=(LinearLayout)view.findViewById(R.id.age1);
        butten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i=new Intent(getActivity(), ListActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}