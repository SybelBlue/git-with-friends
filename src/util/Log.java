package util;

public abstract class Log {

    public final Object source;

    protected Log(Object src) {
        source = src;
    }

    public abstract void tick();


}
