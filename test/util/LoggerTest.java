package util;

import static util.loggers.StaticLogger.*;

@SuppressWarnings("StatementWithEmptyBody")
public class LoggerTest {

    public static void main(String[] args) {
        log("test.");
        for (int i = 0; i < 1000; i++) tick();
        kill();
        long l = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < l) ;
        System.out.println("reset called");
        reset();
        l += 5000;
        while (System.currentTimeMillis() < l) ;
        tick();
        tick();
        log(l);
    }

}
