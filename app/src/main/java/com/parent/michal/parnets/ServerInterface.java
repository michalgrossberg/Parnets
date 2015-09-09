package com.parent.michal.parnets;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.client.Client;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;


class Provider {
    String name;
    String location;
    String desctiprion;
    String fullDesctiprion;
    byte[] image;
}

class Catagory {
    String name;
    byte[] image;
}
public interface ServerInterface {

   //public List<Provider> getAllServicesForLocationAndCategory(String Category,Date date ,float lag,float land );

    @GET("/providers/all")
    List<Provider> getProviders();
    @FormUrlEncoded
    @POST("/users/register")
    void createUser(@Field("user") User user, Callback<User> cb);
    @GET ("/users/login/:email/:password")
    User login(String email, String password);

}
