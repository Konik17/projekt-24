
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz operację (1-3):");
        System.out.println("1. a/b * c");
        System.out.println("2. Sprawdź czy trójkąt ABC jest prostokątny");
        System.out.println("3. (√c + √(1/b)) * c²");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("Podaj a:");
                double a = scanner.nextDouble();
                System.out.println("Podaj b:");
                double b = scanner.nextDouble();
                System.out.println("Podaj c:");
                double c = scanner.nextDouble();
                
                if (b == 0) {
                    System.out.println("Nie można dzielić przez zero!");
                } else {
                    double result = (a/b) * c;
                    System.out.println("Wynik: " + result);
                }
                break;
                
            case 2:
                System.out.println("Podaj bok a:");
                double side1 = scanner.nextDouble();
                System.out.println("Podaj bok b:");
                double side2 = scanner.nextDouble();
                System.out.println("Podaj bok c:");
                double side3 = scanner.nextDouble();
                
                boolean isPythagorean = checkPythagorean(side1, side2, side3);
                System.out.println(isPythagorean ? 
                    "Trójkąt jest prostokątny" : 
                    "Trójkąt nie jest prostokątny");
                break;
                
            case 3:
                System.out.println("Podaj b:");
                double bVal = scanner.nextDouble();
                System.out.println("Podaj c:");
                double cVal = scanner.nextDouble();
                
                if (bVal == 0) {
                    System.out.println("Nie można dzielić przez zero!");
                } else if (cVal < 0 || (1/bVal) < 0) {
                    System.out.println("Nie można pierwiastkować liczby ujemnej!");
                } else {
                    double result = (Math.sqrt(cVal) + Math.sqrt(1/bVal)) * (cVal * cVal);
                    System.out.println("Wynik: " + result);
                }
                break;
                
            default:
                System.out.println("Nieprawidłowy wybór!");
        }
        
        scanner.close();
    }
    
    private static boolean checkPythagorean(double a, double b, double c) {
        // Sortujemy boki, aby największy był c
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        
        // Sprawdzamy twierdzenie Pitagorasa
        return Math.abs((sides[0] * sides[0] + sides[1] * sides[1]) - 
                       (sides[2] * sides[2])) < 0.0001; // dla dokładności obliczeń
    }
}
