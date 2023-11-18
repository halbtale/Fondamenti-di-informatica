public class Chronometer {
    private static final long NONE = -1L;
    final private boolean RUNNING = true;
    final private boolean STOPPED = false;

    private long startTimeMillis = NONE;
    private long endTimeMillis = NONE;
    private boolean state = STOPPED;

    public Chronometer() {
    }

    public void start() {
        reset();
        startTimeMillis = System.currentTimeMillis();
        state = RUNNING;
    }

    public void stop() {
        endTimeMillis = System.currentTimeMillis();
        state = STOPPED;
    }

    public void reset() {
        startTimeMillis = NONE;
        endTimeMillis = NONE;
        state = STOPPED;
    }

    public String getElapsedTime() {
        if (isTimeReady()) {
            return String.format("%.4f", ((double) (endTimeMillis - startTimeMillis)) / 1000) + " s";
        } else {
            return "0.0000";
        }
    }

    public boolean isRunning() {
        return state;
    }

    public boolean isTimeReady() {
        return startTimeMillis < endTimeMillis;
    }

    public String toString() {
        if (state == RUNNING) {
            return "Chronometer running: " + getElapsedTime() + " s";
        } else if (state == STOPPED && isTimeReady()) {
            return "Chronometer ready: " + getElapsedTime() + " s";
        } else {
            return "Chronometer off";
        }
    }

}
