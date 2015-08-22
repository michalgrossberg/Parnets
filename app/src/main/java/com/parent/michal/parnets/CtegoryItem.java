package com.parent.michal.parnets;

import android.graphics.Bitmap;

/**
 * Created by GRMICHAL on 8/15/2015.
 */
public class CtegoryItem {
    //another class to handle item's id and name
        public int itemId;
        public String itemName;
        public Bitmap cover;


        // constructor
        public CtegoryItem(int itemId, String itemName, Bitmap cover) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.cover=cover;
        }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Bitmap getCover() {
        return cover;
    }

    public void setCover(Bitmap cover) {
        this.cover = cover;
    }
}
