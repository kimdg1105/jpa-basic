package hellojpa.entity;

import lombok.*;

import javax.persistence.*;


@Entity // 클래스 이름이 Default이다.
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String username;

    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
