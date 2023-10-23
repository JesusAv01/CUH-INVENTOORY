package mx.com.cuh.controller;

import mx.com.cuh.entity.Product;
import mx.com.cuh.pojo.Response;
import mx.com.cuh.service.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class Product_Controller {
    @Autowired
    private Products products;

    @GetMapping(value="/products")
    public List<Product> obtenerProductos(){
        return products.obtenerProductos();
    }

    @PostMapping(value = "/products")
    public Response nuevoProducto(@RequestBody List<Product> producto){
        return products.nuevoProducto(producto);
    }

    @PutMapping(value = "/products")
    public Response updateProducto(@RequestBody Product producto,@RequestParam(name = "id") String id){
        return products.updateProducto(producto,id);
    }

    @DeleteMapping(value = "/products")
    public Response deleteProduct(@RequestParam(name = "id")String id){
        return products.deleteProduct(id);
    }
}
