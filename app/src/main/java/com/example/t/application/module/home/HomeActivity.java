package com.example.t.application.module.home;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.t.application.R;
import com.example.t.application.base.BaseActivity;
import com.example.t.application.global.MyApplication;
import com.example.t.application.module.home.fragment.CacheFragment;
import com.example.t.application.module.home.fragment.HomeFragment;
import com.example.t.application.module.home.fragment.LiveFragment;
import com.example.t.application.module.home.fragment.SearchcClassFragment;
import com.example.t.application.module.home.fragment.WoDeFragment;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/25 10:43
 * 作 者：T
 * 微信：704003376
 */
public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

 //   private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private RadioButton mRadioButton4;
    private RadioButton mRadioButton5;
    private AnimationDrawable mAnimationDrawable;
    private LinearLayout mls;

    @Override
    protected void initView() {
       // mViewPager = findViewById(R.id.viewPager);
        mls = findViewById(R.id.ls);
        mRadioGroup = findViewById(R.id.radioGroup);
        mRadioButton1 = findViewById(R.id.radioButton1);
        mRadioButton2 = findViewById(R.id.radioButton2);
        mRadioButton3 = findViewById(R.id.radioButton3);
        mRadioButton4 = findViewById(R.id.radioButton4);
        mRadioButton5 = findViewById(R.id.radioButton5);
        mRadioGroup.setOnCheckedChangeListener(this);
        MyApplication.objectVector.add(HomeActivity.this);
        startFragment(R.id.ls, new HomeFragment());
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void loadData() {
    }

    //RadioGroup点击事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //清理所有导航栏的状态
        clearState();
        switch (checkedId) {
            case R.id.radioButton1:
               mRadioButton1.setTextColor(getResources().getColor(R.color.colorPrimary));
                mAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                        R.drawable.oldvideo);
                mRadioButton1.setCompoundDrawablesWithIntrinsicBounds(null,mAnimationDrawable , null, null);
                mAnimationDrawable.start();
                MyApplication.objectVector.add(HomeActivity.this);
                startFragment(R.id.ls, new HomeFragment());
                break;
            case R.id.radioButton2:
                mRadioButton2.setTextColor(getResources().getColor(R.color.colorPrimary));
                mAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                        R.drawable.oldvideo2);
                mRadioButton2.setCompoundDrawablesWithIntrinsicBounds(null,mAnimationDrawable , null, null);
                mAnimationDrawable.start();
                MyApplication.objectVector.add(HomeActivity.this);
                startFragment(R.id.ls, new SearchcClassFragment());
                break;
            case R.id.radioButton3:
                mRadioButton3.setTextColor(getResources().getColor(R.color.colorPrimary));
                mAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                        R.drawable.oldvideo3);
                mRadioButton3.setCompoundDrawablesWithIntrinsicBounds(null,mAnimationDrawable , null, null);
                mAnimationDrawable.start();
                MyApplication.objectVector.add(HomeActivity.this);
                startFragment(R.id.ls, new LiveFragment());
                break;
            case R.id.radioButton4:
                mRadioButton4.setTextColor(getResources().getColor(R.color.colorPrimary));
                mAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                        R.drawable.oldvideo4);
                mRadioButton4.setCompoundDrawablesWithIntrinsicBounds(null,mAnimationDrawable , null, null);
                mAnimationDrawable.start();
                MyApplication.objectVector.add(HomeActivity.this);
                startFragment(R.id.ls, new CacheFragment());
                break;
            case R.id.radioButton5:
                mRadioButton5.setTextColor(getResources().getColor(R.color.colorPrimary));
                mAnimationDrawable = (AnimationDrawable) getResources().getDrawable(
                        R.drawable.oldvideo5);
                mRadioButton5.setCompoundDrawablesWithIntrinsicBounds(null,mAnimationDrawable , null, null);
                mAnimationDrawable.start();
                MyApplication.objectVector.add(HomeActivity.this);
                startFragment(R.id.ls, new WoDeFragment());
                break;
        }
    }
    //初始化底部导航栏
    private void clearState() {
        mRadioButton1.setTextColor(getResources().getColor(android.R.color.darker_gray));
        mRadioButton2.setTextColor(getResources().getColor(android.R.color.darker_gray));
        mRadioButton3.setTextColor(getResources().getColor(android.R.color.darker_gray));
        mRadioButton4.setTextColor(getResources().getColor(android.R.color.darker_gray));
        mRadioButton5.setTextColor(getResources().getColor(android.R.color.darker_gray));
      mRadioButton1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.tab_btn_01_def), null, null);
        mRadioButton2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.tab_btn_02_def), null, null);
        mRadioButton3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.tab_btn_03_def), null, null);
        mRadioButton4.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.tab_btn_04_def), null, null);
        mRadioButton5.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.tab_btn_05_def), null, null);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            clickTwoExit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean mFlag;

    private void clickTwoExit() {
        if (!mFlag) {
            mFlag = true;
            Toast.makeText(HomeActivity.this, R.string.click_two_exit_message, Toast.LENGTH_SHORT).show();
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mFlag = false;
                }
            }, 2000);

        } else {
            for (Activity activity : MyApplication.objectVector) {
                activity.finish();
            }
        }

    }


}
