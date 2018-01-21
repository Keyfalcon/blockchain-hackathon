package com.keyfalcon.blockchain.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.adapter.PaymentsAdapter;
import com.keyfalcon.blockchain.model.PaymentsModel;

import java.util.ArrayList;
import java.util.List;

public class MyPayments extends AppCompatActivity {

    private Context mContext = MyPayments.this;
    private List<PaymentsModel> mList = new ArrayList<>();
    private RecyclerView mRvPayments;
    private PaymentsAdapter mAdatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUi();
        initListener();
    }

    private void initUi() {
        setContentView(R.layout.activity_my_payments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRvPayments = findViewById(R.id.rvPayments);
        mRvPayments.setLayoutManager(new LinearLayoutManager(mContext));
        mList.add(new PaymentsModel("JN654","3254 ₹","02-07-2017","FBDF65151"));
        mList.add(new PaymentsModel("MKL32","5272 ₹","04-09-2017","MBV234567"));
        mList.add(new PaymentsModel("NA516","4533 ₹","19-11-2017","CVBH45897"));
        mList.add(new PaymentsModel("DVB435","1812 ₹","14-01-2018","XCB46457"));
        mAdatper = new PaymentsAdapter(mContext,mList);
        mRvPayments.setAdapter(mAdatper);
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
