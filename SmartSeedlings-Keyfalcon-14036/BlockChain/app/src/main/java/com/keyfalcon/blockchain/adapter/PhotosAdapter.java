package com.keyfalcon.blockchain.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.keyfalcon.blockchain.R;

import java.util.List;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {

    private Context mContext;
    private List<Uri> mList;

    public PhotosAdapter(Context context, List<Uri> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_images, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mIvPics.setImageURI(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public List<Uri> getAllPhotos() {
        return mList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mIvPics;

        public ViewHolder(View itemView) {
            super(itemView);

            mIvPics = itemView.findViewById(R.id.ivPic);
        }
    }
}
