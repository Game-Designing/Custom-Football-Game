package com.inmobi.ads;

import android.content.Context;
import android.widget.FrameLayout;

public abstract class NativeScrollableContainer extends FrameLayout {

    /* renamed from: a */
    private final int f31359a;

    /* renamed from: com.inmobi.ads.NativeScrollableContainer$a */
    interface C10326a {
        /* renamed from: a */
        int mo33858a(int i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo33856a(C10402am amVar, C10434ax axVar, int i, int i2, C10326a aVar);

    public NativeScrollableContainer(Context context) {
        super(context);
        this.f31359a = 0;
    }

    public NativeScrollableContainer(Context context, int i) {
        super(context);
        this.f31359a = i;
    }

    public final int getType() {
        return this.f31359a;
    }
}
