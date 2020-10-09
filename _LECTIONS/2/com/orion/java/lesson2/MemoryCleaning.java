package com.orion.java.lesson2;

import java.util.ArrayList;

public class MemoryCleaning {

    public static void main(String[] args) {


        ArrayList l = new ArrayList(1_00_000);

        /// какой-то код

        l = null;

        // другой, l не используется
    }
}
