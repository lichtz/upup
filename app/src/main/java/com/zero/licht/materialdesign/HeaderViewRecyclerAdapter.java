package com.zero.licht.materialdesign;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by licht on 2018/1/22.
 */

public class HeaderViewRecyclerAdapter extends RecyclerView.Adapter {
    private   RecyclerView.Adapter mAdapter;
    private List<View> mHeaderVireInfos = new ArrayList<>();
    private List<View> mFooterVireInfos = new ArrayList<>();
    public HeaderViewRecyclerAdapter(List<View> headerVireInfos, List<View> footerVireInfos, RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
        if (mHeaderVireInfos ==null){
            mHeaderVireInfos = new ArrayList<>();
        }else {
            mHeaderVireInfos = headerVireInfos;
        }
        if (mFooterVireInfos ==null){
            mFooterVireInfos = footerVireInfos;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==-1){
             return  new HeaderViewHolder(mHeaderVireInfos.get(0));

        }else  if (viewType==-2){
            return  new HeaderViewHolder(mFooterVireInfos.get(0));
        }

        return mAdapter.onCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int numHeaders =   getHeadersCount();
        if (position <numHeaders){
            return ;
        }
        int adjPostion = position - numHeaders;
        int adapterCount =0;
        if (mAdapter !=null){
            adapterCount = mAdapter.getItemCount();
            if (adjPostion<adapterCount){
               mAdapter.onBindViewHolder(holder,adjPostion);
                return;
            }
        }


    }

    @Override
    public int getItemViewType(int position) {
       int numHeaders =   getHeadersCount();
       if (position <numHeaders){
            return -1;
       }
        int adjPostion = position - numHeaders;
        int adapterCount =0;
        if (mAdapter !=null){
             adapterCount = mAdapter.getItemCount();
             if (adjPostion<adapterCount){
             return mAdapter.getItemViewType(adjPostion);
             }
        }
        return -2;

}

    @Override
    public int getItemCount() {
        if (mAdapter != null) {
            return getFootersCount() + getHeadersCount() + mAdapter.getItemCount();
        } else {
            return getFootersCount() + getHeadersCount();
        }
    }
    public int getHeadersCount() {
        return mHeaderVireInfos.size();
    }

    public int getFootersCount() {
        return mFooterVireInfos.size();
    }


    private static class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(View itemView) {
            super(itemView);

        }
    }
}
