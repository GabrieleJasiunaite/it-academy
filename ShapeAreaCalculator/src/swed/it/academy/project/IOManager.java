package swed.it.academy.project;

import java.util.Scanner;

public class IOManager {
    private static int shapeChoice;
    private static double data1;
    private static double data2;
    private static boolean isRunning = true;

    static final Scanner scanner = new Scanner(System.in);

    public static int getShapeChoice() {
        return shapeChoice;
    }

    public static double getData1() {
        return data1;
    }

    public static double getData2() {
        return data2;
    }

    public static boolean getIsRunning() {
        return isRunning;
    }

    public static void chooseUsersShape() {
        System.out.println("Choose a shape: 1 - Square, 2 - Triangle, 3 - Circle");
            shapeChoice = scanner.nextInt();
    }

    public static void checkDataInput() throws UnknownShapeException {
        switch (shapeChoice) {
            case 1:
                System.out.println("Input the length of the square's edge");
                data1 = scanner.nextDouble();
                break;
            case 2:
                System.out.println("Input the length of the first edge of the triangle");
                data1 = scanner.nextDouble();
                System.out.println("Input the length of the second edge of the triangle");
                data2 = scanner.nextDouble();
                break;
            case 3:
                System.out.println("Input the radius length");
                data1 = scanner.nextDouble();
                break;
            default:
                scanner.close();
                throw new UnknownShapeException("There is no such shape");
        }
    }

    static void displayArea(String shapeArea) {
        System.out.println(shapeArea);
        System.out.println("------------------------");
    }

    static void chooseIfContinue() {
        System.out.println("Continue? Y/N");
        scanner.nextLine();
        String answer = scanner.nextLine();
        if (answer.equals("N")) {
            isRunning = false;
        }
    }

}
