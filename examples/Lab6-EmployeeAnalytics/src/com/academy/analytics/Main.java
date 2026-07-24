package com.academy.analytics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EmployeeService employeeService =
                new EmployeeService(EmployeeData.createSampleEmployees());
        ReportService reportService = new ReportService(employeeService);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            String choiceInput = scanner.nextLine().trim();
            if (choiceInput.isEmpty()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.println("----------------------------------");
            switch (choice) {
                case 1 -> employeeService.displayAllEmployees();
                case 2 -> reportService.displayEmployeesByDepartment();
                case 3 -> reportService.displaySalaryReport();
                case 4 -> reportService.displayTopPerformers();
                case 5 -> reportService.displayHighestSalary();
                case 6 -> reportService.displayDepartmentStatistics();
                case 7 -> reportService.displayActiveEmployees();
                case 8 -> reportService.displayDashboard();
                case 9 -> {
                    System.out.println("Thank You");
                    scanner.close();
                    return;
                }
                case 10 -> employeeService.demonstrateLambdas();
                case 11 -> employeeService.demonstrateFunctionalInterfaces();
                case 12 -> employeeService.demonstrateStreamSources();
                case 13 -> {
                    employeeService.displayHighSalaryEmployees();
                    System.out.println();
                    employeeService.displayItEmployees();
                }
                case 14 -> employeeService.displayFilteredItTopPerformers();
                case 15 -> employeeService.demonstrateMapping();
                case 16 -> employeeService.demonstrateSorting();
                case 17 -> {
                    employeeService.displayDistinctDepartments();
                    System.out.println();
                    employeeService.displayTopAndNextSalaries();
                }
                case 18 -> employeeService.displayCounts();
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    private static void displayMenu() {
        System.out.println("=====================================");
        System.out.println("Employee Analytics");
        System.out.println("=====================================");
        System.out.println("1 Display Employees");
        System.out.println("2 Employees By Department");
        System.out.println("3 Salary Report");
        System.out.println("4 Top Performers");
        System.out.println("5 Highest Salary");
        System.out.println("6 Department Statistics");
        System.out.println("7 Active Employees");
        System.out.println("8 Dashboard");
        System.out.println("9 Exit");
        System.out.println("10 Lambda Expressions");
        System.out.println("11 Functional Interfaces");
        System.out.println("12 Stream Sources");
        System.out.println("13 Filters (single)");
        System.out.println("14 Chained Filters");
        System.out.println("15 Mapping");
        System.out.println("16 Sorting");
        System.out.println("17 Distinct / Limit / Skip");
        System.out.println("18 Counts");
        System.out.print("Choice : ");
    }
}