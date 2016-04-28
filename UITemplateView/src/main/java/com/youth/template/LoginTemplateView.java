package com.youth.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginTemplateView extends FrameLayout {
    private Context context;
    private RelativeLayout loginTemplate;
    private ImageView loginLogo;
    private EditText username;
    private EditText pwd;
    private Button btnLogin;
    private TextView forgotPwd;
    private LoginListener loginListener;
    private ForgotListener forgotListener;
    public LoginTemplateView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public LoginTemplateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public LoginTemplateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    public void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.login_template_view, this, true);
        loginTemplate = (RelativeLayout) view.findViewById(R.id.login_template);
        loginLogo = (ImageView) view.findViewById(R.id.login_logo);
        username = (EditText) view.findViewById(R.id.login_username);
        pwd = (EditText) view.findViewById(R.id.login_pwd);
        btnLogin = (Button) view.findViewById(R.id.login_btn);
        forgotPwd = (TextView) view.findViewById(R.id.login_forgot);
        login();
        forgot();
    }

    public void setLoginLogo(@DrawableRes int resId){
        loginLogo.setImageResource(resId);
    }
    public void setLoginLogoVisibility(int visibility){
        loginLogo.setVisibility(visibility);
    }
    public void setLoginLogoBackgroundResource(@DrawableRes int resId){
        loginLogo.setBackgroundResource(resId);
    }
    public void setLoginLogoBackgroundColor(@ColorInt int color){
        loginLogo.setBackgroundColor(color);
    }
    public void setUsernameIcon(@DrawableRes int resId){
        Drawable drawable= getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        username.setCompoundDrawables(drawable,null,null,null);
    }
    public void setUsernameHint(String text){
        username.setHint(text);
    }
    public void setUsernameBackground(@DrawableRes int resId){
        username.setBackgroundResource(resId);
    }
    public void setPwdIcon(@DrawableRes int resId){
        Drawable drawable= getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        pwd.setCompoundDrawables(drawable,null,null,null);
    }
    public void setPwdHint(String text){
        pwd.setHint(text);
    }
    public void setPwdBackground(@DrawableRes int resId){
        pwd.setBackgroundResource(resId);
    }
    public void setLgoinButtonBackground(@DrawableRes int resId){
        btnLogin.setBackgroundResource(resId);
    }
    public void setLgoinButtonText(String text){
        btnLogin.setText(text);
    }
    public void setLgoinButtonTextColor(@ColorInt int color){
        btnLogin.setTextColor(color);
    }
    public void setForgotButtonText(String text){
        forgotPwd.setText(text);
    }
    public void setForgotButtonTextColor(@ColorInt int color){
        forgotPwd.setTextColor(color);
    }
    public String getUsername(){
        return username.getText().toString();
    }
    public String getPwd(){
        return pwd.getText().toString();
    }
    public void login(){
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginListener!=null){
                    loginListener.login(v);
                }
            }
        });
    }
    public void forgot(){
        forgotPwd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(forgotListener!=null){
                    forgotListener.forgot(v);
                }
            }
        });
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public void setForgotListener(ForgotListener forgotListener) {
        this.forgotListener = forgotListener;
    }

    public interface LoginListener {
        void login(View v);
    }

    public interface ForgotListener {
        void forgot(View v);
    }
}