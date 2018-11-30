package com.polygon.myxtap.myxtapapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText editText;
    static String editTextMemory = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.second_editText_1);
        if (editTextMemory == null) {
            editTextMemory = editText.getText().toString();
        } else {
            editText.setText(editTextMemory);
        }
    }

    @Override
    protected void onDestroy() {
        editTextMemory = editText.getText().toString();
        super.onDestroy();
    }
}
