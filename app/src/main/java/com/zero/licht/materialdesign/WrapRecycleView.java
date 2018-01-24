package com.zero.licht.materialdesign;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by licht on 2018/1/22.
 */

public class WrapRecycleView extends RecyclerView {
    private List<View> mHeaderVireInfos = new ArrayList<>();
    private List<View> mFooterVireInfos = new ArrayList<>();
    private Adapter mAdapter;
    public WrapRecycleView(Context context) {
        super(context);
    }

    public WrapRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public  void  addHeaderView(View v){
        mHeaderVireInfos.add(v);
      if (mAdapter !=null){
          if (!(mAdapter instanceof HeaderViewRecyclerAdapter)) {
              mAdapter = new HeaderViewRecyclerAdapter(mHeaderVireInfos,mFooterVireInfos,mAdapter);
          }

      }
    }


    @Override
    public void setAdapter(Adapter adapter) {

        if (mHeaderVireInfos.size() > 0|| mFooterVireInfos.size() > 0) {
            mAdapter = new HeaderViewRecyclerAdapter(mHeaderVireInfos, mFooterVireInfos, adapter);
        } else {
            mAdapter = adapter;
        }
        super.setAdapter(mAdapter);

    }
}
