package com.example.j32u4ukh.androidlearning;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseFragment extends Fragment {
    private int indicatorColor = Color.BLUE;
    private int dividerColor = Color.GRAY;
    private String title = "";
    private static final String DATA_NAME = "name";

    public static BaseFragment newInstance(String title) {
        BaseFragment fragment = new BaseFragment();
        fragment.setTitle(title);

        //pass data
        Bundle args = new Bundle();
        args.putString(DATA_NAME, title);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get data：DATA_NAME當作KEY，取得後面的VALUE
        title = getArguments().getString(DATA_NAME);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_common, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        txtName.setText(title);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getIndicatorColor() {
        return indicatorColor;
    }
    public void setIndicatorColor(int indicatorColor) {
        this.indicatorColor = indicatorColor;
    }
    public int getDividerColor() {
        return dividerColor;
    }
    public void setDividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
    }
}
