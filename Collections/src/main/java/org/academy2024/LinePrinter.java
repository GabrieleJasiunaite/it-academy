package org.academy2024;

public class LinePrinter {

    public static void print(String printStr) {
        resetColor();
        System.out.println(printStr);
    }

    public static void print(Color color, String printStr) {
        System.out.println(color.getColor() + printStr);
    }

    public static void resetColor() {
        System.out.println("\u001B[0m");
    }
}
