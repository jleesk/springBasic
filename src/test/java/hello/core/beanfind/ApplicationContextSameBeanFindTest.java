package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Map;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);


	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상이 있으면, 빈 이름으로 지정하면 된다.")
	void findBeanByName(){
		MemberRepository memberRepository =ac.getBean("memberRepository1",MemberRepository.class);
		assertThat(memberRepository).isInstanceOf(MemberRepository.class);
	}

	@Test
	@DisplayName("특정 타입을 모두 조회하기")
	void findAllBeanByType(){
		Map<String,MemberRepository> beansofType =ac.getBeansOfType(MemberRepository.class);
		for(String key: beansofType.keySet()){
			System.out.println("key = " + key+ " value = " + beansofType.get(key));
		}
		System.out.println("beansofType = " + beansofType);
		assertThat(beansofType.size()).isEqualTo(2);
	}


	@Configuration
	static class SameBeanConfig{

		@Bean
		public MemberRepository memberRepository1(){
			return new MemoryMemberRepository();

		}

		@Bean
		public MemberRepository memberRepository2(){
			return new MemoryMemberRepository();

		}
	}
}
