package com.parent.michal.parnets;

import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CategoryFrgment  extends Fragment {

    List<CtegoryItem> ctegoryItemData = null;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_category_frgment, container, false);

        //getCategories from server!!!

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.clown);
        Bitmap bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.magician);
        ctegoryItemData =new ArrayList<CtegoryItem>();
        ctegoryItemData.add(new CtegoryItem(91, "Clowns",bm));
        ctegoryItemData.add( new CtegoryItem(92, "magician",bm1));
        ctegoryItemData.add( new CtegoryItem(93, "Science activities ",bm1));
        ctegoryItemData.add( new CtegoryItem(94, "Animal activities  ",bm1));
        ctegoryItemData.add( new CtegoryItem(95, "Music activities ",bm1));
        ctegoryItemData.add( new CtegoryItem(96, "Dress Up activities ",bm1));
        ctegoryItemData.add( new CtegoryItem(97, "Cocking activities ",bm1));
        ctegoryItemData.add( new CtegoryItem(98, "Inflatables activities ",bm1));
        ctegoryItemData.add( new CtegoryItem(99, "DJ’s",bm1));
        ctegoryItemData.add( new CtegoryItem(100, "Photographers",bm1));


        ListCategoryAdapter adapter = new ListCategoryAdapter(getActivity(), R.layout.list_item, ctegoryItemData);
        // create a new ListView, set the adapter and item click listener
        ListView listViewItems = (ListView) v.findViewById(R.id.list_view_category);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String m= ctegoryItemData.get(position).itemName;
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main, new ServiceProviderFragment(), "NewFragmentTag");
                ft.commit();

            }
        });


        return v;
    }
}