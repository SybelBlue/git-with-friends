package util.loggers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AutoLogger extends AbstractLogger {

    public static final SimpleDateFormat VERBOSE_FORMAT
            = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static final SimpleDateFormat SIMPLE_FORMAT
            = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat DEFAULT_FORMAT = SIMPLE_FORMAT;

    private final SimpleDateFormat sdf;
    private final Timer timer;

    public AutoLogger(Object src, SimpleDateFormat sdf) {
        super(src);
        this.sdf = sdf;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log(new LogHolder());
            }
        },
                1000 - System.currentTimeMillis() % 1000,
                1000);
    }

    public AutoLogger(Object src) {
        this(src, DEFAULT_FORMAT);
    }

    @Override
    public void tick() {}

    @Override
    public void kill() {
        timer.cancel();
    }

    @Override
    public void reset() {}

    @Override
    public void log(Object o) {
        super.log(o);
        String stamp = sdf.format(new Date());

        if (o instanceof LogHolder)
            System.out.println(stamp + "#");
        else
            System.out.println(stamp + ": " + o.toString());
    }

    private static class LogHolder {}

}
