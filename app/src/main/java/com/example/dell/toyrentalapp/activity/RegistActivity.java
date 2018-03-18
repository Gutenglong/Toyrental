package com.example.dell.toyrentalapp.activity;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.toyrentalapp.R;

//import com.example.dell.toyrentalapp.LoginActivity;

/**
 * Created by zhangzhixin on 2016/11/29.
 */
public class RegistActivity extends Activity {
    private EditText username;
    private EditText password;
    private Button regist;
    private Button gologin;
    private Boolean bl=false;
    private String registuri="http://123.207.228.232/blog/registuser";
    private String result;
    private Handler myhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(result.equals("ok")){;
                mDialog.dismiss();
                Toast.makeText(RegistActivity.this,"注册成功!",Toast.LENGTH_LONG).show();
            }
            else if(result.equals("false")){
                mDialog.dismiss();
                Toast.makeText(RegistActivity.this,"用户已存在",Toast.LENGTH_LONG).show();
            }
        }
    };
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        findview();
        setlisenter();
    }
    public void findview(){
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        regist=(Button)findViewById(R.id.regist);
        gologin=(Button)findViewById(R.id.gologin);
    }
    public void setlisenter(){
        regist.setOnClickListener(mylistener);
        gologin.setOnClickListener(mylistener);
    }

    private String Name_str;
    private String Pwd_str;
    View.OnClickListener mylistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.regist:
//                    regist();
                    break;
                case R.id.gologin:
                    Intent ina=new Intent(RegistActivity.this, LoginsActivity.class);
                    startActivity(ina);
                    RegistActivity.this.finish();
                    break;
            }
        }
    };
//    public void regist(){
//        Log.e("regist","run");
//        mDialog = new ProgressDialog(RegistActivity.this);
//        mDialog.setMessage("注册中，请稍后...");
//        mDialog.show();
//        AsyncHttpClient client=new AsyncHttpClient();
//        RequestParams params =new RequestParams();
//        params.put("username",username.getText().toString());
//        params.put("password",password.getText().toString());
//        client.get(registuri, params, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int i, Header[] headers, byte[] bytes) {
//                byte [] mybyte=bytes;
//                result=new String (mybyte);
//                Message msg=new Message();
//                myhandler.sendMessage(msg);
//                Thread th=new Thread(){
//                    @Override
//                    public void run() {
//                        super.run();
//                        try {
//                            EMClient.getInstance().createAccount(username.getText().toString(),password.getText().toString());
//                        } catch (final HyphenateException e) {
//                            e.printStackTrace();
//
//                            Log.e("hx","catch");
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//
//                                    /**
//                                     * 关于错误码可以参考官方api详细说明
//                                     * http://www.easemob.com/apidoc/android/chat3.0/classcom_1_1hyphenate_1_1_e_m_error.html
//                                     */
//                                    int errorCode = e.getErrorCode();
//                                    String message = e.getMessage();
//                                    Log.d("lzan13", String.format("sign up - errorCode:%d, errorMsg:%s", errorCode, e.getMessage()));
//                                    switch (errorCode) {
//                                        // 网络错误
//                                        case EMError.NETWORK_ERROR:
//                                            Toast.makeText(RegistActivity.this, "网络错误 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
//                                            break;
//                                        // 用户已存在
//                                        case EMError.USER_ALREADY_EXIST:
//                                            Toast.makeText(RegistActivity.this, "用户已存在 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
//                                            break;
//                                        // 参数不合法，一般情况是username 使用了uuid导致，不能使用uuid注册
//                                        case EMError.USER_ILLEGAL_ARGUMENT:
//                                            Toast.makeText(RegistActivity.this, "参数不合法，一般情况是username 使用了uuid导致，不能使用uuid注册 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
//                                            break;
//                                        // 服务器未知错误
//                                        case EMError.SERVER_UNKNOWN_ERROR:
//                                            Toast.makeText(RegistActivity.this, "服务器未知错误 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
//                                            break;
//                                        case EMError.USER_REG_FAILED:
//                                            Toast.makeText(RegistActivity.this, "账户注册失败 code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
//                                            break;
//                                        default:
//                                            Toast.makeText(RegistActivity.this, "ml_sign_up_failed code: " + errorCode + ", message:" + message, Toast.LENGTH_LONG).show();
//                                            break;
//                                    }
//                                }
//                            });
//                        }
//                    }
//                };
//                th.start();
//            }
//            @Override
//            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
//                Toast.makeText(RegistActivity.this,"您的网络有异常",Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }


}

