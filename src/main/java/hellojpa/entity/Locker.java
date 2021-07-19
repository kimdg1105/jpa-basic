package hellojpa.entity;


import hellojpa.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Locker extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;
}
