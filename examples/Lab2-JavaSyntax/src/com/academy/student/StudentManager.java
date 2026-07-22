package com.academy.student;

import java.util.Scanner;

public class StudentManager {

    private static final int MAX_STUDENTS = 20;

    private final Student[] students = new Student[MAX_STUDENTS];
    private int studentCount = 0;
    private final Scanner scanner;

    public StudentManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("====================================");
        System.out.println("Student Management System");
        System.out.println("====================================");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("4. Average Marks");
        System.out.println("5. Exit");
        System.out.print("Enter Choice : ");
    }

    // ---- Option 1: Add a student (with validation) ----
    public void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student list is full. Cannot add more.");
            return;
        }

        int id = readPositiveInt("Student ID : ");
        if (findStudentIndex(id) != -1) {                 // reject duplicate IDs
            System.out.println("A student with ID " + id + " already exists.");
            return;
        }

        String name = readNonEmptyLine("Name : ");
        String course = readNonEmptyLine("Course : ");
        double marks = readValidMarks();

        students[studentCount] = new Student(id, name, course, marks);
        studentCount++;
        System.out.println("Student Added Successfully.");
    }

    // ---- Option 2: Display all students as a printf table ----
    public void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }

        String line = "----------------------------------------------------------";
        System.out.println(line);
        System.out.printf("%-8s %-20s %-15s %-8s%n", "ID", "Name", "Course", "Marks");
        System.out.println(line);
        for (int i = 0; i < studentCount; i++) {          // occupied slots only
            Student s = students[i];
            System.out.printf("%-8d %-20s %-15s %-8.2f%n",
                    s.getStudentId(), s.getName(), s.getCourse(), s.getMarks());
        }
        System.out.println(line);
    }

    // ---- Option 3: Search by ID ----
    public void searchStudent() {
        if (studentCount == 0) {
            System.out.println("No students to search.");
            return;
        }

        int id = readPositiveInt("Enter Student ID : ");
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student Not Found.");
        } else {
            students[index].display();
        }
    }

    // ---- Option 4: Average marks over occupied slots ----
    public void calculateAverage() {
        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        double total = 0;
        for (int i = 0; i < studentCount; i++) {
            total += students[i].getMarks();
        }
        double average = total / studentCount;            // divide by count, not MAX
        System.out.printf("Average Marks : %.2f%n", average);
    }

    // ---- Helpers ----
    private int findStudentIndex(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == id) {
                return i;
            }
        }
        return -1;
    }

    private int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Please enter a positive number.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private String readNonEmptyLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private double readValidMarks() {
        while (true) {
            System.out.print("Marks : ");
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value >= 0 && value <= 100) {
                    return value;
                }
                System.out.println("Marks must be between 0 and 100.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}