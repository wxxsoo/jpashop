package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Created by wansoo.
 * User: accomplishlee
 */

@RunWith(SpringRunner.class) // Jnit과 Spring을 엮어서 실
@SpringBootTest // SpringBoot로 띄운 상태로 Test를 하기 위해 필요한 어노테이션
@Transactional // 테스트후 DB에 커밋하지않고 롤백을 하기위해 사용
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("lee");
        // when
        Long saveId = memberService.join(member);
        // then
//        em.flush();
        Assert.assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("lee");
        Member member2 = new Member();
        member2.setName("lee");
        // when
        memberService.join(member1);
        memberService.join(member2);
        // then
        Assert.fail("예외가 발생해야 한다.");
    }
}