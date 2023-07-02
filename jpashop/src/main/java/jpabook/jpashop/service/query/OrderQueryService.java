package jpabook.jpashop.service.query;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderQueryService { // 쿼리용 서비스는 패키지 분리하는 것이 좋다.
    private final OrderRepository orderRepository;

    public List<OrderQueryDto> ordersV3_query(){
        List<Order> orders=orderRepository.findAllWithItem();
        return orders.stream().map(o->new OrderQueryDto(o)).collect(toList());
    }
}
