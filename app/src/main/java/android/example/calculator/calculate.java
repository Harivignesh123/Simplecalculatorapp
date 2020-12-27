package android.example.calculator;

import java.util.ArrayList;

public class calculate {
    private float value1=0;
    boolean condition=true;
    int i=0;
    public String finalanswer(ArrayList<String> list) {
        condition = true;
        while (condition) {
            if (list.indexOf("√") == -1) {
                condition = false;
            } else {
                i = list.indexOf("√");
                value1 = (float) Math.sqrt(Float.parseFloat(list.get(i + 1)));
                list.remove(i + 1);
                list.remove(i);
                list.add(i, String.valueOf(value1));
            }
        }
        condition = true;
        while (condition) {
            if (list.indexOf("^") == -1) {
                condition = false;
            } else {
                i = list.indexOf("^");
                value1 = (float) Math.pow(Float.parseFloat(list.get(i - 1)),Float.parseFloat(list.get(i + 1)));
                list.remove(i + 1);
                list.remove(i);
                list.remove(i - 1);
                list.add(i - 1, String.valueOf(value1));
            }
        }

        condition = true;
        while (condition) {
            if (list.indexOf("÷") == -1) {
                condition = false;
            } else {
                i = list.indexOf("÷");
                value1 = Float.parseFloat(list.get(i - 1)) / Float.parseFloat(list.get(i + 1));
                list.remove(i + 1);
                list.remove(i);
                list.remove(i - 1);
                list.add(i - 1, String.valueOf(value1));
            }
        }
        condition = true;
        while (condition) {
            if (list.indexOf("×") == -1) {
                condition = false;
            } else {
                i = list.indexOf("×");
                value1 = Float.parseFloat(list.get(i - 1)) * Float.parseFloat(list.get(i + 1));
                list.remove(i + 1);
                list.remove(i);
                list.remove(i - 1);
                list.add(i - 1, String.valueOf(value1));
            }
        }
        condition = true;
        while (condition) {
            if (list.indexOf("+") == -1) {
                condition = false;
            } else {
                i = list.indexOf("+");
                value1 = Float.parseFloat(list.get(i - 1)) + Float.parseFloat(list.get(i + 1));
                list.remove(i + 1);
                list.remove(i);
                list.remove(i - 1);
                list.add(i - 1, String.valueOf(value1));
            }
        }
        condition = true;
        while (condition) {
            if (list.indexOf("-") == -1) {
                condition = false;

            } else {
                i = list.indexOf("-");
                value1 = Float.parseFloat(list.get(i - 1)) - Float.parseFloat(list.get(i + 1));
                list.remove(i + 1);
                list.remove(i);
                list.remove(i - 1);
                list.add(i-1,String.valueOf(value1));
            }
        }
        return list.get(0);
    }
}
