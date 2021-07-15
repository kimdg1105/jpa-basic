package hellojpa.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Member") // 클래스 이름이 Default이다.
@Getter
@Setter
public class Member {
    @Id @GeneratedValue // stratgy = Auto
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;


//    @Column
//    private Integer age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    private LocalDate test1;
//    private LocalDateTime test2;
//
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;




    public Member() {
    }

//    public Member(Long id, String name) {
//
//        this.id = id;
//        this.name = name;
//    }


}
