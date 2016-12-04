package com.zipyatrip.zipyatrip.zipyatrip;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.zipyatrip.zipyatrip.zipyatrip.R.id.btnChooseYaMood;


public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextFrom,editTextTo,editTime,editDate;
        Button btnChooseYaMood;
        Button click = (Button)findViewById(R.id.Bcapture);
        mImageView = (ImageView)findViewById(R.id.imageView);
        btnChooseYaMood = (Button)findViewById(R.id.btnChooseYaMood);
        editTime = (EditText)findViewById(R.id.etTime);
        editDate = (EditText)findViewById(R.id.etDate);

        Date d = new Date();

        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String currentTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        editTime.setText(currentTime);
        editDate.setText(currentDate);

        btnChooseYaMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ChooseMoodActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
            Bundle extras= data.getExtras();
            Bitmap photo= (Bitmap) extras.get("data");
            mImageView.setImageBitmap(photo);
        }
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }




}
