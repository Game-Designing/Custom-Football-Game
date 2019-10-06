package p005cm.aptoide.p006pt.packageinstaller;

/* renamed from: cm.aptoide.pt.packageinstaller.InstallStatus */
public final class InstallStatus {
    private final String message;
    private final String packageName;
    private final Status status;

    /* renamed from: cm.aptoide.pt.packageinstaller.InstallStatus$Status */
    public enum Status {
        INSTALLING,
        SUCCESS,
        FAIL,
        CANCELED,
        UNKNOWN_ERROR
    }

    InstallStatus(Status status2, String message2, String packageName2) {
        this.message = message2;
        this.status = status2;
        this.packageName = packageName2;
    }

    public String getMessage() {
        return this.message;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getPackageName() {
        return this.packageName;
    }
}
