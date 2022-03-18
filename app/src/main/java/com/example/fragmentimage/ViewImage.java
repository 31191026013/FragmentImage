package com.example.fragmentimage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import com.squareup.picasso.Picasso;

public class ViewImage extends Activity {
    ImageView img;
    String url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_image);

        TextView buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setText(new String(Character.toChars(0x2B05)));
        Intent intent = getIntent();
        url = intent.getExtras().getString("url");
        img = findViewById(R.id.imageView);

        Picasso.get()
                .load(url)
                .resize(1000,800)
                .into(img);

    }

    public void returnHome(View view){
        Intent intent = new Intent(getApplication(), MainActivity.class);
        intent.putExtra("history", url);
        startActivity(intent);
    }
}
