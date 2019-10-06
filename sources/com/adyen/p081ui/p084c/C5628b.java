package com.adyen.p081ui.p084c;

import android.os.Handler;
import android.view.View;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.adyen.ui.c.b */
/* compiled from: AdyenInputValidator */
public class C5628b {

    /* renamed from: a */
    private HashMap<View, Boolean> f9527a = new HashMap<>();

    /* renamed from: b */
    private boolean f9528b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C5629a f9529c;

    /* renamed from: com.adyen.ui.c.b$a */
    /* compiled from: AdyenInputValidator */
    public interface C5629a {
        /* renamed from: a */
        void mo17730a(boolean z);
    }

    /* renamed from: a */
    public void mo17782a(View view, boolean ready) {
        if (this.f9527a.containsKey(view) && ((Boolean) this.f9527a.get(view)).booleanValue() != ready) {
            this.f9527a.put(view, Boolean.valueOf(ready));
            m9920b();
        }
    }

    /* renamed from: a */
    public void mo17781a(View newView) {
        this.f9527a.put(newView, Boolean.valueOf(false));
    }

    /* renamed from: a */
    private boolean m9919a() {
        boolean ready = true;
        for (Entry<View, Boolean> entry : this.f9527a.entrySet()) {
            ready &= ((Boolean) entry.getValue()).booleanValue();
        }
        return ready;
    }

    /* renamed from: b */
    private void m9920b() {
        boolean oldState = this.f9528b;
        boolean newState = m9919a();
        if (oldState != newState) {
            this.f9528b = newState;
            m9918a(newState);
        }
    }

    /* renamed from: a */
    private void m9918a(boolean newState) {
        if (this.f9529c != null) {
            new Handler().post(new C5627a(this, newState));
        }
    }

    /* renamed from: a */
    public void mo17783a(C5629a listener) {
        this.f9529c = listener;
    }
}
