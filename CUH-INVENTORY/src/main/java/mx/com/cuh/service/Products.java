package mx.com.cuh.service;

import mx.com.cuh.entity.Product;
import mx.com.cuh.pojo.Response;

import java.util.List;

public interface Products {
    List<Product> obtenerProductos();

    Response nuevoProducto(List<Product>producto);

    Response updateProducto(Product producto , String id);

    Response deleteProduct(String id);

}
