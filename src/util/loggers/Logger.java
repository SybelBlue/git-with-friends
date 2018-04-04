package util.loggers;

import java.util.function.Consumer;

public class Logger extends AbstractLogger {

    /** The action taken each tick */
    private Consumer<Long> onTick;

    /** The number of ticks since instantiation */
    private long tickCount = 0;

    /**
     * Creates new Logger object with source src.
     *
     * @param src the source of this logger's instantiation
     */
    public Logger(Object src) {
        super(src);
    }

    /**
     * Increments the tick count.
     */
    @Override
    public void tick() {
        if (!active) return;

        log("tick");

        if (onTick != null)
            onTick.accept(tickCount);

        tickCount++;
    }

    @Override
    public void reset() {
        super.reset();
        tickCount = 0;
    }

    @Override
    public void log(Object o) {
        if (!active) return;
        super.log(o);

        System.out.printf("%7d: %s\n", tickCount, o.toString());
    }

    /**
     * Sets the onTick action
     *
     * @param onTick the action to take each tick
     */
    public void setOnTick(Consumer<Long> onTick) {
        this.onTick = onTick;
        log("onTick updated to " + onTick.toString());
    }
}
