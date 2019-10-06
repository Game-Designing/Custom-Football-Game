package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse */
public abstract class BaseV7EndlessResponse extends BaseV7Response {
    protected static final int NEXT_STEP = 10;
    private final boolean stableTotal;

    public abstract int getNextSize();

    public abstract int getTotal();

    public abstract boolean hasData();

    public BaseV7EndlessResponse() {
        this(true);
    }

    public BaseV7EndlessResponse(boolean stableTotal2) {
        this.stableTotal = stableTotal2;
    }

    public boolean hasStableTotal() {
        return this.stableTotal;
    }

    public int hashCode() {
        return (((1 * 59) + super.hashCode()) * 59) + (this.stableTotal ? 79 : 97);
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof BaseV7EndlessResponse;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseV7EndlessResponse)) {
            return false;
        }
        BaseV7EndlessResponse other = (BaseV7EndlessResponse) o;
        if (other.canEqual(this) && super.equals(o) && this.stableTotal == other.stableTotal) {
            return true;
        }
        return false;
    }
}
