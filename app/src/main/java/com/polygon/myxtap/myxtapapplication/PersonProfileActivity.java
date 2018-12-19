package com.polygon.myxtap.myxtapapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonProfileActivity extends AppCompatActivity {

    private static final String TAG = "PersonProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_profile);

        Log.d(TAG, "onCreate: started.");
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if (getIntent().hasExtra("image_rid") && getIntent().hasExtra("person_name")) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            int imageRid = getIntent().getIntExtra("image_rid", R.mipmap.ic_launcher);
            String personName = getIntent().getStringExtra("person_name");
            setData(imageRid, personName);
        }
    }

    private void setData(int imageRid, String personName) {
        Log.d(TAG, "setImage: setting obtained data.");

        ImageView image = findViewById(R.id.imgPersonPhoto);
        image.setImageResource(imageRid);

        TextView name = findViewById(R.id.textPersonName);
        name.setText(personName);
    }

}
