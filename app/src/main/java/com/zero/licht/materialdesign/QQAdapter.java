package com.zero.licht.materialdesign;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;

/**
 * Created by licht on 2018/1/23.
 */

public class QQAdapter extends RecyclerView.Adapter implements  ItemTouchMoveListener{
    private StartDragListener mStartDragListener;
    public QQAdapter(StartDragListener startDragListener) {
        mStartDragListener = startDragListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
            MyViewHolder  myViewHolder = (MyViewHolder) holder;
            myViewHolder.textView.setText(position+"PPOPODPOPDOPDPDO");
            myViewHolder.logo.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        //传递触摸给
                         mStartDragListener.onStartDrag(holder);
                    }
                    return  false;
                }
            });
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    @Override
    public boolean onItemMove(int fromPostion, int toPostion) {
        //数据交换  刷新
//        Collections.swap(list,fromPostion,toPostion);

        notifyItemMoved(fromPostion,toPostion);
        return false;
    }

    @Override
    public boolean onItemRemove(int postion) {
//        list.remove(postion);
//        notifyItemRemoved(postion);
        Log.i("zyl","WWWWWWWWWWWW22222");
        return false;
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView logo;
        private final TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.q);
            textView = itemView.findViewById(R.id.t);


        }
    }
}
