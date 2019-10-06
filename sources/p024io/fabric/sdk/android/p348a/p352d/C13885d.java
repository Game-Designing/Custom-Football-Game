package p024io.fabric.sdk.android.p348a.p352d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import p024io.fabric.sdk.android.C0102l;

/* renamed from: io.fabric.sdk.android.a.d.d */
/* compiled from: PreferenceStoreImpl */
public class C13885d implements C13884c {

    /* renamed from: a */
    private final SharedPreferences f42113a;

    /* renamed from: b */
    private final String f42114b;

    /* renamed from: c */
    private final Context f42115c;

    public C13885d(Context context, String name) {
        if (context != null) {
            this.f42115c = context;
            this.f42114b = name;
            this.f42113a = this.f42115c.getSharedPreferences(this.f42114b, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Deprecated
    public C13885d(C0102l kit) {
        this(kit.mo3307i(), kit.getClass().getName());
    }

    public SharedPreferences get() {
        return this.f42113a;
    }

    public Editor edit() {
        return this.f42113a.edit();
    }

    @TargetApi(9)
    /* renamed from: a */
    public boolean mo43294a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
