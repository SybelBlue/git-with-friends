package util.loggers;

/**
 * Class used for static import of implemented forms of
 * AbstractLogger abstract class for convenience
 */
public final class StaticLogger {

    /** The instance called upon for the static methods */
    private static final Logger instance = new Logger("Static Logger");

    /** Calls log */
    public static void log(Object o) {
        instance.log(o);
    }

    /** Calls tick */
    public static void tick() {
        instance.tick();
    }

    /** Calls reset */
    public static void reset() {
        instance.reset();
    }

    /** Calls kill */
    public static void kill() {
        instance.reset();
    }

    /** Returns the instance of Logger that calls are made on */
    private static Logger getInstance() {
        return instance;
    }

}
