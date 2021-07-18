package hellojpa.entity;


import hellojpa.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID") // FK 조인할 필드명
//    private Team team;
//
//    @OneToMany(mappedBy = "member")
//    private List<Order> orders = new ArrayList<>();
//


    @Column
    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private LocalDateTime orderDate;


    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;




    public Member() {
    }

//    public void changeTeam(Team team){
//        this.team = team;
//        team.getMembers().add(this);
//    }


}
