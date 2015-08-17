package com.parent.michal.parnets;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ServiceProviderFragment extends Fragment {

    List<ServiceItem> serviceItems = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_service_rovider, container, false);

        //getCategories from server!!!

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.clown);
        Bitmap bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.magician);
        serviceItems =new ArrayList<ServiceItem>();
        //(Bitmap profilepicture, int rating, String pricerange, String location)

        serviceItems.add(new ServiceItem(bm, "avi",5, "50-70","haifa"));
        serviceItems.add(new ServiceItem(bm, "avi",5, "50-70","tel aviv"));
        serviceItems.add(new ServiceItem(bm, "avi",5, "100-150","San Diego"));
        serviceItems.add(new ServiceItem(bm, "avi",5, "200-220","New york"));




        ServiceAdapter adapter = new ServiceAdapter(getActivity(), R.layout.service_provider_item,serviceItems );
        // create a new ListView, set the adapter and item click listener
        ListView listViewItems = (ListView) v.findViewById(R.id.list_view_service);
        listViewItems.setAdapter(adapter);

        return v;
    }
}