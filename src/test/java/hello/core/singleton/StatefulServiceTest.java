package hello.core.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.assertj.core.api.Assertions;

class StatefulServiceTest {

	@Test
	void statefulServiceSingleton(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 =ac.getBean(StatefulService.class);
		StatefulService statefulService2 =ac.getBean(StatefulService.class);
		//A사용자가 1만원 주문
		int userAPrice = statefulService1.order("userA",10000);
		//B사용자가 1만원 주문
		int userBPrice = statefulService2.order("userB",20000);

		//A사용자 금액 조회
	//	int price =statefulService1.getPrice();
		System.out.println("userAprice = " + userAPrice);

	//	Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

	}

	static class TestConfig {
		@Bean
		public StatefulService statefulService(){
			return new StatefulService();
		}
	}

}