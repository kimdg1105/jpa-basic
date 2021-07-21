package hellojpa.entity;


import hellojpa.entity.base.BaseEntity;
import hellojpa.entity.embedded.Address;
import hellojpa.entity.embedded.Period;
import hellojpa.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity // 클래스 이름이 Default이다.
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue // stratgy = Auto
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "TEAM_ID")
    private Long teamId;

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))

    })
    private Address workAddress;


    @Embedded
    private Period workPeriod;



//
//    @Column
//    private Integer age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    private LocalDateTime orderDate;
//
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;
//
//    @OneToOne(fetch = LAZY)
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;
//
//    @ManyToOne(fetch = LAZY) // 프록시 객체의 조회로 바뀐다.
//    @JoinColumn
//    private Team team;
//

    public Member() {
    }

//    public void changeTeam(Team team){
//        this.team = team;
//        team.getMembers().add(this);
//    }


}
