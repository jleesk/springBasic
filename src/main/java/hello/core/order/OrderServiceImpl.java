package hello.core.order;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
//import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

import java.lang.management.MemoryManagerMXBean;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
 //   private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //정책변경
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository =memberRepository;
        this.discountPolicy =discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice, discountPrice);

    }
}
