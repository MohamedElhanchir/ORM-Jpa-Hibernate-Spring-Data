package ma.enset.jpademo.repository;

import ma.enset.jpademo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainsIgnoreCase(String kw);
    @Query("select p from Product p where p.price > :min and p.price < :max")
    List<Product> search(@Param("min") double min, @Param("max") double max);
}
