package p024io.fabric.sdk.android.p348a.p350b;

import android.content.Context;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p349a.C13827b;
import p024io.fabric.sdk.android.p348a.p349a.C13829d;

/* renamed from: io.fabric.sdk.android.a.b.A */
/* compiled from: InstallerPackageNameProvider */
public class C13830A {

    /* renamed from: a */
    private final C13829d<String> f41987a = new C13870z(this);

    /* renamed from: b */
    private final C13827b<String> f41988b = new C13827b<>();

    /* renamed from: a */
    public String mo43202a(Context appContext) {
        String str = null;
        try {
            String name = (String) this.f41988b.mo43199a(appContext, this.f41987a);
            if (!"".equals(name)) {
                str = name;
            }
            return str;
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
