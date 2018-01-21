package com.keyfalcon.blockchain.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.adapter.StatusAdapter;
import com.keyfalcon.blockchain.callbacks.OnClickCallback;
import com.keyfalcon.blockchain.model.LandModel;
import com.keyfalcon.blockchain.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class StatusUpdate extends AppCompatActivity implements OnClickCallback {

    private final Context mContext = StatusUpdate.this;
    private RecyclerView mRvStatus;
    private List<LandModel> mList = new ArrayList<>();
    private boolean mIsSchedules = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUi();
        initListener();
    }

    private void initUi() {
        setContentView(R.layout.activity_status_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra(Constants.KEY_IS_MY_SCHEDULE)) {
            mIsSchedules = true;
            getSupportActionBar().setTitle(getString(R.string.title_activity_my_schedules));
        }

        mRvStatus = findViewById(R.id.rvUpdates);
        mRvStatus.setLayoutManager(new LinearLayoutManager(mContext));
        mList.add(new LandModel("ABC12345", 12.985743, 77.544333, "54 ha", "pond", new String[5], "Red soil", ""));
        mList.add(new LandModel("ASD12345", 11.985743, 12.985743, "54 ha", "pond", new String[5], "Red soil", ""));
        mList.add(new LandModel("OKVN12345", 78.9857431, 64.985743, "54 ha", "pond", new String[5], "Red soil", ""));
        mRvStatus.setAdapter(new StatusAdapter(mContext, mList, this));
    }

    private void initListener() {

    }

    @Override
    public void onClickCallback(Object o, int type) {
        LandModel model = (LandModel) o;
        Intent intent = new Intent();
        if (!mIsSchedules) {
            intent.setClass(mContext, LandSurveyDetails.class);
        } else {
            intent.setClass(mContext, MySchedules.class);
        }
        intent.putExtra(Constants.KEY_SURVEY_NO, model.getmSurveyNo());
        startActivity(intent);
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
