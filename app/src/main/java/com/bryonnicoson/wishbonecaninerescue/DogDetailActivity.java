package com.bryonnicoson.wishbonecaninerescue;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DogDetailActivity extends AppCompatActivity {

    String name, breed, age, sex, size, desc;
    DatabaseHelper db;
    FloatingActionButton fab;
    int favorite;

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
        favorite = mainIntent.getIntExtra("FAVORITE", 0);

        mDogPhoto.setImageResource(mainIntent.getIntExtra("PHOTO", 0));
        mDogName.setText(name);
        mDogBreed.setText(breed);
        mDogAge.setText(age);
        mDogSex.setText(sex);
        mDogSize.setText(size);
        mDogDesc.setText(desc);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        setFabIcon(favorite);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = DatabaseHelper.getInstance(DogDetailActivity.this);
                db.toggleFavorite(name);
                if (favorite == 0) favorite = 1;
                if (favorite == 1) favorite = 0;
                setFabIcon(favorite);
            }
        });
    }
    public void setFabIcon(int favorite){

        if (favorite == 0) {
            fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.btn_star_big_off));
        } else {
            fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.btn_star_big_on));
        }
    }
}
