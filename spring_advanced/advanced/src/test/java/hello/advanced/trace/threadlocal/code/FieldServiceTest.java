package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FieldServiceTest {
    private FieldService fieldService=new FieldService();

    @Test
    void field(){
        log.info("main start");

        Runnable userA=()->{
          fieldService.logic("userA");
        };

        Runnable userB=()->{
            fieldService.logic("userB");
        };

        Thread threadA=new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB=new Thread(userB);
        threadA.setName("thread-B");

        threadA.start();
//        sleep(2000);

        sleep(100);
        threadB.start();
        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}