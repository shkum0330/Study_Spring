package jpabook.jpashop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
public class MemberRepository {
    @PersistenceContext
    EntityManager em;

    public Long save(Member member){
        log.info("{}",member);
        em.persist(member);
        return member.getId();
    }
    public Member find(Long id){
        return em.find(Member.class,id);
    }
}
