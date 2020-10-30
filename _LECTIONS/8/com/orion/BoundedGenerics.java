package com.orion;

import java.util.ArrayList;
import java.util.List;

public class BoundedGenerics {


    public static void main(String[] args) {


        List<Number> listNumber;

        listNumber = new ArrayList<Number>();
        //listNumber = new ArrayList<Integer>();// не работает, т.к. <Integer> е являеется налсдеником <Number>


        List<? extends Number> listExtendsNumber;


        listExtendsNumber = new ArrayList<Number>();
        listExtendsNumber = new ArrayList<Integer>();



        List<? super Number> listSuperNumber;

        listSuperNumber = new ArrayList<Number>();
      //  listSuperNumber = new ArrayList<Integer>(); не работает Т.к. super обращает иерархие наследования в параметризованной части.
        listSuperNumber = new ArrayList<Object>();


    }
}




