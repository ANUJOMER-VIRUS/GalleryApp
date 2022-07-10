package com.example.galleryapp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class ImageViewer extends AppCompatActivity {


//imagesarray=getIntent().getExtras().getStringArray("Image_array");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_image_viewer);
      String filepath=getIntent().getExtras().getString("Path");
      File file=new File(filepath);
      if(file.exists()){
          Bitmap bitmap=BitmapFactory.decodeFile(file.getAbsolutePath());
          ZoomableImageView imageView=findViewById(R.id.imageViewq);
          imageView.setImageBitmap(bitmap);
      }


    }
}