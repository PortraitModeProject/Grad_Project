package com.example.abalik.bitirme;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton ButtonTakePhoto;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonTakePhoto = (AppCompatButton) findViewById(R.id.ButtonTakePhoto);
        if (ButtonTakePhoto != null) {
            ButtonTakePhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Take_Photo();
                }
            });
        }


    }

    private void Take_Photo(){
        final String path = "/mnt/sdcard/Pictures/face.jpg";
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"face.jpg");
        Uri tempUri = Uri.fromFile(imageFile);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        //wait for uploading the picture to server
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //facepp_detect(path);
            }
        }, 10000);
    }
}


