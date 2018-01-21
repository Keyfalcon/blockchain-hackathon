package com.keyfalcon.blockchain.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.adapter.LandSurveyDetailsAdapter;
import com.keyfalcon.blockchain.model.LandSurveyModel;
import com.keyfalcon.blockchain.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class LandSurveyDetails extends AppCompatActivity {

    private Context mContext = LandSurveyDetails.this;
    private RecyclerView mRvLandSurvey;
    private List<LandSurveyModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_survey_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra(Constants.KEY_SURVEY_NO))
            toolbar.setTitle(getIntent().getStringExtra(Constants.KEY_SURVEY_NO));

        mRvLandSurvey = findViewById(R.id.rvLandSurvey);
        mList.add(new LandSurveyModel("Land area department", "Success", "10:10 AM", LandSurveyModel.SurveyStatus.SUCCESS));
        mList.add(new LandSurveyModel("Nursery", "In Progress", "n/a", LandSurveyModel.SurveyStatus.IN_PROGRESS));
        mList.add(new LandSurveyModel("Forest department", "Upcoming", "n/a", LandSurveyModel.SurveyStatus.UPCOMING));
        mList.add(new LandSurveyModel("Treasury", "Upcoming", "n/a",LandSurveyModel.SurveyStatus.UPCOMING));
        mRvLandSurvey.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvLandSurvey.setHasFixedSize(true);
        mRvLandSurvey.setAdapter(new LandSurveyDetailsAdapter(mContext, mList));
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
