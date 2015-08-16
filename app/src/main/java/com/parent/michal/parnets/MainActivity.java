package com.parent.michal.parnets;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends FragmentActivity  {
    private static final int PLACE_PICKER_REQUEST = 1;
    GoogleApiClient mGoogleApiClient;
    Button btnLocation,btnChooseDate;
    private DatePicker dpResult;

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;

    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
            new LatLng(37.398160, -122.180831), new LatLng(37.430610, -121.972090));


    TextView txtLocation,txtDateDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        List<ObjectItem> ObjectItemData = null;
        //getCategories from server!!!
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.clown);
        Bitmap bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.magician);
        ObjectItemData =new ArrayList<ObjectItem>();
        ObjectItemData.add(new ObjectItem(91, "Clowns",bm));
        ObjectItemData.add( new ObjectItem(92, "magician",bm1));
        ObjectItemData.add( new ObjectItem(93, "Science activities ",bm1));
        ObjectItemData.add( new ObjectItem(94, "Animal activities  ",bm1));
        ObjectItemData.add( new ObjectItem(95, "Music activities ",bm1));
        ObjectItemData.add( new ObjectItem(96, "Dress Up activities ",bm1));
        ObjectItemData.add( new ObjectItem(97, "Cocking activities ",bm1));
        ObjectItemData.add( new ObjectItem(98, "Inflatables activities ",bm1));
        ObjectItemData.add( new ObjectItem(99, "DJ’s",bm1));
        ObjectItemData.add( new ObjectItem(100, "Photographers",bm1));


        ListCategoryAdapter adapter = new ListCategoryAdapter(this, R.layout.list_item, ObjectItemData);
        // create a new ListView, set the adapter and item click listener
        ListView listViewItems = (ListView) findViewById(R.id.list_view_category);
        listViewItems.setAdapter(adapter);


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


        }
    };
}
