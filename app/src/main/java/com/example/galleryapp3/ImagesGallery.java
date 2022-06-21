package com.example.galleryapp3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class ImagesGallery {
    public static ArrayList<String >listOfImages(Context context){
        Uri uri;
        Cursor cursor;
        int column_index_data,column_index_folder_name;
        ArrayList<String>listofAllimages=new ArrayList<>();
        String Abslutepathimage;
        uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection={
                MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME
        };
        String OrderBy=MediaStore.Video.Media.DATE_TAKEN;
        cursor=context.getContentResolver().query(uri,projection,null,
                null,OrderBy+"DESC");

        column_index_data=cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        while (cursor.moveToNext()){
            Abslutepathimage=cursor.getString(column_index_data);
            listofAllimages.add(Abslutepathimage);
        }


        return listofAllimages;
    }
}
