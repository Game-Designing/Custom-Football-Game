package com.smaato.soma.p239c.p254k;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.ImageView;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12369fa;
import com.smaato.soma.p255d.C12316i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.smaato.soma.c.k.p */
/* compiled from: CustomWebView */
public class C12301p extends WebView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f38479a = false;

    /* renamed from: b */
    private boolean f38480b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12369fa f38481c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ImageView f38482d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12064Na f38483e;

    /* renamed from: f */
    private boolean f38484f;

    /* renamed from: g */
    private C12304b f38485g;

    /* renamed from: h */
    private boolean f38486h;

    /* renamed from: com.smaato.soma.c.k.p$a */
    /* compiled from: CustomWebView */
    public static abstract class C12302a implements OnTouchListener {

        /* renamed from: a */
        private GestureDetector f38487a;

        /* renamed from: com.smaato.soma.c.k.p$a$a */
        /* compiled from: CustomWebView */
        private final class C12303a extends SimpleOnGestureListener {

            /* renamed from: a */
            int f38488a;

            private C12303a() {
                this.f38488a = 0;
            }

            /* synthetic */ C12303a(C12302a x0, C12288c x1) {
                this();
            }

            public boolean onDown(MotionEvent e) {
                return true;
            }

            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                if (distanceX > 50.0f) {
                    try {
                        if (this.f38488a <= 0) {
                            C12302a.this.mo39711i();
                            this.f38488a = 1;
                            return true;
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
                if (distanceX < -50.0f && this.f38488a >= 0) {
                    C12302a.this.mo39710h();
                    this.f38488a = -1;
                }
                return true;
            }
        }

        /* renamed from: h */
        public abstract void mo39710h();

        /* renamed from: i */
        public abstract void mo39711i();

        public C12302a(Context ctx) {
            this.f38487a = new GestureDetector(ctx, new C12303a(this, null));
        }

        public boolean onTouch(View v, MotionEvent event) {
            this.f38487a.onTouchEvent(event);
            return false;
        }
    }

    /* renamed from: com.smaato.soma.c.k.p$b */
    /* compiled from: CustomWebView */
    public interface C12304b {
        void onVisibilityChanged(boolean z);
    }

    public C12301p(Context context, C12064Na banner, C12369fa baseView) {
        super(context);
        this.f38481c = baseView;
        this.f38483e = banner;
        if (this.f38479a) {
            m40476b();
        }
        setOnTouchListener(new C12288c(this, context, baseView, banner));
    }

    public void setOnVisibilityChangedListener(C12304b onVisibilityChangedListener) {
        this.f38485g = onVisibilityChangedListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m40478c() {
        if (VERSION.SDK_INT <= 19) {
            postDelayed(new C12289d(this), 500);
        } else {
            m40480d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m40480d() {
        this.f38481c.getBannerAnimatorHandler().sendMessage(this.f38481c.getBannerAnimatorHandler().obtainMessage(101));
    }

    public void setButtonAttached(boolean isButtonAttached) {
        this.f38479a = isButtonAttached;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        boolean newIsVisible = visibility == 0;
        if (newIsVisible != this.f38486h) {
            this.f38486h = newIsVisible;
            C12304b bVar = this.f38485g;
            if (bVar != null) {
                bVar.onVisibilityChanged(this.f38486h);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40476b() {
        new C12291f(this).execute();
    }

    /* access modifiers changed from: protected */
    public Uri getScreenShotUri() {
        return (Uri) new C12292g(this).execute();
    }

    /* renamed from: a */
    public boolean mo39721a() {
        return this.f38480b;
    }

    public void setUserClicked(boolean userClicked) {
        this.f38480b = userClicked;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo39718a(Context context) {
        new C12294i(this, context).execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40477b(Context context) {
        new C12297l(this, context).execute();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo39719a(Context context, String cause) {
        new C12298m(this, cause, context).execute();
    }

    /* renamed from: a */
    public void mo39720a(C12316i fraudesType, String redirectURL) {
        try {
            if (this.f38483e != null) {
                if (!this.f38484f) {
                    this.f38484f = true;
                    List<String> urlTraces = new ArrayList<>();
                    HashMap<String, String> reportData = new HashMap<>();
                    reportData.put("adspace", String.valueOf(this.f38481c.getAdSettings().mo39887c()));
                    reportData.put("publisher", String.valueOf(this.f38481c.getAdSettings().mo39891g()));
                    reportData.put("sdk", "sdkandroid_9-1-5");
                    String str = "";
                    reportData.put("admarkup", this.f38483e.mo39286c() != null ? this.f38483e.mo39286c() : str);
                    String str2 = "redirecturl";
                    if (redirectURL != null) {
                        reportData.put(str2, redirectURL);
                    } else {
                        reportData.put(str2, this.f38483e.mo39296k() != null ? this.f38483e.mo39296k() : str);
                    }
                    reportData.put("clickurl", this.f38483e.mo39297l() != null ? this.f38483e.mo39297l() : str);
                    reportData.put("type", fraudesType.toString());
                    urlTraces.add(reportData.get(str2));
                    String str3 = "sci";
                    if (this.f38483e.mo39301p() != null) {
                        str = this.f38483e.mo39301p();
                    }
                    reportData.put(str3, str);
                    new Handler(Looper.getMainLooper()).post(new C12299n(this, urlTraces, reportData));
                }
            }
        } catch (Exception e) {
        }
    }
}
