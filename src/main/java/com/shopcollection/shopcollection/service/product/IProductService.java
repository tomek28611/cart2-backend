package com.shopcollection.shopcollection.service.product;

import com.shopcollection.shopcollection.dto.ProductDto;
import com.shopcollection.shopcollection.model.Product;
import com.shopcollection.shopcollection.request.AddProductRequest;
import com.shopcollection.shopcollection.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {

    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String category, String name);
    Long countProductsByBrandAndName(String brand, String name);



}
