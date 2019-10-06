package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import java.util.Set;

public final class zzbvq extends zzbts<VideoLifecycleCallbacks> {

    /* renamed from: b */
    private boolean f25915b;

    protected zzbvq(Set<zzbuz<VideoLifecycleCallbacks>> set) {
        super(set);
    }

    /* renamed from: H */
    public final void mo30928H() {
        mo30895a(C9294_g.f22046a);
    }

    /* renamed from: G */
    public final void mo30927G() {
        mo30895a(C9316ah.f22086a);
    }

    /* renamed from: J */
    public final synchronized void mo30930J() {
        mo30895a(C9338bh.f22119a);
        this.f25915b = true;
    }

    /* renamed from: I */
    public final synchronized void mo30929I() {
        if (!this.f25915b) {
            mo30895a(C9360ch.f22160a);
            this.f25915b = true;
        }
        mo30895a(C9382dh.f22179a);
    }
}
