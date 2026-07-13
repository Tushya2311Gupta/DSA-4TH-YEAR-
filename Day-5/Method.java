class Student {
    String name;
    int age;
    void setData(String n, int a) {
        name = n;
        age = a;
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
public class Method {
    public static void main(String[] args) {
        Student s1 = new Student();   
        s1.setData("Parth", 20);      
        s1.display();                 
    }
}