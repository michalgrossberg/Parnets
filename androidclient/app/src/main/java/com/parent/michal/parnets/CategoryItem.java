package com.parent.michal.parnets;

import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;

/**
 * Created by GRMICHAL on 8/15/2015.
 */
public class CategoryItem {
    //another class to handle item's id and name
        public int id;
        public String name;
        public transient Bitmap cover;
        public  String image;


        // constructor
        public CategoryItem(int itemId, String itemName, Bitmap cover) {
            this.id = itemId;
            this.name = itemName;
            this.cover=cover;
            this.image=convertBitmap(this.cover);

        }
    private  String convertBitmap( Bitmap bmp){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG,50,stream);
        byte[] byteArray = stream.toByteArray();

        byte [] b=stream.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);

        return temp;
    }

    public int getItemId() {
        return id;
    }

    public void setItemId(int itemId) {
        this.id = itemId;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String itemName) {
        this.name = itemName;
    }

    public Bitmap getCover() {
        return cover;
    }

    public void setCover(Bitmap cover) {
        this.cover = cover;
    }
}
