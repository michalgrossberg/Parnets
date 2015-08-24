package com.parent.michal.parnets;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import  com.parent.michal.parnets.ServerInterface;

import retrofit.RestAdapter;

public class ServiceProviderFragment extends Fragment {
    public static final String BASE_URL = "http://46.210.232.245:3000";


    List<ServiceItem> serviceItems = null;
    RestAdapter restAdapter ;

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

        restAdapter =new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();
        //once the server will be handy:
        /*getProvidersAsyncTask getProviders =new getProvidersAsyncTask();
        getProviders.execute();
*/
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

    class getProvidersAsyncTask extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... params) {

            List<Provider> serviceItems1;
            ServerInterface server=restAdapter.create(ServerInterface.class);
            serviceItems1= (List<Provider>) server.getProviders();

            return null;
        }
    }
}