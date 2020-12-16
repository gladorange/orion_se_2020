package shilkin.mishop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "price")
    private int price;
    @Column(name = "product_count")
    private int productCount;
}
