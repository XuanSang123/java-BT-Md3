package BaiTapXIV.Bai3.business;

import java.util.List;

public interface IGenericDesign<T, E> {
    //    Thêm mới:
    boolean create(T t);

    //    Chỉnh sửa:
    void update(T t);

    //    Xóa:
    void deleteById(E id);

    //    Tìm theo id:
    T findById(E id);

    //    Tìm tất cả:
    List<T> findAll();

}