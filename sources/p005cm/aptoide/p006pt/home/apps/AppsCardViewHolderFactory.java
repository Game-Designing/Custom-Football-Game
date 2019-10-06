package p005cm.aptoide.p006pt.home.apps;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.AppsCardViewHolderFactory */
public class AppsCardViewHolderFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C14963c<AppClick> appItemClicks;
    private final C14963c<Void> updateAll;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1645028648787591454L, "cm/aptoide/pt/home/apps/AppsCardViewHolderFactory", 33);
        $jacocoData = probes;
        return probes;
    }

    public AppsCardViewHolderFactory(C14963c<AppClick> appItemClicks2, C14963c<Void> updateAll2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appItemClicks = appItemClicks2;
        this.updateAll = updateAll2;
        $jacocoInit[0] = true;
    }

    public AppsViewHolder createViewHolder(int viewType, ViewGroup parent) {
        AppsViewHolder appViewHolder;
        boolean[] $jacocoInit = $jacocoInit();
        switch (viewType) {
            case 0:
                LayoutInflater from = LayoutInflater.from(parent.getContext());
                $jacocoInit[1] = true;
                appViewHolder = new DownloadsHeaderViewHolder(from.inflate(C1375R.layout.apps_header_item, parent, false));
                $jacocoInit[2] = true;
                break;
            case 1:
                LayoutInflater from2 = LayoutInflater.from(parent.getContext());
                $jacocoInit[3] = true;
                appViewHolder = new InstalledHeaderViewHolder(from2.inflate(C1375R.layout.apps_header_item, parent, false));
                $jacocoInit[4] = true;
                break;
            case 2:
                LayoutInflater from3 = LayoutInflater.from(parent.getContext());
                $jacocoInit[5] = true;
                appViewHolder = new UpdatesHeaderViewHolder(from3.inflate(C1375R.layout.apps_header_updates_item, parent, false), this.updateAll);
                $jacocoInit[6] = true;
                break;
            case 3:
                LayoutInflater from4 = LayoutInflater.from(parent.getContext());
                $jacocoInit[7] = true;
                appViewHolder = new ActiveAppDownloadViewHolder(from4.inflate(C1375R.layout.apps_active_download_app_item, parent, false), this.appItemClicks);
                $jacocoInit[8] = true;
                break;
            case 4:
                LayoutInflater from5 = LayoutInflater.from(parent.getContext());
                $jacocoInit[9] = true;
                appViewHolder = new StandByAppDownloadViewHolder(from5.inflate(C1375R.layout.apps_standby_download_app_item, parent, false), this.appItemClicks);
                $jacocoInit[10] = true;
                break;
            case 5:
                LayoutInflater from6 = LayoutInflater.from(parent.getContext());
                $jacocoInit[11] = true;
                appViewHolder = new CompletedAppDownloadViewHolder(from6.inflate(C1375R.layout.apps_completed_download_app_item, parent, false), this.appItemClicks);
                $jacocoInit[12] = true;
                break;
            case 6:
                LayoutInflater from7 = LayoutInflater.from(parent.getContext());
                $jacocoInit[13] = true;
                appViewHolder = new ErrorAppDownloadViewHolder(from7.inflate(C1375R.layout.apps_error_download_app_item, parent, false), this.appItemClicks);
                $jacocoInit[14] = true;
                break;
            case 7:
                LayoutInflater from8 = LayoutInflater.from(parent.getContext());
                $jacocoInit[23] = true;
                appViewHolder = new InstalledAppViewHolder(from8.inflate(C1375R.layout.apps_installed_app_item, parent, false));
                $jacocoInit[24] = true;
                break;
            case 8:
                LayoutInflater from9 = LayoutInflater.from(parent.getContext());
                $jacocoInit[15] = true;
                appViewHolder = new UpdateAppViewHolder(from9.inflate(C1375R.layout.apps_update_app_item, parent, false), this.appItemClicks);
                $jacocoInit[16] = true;
                break;
            case 9:
                LayoutInflater from10 = LayoutInflater.from(parent.getContext());
                $jacocoInit[17] = true;
                appViewHolder = new UpdatingAppViewHolder(from10.inflate(C1375R.layout.apps_updating_app_item, parent, false), this.appItemClicks);
                $jacocoInit[18] = true;
                break;
            case 10:
                LayoutInflater from11 = LayoutInflater.from(parent.getContext());
                $jacocoInit[19] = true;
                appViewHolder = new StandByUpdateAppViewHolder(from11.inflate(C1375R.layout.apps_standby_update_app_item, parent, false), this.appItemClicks);
                $jacocoInit[20] = true;
                break;
            case 11:
                LayoutInflater from12 = LayoutInflater.from(parent.getContext());
                $jacocoInit[21] = true;
                appViewHolder = new ErrorUpdateAppViewHolder(from12.inflate(C1375R.layout.apps_error_update_app_item, parent, false), this.appItemClicks);
                $jacocoInit[22] = true;
                break;
            case 12:
                LayoutInflater from13 = LayoutInflater.from(parent.getContext());
                $jacocoInit[25] = true;
                appViewHolder = new StandByUpdateAppViewHolder(from13.inflate(C1375R.layout.apps_standby_update_app_item, parent, false), this.appItemClicks);
                $jacocoInit[26] = true;
                break;
            case 13:
                LayoutInflater from14 = LayoutInflater.from(parent.getContext());
                $jacocoInit[27] = true;
                appViewHolder = new StandByAppDownloadViewHolder(from14.inflate(C1375R.layout.apps_standby_download_app_item, parent, false), this.appItemClicks);
                $jacocoInit[28] = true;
                break;
            case 14:
                LayoutInflater from15 = LayoutInflater.from(parent.getContext());
                $jacocoInit[29] = true;
                appViewHolder = new InstallingAppViewHolder(from15.inflate(C1375R.layout.apps_installing_app_item, parent, false));
                $jacocoInit[30] = true;
                break;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Wrong cardType");
                sb.append(viewType);
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                $jacocoInit[31] = true;
                throw illegalStateException;
        }
        $jacocoInit[32] = true;
        return appViewHolder;
    }
}
