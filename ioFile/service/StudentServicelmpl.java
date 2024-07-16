package BaiTapXVIII.ioFile.service;

import BaiTapXVIII.ioFile.model.Student;
import BaiTapXVIII.ioFile.util.IOFile;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements IStudentService {
    private static List<Student> studentList;

    static {
        studentList = new IOFile<Student>().readFromFile(IOFile.STUDENT_PATH);

    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(Integer id) {
        for (Student s : studentList) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void save(Student student) {
        if (findById(student.getStudentId()) == null) {
            // theem moi
            student.setStudentId(getNewId());
            studentList.add(student);
        } else {
            // cap nhat
            studentList.set(studentList.indexOf(findById(student.getStudentId())), student);
        }
        new IOFile<Student>().writeToFile(IOFile.STUDENT_PATH, studentList);
    }

    @Override
    public void deleteById(Integer id) {
        studentList.remove(findById(id));
        new IOFile<Student>().writeToFile(IOFile.STUDENT_PATH, studentList);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentList.stream()
                .filter(
                        (stu) -> stu.getStudentName()
                                .toLowerCase()
                                .contains(name.toLowerCase()))
//                .toList();
                .collect(Collectors.toList());
    }

    @Override
    public int getNewId() {
        int maxId = 0;
        for (Student s : studentList) {
            if (maxId < s.getStudentId()) {
                maxId = s.getStudentId();
            }
        }
        return maxId + 1;
    }

}