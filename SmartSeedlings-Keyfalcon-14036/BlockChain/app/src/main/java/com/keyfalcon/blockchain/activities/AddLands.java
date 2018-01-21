package com.keyfalcon.blockchain.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.keyfalcon.blockchain.App;
import com.keyfalcon.blockchain.BuildConfig;
import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.adapter.PhotosAdapter;
import com.keyfalcon.blockchain.model.LandModel;
import com.keyfalcon.blockchain.utils.Utils;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddLands extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private final int IMAGE_CAPTURE = 0x5001;
    private final int LOCATION_PERMISSION = 0x5002;

    private final String TAG = "AddLands";
    private Context mContext = AddLands.this;
    private EditText mEtSurveyNo, mEtGps, mEtArea, mEtTypeOfSoil;
    private Spinner mSWaterSource;
    private RecyclerView mRvPhotos;
    private List<Uri> mUriList = new ArrayList<>();
    private PhotosAdapter mPhotosAdapter;
    private Uri mImgUri;
    private FusedLocationProviderClient mFusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUi();
        initListener();
    }

    private void initUi() {
        setContentView(R.layout.activity_add_lands);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        mSWaterSource = findViewById(R.id.sSourceWater);
        mEtArea = findViewById(R.id.etArea);
        mEtGps = findViewById(R.id.etGps);
        mEtSurveyNo = findViewById(R.id.etSurveyNo);
        mEtTypeOfSoil = findViewById(R.id.etSoil);
        mRvPhotos = findViewById(R.id.rvPhotos);
        mRvPhotos.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mPhotosAdapter = new PhotosAdapter(mContext, mUriList);
        mRvPhotos.setAdapter(mPhotosAdapter);
    }

    private void initListener() {
        findViewById(R.id.bContinue).setOnClickListener(this);
        findViewById(R.id.bAddMore).setOnClickListener(this);
        findViewById(R.id.cvAddPhoto).setOnClickListener(this);

        mEtGps.setOnTouchListener(this);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bContinue:
                if (validate()) {
                    setResult(RESULT_OK);
                    updateAndFinish();
                }
                break;
            case R.id.bAddMore:
                if (validate()) {
                    setResult(RESULT_FIRST_USER);
                    updateAndFinish();
                }
                break;
            case R.id.cvAddPhoto:
                openCamera();
                break;
        }
    }

    private void updateAndFinish() {

        try {
           /* String aSurveyNo = mEtSurveyNo.getText().toString();
            String[] sArry = mEtGps.getText().toString().split(", ");
            double aLatitude = Double.parseDouble(sArry[0]);
            double aLongitude = Double.parseDouble(sArry[1]);
            String aArea = mEtArea.getText().toString();
            String aWaterSource = (String) mSWaterSource.getSelectedItem();
            List<Uri> aList = mPhotosAdapter.getAllPhotos();
            String[] aPaths = new String[aList.size()];
            for (int i = 0; i < aPaths.length; i++) {
                aPaths[i] = aList.get(i).getPath();
            }
            String aSoilType = mEtTypeOfSoil.getText().toString();

            LandModel landModel = new LandModel(aSurveyNo, aLatitude, aLongitude, aArea, aWaterSource, aPaths, aSoilType, "Request");
            App.getDatabaseHelper().getDao(LandModel.class).createOrUpdate(landModel);*/
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validate() {
        if (mEtSurveyNo.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please enter survey number");
            return false;
        }
        if (mEtGps.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please refresh GPS");
            return false;
        }
        if (mEtArea.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please enter area");
            return false;
        }
        if (mEtTypeOfSoil.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please enter type of soil");
            return false;
        }
        return true;
    }

    public void openCamera() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            Utils.requestPermission(AddLands.this, Manifest.permission.CAMERA, "Storage read permission is needed to pick files.", 1);
        } else if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Utils.requestPermission(AddLands.this, Manifest.permission.READ_EXTERNAL_STORAGE, "Storage read permission is needed to pick files.", 1);
        } else {

            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            mImgUri = FileProvider.getUriForFile(mContext,
                    BuildConfig.APPLICATION_ID + ".provider",
                    getOutputMediaFile());
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        mImgUri);
                startActivityForResult(takePictureIntent, IMAGE_CAPTURE);
            }
        }
    }

    private File getOutputMediaFile() {

        // External sdcard location
        File mediaStorageDir = new File(Utils.getPath() + File.separator + "Pictures");

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(TAG, "Oops! Failed create ");
                return null;
            }
        }

        File mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + "IMG_" + System.currentTimeMillis() + ".jpg");
        return mediaFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                mUriList.add(mImgUri);
                mPhotosAdapter.notifyDataSetChanged();
            } else if (resultCode == RESULT_CANCELED) {

            }
        } else if (requestCode == LOCATION_PERMISSION) {
            if (resultCode == RESULT_OK) {
                requestLocation();
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int DRAWABLE_LEFT = 0;
        final int DRAWABLE_TOP = 1;
        final int DRAWABLE_RIGHT = 2;
        final int DRAWABLE_BOTTOM = 3;

        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (event.getRawX() >= (mEtGps.getRight() - mEtGps.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                // your action here
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    Utils.requestPermission(AddLands.this, Manifest.permission.ACCESS_FINE_LOCATION, "Storage read permission is needed to pick files.", LOCATION_PERMISSION);
                    return true;
                }

                requestLocation();

                return true;
            }
        }
        return false;
    }

    private void requestLocation() {
        Task<Location> aTask = mFusedLocationProviderClient.getLastLocation();
        aTask.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location aLocation) {
                if (aLocation != null)
                    mEtGps.setText(aLocation.getLatitude() + ", " + aLocation.getLongitude());
            }
        });
    }
}
