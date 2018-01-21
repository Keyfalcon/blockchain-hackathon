package com.keyfalcon.blockchain.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.model.PaymentsModel;

import java.util.List;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public class PaymentsAdapter extends RecyclerView.Adapter<PaymentsAdapter.ViewHolder> {

    private Context mContext;
    private List<PaymentsModel> mList;

    public PaymentsAdapter(Context context, List<PaymentsModel> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_paymenst, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvSurveyNo.setText(mList.get(position).getTitle());
        holder.mTvTime.setText(mList.get(position).getTime());
        holder.mTvDetails.setText(mList.get(position).getMessage());
        holder.mTvPaymentId.setText("Transaction ID: "+mList.get(position).getTransactionId());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvSurveyNo, mTvTime, mTvDetails,mTvPaymentId;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvSurveyNo = itemView.findViewById(R.id.tvSurveyNo);
            mTvDetails = itemView.findViewById(R.id.tvDetails);
            mTvPaymentId = itemView.findViewById(R.id.tvPaymentId);
            mTvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}
