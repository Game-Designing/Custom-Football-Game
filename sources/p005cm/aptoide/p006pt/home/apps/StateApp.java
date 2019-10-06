package p005cm.aptoide.p006pt.home.apps;

/* renamed from: cm.aptoide.pt.home.apps.StateApp */
public interface StateApp extends App {

    /* renamed from: cm.aptoide.pt.home.apps.StateApp$Status */
    public enum Status {
        ACTIVE,
        STANDBY,
        COMPLETED,
        ERROR,
        UPDATE,
        UPDATING,
        PAUSING,
        INSTALLING;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    int getProgress();

    Status getStatus();

    boolean isIndeterminate();

    void setIndeterminate(boolean z);

    void setStatus(Status status);
}
