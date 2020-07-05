package com.example.implicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openURL(View view) {
        Uri u = Uri.parse("https://www.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void call(View view) {
        Uri uri = Uri.parse("tel:1234567890");
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);

    }

    public void myLocation(View view) {
        //To Zoom
        //Uri mapsuri = Uri.parse("geo:16.4649,80.5078?z=21");
        //Searching Restaurants
        //Uri mapsuri = Uri.parse("geo:16.4649,80.5078?q=restaurants");
        //Adding a Marker
       // Uri mapsuri = Uri.parse("geo:16.4649,80.5078?q=<16.4649>,<80.5078>");
        //Near by Restaurants
        Uri mapsuri = Uri.parse("geo:0,0?q=ATM");
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW,mapsuri);
        if (mapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapsIntent);
        }

    }
}
