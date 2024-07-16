package BaiTapXV.business;

import BaiTapXV.entity.Product;

public interface IProductDesign extends IGenericDesign<Product, Integer> {
    Product findByName(String name);

//    Product findById(Integer id);

    boolean existByCategoryId(Integer catId);
}
