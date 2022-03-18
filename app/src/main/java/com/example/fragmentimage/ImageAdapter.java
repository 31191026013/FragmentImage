package com.example.fragmentimage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
    private final String[] imageUrl;
    private final Context context;

    public ImageAdapter(Context context, String[] images){
        this.imageUrl = images;
        this.context = context;
    }
    @Override
    public int getCount() {
        return imageUrl.length;
    }

    @Override
    public String getItem(int position) {
        return imageUrl[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view = (ImageView) convertView;
        if(null == convertView){
            view = new ImageView(context);
        }
        String url = getItem(position);

        Picasso.get()
                .load(url)
                .resize(600,400)
                .into(view);
        return view;
    }
}
