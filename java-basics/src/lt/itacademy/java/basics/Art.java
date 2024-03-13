package lt.itacademy.java.basics;

import java.util.Scanner;

public class Art {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

            for (int i = 0; i < input; i++) {
                for (int j = 0; j < input - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= 2 * i; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }

        for (int j = 0; j <= input - 1; j++) {
            System.out.print(" ");
        }

        System.out.print("#");
    }
}
