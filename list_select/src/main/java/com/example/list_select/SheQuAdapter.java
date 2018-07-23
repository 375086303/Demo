package com.example.list_select;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class SheQuAdapter extends BaseQuickAdapter<SheQuData.ResultListBean.MyBean,BaseViewHolder> {

    public static List<Boolean> mList;

    public SheQuAdapter(int layoutResId, @Nullable List<SheQuData.ResultListBean.MyBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SheQuData.ResultListBean.MyBean item) {
        helper.setText(R.id.society_circle_title,item.getName());
        Glide.with(mContext).load(item.getIcon()).into((ImageView) helper.getView(R.id.society_circle_img));
        helper.addOnClickListener(R.id.imagee);
        final CheckBox view = helper.getView(R.id.imagee);
        final int layoutPosition = helper.getLayoutPosition();
        view.setChecked(mList.get(layoutPosition));
    }
    public static void setData(List<Boolean> mList){
        SheQuAdapter.mList = mList;
    }
}
