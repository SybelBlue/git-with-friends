package util.loggers;

import java.util.Date;
import java.util.function.Consumer;

/**
 * A class that lays out the basic functionality of a Log for
 * keeping track of activity at runtime
 */
public abstract class AbstractLogger {

    /** The source of the logger's instantiation */
    public final Object src;

    /** True when the logger can log or tick */
    boolean active = true;

    /**
     *  An action taken every time the log method is called
     *  and applied to the argument o passed into log(o)
     */
    private Consumer<Object> onLog;

    /**
     * Creates a new instance of an abstract logger,
     * used only for inheritance purposes and so is
     * restricted to package-private
     *
     * @param src the source of this logger's instantiation
     */
    AbstractLogger(Object src) {
        this.src = src;
        log(src.toString() + " instantiated new Logger Utility at " + new Date().toString());
    }

    /** Advance any counters */
    public abstract void tick();

    /** Disallow logging or ticking */
    public void kill() { active = false; }

    /** Resets the logger to its initial state */
    public void reset() { active = true; }

    /**
     * Logs the object, and calls onLog if
     * not null
     *
     * @param o the object to log
     */
    public void log(Object o) {
        if (active && onLog != null)
            onLog.accept(o);
    }

    public void setOnLog(Consumer<Object> onLog) {
        this.onLog = onLog;
        log("onLog updated to " + onLog.toString());
    }

}
