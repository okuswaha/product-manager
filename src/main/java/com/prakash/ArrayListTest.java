package com.prakash;

import jersey.repackaged.com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class ArrayListTest {
    public static void main(String[] args) {
        String[] groceries = {"Tomato sauce","Mustard","Barbecue sauce","Red-wine vinegar","Salsa"};
        ArrayList<String> groceriesList = Lists.newArrayList(groceries);
        System.out.println("=====================Before===========================");
        printAList(groceriesList);
        groceriesList.remove("Salsa");
        System.out.println("=====================After===========================");
        printAList(groceriesList);
        LinkedList<String> linkedList = new LinkedList<>();





    }

    private static void printAList(ArrayList<String> groceriesList) {
        for (String s: groceriesList) {
            System.out.println(s);
        }
    }
}
