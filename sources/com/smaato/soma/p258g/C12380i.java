package com.smaato.soma.p258g;

import android.content.Context;
import android.widget.TextView;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.smaato.soma.C12058Ka;
import com.smaato.soma.C12150c;
import com.smaato.soma.C12367f;
import com.smaato.soma.C12398ha;
import com.smaato.soma.C12431j;
import com.smaato.soma.p239c.C12187c;
import com.smaato.soma.p239c.p246f.C12252w;
import java.lang.ref.WeakReference;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.smaato.soma.g.i */
/* compiled from: NativeAd */
class C12380i extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Context f38659a;

    /* renamed from: b */
    final /* synthetic */ C12389r f38660b;

    C12380i(C12389r this$0, Context context) {
        this.f38660b = this$0;
        this.f38659a = context;
    }

    public Void process() {
        C12389r rVar = this.f38660b;
        rVar.f38706y = new WeakReference(rVar);
        this.f38660b.f38688g = C12187c.m40092b().mo39469a(this.f38659a, null);
        this.f38660b.f38688g.mo39603a(this.f38660b.f38706y);
        this.f38660b.f38687f.mo39883a(C12431j.NATIVE);
        this.f38660b.f38687f.mo39882a((C12150c) null);
        this.f38660b.f38688g.setAdSettings(this.f38660b.f38687f);
        this.f38660b.f38688g.setUserSettings(this.f38660b.f38686e);
        this.f38660b.f38688g.mo39602a((C12367f) this.f38660b);
        this.f38660b.f38680F = this.f38659a;
        this.f38660b.f38704w = new TextView(this.f38659a);
        this.f38660b.f38704w.setText("Sponsored");
        this.f38660b.f38704w.setId(C12058Ka.native_ad_sponsored_view_id);
        this.f38660b.f38704w.setTextSize(10.0f);
        this.f38660b.f38704w.setBackgroundColor(-7829368);
        this.f38660b.f38704w.setTextColor(CtaButton.BACKGROUND_COLOR);
        this.f38660b.f38704w.getBackground().setAlpha(Opcodes.LUSHR);
        if (C12252w.m40307b().mo39629e() == null) {
            C12252w.m40307b().mo39626b(this.f38659a);
        }
        return null;
    }
}
