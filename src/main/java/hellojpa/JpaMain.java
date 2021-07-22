package hellojpa;

import hellojpa.entity.Member;

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
//
            Member member1 = new Member();
            Member member2 = new Member();
            member1.setUsername("Dong");
            member2.setUsername("Dong");

            em.persist(member1);
            em.persist(member1);

            List<Member> resultList = em.createQuery("select m from Member as m where  m.username =:username", Member.class) // 이름 기반
//            em.createQuery("select m from Member as m where  m.username =?1", Member.class) // 위치 기반
                    .setParameter("username", "Dong")
                    .setParameter("1","Dong")
                    .getResultList();

//            TypedQuery<String> query2 = em.createQuery("select m.username from Member as m", String.class);
//            Query query3 = em.createQuery("select m.username, m.age from Member as m");

            Member singleResult = query1.getSingleResult();
            System.out.println("singleResult.getUsername() = " + singleResult.getUsername());





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
