package com.keyfalcon.blockchain.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.activities.RequestSeedlings;
import com.keyfalcon.blockchain.callbacks.OnClickCallback;
import com.keyfalcon.blockchain.model.LandModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public class RequestsAdapter extends RecyclerView.Adapter<RequestsAdapter.ViewHolder> {

    private Context mContext;
    private List<LandModel> mList;
    private List<LandModel> mSelectedList;
    private OnClickCallback mCallback;

    public RequestsAdapter(Context context, List<LandModel> list, OnClickCallback callback) {
        this.mContext = context;
        this.mList = list;
        mCallback = callback;
        mSelectedList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_seedling_request, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LandModel model=  mList.get(position);
        holder.mTvArea.setText(model.getArea());
        holder.mTvSurveyNo.setText(model.getmSurveyNo());
        holder.mTvSoilType.setText(model.getTypeOfSoil());
        holder.mTvWaterSource.setText(model.getSourceOfWater());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public List<LandModel> getAllSelectedLands() {
        return mSelectedList;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout mLlLand, mLlMap, mLlImages;
        TextView mTvSurveyNo, mTvSoilType, mTvArea, mTvWaterSource;

        public ViewHolder(View itemView) {
            super(itemView);

            mLlLand = itemView.findViewById(R.id.llLand);
            mLlMap = itemView.findViewById(R.id.llMap);
            mLlImages = itemView.findViewById(R.id.llImages);

            mTvSurveyNo = itemView.findViewById(R.id.tvSurveyNo);
            mTvSoilType = itemView.findViewById(R.id.tvSoilType);
            mTvArea = itemView.findViewById(R.id.tvArea);
            mTvWaterSource = itemView.findViewById(R.id.tvWaterSource);

            mLlLand.setOnClickListener(this);
            mLlMap.setOnClickListener(this);
            mLlImages.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.llLand:
                    mCallback.onClickCallback(mList.get(getAdapterPosition()), RequestSeedlings.TYPE_REQUEST_SEEDLINGS);
                    break;
                case R.id.llMap:
                    mCallback.onClickCallback(mList.get(getAdapterPosition()), RequestSeedlings.TYPE_REQUEST_MAP);
                    break;
                case R.id.llImages:
                    mCallback.onClickCallback(mList.get(getAdapterPosition()), RequestSeedlings.TYPE_REQUEST_IMAGE);
                    break;
            }
        }
    }
}
