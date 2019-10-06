package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@zzard
public final class zzbim extends MutableContextWrapper {

    /* renamed from: a */
    private Activity f25374a;

    /* renamed from: b */
    private Context f25375b;

    /* renamed from: c */
    private Context f25376c;

    public zzbim(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final void setBaseContext(Context context) {
        this.f25375b = context.getApplicationContext();
        this.f25374a = context instanceof Activity ? (Activity) context : null;
        this.f25376c = context;
        super.setBaseContext(this.f25375b);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.f25374a;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.f25375b.startActivity(intent);
    }

    /* renamed from: b */
    public final Activity mo30645b() {
        return this.f25374a;
    }

    public final Object getSystemService(String str) {
        return this.f25376c.getSystemService(str);
    }

    /* renamed from: a */
    public final Context mo30644a() {
        return this.f25376c;
    }
}
