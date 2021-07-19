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
public class Team extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long teamId;

    private String name;

}
