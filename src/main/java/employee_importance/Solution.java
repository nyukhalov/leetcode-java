package employee_importance;

import java.util.*;

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

// https://leetcode.com/problems/employee-importance/description/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> m = new HashMap<>();
        for (Employee e: employees) {
            m.put(e.id, e);
        }
        return getTotalEmployeeImportance(m, id);
    }

    private int getTotalEmployeeImportance(Map<Integer, Employee> m, int id) {
        int importance = 0;
        Employee e = m.get(id);
        importance += e.importance;
        for (int sId: e.subordinates) {
            importance += getTotalEmployeeImportance(m, sId);
        }
        return importance;
    }
}
