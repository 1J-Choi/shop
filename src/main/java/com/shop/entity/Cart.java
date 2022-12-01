package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="cart")
@Getter
@Setter
@ToString
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY) // 1:1 맵핑 지연로딩
    @JoinColumn(name = "number_id") // JoinColumn 매핑할 외래키(name)를 지정합니다. 외래키 이름을 설정
    // name을 명시하지 않으면 JPA가 알아서 ID를 찾으나 원하는 이름이 아닐 수 도 있음
    private Member member; // member의 객체 자체가 들어간다

    public static Cart createCart(Member member) {
        Cart cart = new Cart();
        cart.setMember(member);
        return cart;
    }
}
