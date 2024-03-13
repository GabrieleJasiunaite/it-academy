package lt.itacademy.java.basics;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            Scanner scanner = new Scanner(System.in);
            String[] input = scanner.nextLine().split(" ");
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            switch (input[0]) {
                case "Rectangle":
                    Rectangle(a, b);
                    break;
                case "Triangle":
                    Triangle(a, b);
                    break;
                case "Square":
                    Square(a);
                    break;
                default:
                    System.out.println("Invalid parameters");
            }

            System.out.println("Continue? Y/N");
            if (scanner.nextLine().equals("N")) {
                running = false;
            }
        }
    }

    private static void Rectangle(int a, int b) {
        if (a <= 0 || b <= 0) {
            System.out.println("Rectangle edge length can't be 0");
        } else {
            System.out.println("Rectangle perimeter is " + (a + b) * 2 + " and area is " + a * b);
        }
    }

    private static void Square(int a) {
        if (a <= 0) {
            System.out.println("Square edge length can't be 0");
        } else {
            System.out.println("Square perimeter is " + a * 4 + " and area is " + a * a);
        }
    }

    private static void Triangle(int a, int b) {
        if (a <= 0 || b <= 0) {
            System.out.println("Triangle edge length can't be 0");
        } else {
            double c = Math.sqrt(a * a + b * b);
            System.out.println("Triangle perimeter is " + a + b + c + " and area is " + (a * b / 2));
        }
    }
}
