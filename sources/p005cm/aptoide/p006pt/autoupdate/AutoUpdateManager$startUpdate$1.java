package p005cm.aptoide.p006pt.autoupdate;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadAnalytics.AppContext;
import p005cm.aptoide.p006pt.install.Install;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateManager$startUpdate$1 */
/* compiled from: AutoUpdateManager.kt */
final class AutoUpdateManager$startUpdate$1<T, R> implements C0132p<T, C0120S<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ AutoUpdateManager this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7534923003525386822L, "cm/aptoide/pt/autoupdate/AutoUpdateManager$startUpdate$1", 6);
        $jacocoData = probes;
        return probes;
    }

    AutoUpdateManager$startUpdate$1(AutoUpdateManager autoUpdateManager) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = autoUpdateManager;
        $jacocoInit[5] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S call = call((AutoUpdateModel) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0120S<Install> call(AutoUpdateModel it) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(AutoUpdateManager.access$getDownloadFactory$p(this.this$0).create(it.getMd5(), it.getVersionCode(), it.getPackageName(), it.getUri(), false));
        $jacocoInit[1] = true;
        C0120S g = c.mo3663g((C0132p<? super T, ? extends C0117M>) new C0132p<Download, C0117M>(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ AutoUpdateManager$startUpdate$1 this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(4140498107224011679L, "cm/aptoide/pt/autoupdate/AutoUpdateManager$startUpdate$1$1", 4);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = r3;
                $jacocoInit[3] = true;
            }

            public /* bridge */ /* synthetic */ Object call(Object obj) {
                boolean[] $jacocoInit = $jacocoInit();
                C0117M call = call((Download) obj);
                $jacocoInit[0] = true;
                return call;
            }

            public final C0117M call(final Download download) {
                boolean[] $jacocoInit = $jacocoInit();
                C0117M install = AutoUpdateManager.access$getInstallManager$p(this.this$0.this$0).install(download);
                $jacocoInit[1] = true;
                C0117M b = install.mo3595b((C0129b<? super C0137ja>) new C0129b<C0137ja>(this) {
                    private static transient /* synthetic */ boolean[] $jacocoData;
                    final /* synthetic */ C22801 this$0;

                    private static /* synthetic */ boolean[] $jacocoInit() {
                        boolean[] zArr = $jacocoData;
                        if (zArr != null) {
                            return zArr;
                        }
                        boolean[] probes = Offline.getProbes(1848824449421189078L, "cm/aptoide/pt/autoupdate/AutoUpdateManager$startUpdate$1$1$1", 5);
                        $jacocoData = probes;
                        return probes;
                    }

                    {
                        boolean[] $jacocoInit = $jacocoInit();
                        this.this$0 = r2;
                        $jacocoInit[4] = true;
                    }

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        boolean[] $jacocoInit = $jacocoInit();
                        call((C0137ja) obj);
                        $jacocoInit[0] = true;
                    }

                    public final void call(C0137ja it) {
                        boolean[] $jacocoInit = $jacocoInit();
                        DownloadAnalytics access$getDownloadAnalytics$p = AutoUpdateManager.access$getDownloadAnalytics$p(this.this$0.this$0.this$0);
                        Download download = download;
                        Action action = Action.CLICK;
                        $jacocoInit[1] = true;
                        AppContext appContext = AppContext.AUTO_UPDATE;
                        Boolean valueOf = Boolean.valueOf(false);
                        $jacocoInit[2] = true;
                        access$getDownloadAnalytics$p.downloadStartEvent(download, action, appContext, valueOf);
                        $jacocoInit[3] = true;
                    }
                });
                $jacocoInit[2] = true;
                return b;
            }
        });
        $jacocoInit[2] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[3] = true;
        C0120S<Install> a = l.mo3586a(AutoUpdateManager.access$getInstall(this.this$0));
        $jacocoInit[4] = true;
        return a;
    }
}
