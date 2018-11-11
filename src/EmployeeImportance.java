import java.util.*;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (Employee e : employees) {
            map.put(e.id, e);
        }

        queue.add(id);

        int sum = 0;

        while (!queue.isEmpty()) {
            Employee e = map.get(queue.poll());
            sum += e.importance;
            queue.addAll(e.subordinates);
        }
        return sum;
    }
}
