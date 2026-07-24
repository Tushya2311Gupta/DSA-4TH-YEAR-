import java.util.Scanner;

public class sandwich {
    public static int countStudents(int[] students, int[] sandwiches) {
    int circleCount = 0;
    int squareCount = 0;
    
    // Count how many students prefer each type of sandwich
    for (int student : students) {
        if (student == 0) {
            circleCount++;
        } else {
            squareCount++;
        }
    }
    
    // Iterate through the sandwiches stack
    for (int sandwich : sandwiches) {
        if (sandwich == 0) {
            if (circleCount > 0) {
                circleCount--; // A student eats the circular sandwich
            } else {
                break; // No one left wants this circular sandwich, queue halts
            }
        } else {
            if (squareCount > 0) {
                squareCount--; // A student eats the square sandwich
            } else {
                break; // No one left wants this square sandwich, queue halts
            }
        }
    }
    
    // The number of students unable to eat
    return circleCount + squareCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] students = new int[n];
        System.out.println("Enter student preferences (0 for circle, 1 for square):");
        for (int i = 0; i < n; i++) {
            students[i] = scanner.nextInt();
        }

        System.out.print("Enter number of sandwiches: ");
        int m = scanner.nextInt();
        int[] sandwiches = new int[m];
        System.out.println("Enter sandwich stack order (0 for circle, 1 for square):");
        for (int i = 0; i < m; i++) {
            sandwiches[i] = scanner.nextInt();
        }

        scanner.close();
        int result = countStudents(students, sandwiches);
        System.out.println("Students unable to eat: " + result);
    }
}
