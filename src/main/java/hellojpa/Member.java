package hellojpa;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Member") // 클래스 이름이 Default이다.
@Getter
@Setter
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq", initialValue = 1, allocationSize = 1)
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    private Long id;
//    @Column(unique = true, length = 10) // 옵션 설정 가능
    @Column(name = "name", insertable = true, updatable = true, nullable = false)
    private String username;

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
