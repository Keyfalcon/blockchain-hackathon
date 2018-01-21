package com.keyfalcon.blockchain.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.activities.MyPayments;
import com.keyfalcon.blockchain.activities.Notifications;
import com.keyfalcon.blockchain.activities.Register;
import com.keyfalcon.blockchain.activities.RequestSeedlings;
import com.keyfalcon.blockchain.activities.StatusUpdate;
import com.keyfalcon.blockchain.model.DashModel;
import com.keyfalcon.blockchain.utils.Constants;

import java.util.List;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.ViewHolder> {

    private Context mContext;
    private List<DashModel> mList;

    public DashAdapter(Context context, List<DashModel> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_dash, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mFabIcon.setImageResource(mList.get(position).getIcon());
        holder.mTvTitle.setText(mList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public List<DashModel> getAllPhotos() {
        return mList;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        FloatingActionButton mFabIcon;
        TextView mTvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mFabIcon = itemView.findViewById(R.id.fabIcon);
            mTvTitle = itemView.findViewById(R.id.tvTitle);
            mFabIcon.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(mContext, android.R.color.white)));
        }

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (getAdapterPosition()) {
                case 0:
                    mContext.startActivity(new Intent(mContext, StatusUpdate.class));
                    break;
                case 1:
                    intent = new Intent(mContext, Register.class);
                    intent.putExtra(Constants.KEY_IS_EDIT, true);
                    mContext.startActivity(intent);
                    break;
                case 2:
                    mContext.startActivity(new Intent(mContext, Notifications.class));
                    break;
                case 3:
                    mContext.startActivity(new Intent(mContext, RequestSeedlings.class));
                    break;
                case 4:
                    mContext.startActivity(new Intent(mContext, MyPayments.class));
                    break;
                case 5:
                    intent = new Intent(mContext, StatusUpdate.class);
                    intent.putExtra(Constants.KEY_IS_MY_SCHEDULE, true);
                    mContext.startActivity(intent);
                    break;
            }
        }
    }
}
