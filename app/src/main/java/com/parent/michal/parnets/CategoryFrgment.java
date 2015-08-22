package com.parent.michal.parnets;

import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit.RestAdapter;


public class CategoryFrgment  extends Fragment {

    List<CtegoryItem> ctegoryItemData = null;
    public static final String BASE_URL = "http://localhost";
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(BASE_URL)
            .build();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_category_frgment, container, false);

        //getCategories from server!!!

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.clown);
        Bitmap bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.magician);
        Bitmap bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.sience);
        Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.animal);
        Bitmap bm4 = BitmapFactory.decodeResource(getResources(), R.drawable.music);
        Bitmap bm5 = BitmapFactory.decodeResource(getResources(), R.drawable.dressup);
        Bitmap bm6 = BitmapFactory.decodeResource(getResources(), R.drawable.cooking);
        Bitmap bm7 = BitmapFactory.decodeResource(getResources(), R.drawable.inflatables);
        Bitmap bm8 = BitmapFactory.decodeResource(getResources(), R.drawable.djs);
        Bitmap bm9 = BitmapFactory.decodeResource(getResources(), R.drawable.photographers);




        ctegoryItemData =new ArrayList<CtegoryItem>();
        ctegoryItemData.add(new CtegoryItem(91, "Clowns",bm));
        ctegoryItemData.add( new CtegoryItem(92, "magician",bm1));
        ctegoryItemData.add( new CtegoryItem(93, "Science  ",bm2));
        ctegoryItemData.add( new CtegoryItem(94, "Animal   ",bm3));
        ctegoryItemData.add( new CtegoryItem(95, "Music  ",bm4));
        ctegoryItemData.add( new CtegoryItem(96, "Dress Up  ",bm5));
        ctegoryItemData.add( new CtegoryItem(97, "Cooking  ",bm6));
        ctegoryItemData.add( new CtegoryItem(98, "Inflatables  ",bm7));
        ctegoryItemData.add( new CtegoryItem(99, "DJ’s",bm8));
        ctegoryItemData.add( new CtegoryItem(100, "Photographers",bm9));


        ListCategoryAdapter adapter = new ListCategoryAdapter(getActivity(), R.layout.list_item, ctegoryItemData);
        // create a new ListView, set the adapter and item click listener
        ListView listViewItems = (ListView) v.findViewById(R.id.list_view_category);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String m= ctegoryItemData.get(position).itemName;
                DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                Date date = null;
                try {
                     date = format.parse(SharedHandler.get("date","details",getActivity()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
               /* ArrayList<ServiceItem> serviceItems;
                serviceItems=getAllServicesForLocationAndCategory(m, date ,lang,land);*/
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main, new ServiceProviderFragment(), "NewFragmentTag");
                ft.commit();

            }
        });


        return v;
    }
}