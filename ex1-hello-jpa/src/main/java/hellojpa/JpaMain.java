package hellojpa;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // 비영속
            Member member = new Member();
            member.setUsername("HelloJPA2");
            // 영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println(findMember1==findMember2);
//            Member findMember = em.find(Member.class, 2L);
//            findMember.setName("HelloJPA");
//            System.out.println(findMember.getName());
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//            for (Member member:result){
//                System.out.println(member.getName());
//            }
            Member member1 = new Member();
            Member member2 = new Member();
            Member member3 = new Member();
            member1.setUsername("A");
            member2.setUsername("B");
            member3.setUsername("C");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
//            em.detach(member1);
            System.out.println("===================");
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
