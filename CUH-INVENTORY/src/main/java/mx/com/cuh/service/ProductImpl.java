package mx.com.cuh.service;

import mx.com.cuh.entity.Product;
import mx.com.cuh.pojo.Response;
import mx.com.cuh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class ProductImpl implements Products {
    @Autowired
    private ProductRepository productRepository;

    //METODO GET
    @Override
    public List<Product> obtenerProductos() {
        return (List<Product>) productRepository.findAll();
    }

    //Metodo POST
    @Override
    public Response nuevoProducto(List<Product> productos) {
        Response respuesta = new Response();

        productRepository.saveAll(productos);
        respuesta.setMensaje("Producto guardado");

        return respuesta;
    }

    //Metodo PUT

    public Response updateProducto(Product producto, String id) {
        Optional<Product> productExisting = productRepository.findById(Long.valueOf(id));
        Response respuesta = new Response();
        if (productExisting.isPresent()) {
            Product productUpdate = productExisting.get();
            Field[] fields = Product.class.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(producto);
                    if (fieldValue != null) {
                        field.set(productUpdate, fieldValue);
                    }
                } catch (IllegalAccessException e) {

                    e.printStackTrace();
                }
            }
            productRepository.save(productUpdate);
            respuesta.setMensaje("Producto actualizado con éxito");
        } else {
            respuesta.setMensaje("El producto no existe");
        }
        return respuesta;
    }

    @Override
    public Response deleteProduct(String id) {
        Optional<Product> producto = productRepository.findById(Long.valueOf(id));
        Response respuesta = new Response();
        if (producto.isPresent()) {
            Product productofinal = producto.get();
            productRepository.delete(productofinal);
            respuesta.setMensaje("Producto eliminado con éxito");
        } else {
            respuesta.setMensaje("El producto no existe");
        }
        return respuesta;
    }

}
