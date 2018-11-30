package com.polygon.myxtap.myxtapapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_1;
    Button button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);

        setListeners();
    }

    private void setListeners() {

        button_1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","vovamiller_97@mail.ru", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Implicit Email Intent Test");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Отправлено из " + getApplicationName(MainActivity.this));
                startActivity(Intent.createChooser(emailIntent, "Send Email..."));
            }
        });

        button_2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int stringId = applicationInfo.labelRes;
        return stringId == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(stringId);
    }

}