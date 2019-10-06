package p005cm.aptoide.p006pt.home.apps;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.home.apps.StateApp.Status;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.Install.InstallationStatus;

/* renamed from: cm.aptoide.pt.home.apps.AppMapper */
public class AppMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.home.apps.AppMapper$1 */
    static /* synthetic */ class C34961 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus = new int[InstallationStatus.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8644783818037681243L, "cm/aptoide/pt/home/apps/AppMapper$1", 22);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.GENERIC_ERROR.ordinal()] = 1;
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
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    try {
                                        $jacocoInit[12] = true;
                                    } catch (NoSuchFieldError e7) {
                                        try {
                                            $jacocoInit[14] = true;
                                        } catch (NoSuchFieldError e8) {
                                            try {
                                                $jacocoInit[16] = true;
                                            } catch (NoSuchFieldError e9) {
                                                try {
                                                    $jacocoInit[18] = true;
                                                } catch (NoSuchFieldError e10) {
                                                    $jacocoInit[20] = true;
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
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.INSTALLATION_TIMEOUT.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.NOT_ENOUGH_SPACE_ERROR.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.PAUSED.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.IN_QUEUE.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.INITIAL_STATE.ordinal()] = 6;
            $jacocoInit[11] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.DOWNLOADING.ordinal()] = 7;
            $jacocoInit[13] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.INSTALLING.ordinal()] = 8;
            $jacocoInit[15] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.INSTALLED.ordinal()] = 9;
            $jacocoInit[17] = true;
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[InstallationStatus.UNINSTALLED.ordinal()] = 10;
            $jacocoInit[19] = true;
            $jacocoInit[21] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4998446896537063700L, "cm/aptoide/pt/home/apps/AppMapper", 47);
        $jacocoData = probes;
        return probes;
    }

    public AppMapper() {
        $jacocoInit()[0] = true;
    }

    public List<App> getDownloadApps(List<Install> installations) {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> downloadsList = new ArrayList<>();
        $jacocoInit[1] = true;
        int i = 0;
        $jacocoInit[2] = true;
        while (i < installations.size()) {
            $jacocoInit[3] = true;
            Install install = (Install) installations.get(i);
            $jacocoInit[4] = true;
            String appName = install.getAppName();
            String md5 = install.getMd5();
            String packageName = install.getPackageName();
            $jacocoInit[5] = true;
            String icon = install.getIcon();
            int progress = install.getProgress();
            boolean isIndeterminate = install.isIndeterminate();
            $jacocoInit[6] = true;
            DownloadApp downloadApp = new DownloadApp(appName, md5, packageName, icon, progress, isIndeterminate, install.getVersionCode(), mapDownloadStatus(install.getState()));
            $jacocoInit[7] = true;
            downloadsList.add(downloadApp);
            i++;
            $jacocoInit[8] = true;
        }
        List<Install> list = installations;
        $jacocoInit[9] = true;
        return downloadsList;
    }

    private Status mapDownloadStatus(InstallationStatus installationStatus) {
        Status status;
        boolean[] $jacocoInit = $jacocoInit();
        switch (C34961.$SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[installationStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                status = Status.ERROR;
                $jacocoInit[10] = true;
                break;
            case 4:
            case 5:
            case 6:
                status = Status.STANDBY;
                $jacocoInit[11] = true;
                break;
            case 7:
                status = Status.ACTIVE;
                $jacocoInit[12] = true;
                break;
            case 8:
                status = Status.INSTALLING;
                $jacocoInit[13] = true;
                break;
            case 9:
            case 10:
                status = Status.COMPLETED;
                $jacocoInit[14] = true;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid installation status");
                $jacocoInit[15] = true;
                throw illegalStateException;
        }
        $jacocoInit[16] = true;
        return status;
    }

    public List<App> mapInstalledToInstalledApps(List<Installed> installeds) {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> installedAppsList = new ArrayList<>();
        $jacocoInit[17] = true;
        $jacocoInit[18] = true;
        for (Installed installed : installeds) {
            $jacocoInit[19] = true;
            String name = installed.getName();
            String packageName = installed.getPackageName();
            $jacocoInit[20] = true;
            InstalledApp installedApp = new InstalledApp(name, packageName, installed.getVersionName(), installed.getIcon());
            $jacocoInit[21] = true;
            installedAppsList.add(installedApp);
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
        return installedAppsList;
    }

    public List<App> mapUpdateToUpdateAppList(List<Update> updates) {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> updatesList = new ArrayList<>();
        $jacocoInit[24] = true;
        $jacocoInit[25] = true;
        for (Update update : updates) {
            $jacocoInit[26] = true;
            String label = update.getLabel();
            String md5 = update.getMd5();
            String icon = update.getIcon();
            $jacocoInit[27] = true;
            String packageName = update.getPackageName();
            String updateVersionName = update.getUpdateVersionName();
            int versionCode = update.getVersionCode();
            Status status = Status.UPDATE;
            $jacocoInit[28] = true;
            UpdateApp updateApp = new UpdateApp(label, md5, icon, packageName, 0, false, updateVersionName, versionCode, status, update.getAppId());
            $jacocoInit[29] = true;
            updatesList.add(updateApp);
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
        return updatesList;
    }

    public List<App> getUpdatesList(List<Install> installs) {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> updatesList = new ArrayList<>();
        $jacocoInit[32] = true;
        $jacocoInit[33] = true;
        for (Install install : installs) {
            $jacocoInit[34] = true;
            String appName = install.getAppName();
            String md5 = install.getMd5();
            String icon = install.getIcon();
            $jacocoInit[35] = true;
            String packageName = install.getPackageName();
            int progress = install.getProgress();
            boolean isIndeterminate = install.isIndeterminate();
            $jacocoInit[36] = true;
            UpdateApp updateApp = new UpdateApp(appName, md5, icon, packageName, progress, isIndeterminate, install.getVersionName(), install.getVersionCode(), mapUpdateStatus(install.getState()), -1);
            $jacocoInit[37] = true;
            updatesList.add(updateApp);
            $jacocoInit[38] = true;
        }
        $jacocoInit[39] = true;
        return updatesList;
    }

    private Status mapUpdateStatus(InstallationStatus state) {
        Status status;
        boolean[] $jacocoInit = $jacocoInit();
        switch (C34961.$SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[state.ordinal()]) {
            case 1:
            case 2:
            case 3:
                status = Status.ERROR;
                $jacocoInit[40] = true;
                break;
            case 4:
            case 5:
            case 6:
                status = Status.STANDBY;
                $jacocoInit[41] = true;
                break;
            case 7:
                status = Status.UPDATING;
                $jacocoInit[42] = true;
                break;
            case 8:
                status = Status.INSTALLING;
                $jacocoInit[44] = true;
                break;
            case 9:
            case 10:
                status = Status.UPDATE;
                $jacocoInit[43] = true;
                break;
            default:
                status = Status.UPDATE;
                $jacocoInit[45] = true;
                break;
        }
        $jacocoInit[46] = true;
        return status;
    }
}
