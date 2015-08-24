package com.parent.michal.parnets;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.client.Client;
import retrofit.http.GET;


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

   public List<Provider> getAllServicesForLocationAndCategory(String Category,Date date ,float lag,float land );

    @GET("/providers/all")
    List<Provider> getProviders();
}
