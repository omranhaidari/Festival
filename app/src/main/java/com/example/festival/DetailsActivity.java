package com.example.festival;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.festival.database.Groupe;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Groupe g = MainActivity.selectedGroup;
    }
}