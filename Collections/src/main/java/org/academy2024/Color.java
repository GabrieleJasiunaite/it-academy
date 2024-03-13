package org.academy2024;

public enum Color {
    RED("\u001B[31m"),
    GREEN("\u001B[32m");

    private Color(String color) {
        this.color = color;
    }

    private String color;

    public String getColor() {
        return color;
    }
}
