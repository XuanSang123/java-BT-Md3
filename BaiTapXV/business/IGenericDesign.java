package BaiTapXV.business;

import java.util.List;

public interface IGenericDesign<T, E> {
  List<T> findAll(E id);
    boolean create(T t);

    List<T> findAll();

    boolean update(T t);

    boolean deleteById(E id);

    T findById(E id);
}