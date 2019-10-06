package p005cm.aptoide.p006pt.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.view.LoadInterface;
import p005cm.aptoide.p006pt.view.swipe.LoaderLayoutHandler;

/* renamed from: cm.aptoide.pt.view.fragment.BaseLoaderFragment */
public abstract class BaseLoaderFragment extends UIComponentFragment implements LoadInterface {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean create = true;
    private LoaderLayoutHandler loaderLayoutHandler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5215513658987350709L, "cm/aptoide/pt/view/fragment/BaseLoaderFragment", 30);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract int getViewToShowAfterLoadingId();

    /* access modifiers changed from: protected */
    public abstract int[] getViewsToShowAfterLoadingId();

    public abstract void load(boolean z, boolean z2, Bundle bundle);

    public BaseLoaderFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[1] = true;
        load(this.create, false, savedInstanceState);
        $jacocoInit[2] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loaderLayoutHandler = createLoaderLayoutHandler();
        $jacocoInit[3] = true;
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[4] = true;
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    public LoaderLayoutHandler createLoaderLayoutHandler() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getViewsToShowAfterLoadingId().length > 0) {
            $jacocoInit[5] = true;
            LoaderLayoutHandler loaderLayoutHandler2 = new LoaderLayoutHandler((LoadInterface) this, getViewsToShowAfterLoadingId());
            $jacocoInit[6] = true;
            return loaderLayoutHandler2;
        }
        LoaderLayoutHandler loaderLayoutHandler3 = new LoaderLayoutHandler((LoadInterface) this, getViewToShowAfterLoadingId());
        $jacocoInit[7] = true;
        return loaderLayoutHandler3;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        LoaderLayoutHandler loaderLayoutHandler2 = this.loaderLayoutHandler;
        if (loaderLayoutHandler2 == null) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            loaderLayoutHandler2.bindViews(view);
            $jacocoInit[10] = true;
        }
        if (this.create) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            finishLoading();
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
    }

    /* access modifiers changed from: protected */
    public void finishLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        LoaderLayoutHandler loaderLayoutHandler2 = this.loaderLayoutHandler;
        if (loaderLayoutHandler2 == null) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            loaderLayoutHandler2.finishLoading();
            $jacocoInit[17] = true;
        }
        $jacocoInit[18] = true;
    }

    public void onStop() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onStop();
        this.create = false;
        $jacocoInit[19] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        LoaderLayoutHandler loaderLayoutHandler2 = this.loaderLayoutHandler;
        if (loaderLayoutHandler2 == null) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            loaderLayoutHandler2.unbindViews();
            this.loaderLayoutHandler = null;
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
    }

    /* access modifiers changed from: protected */
    public void finishLoading(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        LoaderLayoutHandler loaderLayoutHandler2 = this.loaderLayoutHandler;
        if (loaderLayoutHandler2 == null) {
            $jacocoInit[24] = true;
        } else {
            $jacocoInit[25] = true;
            loaderLayoutHandler2.finishLoading(throwable);
            $jacocoInit[26] = true;
        }
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[27] = true;
        instance.log(throwable);
        $jacocoInit[28] = true;
    }

    public boolean isCreate() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.create;
        $jacocoInit[29] = true;
        return z;
    }
}
