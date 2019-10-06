package com.vungle.warren.tasks.runnable;

public abstract class PriorityRunnable implements Comparable, Runnable {
    public abstract Integer getPriority();

    public int compareTo(Object o) {
        if (!(o instanceof PriorityRunnable)) {
            return -1;
        }
        return ((PriorityRunnable) o).getPriority().compareTo(getPriority());
    }
}
