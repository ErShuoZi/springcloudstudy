package springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import springcloud.entity.Member;

@Mapper
public interface MemberDao {
    public Member queryMemberById(Long id);

    int save(Member member);
}
