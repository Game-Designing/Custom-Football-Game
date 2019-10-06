package p024io.fabric.sdk.android.p348a.p352d;

import android.content.Context;
import java.io.File;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: io.fabric.sdk.android.a.d.b */
/* compiled from: FileStoreImpl */
public class C13883b implements C13882a {

    /* renamed from: a */
    private final Context f42110a;

    /* renamed from: b */
    private final String f42111b;

    /* renamed from: c */
    private final String f42112c;

    public C13883b(C0102l kit) {
        if (kit.mo3307i() != null) {
            this.f42110a = kit.mo3307i();
            this.f42111b = kit.mo3311v();
            StringBuilder sb = new StringBuilder();
            sb.append("Android/");
            sb.append(this.f42110a.getPackageName());
            this.f42112c = sb.toString();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    /* renamed from: a */
    public File mo43292a() {
        return mo43293a(this.f42110a.getFilesDir());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public File mo43293a(File file) {
        String str = "Fabric";
        if (file == null) {
            C13920f.m44245e().mo43326c(str, "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            C13920f.m44245e().mo43321a(str, "Couldn't create file");
        }
        return null;
    }
}
