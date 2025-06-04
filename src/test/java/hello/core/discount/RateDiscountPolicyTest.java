package hello.core.discount;

import static org.junit.jupiter.api.Assertions.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import java.lang.management.MemoryNotificationInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("VIP는 10%할인이 되어야 함.")
	void vip_o(){
		Member member= new Member(1L, "member VIP", Grade.VIP);
		int discount = discountPolicy.discount(member,10000);
		Assertions.assertThat(discount).isEqualTo(1000);

	}


	@Test
	@DisplayName("VIP가 아니면, 할인이 적용되지 않음")
	void vip_x(){
		Member member= new Member(2L, "member]", Grade.BASIC);
		int discount = discountPolicy.discount(member,10000);
		Assertions.assertThat(discount).isEqualTo(1000);
	}
}