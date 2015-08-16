package com.parent.michal.parnets;

import android.graphics.Bitmap;

/**
 * Created by GRMICHAL on 8/15/2015.
 */
public class ObjectItem {
    //another class to handle item's id and name
        public int itemId;
        public String itemName;
        public Bitmap cover;


        // constructor
        public ObjectItem(int itemId, String itemName,Bitmap cover) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.cover=cover;
        }

    }
