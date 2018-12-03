package com.polygon.myxtap.myxtapapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    private Button buttonSendMail;
    private Button buttonOpenProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        buttonSendMail = findViewById(R.id.buttonSendMail);
        buttonOpenProfile = findViewById(R.id.buttonOpenProfile);

        setListeners();
    }

    private void setListeners() {
        buttonSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonSendMail();
            }
        });
        buttonOpenProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonOpenProfile();
            }
        });
    }

    private void onClickButtonSendMail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","vovamiller_97@mail.ru", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Implicit Email Intent Test");
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                "Отправлено из " + AppUtilities.getApplicationName(MainMenuActivity.this));
        startActivity(Intent.createChooser(emailIntent, "Send Email..."));
    }

    private void onClickButtonOpenProfile() {
        Intent myIntent = new Intent(MainMenuActivity.this, PersonProfileActivity.class);
        startActivity(myIntent);
    }

}