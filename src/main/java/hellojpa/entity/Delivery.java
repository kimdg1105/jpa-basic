package hellojpa.entity;


import hellojpa.entity.base.BaseEntity;
import hellojpa.enums.DeliveryStatus;
import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus deliveryStatus;

    @OneToOne(mappedBy = "delivery")
    private Order orders;
}
