package com.parent.michal.parnets;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class CategoryFrgment  extends Fragment {

    CategoryItem categoryItem;
    Boolean mShowingBack;
    List<CategoryItem> ctegoryItemData = null;
    public static final String BASE_URL = "http://10.0.0.6:3000";
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(BASE_URL)
            .build();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mShowingBack=false;
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




        ctegoryItemData =new ArrayList<CategoryItem>();
        ctegoryItemData.add(new CategoryItem(91, "Clowns",bm));

        ctegoryItemData.add( new CategoryItem(92, "magician",bm1));
        ctegoryItemData.add( new CategoryItem(93, "Science  ",bm2));
        ctegoryItemData.add( new CategoryItem(94, "Animal   ",bm3));
        ctegoryItemData.add( new CategoryItem(95, "Music  ",bm4));
        ctegoryItemData.add( new CategoryItem(96, "Dress Up  ",bm5));
        ctegoryItemData.add( new CategoryItem(97, "Cooking  ",bm6));
        ctegoryItemData.add( new CategoryItem(98, "Inflatables  ",bm7));
        ctegoryItemData.add( new CategoryItem(99, "DJ’s",bm8));
        ctegoryItemData.add( new CategoryItem(100, "Photographers",bm9));

        categoryItem = new CategoryItem(91, "Clowns",bm);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();
        //Log.d("categoryItem size",""+categoryItem.image.length);


        //once the server will be handy:
        CreateCategoryAsyncTask createTask =new CreateCategoryAsyncTask();
        createTask.execute();
        // POST /users/register


        ListCategoryAdapter adapter = new ListCategoryAdapter(getActivity(), R.layout.list_item, ctegoryItemData);
        // create a new ListView, set the adapter and item click listener
        ListView listViewItems = (ListView) v.findViewById(R.id.list_view_category);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String m= ctegoryItemData.get(position).name;
                DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                Date date = null;
                try {
                     date = format.parse(SharedHandler.get("date","details",getActivity()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
               /* ArrayList<ServiceItem> serviceItems;
                serviceItems=getAllServicesForLocationAndCategory(m, date ,lang,land);*/



         /*       final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations( R.anim.slide_in_left,R.anim.slide_out_right);
                ft.replace(R.id.main, new ServiceProviderFragment(), "ServiceProviderFragment");
                ft.commit();*/

                flipCard();
            }
        });


        return v;
    }

    private void flipCard() {
        if (mShowingBack) {
            getFragmentManager().popBackStack();
            return;
        }

        // Flip to the back.

        mShowingBack = true;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.

        getFragmentManager()
                .beginTransaction()

                        // Replace the default fragment animations with animator resources representing
                        // rotations when switching to the back of the card, as well as animator
                        // resources representing rotations when flipping back to the front (e.g. when
                        // the system Back button is pressed).
                .setCustomAnimations(
                        R.anim.card_flip_right_in, R.anim.card_flip_right_out,
                        R.anim.card_flip_left_in, R.anim.card_flip_left_out)

                        // Replace any fragments currently in the container view with a fragment
                        // representing the next page (indicated by the just-incremented currentPage
                        // variable).
                .replace(R.id.main, new   ServiceProviderFragment(), "ServiceProviderFragment")

                        // Add this transaction to the back stack, allowing users to press Back
                        // to get to the front of the card.
                .addToBackStack(null)

                        // Commit the transaction.
                .commit();
    }

    class CreateCategoryAsyncTask extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... params) {
            ServerInterface server=restAdapter.create(ServerInterface.class);
            server.createCatagory(categoryItem , new Callback<User>() {
                @Override
                public void success(User user, Response response) {


                    Log.d("CreateCategoryAsyncTask","CreateCategoryAsyncTask OK");
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.d("CreateCategoryAsyncTask","CreateCategoryAsyncTask ERROR");


                    //Toast.makeText(getApplicationContext(), retrofitError.toString(), Toast.LENGTH_SHORT).show();

                }
            });

            return null;
        }
    }
}