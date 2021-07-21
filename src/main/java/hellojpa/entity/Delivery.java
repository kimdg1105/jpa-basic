package hellojpa.entity;


import hellojpa.entity.base.BaseEntity;
import hellojpa.entity.embedded.Address;
import hellojpa.enums.DeliveryStatus;
import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Embedded
    private Address address;

    private DeliveryStatus deliveryStatus;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order orders;
}
