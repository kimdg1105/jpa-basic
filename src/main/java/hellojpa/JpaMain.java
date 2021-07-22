package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberDTO;
import hellojpa.entity.Team;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

            String query1 =
                    "select " +
                            "case when m.age <= 10 then '학생요금'" +
                            "   when m.age >=60 then '경로요금'" +
                            "   else '일반요금' end " +
                    "from Member m";

            String query2 =
                    "select coalesce(m.username, '이름 없는 회원') " +
                            "from Member m";

            String query3 =
                    "select nullif(m.username, '관리자') " +
                            "from Member m";

            List<String> resultList1 = em.createQuery(query1, String.class).getResultList();

            List<String> resultList2 = em.createQuery(query2, String.class).getResultList();

            List<String> resultList3 = em.createQuery(query3, String.class).getResultList();

            for (String s : resultList1) {
                System.out.println("s = " + s);
            }

            for (String s : resultList2) {
                System.out.println("s = " + s);

            }

            System.out.println("resultList3 = " + resultList3);

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
