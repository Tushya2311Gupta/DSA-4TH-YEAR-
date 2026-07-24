import java.util.Scanner;

public class sandwich {
    public static int countStudents(int[] students, int[] sandwiches) {
    int circleCount = 0;
    int squareCount = 0;
    for (int student : students) {
        if (student == 0) {
            circleCount++;
        } else {
            squareCount++;
        }
    }
    for (int sandwich : sandwiches) {
        if (sandwich == 0) {
            if (circleCount > 0) {
                circleCount--; 
            } else {
                break;
            }
        } else {
            if (squareCount > 0) {
                squareCount--;
            } else {
                break;
            }
        }
    }
    return circleCount + squareCount;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] students = new int[n];
        System.out.println("Enter student preferences (0 for circle, 1 for square):");
        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }
        System.out.print("Enter number of sandwiches: ");
        int m = sc.nextInt();
        int[] sandwiches = new int[m];
        System.out.println("Enter sandwich stack order (0 for circle, 1 for square):");
        for (int i = 0; i < m; i++) {
            sandwiches[i] = sc.nextInt();
        }
        sc.close();
        int result = countStudents(students, sandwiches);
        System.out.println("Students unable to eat: " + result);
    }
}
