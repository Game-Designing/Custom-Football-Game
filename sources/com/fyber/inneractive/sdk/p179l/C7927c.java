package com.fyber.inneractive.sdk.p179l;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.l.c */
public final class C7927c extends WebView {

    /* renamed from: a */
    C7929a f16159a;

    /* renamed from: b */
    private boolean f16160b = false;

    /* renamed from: c */
    private boolean f16161c;

    /* renamed from: com.fyber.inneractive.sdk.l.c$a */
    public interface C7929a {
        /* renamed from: b */
        void mo24739b(boolean z);

        /* renamed from: k */
        void mo24767k();

        /* renamed from: l */
        void mo24768l();
    }

    C7927c(Context context) {
        super(context.getApplicationContext());
    }

    public final void setListener(C7929a aVar) {
        this.f16159a = aVar;
    }

    public final boolean getIsVisible() {
        return this.f16161c;
    }

    /* renamed from: a */
    public final void mo24753a(int i, int i2) {
        onSizeChanged(i, i2, 0, 0);
    }

    public final void destroy() {
        super.destroy();
        this.f16159a = null;
    }

    /* renamed from: a */
    public final void mo24754a(String str) {
        StringBuilder sb = new StringBuilder("injecting JS: ");
        sb.append(str);
        IAlog.m18021b(sb.toString());
        if (str != null) {
            StringBuilder sb2 = new StringBuilder("javascript:");
            sb2.append(str);
            loadUrl(sb2.toString());
        }
    }

    public final void loadUrl(String str) {
        if (str != null) {
            if (!str.startsWith("javascript:")) {
                super.loadUrl(str);
            } else if (VERSION.SDK_INT >= 19) {
                try {
                    evaluateJavascript(str, new ValueCallback<String>() {
                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            String str = (String) obj;
                            StringBuilder sb = new StringBuilder("Javascript callback (KitKat): ");
                            sb.append(str);
                            IAlog.m18021b(sb.toString());
                        }
                    });
                } catch (Exception e) {
                    IAlog.m18021b("Failed to invoke Javascript (version above KITKAT)");
                }
            } else {
                try {
                    super.loadUrl(str);
                } catch (Exception e2) {
                    IAlog.m18021b("Failed to invoke Javascript (version below KITKAT)");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.f16160b) {
            this.f16160b = true;
            C7929a aVar = this.f16159a;
            if (aVar != null) {
                aVar.mo24767k();
            }
            mo24755a();
        }
    }

    /* access modifiers changed from: protected */
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        mo24755a();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f16161c = false;
        if (this.f16160b) {
            this.f16160b = false;
            C7929a aVar = this.f16159a;
            if (aVar != null) {
                aVar.mo24768l();
            }
            mo24755a();
        }
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        mo24755a();
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        StringBuilder sb = new StringBuilder("onWindowFocusChanged with: ");
        sb.append(z);
        IAlog.m18019a(sb.toString());
        mo24755a();
    }

    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8) {
            m17898a(false);
        } else {
            mo24755a();
        }
    }

    /* renamed from: a */
    public final boolean mo24755a() {
        StringBuilder sb = new StringBuilder("updateVisibility called - is = ");
        sb.append(isShown());
        sb.append(" hwf = ");
        sb.append(hasWindowFocus());
        sb.append(" atw = ");
        sb.append(this.f16160b);
        sb.append("winToken - ");
        sb.append(getWindowToken());
        sb.append(" app token - ");
        sb.append(getApplicationWindowToken());
        IAlog.m18019a(sb.toString());
        boolean z = true;
        if (getWindowToken() != getApplicationWindowToken()) {
            if (getWindowVisibility() == 8 || !isShown() || !this.f16160b) {
                z = false;
            }
            return m17898a(z);
        }
        if (!isShown() || !hasWindowFocus() || !this.f16160b) {
            z = false;
        }
        return m17898a(z);
    }

    /* renamed from: a */
    private boolean m17898a(boolean z) {
        if (z) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                Rect rect = new Rect();
                viewGroup.getHitRect(rect);
                if (!getLocalVisibleRect(rect) && getWindowToken() == getApplicationWindowToken()) {
                    IAlog.m18019a("updateVisibility - Cannot find local visible rect. Scrolled out?");
                    z = false;
                }
            } else {
                IAlog.m18019a("updateVisibility - No parent available");
            }
        }
        if (this.f16161c == z) {
            return false;
        }
        this.f16161c = z;
        C7929a aVar = this.f16159a;
        if (aVar != null) {
            aVar.mo24739b(z);
        }
        return true;
    }
}
