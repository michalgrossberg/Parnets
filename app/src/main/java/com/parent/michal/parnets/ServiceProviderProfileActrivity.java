package com.parent.michal.parnets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class ServiceProviderProfileActrivity extends Activity {

    Context mcontext;
    ImageButton btnBackProfile;
    ImageView imageViewGallery ;
    Button btnBook;
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
                // custom dialog
                //this row has a problem!!!!!!!!!!!!!!
                final Dialog dialog = new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.dialog_book);
                dialog.setTitle("Title...");
                dialog.show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_service_provider_profile, menu);
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
}
