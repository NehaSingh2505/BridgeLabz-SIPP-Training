class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
