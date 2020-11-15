package com.example.hogwarts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    ImageView detailsImage;
    TextView firstName;
    TextView lastName;
    TextView gender;
    TextView house;

    String ImageUrl, name, LastName, Gender, House;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailsImage = findViewById(R.id.detailsImage);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        gender = findViewById(R.id.gender);
        house = findViewById(R.id.house);

        setData();



    }

    private void setData() {

        ImageUrl = getIntent().getStringExtra("image");
        name = getIntent().getStringExtra("name");
        Gender = getIntent().getStringExtra("gender");
        House = getIntent().getStringExtra("house");

        String fullName[] = name.split(" ");

        Glide.with(DetailsActivity.this).load(ImageUrl).into(detailsImage);
        firstName.setText(fullName[0]);
        lastName.setText(fullName[1]);
        gender.setText(Gender);
        house.setText(House);

    }
}