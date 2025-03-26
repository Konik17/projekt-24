
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz (1-3):");
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
                    double wynik = (a/b) * c;
                    System.out.println("Wynik: " + wynik);
                }
                break;
                
            case 2:
                System.out.println("Podaj bok a:");
                double bok1 = scanner.nextDouble();
                System.out.println("Podaj bok b:");
                double bok2 = scanner.nextDouble();
                System.out.println("Podaj bok c:");
                double bok3 = scanner.nextDouble();
                
                boolean isPythagorean = checkPythagorean(bok1, bok2, bok3);
                System.out.println(isPythagorean ? 
                    "Trójkąt jest prostokątny" : 
                    "Trójkąt nie jest prostokątny");
                break;
                
            case 3:
                System.out.println("Podaj b:");
                double bwartosc = scanner.nextDouble();
                System.out.println("Podaj c:");
                double cwartosc = scanner.nextDouble();
                
                if (bwartosc == 0) {
                    System.out.println("Nie można dzielić przez zero!");
                } else if (cwartosc < 0 || (1/bwartosc) < 0) {
                    System.out.println("Nie można pierwiastkować liczby ujemnej!");
                } else {
                    double wynik = (Math.sqrt(cwartosc) + Math.sqrt(1/bwartosc)) * (cwartosc * cwartosc);
                    System.out.println("Wynik: " + wynik);
                }
                break;
                
            default:
                System.out.println("Nieprawidłowy wybór!");
        }
        
        scanner.close();
    }
    
    private static boolean checkPythagorean(double a, double b, double c) {
        
        double[] boki = {a, b, c};
        java.util.Arrays.sort(boki);
        
        
        return Math.abs((boki[0] * boki[0] + boki[1] * boki[1]) - 
                       (boki[2] * boki[2])) < 0.0001; //3
      
    }
}
