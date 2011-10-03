package com.lissenberg.blog.util;

/**
 * A timer or stopwatch to measure duration in several time units.
 *
 * @author Harro Lissenberg
 */
public class Timer {
    private static final long millis = 1000L * 1000L;
    private static final long seconds = millis * 1000L;
    private static final long minutes = seconds * 1000L;
    private static final long hours = minutes * 1000L;

    enum Unit {HOURS, MINUTES, SECONDS, MILLISECONDS, NANOSECONDS}

    private final long start;

    /**
     * Creates and starts the timer
     */
    public Timer() {
        start = System.nanoTime();
    }

    /**
     * Returns the duration of this timer in milliseconds. Timer will continue.
     *
     * @return the duration
     */
    public long getDuration() {
        return getDuration(Unit.MILLISECONDS);
    }

    /**
     * Returns the duration of this timer. Timer will continue.
     *
     * @param timeUnit the time unit of the duration
     * @return the duration
     */
    public long getDuration(Unit timeUnit) {
        long stopped = System.nanoTime() - start;
        switch (timeUnit) {
            case MILLISECONDS:
                return stopped / millis;
            case SECONDS:
                return stopped / seconds;
            case MINUTES:
                return stopped / minutes;
            case HOURS:
                return stopped / hours;
            default:
                return stopped;
        }
    }
}
