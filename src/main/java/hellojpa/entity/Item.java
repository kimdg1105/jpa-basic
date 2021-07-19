package hellojpa.entity;

import hellojpa.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 싱글 테이블 설계
@DiscriminatorColumn
public abstract class Item extends BaseEntity { // Item만 만드는 경우는 없다 -> 추상 클래스

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;


}
