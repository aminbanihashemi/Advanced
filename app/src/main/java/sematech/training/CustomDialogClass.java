package sematech.training;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.makeramen.roundedimageview.RoundedImageView;

import static sematech.training.WorkoutOne.WorkoutOneActivity.PICK_IMAGE;

public class CustomDialogClass extends Dialog implements View.OnClickListener  {
    public Activity mActivity;
    public Dialog d;
    public RoundedImageView cameraBtn, galleryBtn;
    Intent takePictureIntent;
    LinearLayout mLinearLayout;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int CAMERA_REQUEST = 1888;

    public CustomDialogClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.mActivity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_profile_picture);
        cameraBtn = findViewById(R.id.camera_btn);
        galleryBtn = findViewById(R.id.gallery_btn);
        mLinearLayout = findViewById(R.id.mLinearLayout);
        cameraBtn.setOnClickListener(this);
        galleryBtn.setOnClickListener(this);
        mLinearLayout = findViewById(R.id.mLinearLayout);
        ////////////////////////////////////////////////////////
        DisplayMetrics displayMetrics = new DisplayMetrics();
         mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int myHeight = displayMetrics.heightPixels;

//        mLinearLayout.getLayoutParams().height = (int) (myHeight*0.07);
        mLinearLayout.getLayoutParams().width = (int) (myHeight*0.5);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camera_btn:
                CameraMethod();
                break;
            case R.id.gallery_btn:
                GalleyMethod();
                break;
            default:
                break;
        }
        dismiss();
    }

    private void CameraMethod() {
//
//        if (checkSelfPermission(Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED) {
//            requestPermissions(new String[]{Manifest.permission.CAMERA},
//                    MY_CAMERA_PERMISSION_CODE);
//        } else {
//            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//            mActivity.startActivityForResult(cameraIntent, CAMERA_REQUEST);
//        }
    }

    private void GalleyMethod() {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        mActivity.startActivityForResult(chooserIntent, PICK_IMAGE);
    }
}
