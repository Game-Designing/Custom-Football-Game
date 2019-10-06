package com.smaato.soma;

import android.app.AlertDialog.Builder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.smaato.soma.p236a.p237a.C12111b;
import java.lang.ref.WeakReference;

@Deprecated
/* renamed from: com.smaato.soma.Ba */
/* compiled from: FullScreenBanner */
public class C12037Ba extends C12089a<C12393ga> implements C12507r {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Builder f37871d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12111b f37872e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12064Na f37873f;

    @Deprecated
    /* renamed from: com.smaato.soma.Ba$a */
    /* compiled from: FullScreenBanner */
    public class C12038a extends C12369fa {

        /* renamed from: q */
        final /* synthetic */ C12037Ba f37874q;

        /* renamed from: com.smaato.soma.Ba$a$a */
        /* compiled from: FullScreenBanner */
        private class C12039a extends Handler {

            /* renamed from: a */
            private WeakReference<C12369fa> f37875a;

            /* renamed from: b */
            private C12369fa f37876b;

            /* synthetic */ C12039a(C12038a x0, C12369fa x1, C12516va x2) {
                this(x1);
            }

            private C12039a(C12369fa baseView) {
                super(Looper.getMainLooper());
                this.f37875a = null;
                this.f37876b = baseView;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public WeakReference<C12369fa> mo39223a() {
                if (this.f37875a == null) {
                    this.f37875a = new WeakReference<>(this.f37876b);
                }
                return this.f37875a;
            }

            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                new C12035Aa(this, msg).execute();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public void mo39221g() {
            if (this.f37874q.f37872e != C12111b.f37995c && this.f37874q.f37873f != null && this.f37874q.mo39314b() == null) {
                super.mo39221g();
                this.f37874q.f37871d = new Builder(getContext());
                this.f37874q.f37871d.setCancelable(false);
                this.f37874q.f37871d.setView((C12038a) this.f37874q.f37960c);
                this.f37874q.f37871d.setNegativeButton("Skip", new C12520xa(this));
                if (this.f37874q.f37873f.mo39284b() != null && this.f37874q.f37873f.mo39284b() == C12431j.IMAGE) {
                    this.f37874q.f37871d.setPositiveButton("More Info", new C12524za(this));
                }
                C12493k kVar = this.f37874q.f37959b;
                if (kVar != null) {
                    kVar.mo40023a();
                }
                C12037Ba ba = this.f37874q;
                ba.mo39313a(ba.f37871d.show());
                mo39832j();
                this.f37874q.f37872e = C12111b.f37995c;
            }
        }

        public Handler getBannerAnimatorHandler() {
            if (this.f38637h == null) {
                setBannerAnimatorHandler(new C12039a(this, this, null));
            }
            return this.f38637h;
        }
    }

    /* renamed from: c */
    public void mo39220c() {
        throw null;
    }
}
