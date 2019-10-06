package com.smaato.soma;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p239c.p246f.p249c.C12229k;
import com.smaato.soma.p260i.C12402c;
import com.smaato.soma.p260i.C12406g;

/* renamed from: com.smaato.soma.eb */
/* compiled from: ToasterBanner */
public class C12366eb extends RelativeLayout implements C12393ga {

    /* renamed from: a */
    private Context f38625a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final View f38626b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12402c f38627c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C12406g f38628d;

    /* renamed from: e */
    private boolean f38629e;

    public void setContext(Context context) {
        this.f38625a = context;
    }

    public void setLocationUpdateEnabled(boolean updateEnabled) {
        new C12149bb(this, updateEnabled).execute();
    }

    public C12229k getUserSettings() {
        return (C12229k) new C12306cb(this).execute();
    }

    public void setUserSettings(C12229k userSettings) {
        new C12321db(this, userSettings).execute();
    }

    public int getBackgroundColor() {
        return ((Integer) new C12070Qa(this).execute()).intValue();
    }

    public void setBannerStateListener(C12507r listener) {
        new C12071Ra(this, listener).execute();
    }

    public C12394h getAdSettings() {
        return (C12394h) new C12073Sa(this).execute();
    }

    public void setAdSettings(C12394h adSettings) {
        new C12075Ta(this, adSettings).execute();
    }

    /* renamed from: b */
    public void mo39808b() {
        C12146d.m39966a((Object) new C12077Ua(this));
        new C12083Xa(this).execute();
    }

    /* renamed from: c */
    public void mo39809c() {
        C12146d.m39966a((Object) new C12085Ya(this));
        new C12141ab(this).execute();
    }

    public final void setScalingEnabled(boolean scalingEnabled) {
        this.f38629e = scalingEnabled;
    }
}
