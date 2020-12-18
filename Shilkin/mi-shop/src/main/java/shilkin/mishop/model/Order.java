package shilkin.mishop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shop_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "product_count")
    private int productCount;
    @Column(name = "final_price")
    private int finalPrice;
}
