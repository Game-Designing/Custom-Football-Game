package com.fyber.inneractive.sdk.p179l;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.fyber.inneractive.sdk.C7636R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError;
import com.fyber.inneractive.sdk.mraid.C7950a;
import com.fyber.inneractive.sdk.mraid.C7954e;
import com.fyber.inneractive.sdk.mraid.C7954e.C7956a;
import com.fyber.inneractive.sdk.mraid.C7969r;
import com.fyber.inneractive.sdk.mraid.C7970s;
import com.fyber.inneractive.sdk.mraid.C7971t;
import com.fyber.inneractive.sdk.mraid.C7973v;
import com.fyber.inneractive.sdk.mraid.C7974w;
import com.fyber.inneractive.sdk.mraid.C7976y;
import com.fyber.inneractive.sdk.mraid.C7977z;
import com.fyber.inneractive.sdk.p165f.C7730b;
import com.fyber.inneractive.sdk.p179l.C7930d.C7942d;
import com.fyber.inneractive.sdk.p180ui.IAcloseButton;
import com.fyber.inneractive.sdk.util.C8005i;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.C8017o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.mopub.common.AdType;
import com.mopub.mraid.MraidNativeCommandHandler;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

/* renamed from: com.fyber.inneractive.sdk.l.d */
public abstract class C7930d<T extends C7942d> extends C7922a<T> {

    /* renamed from: a */
    private static final String[] f16163a = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};

    /* renamed from: A */
    protected C7976y f16164A = C7976y.HIDDEN;

    /* renamed from: B */
    public boolean f16165B;

    /* renamed from: C */
    protected float f16166C;

    /* renamed from: D */
    public int f16167D = -1;

    /* renamed from: E */
    public int f16168E = -1;

    /* renamed from: F */
    protected int f16169F = -1;

    /* renamed from: G */
    protected int f16170G = -1;

    /* renamed from: H */
    protected int f16171H = -1;

    /* renamed from: I */
    protected int f16172I = -1;

    /* renamed from: J */
    protected C7940b f16173J = C7940b.NONE;

    /* renamed from: K */
    protected boolean f16174K = false;

    /* renamed from: L */
    private int f16175L;

    /* renamed from: M */
    private C7945g f16176M;

    /* renamed from: N */
    private IAcloseButton f16177N;

    /* renamed from: O */
    private int f16178O;

    /* renamed from: P */
    private FrameLayout f16179P;

    /* renamed from: Q */
    private FrameLayout f16180Q;

    /* renamed from: R */
    private RelativeLayout f16181R;

    /* renamed from: S */
    private int f16182S;

    /* renamed from: T */
    private int f16183T;

    /* renamed from: b */
    private final int f16184b;

    /* renamed from: c */
    private final int f16185c;

    /* renamed from: d */
    private C7943e f16186d;

    /* renamed from: e */
    private FrameLayout f16187e;

    /* renamed from: f */
    private C7927c f16188f;

    /* renamed from: g */
    private boolean f16189g = false;

    /* renamed from: com.fyber.inneractive.sdk.l.d$a */
    public enum C7939a {
        ;
        

        /* renamed from: a */
        public static final int f16206a = 0;

        /* renamed from: b */
        public static final int f16207b = 0;

        static {
            f16206a = 1;
            f16207b = 2;
            f16208c = new int[]{f16206a, f16207b};
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.l.d$b */
    private enum C7940b {
        PORTRAIT("portrait"),
        LANDSCAPE("landscape"),
        NONE("none");
        

        /* renamed from: d */
        final String f16213d;

        private C7940b(String str) {
            this.f16213d = str;
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.l.d$c */
    private class C7941c implements MediaScannerConnectionClient {

        /* renamed from: b */
        private final String f16215b;

        /* renamed from: c */
        private final String f16216c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public MediaScannerConnection f16217d;

        /* synthetic */ C7941c(C7930d dVar, String str, byte b) {
            this(str);
        }

        private C7941c(String str) {
            this.f16215b = str;
            this.f16216c = null;
        }

        public final void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.f16217d;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.f16215b, this.f16216c);
            }
        }

        public final void onScanCompleted(String str, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.f16217d;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.l.d$d */
    public interface C7942d extends C7949g {
        /* renamed from: a */
        void mo24519a(AdDisplayError adDisplayError);

        /* renamed from: a */
        void mo24520a(boolean z);

        /* renamed from: b */
        void mo24522b();

        /* renamed from: b */
        boolean mo24523b(String str);

        /* renamed from: c_ */
        void mo24524c_();

        /* renamed from: d_ */
        void mo24525d_();

        /* renamed from: l */
        void mo24534l();
    }

    /* renamed from: com.fyber.inneractive.sdk.l.d$e */
    public enum C7943e {
        INLINE,
        INTERSTITIAL
    }

    /* renamed from: com.fyber.inneractive.sdk.l.d$f */
    public enum C7944f {
        ;
        

        /* renamed from: a */
        public static final int f16221a = 0;

        /* renamed from: b */
        public static final int f16222b = 0;

        /* renamed from: c */
        public static final int f16223c = 0;

        static {
            f16221a = 1;
            f16222b = 2;
            f16223c = 3;
            f16224d = new int[]{f16221a, f16222b, f16223c};
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.l.d$g */
    class C7945g extends BroadcastReceiver {

        /* renamed from: a */
        Context f16225a;

        /* renamed from: c */
        private int f16227c;

        C7945g() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (this.f16225a != null) {
                if ("android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction())) {
                    int p = C8006j.m18077p();
                    if (p != this.f16227c) {
                        this.f16227c = p;
                        C7930d.m17908a(C7930d.this, context);
                    }
                }
            }
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.l.d$h */
    public static abstract class C7946h implements C7942d {
        /* renamed from: c_ */
        public void mo24524c_() {
        }

        /* renamed from: d_ */
        public void mo24525d_() {
        }

        /* renamed from: b */
        public void mo24522b() {
        }

        /* renamed from: a */
        public void mo24520a(boolean z) {
        }

        /* renamed from: b */
        public boolean mo24523b(String str) {
            return false;
        }

        /* renamed from: l */
        public final void mo24534l() {
        }

        /* renamed from: a */
        public final void mo24469a(Object obj) {
        }

        /* renamed from: c */
        public final void mo24441c(boolean z) {
        }

        /* renamed from: a */
        public boolean mo24521a(String str) {
            return false;
        }

        /* renamed from: k */
        public final void mo24533k() {
        }
    }

    /* renamed from: a */
    static /* synthetic */ String m17906a(URI uri, C7730b bVar) {
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        String name = new File(path).getName();
        String a = bVar.mo24295a("text/html");
        if (a != null) {
            String[] split = a.split(";");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = split[i];
                if (str.contains("image/")) {
                    StringBuilder sb = new StringBuilder(".");
                    sb.append(str.split("/")[1]);
                    String sb2 = sb.toString();
                    if (!name.endsWith(sb2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(name);
                        sb3.append(sb2);
                        name = sb3.toString();
                    }
                } else {
                    i++;
                }
            }
        }
        return name;
    }

    /* renamed from: a */
    static /* synthetic */ void m17908a(C7930d dVar, Context context) {
        dVar.m17907a(context);
        dVar.mo24771a((C7970s) C7973v.m18002a(dVar.f16167D, dVar.f16168E));
        dVar.mo24771a((C7970s) C7971t.m17998a(dVar.f16169F, dVar.f16170G));
        int i = dVar.f16171H;
        if (i != -1 && dVar.f16172I != -1) {
            dVar.mo24771a((C7970s) C7969r.m17995a(C8006j.m18066a(i), C8006j.m18066a(dVar.f16172I)));
        }
    }

    public C7930d(Context context, boolean z, boolean z2, C7943e eVar, int i, int i2) {
        super(context, z, z2);
        this.f16186d = eVar;
        this.f16184b = i;
        this.f16185c = i2;
    }

    /* renamed from: a */
    public boolean mo24738a(WebView webView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("handle url for: ");
        sb.append(str);
        sb.append(" webView = ");
        sb.append(webView);
        IAlog.m18021b(sb.toString());
        if (this.f16164A != C7976y.EXPANDED || TextUtils.isEmpty(str) || !webView.equals(this.f16188f) || this.f16189g) {
            return super.mo24738a(webView, str);
        }
        this.f16189g = true;
        return false;
    }

    /* renamed from: a */
    public boolean mo24651a(String str) {
        if (!AdType.MRAID.equals(Uri.parse(str).getScheme())) {
            return false;
        }
        m17911a(URI.create(str));
        return true;
    }

    /* renamed from: b */
    public boolean mo24653b(String str) {
        L l = this.f16138l;
        if (l != null) {
            return ((C7942d) l).mo24521a(str);
        }
        return false;
    }

    /* renamed from: d */
    public void mo24775d(String str) {
    }

    /* renamed from: a */
    private boolean m17911a(URI uri) {
        String[] split;
        String str;
        String host = uri.getHost();
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null && rawQuery.length() > 0) {
                for (String str2 : rawQuery.split("&")) {
                    int indexOf = str2.indexOf("=");
                    String str3 = "UTF-8";
                    String decode = indexOf > 0 ? URLDecoder.decode(str2.substring(0, indexOf), str3) : str2;
                    if (indexOf > 0) {
                        int i = indexOf + 1;
                        if (str2.length() > i) {
                            str = URLDecoder.decode(str2.substring(i), str3);
                            linkedHashMap.put(decode, str);
                        }
                    }
                    str = null;
                    linkedHashMap.put(decode, str);
                }
            }
            C7950a a = C7954e.m17978a(host, linkedHashMap, this);
            if (a == null) {
                m17917l(host);
            }
            a.f16229a = host;
            if (!a.mo24815b() || this.f16142p) {
                a.mo24813a();
                m17917l(host);
            } else {
                StringBuilder sb = new StringBuilder("Mraid action ");
                sb.append(host);
                sb.append(" called without a REAL user click!");
                IAlog.m18021b(sb.toString());
                mo24734a((Object) a);
                if (IAConfigManager.m17012z()) {
                    IAlog.m18021b("Mraid action blocked!");
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public void mo24648a() {
        super.mo24648a();
        this.f16164A = C7976y.LOADING;
        Context context = this.f16134h.getContext();
        this.f16175L = context instanceof Activity ? ((Activity) context).getRequestedOrientation() : -1;
        this.f16180Q = new FrameLayout(this.f16134h.getContext());
        this.f16181R = new RelativeLayout(this.f16134h.getContext());
        FrameLayout frameLayout = new FrameLayout(this.f16134h.getContext());
        frameLayout.setBackgroundColor(-858993460);
        this.f16179P = frameLayout;
        m17907a(context);
        this.f16134h.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4 || !C7930d.this.mo24780n()) {
                    return false;
                }
                IAlog.m18019a("back button pressed while ad is expanded, ad will be collapsed.");
                C7930d.this.mo24782p();
                return true;
            }
        });
    }

    public void setAdDefaultSize(int i, int i2) {
        this.f16182S = i;
        this.f16183T = i2;
        this.f16171H = i;
        this.f16172I = i2;
    }

    /* renamed from: a */
    private void m17907a(Context context) {
        int i;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f16166C = displayMetrics.density;
        int i2 = 0;
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            i2 = rect.top;
            i = window.findViewById(16908290).getTop() - i2;
        } else {
            i = 0;
        }
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        double d = (double) i3;
        int i5 = displayMetrics.densityDpi;
        double d2 = (double) i5;
        Double.isNaN(d2);
        double d3 = 160.0d / d2;
        Double.isNaN(d);
        this.f16167D = (int) (d3 * d);
        double d4 = (double) i4;
        double d5 = (double) i5;
        Double.isNaN(d5);
        double d6 = 160.0d / d5;
        Double.isNaN(d4);
        this.f16168E = (int) (d4 * d6);
        int i6 = (i4 - i2) - i;
        double d7 = (double) i5;
        Double.isNaN(d7);
        double d8 = 160.0d / d7;
        Double.isNaN(d);
        this.f16169F = (int) (d * d8);
        double d9 = (double) i6;
        double d10 = (double) i5;
        Double.isNaN(d10);
        double d11 = 160.0d / d10;
        Double.isNaN(d9);
        this.f16170G = (int) (d9 * d11);
    }

    /* renamed from: b */
    public void mo24652b() {
        mo24779m();
        super.mo24652b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public final void mo24779m() {
        try {
            if (this.f16176M != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(IAlog.m18018a((Object) this));
                sb.append("unregistering orientation broadcast receiver");
                IAlog.m18021b(sb.toString());
                C7945g gVar = this.f16176M;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(IAlog.m18018a((Object) C7930d.this));
                sb2.append("unregister screen broadcast receiver called");
                IAlog.m18021b(sb2.toString());
                if (gVar.f16225a != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(IAlog.m18018a((Object) C7930d.this));
                    sb3.append("unregistering broadcast receiver");
                    IAlog.m18021b(sb3.toString());
                    gVar.f16225a.unregisterReceiver(gVar);
                    gVar.f16225a = null;
                }
            }
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        this.f16176M = null;
    }

    /* renamed from: c */
    public void mo24774c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C7973v.m18002a(this.f16167D, this.f16168E));
        arrayList.add(C7971t.m17998a(this.f16169F, this.f16170G));
        if (this.f16134h != null) {
            String arrayList2 = arrayList.toString();
            if (arrayList2.length() >= 2) {
                StringBuilder sb = new StringBuilder("{");
                sb.append(arrayList2.substring(1, arrayList2.length() - 1));
                sb.append("}");
                String sb2 = sb.toString();
                C7927c cVar = this.f16134h;
                StringBuilder sb3 = new StringBuilder("window.mraidbridge.fireChangeEvent(");
                sb3.append(sb2);
                sb3.append(");");
                cVar.mo24754a(sb3.toString());
                StringBuilder sb4 = new StringBuilder("Fire changes: ");
                sb4.append(sb2);
                IAlog.m18019a(sb4.toString());
            }
        }
        this.f16164A = C7976y.DEFAULT;
        mo24771a((C7970s) C7974w.m18004a(this.f16164A));
    }

    /* renamed from: n */
    public final boolean mo24780n() {
        return this.f16164A == C7976y.EXPANDED;
    }

    /* renamed from: o */
    public final boolean mo24781o() {
        return this.f16164A == C7976y.RESIZED;
    }

    /* renamed from: p */
    public final void mo24782p() {
        this.f16189g = false;
        C7976y yVar = this.f16164A;
        if (yVar == C7976y.EXPANDED || yVar == C7976y.RESIZED) {
            m17913e(false);
            C7927c cVar = this.f16134h;
            if (cVar != null) {
                C7976y yVar2 = this.f16164A;
                if (yVar2 == C7976y.EXPANDED) {
                    this.f16180Q.removeAllViewsInLayout();
                    this.f16181R.removeAllViewsInLayout();
                    FrameLayout frameLayout = this.f16187e;
                    if (frameLayout != null) {
                        frameLayout.removeView(this.f16181R);
                    }
                    ViewGroup viewGroup = (ViewGroup) this.f16179P.getParent();
                    if (viewGroup != null) {
                        viewGroup.addView(this.f16134h, this.f16178O, new LayoutParams(this.f16182S, this.f16183T, 17));
                        viewGroup.removeView(this.f16179P);
                        viewGroup.invalidate();
                        this.f16134h.requestLayout();
                    }
                    this.f16171H = this.f16182S;
                    this.f16172I = this.f16183T;
                } else if (yVar2 == C7976y.RESIZED) {
                    int i = this.f16182S;
                    this.f16171H = i;
                    int i2 = this.f16183T;
                    this.f16172I = i2;
                    cVar.setLayoutParams(new LayoutParams(i, i2, 17));
                }
            }
            this.f16164A = C7976y.DEFAULT;
            mo24650a(false);
            mo24771a((C7970s) C7974w.m18004a(this.f16164A));
        } else if (yVar == C7976y.DEFAULT) {
            this.f16134h.setVisibility(4);
            this.f16164A = C7976y.HIDDEN;
            mo24771a((C7970s) C7974w.m18004a(this.f16164A));
        }
        L l = this.f16138l;
        if (l != null) {
            ((C7942d) l).mo24525d_();
        }
    }

    /* renamed from: a */
    public final void mo24772a(String str, int i, int i2, boolean z, boolean z2) {
        if (this.f16184b == C7939a.f16207b || this.f16164A != C7976y.DEFAULT) {
            return;
        }
        if (str == null || URLUtil.isValidUrl(str)) {
            this.f16187e = (FrameLayout) this.f16134h.getRootView().findViewById(16908290);
            if (this.f16187e == null) {
                IAlog.m18023d("Couldn't find content in the view tree");
                return;
            }
            mo24776d(z);
            mo24650a(z2);
            if (this.f16172I >= 0) {
                this.f16172I = C8006j.m18072b(i2);
            }
            if (this.f16171H >= 0) {
                this.f16171H = C8006j.m18072b(i);
            }
            C7927c cVar = this.f16134h;
            if (str != null) {
                this.f16188f = new C7927c(cVar.getContext());
                this.f16188f.setId(C7636R.C7637id.inneractive_webview_mraid);
                this.f16188f.loadUrl(str);
                this.f16188f.setWebChromeClient(this.f16135i);
                this.f16188f.setWebViewClient(this.f16136j);
                cVar = this.f16188f;
                cVar.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (i != 4 || !C7930d.this.mo24780n()) {
                            return false;
                        }
                        IAlog.m18019a("back button pressed while ad is expanded, ad will be collapsed.");
                        C7930d.this.mo24782p();
                        return true;
                    }
                });
            } else {
                ViewGroup viewGroup = (ViewGroup) cVar.getParent();
                if (viewGroup != null) {
                    int childCount = viewGroup.getChildCount();
                    int i3 = 0;
                    while (i3 < childCount && viewGroup.getChildAt(i3) != this.f16134h) {
                        i3++;
                    }
                    this.f16178O = i3;
                    C8017o.m18097a((View) this.f16179P);
                    viewGroup.addView(this.f16179P, i3, new ViewGroup.LayoutParams(this.f16134h.getWidth(), this.f16134h.getHeight()));
                    viewGroup.removeView(this.f16134h);
                }
            }
            float f = this.f16166C;
            int i4 = (int) ((50.0f * f) + 0.5f);
            if (i2 >= 0 && i >= 0) {
                i = (int) (((float) i) * f);
                i2 = (int) (((float) i2) * f);
                if (i < i4) {
                    i = i4;
                }
                if (i2 < i4) {
                    i2 = i4;
                }
            }
            View view = new View(this.f16134h.getContext());
            view.setBackgroundColor(this.f16134h.getContext().getResources().getColor(C7636R.color.ia_mraid_expanded_dimmed_bk));
            view.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.f16181R.addView(view, new RelativeLayout.LayoutParams(-1, -1));
            C8017o.m18097a((View) cVar);
            this.f16180Q.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
            C8017o.m18097a((View) this.f16180Q);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(13);
            this.f16181R.addView(this.f16180Q, layoutParams);
            C8017o.m18097a((View) this.f16181R);
            this.f16187e.addView(this.f16181R, new RelativeLayout.LayoutParams(-1, -1));
            if (cVar != null && !cVar.hasFocus()) {
                cVar.requestFocus();
            }
            int i5 = this.f16185c;
            if (i5 == C7944f.f16221a || (!this.f16165B && i5 != C7944f.f16222b)) {
                m17913e(true);
            }
            this.f16164A = C7976y.EXPANDED;
            mo24771a((C7970s) C7974w.m18004a(this.f16164A));
            int i6 = this.f16171H;
            if (!(i6 == -1 || this.f16172I == -1)) {
                mo24771a((C7970s) C7969r.m17995a(C8006j.m18066a(i6), C8006j.m18066a(this.f16172I)));
            }
            L l = this.f16138l;
            if (l != null) {
                ((C7942d) l).mo24524c_();
            }
            return;
        }
        mo24770a(C7956a.EXPAND, "URL passed to expand() was invalid.");
    }

    /* renamed from: a */
    public final void mo24769a(int i, int i2, int i3, int i4, boolean z) {
        this.f16187e = (FrameLayout) this.f16134h.getRootView().findViewById(16908290);
        if (this.f16187e == null) {
            IAlog.m18023d("Couldn't find content in the view tree");
        } else if (this.f16184b != C7939a.f16207b) {
            C7976y yVar = this.f16164A;
            if (yVar != C7976y.DEFAULT && yVar != C7976y.RESIZED) {
                mo24770a(C7956a.RESIZE, "Ad can be resized only if it's state is default or resized.");
            } else if (i >= 0 || i2 >= 0) {
                mo24776d(false);
                int i5 = this.f16185c;
                if (i5 == C7944f.f16221a || (!this.f16165B && i5 != C7944f.f16222b)) {
                    m17913e(true);
                }
                mo24650a(false);
                this.f16172I = C8006j.m18072b(i2);
                this.f16171H = C8006j.m18072b(i);
                if (!z) {
                    int i6 = (i3 + i) - this.f16167D;
                    if (i6 > 0) {
                        i3 -= i6;
                    }
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    int i7 = (i4 + i2) - this.f16168E;
                    if (i7 > 0) {
                        i4 -= i7;
                    }
                    if (i4 < 0) {
                        i4 = 0;
                    }
                }
                LayoutParams layoutParams = new LayoutParams(C8006j.m18072b(i), C8006j.m18072b(i2));
                layoutParams.leftMargin = i3;
                layoutParams.topMargin = i4;
                if (i3 == 0 && i4 == 0) {
                    layoutParams.gravity = 17;
                }
                this.f16134h.setLayoutParams(layoutParams);
                C7976y yVar2 = this.f16164A;
                C7976y yVar3 = C7976y.RESIZED;
                if (yVar2 != yVar3) {
                    this.f16164A = yVar3;
                    mo24771a((C7970s) C7974w.m18004a(this.f16164A));
                    int i8 = this.f16171H;
                    if (!(i8 == -1 || this.f16172I == -1)) {
                        mo24771a((C7970s) C7969r.m17995a(C8006j.m18066a(i8), C8006j.m18066a(this.f16172I)));
                    }
                }
                L l = this.f16138l;
                if (l != null) {
                    ((C7942d) l).mo24522b();
                }
            } else {
                mo24770a(C7956a.RESIZE, "Creative size passed to resize() was invalid.");
            }
        }
    }

    /* renamed from: g */
    public final void mo24777g(final String str) {
        this.f16150x.post(new Runnable() {
            public final void run() {
                Toast.makeText(C7930d.this.f16134h.getContext(), str, 0).show();
            }
        });
    }

    /* renamed from: q */
    public final void mo24783q() {
        mo24771a((C7970s) C7971t.m17998a(this.f16169F, this.f16170G));
    }

    /* renamed from: r */
    public static void m17918r() {
    }

    public void setResizeProperties() {
    }

    /* renamed from: a */
    public final void mo24773a(Map<String, String> map) {
        boolean z;
        int i;
        Map<String, String> map2 = map;
        String str = "daysInMonth";
        String str2 = "daysInWeek";
        String str3 = "interval";
        String str4 = "frequency";
        String str5 = "transparency";
        String str6 = "summary";
        String str7 = "location";
        String str8 = "end";
        String str9 = Repo.COLUMN_DESCRIPTION;
        String str10 = "start";
        Context context = this.f16134h.getContext();
        if (C8005i.m18062k()) {
            try {
                HashMap hashMap = new HashMap();
                if (!map2.containsKey(str9) || !map2.containsKey(str10)) {
                    throw new IllegalArgumentException("Missing start and description fields");
                }
                hashMap.put("title", map2.get(str9));
                if (!map2.containsKey(str10) || map2.get(str10) == null) {
                    throw new IllegalArgumentException("Invalid calendar event: start is null.");
                }
                Date i2 = m17914i((String) map2.get(str10));
                if (i2 != null) {
                    hashMap.put("beginTime", Long.valueOf(i2.getTime()));
                    if (map2.containsKey(str8) && map2.get(str8) != null) {
                        Date i3 = m17914i((String) map2.get(str8));
                        if (i3 != null) {
                            hashMap.put("endTime", Long.valueOf(i3.getTime()));
                        } else {
                            throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                        }
                    }
                    if (map2.containsKey(str7)) {
                        hashMap.put("eventLocation", map2.get(str7));
                    }
                    if (map2.containsKey(str6)) {
                        hashMap.put(str9, map2.get(str6));
                    }
                    if (map2.containsKey(str5)) {
                        hashMap.put("availability", Integer.valueOf("transparent".equals(map2.get(str5)) ? 1 : 0));
                    }
                    StringBuilder sb = new StringBuilder();
                    if (map2.containsKey(str4)) {
                        String str11 = (String) map2.get(str4);
                        if (map2.containsKey(str3)) {
                            i = Integer.parseInt((String) map2.get(str3));
                        } else {
                            i = -1;
                        }
                        String str12 = "INTERVAL=";
                        String str13 = ";";
                        if ("daily".equals(str11)) {
                            sb.append("FREQ=DAILY;");
                            if (i != -1) {
                                StringBuilder sb2 = new StringBuilder(str12);
                                sb2.append(i);
                                sb2.append(str13);
                                sb.append(sb2.toString());
                            }
                        } else if ("weekly".equals(str11)) {
                            sb.append("FREQ=WEEKLY;");
                            if (i != -1) {
                                StringBuilder sb3 = new StringBuilder(str12);
                                sb3.append(i);
                                sb3.append(str13);
                                sb.append(sb3.toString());
                            }
                            if (map2.containsKey(str2)) {
                                String j = m17915j((String) map2.get(str2));
                                if (j != null) {
                                    StringBuilder sb4 = new StringBuilder("BYDAY=");
                                    sb4.append(j);
                                    sb4.append(str13);
                                    sb.append(sb4.toString());
                                } else {
                                    throw new IllegalArgumentException("invalid ");
                                }
                            }
                        } else if ("monthly".equals(str11)) {
                            sb.append("FREQ=MONTHLY;");
                            if (i != -1) {
                                StringBuilder sb5 = new StringBuilder(str12);
                                sb5.append(i);
                                sb5.append(str13);
                                sb.append(sb5.toString());
                            }
                            if (map2.containsKey(str)) {
                                String k = m17916k((String) map2.get(str));
                                if (k != null) {
                                    StringBuilder sb6 = new StringBuilder("BYMONTHDAY=");
                                    sb6.append(k);
                                    sb6.append(str13);
                                    sb.append(sb6.toString());
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                        }
                    }
                    String sb7 = sb.toString();
                    if (!TextUtils.isEmpty(sb7)) {
                        hashMap.put("rrule", sb7);
                    }
                    Intent type = new Intent("android.intent.action.INSERT").setType(MraidNativeCommandHandler.ANDROID_CALENDAR_CONTENT_TYPE);
                    for (String str14 : hashMap.keySet()) {
                        Object obj = hashMap.get(str14);
                        if (obj instanceof Long) {
                            type.putExtra(str14, ((Long) obj).longValue());
                        } else if (obj instanceof Integer) {
                            type.putExtra(str14, ((Integer) obj).intValue());
                        } else {
                            type.putExtra(str14, (String) obj);
                        }
                    }
                    type.setFlags(268435456);
                    context.startActivity(type);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                }
            } catch (ActivityNotFoundException e) {
                IAlog.m18021b("There is no calendar app installed!");
                mo24770a(C7956a.CREATE_CALENDAR_EVENT, "Action is unsupported on this device - no calendar app installed");
            } catch (IllegalArgumentException e2) {
                StringBuilder sb8 = new StringBuilder("invalid parameters for create calendar ");
                sb8.append(e2.getMessage());
                IAlog.m18021b(sb8.toString());
                mo24770a(C7956a.CREATE_CALENDAR_EVENT, e2.getMessage());
            } catch (Exception e3) {
                IAlog.m18021b("Failed to create calendar event.");
                mo24770a(C7956a.CREATE_CALENDAR_EVENT, "could not create calendar event");
            }
        } else {
            IAlog.m18021b("createCalendarEvent supported for devices post-ICS");
            mo24770a(C7956a.CREATE_CALENDAR_EVENT, "Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
            z = false;
        }
        if (z) {
            L l = this.f16138l;
            if (l != null) {
                ((C7942d) l).mo24534l();
            }
        }
    }

    /* renamed from: i */
    private static Date m17914i(String str) {
        Date date = null;
        int i = 0;
        while (true) {
            String[] strArr = f16163a;
            if (i >= strArr.length) {
                break;
            }
            try {
                date = new SimpleDateFormat(strArr[i], Locale.getDefault()).parse(str);
                if (date != null) {
                    break;
                }
                i++;
            } catch (ParseException e) {
            }
        }
        return date;
    }

    /* renamed from: j */
    private static String m17915j(String str) throws IllegalArgumentException {
        String str2;
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String str3 = ",";
        String[] split = str.split(str3);
        for (String parseInt : split) {
            int parseInt2 = Integer.parseInt(parseInt);
            if (parseInt2 == 7) {
                parseInt2 = 0;
            }
            if (!zArr[parseInt2]) {
                StringBuilder sb2 = new StringBuilder();
                switch (parseInt2) {
                    case 0:
                        str2 = "SU";
                        break;
                    case 1:
                        str2 = "MO";
                        break;
                    case 2:
                        str2 = "TU";
                        break;
                    case 3:
                        str2 = "WE";
                        break;
                    case 4:
                        str2 = "TH";
                        break;
                    case 5:
                        str2 = "FR";
                        break;
                    case 6:
                        str2 = "SA";
                        break;
                    default:
                        StringBuilder sb3 = new StringBuilder("invalid day of week ");
                        sb3.append(parseInt2);
                        throw new IllegalArgumentException(sb3.toString());
                }
                sb2.append(str2);
                sb2.append(str3);
                sb.append(sb2.toString());
                zArr[parseInt2] = true;
            }
        }
        if (split.length != 0) {
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
    }

    /* renamed from: k */
    private static String m17916k(String str) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String str2 = ",";
        String[] split = str.split(str2);
        for (String parseInt : split) {
            int parseInt2 = Integer.parseInt(parseInt);
            int i = parseInt2 + 31;
            if (!zArr[i]) {
                StringBuilder sb2 = new StringBuilder();
                if (parseInt2 == 0 || parseInt2 < -31 || parseInt2 > 31) {
                    StringBuilder sb3 = new StringBuilder("invalid day of month ");
                    sb3.append(parseInt2);
                    throw new IllegalArgumentException(sb3.toString());
                }
                sb2.append(String.valueOf(parseInt2));
                sb2.append(str2);
                sb.append(sb2.toString());
                zArr[i] = true;
            }
        }
        if (split.length != 0) {
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
    }

    /* renamed from: a */
    private void mo24650a(boolean z) {
        try {
            Activity activity = (Activity) this.f16134h.getContext();
            activity.setRequestedOrientation(z ? activity.getResources().getConfiguration().orientation : this.f16175L);
        } catch (ClassCastException e) {
            IAlog.m18021b("Failed to modify the device orientation.");
        }
    }

    public void setOrientationProperties(boolean z, String str) {
        mo24650a(z);
        if ("protrait".equals(str)) {
            this.f16173J = C7940b.PORTRAIT;
        } else if ("landscape".equals(str)) {
            this.f16173J = C7940b.LANDSCAPE;
        } else {
            this.f16173J = C7940b.NONE;
        }
        C7976y yVar = C7976y.EXPANDED;
    }

    /* renamed from: e */
    private void m17913e(boolean z) {
        if (this.f16187e != null) {
            if (z) {
                int b = C8006j.m18072b(35);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b, b);
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = C8006j.m18072b(10);
                layoutParams.topMargin = C8006j.m18072b(10);
                if (this.f16177N == null) {
                    this.f16177N = new IAcloseButton(this.f16134h.getContext(), b);
                    this.f16177N.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            C7930d.this.mo24782p();
                        }
                    });
                }
                C8017o.m18097a((View) this.f16177N);
                this.f16181R.addView(this.f16177N, layoutParams);
            } else {
                this.f16181R.removeView(this.f16177N);
            }
            L l = this.f16138l;
            if (l != null) {
                ((C7942d) l).mo24520a(z);
            }
            this.f16165B = !z;
        }
    }

    /* renamed from: d */
    public final void mo24776d(boolean z) {
        this.f16165B = z;
        L l = this.f16138l;
        if (l != null) {
            ((C7942d) l).mo24520a(this.f16165B);
        }
    }

    /* renamed from: s */
    public final Context mo24784s() {
        return this.f16134h.getContext();
    }

    /* renamed from: a */
    public final void mo24771a(C7970s sVar) {
        if (this.f16134h != null) {
            StringBuilder sb = new StringBuilder("{");
            sb.append(sVar.toString());
            sb.append("}");
            String sb2 = sb.toString();
            C7927c cVar = this.f16134h;
            StringBuilder sb3 = new StringBuilder("window.mraidbridge.fireChangeEvent(");
            sb3.append(sb2);
            sb3.append(");");
            cVar.mo24754a(sb3.toString());
            StringBuilder sb4 = new StringBuilder("Fire changes: ");
            sb4.append(sb2);
            IAlog.m18019a(sb4.toString());
        }
    }

    /* renamed from: a */
    public final void mo24770a(C7956a aVar, String str) {
        String str2 = aVar.f16251q;
        C7927c cVar = this.f16134h;
        if (cVar != null) {
            StringBuilder sb = new StringBuilder("window.mraidbridge.fireErrorEvent('");
            sb.append(str2);
            sb.append("', '");
            sb.append(str);
            sb.append("');");
            cVar.mo24754a(sb.toString());
        }
    }

    /* renamed from: t */
    public final void mo24788t() {
        C7927c cVar = this.f16134h;
        if (cVar != null) {
            cVar.mo24754a("window.mraidbridge.fireReadyEvent();");
        }
    }

    /* renamed from: l */
    private void m17917l(String str) {
        C7927c cVar = this.f16134h;
        if (cVar != null) {
            StringBuilder sb = new StringBuilder("window.mraidbridge.nativeCallComplete('");
            sb.append(str);
            sb.append("');");
            cVar.mo24754a(sb.toString());
        }
    }

    /* renamed from: b */
    public void mo24739b(boolean z) {
        mo24771a((C7970s) new C7977z(z));
        super.mo24739b(z);
    }

    /* renamed from: k */
    public final void mo24767k() {
        if (this.f16176M == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(IAlog.m18018a((Object) this));
                sb.append("registering orientation broadcast receiver");
                IAlog.m18021b(sb.toString());
                this.f16176M = new C7945g<>();
                C7945g gVar = this.f16176M;
                Context context = this.f16134h.getContext();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(IAlog.m18018a((Object) C7930d.this));
                sb2.append("register screen broadcast receiver");
                IAlog.m18021b(sb2.toString());
                gVar.f16225a = context;
                context.registerReceiver(gVar, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(IAlog.m18018a((Object) this));
                sb3.append("failed registering orientation broadcast recevier");
                IAlog.m18023d(sb3.toString());
                if (IAlog.f16291a >= 3) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: l */
    public final void mo24768l() {
        mo24779m();
    }

    /* renamed from: u */
    public final int mo24789u() {
        return this.f16171H;
    }

    /* renamed from: v */
    public final int mo24790v() {
        return this.f16172I;
    }

    /* renamed from: h */
    public final void mo24778h(final String str) {
        final File file = new File(Environment.getExternalStorageDirectory(), "Pictures");
        file.mkdirs();
        new Thread(new Runnable() {

            /* renamed from: d */
            private URI f16197d;

            /* renamed from: e */
            private InputStream f16198e;

            /* renamed from: f */
            private OutputStream f16199f;

            /* renamed from: g */
            private MediaScannerConnection f16200g;

            /* JADX WARNING: Removed duplicated region for block: B:20:0x0096  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x009a A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00a7  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    r0 = 0
                    com.fyber.inneractive.sdk.f.b r1 = new com.fyber.inneractive.sdk.f.b     // Catch:{ Exception -> 0x007d }
                    java.lang.String r2 = r4     // Catch:{ Exception -> 0x007d }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x007d }
                    r2 = 3000(0xbb8, float:4.204E-42)
                    boolean r0 = r1.mo24296a(r2, r0)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    if (r0 == 0) goto L_0x0065
                    java.lang.Object r0 = r1.mo24294a()     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.io.InputStream r0 = (java.io.InputStream) r0     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r6.f16198e = r0     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.lang.String r0 = r4     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.net.URI r0 = java.net.URI.create(r0)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r6.f16197d = r0     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.net.URI r0 = r6.f16197d     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.lang.String r0 = com.fyber.inneractive.sdk.p179l.C7930d.m17906a(r0, r1)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.io.File r3 = r0     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r2.<init>(r3, r0)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r3.<init>(r2)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r6.f16199f = r3     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.io.InputStream r2 = r6.f16198e     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    java.io.OutputStream r3 = r6.f16199f     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    com.fyber.inneractive.sdk.util.C8017o.m18099a(r2, r3)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    com.fyber.inneractive.sdk.l.d$c r2 = new com.fyber.inneractive.sdk.l.d$c     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    com.fyber.inneractive.sdk.l.d r3 = com.fyber.inneractive.sdk.p179l.C7930d.this     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r4 = 0
                    r2.<init>(r3, r0, r4)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    android.media.MediaScannerConnection r0 = new android.media.MediaScannerConnection     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    com.fyber.inneractive.sdk.l.d r3 = com.fyber.inneractive.sdk.p179l.C7930d.this     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    android.content.Context r3 = r3.f16134h.getContext()     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    android.content.Context r3 = r3.getApplicationContext()     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r0.<init>(r3, r2)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r6.f16200g = r0     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    android.media.MediaScannerConnection r0 = r6.f16200g     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r2.f16217d = r0     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    android.media.MediaScannerConnection r0 = r6.f16200g     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                    r0.connect()     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
                L_0x0065:
                    java.io.InputStream r0 = r6.f16198e
                    com.fyber.inneractive.sdk.util.C8017o.m18098a(r0)
                    java.io.OutputStream r0 = r6.f16199f
                    com.fyber.inneractive.sdk.util.C8017o.m18098a(r0)
                    r1.mo24301e()
                    return
                L_0x0073:
                    r0 = move-exception
                    goto L_0x009b
                L_0x0075:
                    r0 = move-exception
                    r0 = r1
                    goto L_0x007e
                L_0x0078:
                    r1 = move-exception
                    r5 = r1
                    r1 = r0
                    r0 = r5
                    goto L_0x009b
                L_0x007d:
                    r1 = move-exception
                L_0x007e:
                    com.fyber.inneractive.sdk.l.d r1 = com.fyber.inneractive.sdk.p179l.C7930d.this     // Catch:{ all -> 0x0078 }
                    android.os.Handler r1 = r1.f16150x     // Catch:{ all -> 0x0078 }
                    com.fyber.inneractive.sdk.l.d$4$1 r2 = new com.fyber.inneractive.sdk.l.d$4$1     // Catch:{ all -> 0x0078 }
                    r2.<init>()     // Catch:{ all -> 0x0078 }
                    r1.post(r2)     // Catch:{ all -> 0x0078 }
                    java.io.InputStream r1 = r6.f16198e
                    com.fyber.inneractive.sdk.util.C8017o.m18098a(r1)
                    java.io.OutputStream r1 = r6.f16199f
                    com.fyber.inneractive.sdk.util.C8017o.m18098a(r1)
                    if (r0 == 0) goto L_0x009a
                    r0.mo24301e()
                    return
                L_0x009a:
                    return
                L_0x009b:
                    java.io.InputStream r2 = r6.f16198e
                    com.fyber.inneractive.sdk.util.C8017o.m18098a(r2)
                    java.io.OutputStream r2 = r6.f16199f
                    com.fyber.inneractive.sdk.util.C8017o.m18098a(r2)
                    if (r1 == 0) goto L_0x00aa
                    r1.mo24301e()
                L_0x00aa:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p179l.C7930d.C79344.run():void");
            }
        }).start();
    }
}
