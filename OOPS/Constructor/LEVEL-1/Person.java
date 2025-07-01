public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person another) {
        this.name = another.name;
        this.age = another.age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
