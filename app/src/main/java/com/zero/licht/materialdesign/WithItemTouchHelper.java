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
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN|ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
//        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int i = makeMovementFlags(dragFlags, 0);
        return i;
    }


    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
         if (itemTouchMoveListener !=null){
             itemTouchMoveListener.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
         }
        return true;
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
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }


}
