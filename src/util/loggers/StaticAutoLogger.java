package util.loggers;

/**
 * Class used for static import of implemented forms of
 * AbstractLogger abstract class for convenience
 */
public final class StaticAutoLogger {

    /** The instance called upon for the static methods */
    private static final AutoLogger instance = new AutoLogger("Static AutoLogger");

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
        instance.kill();
    }

    /** Returns the instance of AutoLogger that calls are made on */
    private static AutoLogger getInstance() {
        return instance;
    }

}
