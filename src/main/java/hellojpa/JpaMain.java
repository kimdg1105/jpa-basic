package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberDTO;
import hellojpa.entity.Team;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Team teamA = new Team();
            teamA.setName("A");
            em.persist(teamA);
            Team teamB = new Team();
            teamB.setName("B");
            em.persist(teamB);
            Team teamC = new Team();
            teamC.setName("C");
            em.persist(teamC);

            Member member1 = new Member();
            member1.setUsername("Tester1");
            member1.changeTeam(teamA);

            Member member2 = new Member();
            member2.setUsername("Tester2");
            member2.changeTeam(teamA);

            Member member3 = new Member();
            member3.setUsername("Tester3");
            member3.changeTeam(teamB);

            Member member4 = new Member();
            member4.setUsername("Tester4");


            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);

            em.flush();
            em.clear();

            String query1 = "select m from Member m join fetch m.team";

            List<Member> resultList1 = em.createQuery(query1, Member.class).getResultList();



            for (Member s : resultList1) {
                try {
                    System.out.println("s1.Member = " + s + "s1.Team = " + s.getTeam().getName());
                    //회원1 -> 팀(SQL)
                    //회원2 -> 팀(1차 캐시)
                    //회원3 -> 팀(SQL)

                    //N+1 문제가 이런 식으로 발생한다.

                }
                catch (NullPointerException e){
                    System.out.println("Memeber "+  s + " has no team.");
                }
            }

            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            em.close();
        }

        emf.close();




    }
}
