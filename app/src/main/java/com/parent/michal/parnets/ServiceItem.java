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

    String Name;
    int Rating;
    String Pricerange;
    String Location;

    public ServiceItem(Bitmap profilepicture,String name, int rating, String pricerange, String location) {
        Profilepicture = profilepicture;
        Rating = rating;
        Pricerange = pricerange;
        Location = location;
        Name=name;
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
