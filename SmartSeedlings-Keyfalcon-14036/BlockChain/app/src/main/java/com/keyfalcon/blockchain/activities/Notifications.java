package com.keyfalcon.blockchain.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.adapter.NotificationAdapter;
import com.keyfalcon.blockchain.model.NotificationModel;

import java.util.ArrayList;
import java.util.List;

public class Notifications extends AppCompatActivity {

    private final Context mContext = Notifications.this;
    private RecyclerView mRvNotifications;
    private NotificationAdapter mAdapter;
    private List<NotificationModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
        initListener();
    }

    private void initUI() {
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRvNotifications = findViewById(R.id.rvNotifications);
        mRvNotifications.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new NotificationAdapter(mContext, mList);
        mRvNotifications.setAdapter(mAdapter);
    }

    private void initListener() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
