package maxfomtaskeleven.thirdtask;

import jdk.jshell.execution.Util;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = Analytic.createStudents();
        System.out.println(students);

        Analytic.whoVisitMathematicalAnalysis(students);

        Analytic.AttendanceStatistics(students);

        Analytic.mostAttendedLectures(students);

        Analytic.mostVisitedStudents(students, LocalDate.of(2008, 8, 8));

        Analytic.lecturesStatitstics(students);

    }

}
