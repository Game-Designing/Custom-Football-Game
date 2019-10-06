package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.DataKeys;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.mopub.mobileads.v */
/* compiled from: BaseInterstitialActivity */
abstract class C11459v extends Activity {

    /* renamed from: a */
    protected AdReport f35423a;

    /* renamed from: b */
    private CloseableLayout f35424b;

    /* renamed from: c */
    private Long f35425c;

    public abstract View getAdView();

    C11459v() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.f35425c = m37904b(intent);
        this.f35423a = m37902a(intent);
        requestWindowFeature(1);
        getWindow().addFlags(Opcodes.ACC_ABSTRACT);
        View adView = getAdView();
        this.f35424b = new CloseableLayout(this);
        this.f35424b.setOnCloseListener(new C11453u(this));
        this.f35424b.addView(adView, new LayoutParams(-1, -1));
        setContentView(this.f35424b);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CloseableLayout closeableLayout = this.f35424b;
        if (closeableLayout != null) {
            closeableLayout.removeAllViews();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public CloseableLayout mo37563b() {
        return this.f35424b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Long mo37562a() {
        return this.f35425c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo37564c() {
        return m37903a(this.f35423a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo37566e() {
        CloseableLayout closeableLayout = this.f35424b;
        if (closeableLayout != null) {
            closeableLayout.setCloseVisible(true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo37565d() {
        CloseableLayout closeableLayout = this.f35424b;
        if (closeableLayout != null) {
            closeableLayout.setCloseVisible(false);
        }
    }

    /* renamed from: b */
    protected static Long m37904b(Intent intent) {
        String str = DataKeys.BROADCAST_IDENTIFIER_KEY;
        if (intent.hasExtra(str)) {
            return Long.valueOf(intent.getLongExtra(str, -1));
        }
        return null;
    }

    /* renamed from: a */
    protected static AdReport m37902a(Intent intent) {
        try {
            return (AdReport) intent.getSerializableExtra(DataKeys.AD_REPORT_KEY);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /* renamed from: a */
    static String m37903a(AdReport adReport) {
        if (adReport != null) {
            return adReport.getResponseString();
        }
        return null;
    }
}
