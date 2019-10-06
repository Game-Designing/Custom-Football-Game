package p005cm.aptoide.p006pt.dataprovider.util.referrer;

/* renamed from: cm.aptoide.pt.dataprovider.util.referrer.SimpleTimedFuture */
public class SimpleTimedFuture<T> {
    private int DELAY;
    private T value;

    public T get() {
        return get(5000);
    }

    public T get(int timeOutMillis) {
        int counter = 0;
        while (!isDone()) {
            try {
                this.DELAY = 100;
                Thread.sleep((long) this.DELAY);
                counter++;
                if (this.DELAY * counter > timeOutMillis) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("TimeOut reached! ");
                    sb.append(timeOutMillis);
                    throw new InterruptedException(sb.toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return this.value;
    }

    public boolean isDone() {
        return this.value != null;
    }

    public void set(T value2) {
        this.value = value2;
    }
}
