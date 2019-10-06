package com.smaato.soma.p260i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.smaato.soma.C12366eb;
import com.smaato.soma.C12369fa;
import com.smaato.soma.p238b.C12146d;
import java.lang.ref.WeakReference;

/* renamed from: com.smaato.soma.i.g */
/* compiled from: ToasterLayout */
public class C12406g extends C12369fa {

    /* renamed from: q */
    C12366eb f38742q;

    /* renamed from: com.smaato.soma.i.g$a */
    /* compiled from: ToasterLayout */
    private class C12407a extends Handler {

        /* renamed from: a */
        private WeakReference<C12369fa> f38743a;

        /* renamed from: b */
        private C12369fa f38744b;

        /* synthetic */ C12407a(C12406g x0, C12369fa x1, C12403d x2) {
            this(x1);
        }

        private C12407a(C12369fa baseView) {
            super(Looper.getMainLooper());
            this.f38743a = null;
            this.f38744b = baseView;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public WeakReference<C12369fa> mo39901a() {
            if (this.f38743a == null) {
                this.f38743a = new WeakReference<>(this.f38744b);
            }
            return this.f38743a;
        }

        public void handleMessage(Message msg) {
            C12146d.m39966a((Object) new C12404e(this));
            super.handleMessage(msg);
            new C12405f(this, msg).execute();
        }
    }

    public Handler getBannerAnimatorHandler() {
        if (this.f38637h == null) {
            setBannerAnimatorHandler(new C12407a(this, this, null));
        }
        return this.f38637h;
    }

    /* renamed from: m */
    public boolean mo39835m() {
        boolean result = super.mo39835m();
        this.f38742q.mo39808b();
        return result;
    }

    public final void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        new C12403d(this, hasWindowFocus).execute();
    }
}
