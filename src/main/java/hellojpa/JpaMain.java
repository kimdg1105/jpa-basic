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
            Team team = new Team();
            team.setName("SK");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("Dong");
            member1.setAge(25);
            member1.changeTeam(team);

            Member member2 = new Member();
            member2.setUsername(null);
            member2.setAge(67);
            member2.changeTeam(team);

            Member member3 = new Member();
            member2.setUsername("관리자");
            member2.setAge(7);
            member2.changeTeam(team);

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            em.flush();
            em.clear();

            String query1 = "select m.username from Member m"; // 상태 필드로서, 경로 탐색의 끝이다.

            String query2 = "select m.team from Member m";

            String query3 = "select t.members From Team t";

            String query4 = "select m.username From Team t join t.members m";

            List<String> resultList1 = em.createQuery(query1, String.class).getResultList();

            List<Team> resultList2 = em.createQuery(query2, Team.class).getResultList();

            Collection resultList3 = em.createQuery(query3, Collection.class).getResultList();

            List<String> resultList4 = em.createQuery(query4, String.class).getResultList();


            for (String s : resultList1) {
                System.out.println("s1 = " + s);
            }

            for (Team s : resultList2) {
                System.out.println("s2 = " + s.toString());
            }

            for (Object s : resultList3) {
                System.out.println("s3 = " + s.toString());
            }

            for (String s : resultList4) {
                System.out.println("s4 = " + s.toString());
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
