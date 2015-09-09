package com.parent.michal.parnets;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;



public class MainActivity extends FragmentActivity  {
    private static final int PLACE_PICKER_REQUEST = 1;
    GoogleApiClient mGoogleApiClient;
    Button btnLocation,btnChooseDate;
    private DatePicker dpResult;
    private int year;
    private int month;
    private int day;
    private String DATE;
    SeekBar seekBar;
    Activity mActivity;
    static final int DATE_DIALOG_ID = 999;
    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
            new LatLng(37.398160, -122.180831), new LatLng(37.430610, -121.972090));


    TextView txtLocation,txtDateDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity=this;
        seekBar= (SeekBar) findViewById(R.id.seekBar);
        btnLocation= (Button) findViewById(R.id.btnLocation);
        btnChooseDate= (Button) findViewById(R.id.btnChooseDate);
        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //txtLocation= (TextView) findViewById(R.id.txtLocation);
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PlacePicker.IntentBuilder intentBuilder =
                            new PlacePicker.IntentBuilder();
                    intentBuilder.setLatLngBounds(BOUNDS_MOUNTAIN_VIEW);
                    Intent intent = intentBuilder.build(getApplicationContext());
                    startActivityForResult(intent, PLACE_PICKER_REQUEST);

                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }

        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "needs to change the search again!!!, newVal : progress " +seekBar.getProgress(), Toast.LENGTH_SHORT).show();

            }
        });
        CategoryFrgment myf = new CategoryFrgment();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.main, myf,"CategoryFrgment");
        transaction.commit();



        setCurrentDateOnView();
        addListenerOnButton();



    }


    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {

        if (requestCode == PLACE_PICKER_REQUEST
                && resultCode == Activity.RESULT_OK) {

            final Place place = PlacePicker.getPlace(data, this);
            final CharSequence name = place.getName();
            final CharSequence address = place.getAddress();
            String attributions = PlacePicker.getAttributions(data);
            if (attributions == null) {
                attributions = "";
            }

            //mName.setText(name);
            //mAddress.setText(address);
            //mAttributions.setText(Html.fromHtml(attributions));
             btnLocation.setText(address);
            btnLocation.setText("TTTTTTTTTTTTTTTTTTTTTTTTTTTTT");


        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        }

    @Override
    protected void onStop() {

        super.onStop();
    }
    // display current date
    public void setCurrentDateOnView() {

        txtDateDisplay = (TextView) findViewById(R.id.txtDateDisplay);
      //dpResult = (DatePicker) findViewById(R.id.dpResult);

       final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        txtDateDisplay.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));



    }
    public void addListenerOnButton() {

        btnChooseDate = (Button) findViewById(R.id.btnChooseDate);

        btnChooseDate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview

            txtDateDisplay.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));
            int i =month+1;
            String tmp=i+ "/"+day+"/"+year;

            Calendar c = Calendar.getInstance();
            c.set(year, i, day);

            String pattern = "MM/dd/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date d=null;
            try {
                d=sdf.parse(tmp);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            SharedHandler.save("date", d.toString(),
                    "details", MainActivity.this);

            //Toast.makeText(getApplicationContext(), formattedDate, Toast.LENGTH_SHORT).show();


        }
    };


    @Override
    public void onBackPressed() {

        FragmentManager fragmentManager=getFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.main);
        if( fragment.getTag().equals("CategoryFrgment")){
            super.onBackPressed();

        }
        else
            if(fragment.getTag().equals("ServiceProviderFragment")){


                /*final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations( R.anim.slide_in_left,R.anim.slide_out_right);
                ft.replace(R.id.main, new CategoryFrgment(), "CategoryFrgment");
                ft.commit();*/
                String backStateName = fragment.getClass().getName();

                FragmentManager manager = getFragmentManager();
                boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

                if (!fragmentPopped){ //fragment not in back stack, create it.
                    FragmentTransaction ft = manager.beginTransaction();
                    ft.replace(R.id.main, fragment);
                    ft.addToBackStack(backStateName);
                    ft.commit();
                }
                flipCard();

        }

        
    }
    private void flipCard() {

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
                .replace(R.id.main, new CategoryFrgment(), "CategoryFrgment")

                        // Add this transaction to the back stack, allowing users to press Back
                        // to get to the front of the card.
                .addToBackStack(null)

                        // Commit the transaction.
                .commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
