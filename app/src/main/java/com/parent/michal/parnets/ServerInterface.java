package com.parent.michal.parnets;

import java.util.ArrayList;

/**
 * Created by GRMICHAL on 8/18/2015.
 */
public interface ServerInterface {

    public ArrayList<ServiceItem> getAllServicesForLocationAndCategory(String Category, String Location );

}
