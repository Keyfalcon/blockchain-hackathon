package com.keyfalcon.blockchain.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.adapter.DashAdapter;
import com.keyfalcon.blockchain.model.DashModel;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    private final Context mContext = Dashboard.this;
    private RecyclerView mRvDash;
    private List<DashModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initui();
        initListener();

    }

    private void initui() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.GONE);
        mRvDash = findViewById(R.id.rvDash);
        mRvDash.setLayoutManager(new GridLayoutManager(mContext, 3));

        mList.add(new DashModel(R.drawable.ic_view_headline, "Status Update"));
        mList.add(new DashModel(R.drawable.ic_profile, "My Profile"));
        mList.add(new DashModel(R.drawable.ic_notification, "Notification"));
        mList.add(new DashModel(R.drawable.ic_land, "Seedlings\nRequest"));
        mList.add(new DashModel(R.drawable.ic_payments, "My\nPayments"));
        mList.add(new DashModel(R.drawable.ic_status_update, "My\nSchedule"));
        mRvDash.setAdapter(new DashAdapter(mContext, mList));
    }

    private void initListener() {

    }

}
