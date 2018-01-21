package com.keyfalcon.blockchain.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.adapter.MySchedulesAdapter;
import com.keyfalcon.blockchain.model.MySchdulesModel;

import java.util.ArrayList;
import java.util.List;

public class MySchedules extends AppCompatActivity {

    private Context mContext = MySchedules.this;
    private RecyclerView mRvSchedules;
    private MySchedulesAdapter mAdapter;
    private List<MySchdulesModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_schedules);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRvSchedules = findViewById(R.id.rvSchedules);
        mRvSchedules.setLayoutManager(new LinearLayoutManager(mContext));

        mList.add(new MySchdulesModel("Q1 - 11-JAN-18","Completed","Good","466","https://source.unsplash.com/FV_PxCqgtwc/400x400", MySchdulesModel.ScheduleStatus.COMPLETED));
        mList.add(new MySchdulesModel("Q2 - 11-JUL-18","Pending","n/a","n/a","n/a", MySchdulesModel.ScheduleStatus.PENDING));
        mList.add(new MySchdulesModel("Q3 - 11-DEC-18","Pending","n/a","n/a","n/a", MySchdulesModel.ScheduleStatus.PENDING));

        mAdapter = new MySchedulesAdapter(mContext,mList);
        mRvSchedules.setAdapter(mAdapter);
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
