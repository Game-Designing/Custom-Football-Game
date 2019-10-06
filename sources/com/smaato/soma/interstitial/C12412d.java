package com.smaato.soma.interstitial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.smaato.soma.p239c.p252i.C12278d;
import com.smaato.soma.p260i.C12402c;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.smaato.soma.interstitial.d */
/* compiled from: BaseActivity */
public class C12412d extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RelativeLayout f38767a;

    /* renamed from: b */
    protected C12402c f38768b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new C12409a(this).execute();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public RelativeLayout mo39912d() {
        return this.f38767a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo39911c() {
        this.f38768b = new C12402c(getBaseContext());
        int wh = C12278d.m40415a().mo39670a(50);
        this.f38768b.getLayoutParams().width = wh;
        this.f38768b.getLayoutParams().height = wh;
        this.f38768b.setOnClickListener(new C12411c(this));
        this.f38767a.addView(this.f38768b);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void mo40014e() {
        requestWindowFeature(1);
        getWindow().addFlags(Opcodes.ACC_ABSTRACT);
    }
}
