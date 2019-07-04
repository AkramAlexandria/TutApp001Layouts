package com.example.tutapp01layouts;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdaptor extends FragmentPagerAdapter {


    public PagerAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment01 fragment01=new Fragment01();
                return fragment01;

            case 1:
                Fragment02 fragment02=new Fragment02();
                return fragment02;

            case 2:
                Fragment03 fragment03=new Fragment03();
                return fragment03;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
