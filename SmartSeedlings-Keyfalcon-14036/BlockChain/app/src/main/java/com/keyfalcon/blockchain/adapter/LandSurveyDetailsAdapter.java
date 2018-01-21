package com.keyfalcon.blockchain.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.model.LandSurveyModel;
import com.keyfalcon.blockchain.utils.Utils;
import com.keyfalcon.blockchain.widgets.TimelineView;

import java.util.List;

/**
 * Created by Shylesh on 21-Jan-18.
 */

public class LandSurveyDetailsAdapter extends RecyclerView.Adapter<LandSurveyDetailsAdapter.TimeLineViewHolder> {

    private Context mContext;
    private List<LandSurveyModel> mList;

    public LandSurveyDetailsAdapter(Context mContext, List<LandSurveyModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TimeLineViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_land_survey_details, parent, false), viewType);
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("", "getItemViewType: ");
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        LandSurveyModel model = mList.get(position);
        holder.mTitle.setText(model.getTitle());
        holder.mTime.setText(model.getTime());
        holder.mStatus.setText(model.getStatus());

        switch (model.getsStatus()){
            case SUCCESS:
                holder.mTimelineView.setMarker(ContextCompat.getDrawable(mContext, R.drawable.ic_marker_success));
                break;
            case DECLINED:
                holder.mTimelineView.setMarker(ContextCompat.getDrawable(mContext, R.drawable.ic_marker_declined));
                break;
            case UPCOMING:
                holder.mTimelineView.setMarker(Utils.getDrawable(mContext, R.drawable.ic_marker_inactive, R.color.colorPrimary));
                break;
            case IN_PROGRESS:
                holder.mTimelineView.setMarker(Utils.getDrawable(mContext, R.drawable.ic_marker_active, R.color.colorPrimary));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class TimeLineViewHolder extends RecyclerView.ViewHolder {

        TextView mTime, mTitle, mStatus;
        TimelineView mTimelineView;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tvTitle);
            mStatus = itemView.findViewById(R.id.tvStatus);
            mTime = itemView.findViewById(R.id.tvTime);
            mTimelineView = itemView.findViewById(R.id.tlLand);
            mTimelineView.initLine(viewType);
        }
    }
}
