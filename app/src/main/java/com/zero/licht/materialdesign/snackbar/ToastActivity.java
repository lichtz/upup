package com.zero.licht.materialdesign.snackbar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zero.licht.materialdesign.R;

public class ToastActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//         showToast("ddddd");


    }

    private void showToast(String s) {
        Toast toast = new Toast(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.toast_view,null);
        TextView textView = inflate.findViewById(R.id.tv);
         textView.setText(s);
         toast.setGravity(Gravity.CENTER,0,0);
         toast.setDuration(12000);
         toast.setView(inflate);
         toast.show();

    }

    private void  showSnackBar(View view){
        Snackbar make = Snackbar.make(view, "sb?", Snackbar.LENGTH_LONG);
         make.setAction("yyyy", new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showToast("jd=a");
             }
         });
         make.show();
    }


    public void toast(View view) {
        showSnackBar(view);
    }
}
