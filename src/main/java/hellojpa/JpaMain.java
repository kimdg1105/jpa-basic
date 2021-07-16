package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;

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

            Team team = new Team();
            team.setName("TeamB");
            em.persist(team);

            Member member = new Member();
            member.setUsername("TesterB");
            member.setTeam(team);
            em.persist(member);
//
////          테이블에 맞춘 모델링의 문제점
//            Member findMember = em.find(Member.class, member.getId());
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            System.out.println("=================");
            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam.getName() = " + findTeam.getName());
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
