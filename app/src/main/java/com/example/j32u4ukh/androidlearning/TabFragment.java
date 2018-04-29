package com.example.j32u4ukh.androidlearning;

import java.util.LinkedList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        SlidingTabLayout tabs;
        ViewPager pager;
        FragmentPagerAdapter adapter;

        //adapter
        final LinkedList<BaseFragment> fragments = getFragments();
        adapter = new TabFragmentPagerAdapter(getFragmentManager(), fragments);
        //pager
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(adapter);
        //tabs 標籤
        tabs = (SlidingTabLayout) view.findViewById(R.id.tabs);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return fragments.get(position).getIndicatorColor();
            }

            @Override
            public int getDividerColor(int position) {
                return fragments.get(position).getDividerColor();
            }
        });

        // 設定標籤顏色
        tabs.setBackgroundResource(R.color.colorPrimary);
        tabs.setViewPager(pager);
    }

    // 產生滑動頁面&內容
    private LinkedList<BaseFragment> getFragments(){
        LinkedList<BaseFragment> fragments = new LinkedList<BaseFragment>();
        for(int page = 1; page <= 10; page++){
            fragments.add(BaseFragment.newInstance("Page" + String.valueOf(page)));
        }
        return fragments;
    }
}
