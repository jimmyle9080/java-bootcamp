package com.academy.analytics;

import java.util.ArrayList;
import java.util.List;

public final class EmployeeData {

    private EmployeeData() {
    }

    public static List<Employee> createSampleEmployees() {
        List<Employee> employees = new ArrayList<>();
        // IT
        employees.add(new Employee("E001", "John Smith",       "IT",        165000, 12, 5, true));
        employees.add(new Employee("E002", "Alice Johnson",    "Finance",   152000, 10, 5, true));
        employees.add(new Employee("E003", "David Lee",        "IT",        149000, 11, 5, true));
        employees.add(new Employee("E004", "Sarah Brown",      "IT",        141000,  9, 4, true));
        employees.add(new Employee("E005", "Michael Chen",     "Finance",   138000,  8, 4, true));
        employees.add(new Employee("E006", "Sophia Jackson",   "IT",         96000,  7, 4, true));
        employees.add(new Employee("E007", "Ryan Cooper",      "IT",        118000,  6, 3, true));
        // Finance
        employees.add(new Employee("E008", "Emma Wilson",      "Finance",   125000,  9, 4, true));
        employees.add(new Employee("E009", "James Martin",     "Finance",   102000,  6, 3, true));
        employees.add(new Employee("E010", "Olivia Davis",     "Finance",    80000,  4, 2, true));
        // HR
        employees.add(new Employee("E011", "Liam Garcia",      "HR",         48000,  2, 2, true));
        employees.add(new Employee("E012", "Grace Miller",     "HR",        112000,  7, 4, true));
        employees.add(new Employee("E013", "Noah Rodriguez",   "HR",         90000,  5, 3, true));
        employees.add(new Employee("E014", "Ava Martinez",     "HR",         72000,  4, 3, true));
        employees.add(new Employee("E015", "Ethan Hernandez",  "HR",         60000,  3, 2, false));
        // Sales
        employees.add(new Employee("E016", "Mia Lopez",        "Sales",     130000,  8, 4, true));
        employees.add(new Employee("E017", "Lucas Gonzalez",   "Sales",     100000,  6, 3, true));
        employees.add(new Employee("E018", "Isabella Perez",   "Sales",      85000,  5, 3, true));
        employees.add(new Employee("E019", "Mason Sanchez",    "Sales",      68000,  3, 2, true));
        employees.add(new Employee("E020", "Charlotte Rivera", "Sales",      55000,  2, 2, true));
        // Marketing
        employees.add(new Employee("E021", "Amelia Torres",    "Marketing", 122000,  7, 4, true));
        employees.add(new Employee("E022", "Benjamin Flores",  "Marketing",  98000,  5, 3, true));
        employees.add(new Employee("E023", "Harper Nguyen",    "Marketing",  82000,  4, 3, true));
        employees.add(new Employee("E024", "Elijah Green",     "Marketing",  66000,  3, 2, true));
        employees.add(new Employee("E025", "Evelyn Adams",     "Marketing",  63000,  2, 1, false));
        return employees;
    }
}