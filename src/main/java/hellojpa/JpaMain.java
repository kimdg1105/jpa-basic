package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberDTO;

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

            em.flush();
            em.clear();

            List<MemberDTO> resultList = em.createQuery("select  new hellojpa.entity.MemberDTO(m.username, m.age) from Member m", MemberDTO.class) // 이름 기반
                    .getResultList();

            MemberDTO memberDTO = resultList.get(0);
            System.out.println("memberDTO = " + memberDTO.getName());
            System.out.println("memberDTO = " + memberDTO.getAge());

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
