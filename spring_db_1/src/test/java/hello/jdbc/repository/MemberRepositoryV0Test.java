package hello.jdbc.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class MemberRepositoryV0Test {
  private final MemberRepositoryV0 memberRepositoryV0 = new MemberRepositoryV0();

  @Test
  void save() {
    Member member = new Member("memberA", 10000);
    Member saveMember = memberRepositoryV0.save(member);
    log.info("saveMember: {}", saveMember);
    assertEquals(member, saveMember);
  }

  @Test
  void findById() {
    Member member = new Member("memberA", 10000);
    Member findMember = memberRepositoryV0.findById(member.getMemberId());
    log.info("findMember: {}", findMember);
    assertEquals(member, findMember);
  }
}
