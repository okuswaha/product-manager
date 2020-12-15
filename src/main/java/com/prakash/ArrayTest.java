package com.prakash;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        String[] groceries = {"Tomato sauce","Mustard","Barbecue sauce","Red-wine vinegar","Salsa"};
        System.out.println(Arrays.toString(groceries));

        System.out.println(Arrays.binarySearch(groceries,"Salsa"));
        groceries[Arrays.binarySearch(groceries,"Salsa")] = "";
    }
}
