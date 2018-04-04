package util.loggers;

import java.util.function.Consumer;

public class Logger extends AbstractLogger {

    private Consumer<Long> onTick;

    private long tickCount = 0;
    private boolean active = true;

    public Logger(Object src) {
        super(src);
    }

    @Override
    public void tick() {
        if (!active) return;

        if (onTick != null)
            onTick.accept(tickCount);

        tickCount++;
    }

    @Override
    public void kill() {
        active = false;
    }

    @Override
    public void reset() {
        tickCount = 0;
    }

    @Override
    public void log(Object o) {
        super.log(o);

        System.out.printf("%7d: %s\n", tickCount, o.toString());
    }

    public void setOnTick(Consumer<Long> onTick) {
        this.onTick = onTick;
        log("onTick updated to " + onTick.toString());
    }
}
