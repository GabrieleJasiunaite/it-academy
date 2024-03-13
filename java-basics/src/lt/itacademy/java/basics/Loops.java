package lt.itacademy.java.basics;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        daysToHoursAndMinutesForLoop(365);
        daysToHoursAndMinutesWhileLoop(365);

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        factorial(input);
    }

    private static void daysToHoursAndMinutesForLoop(int days) {
        int hours = 0;
        int minutes = 0;

        for(int i = days; i > 0; i--){
            hours += 24;
            minutes += 1440;
        }

        System.out.println("There are " + hours + " hours or " + minutes + " minutes in one year.");
    }

    private static void daysToHoursAndMinutesWhileLoop(int days) {
        int hours = 0;
        int minutes = 0;

        while(days > 0){
            hours += 24;
            minutes += 1440;
            days--;
        }

        System.out.println("There are " + hours + " hours or " + minutes + " minutes in one year.");
    }

    private static void factorial(int num) {
        int result = num;
        for(int i = num - 1; i > 1; i--){
            result *= i;
        }

        System.out.println("Factorial of number " + num + " is " + result + ".");
    }
}
