package hello.core.scan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class    AutoAppConfigTest {

	@Bean(name = "memoryMemberRepository")
	MemberRepository memberRepository(){
		return new MemoryMemberRepository();
	}

	@Test
	void basicScan(){
		AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AutoAppConfig.class);

		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}

}
