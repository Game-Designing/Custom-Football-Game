package p005cm.aptoide.p006pt.downloadmanager;

import java.util.List;

/* renamed from: cm.aptoide.pt.downloadmanager.AppDownloadStatus */
public class AppDownloadStatus {
    private static final int PROGRESS_MAX_VALUE = 100;
    private AppDownloadState appDownloadState;
    private long downloadSize;
    private List<FileDownloadCallback> fileDownloadCallbackList;
    private String md5;

    /* renamed from: cm.aptoide.pt.downloadmanager.AppDownloadStatus$AppDownloadState */
    public enum AppDownloadState {
        INVALID_STATUS,
        COMPLETED,
        PENDING,
        PAUSED,
        WARN,
        ERROR,
        ERROR_FILE_NOT_FOUND,
        ERROR_NOT_ENOUGH_SPACE,
        PROGRESS
    }

    public AppDownloadStatus(String md52, List<FileDownloadCallback> fileDownloadCallbackList2, AppDownloadState appDownloadState2, long downloadSize2) {
        this.md5 = md52;
        this.fileDownloadCallbackList = fileDownloadCallbackList2;
        this.appDownloadState = appDownloadState2;
        this.downloadSize = downloadSize2;
    }

    public String getMd5() {
        return this.md5;
    }

    public int getOverallProgress() {
        if (this.downloadSize == 0) {
            return calculateProgressByFileNumber(getOverallProgressAsPercentage());
        }
        return calculateProgressByFileSize(getOverallProgressAsBytes());
    }

    private int getOverallProgressAsBytes() {
        int overallProgress = 0;
        for (FileDownloadCallback fileDownloadCallback : this.fileDownloadCallbackList) {
            overallProgress += (int) fileDownloadCallback.getDownloadProgress().getDownloadedBytes();
        }
        return overallProgress;
    }

    private int getOverallProgressAsPercentage() {
        int overallProgress = 0;
        for (FileDownloadCallback fileDownloadCallback : this.fileDownloadCallbackList) {
            overallProgress += getFileDownloadProgressAsPercentage(fileDownloadCallback);
        }
        return overallProgress;
    }

    private int getFileDownloadProgressAsPercentage(FileDownloadCallback fileDownloadCallback) {
        return (int) Math.floor((double) ((((float) fileDownloadCallback.getDownloadProgress().getDownloadedBytes()) / ((float) fileDownloadCallback.getDownloadProgress().getTotalFileBytes())) * 100.0f));
    }

    private int calculateProgressByFileSize(int overallProgress) {
        return (int) (100.0f * (((float) overallProgress) / ((float) ((int) this.downloadSize))));
    }

    private int calculateProgressByFileNumber(int overallProgress) {
        if (this.fileDownloadCallbackList.size() > 0) {
            return overallProgress / this.fileDownloadCallbackList.size();
        }
        return overallProgress;
    }

    public AppDownloadState getDownloadStatus() {
        return this.appDownloadState;
    }

    private AppDownloadState getAppDownloadState() {
        AppDownloadState previousState = null;
        for (FileDownloadCallback fileDownloadCallback : this.fileDownloadCallbackList) {
            AppDownloadState downloadState = fileDownloadCallback.getDownloadState();
            AppDownloadState appDownloadState2 = AppDownloadState.ERROR;
            if (downloadState == appDownloadState2) {
                return appDownloadState2;
            }
            AppDownloadState downloadState2 = fileDownloadCallback.getDownloadState();
            AppDownloadState appDownloadState3 = AppDownloadState.ERROR_FILE_NOT_FOUND;
            if (downloadState2 == appDownloadState3) {
                return appDownloadState3;
            }
            AppDownloadState downloadState3 = fileDownloadCallback.getDownloadState();
            AppDownloadState appDownloadState4 = AppDownloadState.ERROR_NOT_ENOUGH_SPACE;
            if (downloadState3 == appDownloadState4) {
                return appDownloadState4;
            }
            AppDownloadState downloadState4 = fileDownloadCallback.getDownloadState();
            AppDownloadState appDownloadState5 = AppDownloadState.WARN;
            if (downloadState4 == appDownloadState5) {
                return appDownloadState5;
            }
            AppDownloadState downloadState5 = fileDownloadCallback.getDownloadState();
            AppDownloadState appDownloadState6 = AppDownloadState.PAUSED;
            if (downloadState5 == appDownloadState6) {
                return appDownloadState6;
            }
            AppDownloadState downloadState6 = fileDownloadCallback.getDownloadState();
            AppDownloadState appDownloadState7 = AppDownloadState.INVALID_STATUS;
            if (downloadState6 == appDownloadState7) {
                return appDownloadState7;
            }
            AppDownloadState downloadState7 = fileDownloadCallback.getDownloadState();
            AppDownloadState appDownloadState8 = AppDownloadState.COMPLETED;
            if (downloadState7 != appDownloadState8) {
                AppDownloadState downloadState8 = fileDownloadCallback.getDownloadState();
                AppDownloadState appDownloadState9 = AppDownloadState.PENDING;
                if (downloadState8 != appDownloadState9) {
                    continue;
                } else if (previousState != null && previousState != appDownloadState9) {
                    return AppDownloadState.PROGRESS;
                } else {
                    if (this.fileDownloadCallbackList.indexOf(fileDownloadCallback) == this.fileDownloadCallbackList.size() - 1) {
                        return AppDownloadState.PENDING;
                    }
                }
            } else if (previousState != null && previousState != appDownloadState8) {
                return AppDownloadState.PROGRESS;
            } else {
                if (this.fileDownloadCallbackList.indexOf(fileDownloadCallback) == this.fileDownloadCallbackList.size() - 1) {
                    return AppDownloadState.COMPLETED;
                }
            }
            previousState = fileDownloadCallback.getDownloadState();
        }
        return AppDownloadState.PROGRESS;
    }

    public void setFileDownloadCallback(FileDownloadCallback fileDownloadCallback) {
        if (!this.fileDownloadCallbackList.contains(fileDownloadCallback)) {
            this.fileDownloadCallbackList.add(fileDownloadCallback);
        } else {
            this.fileDownloadCallbackList.set(this.fileDownloadCallbackList.indexOf(fileDownloadCallback), fileDownloadCallback);
        }
        refreshAppDownloadState();
    }

    private void refreshAppDownloadState() {
        this.appDownloadState = getAppDownloadState();
    }

    public AppDownloadState getFileDownloadStatus(String md52) {
        FileDownloadCallback fileDownloadCallback = getFileDownloadCallback(md52);
        if (fileDownloadCallback == null) {
            return AppDownloadState.PROGRESS;
        }
        return fileDownloadCallback.getDownloadState();
    }

    public int getFileDownloadProgress(String md52) {
        FileDownloadCallback fileDownloadCallback = getFileDownloadCallback(md52);
        if (fileDownloadCallback == null) {
            return 0;
        }
        return getFileDownloadProgressAsPercentage(fileDownloadCallback);
    }

    private FileDownloadCallback getFileDownloadCallback(String md52) {
        for (FileDownloadCallback fileDownloadCallback : this.fileDownloadCallbackList) {
            if (fileDownloadCallback.getMd5().equals(md52)) {
                return fileDownloadCallback;
            }
        }
        return null;
    }
}
