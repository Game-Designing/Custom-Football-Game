package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Pay;

/* renamed from: cm.aptoide.pt.app.DownloadModel */
public class DownloadModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Action action;
    private final DownloadState downloadState;
    private final Pay pay;
    private final int progress;

    /* renamed from: cm.aptoide.pt.app.DownloadModel$Action */
    public enum Action {
        UPDATE,
        INSTALL,
        DOWNGRADE,
        OPEN,
        PAY,
        MIGRATE;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.app.DownloadModel$DownloadState */
    public enum DownloadState {
        ACTIVE,
        PAUSE,
        COMPLETE,
        INDETERMINATE,
        ERROR,
        NOT_ENOUGH_STORAGE_ERROR,
        INSTALLING;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.app.DownloadModel$Error */
    public enum Error {
        NETWORK,
        GENERIC;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7809710272300556200L, "cm/aptoide/pt/app/DownloadModel", 33);
        $jacocoData = probes;
        return probes;
    }

    public DownloadModel(Action action2, int progress2, DownloadState downloadState2, Pay pay2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.action = action2;
        this.progress = progress2;
        this.downloadState = downloadState2;
        this.pay = pay2;
        $jacocoInit[0] = true;
    }

    public Action getAction() {
        boolean[] $jacocoInit = $jacocoInit();
        Action action2 = this.action;
        $jacocoInit[1] = true;
        return action2;
    }

    public int getProgress() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.progress;
        $jacocoInit[2] = true;
        return i;
    }

    public DownloadState getDownloadState() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadState downloadState2 = this.downloadState;
        $jacocoInit[3] = true;
        return downloadState2;
    }

    public boolean isDownloading() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.downloadState.equals(DownloadState.ACTIVE)) {
            $jacocoInit[4] = true;
        } else {
            DownloadState downloadState2 = this.downloadState;
            DownloadState downloadState3 = DownloadState.PAUSE;
            $jacocoInit[5] = true;
            if (downloadState2.equals(downloadState3)) {
                $jacocoInit[6] = true;
            } else {
                DownloadState downloadState4 = this.downloadState;
                DownloadState downloadState5 = DownloadState.INDETERMINATE;
                $jacocoInit[7] = true;
                if (downloadState4.equals(downloadState5)) {
                    $jacocoInit[8] = true;
                } else {
                    z = false;
                    $jacocoInit[10] = true;
                    $jacocoInit[11] = true;
                    return z;
                }
            }
        }
        $jacocoInit[9] = true;
        z = true;
        $jacocoInit[11] = true;
        return z;
    }

    public boolean isDownloadingOrInstalling() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (isDownloading()) {
            $jacocoInit[12] = true;
        } else if (this.downloadState.equals(DownloadState.INSTALLING)) {
            $jacocoInit[13] = true;
        } else {
            z = false;
            $jacocoInit[15] = true;
            $jacocoInit[16] = true;
            return z;
        }
        $jacocoInit[14] = true;
        z = true;
        $jacocoInit[16] = true;
        return z;
    }

    public Pay getPay() {
        boolean[] $jacocoInit = $jacocoInit();
        Pay pay2 = this.pay;
        $jacocoInit[17] = true;
        return pay2;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.downloadState.equals(DownloadState.ERROR)) {
            $jacocoInit[18] = true;
        } else if (this.downloadState.equals(DownloadState.NOT_ENOUGH_STORAGE_ERROR)) {
            $jacocoInit[19] = true;
        } else {
            z = false;
            $jacocoInit[21] = true;
            $jacocoInit[22] = true;
            return z;
        }
        $jacocoInit[20] = true;
        z = true;
        $jacocoInit[22] = true;
        return z;
    }

    public boolean isDownloadable() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.action.equals(Action.INSTALL)) {
            $jacocoInit[23] = true;
        } else {
            Action action2 = this.action;
            Action action3 = Action.UPDATE;
            $jacocoInit[24] = true;
            if (action2.equals(action3)) {
                $jacocoInit[25] = true;
            } else {
                Action action4 = this.action;
                Action action5 = Action.DOWNGRADE;
                $jacocoInit[26] = true;
                if (action4.equals(action5)) {
                    $jacocoInit[27] = true;
                } else {
                    Action action6 = this.action;
                    Action action7 = Action.PAY;
                    $jacocoInit[28] = true;
                    if (action6.equals(action7)) {
                        $jacocoInit[29] = true;
                    } else {
                        z = false;
                        $jacocoInit[31] = true;
                        $jacocoInit[32] = true;
                        return z;
                    }
                }
            }
        }
        $jacocoInit[30] = true;
        z = true;
        $jacocoInit[32] = true;
        return z;
    }
}
