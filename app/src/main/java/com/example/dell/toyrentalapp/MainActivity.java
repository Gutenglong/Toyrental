package com.example.dell.toyrentalapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.dell.toyrentalapp.fragment.HomeFragment;
import com.example.dell.toyrentalapp.fragment.KindsFragment;
import com.example.dell.toyrentalapp.fragment.MyFragment;
import com.example.dell.toyrentalapp.fragment.ShoppingCtFragment;


public class MainActivity extends Activity {

    public static LinearLayout ll;
    private static final String TAG = "LifeCycleActivity";
    private int param = 1;

    //声明Fragment属性
    private HomeFragment mHome;
    private KindsFragment mKinds;
    private ShoppingCtFragment mSct;
    private MyFragment mMy;

    private LinearLayout liner_home;
    private LinearLayout liner_kinds;
    private LinearLayout liner_sct;
//    private LinearLayout liner_attractions;
    private LinearLayout liner_my;

    private ImageButton image_home;
    private ImageButton image_kinds;
    private ImageButton image_sct;
//    private ImageButton image_attractions;
    private ImageButton image_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //获取界面控件
        getViews();
        //注册事件监听器
        setListener();
        //设置默认页面
        setDefaultPage();
    }

    private void setListener() {
        MyListener mylistener = new MyListener();
        liner_home.setOnClickListener(mylistener);
        liner_kinds.setOnClickListener(mylistener);
        liner_sct.setOnClickListener(mylistener);
//        liner_attractions.setOnClickListener(mylistener);
        liner_my.setOnClickListener(mylistener);
    }
    //she值事件监听器

    //
    private void setDefaultPage() {
        android.app.FragmentManager fm = getFragmentManager();
        //获取fragmentTranSaction
        android.app.FragmentTransaction transaction = fm.beginTransaction();
        //默认页面
        mHome = new HomeFragment();
        transaction.replace(R.id.contaner, mHome);
        ResetTabsImg();
        SetTabsSelectedImg(0);
        //执行更改
        transaction.commit();
    }

    //获取控件
    private void getViews() {
        ll = (LinearLayout) findViewById(R.id.ll);
        liner_home = (LinearLayout) findViewById(R.id.liner_home);
        liner_kinds = (LinearLayout) findViewById(R.id.liner_kinds);
        liner_sct = (LinearLayout) findViewById(R.id.liner_sct);
//        liner_attractions = (LinearLayout) findViewById(R.id.liner_attractions);
        liner_my = (LinearLayout) findViewById(R.id.liner_my);

        image_home = (ImageButton) findViewById(R.id.image_home);
        image_kinds = (ImageButton) findViewById(R.id.image_kinds);
        image_sct = (ImageButton) findViewById(R.id.image_sct);
//        image_attractions = (ImageButton) findViewById(R.id.image_attractions);
        image_my = (ImageButton) findViewById(R.id.image_my);

    }


    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction transaction = fm.beginTransaction();
            switch (v.getId()) {
                case R.id.liner_home:
                    if (mHome == null) {
                        mHome = new HomeFragment();
                    }
                    transaction.replace(R.id.contaner, mHome);
                    ResetTabsImg();
                    SetTabsSelectedImg(0);
                    break;
                case R.id.liner_kinds:
                    if (mKinds == null) {
                        mKinds = new KindsFragment();
                    }
                    transaction.replace(R.id.contaner, mKinds);
                    ResetTabsImg();
                    SetTabsSelectedImg(1);
                    break;
                case R.id.liner_sct:
                    if (mSct == null) {
                        mSct = new ShoppingCtFragment();
                    }
                    transaction.replace(R.id.contaner, mSct);
                    ResetTabsImg();
                    SetTabsSelectedImg(2);
                    break;
//                case R.id.liner_attractions:
//                    if (mAtt == null) {
//                        mAtt = new AttFragment();
//                    }
//                    transaction.replace(R.id.contaner, mAtt);
//                    ResetTabsImg();
//                    SetTabsSelectedImg(3);
//                    break;
                case R.id.liner_my:
                    if (mMy == null) {
                        mMy = new MyFragment();
                    }
                    transaction.replace(R.id.contaner, mMy);
                    ResetTabsImg();
                    SetTabsSelectedImg(4);
                    break;
            }
            transaction.commit();
            ll.invalidate();
        }
    }


    private void ResetTabsImg() {
        image_home.setImageResource(R.drawable.home1);
        image_kinds.setImageResource(R.drawable.kind1);
        image_sct.setImageResource(R.drawable.sct3);
//        image_attractions.setImageResource(R.drawable.jing1);
        image_my.setImageResource(R.drawable.my1);
    }

    private void SetTabsSelectedImg(int i) {
        switch (i) {
            case 0:
                image_home.setImageResource(R.drawable.home2);
                break;
            case 1:
                image_kinds.setImageResource(R.drawable.kind2);
                break;
            case 2:
                image_sct.setImageResource(R.drawable.sct1);
                break;
//            case 3:
////                image_attractions.setImageResource(R.drawable.jing2);
//                break;
            case 4:
                image_my.setImageResource(R.drawable.my2);
                break;
        }
    }
    //Activity创建或者从后台重新回到前台时被调用 
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart called.");
    }
    //Activity从后台重新回到前台时被调用  
    @Override
    public void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart called.");
    }
    //Activity创建或者从被覆盖、后台重新回到前台时被调用 
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume called.");
    }
    //Activity被覆盖到下面或者锁屏时被调用  
    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG,"onPause called.");//有可能在执行完onPause或onStop后,系统资源紧张将Activity杀死,所以有必要在此保存持久数据  
    }
    //退出当前Activity或者跳转到新Activity时被调用  
    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"onStop called.");
    }
    //退出当前Activity时被调用,调用之后Activity就结束了  
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestory called.");
    }
    /** 
          * Activity被系统杀死时被调用. 
          * 例如:屏幕方向改变时,Activity被销毁再重建;当前Activity处于后台,系统资源紧张将其杀死. 
          * 另外,当跳转到其他Activity或者按Home键回到主屏时该方法也会被调用,系统是为了保存当前View组件的状态. 
          * 在onPause之前被调用. 
          */
    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putInt("param",param);
        Log.i(TAG,"onSaveInstanceState called. put param: "+param);
        super.onSaveInstanceState(outState);
    }
    /** 
          * Activity被系统杀死后再重建时被调用. 
          * 例如:屏幕方向改变时,Activity被销毁再重建;当前Activity处于后台,系统资源紧张将其杀死,用户又启动该Activity. 
          * 这两种情况下onRestoreInstanceState都会被调用,在onStart之后. 
          */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        param = savedInstanceState.getInt("param");
        Log.i(TAG,"onRestoreInstanceState called. get param: "+param);
        super.onRestoreInstanceState(savedInstanceState);
    }

}


//package com.example.dell.toyrentalapp;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
