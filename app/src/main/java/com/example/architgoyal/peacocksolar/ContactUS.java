package com.example.architgoyal.peacocksolar;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContactUS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            this.getWindow().setStatusBarColor(
                    getResources().getColor(R.color.statusbarcolor));
        }
    }
}
