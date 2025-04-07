import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.toList;

/**
 * @author avinash
 * Collectors.teeing() method is useful when we want to simultaneously
 * process a stream in two different ways and then combine their results
 */
public class StreamsExample {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee(1, "A", 100, "a@gmail.com"),
                new Employee(2, "B", 200, "b@gmail.com"),
                new Employee(3, "C", 350, "c@gmail.com"),
                new Employee(4, "D", 400, "d@gmail.com"),
                new Employee(5, "E", 200, "e@gmail.com"));

        HashMap<String, Employee> result = employeeList.stream().collect(
                Collectors.teeing(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        Collectors.minBy(Comparator.comparing(Employee::getSalary)),
                        (e1, e2) -> {
                            HashMap<String, Employee> map = new HashMap();
                            map.put("MAX", e1.get());
                            map.put("MIN", e2.get());
                            return map;
                        })
        );

        System.out.println("Group different value using teeing method = " + result + "\n");

        HashMap<String, Object> resultTwo = employeeList.stream().collect(
                Collectors.teeing(
                        filtering(e -> e.getSalary() > 200, Collectors.toList()),
                        filtering(e -> e.getSalary() > 200, Collectors.counting()),
                        (list, count) -> {
                            HashMap<String, Object> map = new HashMap();
                            map.put("list", list);
                            map.put("count", count);
                            return map;
                        }
                ));

        System.out.println("List of values with Count using teeing method = " + resultTwo + "\n");

        Map<String, List<Employee>> resultThree = employeeList.stream()
                .collect(Collectors.teeing(
                        filtering(e -> e.getSalary() % 2 == 0, toList()),
                        filtering(e -> e.getSalary() % 2 != 0, toList()),
                        (evenList, oddList) -> {
                            Map<String, List<Employee>> group = new HashMap<>();
                            group.put("Even", evenList);
                            group.put("Odd", oddList);
                            return group;
                        }
                ));

        System.out.println("Group even and odd Salary Employees = " + resultThree + "\n");
    }
}
