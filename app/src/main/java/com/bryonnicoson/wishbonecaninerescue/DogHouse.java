package com.bryonnicoson.wishbonecaninerescue;

import java.util.ArrayList;

/**
 * Created by bryon on 7/13/16.
 */
public class DogHouse extends ArrayList<Dog> {

    private static DogHouse mDogHouse = new DogHouse();

    private DogHouse() {}

    public static DogHouse getInstance() {
        return mDogHouse;
    }

}
