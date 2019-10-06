package p005cm.aptoide.p006pt.navigator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p002b.p003c.p049c.C1163b;
import p005cm.aptoide.p006pt.view.BaseActivity;
import p019d.p022i.p023b.C0100e;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.navigator.ActivityCustomTabsNavigator */
public abstract class ActivityCustomTabsNavigator extends BaseActivity implements CustomTabsNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C0100e<Uri> results;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4493474706278728608L, "cm/aptoide/pt/navigator/ActivityCustomTabsNavigator", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityCustomTabsNavigator() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        this.results = C0100e.m565o();
        $jacocoInit[2] = true;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onNewIntent(intent);
        $jacocoInit[3] = true;
        this.results.call(intent.getData());
        $jacocoInit[4] = true;
    }

    public void navigateToCustomTabs(C1163b intent, Uri uri) {
        boolean[] $jacocoInit = $jacocoInit();
        intent.mo8779a(this, uri);
        $jacocoInit[5] = true;
    }

    public C0120S<Uri> customTabResults() {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<Uri> eVar = this.results;
        $jacocoInit[6] = true;
        return eVar;
    }
}
