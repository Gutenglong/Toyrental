//package com.example.dell.toyrentalapp.activity;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.dell.toyrentalapp.MainActivity;
//
//import org.json.JSONObject;
//
////import com.example.nianchen.normaluniversitytourgroup.page_activity.RegistActivity;
////import com.hyphenate.EMCallBack;
////import com.hyphenate.EMContactListener;
////import com.hyphenate.EMError;
////import com.hyphenate.chat.EMClient;
////import com.loopj.android.http.AsyncHttpClient;
////import com.loopj.android.http.AsyncHttpResponseHandler;
////import com.loopj.android.http.JsonHttpResponseHandler;
////import com.loopj.android.http.RequestParams;
////import com.loopj.android.http.ResponseHandlerInterface;
////
////import org.apache.http.Header;
//
//public class LoginActivity extends AppCompatActivity {
//    private Button Btlogin;
//    private EditText EtUname;
//    private EditText EtPwd;
//    private Button Btnregist;
//    private String loginuri="http://123.207.228.232/blog/loginuser";
//    private Handler myhandler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if(loginresult.equals("loginok")){
//
//            }
//            else {
//                Toast.makeText(LoginActivity.this, "登入失败",Toast.LENGTH_LONG).show();
//            }
//            if(msg.what==10){
//                Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(i);
//                LoginActivity.this.finish();
//            }
//        }
//    };
//    private String name;
//    private String password;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        Log.e("log","onCreate");
//        findView();
//        setListener();
//    }
//
//    private void findView() {
//        Btlogin = (Button)findViewById(R.id.btlogin);
//        EtUname = (EditText) findViewById(R.id.Etu);
//        EtPwd = (EditText) findViewById(R.id.Pw);
//        Btnregist=(Button)findViewById(R.id.regist);
//    }
//
//    private String loginresult;
//    private JSONObject result;
//    private ProgressDialog mDialog;
//    View.OnClickListener mylistener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.btlogin:
//                    mDialog = new ProgressDialog(LoginActivity.this);
//                    mDialog.setMessage("正在登陆，请稍后...");
//                    mDialog.show();
//                    login();
//                    loginhx();
//                    SharedPreferences spf=getSharedPreferences("User",MODE_PRIVATE);
//                    SharedPreferences.Editor editor=spf.edit();
//                    editor.putString("uname",EtUname.getText().toString());
//                    editor.clear();
//                    editor.commit();
//                    break;
//                case R.id.regist:
//                    Intent ina=new Intent(LoginActivity.this, RegistActivity.class);
//                    startActivity(ina);
//                    break;
//            }
//        }
//    };
//    private void setListener() {
//        Btlogin.setOnClickListener(mylistener);
//        Btnregist.setOnClickListener(mylistener);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.e("log","onStop");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.e("log","onDestroy");
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.e("log","onStart");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.e("log","onResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.e("log","onPause");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.e("log","onRestart");
//    }
//    public void login(){
//        name=EtUname.getText().toString();
//        password=EtPwd.getText().toString();
//        AsyncHttpClient client=new AsyncHttpClient();
//        RequestParams params=new RequestParams();
//        params.put("username",name);
//        params.put("password",password);
//        client.post(loginuri, params, new AsyncHttpResponseHandler() {
//                    @Override
//                    public void onSuccess(int i, Header[] headers, byte[] bytes) {
//                        byte [] mybytes=bytes;
//                        loginresult=new String (mybytes);
//                        Message msg=new Message();
//                        myhandler.sendMessage(msg);
//                        Log.e(loginresult,"this is");
//
//                    }
//                    @Override
//                    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
//                        Toast.makeText(LoginActivity.this,"您的网络有异常",Toast.LENGTH_LONG).show();
//                    }
//                }
//
//
//        );
//    }
//    public void loginhx(){
//        EMClient.getInstance().login(name, password, new EMCallBack() {
//            @Override
//            public void onSuccess() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mDialog.dismiss();
//                        // 加载所有会话到内存
//                        EMClient.getInstance().chatManager().loadAllConversations();
//                        Message msg=new Message();
//                        msg.what=10;
//                        myhandler.sendMessage(msg);
//                    }
//                });
//            }
//
//
//            @Override
//            public void onError(final int i, final String s) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        mDialog.dismiss();
//                        Log.d("lzan13", "登录失败 Error code:" + i + ", message:" + s);
//                        /**
//                         * 关于错误码可以参考官方api详细说明
//                         * http://www.easemob.com/apidoc/android/chat3.0/classcom_1_1hyphenate_1_1_e_m_error.html
//                         */
//                        switch (i) {
//                            // 网络异常 2
//                            case EMError.NETWORK_ERROR:
//                                Toast.makeText(LoginActivity.this, "网络错误 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                            // 无效的用户名 101
//                            case EMError.INVALID_USER_NAME:
//                                Toast.makeText(LoginActivity.this, "无效的用户名 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                            // 无效的密码 102
//                            case EMError.INVALID_PASSWORD:
//                                Toast.makeText(LoginActivity.this, "无效的密码 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                            // 用户认证失败，用户名或密码错误 202
//                            case EMError.USER_AUTHENTICATION_FAILED:
//                                Toast.makeText(LoginActivity.this, "用户认证失败，用户名或密码错误 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                            // 用户不存在 204
//                            case EMError.USER_NOT_FOUND:
//                                Toast.makeText(LoginActivity.this, "用户不存在 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                            // 无法访问到服务器 300
//                            case EMError.SERVER_NOT_REACHABLE:
//                                Toast.makeText(LoginActivity.this, "无法访问到服务器 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                            // 等待服务器响应超时 301
//                            case EMError.SERVER_TIMEOUT:
//                                Toast.makeText(LoginActivity.this, "等待服务器响应超时 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                            // 服务器繁忙 302
//                            case EMError.SERVER_BUSY:
//                                Toast.makeText(LoginActivity.this, "服务器繁忙 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                            // 未知 Server 异常 303 一般断网会出现这个错误
//                            case EMError.SERVER_UNKNOWN_ERROR:
//                                Toast.makeText(LoginActivity.this, "未知的服务器异常 code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                            default:
//                                Toast.makeText(LoginActivity.this, "ml_sign_in_failed code: " + i + ", message:" + s, Toast.LENGTH_LONG).show();
//                                break;
//                        }
//                    }
//                });
//            }
//
//            @Override
//            public void onProgress(int i, String s) {
//
//            }
//        });
//    }
//
//
//}
