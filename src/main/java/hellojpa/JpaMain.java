package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;
import hellojpa.entity.inheritance.Album;
import hellojpa.entity.inheritance.Book;
import hellojpa.entity.inheritance.Movie;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            System.out.println("=================");


            Member member = new Member();
            member.setUsername("Dong");

            em.persist(member);
            em.flush();
            em.clear();

//            Member member1 = em.find(Member.class, member.getId());
//            System.out.println("member1 = " + member1);

            Member reference = em.getReference(Member.class, member.getId());
            System.out.println("reference = " + reference.getClass());


            Hibernate.initialize(reference);
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(reference));


            em.detach(reference);
            System.out.println("reference = " + reference.getUsername());




            System.out.println("=================");



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
