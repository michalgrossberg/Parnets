package com.parent.michal.parnets;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by GRMICHAL on 8/15/2015.
 */

public class ListCategoryAdapter  extends ArrayAdapter<CtegoryItem> {

    Context mContext;
    int layoutResourceId;
    List<CtegoryItem> data;

    public ListCategoryAdapter(Context mContext, int layoutResourceId, List<CtegoryItem> data) {

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
    public CtegoryItem getItem(int position) {
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


        convertView = inflater.inflate(R.layout.list_item, parent, false);

        // object item based on the position
        CtegoryItem ctegoryItem = data.get(position);

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView textViewItem = (TextView) convertView.findViewById(R.id.category_name);
        textViewItem.setText(ctegoryItem.itemName);
        textViewItem.setTag(ctegoryItem.itemId);

        LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.LayoutItem);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Facing an problem with the picd
        //OutOf memory exception


        //Bitmap original = objectItem.cover;
        //original.compress(Bitmap.CompressFormat.PNG, 100, out);
       // Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));

        //Drawable drawable = new BitmapDrawable(mContext.getResources(),decoded);
        //linearLayout.setBackground(drawable);

        return convertView;    }
}