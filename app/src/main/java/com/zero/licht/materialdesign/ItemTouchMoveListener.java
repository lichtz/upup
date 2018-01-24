package com.zero.licht.materialdesign;

/**
 * Created by licht on 2018/1/24.
 */

public interface ItemTouchMoveListener {
    /**
     * 当拖拽回调
     * 目的刷新
     * @param fromPostion 开始位置
     * @param toPostion 目标位置
     * @return 是否回调
     */
    boolean onItemMove(int fromPostion,int toPostion);

    /**
     * 条目被移除回调
     * @param postion
     * @return
     */
    boolean onItemRemove(int postion);
}
