package mx.com.cuh.repository;

import mx.com.cuh.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {

}
