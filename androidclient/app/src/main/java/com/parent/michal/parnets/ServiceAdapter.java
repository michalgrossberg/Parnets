package com.parent.michal.parnets;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by GRMICHAL on 8/16/2015.
 */
public class ServiceAdapter extends ArrayAdapter<ServiceItem> {

    Context mContext;
    int layoutResourceId;
    List<ServiceItem> data;

    public ServiceAdapter(Context mContext, int layoutResourceId, List<ServiceItem> data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public ServiceItem getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ///   if(convertView==null){
        // inflate the layout
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

        convertView = inflater.inflate(R.layout.service_provider_item, parent, false);

        // object item based on the position
        ServiceItem serviceItem = data.get(position);

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView textViewItem = (TextView) convertView.findViewById(R.id.txtNameProvider);
        String name=serviceItem.getName().toString();
        textViewItem.setText(serviceItem.getName());


        TextView tvdesc = (TextView) convertView.findViewById(R.id.txtDescription);
        tvdesc.setText(serviceItem.getDecription());


        TextView textViewPricing = (TextView) convertView.findViewById(R.id.txtPricing);
        textViewPricing.setText("price range : " +serviceItem.getPricerange());
        //textViewItem.setTag(serviceItem.getPricerange());

        /*TextView textViewLocation = (TextView) convertView.findViewById(R.id.txtLocation);
        textViewLocation.setText(serviceItem.getLocation());*/
       // textViewItem.setTag(serviceItem.getLocation());
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ingViewPrpfilePic);
        imageView.setImageBitmap(serviceItem.getProfilepicture());



        return convertView;    }
}