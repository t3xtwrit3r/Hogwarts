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

    String ImageUrl, FirstName, LastName, Gender, House;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailsImage = findViewById(R.id.detailsImage);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        gender = findViewById(R.id.gender);
        house = findViewById(R.id.house);

        getData();
        setData();



    }

    private void setData() {
        if(getIntent().hasExtra("image") && getIntent().hasExtra("firstName") && getIntent().hasExtra("lastName") && getIntent().hasExtra("gender") && getIntent().hasExtra("house")){
            ImageUrl = getIntent().getStringExtra("image");
            FirstName = getIntent().getStringExtra("firsName");
            LastName = getIntent().getStringExtra("lastName");
            Gender = getIntent().getStringExtra("gender");
            House = getIntent().getStringExtra("house");
        }
    }

    private void getData() {

        Glide.with(DetailsActivity.this).load(ImageUrl).into(detailsImage);
        firstName.setText(FirstName);
        lastName.setText(LastName);
        gender.setText(Gender);
        house.setText(House);

    }
}