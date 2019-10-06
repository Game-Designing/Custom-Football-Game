package p005cm.aptoide.p006pt.home.apps;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.apps.App.Type;
import p005cm.aptoide.p006pt.home.apps.StateApp.Status;

/* renamed from: cm.aptoide.pt.home.apps.AppsAdapter */
public class AppsAdapter extends C0970a<AppsViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    static final int ACTIVE_DOWNLOAD = 3;
    static final int COMPLETED_DOWNLOAD = 5;
    static final int ERROR_DOWNLOAD = 6;
    static final int ERROR_UPDATE = 11;
    static final int HEADER_DOWNLOADS = 0;
    static final int HEADER_INSTALLED = 1;
    static final int HEADER_UPDATES = 2;
    protected static final int INSTALLED = 7;
    static final int INSTALLING = 14;
    static final int PAUSING_DOWNLOAD = 13;
    static final int PAUSING_UPDATE = 12;
    static final int STANDBY_DOWNLOAD = 4;
    static final int STANDBY_UPDATE = 10;
    protected static final int UPDATE = 8;
    static final int UPDATING = 9;
    private AppsCardViewHolderFactory appsCardViewHolderFactory;
    private List<App> listOfApps;

    /* renamed from: cm.aptoide.pt.home.apps.AppsAdapter$1 */
    static /* synthetic */ class C34981 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$apps$App$Type = new int[Type.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status = new int[Status.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-3533000834706465117L, "cm/aptoide/pt/home/apps/AppsAdapter$1", 31);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.UPDATE.ordinal()] = 1;
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
                                            $jacocoInit[16] = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.UPDATING.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.STANDBY.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.ERROR.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.PAUSING.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.INSTALLING.ordinal()] = 6;
            $jacocoInit[11] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.ACTIVE.ordinal()] = 7;
            $jacocoInit[13] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.COMPLETED.ordinal()] = 8;
            $jacocoInit[15] = true;
            try {
                $jacocoInit[17] = true;
                $SwitchMap$cm$aptoide$pt$home$apps$App$Type[Type.HEADER_DOWNLOADS.ordinal()] = 1;
                $jacocoInit[18] = true;
            } catch (NoSuchFieldError e9) {
                try {
                    $jacocoInit[19] = true;
                } catch (NoSuchFieldError e10) {
                    try {
                        $jacocoInit[21] = true;
                    } catch (NoSuchFieldError e11) {
                        try {
                            $jacocoInit[23] = true;
                        } catch (NoSuchFieldError e12) {
                            try {
                                $jacocoInit[25] = true;
                            } catch (NoSuchFieldError e13) {
                                try {
                                    $jacocoInit[27] = true;
                                } catch (NoSuchFieldError e14) {
                                    $jacocoInit[29] = true;
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$home$apps$App$Type[Type.HEADER_INSTALLED.ordinal()] = 2;
            $jacocoInit[20] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$App$Type[Type.HEADER_UPDATES.ordinal()] = 3;
            $jacocoInit[22] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$App$Type[Type.DOWNLOAD.ordinal()] = 4;
            $jacocoInit[24] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$App$Type[Type.UPDATE.ordinal()] = 5;
            $jacocoInit[26] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$App$Type[Type.INSTALLED.ordinal()] = 6;
            $jacocoInit[28] = true;
            $jacocoInit[30] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(859012998847281990L, "cm/aptoide/pt/home/apps/AppsAdapter", 221);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((AppsViewHolder) wVar, i);
        $jacocoInit[213] = true;
    }

    public AppsAdapter(List<App> listOfApps2, AppsCardViewHolderFactory appsCardViewHolderFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.listOfApps = listOfApps2;
        this.appsCardViewHolderFactory = appsCardViewHolderFactory2;
        $jacocoInit[0] = true;
    }

    public AppsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsViewHolder createViewHolder = this.appsCardViewHolderFactory.createViewHolder(viewType, parent);
        $jacocoInit[1] = true;
        return createViewHolder;
    }

    public void onBindViewHolder(AppsViewHolder appsViewHolder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        appsViewHolder.setApp((App) this.listOfApps.get(position));
        $jacocoInit[2] = true;
    }

    public int getItemViewType(int position) {
        int type;
        boolean[] $jacocoInit = $jacocoInit();
        App item = (App) this.listOfApps.get(position);
        $jacocoInit[3] = true;
        switch (C34981.$SwitchMap$cm$aptoide$pt$home$apps$App$Type[item.getType().ordinal()]) {
            case 1:
                type = 0;
                $jacocoInit[4] = true;
                break;
            case 2:
                type = 1;
                $jacocoInit[5] = true;
                break;
            case 3:
                type = 2;
                $jacocoInit[6] = true;
                break;
            case 4:
                type = getDownloadType(((DownloadApp) item).getStatus());
                $jacocoInit[7] = true;
                break;
            case 5:
                type = getUpdateType(((UpdateApp) item).getStatus());
                $jacocoInit[8] = true;
                break;
            case 6:
                type = 7;
                $jacocoInit[9] = true;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid type of App");
                $jacocoInit[10] = true;
                throw illegalArgumentException;
        }
        $jacocoInit[11] = true;
        return type;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.listOfApps.size();
        $jacocoInit[12] = true;
        return size;
    }

    private int getUpdateType(Status updateStatus) {
        int type;
        boolean[] $jacocoInit = $jacocoInit();
        switch (C34981.$SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[updateStatus.ordinal()]) {
            case 1:
                type = 8;
                $jacocoInit[13] = true;
                break;
            case 2:
                type = 9;
                $jacocoInit[14] = true;
                break;
            case 3:
                type = 10;
                $jacocoInit[15] = true;
                break;
            case 4:
                type = 11;
                $jacocoInit[16] = true;
                break;
            case 5:
                type = 12;
                $jacocoInit[17] = true;
                break;
            case 6:
                type = 14;
                $jacocoInit[18] = true;
                break;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Wrong download status : ");
                sb.append(updateStatus.name());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
                $jacocoInit[19] = true;
                throw illegalArgumentException;
        }
        $jacocoInit[20] = true;
        return type;
    }

    private int getDownloadType(Status downloadStatus) {
        int type;
        boolean[] $jacocoInit = $jacocoInit();
        switch (C34981.$SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[downloadStatus.ordinal()]) {
            case 3:
                type = 4;
                $jacocoInit[22] = true;
                break;
            case 4:
                type = 6;
                $jacocoInit[24] = true;
                break;
            case 5:
                type = 13;
                $jacocoInit[25] = true;
                break;
            case 6:
                type = 14;
                $jacocoInit[26] = true;
                break;
            case 7:
                type = 3;
                $jacocoInit[21] = true;
                break;
            case 8:
                type = 5;
                $jacocoInit[23] = true;
                break;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Wrong download status : ");
                sb.append(downloadStatus.name());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
                $jacocoInit[27] = true;
                throw illegalArgumentException;
        }
        $jacocoInit[28] = true;
        return type;
    }

    private void addApps(List<App> list, int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[29] = true;
        while (i < list.size()) {
            $jacocoInit[30] = true;
            if (isValid((App) list.get(i))) {
                $jacocoInit[31] = true;
                if (this.listOfApps.contains(list.get(i))) {
                    $jacocoInit[32] = true;
                    int itemIndex = this.listOfApps.indexOf(list.get(i));
                    $jacocoInit[33] = true;
                    App actualApp = (App) this.listOfApps.get(itemIndex);
                    $jacocoInit[34] = true;
                    App newApp = (App) list.get(i);
                    if (!(actualApp instanceof StateApp)) {
                        $jacocoInit[35] = true;
                    } else if (!(newApp instanceof StateApp)) {
                        $jacocoInit[36] = true;
                    } else {
                        $jacocoInit[37] = true;
                        if (!shouldUpdateStateApp((StateApp) actualApp, (StateApp) newApp)) {
                            $jacocoInit[38] = true;
                        } else {
                            $jacocoInit[39] = true;
                            if (((StateApp) actualApp).getStatus() == Status.PAUSING) {
                                $jacocoInit[40] = true;
                                if (!shouldUpdatePausingApp((StateApp) newApp)) {
                                    $jacocoInit[41] = true;
                                } else {
                                    $jacocoInit[42] = true;
                                    updateApp(list, i, itemIndex);
                                    $jacocoInit[43] = true;
                                }
                            } else {
                                updateApp(list, i, itemIndex);
                                $jacocoInit[44] = true;
                            }
                        }
                        $jacocoInit[48] = true;
                    }
                    if (list.get(i) == this.listOfApps.get(itemIndex)) {
                        $jacocoInit[45] = true;
                    } else {
                        $jacocoInit[46] = true;
                        updateApp(list, i, itemIndex);
                        $jacocoInit[47] = true;
                    }
                    $jacocoInit[48] = true;
                } else {
                    this.listOfApps.add(offset + 1, list.get(i));
                    $jacocoInit[49] = true;
                    notifyItemInserted(offset + 1);
                    $jacocoInit[50] = true;
                }
            } else if (!this.listOfApps.contains(list.get(i))) {
                $jacocoInit[51] = true;
            } else {
                $jacocoInit[52] = true;
                int itemIndex2 = this.listOfApps.indexOf(list.get(i));
                $jacocoInit[53] = true;
                this.listOfApps.remove(itemIndex2);
                $jacocoInit[54] = true;
                notifyItemRemoved(itemIndex2);
                $jacocoInit[55] = true;
            }
            i++;
            $jacocoInit[56] = true;
        }
        $jacocoInit[57] = true;
    }

    private boolean shouldUpdateStateApp(StateApp actualApp, StateApp newApp) {
        boolean hasSameStatus;
        boolean hasSameProgress;
        boolean hasSameIndeterminateStatus;
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (actualApp.getStatus() == newApp.getStatus()) {
            $jacocoInit[58] = true;
            hasSameStatus = true;
        } else {
            $jacocoInit[59] = true;
            hasSameStatus = false;
        }
        $jacocoInit[60] = true;
        if (actualApp.getProgress() == newApp.getProgress()) {
            $jacocoInit[61] = true;
            hasSameProgress = true;
        } else {
            $jacocoInit[62] = true;
            hasSameProgress = false;
        }
        $jacocoInit[63] = true;
        if (actualApp.isIndeterminate() == newApp.isIndeterminate()) {
            $jacocoInit[64] = true;
            hasSameIndeterminateStatus = true;
        } else {
            $jacocoInit[65] = true;
            hasSameIndeterminateStatus = false;
        }
        if (!hasSameStatus) {
            $jacocoInit[66] = true;
        } else if (!hasSameProgress) {
            $jacocoInit[67] = true;
        } else if (!hasSameIndeterminateStatus) {
            $jacocoInit[68] = true;
        } else {
            $jacocoInit[70] = true;
            $jacocoInit[71] = true;
            return z;
        }
        $jacocoInit[69] = true;
        z = true;
        $jacocoInit[71] = true;
        return z;
    }

    private void updateApp(List<App> list, int i, int itemIndex) {
        boolean[] $jacocoInit = $jacocoInit();
        this.listOfApps.set(itemIndex, list.get(i));
        $jacocoInit[72] = true;
        notifyItemChanged(itemIndex);
        $jacocoInit[73] = true;
    }

    private boolean shouldUpdatePausingApp(StateApp app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (app.getStatus() == Status.STANDBY) {
            $jacocoInit[74] = true;
        } else if (app.getStatus() == Status.ERROR) {
            $jacocoInit[75] = true;
        } else {
            z = false;
            $jacocoInit[77] = true;
            $jacocoInit[78] = true;
            return z;
        }
        $jacocoInit[76] = true;
        z = true;
        $jacocoInit[78] = true;
        return z;
    }

    public void addUpdateAppsList(List<App> updatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        int headerPosition = findHeaderPosition(Type.HEADER_UPDATES);
        if (headerPosition != -1) {
            $jacocoInit[79] = true;
        } else {
            $jacocoInit[80] = true;
            int headerPosition2 = findLastDownloadPosition();
            $jacocoInit[81] = true;
            this.listOfApps.add(headerPosition2 + 1, new Header(Type.HEADER_UPDATES));
            $jacocoInit[82] = true;
            notifyItemInserted(headerPosition2 + 1);
            headerPosition = headerPosition2 + 1;
            $jacocoInit[83] = true;
        }
        addApps(updatesList, headerPosition);
        $jacocoInit[84] = true;
    }

    private int findLastDownloadPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int lastDownloadPosition = -1;
        $jacocoInit[85] = true;
        int i = 0;
        $jacocoInit[86] = true;
        while (i < this.listOfApps.size()) {
            $jacocoInit[87] = true;
            App app = (App) this.listOfApps.get(i);
            $jacocoInit[88] = true;
            if (app.getType() != Type.DOWNLOAD) {
                $jacocoInit[89] = true;
            } else {
                lastDownloadPosition = i;
                $jacocoInit[90] = true;
            }
            i++;
            $jacocoInit[91] = true;
        }
        $jacocoInit[92] = true;
        return lastDownloadPosition;
    }

    public void addInstalledAppsList(List<App> installedApps) {
        boolean[] $jacocoInit = $jacocoInit();
        int headerPosition = findHeaderPosition(Type.HEADER_INSTALLED);
        if (headerPosition != -1) {
            $jacocoInit[93] = true;
        } else {
            $jacocoInit[94] = true;
            int headerPosition2 = findLastUpdatePosition();
            if (headerPosition2 != -1) {
                $jacocoInit[95] = true;
            } else {
                $jacocoInit[96] = true;
                headerPosition2 = findLastDownloadPosition();
                $jacocoInit[97] = true;
            }
            this.listOfApps.add(headerPosition2 + 1, new Header(Type.HEADER_INSTALLED));
            $jacocoInit[98] = true;
            notifyItemInserted(headerPosition2 + 1);
            headerPosition = headerPosition2 + 1;
            $jacocoInit[99] = true;
        }
        this.listOfApps.addAll(headerPosition + 1, installedApps);
        $jacocoInit[100] = true;
    }

    private int findLastUpdatePosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int lastUpdatePosition = -1;
        $jacocoInit[101] = true;
        int i = 0;
        $jacocoInit[102] = true;
        while (i < this.listOfApps.size()) {
            $jacocoInit[103] = true;
            App app = (App) this.listOfApps.get(i);
            $jacocoInit[104] = true;
            if (app.getType() != Type.UPDATE) {
                $jacocoInit[105] = true;
            } else {
                lastUpdatePosition = i;
                $jacocoInit[106] = true;
            }
            i++;
            $jacocoInit[107] = true;
        }
        $jacocoInit[108] = true;
        return lastUpdatePosition;
    }

    public void addDownloadAppsList(List<App> downloadsList) {
        boolean[] $jacocoInit = $jacocoInit();
        int headerPosition = findHeaderPosition(Type.HEADER_DOWNLOADS);
        if (headerPosition != -1) {
            $jacocoInit[109] = true;
        } else {
            $jacocoInit[110] = true;
            this.listOfApps.add(headerPosition + 1, new Header(Type.HEADER_DOWNLOADS));
            headerPosition++;
            $jacocoInit[111] = true;
            notifyItemInserted(headerPosition + 1);
            $jacocoInit[112] = true;
        }
        addApps(downloadsList, headerPosition);
        $jacocoInit[113] = true;
    }

    private int findHeaderPosition(Type headerToFind) {
        boolean[] $jacocoInit = $jacocoInit();
        if (headerToFind == Type.HEADER_DOWNLOADS) {
            $jacocoInit[114] = true;
        } else if (headerToFind == Type.HEADER_INSTALLED) {
            $jacocoInit[115] = true;
        } else if (headerToFind == Type.HEADER_UPDATES) {
            $jacocoInit[116] = true;
        } else {
            $jacocoInit[117] = true;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The argument must be a type of header ");
            $jacocoInit[118] = true;
            throw illegalArgumentException;
        }
        int i = 0;
        $jacocoInit[119] = true;
        while (i < this.listOfApps.size()) {
            $jacocoInit[120] = true;
            App app = (App) this.listOfApps.get(i);
            $jacocoInit[121] = true;
            if (app.getType() == headerToFind) {
                $jacocoInit[122] = true;
                return i;
            }
            i++;
            $jacocoInit[123] = true;
        }
        $jacocoInit[124] = true;
        return -1;
    }

    public void removeUpdatesList(List<App> updatesToRemove) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[125] = true;
        for (App app : updatesToRemove) {
            if (!(app instanceof UpdateApp)) {
                $jacocoInit[126] = true;
            } else {
                $jacocoInit[127] = true;
                if (!this.listOfApps.contains((UpdateApp) app)) {
                    $jacocoInit[128] = true;
                } else {
                    $jacocoInit[129] = true;
                    int indexOfExcludedApp = this.listOfApps.indexOf((UpdateApp) app);
                    $jacocoInit[130] = true;
                    this.listOfApps.remove(indexOfExcludedApp);
                    $jacocoInit[131] = true;
                    notifyItemRemoved(indexOfExcludedApp);
                    $jacocoInit[132] = true;
                }
            }
            $jacocoInit[133] = true;
        }
        $jacocoInit[134] = true;
    }

    public void removeInstalledDownloads(List<App> installedDownloadsList) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[135] = true;
        for (Object next : installedDownloadsList) {
            $jacocoInit[136] = true;
            if (!this.listOfApps.contains((DownloadApp) next)) {
                $jacocoInit[137] = true;
            } else {
                $jacocoInit[138] = true;
                int indexOfInstalledApp = this.listOfApps.indexOf((DownloadApp) next);
                $jacocoInit[139] = true;
                this.listOfApps.remove((DownloadApp) next);
                $jacocoInit[140] = true;
                notifyItemRemoved(indexOfInstalledApp);
                $jacocoInit[141] = true;
            }
            $jacocoInit[142] = true;
        }
        removeDownloadsHeader();
        $jacocoInit[143] = true;
    }

    private void removeDownloadsHeader() {
        boolean[] $jacocoInit = $jacocoInit();
        if (countNumberOfAppsByType(Type.DOWNLOAD) != 0) {
            $jacocoInit[144] = true;
        } else {
            $jacocoInit[145] = true;
            int downloadsHeaderPosition = findHeaderPosition(Type.HEADER_DOWNLOADS);
            if (downloadsHeaderPosition <= -1) {
                $jacocoInit[146] = true;
            } else {
                $jacocoInit[147] = true;
                this.listOfApps.remove(downloadsHeaderPosition);
                $jacocoInit[148] = true;
                notifyItemRemoved(downloadsHeaderPosition);
                $jacocoInit[149] = true;
            }
        }
        $jacocoInit[150] = true;
    }

    private int countNumberOfAppsByType(Type type) {
        boolean[] $jacocoInit = $jacocoInit();
        int appsByType = 0;
        $jacocoInit[151] = true;
        $jacocoInit[152] = true;
        for (App app : this.listOfApps) {
            $jacocoInit[153] = true;
            if (app.getType() != type) {
                $jacocoInit[154] = true;
            } else {
                appsByType++;
                $jacocoInit[155] = true;
            }
            $jacocoInit[156] = true;
        }
        $jacocoInit[157] = true;
        return appsByType;
    }

    public void removeCanceledAppDownload(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.listOfApps.contains(app)) {
            $jacocoInit[158] = true;
        } else {
            $jacocoInit[159] = true;
            int indexOfCanceledDownload = this.listOfApps.indexOf(app);
            $jacocoInit[160] = true;
            this.listOfApps.remove(app);
            $jacocoInit[161] = true;
            notifyItemRemoved(indexOfCanceledDownload);
            $jacocoInit[162] = true;
        }
        $jacocoInit[163] = true;
    }

    private boolean isValid(App app) {
        boolean isValid;
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        switch (C34981.$SwitchMap$cm$aptoide$pt$home$apps$App$Type[app.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                isValid = true;
                $jacocoInit[164] = true;
                break;
            case 4:
                if (!TextUtils.isEmpty(((DownloadApp) app).getName())) {
                    $jacocoInit[165] = true;
                    z = true;
                } else {
                    $jacocoInit[166] = true;
                }
                isValid = z;
                $jacocoInit[167] = true;
                break;
            case 5:
                if (!TextUtils.isEmpty(((UpdateApp) app).getName())) {
                    $jacocoInit[168] = true;
                    z = true;
                } else {
                    $jacocoInit[169] = true;
                }
                isValid = z;
                $jacocoInit[170] = true;
                break;
            case 6:
                if (!TextUtils.isEmpty(((InstalledApp) app).getAppName())) {
                    $jacocoInit[171] = true;
                    z = true;
                } else {
                    $jacocoInit[172] = true;
                }
                isValid = z;
                $jacocoInit[173] = true;
                break;
            default:
                isValid = false;
                $jacocoInit[174] = true;
                break;
        }
        $jacocoInit[175] = true;
        return isValid;
    }

    public List<App> getUpdateApps() {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> updateApps = new ArrayList<>();
        $jacocoInit[176] = true;
        $jacocoInit[177] = true;
        for (App app : this.listOfApps) {
            $jacocoInit[178] = true;
            if (app.getType() != Type.UPDATE) {
                $jacocoInit[179] = true;
            } else {
                $jacocoInit[180] = true;
                updateApps.add(app);
                $jacocoInit[181] = true;
            }
            $jacocoInit[182] = true;
        }
        $jacocoInit[183] = true;
        return updateApps;
    }

    public void setAvailableUpdatesList(List<App> availableUpdates) {
        boolean[] $jacocoInit = $jacocoInit();
        this.listOfApps.removeAll(getUpdatesToRemove(availableUpdates));
        $jacocoInit[184] = true;
        notifyDataSetChanged();
        $jacocoInit[185] = true;
        addUpdateAppsList(availableUpdates);
        $jacocoInit[186] = true;
        Collections.sort(this.listOfApps, C3695g.f7098a);
        $jacocoInit[187] = true;
    }

    /* renamed from: a */
    static /* synthetic */ int m8208a(App app1, App app2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (app1.getType() != Type.UPDATE) {
            $jacocoInit[215] = true;
        } else if (app2.getType() != Type.UPDATE) {
            $jacocoInit[216] = true;
        } else {
            $jacocoInit[217] = true;
            String name = ((UpdateApp) app1).getName();
            UpdateApp updateApp = (UpdateApp) app2;
            $jacocoInit[218] = true;
            int compareTo = name.compareTo(updateApp.getName());
            $jacocoInit[219] = true;
            return compareTo;
        }
        $jacocoInit[220] = true;
        return 0;
    }

    private List<App> getUpdatesToRemove(List<App> updatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> updatesToRemove = getUpdateApps();
        $jacocoInit[188] = true;
        updatesToRemove.removeAll(updatesList);
        $jacocoInit[189] = true;
        return updatesToRemove;
    }

    public void setAppStandby(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        int indexOfApp = this.listOfApps.indexOf(app);
        if (indexOfApp == -1) {
            $jacocoInit[190] = true;
        } else {
            $jacocoInit[191] = true;
            App application = (App) this.listOfApps.get(indexOfApp);
            if (!(application instanceof StateApp)) {
                $jacocoInit[192] = true;
            } else {
                $jacocoInit[193] = true;
                setIndeterminate(indexOfApp, (StateApp) application);
                $jacocoInit[194] = true;
            }
        }
        $jacocoInit[195] = true;
    }

    private void setIndeterminate(int indexOfApp, StateApp application) {
        boolean[] $jacocoInit = $jacocoInit();
        application.setIndeterminate(true);
        $jacocoInit[196] = true;
        application.setStatus(Status.STANDBY);
        $jacocoInit[197] = true;
        notifyItemChanged(indexOfApp);
        $jacocoInit[198] = true;
    }

    public void setAllUpdatesIndeterminate() {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> updatesList = getUpdateApps();
        $jacocoInit[199] = true;
        $jacocoInit[200] = true;
        for (Object next : updatesList) {
            $jacocoInit[201] = true;
            setAppStandby((UpdateApp) next);
            $jacocoInit[202] = true;
        }
        $jacocoInit[203] = true;
    }

    public void setAppOnPausing(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        int indexOfApp = this.listOfApps.indexOf(app);
        if (indexOfApp == -1) {
            $jacocoInit[204] = true;
        } else {
            $jacocoInit[205] = true;
            App application = (App) this.listOfApps.get(indexOfApp);
            if (!(application instanceof StateApp)) {
                $jacocoInit[206] = true;
            } else {
                $jacocoInit[207] = true;
                setAppPausing(indexOfApp, (StateApp) application);
                $jacocoInit[208] = true;
            }
        }
        $jacocoInit[209] = true;
    }

    private void setAppPausing(int indexOfApp, StateApp application) {
        boolean[] $jacocoInit = $jacocoInit();
        application.setStatus(Status.PAUSING);
        $jacocoInit[210] = true;
        application.setIndeterminate(true);
        $jacocoInit[211] = true;
        notifyItemChanged(indexOfApp);
        $jacocoInit[212] = true;
    }
}
