package com.example.findcities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView tvSelected;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        spinner = findViewById(R.id.spinner);
        tvSelected = findViewById(R.id.tvSelected);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
     }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        String selected = parent.getItemAtPosition(pos).toString();
        tvSelected.setText(selected);

        if (!selected.isEmpty()) {

            //TODO http request to the API, endpoint: https://wft-geo-db.p.rapidapi.com/v1
            //TODO get the GPS coordinates from the json file

            //URL url = null;
            //HttpURLConnection urlConnection = null;
            //try {
            //    url = new URL("https://wft-geo-db.p.rapidapi.com/v1");
            //    urlConnection = (HttpURLConnection) url.openConnection();
            //    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                //readStream(in);
            //} catch (MalformedURLException e) {
            //    e.printStackTrace();}
            // catch (IOException e) {
                //e.printStackTrace();}

            //finally {
            //    urlConnection.disconnect();
            //}


            String sourceLatitude = "47,094018";
            String sourceLongitude = "19,302071";
            String uri = "http://maps.google.com/maps?saddr=" + sourceLatitude + "," + sourceLongitude;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }
     }

    public void onNothingSelected(AdapterView<?> parent) {
        String selected = "";
        tvSelected.setText(selected);
    }

}