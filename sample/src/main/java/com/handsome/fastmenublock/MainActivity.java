package com.handsome.fastmenublock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eleme(View view) {
        startActivity(new Intent(this, ELemeActivity.class));
    }

    public void jd(View view) {
        startActivity(new Intent(this, JDActivity.class));
    }

    public void office(View view) {
        startActivity(new Intent(this, OfficeActivity.class));
    }
}
