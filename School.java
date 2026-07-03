class School {
    String schoolName = "ABC School";

    class Student {
        String studentName = "Arun";

        void display() {
            System.out.println("School : " + schoolName);
            System.out.println("Student : " + studentName);
        }
    }

    public static void main(String[] args) {
        School school = new School();
        School.Student student = school.new Student();
        student.display();
    }
}