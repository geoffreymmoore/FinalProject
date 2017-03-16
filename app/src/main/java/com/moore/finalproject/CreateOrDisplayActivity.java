package com.moore.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateOrDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_display);
    }

    public void createNewJobClick(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    public void viewExistingJobClick(View view) {
        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);
    }
}
