package com.gmd.lessons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        ImageView teamImage = (ImageView) findViewById(R.id.teamImage);
        teamImage.setImageDrawable(getDrawable(R.drawable.realmadrid));
        Bitmap barcelona = BitmapFactory.decodeResource(getResources(),
                R.drawable.realmadrid);

        // Asynchronous
        Palette.from(barcelona).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette p) {
                View view = findViewById(R.id.teamContainer);
                TextView teamName = (TextView) findViewById(R.id.teamName);
                TextView teamCountry = (TextView) findViewById(R.id.teamCountry);
                view.setBackgroundColor(p.getDarkVibrantColor(Color.BLACK));
                teamName.setTextColor(p.getLightVibrantColor(Color.BLACK));
                teamCountry.setTextColor(p.getLightVibrantColor(Color.BLACK));
            }
        });
    }
}
