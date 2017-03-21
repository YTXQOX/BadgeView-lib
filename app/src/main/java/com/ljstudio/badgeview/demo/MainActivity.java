package com.ljstudio.badgeview.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljstudio.badgeview.BadgeTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = (ImageView) findViewById(R.id.tv);
        BadgeTextView mBadgeTextView =new BadgeTextView(this);
        mBadgeTextView.setTargetView(iv);
        mBadgeTextView.setBadgeColor(Color.parseColor("#FF0000"));
        mBadgeTextView.setBadgeCount(0).setmDefaultTopPadding(4).setmDefaultRightPadding(4);
        mBadgeTextView.setBadgeShown(true);

        TextView tv2 = (TextView) findViewById(R.id.tv2);
        BadgeTextView mBadgeTextView2 =new BadgeTextView(this);
        mBadgeTextView2.setBadgeShown(true);
        mBadgeTextView2.setTargetView(tv2);
        mBadgeTextView2.setBadgeCount(15).setmDefaultRightPadding(15).setmDefaultTopPadding(15);

    }
}
