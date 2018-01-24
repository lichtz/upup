package com.zero.licht.materialdesign;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

/**
 * Created by licht on 2018/1/24.
 */

public class WithItemTouchHelper extends ItemTouchHelper.Callback {
    private ItemTouchMoveListener itemTouchMoveListener;

    public WithItemTouchHelper(ItemTouchMoveListener itemTouchMoveListener) {
        this.itemTouchMoveListener = itemTouchMoveListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //上下拖拽
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int i = makeMovementFlags(dragFlags, swipeFlags);
        return i;
    }


    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
         if (itemTouchMoveListener !=null){
             itemTouchMoveListener.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
         }
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //监听侧滑，1.删除数据 2.调用adapter.notifyItemRemove(postion)
        Log.i("zyl",direction+"PPPP");
          itemTouchMoveListener.onItemRemove(viewHolder.getAdapterPosition());
    }

    /**
     * 是否允许长按
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
         //闲置状态  ItemTouchHelper.ACTION_STATE_IDLE
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE){
             viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.colorAccent));

         }
        super.onSelectedChanged(viewHolder, actionState);

    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //恢复选中状态
        viewHolder.itemView.setBackgroundColor(Color.WHITE) ;

        super.clearView(recyclerView, viewHolder);
    }

     //侧滑动效
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView,
                            RecyclerView.ViewHolder viewHolder,
                            float dX, float dY, int actionState, boolean isCurrentlyActive) {
         if (actionState== ItemTouchHelper.ACTION_STATE_SWIPE){
             float v = 1 - Math.abs(dX) / viewHolder.itemView.getWidth();
             viewHolder.itemView.setAlpha(v);
             viewHolder.itemView.setScaleX(v);
             viewHolder.itemView.setScaleY(v);
         }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

    }
}
