package util;

import static util.loggers.StaticAutoLogger.*;

@SuppressWarnings("StatementWithEmptyBody")
public class AutoLoggerTest {

    public static void main(String[] args) {
        log("test.");
        tick();
        kill();
        long l = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < l) ;
        reset();
        l += 5000;
        while (System.currentTimeMillis() < l) ;
        log(l);
        kill();
    }

}
