package p005cm.aptoide.p006pt.home.apps;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.home.apps.App.Type;
import p005cm.aptoide.p006pt.home.apps.StateApp.Status;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.AppcAppsAdapter */
public class AppcAppsAdapter extends C0970a<AppsViewHolder> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    static final int ERROR_UPDATE = 4;
    static final int PAUSING_UPDATE = 5;
    static final int STANDBY_UPDATE = 3;
    protected static final int UPDATE = 1;
    static final int UPDATING = 2;
    private final C14963c<AppClick> appItemClicks;
    private int limit;
    private List<App> listOfApps;

    /* renamed from: cm.aptoide.pt.home.apps.AppcAppsAdapter$1 */
    static /* synthetic */ class C34971 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status = new int[Status.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2341195535418920482L, "cm/aptoide/pt/home/apps/AppcAppsAdapter$1", 14);
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
                                    $jacocoInit[12] = true;
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
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.INSTALLING.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.ERROR.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[Status.PAUSING.ordinal()] = 6;
            $jacocoInit[11] = true;
            $jacocoInit[13] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3450133250725323218L, "cm/aptoide/pt/home/apps/AppcAppsAdapter", Opcodes.IXOR);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(C1000w wVar, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        onBindViewHolder((AppsViewHolder) wVar, i);
        $jacocoInit[122] = true;
    }

    public AppcAppsAdapter(List<App> listOfApps2, C14963c<AppClick> appItemClicks2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(listOfApps2, appItemClicks2, -1);
        $jacocoInit[0] = true;
    }

    public AppcAppsAdapter(List<App> listOfApps2, C14963c<AppClick> appItemClicks2, int limit2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.listOfApps = listOfApps2;
        this.appItemClicks = appItemClicks2;
        this.limit = limit2;
        $jacocoInit[1] = true;
    }

    public AppsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AppsViewHolder appViewHolder;
        boolean[] $jacocoInit = $jacocoInit();
        if (viewType == 1) {
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            $jacocoInit[2] = true;
            AppsViewHolder appViewHolder2 = new AppcAppViewHolder(from.inflate(C1375R.layout.apps_appc_upgrade_app_item, parent, false), this.appItemClicks);
            $jacocoInit[3] = true;
            appViewHolder = appViewHolder2;
        } else if (viewType == 2) {
            LayoutInflater from2 = LayoutInflater.from(parent.getContext());
            $jacocoInit[4] = true;
            appViewHolder = new UpdatingAppViewHolder(from2.inflate(C1375R.layout.apps_updating_app_item, parent, false), this.appItemClicks, true);
            $jacocoInit[5] = true;
        } else if (viewType == 3) {
            LayoutInflater from3 = LayoutInflater.from(parent.getContext());
            $jacocoInit[6] = true;
            appViewHolder = new StandByUpdateAppViewHolder(from3.inflate(C1375R.layout.apps_standby_update_app_item, parent, false), this.appItemClicks, true);
            $jacocoInit[7] = true;
        } else if (viewType == 4) {
            LayoutInflater from4 = LayoutInflater.from(parent.getContext());
            $jacocoInit[8] = true;
            appViewHolder = new ErrorUpdateAppViewHolder(from4.inflate(C1375R.layout.apps_error_update_app_item, parent, false), this.appItemClicks, true);
            $jacocoInit[9] = true;
        } else if (viewType == 5) {
            LayoutInflater from5 = LayoutInflater.from(parent.getContext());
            $jacocoInit[10] = true;
            appViewHolder = new StandByUpdateAppViewHolder(from5.inflate(C1375R.layout.apps_standby_update_app_item, parent, false), this.appItemClicks, true);
            $jacocoInit[11] = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Wrong cardType");
            sb.append(viewType);
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[12] = true;
            throw illegalStateException;
        }
        $jacocoInit[13] = true;
        return appViewHolder;
    }

    public void onBindViewHolder(AppsViewHolder holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.limit;
        if (i < 0) {
            $jacocoInit[14] = true;
        } else if (position >= i) {
            $jacocoInit[15] = true;
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[16] = true;
        }
        holder.setApp((App) this.listOfApps.get(position));
        $jacocoInit[17] = true;
        $jacocoInit[18] = true;
    }

    public int getItemViewType(int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Object obj = this.listOfApps.get(position);
        $jacocoInit[19] = true;
        Status status = ((UpdateApp) obj).getStatus();
        $jacocoInit[20] = true;
        switch (C34971.$SwitchMap$cm$aptoide$pt$home$apps$StateApp$Status[status.ordinal()]) {
            case 1:
                $jacocoInit[21] = true;
                return 1;
            case 2:
                $jacocoInit[22] = true;
                return 2;
            case 3:
            case 4:
                $jacocoInit[23] = true;
                return 3;
            case 5:
                $jacocoInit[24] = true;
                return 4;
            case 6:
                $jacocoInit[25] = true;
                return 5;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Wrong download status : ");
                sb.append(status.name());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
                $jacocoInit[26] = true;
                throw illegalArgumentException;
        }
    }

    public int getItemCount() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.limit <= 0) {
            $jacocoInit[27] = true;
        } else {
            int size = this.listOfApps.size();
            i = this.limit;
            if (size <= i) {
                $jacocoInit[28] = true;
            } else {
                $jacocoInit[29] = true;
                $jacocoInit[31] = true;
                return i;
            }
        }
        i = this.listOfApps.size();
        $jacocoInit[30] = true;
        $jacocoInit[31] = true;
        return i;
    }

    public int getTotalItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.listOfApps.size();
        $jacocoInit[32] = true;
        return size;
    }

    public void setAvailableUpgradesList(List<App> list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.listOfApps.removeAll(getUpdatesToRemove(list));
        $jacocoInit[33] = true;
        notifyDataSetChanged();
        $jacocoInit[34] = true;
        addApps(list);
        $jacocoInit[35] = true;
        Collections.sort(this.listOfApps, C3688f.f7091a);
        $jacocoInit[36] = true;
    }

    /* renamed from: a */
    static /* synthetic */ int m8207a(App app1, App app2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (app1.getType() != Type.UPDATE) {
            $jacocoInit[124] = true;
        } else if (app2.getType() != Type.UPDATE) {
            $jacocoInit[125] = true;
        } else {
            $jacocoInit[126] = true;
            String name = ((UpdateApp) app1).getName();
            UpdateApp updateApp = (UpdateApp) app2;
            $jacocoInit[127] = true;
            int compareTo = name.compareTo(updateApp.getName());
            $jacocoInit[128] = true;
            return compareTo;
        }
        $jacocoInit[129] = true;
        return 0;
    }

    public void addApps(List<App> list) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[37] = true;
        while (i < list.size()) {
            $jacocoInit[38] = true;
            if (this.listOfApps.contains(list.get(i))) {
                $jacocoInit[39] = true;
                int itemIndex = this.listOfApps.indexOf(list.get(i));
                $jacocoInit[40] = true;
                App actualApp = (App) this.listOfApps.get(itemIndex);
                $jacocoInit[41] = true;
                App newApp = (App) list.get(i);
                if (!(actualApp instanceof StateApp)) {
                    $jacocoInit[42] = true;
                } else if (!(newApp instanceof StateApp)) {
                    $jacocoInit[43] = true;
                } else {
                    $jacocoInit[44] = true;
                    if (!shouldUpdateStateApp((StateApp) actualApp, (StateApp) newApp)) {
                        $jacocoInit[45] = true;
                    } else {
                        $jacocoInit[46] = true;
                        if (((StateApp) actualApp).getStatus() == Status.PAUSING) {
                            $jacocoInit[47] = true;
                            if (!shouldUpdatePausingApp((StateApp) newApp)) {
                                $jacocoInit[48] = true;
                            } else {
                                $jacocoInit[49] = true;
                                updateApp(list, i, itemIndex);
                                $jacocoInit[50] = true;
                            }
                        } else {
                            updateApp(list, i, itemIndex);
                            $jacocoInit[51] = true;
                        }
                    }
                    $jacocoInit[55] = true;
                }
                if (list.get(i) == this.listOfApps.get(itemIndex)) {
                    $jacocoInit[52] = true;
                } else {
                    $jacocoInit[53] = true;
                    updateApp(list, i, itemIndex);
                    $jacocoInit[54] = true;
                }
                $jacocoInit[55] = true;
            } else {
                this.listOfApps.add(list.get(i));
                $jacocoInit[56] = true;
                notifyItemInserted(i);
                $jacocoInit[57] = true;
            }
            i++;
            $jacocoInit[58] = true;
        }
        $jacocoInit[59] = true;
    }

    public void removeCanceledAppDownload(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.listOfApps.contains(app)) {
            $jacocoInit[60] = true;
        } else {
            $jacocoInit[61] = true;
            int indexOfCanceledDownload = this.listOfApps.indexOf(app);
            $jacocoInit[62] = true;
            this.listOfApps.remove(app);
            $jacocoInit[63] = true;
            notifyItemRemoved(indexOfCanceledDownload);
            $jacocoInit[64] = true;
        }
        $jacocoInit[65] = true;
    }

    public void removeAppcUpgradesList(List<App> updatesToRemove) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[66] = true;
        for (App app : updatesToRemove) {
            $jacocoInit[67] = true;
            if (!this.listOfApps.contains(app)) {
                $jacocoInit[68] = true;
            } else {
                $jacocoInit[69] = true;
                int indexOfExcludedApp = this.listOfApps.indexOf(app);
                $jacocoInit[70] = true;
                this.listOfApps.remove(indexOfExcludedApp);
                $jacocoInit[71] = true;
                notifyItemRemoved(indexOfExcludedApp);
                $jacocoInit[72] = true;
            }
            $jacocoInit[73] = true;
        }
        $jacocoInit[74] = true;
    }

    private void updateApp(List<App> list, int i, int itemIndex) {
        boolean[] $jacocoInit = $jacocoInit();
        this.listOfApps.set(itemIndex, list.get(i));
        $jacocoInit[75] = true;
        notifyItemChanged(itemIndex);
        $jacocoInit[76] = true;
    }

    private boolean shouldUpdatePausingApp(StateApp app) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (app.getStatus() == Status.STANDBY) {
            $jacocoInit[77] = true;
        } else if (app.getStatus() == Status.ERROR) {
            $jacocoInit[78] = true;
        } else {
            z = false;
            $jacocoInit[80] = true;
            $jacocoInit[81] = true;
            return z;
        }
        $jacocoInit[79] = true;
        z = true;
        $jacocoInit[81] = true;
        return z;
    }

    private boolean shouldUpdateStateApp(StateApp actualApp, StateApp newApp) {
        boolean hasSameStatus;
        boolean hasSameProgress;
        boolean hasSameIndeterminateStatus;
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (actualApp.getStatus() == newApp.getStatus()) {
            $jacocoInit[82] = true;
            hasSameStatus = true;
        } else {
            $jacocoInit[83] = true;
            hasSameStatus = false;
        }
        $jacocoInit[84] = true;
        if (actualApp.getProgress() == newApp.getProgress()) {
            $jacocoInit[85] = true;
            hasSameProgress = true;
        } else {
            $jacocoInit[86] = true;
            hasSameProgress = false;
        }
        $jacocoInit[87] = true;
        if (actualApp.isIndeterminate() == newApp.isIndeterminate()) {
            $jacocoInit[88] = true;
            hasSameIndeterminateStatus = true;
        } else {
            $jacocoInit[89] = true;
            hasSameIndeterminateStatus = false;
        }
        if (!hasSameStatus) {
            $jacocoInit[90] = true;
        } else if (!hasSameProgress) {
            $jacocoInit[91] = true;
        } else if (!hasSameIndeterminateStatus) {
            $jacocoInit[92] = true;
        } else {
            $jacocoInit[94] = true;
            $jacocoInit[95] = true;
            return z;
        }
        $jacocoInit[93] = true;
        z = true;
        $jacocoInit[95] = true;
        return z;
    }

    private List<App> getUpdatesToRemove(List<App> updatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> updatesToRemove = getUpdateApps();
        $jacocoInit[96] = true;
        updatesToRemove.removeAll(updatesList);
        $jacocoInit[97] = true;
        return updatesToRemove;
    }

    public List<App> getUpdateApps() {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> updateApps = new ArrayList<>();
        $jacocoInit[98] = true;
        $jacocoInit[99] = true;
        for (App app : this.listOfApps) {
            $jacocoInit[100] = true;
            if (app.getType() != Type.UPDATE) {
                $jacocoInit[101] = true;
            } else {
                $jacocoInit[102] = true;
                updateApps.add(app);
                $jacocoInit[103] = true;
            }
            $jacocoInit[104] = true;
        }
        $jacocoInit[105] = true;
        return updateApps;
    }

    public void setAppStandby(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        int indexOfApp = this.listOfApps.indexOf(app);
        if (indexOfApp == -1) {
            $jacocoInit[106] = true;
        } else {
            $jacocoInit[107] = true;
            UpdateApp application = (UpdateApp) this.listOfApps.get(indexOfApp);
            $jacocoInit[108] = true;
            setIndeterminate(indexOfApp, application);
            $jacocoInit[109] = true;
        }
        $jacocoInit[110] = true;
    }

    private void setIndeterminate(int indexOfApp, StateApp application) {
        boolean[] $jacocoInit = $jacocoInit();
        application.setIndeterminate(true);
        $jacocoInit[111] = true;
        application.setStatus(Status.STANDBY);
        $jacocoInit[112] = true;
        notifyItemChanged(indexOfApp);
        $jacocoInit[113] = true;
    }

    public void setAppOnPausing(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        int indexOfApp = this.listOfApps.indexOf(app);
        if (indexOfApp == -1) {
            $jacocoInit[114] = true;
        } else {
            $jacocoInit[115] = true;
            UpdateApp application = (UpdateApp) this.listOfApps.get(indexOfApp);
            $jacocoInit[116] = true;
            setAppPausing(indexOfApp, application);
            $jacocoInit[117] = true;
        }
        $jacocoInit[118] = true;
    }

    private void setAppPausing(int indexOfApp, StateApp application) {
        boolean[] $jacocoInit = $jacocoInit();
        application.setStatus(Status.PAUSING);
        $jacocoInit[119] = true;
        application.setIndeterminate(true);
        $jacocoInit[120] = true;
        notifyItemChanged(indexOfApp);
        $jacocoInit[121] = true;
    }
}
