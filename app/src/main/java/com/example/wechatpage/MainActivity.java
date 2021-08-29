package com.example.wechatpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager2 viewPager2;

    private LinearLayout llChat,llContacts,llDiscovery,llMe;
    private ImageView mIvChat,mIvContacts,mIvDiscovery,mIvMe,mIvCurrent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initPager();
        initTabView();
//        openContactList();
    }

  /*  private void openContactList(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,new FragmentContent());
        fragmentTransaction.commit();
    }*/

    @SuppressLint("WrongViewCast")
    private void initTabView() {
        llChat = findViewById(R.id.iv_tab_weixin);
        llContacts = findViewById(R.id.iv_tab_contact);
        llDiscovery = findViewById(R.id.iv_tab_discovery);
        llMe = findViewById(R.id.iv_tab_me);

        mIvChat = findViewById(R.id.iv_weixin);
        mIvContacts = findViewById(R.id.iv_contact);
        mIvDiscovery = findViewById(R.id.iv_discovery);
        mIvMe = findViewById(R.id.iv_me);

        llChat.setOnClickListener(this);
        llContacts.setOnClickListener(this);
        llDiscovery.setOnClickListener(this);
        llMe.setOnClickListener(this);

        mIvChat.setOnClickListener(this);
        mIvContacts.setOnClickListener(this);
        mIvDiscovery.setOnClickListener(this);
        mIvMe.setOnClickListener(this);

        mIvChat.setSelected(true);
        mIvCurrent = mIvChat;
    }

    private void initPager() {
        viewPager2 = findViewById(R.id.viewpager2);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("微信聊天"));
        fragments.add(BlankFragment.newInstance("通讯录"));
        fragments.add(BlankFragment.newInstance("发现"));
        fragments.add(BlankFragment.newInstance("我"));

        MyfragmentPagerAdapter myfragmentPagerAdapter = new MyfragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager2.setAdapter(myfragmentPagerAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTable(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void changeTable(int position) {
        mIvCurrent.setSelected(false);
        switch (position){
            case 0:
                mIvChat.setSelected(true);
                mIvCurrent = mIvChat;
                break;
            case 1:
                mIvContacts.setSelected(true);
                mIvCurrent = mIvContacts;
                break;
            case 2:
                mIvDiscovery.setSelected(true);
                mIvCurrent = mIvDiscovery;
                break;
            case 3:
                mIvMe.setSelected(true);
                mIvCurrent = mIvMe;
                break;

            case R.id.iv_weixin:
                viewPager2.setCurrentItem(0);
                break;
            case R.id.iv_contact:
                viewPager2.setCurrentItem(1);
                break;
            case R.id.iv_discovery:
                viewPager2.setCurrentItem(2);
                break;
            case R.id.iv_me:
                viewPager2.setCurrentItem(3);
                break;
            default:
        }
    }

    @Override
    public void onClick(View v) {
        changeTable(v.getId());
    }
}