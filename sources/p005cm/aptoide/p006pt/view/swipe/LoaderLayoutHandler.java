package p005cm.aptoide.p006pt.view.swipe;

import android.view.View;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.util.ErrorUtils;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ThreadU;
import p005cm.aptoide.p006pt.view.LoadInterface;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.view.swipe.LoaderLayoutHandler */
public class LoaderLayoutHandler {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private View genericErrorView;
    final LoadInterface loadInterface;
    private View noNetworkConnectionView;
    protected ProgressBar progressBar;
    private View retryErrorView;
    private View retryNoNetworkView;
    private List<View> viewsToShowAfterLoading;
    private final List<Integer> viewsToShowAfterLoadingId = new ArrayList();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6826801572476519277L, "cm/aptoide/pt/view/swipe/LoaderLayoutHandler", 61);
        $jacocoData = probes;
        return probes;
    }

    public LoaderLayoutHandler(LoadInterface loadInterface2, int viewToShowAfterLoadingId) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.viewsToShowAfterLoading = new ArrayList();
        $jacocoInit[2] = true;
        this.viewsToShowAfterLoadingId.add(Integer.valueOf(viewToShowAfterLoadingId));
        this.loadInterface = loadInterface2;
        $jacocoInit[3] = true;
    }

    public LoaderLayoutHandler(LoadInterface loadInterface2, int... viewsToShowAfterLoadingId2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[4] = true;
        $jacocoInit[5] = true;
        this.viewsToShowAfterLoading = new ArrayList();
        int length = viewsToShowAfterLoadingId2.length;
        $jacocoInit[6] = true;
        int i = 0;
        while (i < length) {
            int viewToShowAfterLoadingId = viewsToShowAfterLoadingId2[i];
            $jacocoInit[7] = true;
            this.viewsToShowAfterLoadingId.add(Integer.valueOf(viewToShowAfterLoadingId));
            i++;
            $jacocoInit[8] = true;
        }
        this.loadInterface = loadInterface2;
        $jacocoInit[9] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[10] = true;
        for (Integer intValue : this.viewsToShowAfterLoadingId) {
            int id = intValue.intValue();
            $jacocoInit[11] = true;
            this.viewsToShowAfterLoading.add(view.findViewById(id));
            $jacocoInit[12] = true;
        }
        hideViewsToShowAfterLoading();
        $jacocoInit[13] = true;
        this.progressBar = (ProgressBar) view.findViewById(C1375R.C1376id.progress_bar);
        $jacocoInit[14] = true;
        this.progressBar.setVisibility(0);
        $jacocoInit[15] = true;
        this.genericErrorView = view.findViewById(C1375R.C1376id.generic_error);
        $jacocoInit[16] = true;
        this.noNetworkConnectionView = view.findViewById(C1375R.C1376id.no_network_connection);
        $jacocoInit[17] = true;
        this.retryErrorView = this.genericErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[18] = true;
        this.retryNoNetworkView = this.noNetworkConnectionView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[19] = true;
    }

    private void hideViewsToShowAfterLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[20] = true;
        for (View view : this.viewsToShowAfterLoading) {
            $jacocoInit[21] = true;
            if (view == null) {
                $jacocoInit[22] = true;
            } else {
                view.setVisibility(8);
                $jacocoInit[23] = true;
            }
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
    }

    public void finishLoading(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[26] = true;
        instance.log(throwable);
        $jacocoInit[27] = true;
        ThreadU.runOnUiThread(new C5543d(this, throwable));
        $jacocoInit[28] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17552a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        onFinishLoading(throwable);
        $jacocoInit[60] = true;
    }

    /* access modifiers changed from: protected */
    public void onFinishLoading(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar.setVisibility(8);
        $jacocoInit[29] = true;
        hideViewsToShowAfterLoading();
        $jacocoInit[30] = true;
        if (ErrorUtils.isNoNetworkConnection(throwable)) {
            $jacocoInit[31] = true;
            this.genericErrorView.setVisibility(8);
            $jacocoInit[32] = true;
            this.noNetworkConnectionView.setVisibility(0);
            $jacocoInit[33] = true;
            this.retryNoNetworkView.setOnClickListener(new C5544e(this));
            $jacocoInit[34] = true;
        } else {
            this.noNetworkConnectionView.setVisibility(8);
            $jacocoInit[35] = true;
            this.genericErrorView.setVisibility(0);
            $jacocoInit[36] = true;
            this.retryErrorView.setOnClickListener(new C5541b(this));
            $jacocoInit[37] = true;
        }
        $jacocoInit[38] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17551a(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        restoreState();
        $jacocoInit[58] = true;
        this.loadInterface.load(true, false, null);
        $jacocoInit[59] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17553b(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        restoreState();
        $jacocoInit[56] = true;
        this.loadInterface.load(true, false, null);
        $jacocoInit[57] = true;
    }

    /* access modifiers changed from: protected */
    public void restoreState() {
        boolean[] $jacocoInit = $jacocoInit();
        this.genericErrorView.setVisibility(8);
        $jacocoInit[39] = true;
        this.noNetworkConnectionView.setVisibility(8);
        $jacocoInit[40] = true;
        this.progressBar.setVisibility(0);
        $jacocoInit[41] = true;
    }

    public void finishLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m633a((Callable<? extends T>) new C5540a<Object>(this));
        $jacocoInit[42] = true;
        C0120S b = a.mo3634b(C14522a.m46170a());
        C5542c cVar = C5542c.f9353a;
        C5545f fVar = C5545f.f9357a;
        $jacocoInit[43] = true;
        b.mo3626a((C0129b<? super T>) cVar, (C0129b<Throwable>) fVar);
        $jacocoInit[44] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Object mo17550a() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        onFinishLoading();
        $jacocoInit[55] = true;
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m9789a(Object o) {
        $jacocoInit()[54] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9790b(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[52] = true;
        instance.log(e);
        $jacocoInit[53] = true;
    }

    /* access modifiers changed from: protected */
    public void onFinishLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar.setVisibility(8);
        $jacocoInit[45] = true;
        showViewsToShowAfterLoading();
        $jacocoInit[46] = true;
    }

    private void showViewsToShowAfterLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[47] = true;
        for (View view : this.viewsToShowAfterLoading) {
            $jacocoInit[48] = true;
            view.setVisibility(0);
            $jacocoInit[49] = true;
        }
        $jacocoInit[50] = true;
    }

    public void unbindViews() {
        $jacocoInit()[51] = true;
    }
}
