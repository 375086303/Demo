package com.example.list_select;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.print.PrinterId;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecycley;
    private PopupWindow popupWindow;
    private View content;
    private LinearLayout mLin;
    private int mShowMorePopupWindowWidth;
    private int mShowMorePopupWindowHeight;
    private List<SheQuData.ResultListBean.MyBean> my;
    private List<Boolean> mlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPop();
        initData();
    }
    private void initPop() {
        content = View.inflate(MainActivity.this, R.layout.layout, null);
        popupWindow = new PopupWindow(content, ViewGroup.LayoutParams.WRAP_CONTENT,  ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        content.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        mShowMorePopupWindowWidth = content.getMeasuredWidth();
        mShowMorePopupWindowHeight = content.getMeasuredHeight();
        View parent = popupWindow.getContentView();
        TextView mDianZan = (TextView) parent.findViewById(R.id.mtv_zan);
        TextView mPinglun = (TextView) parent.findViewById(R.id.mtv_pinlun);
        mDianZan.setOnClickListener(this);
        mPinglun.setOnClickListener(this);
    }
    private int a ;
    private void initData() {
        SheQuData sheQuData = new Gson().fromJson(Url.DATA, SheQuData.class);
        my = sheQuData.getResultList().getMy();
        my.addAll(my);
        my.addAll(my);
        my.addAll(my);
        for (int i = 0; i < my.size(); i++) {
            mlist.add(i,false);
        }
        final SheQuAdapter sheQuAdapter = new SheQuAdapter(R.layout.item_society_circle, my);
        mRecycley.setAdapter(sheQuAdapter);
        sheQuAdapter.setData(mlist);
        sheQuAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                for (int i = 0; i < mlist.size(); i++) {
                    if (position==i){
                        mlist.set(position,!mlist.get(position));
                    }else {
                        mlist.set(i,false);
                    }
                }
                if (mlist.get(position)){
                    int height = view.getHeight();
//                    popupWindow.setAnimationStyle(R.style.pop);
                    popupWindow.showAsDropDown(view, -mShowMorePopupWindowWidth,-(mShowMorePopupWindowHeight + height) / 2);
                }else {
                    popupWindow.dismiss();
                }
                adapter.notifyLoadMoreToLoading();

            }
        });
    }


    private void initView() {
        mRecycley = (RecyclerView) findViewById(R.id.mRecycley);
        mRecycley.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mtv_zan:
                Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mtv_pinlun:
                Toast.makeText(this, "lala", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
