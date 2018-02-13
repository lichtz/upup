package com.zero.licht.materialdesign;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements StartDragListener{
    private static final String TAG = "MainActivity";
    private ItemTouchHelper itemTouchHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);

        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        QQAdapter qqAdapter = new QQAdapter(this);
        recyclerView.setAdapter(qqAdapter);
        //上下拖拽
/**
 * 是否允许长按
 * @return
 */itemTouchHelper = new ItemTouchHelper(new WithItemTouchHelper(qqAdapter));

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

     public  void  onStartDrag(RecyclerView.ViewHolder viewHolder){
        if (itemTouchHelper !=null){
            itemTouchHelper.startDrag(viewHolder);
        }
    }

}
