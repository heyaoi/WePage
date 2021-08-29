package com.example.wechatpage;

import java.util.ArrayList;

public class DataManager {
    ArrayList<JavaBean> mcontactlist = null;

    public ArrayList<JavaBean> getContactList() {
        if (mcontactlist == null) {
            mcontactlist = new ArrayList<>();

            for (int i = 0; i < 2000; i++) {
                mcontactlist.add(new JavaBean("张三    " + i, "123456789"));
            }
        }

        return mcontactlist;
    }
}
