package com.keyfalcon.blockchain.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.model.MySchdulesModel;
import com.keyfalcon.blockchain.utils.Utils;
import com.keyfalcon.blockchain.widgets.TimelineView;

import java.util.List;

/**
 * Created by Shylesh on 21-Jan-18.
 */

public class MySchedulesAdapter extends RecyclerView.Adapter<MySchedulesAdapter.TimeLineViewHolder> {

    private Context mContext;
    private List<MySchdulesModel> mList;

    public MySchedulesAdapter(Context mContext, List<MySchdulesModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TimeLineViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_my_schdules, parent, false), viewType);
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("", "getItemViewType: ");
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        MySchdulesModel model = mList.get(position);
        holder.mTitle.setText(model.getTitle());
        holder.mStatus.setText(model.getStatus());
        holder.mTvCondition.setText("Condition: "+model.getCondition());
        holder.mTvNumber.setText("Number: "+model.getNumber());
        loadImageGlide(mContext, model.getIcon(), DiskCacheStrategy.NONE, true, holder.mIvPic);
        switch (model.getsStatus()) {
            case COMPLETED:
                holder.mTimelineView.setMarker(ContextCompat.getDrawable(mContext, R.drawable.ic_marker_success));
                break;
            case PENDING:
                holder.mTimelineView.setMarker(Utils.getDrawable(mContext, R.drawable.ic_marker_inactive, R.color.colorPrimary));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class TimeLineViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle, mStatus, mTvCondition, mTvNumber;
        TimelineView mTimelineView;
        ImageView mIvPic;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tvTitle);
            mStatus = itemView.findViewById(R.id.tvStatus);
            mTvCondition = itemView.findViewById(R.id.tvCondition);
            mTvNumber = itemView.findViewById(R.id.tvNumber);
            mTimelineView = itemView.findViewById(R.id.tlLand);
            mIvPic = itemView.findViewById(R.id.ivPic);
            mTimelineView.initLine(viewType);
        }
    }

    public static void loadImageGlide(Context context, String imageUrl, DiskCacheStrategy diskCacheStrategy, boolean skipCache, ImageView imageView) {
        if (imageUrl != null && !imageUrl.equalsIgnoreCase(""))
            Glide.with(context)
                    .load(imageUrl)
                    .apply(new RequestOptions()
                            .diskCacheStrategy(diskCacheStrategy)
                            .skipMemoryCache(skipCache)
                            .error(R.mipmap.ic_launcher)
                    ).into(imageView);
    }
}
