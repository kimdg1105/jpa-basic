package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            Team team1 = new Team();
            Team team2 = new Team();
            team1.setName("TeamA");
            team2.setName("TeamB");
            em.persist(team1);
            em.persist(team2);

            Member member1 = new Member();
            Member member2 = new Member();
            Member member3 = new Member();
            member1.setUsername("TesterA");
            member2.setUsername("TesterB");
            member3.setUsername("TesterC");
            member1.changeTeam(team1);
            member2.changeTeam(team2);
            member3.changeTeam(team1);

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
//
//            em.flush(); // 디비에 해당 내용을 바로 반영한다.
//            em.clear();

//            team1.getMembers().add(member2); // 이 부분을 Member 엔티티 세터 클래스에 넣는 전략

            System.out.println("=================");
            Member findMember = em.find(Member.class, member3.getId());

            List<Member> members = findMember.getTeam().getMembers();
            for (Member member : members) {
                System.out.println("findTeam.getName() = " + member.getUsername());
            }

            System.out.println("=================");



            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }
        finally {
            em.close();
        }

        emf.close();




    }
}
