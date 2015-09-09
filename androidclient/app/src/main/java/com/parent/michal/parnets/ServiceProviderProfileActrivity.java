package com.parent.michal.parnets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ServiceProviderProfileActrivity extends Activity {

    Context mcontext;
    ImageButton btnBackProfile;
    ImageView imageViewGallery ;
    Button btnBook;

    EditText etDateDialog,etLocation,etNumberOfGuests,etVendorStartTime,etServiceLength,etFreeTextForTheUser;

    //GALLERY
    //variable for selection intent
    private final int PICKER = 1;
    //variable to store the currently selected image
    private int currentPic = 0;
    //gallery object
    private Gallery picGallery;
    //image view for larger display
    private ImageView picView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mcontext=getApplication();
        setContentView(R.layout.activity_service_provider_profile);
        btnBook= (Button) findViewById(R.id.btnBook);
        imageViewGallery= (ImageView) findViewById(R.id.imgViewGallery);
        imageViewGallery.setScaleType(ImageView.ScaleType.FIT_XY);
        btnBackProfile= (ImageButton) findViewById(R.id.btnBackProfile);
        btnBackProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etDateDialog;
                Button btnBook;
                final Dialog dialog = new Dialog(ServiceProviderProfileActrivity.this);
                dialog.setContentView(R.layout.dialog_book);
                dialog.setTitle("Push a request to : Vendor ");
                etDateDialog= (EditText) dialog.findViewById(R.id.etDateDialog);
                //get the date from shared file
                DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                String date = null;
                date = SharedHandler.get("date","details",ServiceProviderProfileActrivity.this);

                etDateDialog.setText(date.substring(4,11)+date.substring(30));
                dialog.show();
                DisplayMetrics metrics = getResources().getDisplayMetrics();
                int width = metrics.widthPixels;
                int height = metrics.heightPixels;
                dialog.getWindow().setLayout((6 * width)/6, LinearLayout.LayoutParams.WRAP_CONTENT);
                etLocation= (EditText) dialog.findViewById(R.id.etLocation);
                etNumberOfGuests=(EditText) dialog.findViewById(R.id.etNumberOfGuests);
                etVendorStartTime=(EditText) dialog.findViewById(R.id.etVendorStartTime);
                etServiceLength=(EditText) dialog.findViewById(R.id.etServiceLength);
                etFreeTextForTheUser=(EditText) dialog.findViewById(R.id.etFreeTextForTheUser);
                etFreeTextForTheUser.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        etFreeTextForTheUser.setText("");

                        return false;
                    }
                
                });
                btnBook= (Button) dialog.findViewById(R.id.btnSend);
                btnBook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(), etFreeTextForTheUser.getText().toString(), Toast.LENGTH_SHORT).show();

                    }
                });




            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_service_provider_profile, menu);
        return true;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
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

}
