package com.example.galleryapp3;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

RecyclerView recyclerView;
GalleryAdapter galleryAdapterl;
    List<String >images;
    TextView gallery_number;
    private static final int MY_READ_PERMISSION_CODE=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery_number=findViewById(R.id.gallery_number);
        recyclerView =findViewById(R.id.recyclerview_gallery_image);

        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
          loadImage();
        }
else {
    loadImages();
        }
    }
    public void loadImage(){
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_READ_PERMISSION_CODE);
    }
    private void loadImages(){
     recyclerView.setHasFixedSize(true);
     recyclerView.setLayoutManager(new GridLayoutManager(this,4));
     images=ImagesGallery.listOfImages(this);
     galleryAdapterl=new GalleryAdapter(this, images, new GalleryAdapter.photoListener() {
         @Override
         public void onPhotoClick(String path) {
int pos=images.indexOf(path);
          Intent intent=new Intent(MainActivity.this,ImageViewer.class);
          intent.putExtra("imagePath",listtostring(images));
          intent.putExtra("pos",pos);
          startActivity(intent);

         }
     });
     recyclerView.setAdapter(galleryAdapterl);
     gallery_number.setText("photos ( "+images.size()+" )");
    }
    @Override
    public  void onRequestPermissionsResult(int RequestCode, @NonNull String[]permission,@NonNull int[] grantResults) {

        super.onRequestPermissionsResult(RequestCode, permission, grantResults);
        if(RequestCode==MY_READ_PERMISSION_CODE){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"REQUEST GRANT",Toast.LENGTH_SHORT).show();
                loadImages();
            }
            else {
                Toast.makeText(this,"Request not granted",Toast.LENGTH_SHORT).show();
            }
        }
    }
private  String[] listtostring(List<String> list){
        String arr[]=list.toArray(new String[list.size()]);
        return arr;
}
}