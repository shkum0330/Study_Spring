package jpabook.jpashop.service.query;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
public class OrderQueryDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate; //주문시간
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItemQueryDto> orderItems;
    public OrderQueryDto(Order order){
        orderId=order.getId();
        name=order.getMember().getName();
        orderDate=order.getOrderDate();
        orderStatus=order.getStatus();
        address=order.getDelivery().getAddress();
        orderItems=order.getOrderItems().stream()
                .map(orderItem -> new OrderItemQueryDto(orderItem)).collect(toList());
    }
}
