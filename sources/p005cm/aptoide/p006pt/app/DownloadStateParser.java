package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadModel.DownloadState;
import p005cm.aptoide.p006pt.download.InstallType;
import p005cm.aptoide.p006pt.download.Origin;
import p005cm.aptoide.p006pt.install.Install.InstallationStatus;
import p005cm.aptoide.p006pt.install.Install.InstallationType;

/* renamed from: cm.aptoide.pt.app.DownloadStateParser */
public class DownloadStateParser {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.app.DownloadStateParser$1 */
    static /* synthetic */ class C16981 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = new int[Action.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus = new int[InstallationStatus.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$install$Install$InstallationType = new int[InstallationType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-5938457950260486460L, "cm/aptoide/pt/app/DownloadStateParser$1", 40);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.INSTALL.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            $jacocoInit[8] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.UPDATE.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.DOWNGRADE.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.MIGRATE.ordinal()] = 4;
            $jacocoInit[7] = true;
            try {
                $jacocoInit[9] = true;
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationType[InstallationType.INSTALLED.ordinal()] = 1;
                $jacocoInit[10] = true;
            } catch (NoSuchFieldError e5) {
                try {
                    $jacocoInit[11] = true;
                } catch (NoSuchFieldError e6) {
                    try {
                        $jacocoInit[13] = true;
                    } catch (NoSuchFieldError e7) {
                        try {
                            $jacocoInit[15] = true;
                        } catch (NoSuchFieldError e8) {
                            $jacocoInit[17] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationType[InstallationType.INSTALL.ordinal()] = 2;
            $jacocoInit[12] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationType[InstallationType.DOWNGRADE.ordinal()] = 3;
            $jacocoInit[14] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationType[InstallationType.UPDATE.ordinal()] = 4;
            $jacocoInit[16] = true;
            try {
                $jacocoInit[18] = true;
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.DOWNLOADING.ordinal()] = 1;
                $jacocoInit[19] = true;
            } catch (NoSuchFieldError e9) {
                try {
                    $jacocoInit[20] = true;
                } catch (NoSuchFieldError e10) {
                    try {
                        $jacocoInit[22] = true;
                    } catch (NoSuchFieldError e11) {
                        try {
                            $jacocoInit[24] = true;
                        } catch (NoSuchFieldError e12) {
                            try {
                                $jacocoInit[26] = true;
                            } catch (NoSuchFieldError e13) {
                                try {
                                    $jacocoInit[28] = true;
                                } catch (NoSuchFieldError e14) {
                                    try {
                                        $jacocoInit[30] = true;
                                    } catch (NoSuchFieldError e15) {
                                        try {
                                            $jacocoInit[32] = true;
                                        } catch (NoSuchFieldError e16) {
                                            try {
                                                $jacocoInit[34] = true;
                                            } catch (NoSuchFieldError e17) {
                                                try {
                                                    $jacocoInit[36] = true;
                                                } catch (NoSuchFieldError e18) {
                                                    $jacocoInit[38] = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.PAUSED.ordinal()] = 2;
            $jacocoInit[21] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.IN_QUEUE.ordinal()] = 3;
            $jacocoInit[23] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.INITIAL_STATE.ordinal()] = 4;
            $jacocoInit[25] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.INSTALLED.ordinal()] = 5;
            $jacocoInit[27] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.UNINSTALLED.ordinal()] = 6;
            $jacocoInit[29] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.INSTALLATION_TIMEOUT.ordinal()] = 7;
            $jacocoInit[31] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.GENERIC_ERROR.ordinal()] = 8;
            $jacocoInit[33] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.NOT_ENOUGH_SPACE_ERROR.ordinal()] = 9;
            $jacocoInit[35] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.INSTALLING.ordinal()] = 10;
            $jacocoInit[37] = true;
            $jacocoInit[39] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3930337634584590957L, "cm/aptoide/pt/app/DownloadStateParser", 33);
        $jacocoData = probes;
        return probes;
    }

    public DownloadStateParser() {
        $jacocoInit()[0] = true;
    }

    public DownloadState parseDownloadState(InstallationStatus state) {
        DownloadState downloadState;
        boolean[] $jacocoInit = $jacocoInit();
        switch (C16981.$SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[state.ordinal()]) {
            case 1:
                downloadState = DownloadState.ACTIVE;
                $jacocoInit[1] = true;
                break;
            case 2:
                downloadState = DownloadState.PAUSE;
                $jacocoInit[2] = true;
                break;
            case 3:
            case 4:
                downloadState = DownloadState.INDETERMINATE;
                $jacocoInit[3] = true;
                break;
            case 5:
                downloadState = DownloadState.COMPLETE;
                $jacocoInit[4] = true;
                break;
            case 6:
                downloadState = DownloadState.COMPLETE;
                $jacocoInit[5] = true;
                break;
            case 7:
            case 8:
                downloadState = DownloadState.ERROR;
                $jacocoInit[6] = true;
                break;
            case 9:
                downloadState = DownloadState.NOT_ENOUGH_STORAGE_ERROR;
                $jacocoInit[7] = true;
                break;
            case 10:
                downloadState = DownloadState.INSTALLING;
                $jacocoInit[8] = true;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Wrong type of download state");
                $jacocoInit[9] = true;
                throw illegalStateException;
        }
        $jacocoInit[10] = true;
        return downloadState;
    }

    public Action parseDownloadType(InstallationType type, boolean paidApp, boolean wasPaid, boolean isMigration) {
        Action action;
        boolean[] $jacocoInit = $jacocoInit();
        if (!paidApp) {
            $jacocoInit[11] = true;
        } else if (wasPaid) {
            $jacocoInit[12] = true;
        } else {
            action = Action.PAY;
            $jacocoInit[13] = true;
            $jacocoInit[20] = true;
            return action;
        }
        if (isMigration) {
            action = Action.MIGRATE;
            $jacocoInit[14] = true;
        } else {
            int i = C16981.$SwitchMap$cm$aptoide$pt$install$Install$InstallationType[type.ordinal()];
            if (i == 1) {
                action = Action.OPEN;
                $jacocoInit[15] = true;
            } else if (i == 2) {
                action = Action.INSTALL;
                $jacocoInit[16] = true;
            } else if (i == 3) {
                action = Action.DOWNGRADE;
                $jacocoInit[17] = true;
            } else if (i != 4) {
                action = Action.INSTALL;
                $jacocoInit[19] = true;
            } else {
                action = Action.UPDATE;
                $jacocoInit[18] = true;
            }
        }
        $jacocoInit[20] = true;
        return action;
    }

    public int parseDownloadAction(Action action) {
        int downloadAction;
        boolean[] $jacocoInit = $jacocoInit();
        int i = C16981.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[action.ordinal()];
        if (i == 1) {
            downloadAction = 0;
            $jacocoInit[21] = true;
        } else if (i == 2) {
            downloadAction = 1;
            $jacocoInit[22] = true;
        } else if (i == 3) {
            downloadAction = 2;
            $jacocoInit[23] = true;
        } else if (i == 4) {
            downloadAction = 2;
            $jacocoInit[24] = true;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid action");
            $jacocoInit[25] = true;
            throw illegalArgumentException;
        }
        $jacocoInit[26] = true;
        return downloadAction;
    }

    public Origin getOrigin(int action) {
        boolean[] $jacocoInit = $jacocoInit();
        if (action == 1) {
            Origin origin = Origin.UPDATE;
            $jacocoInit[28] = true;
            return origin;
        } else if (action != 2) {
            Origin origin2 = Origin.INSTALL;
            $jacocoInit[27] = true;
            return origin2;
        } else {
            Origin origin3 = Origin.DOWNGRADE;
            $jacocoInit[29] = true;
            return origin3;
        }
    }

    public InstallType getInstallType(int action) {
        boolean[] $jacocoInit = $jacocoInit();
        if (action == 1) {
            InstallType installType = InstallType.UPDATE;
            $jacocoInit[31] = true;
            return installType;
        } else if (action != 2) {
            InstallType installType2 = InstallType.INSTALL;
            $jacocoInit[30] = true;
            return installType2;
        } else {
            InstallType installType3 = InstallType.DOWNGRADE;
            $jacocoInit[32] = true;
            return installType3;
        }
    }
}
