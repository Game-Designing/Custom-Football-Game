package p024io.fabric.sdk.android.p348a.p350b;

import android.content.Context;
import p024io.fabric.sdk.android.p348a.p349a.C13829d;

/* renamed from: io.fabric.sdk.android.a.b.z */
/* compiled from: InstallerPackageNameProvider */
class C13870z implements C13829d<String> {

    /* renamed from: a */
    final /* synthetic */ C13830A f42091a;

    C13870z(C13830A this$0) {
        this.f42091a = this$0;
    }

    /* renamed from: a */
    public String m44109a(Context context) throws Exception {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }
}
