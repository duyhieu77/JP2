import Entity.Department;
import Entity.Employee;
import Entity.Gender;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Department> departments = new ArrayList<Department>();
        List<Employee> employees = new ArrayList<>();

        departments.add(new Department(1,"HR","HR"));
        departments.add(new Department(2,"IT","IT"));
        Map<String, Long> countEmployee = new HashMap<>();

        employees.add(new Employee(1, "Lo Van Hieu", departments.get(0), Gender.Male, LocalDateTime.of(1988, 8, 20, 7, 25)));
        employees.add(new Employee(2,"nguyen van ha",departments.get(1), Gender.Female, LocalDateTime.of(1977, 3, 20, 12, 19)));
        employees.add(new Employee(3,"dat nguyen",departments.get(1), Gender.Male, LocalDateTime.of(2000, 10, 23, 8, 45)));
        employees.add(new Employee(4,"dai thu",departments.get(0), Gender.Female, LocalDateTime.of(1999, 6, 16, 2, 20)));
        employees.add(new Employee(5,"tran thi dat",departments.get(0), Gender.Male, LocalDateTime.of(2005, 10, 4, 10, 8)));

        Month currentMonth = LocalDateTime.now().getMonth();

        Map<String, Long> countMaleEmployee = employees.stream()
                .filter(employee -> employee.getGender() == Gender.Male)
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getName(), Collectors.counting()));
        System.out.println("Employee Male in department: " + countMaleEmployee);

        Map<String, List<Employee>> birthdayMaleEmployees = employees.stream()
                .filter(employee -> employee.getDoB().getMonth() == currentMonth)
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getName()));

        System.out.println("Employee have birthday in this month:");
        birthdayMaleEmployees.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            empList.forEach(emp -> System.out.println(" Employee: " + emp.getName()));
        });

        //count total employee for each departmeant(name)
        //hr=2 , it=1
        // way1: using count()return long datatype


//        departments.stream().forEach(department -> {
//        long totalEmp = employees.stream()
//                    .filter(emp ->department.getId()==emp.getDepartment().getId())
//                    .collect(Collectors.toSet())
//                    .stream().count();
//        countEmployee.put(department.getCode(),totalEmp);
//        });
//        System.out.println(countEmployee);
//
//        //getOrDefault(base on Count() must be unique,0) + 1; iterator in MapEntry
//        //way2

//        departments.forEach(d -> {
//            employees.stream()
//                    .filter(emp ->emp .getDepartment().getId()==d.getId())
//                    .map(employee -> {
//                        return countEmployee.put(d.getCode(),countEmployee.getOrDefault(d.getCode(),0L)+1);
//                    });
//        });
//        System.out.println(countEmployee);
//
//        //way3 using Set<Object> vs size() convert dataType to Long

//        departments.stream().forEach(department -> {
//            Set<Employee> employeesSet = employees.stream()
//                    .filter(employee -> employee.getDepartment().getId()==department.getId())
//                    .collect(Collectors.toSet());
//           countEmployee.put(department.getCode(),(long)employeesSet.size());
//        });
//        System.out.println(countEmployee);
    }
}