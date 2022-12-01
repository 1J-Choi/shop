package com.shop.dto;

import com.shop.constant.ItemShippingStatus;
import com.shop.constant.OrderStatus;
import com.shop.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderHistDto {
    private Long orderId;
    private String orderDate;
    private OrderStatus orderStatus;
    private ItemShippingStatus itemShippingStatus;
    private List<OrderItemDto> orderItemDtoList = new ArrayList<>();
    private String orderNm;
    private String orderAddr;

    public OrderHistDto(Order order) {
        this.orderId = order.getId();
        this.orderDate = order.getOrderDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.orderStatus = order.getOrderStatus();
        this.itemShippingStatus = order.getItemShippingStatus();
        this.orderNm = order.getMember().getName();
        this.orderAddr = order.getMember().getAddress();
    }

    public void addOrderItemDto(OrderItemDto orderItemDto) {
        orderItemDtoList.add(orderItemDto);
    }
}
