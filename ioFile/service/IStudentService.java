package BaiTapXVIII.ioFile.service;

import BaiTapXVIII.ioFile.model.Student;
import java.util.List;

public interface IStudentService extends IGenericService<Student, Integer> {
    int getNewId();
    List<Student> findByName(String name);
}
