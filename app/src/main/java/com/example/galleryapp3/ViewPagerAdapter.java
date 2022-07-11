package com.example.galleryapp3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.io.File;
import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    String [] imagespath;
    LayoutInflater mLayoutInflater;

    public ViewPagerAdapter(Context context, String[] imagespath) {
        this.context = context;
        this.imagespath = imagespath;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imagespath.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        // inflating the item.xml
        View itemView = mLayoutInflater.inflate(R.layout.item, container, false);
ZoomableImageView imageView=(ZoomableImageView) itemView.findViewById(R.id.imageViewSwipe);
    String filepath=imagespath[position];
        File file=new
                File(filepath);
        if(file.exists()){
            Bitmap bitmap= BitmapFactory.decodeFile(file.getAbsolutePath());
            imageView.setImageBitmap(bitmap);

        }

        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }
    }