package com.keyfalcon.blockchain.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.adapter.RequestsAdapter;
import com.keyfalcon.blockchain.callbacks.OnClickCallback;
import com.keyfalcon.blockchain.model.LandModel;

import java.util.ArrayList;
import java.util.List;

public class RequestSeedlings extends AppCompatActivity implements OnClickCallback {

    public static int TYPE_REQUEST_SEEDLINGS = 0x7001;
    public static int TYPE_REQUEST_MAP = 0x7002;
    public static int TYPE_REQUEST_IMAGE = 0x7003;

    private final Context mContext = RequestSeedlings.this;
    private RecyclerView mRvRequest;
    private List<LandModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUi();
        initListener();
    }

    private void initUi() {
        setContentView(R.layout.activity_request_seedlings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRvRequest = findViewById(R.id.rvRequest);
        mRvRequest.setLayoutManager(new LinearLayoutManager(mContext));
        mList.add(new LandModel("ABC12345", 12.985743, 77.544333, "54 ha", "pond", new String[5], "Red soil", ""));
        mList.add(new LandModel("ASD12345", 11.985743, 12.985743, "54 ha", "pond", new String[5], "Red soil", ""));
        mList.add(new LandModel("OKVN12345", 78.9857431, 64.985743, "54 ha", "pond", new String[5], "Red soil", ""));
        mRvRequest.setAdapter(new RequestsAdapter(mContext, mList, this));
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

    @Override
    public void onClickCallback(Object o, int type) {
        LandModel model = (LandModel) o;
        if (type == TYPE_REQUEST_SEEDLINGS) {
            showRequestConfirmation(model);
        } else if (type == TYPE_REQUEST_MAP) {
            double latitude = model.getLatitude();
            double longitude = model.getLongitude();
            String label = model.getmSurveyNo();
            String uriBegin = "geo:" + latitude + "," + longitude;
            String query = latitude + "," + longitude + "(" + label + ")";
            String encodedQuery = Uri.encode(query);
            String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
            Uri uri = Uri.parse(uriString);
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (type == TYPE_REQUEST_IMAGE) {
            showPreviewImgDialog(model);
        }
    }

    private void showPreviewImgDialog(LandModel model) {
        final Dialog dialog = new Dialog(RequestSeedlings.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.dialog_image_preview);

        ImageView aIvClose = (ImageView) dialog.findViewById(R.id.ivClose);
        ImageView aIvRight = (ImageView) dialog.findViewById(R.id.ivRight);
        ImageView aIvLeft = (ImageView) dialog.findViewById(R.id.ivLeft);
        final ImageView aIvPic = (ImageView) dialog.findViewById(R.id.ivPic);
        loadImageGlide(mContext, "https://source.unsplash.com/680x440/?white", DiskCacheStrategy.NONE, true, aIvPic);
        aIvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        aIvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImageGlide(mContext, "https://source.unsplash.com/680x440/?white", DiskCacheStrategy.NONE, true, aIvPic);
            }
        });
        aIvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImageGlide(mContext, "https://source.unsplash.com/680x440/?white", DiskCacheStrategy.NONE, true, aIvPic);
            }
        });
        dialog.show();
    }

    private void showRequestConfirmation(LandModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file
        //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        String message = "Apply for seedlings request for the survey no <b>" + model.getmSurveyNo() + "</b>?";
        builder.setMessage(Html.fromHtml(message))
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Confirmation");
        alert.show();
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
