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



ViewPager mViewPager;

    ViewPagerAdapter mViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_image_viewer);

int pos=getIntent().getExtras().getInt("pos");

      String filepath[]=getIntent().getExtras().getStringArray("imagePath");
        mViewPager=(ViewPager)findViewById(R.id.imageViewpager);
        mViewPagerAdapter=new ViewPagerAdapter(ImageViewer.this,filepath);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setCurrentItem(pos);
mViewPager.setPageTransformer(true,new ZoomOutPageTransformer());

    }
}