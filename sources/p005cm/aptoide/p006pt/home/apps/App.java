package p005cm.aptoide.p006pt.home.apps;

/* renamed from: cm.aptoide.pt.home.apps.App */
public interface App {

    /* renamed from: cm.aptoide.pt.home.apps.App$Type */
    public enum Type {
        UPDATE,
        DOWNLOAD,
        INSTALLED,
        HEADER_INSTALLED,
        HEADER_DOWNLOADS,
        HEADER_UPDATES;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    Type getType();
}
