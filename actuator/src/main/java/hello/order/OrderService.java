package hello.order;

import java.util.concurrent.atomic.AtomicInteger;

public interface OrderService {
    void order();
    void cancel();
    AtomicInteger getStock(); // 멀티쓰레드 환경에서 값을 안전하게 증감시킬수 있음
}
