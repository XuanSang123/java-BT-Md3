package BaiTapXIV.Bai3.business;


import BaiTapXIV.Bai3.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentBusiness implements IDepartmentDesign {
    public static List<Department> departments = new ArrayList<>();

    @Override
    public boolean create(Department department) {
        departments.add(department);
        return true;

    }

    @Override
    public void update(Department department) {
        int index = departments.indexOf(findById(department.getDepartmentId()));
        if (index != -1) {
            departments.set(index, department);
        } else {
        }
    }

    @Override
    public void deleteById(String id) {
//        return departments.remove(findById(id));
        departments.removeIf(department -> department.getDepartmentId().equals(id));
    }

    @Override
    public Department findById(String id) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(id)) return department;
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        return departments;
    }

}