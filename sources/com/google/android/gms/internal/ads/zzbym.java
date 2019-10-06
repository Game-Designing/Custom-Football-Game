package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzbym extends zzaef {

    /* renamed from: b */
    private final zzbyt f26084b;

    public zzbym(zzbyt zzbyt) {
        this.f26084b = zzbyt;
    }

    /* renamed from: K */
    public final float mo29647K() {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24056_e)).booleanValue()) {
            return 0.0f;
        }
        if (this.f26084b.mo30986A() != 0.0f) {
            return this.f26084b.mo30986A();
        }
        if (this.f26084b.mo31015m() != null) {
            return m27953ib();
        }
        return m27954jb();
    }

    /* renamed from: ib */
    private final float m27953ib() {
        try {
            return this.f26084b.mo31015m().mo29364K();
        } catch (RemoteException e) {
            zzbad.m26356b("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    /* renamed from: jb */
    private final float m27954jb() {
        zzadw zzadw = (zzadw) this.f26084b.mo31010h().get(0);
        if (zzadw.getWidth() != -1 && zzadw.getHeight() != -1) {
            return ((float) zzadw.getWidth()) / ((float) zzadw.getHeight());
        }
        try {
            Drawable drawable = (Drawable) ObjectWrapper.m22187H(zzadw.mo29639Pa());
            if (drawable == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
                return 0.0f;
            }
            return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        } catch (RemoteException e) {
            zzbad.m26356b("RemoteException getting Drawable for aspect ratio calculation.", e);
            return 0.0f;
        }
    }
}
