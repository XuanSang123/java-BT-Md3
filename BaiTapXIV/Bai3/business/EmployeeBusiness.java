package BaiTapXIV.Bai3.business;

import BaiTapXIV.Bai3.entity.Department;
import BaiTapXIV.Bai3.entity.Employee;
import  static BaiTapXIV.Bai3.business.DepartmentBusiness.departments;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeBusiness implements IEmployeeDesign{
    public static List<Employee> employees = new ArrayList<>();


    @Override
    public int calEmployeeAvg() {
        return employees.size()/departments.size();
    }

    @Override
    public Set<Map.Entry<Department, Integer>> mostCrowded() {
        // B1 : input : phòng ban, nhân viên
        // Tính số lượng nhân viên của mỗi phòng
        // Phân loại các nhân viên theo phòng ban
        Map<Department, Integer> map = new HashMap<>();

        for (Employee e: employees){
            if (map.containsKey(e.getDepartment())){
                // có tồn tại trong map
                map.put(e.getDepartment(), map.get(e.getDepartment())+1);
            }else {
                // chưa tồn tại
                map.put(e.getDepartment(),1);
            }
        }

        // sắp xếp và giới hạn 5 bản ghi
       return map
               .entrySet() // trả về 1 set Các Entry
               .stream() // mở Stream để duyệt
               .sorted((o1, o2) ->o2.getValue().compareTo(o1.getValue())) // sắp xê theo value giảm dân
               .limit(5) // giới hạn 5 bản ghi
               .collect(Collectors.toSet()); // đóng gói các phần tử trong stream thành 1 Set

    }
    @Override
    public Employee manageMostEmploy() {
       // Người quản lí nhiều nhân viên nhất
        Map<Employee, Integer> map = new HashMap<>();

        for (Employee e: employees){
            if (map.containsKey(e.getManager())){
                // có tồn tại trong map
               map.put(e.getManager(), map.get(e.getManager())+1);
            }else {
                // chưa tồn tại
                map.put(e.getManager(),1);
            }
        }
        Map.Entry<Employee,Integer> entry = map.entrySet().stream()
                .min((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .orElse(null);
        if (entry!=null){
            return entry.getKey();
        }
        return null;
    }

    @Override
    public List<Employee> employeeAgeMax() {
        // danh sach 5 người cao tuổi nhất
        return employees.stream().sorted(Comparator.comparing(Employee::getBirthday))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> employeeSalaryMax() {
        return Collections.emptyList();
    }

    @Override
    public boolean existByEmployeeId(String depId) {
        for(Employee employee : employees){
            if(employee.getEmployeeId().equals(depId)) return true;
        }
        return false;
    }

    @Override
    public boolean create(Employee employee) {
        employees.add(employee);
        return true;
    }

    @Override
    public void update(Employee employee) {
        int index = employees.indexOf(findById(employee.getEmployeeId()));
        if(index != -1) {
            employees.set(index, employee);
        }
    }

    @Override
    public void deleteById(String id) {
        employees.removeIf(employee -> employee.getEmployeeId().equals(id));
    }

    @Override
    public Employee findById(String id) {
        for(Employee employee : employees){
            if(employee.getEmployeeId().equals(id)) return employee;
        }
        return null;
    }
    @Override
    public int getAvgEmployeesPerDepartment() {
        return EmployeeBusiness.employees.size()/DepartmentBusiness.departments.size();
    }

    @Override
    public List<Department> findTop5DepartmentsMostCrowded() {
        return DepartmentBusiness.departments.stream()
                .sorted((o1, o2) -> o2.getTotalMembers()-o1.getTotalMembers())
                .limit(5)
                .toList();
    }

    @Override
    public Optional<Employee> findManagerMostEmployees() {
        return employees.stream().min((o1,o2)->calTotalEmployeeByManager(o2) - calTotalEmployeeByManager(o1));
    }
    private int calTotalEmployeeByManager(Employee manager) {
        return employees.stream().mapToInt(em -> (em.getManager()!=null&& em.getManager().equals(manager))?1:0).sum();
    }

    @Override
    public List<Employee> findTop5OldestEmployees() {
        return employees.stream().sorted(Comparator.comparing(Employee::getBirthday)).limit(5).toList();
    }

    @Override
    public List<Employee> findTop5HighestSalary() {
        return employees.stream().sorted((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary())).limit(5).toList();
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
