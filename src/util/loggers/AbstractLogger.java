package util.loggers;

import java.util.Date;
import java.util.function.Consumer;

public abstract class AbstractLogger {

    public final Object src;

    private Consumer<Object> onLog;

    AbstractLogger(Object src) {
        this.src = src;
        log(src.toString() + " instantiated new Logger Utility at " + new Date().toString());
    }

    public abstract void tick();

    public abstract void kill();

    public abstract void reset();

    public void log(Object o) {
        if (onLog != null)
            onLog.accept(o);
    }

    public void setOnLog(Consumer<Object> onLog) {
        this.onLog = onLog;
        log("onLog updated to " + onLog.toString());
    }

}
