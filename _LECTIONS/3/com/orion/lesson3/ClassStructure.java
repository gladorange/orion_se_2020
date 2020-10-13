package com.orion.lesson3;

public class ClassStructure {

    static int staticVariable = 42;
    int regularField = 12;

    public ClassStructure(int regularField) {
        this.regularField = regularField;
    }

    public static int getStaticVariable() {
        return staticVariable;
    }

    public static void setStaticVariable(int staticVariable) {
        ClassStructure.staticVariable = staticVariable;
    }

    public int getRegularField() {
        return regularField;
    }

    public void setRegularField(int regularField) {
        this.regularField = regularField;
    }


}
