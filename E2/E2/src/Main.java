import Entity.Department;
import Entity.Employee;
import Entity.Gender;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Department> departments = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        departments.add(new Department(1, "HR", "HR"));
        departments.add(new Department(2, "IT", "IT"));
        Map<String, Long> countEmployee = new HashMap<>();

        employees.add(new Employee(1, "Lo Van Hieu", departments.get(0), Gender.Male, LocalDateTime.of(1988, 8, 20, 7, 25)));
        employees.add(new Employee(2, "Nguyen Van Ha", departments.get(1), Gender.Female, LocalDateTime.of(1977, 3, 20, 12, 19)));
        employees.add(new Employee(3, "Dat Nguyen", departments.get(1), Gender.Male, LocalDateTime.of(2000, 10, 23, 8, 45)));
        employees.add(new Employee(4, "Dai Thu", departments.get(0), Gender.Female, LocalDateTime.of(1999, 6, 16, 2, 20)));
        employees.add(new Employee(5, "Tran Thi Dat", departments.get(0), Gender.Male, LocalDateTime.of(2005, 10, 4, 10, 8)));

        Month currentMonth = LocalDateTime.now().getMonth();

        Map<String, Long> countMaleEmployee = employees.stream()
                .filter(employee -> employee.getGender() == Gender.Male)
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getName(), Collectors.counting()));
        System.out.println("Male Employees in Department: " + countMaleEmployee);

        Map<String, List<Employee>> birthdayMaleEmployees = employees.stream()
                .filter(employee -> employee.getDoB().getMonth() == currentMonth)
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getName()));

        System.out.println("Employees with birthdays this month:");
        birthdayMaleEmployees.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            empList.forEach(emp -> System.out.println(" Employee: " + emp.getName()));
        });

        Map<String, Employee> resultSearch = searchByName(employees, "Dat");
        System.out.println("Search Results by Name:");
        resultSearch.forEach((name, emp) -> System.out.println("Name: " + name + ", Employee: " + emp.getName()));

        Map<String, Set<Employee>> groupedEmployees = groupByDepartment(employees);
        System.out.println("Grouped Employees by Department:");
        groupedEmployees.forEach((department, empSet) -> {
            System.out.println("Department: " + department);
            empSet.forEach(emp -> System.out.println(" Employee: " + emp.getName()));
        });

        Map<String, Long> countEmployees = countTotalEmployees(departments, employees);
        System.out.println("Total Employees for Each Department:");
        countEmployees.forEach((deptName, count) -> System.out.println("Department: " + deptName + ", Employee Count: " + count));
    }

    public static Map<String, Employee> searchByName(List<Employee> employees, String keyword) {
        return employees.stream()
                .filter(emp -> emp.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toMap(Employee::getName, emp -> emp));
    }

    public static Map<String, Set<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment().getName(), Collectors.toSet()));
    }

    public static Map<String, Long> countTotalEmployees(List<Department> departments, List<Employee> employees) {
        Map<String, Long> countMap = new HashMap<>();
        departments.forEach(department -> {
            long count = employees.stream()
                    .filter(emp -> emp.getDepartment().getId() == department.getId())
                    .count();
            countMap.put(department.getName(), count);
        });
        return countMap;
    }
}