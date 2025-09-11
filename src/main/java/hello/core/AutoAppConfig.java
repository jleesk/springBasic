package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    // 위치 선언해야하지만, 기본적으로 안하면, 상위 패키지들 모두 검색하게 됨.
   // basePackages = "hello.core.member",
  // basePackageClasses = AutoAppConfig.class,

  //AppConfig 소스와 충돌 방지 위해 제외함.
  excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

	@Bean
	OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy){
		return new OrderServiceImpl(memberRepository, discountPolicy);
	}

	@Bean(name = "memoryMemberRepository")
	MemberRepository memberRepository(){
		return new MemoryMemberRepository();
	}

}
