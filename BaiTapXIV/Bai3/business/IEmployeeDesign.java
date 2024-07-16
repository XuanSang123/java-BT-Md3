package BaiTapXIV.Bai3.business;

import BaiTapXIV.Bai3.entity.Department;
import BaiTapXIV.Bai3.entity.Employee;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface IEmployeeDesign extends IGenericDesign<Employee, String> {
    //    Thống kê số lượng nhân viên trung bình của mỗi phòng
    int calEmployeeAvg();

    // Tìm ra 5 phòng có số lượng nhân viên đông nhất
    Set<Map.Entry<Department, Integer>> mostCrowded();

    // Tìm ra người quản lý nhiều nhân viên nhất
    Employee manageMostEmploy();

    //Tìm ra 5 nhân viên có tuổi cao nhất công ty
    List<Employee> employeeAgeMax();

    //Tìm ra 5 nhân viên hưởng lương cao nhất
    List<Employee> employeeSalaryMax();

    //
    boolean existByEmployeeId(String depId);
    //    Thống kê số lượng nhân viên trung bình của mỗi phòng
    int getAvgEmployeesPerDepartment();
    //    Tìm ra 5 phòng có số lượng nhân viên đông nhất
    List<Department> findTop5DepartmentsMostCrowded();
    //    Tìm ra người quản lý nhiều nhân viên nhất
    Optional<Employee> findManagerMostEmployees();
    //    Tìm ra 5 nhân viên có tuổi cao nhất công ty
    List<Employee> findTop5OldestEmployees();
    //    Tìm ra 5 nhân viên hưởng lương cao nhất
    List<Employee> findTop5HighestSalary();
}
