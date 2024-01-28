package springcloud;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springcloud.dao.MemberDao;
import springcloud.entity.Member;
import springcloud.service.MemberService;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class MemberApplicationTest {
    @Resource
    private MemberDao memberDao;
    @Resource
    private MemberService memberService;

    @Test
    public void queryMemberById() {
//        Member member = memberDao.queryMemberById(1L);
        Member member = memberService.queryMemberById(1L);
        log.info("member~~~{}",member);
    }
    @Test
    public void addMember() {
        Member member = new Member(null, "牛魔王", "123", "13012345678", "nmw@163.com", 1);
        int effected = memberService.save(member);
        log.info("effected={}" ,effected);
    }


}
