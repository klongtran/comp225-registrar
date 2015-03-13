package edu.macalester.registrar;

/**
 * A simple scenario to exercise the various registrar model objects.
 */
public class RegistrarTest {
    public static void main(String[] args) {
        // Example students

        Student sally = new Student();
        sally.setName("Sally");

        Student fred = new Student();
        fred.setName("Fred");

        Student tom = new Student();
        tom.setName("Tom");

        // Example courses

        Course c1 = new Course();
        c1.setCatalogNumber("COMP 225");
        c1.setTitle("Software Fun Fun");

        Course c2 = new Course();
        c2.setCatalogNumber("MATH 6");
        c2.setTitle("All About the Number Six");

        System.out.println("------ Enrolling Sally in two courses ------");

        sally.enrollIn(c1);
        sally.enrollIn(c2);

        printSchedule(sally);
        printSchedule(fred);

        printEnrollment(c1);
        printEnrollment(c2);

        System.out.println("------ Enrolling Fred in two courses ------");

        fred.enrollIn(c1);
        fred.enrollIn(c2);

        printSchedule(fred);
        printEnrollment(c1);
        printEnrollment(c2);

        System.out.println("------ Re-enrolling Sally has no effect ------");

        sally.enrollIn(c1);

        printSchedule(sally);
        printEnrollment(c1);

        System.out.println("------ Try to enroll Tom in both courses ------");

        tom.enrollIn(c1);
        tom.enrollIn(c2);

        printSchedule(tom); // this should be empty

        printEnrollment(c1); // both Sally and Fred should still be here
        printEnrollment(c2); // both Sally and Fred should still be here

        printWaitList(c1); // Tom should be here
        printWaitList(c2); // Tom should be here

        System.out.println("------ Sally drops one course, Tom is enrolled ------");

        sally.drop(c1);
        printEnrollment(c1); // Tom should now be in the class
        printWaitList(c1);   // this should be empty

        sally.drop(c2);
        printEnrollment(c2); // Tom should now be in the class
        printWaitList(c2);   // this should now be empty
    }

    private static void printSchedule(Student student) {
        System.out.println("Student name: " + student.getName());
        System.out.println("Courses (" + student.getCourses().size() + ")");
        for(Course course : student.getCourses())
            System.out.println("    "
                + course.getCatalogNumber() + ": "
                + course.getTitle());
        System.out.println();
    }

    private static void printEnrollment(Course course) {
        System.out.println(course.getCatalogNumber() + ": " + course.getTitle());
        System.out.println("Students enrolled (" + course.getStudents().size() + ")");
        for(Student student : course.getStudents())
            System.out.println("    " + student.getName());
        System.out.println();
    }

    private static void printWaitList(Course course) {
        System.out.println(course.getCatalogNumber() + ": " + course.getTitle());
        System.out.println("Students wait-listed (" + course.getWaitList().size() + ")");
        for(Student student : course.getWaitList())
            System.out.println("    " + student.getName());
        System.out.println();
    }
}
