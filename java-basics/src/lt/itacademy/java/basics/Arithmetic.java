package lt.itacademy.java.basics;

import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        System.out.println("Cube's volume: " + Math.pow(input, 3) + "cm3");
        System.out.println("Cube's perimeter " + input * 12 + "cm");

        scanner.nextLine();
        String[] feetAndInches = scanner.nextLine().split(" ");

        float feet = Float.parseFloat(feetAndInches[0]);
        int inches = Integer.parseInt(feetAndInches[1]);
        feetAndInchesToCm(feet, inches);
    }

    private static void feetAndInchesToCm(float feet, int inches) {
        float result = (feet * 12 + inches) * 2.54f;
        System.out.println(feet + " feet and " + inches + " inches = " + result + " cm");
    }
}
