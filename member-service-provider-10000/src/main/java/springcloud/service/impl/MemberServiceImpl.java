package springcloud.service.impl;

import org.springframework.stereotype.Service;
import springcloud.dao.MemberDao;
import springcloud.entity.Member;
import springcloud.service.MemberService;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberDao memberDao;
    @Override
    public Member queryMemberById(Long id) {
        return memberDao.queryMemberById(id);
    }

    @Override
    public int save(Member member) {
        return memberDao.save(member);
    }
}
