package com.parent.michal.parnets;

import android.graphics.Bitmap;

/**
 * Created by GRMICHAL on 8/16/2015.
 */
public class ServiceItem {

    Bitmap Profilepicture;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int Id;

    String Name;
    int Rating;
    String Pricerange;
    String Location;
    String Decription;
    String FullDecription;
    int CategoryId;
    public String getDecription() {
        return Decription;
    }

    public void setDecription(String decription) {
        Decription = decription;
    }

    public ServiceItem(Bitmap profilepicture,String name, int rating, String pricerange, String location , String decription) {
        Profilepicture = profilepicture;
        Rating = rating;
        Pricerange = pricerange;
        Location = location;
        Name=name;
        Decription=decription;
    }

    public void setProfilepicture(Bitmap profilepicture) {
        Profilepicture = profilepicture;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public void setPricerange(String pricerange) {
        Pricerange = pricerange;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getLocation() {

        return Location;
    }

    public String getPricerange() {
        return Pricerange;
    }

    public int getRating() {
        return Rating;
    }

    public Bitmap getProfilepicture() {
        return Profilepicture;
    }
}
