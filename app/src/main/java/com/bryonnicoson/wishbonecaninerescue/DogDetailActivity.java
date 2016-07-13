package com.bryonnicoson.wishbonecaninerescue;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DogDetailActivity extends AppCompatActivity {

    int id;
    String name, breed, age, sex, size, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_detail);

        ImageView mDogPhoto = (ImageView) findViewById(R.id.dog_photo);
        TextView mDogName = (TextView) findViewById(R.id.dog_name);
        TextView mDogBreed = (TextView) findViewById(R.id.dog_breed);
        TextView mDogAge = (TextView) findViewById(R.id.dog_age);
        TextView mDogSex = (TextView) findViewById(R.id.dog_sex);
        TextView mDogSize = (TextView) findViewById(R.id.dog_size);
        TextView mDogDesc = (TextView) findViewById(R.id.dog_desc);

        final Intent mainIntent = getIntent();

        name = mainIntent.getStringExtra("NAME");
        breed = mainIntent.getStringExtra("BREED");
        age = mainIntent.getStringExtra("AGE");
        sex = mainIntent.getStringExtra("SEX");
        size = mainIntent.getStringExtra("SIZE");
        desc = mainIntent.getStringExtra("DESC");

        mDogPhoto.setImageResource(mainIntent.getIntExtra("PHOTO", 0));
        mDogName.setText(name);
        mDogBreed.setText(breed);
        mDogAge.setText(age);
        mDogSex.setText(sex);
        mDogSize.setText(size);
        mDogDesc.setText(desc);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // add this Dog to DogHouse
                DogHouse doghouse = DogHouse.getInstance();
                doghouse.add(new Dog(0, name, breed, sex, age, size, desc));

            }
        });
    }
}
