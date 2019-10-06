package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.downloadmanager.AppDownloadStatus.AppDownloadState;

/* renamed from: cm.aptoide.pt.downloadmanager.DownloadStatusMapper */
public class DownloadStatusMapper {

    /* renamed from: cm.aptoide.pt.downloadmanager.DownloadStatusMapper$1 */
    static /* synthetic */ class C29471 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$downloadmanager$AppDownloadStatus$AppDownloadState */
        static final /* synthetic */ int[] f6230x5e1d6a72 = new int[AppDownloadState.values().length];

        static {
            try {
                f6230x5e1d6a72[AppDownloadState.PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6230x5e1d6a72[AppDownloadState.INVALID_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6230x5e1d6a72[AppDownloadState.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6230x5e1d6a72[AppDownloadState.PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6230x5e1d6a72[AppDownloadState.PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6230x5e1d6a72[AppDownloadState.WARN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f6230x5e1d6a72[AppDownloadState.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f6230x5e1d6a72[AppDownloadState.ERROR_NOT_ENOUGH_SPACE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f6230x5e1d6a72[AppDownloadState.ERROR_FILE_NOT_FOUND.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public int mapAppDownloadStatus(AppDownloadState appDownloadState) {
        switch (C29471.f6230x5e1d6a72[appDownloadState.ordinal()]) {
            case 1:
                return 5;
            case 2:
                return 0;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
            case 8:
            case 9:
                return 9;
            default:
                throw new IllegalArgumentException("Invalid app download state");
        }
    }

    public int mapDownloadError(AppDownloadState appDownloadState) {
        int i = C29471.f6230x5e1d6a72[appDownloadState.ordinal()];
        if (i == 7) {
            return 1;
        }
        if (i != 8) {
            return 0;
        }
        return 2;
    }
}
