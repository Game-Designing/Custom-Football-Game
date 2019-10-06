package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import p019d.p143b.p144a.p146b.C6988a;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7267q;

/* renamed from: com.applovin.adview.b */
public class C5856b extends RelativeLayout {

    /* renamed from: a */
    private C5855a f10196a;

    public C5856b(C7267q qVar, C7257g gVar, Context context) {
        super(context);
        m10663a(gVar, null, qVar, context, null);
    }

    /* renamed from: a */
    private void m10662a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int applyDimension = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(CtaButton.BACKGROUND_COLOR);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, i, applyDimension);
    }

    /* renamed from: a */
    private void m10663a(C7257g gVar, String str, C7267q qVar, Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            C6988a aVar = new C6988a();
            aVar.mo18285a(this, context, gVar, str, qVar, attributeSet);
            this.f10196a = aVar;
            return;
        }
        m10662a(attributeSet, context);
    }

    /* renamed from: a */
    public void mo18297a() {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    /* renamed from: a */
    public void mo18298a(C7251a aVar) {
        mo18299a(aVar, (String) null);
    }

    @Deprecated
    /* renamed from: a */
    public void mo18299a(C7251a aVar, String str) {
        C5855a aVar2 = this.f10196a;
        if (aVar2 != null) {
            aVar2.mo18287a(aVar, str);
        }
    }

    /* renamed from: b */
    public void mo18300b() {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.mo18293b();
        } else {
            Log.i("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    public C5855a getAdViewController() {
        return this.f10196a;
    }

    public C7257g getSize() {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            return aVar.mo18283a();
        }
        return null;
    }

    public String getZoneId() {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            return aVar.mo18294c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.mo18284a(i);
        }
    }

    public void setAdClickListener(C7252b bVar) {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.mo18288a(bVar);
        }
    }

    public void setAdDisplayListener(C7253c cVar) {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.mo18289a(cVar);
        }
    }

    public void setAdLoadListener(C7254d dVar) {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.mo18290a(dVar);
        }
    }

    public void setAdVideoPlaybackListener(C7260j jVar) {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.mo18291a(jVar);
        }
    }

    public void setAdViewEventListener(C5858d dVar) {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.mo18286a(dVar);
        }
    }

    public void setAutoDestroy(boolean z) {
        C5855a aVar = this.f10196a;
        if (aVar != null) {
            aVar.mo18292a(z);
        }
    }
}
