class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "GLA University";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months, Fee: ₹" + fee + ", Institute: " + instituteName);
    }

    static void updateInstituteName(String name) {
        instituteName = name;
    }
}
