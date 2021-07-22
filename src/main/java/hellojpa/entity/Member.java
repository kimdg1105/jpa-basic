package hellojpa.entity;

import lombok.*;

import javax.persistence.*;


@Entity // 클래스 이름이 Default이다.
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String username;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", team=" + team +
                '}';
    }

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);

    }
}
