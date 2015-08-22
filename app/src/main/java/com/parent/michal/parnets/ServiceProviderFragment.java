package com.parent.michal.parnets;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.balon);

        serviceItems =new ArrayList<ServiceItem>();
        serviceItems.add(new ServiceItem(bm, "Michal Grossberg", 5, "50-70","haifa","one line description that the service provider itself choose"));
        serviceItems.add(new ServiceItem(bm, "Michal Grossberg", 5
               ,"50-70","haifa","one line description that the service provider itself choose"));
        serviceItems.add(new ServiceItem(bm, "Michal Grossberg", 5, "50-70","haifa","one line description that the service provider itself choose"));
        serviceItems.add(new ServiceItem(bm, "Michal Grossberg", 5, "50-70","haifa","one line description that the service provider itself choose"));




        ServiceAdapter adapter = new ServiceAdapter(getActivity(), R.layout.service_provider_item,serviceItems );
        // create a new ListView, set the adapter and item click listener
        ListView listViewItems = (ListView) v.findViewById(R.id.list_view_service);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ServiceProviderProfileActrivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}