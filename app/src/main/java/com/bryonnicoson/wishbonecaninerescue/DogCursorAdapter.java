package com.bryonnicoson.wishbonecaninerescue;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bryon on 7/11/16.
 */
public class DogCursorAdapter extends CursorAdapter {
    public DogCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.dog_card, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // dog_name
        TextView dogName = (TextView) view.findViewById(R.id.dog_name);
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        dogName.setText(name);

        // dog_photo : construct uri & convert to resource int before setting
        String uri = "@drawable/" + name.toLowerCase();
        ImageView dogPhoto = (ImageView) view.findViewById(R.id.dog_photo);
        dogPhoto.setImageResource(context.getResources().getIdentifier(uri, null, context.getPackageName()));

        // dog_breed
        TextView dogBreed = (TextView) view.findViewById(R.id.dog_breed);
        dogBreed.setText(cursor.getString(cursor.getColumnIndexOrThrow("breed")));

        // dog_sex
        TextView dogSex = (TextView) view.findViewById(R.id.dog_sex);
        dogSex.setText(cursor.getString(cursor.getColumnIndexOrThrow("sex")));

        // dog_age
        TextView dogAge = (TextView) view.findViewById(R.id.dog_age);
        dogAge.setText(cursor.getString(cursor.getColumnIndexOrThrow("age")));

        // dog_size
        TextView dogSize = (TextView) view.findViewById(R.id.dog_size);
        dogSize.setText(cursor.getString(cursor.getColumnIndexOrThrow("size")));
    }
}
