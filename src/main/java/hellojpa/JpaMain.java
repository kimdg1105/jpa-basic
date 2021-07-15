package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Member member1 = new Member();
//            member1.setId("ID_A");
            member1.setUsername("Tester1");

            Member member2 = new Member();
//            member1.setId("ID_A");
            member2.setUsername("Tester2");

            Member member3 = new Member();
//            member1.setId("ID_A");
            member3.setUsername("Tester3");
//            member1.setRoleType(RoleType.GUEST);
            System.out.println("===============");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            System.out.println("member1.getId() = " + member1.getId());
            System.out.println("===============");
//
//            Member member2 = em.find(Member.class, 1L);
//            if(member2 != null){
//                member2.setUsername("ChangeName2");
//            }

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
