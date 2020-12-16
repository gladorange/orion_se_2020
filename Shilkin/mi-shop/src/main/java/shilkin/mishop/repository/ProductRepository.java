package shilkin.mishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shilkin.mishop.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);

    @Query(value = """
                select p.* from product p
                where p.category_id = ?1
                union all
                select p.* from product p
                join category c on c.id = p.category_id
                where c.parent_category_id = ?1
            """,
            nativeQuery = true)
    List<Product> findProductByCategoryId(Long categoryId);
}
