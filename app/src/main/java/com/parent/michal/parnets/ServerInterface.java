package com.parent.michal.parnets;

import java.util.ArrayList;
import java.util.Date;

import retrofit.client.Client;
import retrofit.http.GET;

/**
 * Created by GRMICHAL on 8/18/2015.
 */
public interface ServerInterface {

    public ArrayList<ServiceItem> getAllServicesForLocationAndCategory(String Category,Date date ,float lag,float land );

    @GET("com.parent.michal.parnets.expressapp/getProviders")
     ServiceItem getProviders();

}
