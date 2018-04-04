package util.loggers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A class that runs automatically, marking the seconds,
 * and time-stamping the logged objects
 */
public class AutoLogger extends AbstractLogger {

    /** Millisecond precision date format for ease of instantiation */
    public static final SimpleDateFormat VERBOSE_FORMAT
            = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /** Hours/minutes/seconds date format for ease of instantiation */
    public static final SimpleDateFormat SIMPLE_FORMAT
            = new SimpleDateFormat("HH:mm:ss");

    /** The default date format for instantiation, equivalent to SIMPLE_FORMAT */
    public static final SimpleDateFormat DEFAULT_FORMAT = SIMPLE_FORMAT;

    /** This instance's date format for logging */
    private final SimpleDateFormat sdf;
    /** This instance's Timer object to mark seconds */
    private Timer timer;

    /**
     * Creates new AutoLogger object with source src and
     * logging format sdf. Automatically marks time by
     * logging each second (formatted using sdf).
     *
     * @param src the source of this logger's instantiation
     * @param sdf the format of timestamps for logging
     */
    public AutoLogger(Object src, SimpleDateFormat sdf) {
        super(src);
        this.sdf = sdf;

        startTimer();
    }

    /**
     * Creates new AutoLogger object with source src and
     * default logging format. Automatically marks time by
     * logging each second (formatted using DEFUALT_FORMAT).
     *
     * Equivalent to AutoLogger(src, DEFAULT_FORMAT).
     *
     * @param src the source of this logger's instantiation
     */
    public AutoLogger(Object src) {
        this(src, DEFAULT_FORMAT);
    }

    /** Starts the timer ticking each second */
    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(
                new TimerTask() {
                        @Override
                        public void run() {
                            log(new LogHolder());
                        }
                    },
                //Time to next second
                1000 - System.currentTimeMillis() % 1000,
                1000);
        log("AutoLogger timer started.");
    }

    @Override
    public void tick() {
        log("Tick Tock! (tick() was called on an AutoLogger...)");
    }

    @Override
    public void kill() {
        super.kill();
        timer.cancel();
    }

    @Override
    public void reset() {
        super.reset();
        startTimer();
    }

    @Override
    public void log(Object o) {
        super.log(o);
        if (!active) return;

        String stamp = (sdf == null? VERBOSE_FORMAT : sdf).format(new Date());

        if (o instanceof LogHolder)
            System.out.println(stamp + "#");
        else
            System.out.println(stamp + ": " + o.toString());
    }

    /** Class to pass internal messages */
    private static class LogHolder {}

}
