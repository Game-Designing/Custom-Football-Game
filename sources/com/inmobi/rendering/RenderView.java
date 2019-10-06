package com.inmobi.rendering;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.ads.AdContainer;
import com.inmobi.ads.AdContainer.C10304a;
import com.inmobi.ads.AdContainer.RenderingProperties;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10375ad;
import com.inmobi.ads.C10445bd;
import com.inmobi.ads.C10449be;
import com.inmobi.ads.C10465bq;
import com.inmobi.ads.C10466br;
import com.inmobi.ads.C10478c;
import com.inmobi.ads.C10478c.C10485g;
import com.inmobi.ads.C10478c.C10487i;
import com.inmobi.ads.C10503ca;
import com.inmobi.ads.C10520cb;
import com.inmobi.ads.C10590o;
import com.inmobi.ads.C10603v;
import com.inmobi.ads.NativeTracker;
import com.inmobi.ads.NativeVideoWrapper;
import com.inmobi.ads.cache.C10513a;
import com.inmobi.ads.cache.C10515b;
import com.inmobi.ads.cache.C10519f;
import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.network.C10678e;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.C10689b;
import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.p207a.C10299n;
import com.inmobi.rendering.InMobiAdActivity.C10719a;
import com.inmobi.rendering.mraid.C10777a;
import com.inmobi.rendering.mraid.C10778b;
import com.inmobi.rendering.mraid.C10779c;
import com.inmobi.rendering.mraid.C10780d;
import com.inmobi.rendering.mraid.C10781e;
import com.inmobi.rendering.mraid.C10783f;
import com.inmobi.rendering.mraid.C10785g;
import com.inmobi.rendering.mraid.C10786h;
import com.inmobi.rendering.mraid.C10787i;
import com.inmobi.rendering.mraid.MediaRenderView;
import com.inmobi.rendering.mraid.MraidMediaProcessor;
import com.integralads.avid.library.inmobi.session.AbstractAvidAdSession;
import com.mopub.common.AdType;
import com.mopub.common.Constants;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

@SuppressLint({"SetJavaScriptEnabled", "ViewConstructor", "ClickableViewAccessibility"})
public final class RenderView extends WebView implements AdContainer, C10756b {

    /* renamed from: a */
    public static final C10734a f32713a = new C10734a() {
        /* renamed from: w */
        public final void mo34056w() {
        }

        /* renamed from: y */
        public final void mo34057y() {
        }

        /* renamed from: a */
        public final void mo33974a(RenderView renderView) {
        }

        /* renamed from: b */
        public final void mo34053b(RenderView renderView) {
        }

        /* renamed from: A */
        public final void mo34049A() {
        }

        /* renamed from: c */
        public final void mo33984c(RenderView renderView) {
        }

        /* renamed from: d */
        public final void mo33986d(RenderView renderView) {
        }

        /* renamed from: a */
        public final void mo34052a(HashMap<Object, Object> hashMap) {
        }

        /* renamed from: b */
        public final void mo34055b(HashMap<Object, Object> hashMap) {
        }

        /* renamed from: B */
        public final void mo34050B() {
        }

        /* renamed from: b */
        public final void mo34054b(String str, Map<String, Object> map) {
        }

        /* renamed from: G */
        public final void mo34051G() {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: x */
    public static final String f32714x = RenderView.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f32715A = false;

    /* renamed from: B */
    private WeakReference<ViewGroup> f32716B;

    /* renamed from: C */
    private C10757c f32717C;

    /* renamed from: D */
    private C10478c f32718D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public List<String> f32719E = new ArrayList();

    /* renamed from: F */
    private boolean f32720F;

    /* renamed from: G */
    private C10778b f32721G;

    /* renamed from: H */
    private C10786h f32722H;

    /* renamed from: I */
    private C10785g f32723I;

    /* renamed from: J */
    private JSONObject f32724J;

    /* renamed from: K */
    private JSONObject f32725K;

    /* renamed from: L */
    private boolean f32726L = true;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f32727M = false;

    /* renamed from: N */
    private final Object f32728N = new Object();

    /* renamed from: O */
    private final Object f32729O = new Object();

    /* renamed from: P */
    private boolean f32730P = true;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public View f32731Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public CustomViewCallback f32732R;

    /* renamed from: S */
    private int f32733S = -1;

    /* renamed from: T */
    private boolean f32734T = false;

    /* renamed from: U */
    private long f32735U = Long.MIN_VALUE;

    /* renamed from: V */
    private String f32736V;

    /* renamed from: W */
    private String f32737W;

    /* renamed from: aa */
    private AdContainer f32738aa;

    /* renamed from: ab */
    private C10590o f32739ab;

    /* renamed from: ac */
    private boolean f32740ac = false;

    /* renamed from: ad */
    private boolean f32741ad;

    /* renamed from: ae */
    private Set<C10465bq> f32742ae;

    /* renamed from: af */
    private C10503ca f32743af;

    /* renamed from: ag */
    private final C10304a f32744ag = new C10304a() {
        /* renamed from: a */
        public final void mo33692a() {
            RenderView.f32714x;
            if (RenderView.this.f32748c != null) {
                RenderView.this.f32748c.mo34049A();
            }
        }

        /* renamed from: a */
        public final void mo33693a(Object obj) {
            RenderView.f32714x;
            if (PlacementType.PLACEMENT_TYPE_INLINE == RenderView.this.f32750e.f31249a) {
                String str = "Expanded";
                if (RenderView.this.f32769y != null) {
                    RenderView.this.f32769y.setAndUpdateViewState(str);
                } else {
                    RenderView.this.setAndUpdateViewState(str);
                }
                RenderView.this.f32765t = false;
            }
            if (RenderView.this.f32748c != null) {
                RenderView.this.f32748c.mo33984c(RenderView.this);
            }
        }

        /* renamed from: b */
        public final void mo33694b(Object obj) {
            RenderView.f32714x;
            String str = "Default";
            if (PlacementType.PLACEMENT_TYPE_INLINE == RenderView.this.f32750e.f31249a) {
                RenderView.this.setAndUpdateViewState(str);
                if (RenderView.this.f32769y != null) {
                    RenderView.this.f32769y.setAndUpdateViewState(str);
                }
            } else if (str.equals(RenderView.this.f32749d)) {
                RenderView.this.setAndUpdateViewState("Hidden");
            }
            if (RenderView.this.f32748c != null) {
                RenderView.this.f32748c.mo33986d(RenderView.this);
            }
        }
    };

    /* renamed from: ah */
    private final WebViewClient f32745ah = new WebViewClient() {
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            RenderView.f32714x;
            if (VERSION.SDK_INT < 21) {
                return false;
            }
            String uri = webResourceRequest.getUrl().toString();
            if (RenderView.this.f32755j) {
                webView.loadUrl(uri);
                return true;
            } else if (RenderView.this.mo34568e() || RenderView.this.f32715A || "about:blank".equals(uri)) {
                RenderView.f32714x;
                StringBuilder sb = new StringBuilder("Placement type: ");
                sb.append(RenderView.this.f32750e.f31249a);
                sb.append(" url:");
                sb.append(uri);
                if (PlacementType.PLACEMENT_TYPE_FULLSCREEN != RenderView.this.f32750e.f31249a) {
                    RenderView.f32714x;
                    if (C10689b.m35091a(RenderView.this.getContainerContext(), uri, null) != null) {
                        RenderView.this.getListener().mo34050B();
                    }
                    return true;
                } else if (!RenderView.this.f32715A || !C10689b.m35094a(uri)) {
                    RenderView.f32714x;
                    if (C10689b.m35091a(RenderView.this.getContainerContext(), uri, null) != null) {
                        RenderView.this.getListener().mo34050B();
                    }
                    return true;
                } else {
                    RenderView.f32714x;
                    return false;
                }
            } else {
                RenderView.this.mo34565c("redirect");
                return true;
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            RenderView.f32714x;
            if (RenderView.this.f32755j) {
                webView.loadUrl(str);
                return true;
            } else if (RenderView.this.mo34568e() || RenderView.this.f32715A || "about:blank".equals(str)) {
                RenderView.f32714x;
                StringBuilder sb = new StringBuilder("Placement type: ");
                sb.append(RenderView.this.f32750e.f31249a);
                sb.append(" url:");
                sb.append(str);
                if (PlacementType.PLACEMENT_TYPE_FULLSCREEN != RenderView.this.f32750e.f31249a) {
                    RenderView.f32714x;
                    if (C10689b.m35091a(RenderView.this.getContainerContext(), str, null) != null) {
                        RenderView.this.getListener().mo34050B();
                    }
                    return true;
                } else if (!RenderView.this.f32715A || !C10689b.m35094a(str)) {
                    RenderView.f32714x;
                    if (C10689b.m35091a(RenderView.this.getContainerContext(), str, null) != null) {
                        RenderView.this.getListener().mo34050B();
                    }
                    return true;
                } else {
                    RenderView.f32714x;
                    return false;
                }
            } else {
                RenderView.this.mo34565c("redirect");
                return true;
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            RenderView.f32714x;
            RenderView.this.f32727M = false;
            RenderView.this.setAndUpdateViewState("Loading");
        }

        public final void onPageFinished(WebView webView, String str) {
            RenderView.f32714x;
            if (RenderView.this.f32719E.contains(str) && !RenderView.this.f32727M) {
                RenderView.this.f32727M = true;
                RenderView.f32714x;
                RenderView renderView = RenderView.this;
                renderView.mo34567d(renderView.getMraidJsString());
            }
            if ("Loading".equals(RenderView.this.f32749d)) {
                RenderView.this.f32748c.mo33974a(RenderView.this);
                RenderView.m35216k(RenderView.this);
                if (RenderView.this.f32769y != null) {
                    RenderView.this.setAndUpdateViewState("Expanded");
                    return;
                }
                RenderView.this.setAndUpdateViewState("Default");
            }
        }

        public final void onLoadResource(WebView webView, String str) {
            RenderView.f32714x;
            String url = RenderView.this.getUrl();
            if (str != null && url != null && str.contains("/mraid.js") && !url.equals("about:blank") && !url.startsWith("file:")) {
                if (!RenderView.this.f32719E.contains(url)) {
                    RenderView.this.f32719E.add(url);
                }
                if (!RenderView.this.f32727M) {
                    RenderView.this.f32727M = true;
                    RenderView.f32714x;
                    RenderView renderView = RenderView.this;
                    renderView.mo34567d(renderView.getMraidJsString());
                }
            }
        }

        @TargetApi(22)
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            RenderView.f32714x;
            StringBuilder sb = new StringBuilder("Loading error. Error code:");
            sb.append(i);
            sb.append(" Error msg:");
            sb.append(str);
            sb.append(" Failing url:");
            sb.append(str2);
        }

        @TargetApi(23)
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            RenderView.f32714x;
            StringBuilder sb = new StringBuilder("Loading error. Error code:");
            sb.append(webResourceError.getErrorCode());
            sb.append(" Error msg:");
            sb.append(webResourceError.getDescription());
            sb.append(" Failing url:");
            sb.append(webResourceRequest.getUrl());
        }
    };

    /* renamed from: ai */
    private final WebChromeClient f32746ai = new WebChromeClient() {
        public final boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            RenderView.f32714x;
            StringBuilder sb = new StringBuilder("jsAlert called with: ");
            sb.append(str2);
            sb.append(str);
            if (RenderView.m35194a(RenderView.this, jsResult)) {
                Activity fullScreenActivity = RenderView.this.getFullScreenActivity();
                if (fullScreenActivity != null) {
                    new Builder(fullScreenActivity).setMessage(str2).setTitle(str).setPositiveButton(17039370, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }).setCancelable(false).create().show();
                } else {
                    jsResult.cancel();
                }
            }
            return true;
        }

        public final boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            RenderView.f32714x;
            StringBuilder sb = new StringBuilder("jsConfirm called with: ");
            sb.append(str2);
            sb.append(str);
            if (RenderView.m35194a(RenderView.this, jsResult)) {
                Activity fullScreenActivity = RenderView.this.getFullScreenActivity();
                if (fullScreenActivity != null) {
                    new Builder(fullScreenActivity).setMessage(str2).setPositiveButton(17039370, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }).setNegativeButton(17039360, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.cancel();
                        }
                    }).create().show();
                } else {
                    jsResult.cancel();
                }
            }
            return true;
        }

        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            RenderView.f32714x;
            StringBuilder sb = new StringBuilder("jsPrompt called with: ");
            sb.append(str2);
            sb.append(str);
            if (!RenderView.m35194a(RenderView.this, (JsResult) jsPromptResult)) {
                return true;
            }
            if (RenderView.this.getFullScreenActivity() != null) {
                return false;
            }
            jsPromptResult.cancel();
            return true;
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            if (RenderView.this.f32747b != null && RenderView.this.f32747b.get() != null) {
                RenderView.this.f32731Q = view;
                RenderView.this.f32732R = customViewCallback;
                RenderView.this.f32731Q.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
                FrameLayout frameLayout = (FrameLayout) ((Activity) RenderView.this.f32747b.get()).findViewById(16908290);
                RenderView.this.f32731Q.setBackgroundColor(CtaButton.BACKGROUND_COLOR);
                frameLayout.addView(RenderView.this.f32731Q, new LayoutParams(-1, -1, 0, 0));
                RenderView.this.f32731Q.requestFocus();
                View m = RenderView.this.f32731Q;
                m.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (4 != keyEvent.getKeyCode() || keyEvent.getAction() != 0) {
                            return false;
                        }
                        RenderView.f32714x;
                        C107255.this.m35255a();
                        return true;
                    }
                });
                m.setFocusable(true);
                m.setFocusableInTouchMode(true);
                m.requestFocus();
            }
        }

        public final void onHideCustomView() {
            m35255a();
            super.onHideCustomView();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m35255a() {
            if (RenderView.this.f32731Q != null) {
                if (RenderView.this.f32732R != null) {
                    RenderView.this.f32732R.onCustomViewHidden();
                    RenderView.this.f32732R = null;
                }
                if (!(RenderView.this.f32731Q == null || RenderView.this.f32731Q.getParent() == null)) {
                    ((ViewGroup) RenderView.this.f32731Q.getParent()).removeView(RenderView.this.f32731Q);
                    RenderView.this.f32731Q = null;
                }
            }
        }

        public final void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
            if (!(RenderView.this.f32747b == null || RenderView.this.f32747b.get() == null)) {
                new Builder((Context) RenderView.this.f32747b.get()).setTitle("Location Permission").setMessage("Allow location access").setPositiveButton(17039370, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        callback.invoke(str, true, false);
                    }
                }).setNegativeButton(17039360, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        callback.invoke(str, false, false);
                    }
                }).create().show();
            }
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            StringBuilder sb = new StringBuilder();
            sb.append(consoleMessage.message());
            sb.append(" -- From line ");
            sb.append(consoleMessage.lineNumber());
            sb.append(" of ");
            sb.append(consoleMessage.sourceId());
            RenderView.f32714x;
            return true;
        }
    };
    /* access modifiers changed from: 0000 */

    /* renamed from: b */
    public WeakReference<Activity> f32747b;
    /* access modifiers changed from: 0000 */

    /* renamed from: c */
    public C10734a f32748c;
    /* access modifiers changed from: 0000 */

    /* renamed from: d */
    public String f32749d = "Default";
    /* access modifiers changed from: 0000 */

    /* renamed from: e */
    public RenderingProperties f32750e;

    /* renamed from: f */
    C10779c f32751f;

    /* renamed from: g */
    C10783f f32752g;

    /* renamed from: h */
    MraidMediaProcessor f32753h;

    /* renamed from: i */
    C10787i f32754i;

    /* renamed from: j */
    public boolean f32755j;

    /* renamed from: k */
    boolean f32756k = true;

    /* renamed from: l */
    boolean f32757l = true;

    /* renamed from: m */
    public boolean f32758m = false;

    /* renamed from: n */
    boolean f32759n = false;

    /* renamed from: o */
    boolean f32760o = false;

    /* renamed from: p */
    boolean f32761p = false;

    /* renamed from: q */
    boolean f32762q = false;

    /* renamed from: r */
    String f32763r = null;

    /* renamed from: s */
    public AtomicBoolean f32764s = new AtomicBoolean(false);
    /* access modifiers changed from: 0000 */

    /* renamed from: t */
    public boolean f32765t;

    /* renamed from: u */
    C10735a f32766u;

    /* renamed from: v */
    public boolean f32767v;

    /* renamed from: w */
    final C10519f f32768w = new C10519f() {
        /* renamed from: a */
        public final void mo34174a(C10515b bVar) {
            if (bVar.f32071g != null && bVar.f32065a.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", ((C10513a) bVar.f32065a.get(0)).f32048d);
                    jSONObject.put("reason", ((C10513a) bVar.f32065a.get(0)).f32056l);
                } catch (JSONException e) {
                }
                String replace = jSONObject.toString().replace("\"", "\\\"");
                StringBuilder sb = new StringBuilder("sendSaveContentResult(\"saveContent_");
                sb.append(bVar.f32072h);
                sb.append("\", 'failed', \"");
                sb.append(replace);
                sb.append("\");");
                String sb2 = sb.toString();
                RenderView.f32714x;
                RenderView.this.mo34556a(bVar.f32071g, sb2);
            }
        }

        /* renamed from: b */
        public final void mo34175b(C10515b bVar) {
            if (bVar.f32071g != null && bVar.f32065a.size() > 0) {
                StringBuilder sb = new StringBuilder("sendSaveContentResult(\"saveContent_");
                sb.append(bVar.f32072h);
                sb.append("\", 'success', \"");
                sb.append(((C10513a) bVar.f32065a.get(0)).f32055k);
                sb.append("\");");
                String sb2 = sb.toString();
                RenderView.f32714x;
                RenderView.this.mo34556a(bVar.f32071g, sb2);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: y */
    public RenderView f32769y;

    /* renamed from: z */
    private WeakReference<Activity> f32770z;

    /* renamed from: com.inmobi.rendering.RenderView$a */
    public interface C10734a {
        /* renamed from: A */
        void mo34049A();

        /* renamed from: B */
        void mo34050B();

        /* renamed from: G */
        void mo34051G();

        /* renamed from: a */
        void mo33974a(RenderView renderView);

        /* renamed from: a */
        void mo34052a(HashMap<Object, Object> hashMap);

        /* renamed from: b */
        void mo34053b(RenderView renderView);

        /* renamed from: b */
        void mo34054b(String str, Map<String, Object> map);

        /* renamed from: b */
        void mo34055b(HashMap<Object, Object> hashMap);

        /* renamed from: c */
        void mo33984c(RenderView renderView);

        /* renamed from: d */
        void mo33986d(RenderView renderView);

        /* renamed from: w */
        void mo34056w();

        /* renamed from: y */
        void mo34057y();
    }

    /* renamed from: a */
    static /* synthetic */ boolean m35194a(RenderView renderView, JsResult jsResult) {
        C10487i renderingConfig = renderView.getRenderingConfig();
        if (renderingConfig != null && renderingConfig.f31954l) {
            return true;
        }
        jsResult.cancel();
        renderView.mo34567d("window.mraidview.popupBlocked('popupBlocked')");
        return false;
    }

    /* renamed from: k */
    static /* synthetic */ void m35216k(RenderView renderView) {
        renderView.mo34567d("window.imaiview.broadcastEvent('ready');");
        renderView.mo34567d("window.mraidview.broadcastEvent('ready');");
    }

    public RenderView(Context context, RenderingProperties renderingProperties, Set<C10465bq> set, String str) {
        super(context.getApplicationContext());
        if (context instanceof Activity) {
            this.f32770z = new WeakReference<>((Activity) context);
        }
        this.f32769y = null;
        this.f32750e = renderingProperties;
        this.f32765t = false;
        this.f32742ae = set;
        this.f32737W = str;
        setReferenceContainer(this);
        this.f32738aa = this;
        this.f32739ab = new C10590o();
        this.f32741ad = false;
    }

    public final void setIsPreload(boolean z) {
        this.f32767v = z;
    }

    public final void setPlacementId(long j) {
        this.f32735U = j;
    }

    public final void setImpressionId(String str) {
        this.f32737W = str;
    }

    public final void setCreativeId(String str) {
        this.f32736V = str;
    }

    public final void setAllowAutoRedirection(boolean z) {
        this.f32740ac = z;
    }

    public final void setBlobProvider(C10735a aVar) {
        this.f32766u = aVar;
    }

    public final String getImpressionId() {
        return this.f32737W;
    }

    public final String getCreativeId() {
        return this.f32736V;
    }

    public final long getPlacementId() {
        return this.f32735U;
    }

    public final boolean getAllowAutoRedirection() {
        return this.f32740ac;
    }

    public final void setOriginalRenderView(RenderView renderView) {
        this.f32769y = renderView;
    }

    public final RenderView getOriginalRenderView() {
        return this.f32769y;
    }

    public final Object getDataModel() {
        return null;
    }

    public final C10304a getFullScreenEventsListener() {
        return this.f32744ag;
    }

    public final RenderingProperties getRenderingProperties() {
        return this.f32750e;
    }

    public final String getState() {
        return this.f32749d;
    }

    public final Object getDefaultPositionMonitor() {
        return this.f32728N;
    }

    public final Object getCurrentPositionMonitor() {
        return this.f32729O;
    }

    public final void setDefaultPositionLock() {
        this.f32756k = true;
    }

    public final void setCurrentPositionLock() {
        this.f32757l = true;
    }

    public final Context getContainerContext() {
        WeakReference<Activity> weakReference = this.f32747b;
        if (weakReference == null || weakReference.get() == null) {
            return getContext();
        }
        return (Context) this.f32747b.get();
    }

    public final void setDefaultPosition() {
        int[] iArr = new int[2];
        this.f32724J = new JSONObject();
        if (this.f32716B == null) {
            this.f32716B = new WeakReference<>((ViewGroup) getParent());
        }
        if (this.f32716B.get() != null) {
            ((ViewGroup) this.f32716B.get()).getLocationOnScreen(iArr);
            try {
                this.f32724J.put("x", C10692c.m35106b(iArr[0]));
                this.f32724J.put("y", C10692c.m35106b(iArr[1]));
                int b = C10692c.m35106b(((ViewGroup) this.f32716B.get()).getWidth());
                int b2 = C10692c.m35106b(((ViewGroup) this.f32716B.get()).getHeight());
                this.f32724J.put("width", b);
                this.f32724J.put("height", b2);
            } catch (JSONException e) {
            }
        } else {
            try {
                this.f32724J.put("x", 0);
                this.f32724J.put("y", 0);
                this.f32724J.put("width", 0);
                this.f32724J.put("height", 0);
            } catch (JSONException e2) {
            }
        }
        synchronized (this.f32728N) {
            this.f32756k = false;
            this.f32728N.notifyAll();
        }
    }

    public final String getDefaultPosition() {
        JSONObject jSONObject = this.f32724J;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final void setCurrentPosition() {
        this.f32725K = new JSONObject();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        try {
            this.f32725K.put("x", C10692c.m35106b(iArr[0]));
            this.f32725K.put("y", C10692c.m35106b(iArr[1]));
            int b = C10692c.m35106b(getWidth());
            int b2 = C10692c.m35106b(getHeight());
            this.f32725K.put("width", b);
            this.f32725K.put("height", b2);
        } catch (JSONException e) {
        }
        synchronized (this.f32729O) {
            this.f32757l = false;
            this.f32729O.notifyAll();
        }
    }

    public final String getCurrentPosition() {
        JSONObject jSONObject = this.f32725K;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final void setFullScreenActivityContext(Activity activity) {
        this.f32747b = new WeakReference<>(activity);
        C10785g gVar = this.f32723I;
        if (gVar != null) {
            setOrientationProperties(gVar);
        }
    }

    public final Activity getFullScreenActivity() {
        WeakReference<Activity> weakReference = this.f32747b;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public final Activity getPubActivity() {
        WeakReference<Activity> weakReference = this.f32770z;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public final C10487i getRenderingConfig() {
        return this.f32718D.f31897i;
    }

    public final C10485g getMraidConfig() {
        return this.f32718D.f31898j;
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        StringBuilder sb = new StringBuilder("onSizeChanged (");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(")");
        if (i != 0 && i2 != 0) {
            int b = C10692c.m35106b(i);
            int b2 = C10692c.m35106b(i2);
            StringBuilder sb2 = new StringBuilder("window.mraidview.broadcastEvent('sizeChange',");
            sb2.append(b);
            sb2.append(",");
            sb2.append(b2);
            sb2.append(");");
            mo34567d(sb2.toString());
        }
    }

    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean z = i == 0;
        if (this.f32760o != z) {
            m35203d(z);
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f32734T = !z;
        m35200c(z);
    }

    public final void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (i == 0) {
            m35200c(false);
            return;
        }
        if (!this.f32734T) {
            m35200c(true);
        }
    }

    /* renamed from: c */
    private void m35200c(boolean z) {
        if (this.f32760o != z) {
            if (VERSION.SDK_INT <= 23 || getFullScreenActivity() == null || !getFullScreenActivity().isInMultiWindowMode()) {
                m35203d(z);
            }
        }
    }

    /* renamed from: d */
    private void m35203d(boolean z) {
        if (!this.f32765t) {
            this.f32760o = z;
            if (!z) {
                this.f32754i.mo34789a(getContainerContext());
            } else {
                this.f32748c.mo34053b(this);
            }
            boolean z2 = this.f32760o;
            StringBuilder sb = new StringBuilder("window.mraidview.broadcastEvent('viewableChange',");
            sb.append(z2);
            sb.append(");");
            mo34567d(sb.toString());
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f32720F = isHardwareAccelerated();
        if (this.f32716B == null) {
            this.f32716B = new WeakReference<>((ViewGroup) getParent());
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        new StringBuilder("Touch event received, action:").append(motionEvent.getAction());
        this.f32741ad = true;
        if (mo34568e()) {
            mo34567d("window.mraidview.onUserInteraction();");
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void onDetachedFromWindow() {
        this.f32719E.clear();
        getMediaProcessor().mo34776b();
        getMediaProcessor().mo34777c();
        getMediaProcessor().mo34778e();
        this.f32754i.mo34789a(getContainerContext());
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder("Detaching WebView from window encountered an error (");
            sb.append(e.getMessage());
            String str = ")";
            sb.append(str);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "IllegalArgumentException");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(e.getMessage());
                hashMap.put("message", sb2.toString());
                C10659b.m34983a();
                C10659b.m34987a("ads", "ExceptionCaught", hashMap);
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder("Error in submitting telemetey event : (");
                sb3.append(e2.getMessage());
                sb3.append(str);
            }
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(19)
    /* renamed from: a */
    public final void mo34554a(C10734a aVar, C10478c cVar) {
        this.f32718D = cVar;
        this.f32748c = aVar;
        this.f32716B = new WeakReference<>((ViewGroup) getParent());
        if ("row".contains("staging") && VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (getRenderingConfig() != null) {
            setBackgroundColor(getRenderingConfig().f31948f);
        }
        if (getMraidConfig() != null) {
            if ((System.currentTimeMillis() / 1000) - new C10780d().f32940a.mo34481b("last_updated_ts", 0) > getMraidConfig().f31936a) {
                C10781e eVar = new C10781e(getMraidConfig().f31939d, getMraidConfig().f31937b, getMraidConfig().f31938c);
                String str = eVar.f32942a;
                if (str != null) {
                    eVar.f32943b = new C10676c("GET", str);
                    eVar.f32943b.f32569A = false;
                    HashMap hashMap = new HashMap();
                    hashMap.put("Accept-Encoding", "gzip");
                    eVar.f32943b.mo34502a((Map<String, String>) hashMap);
                    new Thread(new Runnable() {
                        public final void run() {
                            byte[] bArr;
                            int i = 0;
                            while (i <= C10781e.this.f32944d) {
                                C10781e.f32941c;
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                C10677d a = new C10678e(C10781e.this.f32943b).mo34514a();
                                try {
                                    C10299n.m33566a().mo33663a(C10781e.this.f32943b.mo34509g());
                                    C10299n.m33566a().mo33664b(a.mo34513c());
                                    C10299n.m33566a().mo33665c(SystemClock.elapsedRealtime() - elapsedRealtime);
                                } catch (Exception e) {
                                    C10781e.f32941c;
                                    new StringBuilder("Error in setting request-response data size. ").append(e.getMessage());
                                }
                                if (a.mo34510a()) {
                                    C10781e.f32941c;
                                    i++;
                                    if (i > C10781e.this.f32944d) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep((long) (C10781e.this.f32945e * 1000));
                                    } catch (InterruptedException e2) {
                                        C10781e.f32941c;
                                    }
                                } else {
                                    C10780d dVar = new C10780d();
                                    List list = (List) a.f32593d.get("Content-Encoding");
                                    String str = "MraidFetchLatency";
                                    String str2 = "ads";
                                    String str3 = "payloadSize";
                                    String str4 = "latency";
                                    String str5 = "url";
                                    String str6 = ")";
                                    String str7 = "Error in submitting telemetry event : (";
                                    if (list == null || !((String) list.get(0)).equals("gzip")) {
                                        dVar.mo34784a(a.mo34511b());
                                        C10781e.f32941c;
                                        try {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(str5, C10781e.this.f32942a);
                                            hashMap.put(str4, Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                                            hashMap.put(str3, Long.valueOf(C10781e.this.f32943b.mo34509g() + a.mo34513c()));
                                            C10659b.m34983a();
                                            C10659b.m34987a(str2, str, hashMap);
                                            return;
                                        } catch (Exception e3) {
                                            C10781e.f32941c;
                                            StringBuilder sb = new StringBuilder(str7);
                                            sb.append(e3.getMessage());
                                            sb.append(str6);
                                            return;
                                        }
                                    } else {
                                        C10781e.f32941c;
                                        byte[] bArr2 = a.f32590a;
                                        if (bArr2 == null || bArr2.length == 0) {
                                            bArr = new byte[0];
                                        } else {
                                            bArr = new byte[bArr2.length];
                                            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                                        }
                                        byte[] a2 = C10700d.m35148a(bArr);
                                        if (a2 != null) {
                                            try {
                                                dVar.mo34784a(new String(a2, "UTF-8"));
                                                C10781e.f32941c;
                                                try {
                                                    HashMap hashMap2 = new HashMap();
                                                    hashMap2.put(str5, C10781e.this.f32942a);
                                                    hashMap2.put(str4, Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                                                    hashMap2.put(str3, Long.valueOf(C10781e.this.f32943b.mo34509g() + a.mo34513c()));
                                                    C10659b.m34983a();
                                                    C10659b.m34987a(str2, str, hashMap2);
                                                    return;
                                                } catch (Exception e4) {
                                                    C10781e.f32941c;
                                                    StringBuilder sb2 = new StringBuilder(str7);
                                                    sb2.append(e4.getMessage());
                                                    sb2.append(str6);
                                                    return;
                                                }
                                            } catch (UnsupportedEncodingException e5) {
                                                C10781e.f32941c;
                                                C10781e.f32941c;
                                                e5.getMessage();
                                            }
                                        }
                                        return;
                                    }
                                }
                            }
                        }
                    }).start();
                }
            }
        }
        if (VERSION.SDK_INT >= 16) {
            setImportantForAccessibility(2);
        }
        setScrollable(false);
        if (VERSION.SDK_INT >= 17) {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        getSettings().setJavaScriptEnabled(true);
        getSettings().setGeolocationEnabled(true);
        setWebViewClient(this.f32745ah);
        setWebChromeClient(this.f32746ai);
        this.f32717C = new C10757c(this, this.f32750e);
        addJavascriptInterface(this.f32717C, "sdkController");
        this.f32751f = new C10779c(this);
        this.f32752g = new C10783f(this);
        this.f32753h = new MraidMediaProcessor(this);
        this.f32754i = new C10787i(this);
        this.f32721G = new C10778b();
        this.f32722H = new C10786h();
        this.f32723I = new C10785g();
    }

    public final void setScrollable(boolean z) {
        setScrollContainer(z);
        setVerticalScrollBarEnabled(z);
        setHorizontalScrollBarEnabled(z);
    }

    /* access modifiers changed from: 0000 */
    public final void setIsInAppBrowser(boolean z) {
        this.f32715A = z;
    }

    /* renamed from: c */
    public final boolean mo33681c() {
        return this.f32764s.get();
    }

    @TargetApi(11)
    public final void destroy() {
        if (!this.f32764s.get()) {
            if (!this.f32726L) {
                this.f32726L = true;
                return;
            }
            this.f32764s.set(true);
            this.f32765t = true;
            this.f32733S = -1;
            removeJavascriptInterface("sdkController");
            WeakReference<Activity> weakReference = this.f32747b;
            if (weakReference != null) {
                weakReference.clear();
            }
            WeakReference<ViewGroup> weakReference2 = this.f32716B;
            if (weakReference2 != null) {
                weakReference2.clear();
            }
            C10503ca caVar = this.f32743af;
            if (caVar != null) {
                caVar.mo33962d();
                this.f32743af.mo33963e();
            }
            this.f32738aa = null;
            ViewParent parent = getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this);
                removeAllViews();
            }
            super.destroy();
        }
    }

    /* renamed from: a */
    public final void mo33679a(int i, Map<String, String> map) {
        if (i == 1) {
            return;
        }
        if (i == 2) {
            mo34567d("inmobi.recordEvent(120,null);");
        } else if (i == 3) {
        }
    }

    public final void setRequestedScreenOrientation() {
        if (getFullScreenActivity() != null) {
            C10785g gVar = this.f32723I;
            if (gVar != null) {
                setOrientationProperties(gVar);
            }
        }
    }

    public final View getVideoContainerView() {
        return null;
    }

    public final void setReferenceContainer(AdContainer adContainer) {
        this.f32738aa = adContainer;
    }

    public final AdContainer getReferenceContainer() {
        return this.f32738aa;
    }

    public final C10478c getAdConfig() {
        return this.f32718D;
    }

    public final C10590o getApkDownloader() {
        return this.f32739ab;
    }

    @SuppressLint({"SwitchIntDef"})
    public final C10503ca getViewableAd() {
        Activity activity;
        String str = "deferred";
        if (this.f32743af == null) {
            this.f32743af = new C10520cb(this);
            if (getFullScreenActivity() == null) {
                activity = getPubActivity();
            } else {
                activity = getFullScreenActivity();
            }
            Set<C10465bq> set = this.f32742ae;
            if (set != null) {
                if (activity != null) {
                    try {
                        for (C10465bq bqVar : set) {
                            int i = bqVar.f31835a;
                            if (i == 1) {
                                this.f32743af = new C10375ad(this, activity, this.f32743af, bqVar.f31836b);
                            } else if (i == 3) {
                                AbstractAvidAdSession abstractAvidAdSession = (AbstractAvidAdSession) bqVar.f31836b.get("avidAdSession");
                                boolean z = bqVar.f31836b.containsKey(str) && ((Boolean) bqVar.f31836b.get(str)).booleanValue();
                                if (abstractAvidAdSession != null) {
                                    C10603v vVar = new C10603v(this, activity, this.f32743af, abstractAvidAdSession, z);
                                    this.f32743af = vVar;
                                }
                            }
                        }
                    } catch (Exception e) {
                        new StringBuilder("Exception occurred while creating the HTML viewable ad : ").append(e.getMessage());
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", getMarkupType());
                    String str2 = this.f32737W;
                    if (str2 != null) {
                        hashMap.put("impId", str2);
                    }
                    C10659b.m34983a();
                    C10659b.m34987a("ads", "TrackersForService", hashMap);
                }
            }
        }
        return this.f32743af;
    }

    public final String getMarkupType() {
        return AdType.HTML;
    }

    /* renamed from: a */
    public final void mo34555a(String str) {
        this.f32765t = false;
        if (!this.f32764s.get()) {
            loadDataWithBaseURL("", str, "text/html", "UTF-8", null);
        }
    }

    /* renamed from: b */
    public final void mo34562b(String str) {
        this.f32765t = false;
        if (!this.f32764s.get()) {
            loadUrl(str);
        }
    }

    public final void stopLoading() {
        if (!this.f32764s.get()) {
            super.stopLoading();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo34565c(String str) {
        StringBuilder sb = new StringBuilder("window.mraidview.fireRedirectFraudBeacon('");
        sb.append(str);
        sb.append("')");
        mo34567d(sb.toString());
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("plId", Long.valueOf(this.f32735U));
            hashMap.put("creativeId", this.f32736V);
            hashMap.put("impId", this.f32737W);
            hashMap.put("trigger", str);
            C10659b.m34983a();
            C10659b.m34987a("ads", "BlockAutoRedirection", hashMap);
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("Error in submitting telemetey event : (");
            sb2.append(e.getMessage());
            sb2.append(")");
        }
    }

    /* renamed from: b */
    public final void mo34563b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("broadcastEvent('error',\"");
        sb.append(str2);
        sb.append("\", \"");
        sb.append(str3);
        sb.append("\")");
        mo34556a(str, sb.toString());
    }

    /* renamed from: a */
    public final void mo34556a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        mo34567d(sb.toString());
    }

    /* renamed from: a */
    public final void mo34560a(String str, Map<String, Object> map) {
        this.f32748c.mo34054b(str, map);
    }

    /* renamed from: d */
    public final void mo34567d(final String str) {
        if (getContainerContext() != null) {
            new Handler(getContainerContext().getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        if (!RenderView.this.f32764s.get()) {
                            StringBuilder sb = new StringBuilder("javascript:try{");
                            sb.append(str);
                            sb.append("}catch(e){}");
                            String sb2 = sb.toString();
                            RenderView.f32714x;
                            if (VERSION.SDK_INT < 19) {
                                RenderView.this.loadUrl(sb2);
                                return;
                            }
                            RenderView.this.evaluateJavascript(sb2, null);
                        }
                    } catch (Exception e) {
                        RenderView.f32714x;
                        new StringBuilder("SDK encountered an unexpected error injecting JavaScript in the Ad container; ").append(e.getMessage());
                    }
                }
            });
        }
    }

    public final void setUseCustomClose(boolean z) {
        this.f32758m = z;
    }

    public final void setCloseRegionDisabled(boolean z) {
        this.f32761p = z;
    }

    public final void setDisableBackButton(boolean z) {
        this.f32762q = z;
    }

    /* renamed from: a */
    public final void mo34561a(boolean z) {
        setCloseRegionDisabled(z);
        View rootView = getRootView();
        if (rootView != null) {
            CustomView customView = (CustomView) rootView.findViewById(65531);
            if (customView != null) {
                customView.setVisibility(this.f32761p ? 8 : 0);
            }
        }
    }

    /* renamed from: b */
    public final void mo34564b(boolean z) {
        setUseCustomClose(z);
        if (getRootView() != null) {
            CustomView customView = (CustomView) getRootView().findViewById(65532);
            if (customView != null) {
                customView.setVisibility(this.f32758m ? 8 : 0);
            }
        }
    }

    /* renamed from: b */
    public final void mo33680b() {
        MraidMediaProcessor mraidMediaProcessor = this.f32753h;
        MediaRenderView mediaRenderView = mraidMediaProcessor.f32911b;
        if (mediaRenderView != null) {
            mediaRenderView.mo34752a();
            mraidMediaProcessor.f32911b = null;
        }
        String str = "Default";
        if ("Expanded".equals(this.f32749d)) {
            if (!str.equals(this.f32749d)) {
                this.f32765t = true;
                C10779c cVar = this.f32751f;
                if (cVar.f32936a.getOriginalRenderView() == null) {
                    View findViewById = cVar.f32938c.getRootView().findViewById(65535);
                    ((ViewGroup) cVar.f32936a.getParent()).removeView(cVar.f32936a);
                    ((ViewGroup) findViewById.getParent()).removeView(findViewById);
                    ViewGroup viewGroup = cVar.f32938c;
                    viewGroup.addView(cVar.f32936a, cVar.f32939d, new RelativeLayout.LayoutParams(viewGroup.getWidth(), cVar.f32938c.getHeight()));
                    cVar.f32936a.m35214j();
                }
                m35213i();
                this.f32765t = false;
            }
            this.f32726L = false;
        } else {
            if ("Resized".equals(this.f32749d)) {
                if (!str.equals(this.f32749d)) {
                    this.f32765t = true;
                    C10783f fVar = this.f32752g;
                    ViewGroup viewGroup2 = (ViewGroup) fVar.f32948a.getParent();
                    View findViewById2 = viewGroup2.getRootView().findViewById(65534);
                    View findViewById3 = fVar.f32949b.getRootView().findViewById(65535);
                    ((ViewGroup) findViewById2.getParent()).removeView(findViewById2);
                    ((ViewGroup) findViewById3.getParent()).removeView(findViewById3);
                    viewGroup2.removeView(fVar.f32948a);
                    ViewGroup viewGroup3 = fVar.f32949b;
                    viewGroup3.addView(fVar.f32948a, fVar.f32950c, new RelativeLayout.LayoutParams(viewGroup3.getWidth(), fVar.f32949b.getHeight()));
                    fVar.f32948a.m35214j();
                    setAndUpdateViewState(str);
                    this.f32748c.mo33986d(this);
                    this.f32765t = false;
                }
            } else if (str.equals(this.f32749d)) {
                setAndUpdateViewState("Hidden");
                if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == this.f32750e.f31249a) {
                    m35213i();
                } else {
                    ((ViewGroup) getParent()).removeAllViews();
                }
            }
        }
        this.f32719E.clear();
        this.f32759n = false;
    }

    /* renamed from: i */
    private void m35213i() {
        InMobiAdActivity.m35182a((Object) this);
        Activity fullScreenActivity = getFullScreenActivity();
        if (fullScreenActivity != null) {
            ((InMobiAdActivity) fullScreenActivity).f32695a = true;
            fullScreenActivity.finish();
            int i = this.f32733S;
            if (i != -1) {
                fullScreenActivity.overridePendingTransition(0, i);
            }
        } else {
            String str = "Default";
            if (PlacementType.PLACEMENT_TYPE_INLINE == this.f32750e.f31249a) {
                setAndUpdateViewState(str);
                RenderView renderView = this.f32769y;
                if (renderView != null) {
                    renderView.setAndUpdateViewState(str);
                }
            } else if (str.equals(this.f32749d)) {
                setAndUpdateViewState("Hidden");
            }
            C10734a aVar = this.f32748c;
            if (aVar != null) {
                aVar.mo33986d(this);
            }
        }
    }

    public final void setExitAnimation(int i) {
        this.f32733S = i;
    }

    /* renamed from: f */
    private static String m35206f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    /* renamed from: a */
    public final void mo34558a(String str, String str2, String str3, String str4) {
        if (str3 != null) {
            m35193a(str, str2, str3, str4, false);
        } else if (str4 != null) {
            m35193a(str, str2, str4, null, true);
        } else {
            String str5 = str2;
            mo34563b(str2, "Empty url and fallback url", "openExternal");
        }
    }

    /* renamed from: a */
    private void m35193a(String str, String str2, String str3, String str4, boolean z) {
        String str5 = ")";
        String str6 = "Cannot resolve URI (";
        String str7 = "Error message in processing openExternal: ";
        String str8 = "DeeplinkFallbackFailed";
        String str9 = "DeeplinkFailed";
        String str10 = "openExternal";
        while (true) {
            try {
                C10689b.m35096b(getContainerContext(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put("command", str10);
                hashMap.put("scheme", C10466br.m34254a(str2));
                this.f32748c.mo34054b("CreativeInvokedAction", hashMap);
                getListener().mo34050B();
                StringBuilder sb = new StringBuilder("broadcastEvent('");
                sb.append(str);
                sb.append("Successful','");
                sb.append(str3);
                sb.append("');");
                mo34556a(str2, sb.toString());
                return;
            } catch (URISyntaxException e) {
                if (z) {
                    m35198b(str8, str3);
                } else {
                    m35198b(str9, str3);
                }
                new StringBuilder(str7).append(e.getMessage());
                StringBuilder sb2 = new StringBuilder(str6);
                sb2.append(m35206f(str3));
                sb2.append(str5);
                mo34563b(str2, sb2.toString(), str);
                if (str4 != null) {
                    str3 = str4;
                    str4 = null;
                    z = true;
                } else {
                    return;
                }
            } catch (ActivityNotFoundException e2) {
                if (z) {
                    m35198b(str8, str3);
                } else {
                    m35198b(str9, str3);
                }
                new StringBuilder(str7).append(e2.getMessage());
                StringBuilder sb3 = new StringBuilder(str6);
                sb3.append(m35206f(str3));
                sb3.append(str5);
                mo34563b(str2, sb3.toString(), str);
                if (str4 != null) {
                    str3 = str4;
                    str4 = null;
                    z = true;
                } else {
                    return;
                }
            } catch (Exception e3) {
                mo34563b(str2, "Unexpected error", str10);
                Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not open URL; SDK encountered an unexpected error");
                new StringBuilder("SDK encountered unexpected error in handling openExternal() request from creative; ").append(e3.getMessage());
                return;
            }
        }
    }

    /* renamed from: b */
    private void m35198b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str2);
        mo34560a(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: c */
    public final void mo34566c(String str, String str2, String str3) {
        if (str3 != null) {
            String str4 = Constants.HTTP;
            if (!str3.startsWith(str4) || URLUtil.isValidUrl(str3)) {
                if (!str3.startsWith(str4) || str3.contains("play.google.com") || str3.contains("market.android.com") || str3.contains("market%3A%2F%2F")) {
                    mo34558a(str, str2, str3, null);
                    return;
                }
                InMobiAdActivity.m35181a(this);
                Intent intent = new Intent(getContainerContext(), InMobiAdActivity.class);
                intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
                intent.putExtra("com.inmobi.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", str3);
                C10619a.m34834a(getContainerContext(), intent);
                StringBuilder sb = new StringBuilder("broadcastEvent('");
                sb.append(str);
                sb.append("Successful','");
                sb.append(str3);
                sb.append("');");
                mo34556a(str2, sb.toString());
                HashMap hashMap = new HashMap();
                hashMap.put("command", "openEmbedded");
                hashMap.put("scheme", C10466br.m34254a(str2));
                this.f32748c.mo34054b("CreativeInvokedAction", hashMap);
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" called with invalid url (");
        sb2.append(str3);
        sb2.append(")");
        mo34563b(str2, "Invalid URL", str);
    }

    public final void setRenderViewEventListener(C10734a aVar) {
        this.f32748c = aVar;
    }

    public final C10734a getListener() {
        C10734a aVar = this.f32748c;
        if (aVar != null) {
            return aVar;
        }
        C10734a aVar2 = f32713a;
        this.f32748c = aVar2;
        return aVar2;
    }

    public final String getViewState() {
        return this.f32749d;
    }

    public final MraidMediaProcessor getMediaProcessor() {
        return this.f32753h;
    }

    public final C10778b getExpandProperties() {
        return this.f32721G;
    }

    public final void setExpandProperties(C10778b bVar) {
        if (bVar.f32930b) {
            setUseCustomClose(bVar.f32929a);
        }
        this.f32721G = bVar;
    }

    public final C10786h getResizeProperties() {
        return this.f32722H;
    }

    public final void setResizeProperties(C10786h hVar) {
        this.f32722H = hVar;
    }

    public final void setAndUpdateViewState(String str) {
        this.f32749d = str;
        new StringBuilder("set state:").append(this.f32749d);
        String lowerCase = this.f32749d.toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder("window.mraidview.broadcastEvent('stateChange','");
        sb.append(lowerCase);
        sb.append("');");
        mo34567d(sb.toString());
    }

    /* renamed from: j */
    private void m35214j() {
        setVisibility(0);
        requestLayout();
    }

    public final void setAdActiveFlag(boolean z) {
        this.f32759n = z;
    }

    public final C10785g getOrientationProperties() {
        return this.f32723I;
    }

    public final void setOrientationProperties(C10785g gVar) {
        this.f32723I = gVar;
        WeakReference<Activity> weakReference = this.f32747b;
        if (!(weakReference == null || weakReference.get() == null || gVar.f32953a)) {
            String str = gVar.f32954b;
            char c = 65535;
            int hashCode = str.hashCode();
            boolean z = true;
            if (hashCode != 729267099) {
                if (hashCode == 1430647483 && str.equals("landscape")) {
                    c = 0;
                }
            } else if (str.equals("portrait")) {
                c = 1;
            }
            if (c == 0) {
                if (!(C10692c.m35105b() == 3 || C10692c.m35105b() == 4)) {
                    z = false;
                }
                if (z) {
                    if (3 == C10692c.m35105b()) {
                        ((Activity) this.f32747b.get()).setRequestedOrientation(0);
                    } else {
                        ((Activity) this.f32747b.get()).setRequestedOrientation(8);
                    }
                } else if (gVar.f32955c.equals("left")) {
                    ((Activity) this.f32747b.get()).setRequestedOrientation(8);
                } else if (gVar.f32955c.equals("right")) {
                    ((Activity) this.f32747b.get()).setRequestedOrientation(0);
                }
            } else if (c != 1) {
                if (C10692c.m35105b() == 2) {
                    ((Activity) this.f32747b.get()).setRequestedOrientation(9);
                } else if (C10692c.m35105b() == 4) {
                    ((Activity) this.f32747b.get()).setRequestedOrientation(8);
                } else if (C10692c.m35105b() == 3) {
                    ((Activity) this.f32747b.get()).setRequestedOrientation(0);
                } else {
                    ((Activity) this.f32747b.get()).setRequestedOrientation(1);
                }
            } else if (C10692c.m35105b() == 2) {
                ((Activity) this.f32747b.get()).setRequestedOrientation(9);
            } else {
                ((Activity) this.f32747b.get()).setRequestedOrientation(1);
            }
        }
    }

    public final String getMraidJsString() {
        String c = new C10780d().f32940a.mo34483c("mraid_js_string");
        if (c == null) {
            return "var imIsObjValid=function(a){return\"undefined\"!=typeof a&&null!=a?!0:!1},EventListeners=function(a){this.event=a;this.count=0;var b=[];this.add=function(a){b.push(a);++this.count};this.remove=function(a){var e=!1,d=this;b=b.filter(function(b){if(b=b===a)--d.count,e=!0;return!b});return e};this.removeAll=function(){b=[];this.count=0};this.broadcast=function(a){b.forEach(function(e){try{e.apply({},a)}catch(d){}})};this.toString=function(){var c=[a,\":\"];b.forEach(function(a){c.push(\"|\",String(a),\"|\")});\nreturn c.join(\"\")}},InmobiObj=function(){this.listeners=[];this.addEventListener=function(a,b){try{if(imIsObjValid(b)&&imIsObjValid(a)){var c=this.listeners;c[a]||(c[a]=new EventListeners);c[a].add(b);\"micIntensityChange\"==a&&window.imraidview.startListeningMicIntensity();\"deviceMuted\"==a&&window.imraidview.startListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&window.imraidview.startListeningDeviceVolumeChange();\"volumeChange\"==a&&window.imraidview.startListeningVolumeChange();\"headphones\"==a&&\nwindow.imraidview.startListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&window.imraidview.startListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&window.imraidview.registerDownloaderCallbacks()}}catch(e){this.log(e)}};this.removeEventListener=function(a,b){if(imIsObjValid(a)){var c=this.listeners;imIsObjValid(c[a])&&(imIsObjValid(b)?c[a].remove(b):c[a].removeAll());\"micIntensityChange\"==a&&0==c[a].count&&window.imraidview.stopListeningMicIntensity();\"deviceMuted\"==a&&0==c[a].count&&\nwindow.imraidview.stopListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningDeviceVolumeChange();\"volumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningVolumeChange();\"headphones\"==a&&0==c[a].count&&window.imraidview.stopListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&0==c[a].count&&window.imraidview.stopListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&0==c[a].count&&window.imraidview.unregisterDownloaderCallbacks()}};\nthis.broadcastEvent=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)b[c]=arguments[c];c=b.shift();try{this.listeners[c]&&this.listeners[c].broadcast(b)}catch(e){}}};this.sendSaveContentResult=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)if(2==c){var e=arguments[c],e=JSON.parse(e);b[c]=e}else b[c]=arguments[c];e=b[1];\"success\"!=e&&(c=b[0].substring(b[0].indexOf(\"_\")+1),imraid.saveContentIDMap[c]&&delete imraid.saveContentIDMap[c]);\nwindow.imraid.broadcastEvent(b[0],b[1],b[2])}}},__im__iosNativeMessageHandler=void 0;window.webkit&&(window.webkit.messageHandlers&&window.webkit.messageHandlers.nativeMessageHandler)&&(__im__iosNativeMessageHandler=window.webkit.messageHandlers.nativeMessageHandler);\nvar __im__iosNativeCall={nativeCallInFlight:!1,nativeCallQueue:[],executeNativeCall:function(a){this.nativeCallInFlight?this.nativeCallQueue.push(a):(this.nativeCallInFlight=!0,imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=a)},nativeCallComplete:function(a){0==this.nativeCallQueue.length?this.nativeCallInFlight=!1:(a=this.nativeCallQueue.shift(),imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=\na)}},IOSNativeCall=function(){this.urlScheme=\"\";this.executeNativeCall=function(a){if(imIsObjValid(__im__iosNativeMessageHandler)){e={};e.command=a;e.scheme=this.urlScheme;for(var b={},c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b[arguments[c]]=\"\"+d);e.params=b}else for(var e=this.urlScheme+\"://\"+a,d,b=!0,c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b?(e+=\"?\",b=!1):e+=\"&\",e+=arguments[c]+\"=\"+escape(d));__im__iosNativeCall.executeNativeCall(e);return\"OK\"};this.nativeCallComplete=\nfunction(a){__im__iosNativeCall.nativeCallComplete(a);return\"OK\"};this.updateKV=function(a,b){this[a]=b;var c=this.broadcastMap[a];c&&this.broadcastEvent(c,b)}};\n(function(){var a=window.mraidview={};a.orientationProperties={allowOrientationChange:!0,forceOrientation:\"none\",direction:\"right\"};var b=[],c=!1;a.detectAndBlockFraud=function(e){a.isPossibleFraud()&&a.fireRedirectFraudBeacon(e);return!1};a.popupBlocked=function(e){a.firePopupBlockedBeacon(e)};a.zeroPad=function(a){var d=\"\";10>a&&(d+=\"0\");return d+a};a.supports=function(a){console.log(\"bridge: supports (MRAID)\");if(\"string\"!=typeof a)window.mraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\n\"supports\");else return\"false\"!=sdkController.supports(\"window.mraidview\",a)};a.useCustomClose=function(a){try{sdkController.useCustomClose(\"window.mraidview\",a)}catch(d){imraidview.showAlert(\"use CustomClose: \"+d)}};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};a.stackCommands=function(a,d){c?b.push(a):(eval(a),d&&(c=!0))};a.expand=function(a){try{\"undefined\"==typeof a&&(a=null),sdkController.expand(\"window.mraidview\",a)}catch(d){imraidview.showAlert(\"executeNativeExpand: \"+\nd+\", URL = \"+a)}};a.setExpandProperties=function(e){try{e?this.props=e:e=null;if(\"undefined\"!=typeof e.lockOrientation&&null!=e.lockOrientation&&\"undefined\"!=typeof e.orientation&&null!=e.orientation){var d={};d.allowOrientationChange=!e.lockOrientation;d.forceOrientation=e.orientation;a.setOrientationProperties(d)}sdkController.setExpandProperties(\"window.mraidview\",a.stringify(e))}catch(b){imraidview.showAlert(\"executeNativesetExpandProperties: \"+b+\", props = \"+e)}};a.getExpandProperties=function(){try{return eval(\"(\"+\nsdkController.getExpandProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getExpandProperties: \"+a)}};a.setOrientationProperties=function(e){try{e?(\"undefined\"!=typeof e.allowOrientationChange&&(a.orientationProperties.allowOrientationChange=e.allowOrientationChange),\"undefined\"!=typeof e.forceOrientation&&(a.orientationProperties.forceOrientation=e.forceOrientation)):e=null,sdkController.setOrientationProperties(\"window.mraidview\",a.stringify(a.orientationProperties))}catch(d){imraidview.showAlert(\"setOrientationProperties: \"+\nd+\", props = \"+e)}};a.getOrientationProperties=function(){return{forceOrientation:a.orientationProperties.forceOrientation,allowOrientationChange:a.orientationProperties.allowOrientationChange}};a.resizeProps=null;a.setResizeProperties=function(e){var d,b;try{d=parseInt(e.width);b=parseInt(e.height);if(isNaN(d)||isNaN(b)||1>d||1>b)throw\"Invalid\";e.width=d;e.height=b;a.resizeProps=e;sdkController.setResizeProperties(\"window.mraidview\",a.stringify(e))}catch(c){window.mraid.broadcastEvent(\"error\",\"Invalid properties.\",\n\"setResizeProperties\")}};a.getResizeProperties=function(){try{return eval(\"(\"+sdkController.getResizeProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getResizeProperties: \"+a)}};a.open=function(a){\"undefined\"==typeof a&&(a=null);try{sdkController.open(\"window.mraidview\",a)}catch(d){imraidview.showAlert(\"open: \"+d)}};a.getScreenSize=function(){try{return eval(\"(\"+sdkController.getScreenSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getScreenSize: \"+a)}};a.getMaxSize=\nfunction(){try{return eval(\"(\"+sdkController.getMaxSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getMaxSize: \"+a)}};a.getCurrentPosition=function(){try{return eval(\"(\"+sdkController.getCurrentPosition(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getCurrentPosition: \"+a)}};a.getDefaultPosition=function(){try{return eval(\"(\"+sdkController.getDefaultPosition(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getDefaultPosition: \"+a)}};a.getState=function(){try{return String(sdkController.getState(\"window.mraidview\"))}catch(a){imraidview.showAlert(\"getState: \"+\na)}};a.isViewable=function(){try{return sdkController.isViewable(\"window.mraidview\")}catch(a){imraidview.showAlert(\"isViewable: \"+a)}};a.getPlacementType=function(){return sdkController.getPlacementType(\"window.mraidview\")};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};\"function\"!=typeof String.prototype.startsWith&&(String.prototype.startsWith=function(a){return 0==this.indexOf(a)});a.playVideo=function(a){var d=\"\";null!=a&&(d=a);try{sdkController.playVideo(\"window.mraidview\",\nd)}catch(b){imraidview.showAlert(\"playVideo: \"+b)}};a.stringify=function(e){if(\"undefined\"===typeof JSON){var d=\"\",b;if(\"undefined\"==typeof e.length)return a.stringifyArg(e);for(b=0;b<e.length;b++)0<b&&(d+=\",\"),d+=a.stringifyArg(e[b]);return d+\"]\"}return JSON.stringify(e)};a.stringifyArg=function(a){var d,b,c;b=typeof a;d=\"\";if(\"number\"===b||\"boolean\"===b)d+=args;else if(a instanceof Array)d=d+\"[\"+a+\"]\";else if(a instanceof Object){b=!0;d+=\"{\";for(c in a)null!==a[c]&&(b||(d+=\",\"),d=d+'\"'+c+'\":',b=\ntypeof a[c],d=\"number\"===b||\"boolean\"===b?d+a[c]:\"function\"===typeof a[c]?d+'\"\"':a[c]instanceof Object?d+this.stringify(args[i][c]):d+'\"'+a[c]+'\"',b=!1);d+=\"}\"}else a=a.replace(/\\\\/g,\"\\\\\\\\\"),a=a.replace(/\"/g,'\\\\\"'),d=d+'\"'+a+'\"';imraidview.showAlert(\"json:\"+d);return d};getPID=function(a){var d=\"\";null!=a&&(\"undefined\"!=typeof a.id&&null!=a.id)&&(d=a.id);return d};a.resize=function(){if(null==a.resizeProps)window.mraid.broadcastEvent(\"error\",\"Valid resize dimensions must be provided before calling resize\",\n\"resize\");else try{sdkController.resize(\"window.mraidview\")}catch(b){imraidview.showAlert(\"resize called in bridge\")}};a.createCalendarEvent=function(a){var d={};\"object\"!=typeof a&&window.mraid.broadcastEvent(\"error\",\"createCalendarEvent method expects parameter\",\"createCalendarEvent\");if(\"string\"!=typeof a.start||\"string\"!=typeof a.end)window.mraid.broadcastEvent(\"error\",\"createCalendarEvent method expects string parameters for start and end dates\",\"createCalendarEvent\");else{\"string\"!=typeof a.id&&\n(a.id=\"\");\"string\"!=typeof a.location&&(a.location=\"\");\"string\"!=typeof a.description&&(a.description=\"\");\"string\"!=typeof a.summary&&(a.summary=\"\");\"string\"==typeof a.status&&(\"pending\"==a.status||\"tentative\"==a.status||\"confirmed\"==a.status||\"cancelled\"==a.status)||(a.status=\"\");\"string\"==typeof a.transparency&&(\"opaque\"==a.transparency||\"transparent\"==a.transparency)||(a.transparency=\"\");if(null==a.recurrence||\"\"==a.recurrence)d={};else{\"string\"==typeof a.summary&&(d.frequency=a.recurrence.frequency);\nnull!=a.recurrence.interval&&(d.interval=a.recurrence.interval);\"string\"==typeof a.summary&&(d.expires=a.recurrence.expires);null!=a.recurrence.exceptionDates&&(d.exceptionDates=a.recurrence.exceptionDates);if(null!=a.recurrence.daysInWeek){var b=formatDaysInWeek(a.recurrence.daysInWeek);null!=b?d.daysInWeek=b:imraidview.showAlert(\"daysInWeek invalid format \")}d.daysInMonth=a.recurrence.daysInMonth;d.daysInYear=a.recurrence.daysInYear;d.weeksInMonth=a.recurrence.weeksInMonth;d.monthsInYear=a.recurrence.monthsInYear}\"string\"!=\ntypeof a.reminder&&(a.reminder=\"\");try{sdkController.createCalendarEvent(\"window.mraidview\",a.id,a.start,a.end,a.location,a.description,a.summary,a.status,a.transparency,JSON.stringify(d),a.reminder)}catch(c){sdkController.createCalendarEvent(\"window.mraidview\",a.start,a.end,a.location,a.description)}}};formatDaysInWeek=function(a){try{if(0!=a.length){for(var d=0;d<a.length;d++)switch(a[d]){case 0:a[d]=\"SU\";break;case 1:a[d]=\"MO\";break;case 2:a[d]=\"TU\";break;case 3:a[d]=\"WE\";break;case 4:a[d]=\"TH\";\nbreak;case 5:a[d]=\"FR\";break;case 6:a[d]=\"SA\";break;default:return null}return a}}catch(b){}return null};a.storePicture=function(b){console.log(\"bridge: storePicture\");if(\"string\"!=typeof b)window.mraid.broadcastEvent(\"error\",\"storePicture method expects url as string parameter\",\"storePicture\");else{if(a.supports(\"storePicture\"))return!window.confirm(\"Do you want to download the file?\")?(window.mraid.broadcastEvent(\"error\",\"Store picture on \"+b+\" was cancelled by user.\",\"storePicture\"),!1):sdkController.storePicture(\"window.mraidview\",\nb);window.mraid.broadcastEvent(\"error\",\"Store picture on \"+b+\" was cancelled because it is unsupported in this device/app.\",\"storePicture\")}};a.fireMediaTrackingEvent=function(a,d){};a.fireMediaErrorEvent=function(a,d){};a.fireMediaTimeUpdateEvent=function(a,d,b){};a.fireMediaCloseEvent=function(a,d,b){};a.fireMediaVolumeChangeEvent=function(a,d,b){};a.broadcastEvent=function(){window.mraid.broadcastEvent.apply(window.mraid,arguments)}})();\n(function(){var a=window.mraid=new InmobiObj,b=window.mraidview,c=!1;b.isAdShownToUser=!1;b.onUserInteraction=function(){c=!0};b.isPossibleFraud=function(){return a.supports(\"redirectFraudDetection\")&&(!b.isAdShownToUser||!c)};b.fireRedirectFraudBeacon=function(a){if(\"undefined\"!=typeof inmobi&&inmobi.recordEvent){var d={};d.trigger=a;d.isAdShown=b.isAdShownToUser.toString();inmobi.recordEvent(135,d)}};b.firePopupBlockedBeacon=function(a){if(\"undefined\"!=typeof inmobi&&inmobi.recordEvent){var d={};\nd.trigger=a;inmobi.recordEvent(136,d)}};window.onbeforeunload=function(){b.detectAndBlockFraud(\"redirect\")};a.addEventListener(\"viewableChange\",function(a){a&&!b.isAdShownToUser&&(b.isAdShownToUser=!0)});a.useCustomClose=b.useCustomClose;a.close=b.close;a.getExpandProperties=b.getExpandProperties;a.setExpandProperties=function(c){\"undefined\"!=typeof c&&(\"useCustomClose\"in c&&\"undefined\"!=typeof a.getState()&&\"expanded\"!=a.getState())&&a.useCustomClose(c.useCustomClose);b.setExpandProperties(c)};a.getResizeProperties=\nb.getResizeProperties;a.setResizeProperties=b.setResizeProperties;a.getOrientationProperties=b.getOrientationProperties;a.setOrientationProperties=b.setOrientationProperties;a.expand=b.expand;a.getMaxSize=b.getMaxSize;a.getState=b.getState;a.isViewable=b.isViewable;a.createCalendarEvent=function(a){b.detectAndBlockFraud(\"mraid.createCalendarEvent\")||b.createCalendarEvent(a)};a.open=function(c){b.detectAndBlockFraud(\"mraid.open\")||(\"string\"!=typeof c?a.broadcastEvent(\"error\",\"URL is required.\",\"open\"):\nb.open(c))};a.resize=b.resize;a.getVersion=function(){return\"2.0\"};a.getPlacementType=b.getPlacementType;a.playVideo=function(a){b.playVideo(a)};a.getScreenSize=b.getScreenSize;a.getCurrentPosition=b.getCurrentPosition;a.getDefaultPosition=b.getDefaultPosition;a.supports=function(a){return b.supports(a)};a.storePicture=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\"Request must specify a valid URL\",\"storePicture\"):b.storePicture(c)}})();\n(function(){var a=window.imraidview={},b,c=!0;a.setOrientationProperties=function(d){try{d?(\"undefined\"!=typeof d.allowOrientationChange&&(mraidview.orientationProperties.allowOrientationChange=d.allowOrientationChange),\"undefined\"!=typeof d.forceOrientation&&(mraidview.orientationProperties.forceOrientation=d.forceOrientation),\"undefined\"!=typeof d.direction&&(mraidview.orientationProperties.direction=d.direction)):d=null,sdkController.setOrientationProperties(\"window.imraidview\",mraidview.stringify(mraidview.orientationProperties))}catch(b){a.showAlert(\"setOrientationProperties: \"+\nb+\", props = \"+d)}};a.getOrientationProperties=function(){return mraidview.orientationProperties};a.getWindowOrientation=function(){var a=window.orientation;0>a&&(a+=360);window.innerWidth!==this.previousWidth&&0==a&&window.innerWidth>window.innerHeight&&(a=90);return a};var e=function(){window.setTimeout(function(){if(c||a.getWindowOrientation()!==b)c=!1,b=a.getWindowOrientation(),sdkController.onOrientationChange(\"window.imraidview\"),imraid.broadcastEvent(\"orientationChange\",b)},200)};a.registerOrientationListener=\nfunction(){b=a.getWindowOrientation();window.addEventListener(\"resize\",e,!1);window.addEventListener(\"orientationchange\",e,!1)};a.unRegisterOrientationListener=function(){window.removeEventListener(\"resize\",e,!1);window.removeEventListener(\"orientationchange\",e,!1)};window.imraidview.registerOrientationListener();a.firePostStatusEvent=function(a){window.imraid.broadcastEvent(\"postStatus\",a)};a.fireMediaTrackingEvent=function(a,b){var c={};c.name=a;var e=\"inmobi_media_\"+a;\"undefined\"!=typeof b&&(null!=\nb&&\"\"!=b)&&(e=e+\"_\"+b);window.imraid.broadcastEvent(e,c)};a.fireMediaErrorEvent=function(a,b){var c={name:\"error\"};c.code=b;var e=\"inmobi_media_\"+c.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(e=e+\"_\"+a);window.imraid.broadcastEvent(e,c)};a.fireMediaTimeUpdateEvent=function(a,b,c){var e={name:\"timeupdate\",target:{}};e.target.currentTime=b;e.target.duration=c;b=\"inmobi_media_\"+e.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,e)};a.saveContent=function(a,\nb,c){window.imraid.addEventListener(\"saveContent_\"+a,c);sdkController.saveContent(\"window.imraidview\",a,b)};a.cancelSaveContent=function(a){sdkController.cancelSaveContent(\"window.imraidview\",a)};a.disableCloseRegion=function(a){sdkController.disableCloseRegion(\"window.imraidview\",a)};a.fireGalleryImageSelectedEvent=function(a,b,c){var e=new Image;e.src=\"data:image/jpeg;base64,\"+a;e.width=b;e.height=c;window.imraid.broadcastEvent(\"galleryImageSelected\",e)};a.fireCameraPictureCatpturedEvent=function(a,\nb,c){var e=new Image;e.src=\"data:image/jpeg;base64,\"+a;e.width=b;e.height=c;window.imraid.broadcastEvent(\"cameraPictureCaptured\",e)};a.fireMediaCloseEvent=function(a,b,c){var e={name:\"close\"};e.viaUserInteraction=b;e.target={};e.target.currentTime=c;b=\"inmobi_media_\"+e.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,e)};a.fireMediaVolumeChangeEvent=function(a,b,c){var e={name:\"volumechange\",target:{}};e.target.volume=b;e.target.muted=c;b=\"inmobi_media_\"+e.name;\n\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,e)};a.fireDeviceMuteChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceMuted\",a)};a.fireDeviceVolumeChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceVolumeChange\",a)};a.fireHeadphonePluggedEvent=function(a){window.imraid.broadcastEvent(\"headphones\",a)};a.showAlert=function(a){sdkController.showAlert(\"window.imraidview\",a)};a.openExternal=function(b,c){try{600<=getSdkVersionInt()?sdkController.openExternal(\"window.imraidview\",\nb,c):sdkController.openExternal(\"window.imraidview\",b)}catch(e){a.showAlert(\"openExternal: \"+e)}};a.log=function(b){try{sdkController.log(\"window.imraidview\",b)}catch(c){a.showAlert(\"log: \"+c)}};a.getPlatform=function(){return\"android\"};a.asyncPing=function(b){try{sdkController.asyncPing(\"window.imraidview\",b)}catch(c){a.showAlert(\"asyncPing: \"+c)}};a.startListeningDeviceMuteEvents=function(){sdkController.registerDeviceMuteEventListener(\"window.imraidview\")};a.stopListeningDeviceMuteEvents=function(){sdkController.unregisterDeviceMuteEventListener(\"window.imraidview\")};\na.startListeningDeviceVolumeChange=function(){sdkController.registerDeviceVolumeChangeEventListener(\"window.imraidview\")};a.stopListeningDeviceVolumeChange=function(){sdkController.unregisterDeviceVolumeChangeEventListener(\"window.imraidview\")};a.startListeningHeadphonePluggedEvents=function(){sdkController.registerHeadphonePluggedEventListener(\"window.imraidview\")};a.stopListeningHeadphonePluggedEvents=function(){sdkController.unregisterHeadphonePluggedEventListener(\"window.imraidview\")};getSdkVersionInt=\nfunction(){for(var b=a.getSdkVersion().split(\".\"),c=b.length,e=\"\",f=0;f<c;f++)e+=b[f];return parseInt(e)};a.getSdkVersion=function(){return window._im_imaiview.getSdkVersion()};a.supports=function(a){console.log(\"bridge: supports (IMRAID)\");if(\"string\"!=typeof a)window.imraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\"supports\");else return\"false\"!=sdkController.supports(\"window.imraidview\",a)};a.postToSocial=function(a,b,c,e){a=parseInt(a);isNaN(a)?window.imraid.broadcastEvent(\"error\",\n\"socialType must be an integer\",\"postToSocial\"):(\"string\"!=typeof b&&(b=\"\"),\"string\"!=typeof c&&(c=\"\"),\"string\"!=typeof e&&(e=\"\"),sdkController.postToSocial(\"window.imraidview\",a,b,c,e))};a.incentCompleted=function(a){if(\"object\"!=typeof a||null==a)sdkController.incentCompleted(\"window.imraidview\",null);else try{sdkController.incentCompleted(\"window.imraidview\",JSON.stringify(a))}catch(b){sdkController.incentCompleted(\"window.imraidview\",null)}};a.getOrientation=function(){try{return String(sdkController.getOrientation(\"window.imraidview\"))}catch(b){a.showAlert(\"getOrientation: \"+\nb)}};a.acceptAction=function(b){try{sdkController.acceptAction(\"window.imraidview\",mraidview.stringify(b))}catch(c){a.showAlert(\"acceptAction: \"+c+\", params = \"+b)}};a.rejectAction=function(b){try{sdkController.rejectAction(\"window.imraidview\",mraidview.stringify(b))}catch(c){a.showAlert(\"rejectAction: \"+c+\", params = \"+b)}};a.updateToPassbook=function(b){window.imraid.broadcastEvent(\"error\",\"Method not supported\",\"updateToPassbook\");a.log(\"Method not supported\")};a.isDeviceMuted=function(){return\"false\"!=\nsdkController.isDeviceMuted(\"window.imraidview\")};a.getDeviceVolume=function(){return 603>=getSdkVersionInt()?-1:sdkController.getDeviceVolume(\"window.imraidview\")};a.isHeadPhonesPlugged=function(){return\"false\"!=sdkController.isHeadphonePlugged(\"window.imraidview\")};a.sendSaveContentResult=function(){window.imraid.sendSaveContentResult.apply(window.imraid,arguments)};a.broadcastEvent=function(){window.imraid.broadcastEvent.apply(window.imraid,arguments)};a.disableBackButton=function(a){void 0==a||\n\"boolean\"!=typeof a?console.log(\"disableBackButton called with invalid params\"):sdkController.disableBackButton(\"window.imraidview\",a)};a.isBackButtonDisabled=function(){return sdkController.isBackButtonDisabled(\"window.imraidview\")};a.startListeningForBackButtonPressedEvent=function(){sdkController.registerBackButtonPressedEventListener(\"window.imraidview\")};a.stopListeningForBackButtonPressedEvent=function(){sdkController.unregisterBackButtonPressedEventListener(\"window.imraidview\")};a.hideStatusBar=\nfunction(){};a.setOpaqueBackground=function(){};a.startDownloader=function(a,b,c){682<=getSdkVersionInt()&&sdkController.startDownloader(\"window.imraidview\",a,b,c)};a.registerDownloaderCallbacks=function(){682<=getSdkVersionInt()&&sdkController.registerDownloaderCallbacks(\"window.imraidview\")};a.unregisterDownloaderCallbacks=function(){682<=getSdkVersionInt()&&sdkController.unregisterDownloaderCallbacks(\"window.imraidview\")};a.getDownloadProgress=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadProgress(\"window.imraidview\"):\n-1};a.getDownloadStatus=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadStatus(\"window.imraidview\"):-1};a.fireEvent=function(a){700<=getSdkVersionInt()&&(\"fireSkip\"===a?sdkController.fireSkip(\"window.imraidview\"):\"fireComplete\"===a?sdkController.fireComplete(\"window.imraidview\"):\"showEndCard\"===a&&sdkController.showEndCard(\"window.imraidview\"))};a.saveBlob=function(a){700<=getSdkVersionInt()&&sdkController.saveBlob(\"window.imraidview\",a)};a.getBlob=function(a,b){700<=getSdkVersionInt()&&\nsdkController.getBlob(a,b)};a.setCloseEndCardTracker=function(a){700<=getSdkVersionInt()&&sdkController.setCloseEndCardTracker(\"window.imraidview\",a)}})();\n(function(){var a=window.imraid=new InmobiObj,b=window.imraidview;a.getOrientation=b.getOrientation;a.setOrientationProperties=b.setOrientationProperties;a.getOrientationProperties=b.getOrientationProperties;a.saveContentIDMap={};a.saveContent=function(c,e,d){var k=arguments.length,h,f=null;if(3>k){if(\"function\"===typeof arguments[k-1])h=arguments[k-1];else return;f={reason:1}}else a.saveContentIDMap[c]&&(h=arguments[2],f={reason:11,url:arguments[1]});\"function\"!==!h&&(f?(window.imraid.addEventListener(\"saveContent_failed_\"+\nc,h),window.imraid.sendSaveContentResult(\"saveContent_failed_\"+c,\"failed\",JSON.stringify(f))):(a.removeEventListener(\"saveContent_\"+c),a.saveContentIDMap[c]=!0,b.saveContent(c,e,d)))};a.cancelSaveContent=function(a){b.cancelSaveContent(a)};a.asyncPing=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\"URL is required.\",\"asyncPing\"):b.asyncPing(c)};a.disableCloseRegion=b.disableCloseRegion;a.getSdkVersion=b.getSdkVersion;a.log=function(c){\"undefined\"==typeof c?a.broadcastEvent(\"error\",\"message is required.\",\n\"log\"):\"string\"==typeof c?b.log(c):b.log(JSON.stringify(c))};a.getInMobiAIVersion=function(){return\"2.0\"};a.getVendorName=function(){return\"inmobi\"};a.openExternal=function(a,e){mraidview.detectAndBlockFraud(\"imraid.openExternal\")||b.openExternal(a,e)};a.updateToPassbook=function(c){mraidview.detectAndBlockFraud(\"imraid.updateToPassbook\")||(\"string\"!=typeof c?a.broadcastEvent(\"error\",\"Request must specify a valid URL\",\"updateToPassbook\"):b.updateToPassbook(c))};a.postToSocial=function(a,e,d,k){mraidview.detectAndBlockFraud(\"imraid.postToSocial\")||\nb.postToSocial(a,e,d,k)};a.getPlatform=b.getPlatform;a.incentCompleted=b.incentCompleted;a.loadSKStore=b.loadSKStore;a.showSKStore=function(a){mraidview.detectAndBlockFraud(\"imraid.showSKStore\")||b.showSKStore(a)};a.supports=function(a){return b.supports(a)};a.isDeviceMuted=function(){return!imIsObjValid(a.listeners.deviceMuted)?-1:b.isDeviceMuted()};a.isHeadPhonesPlugged=function(){return!imIsObjValid(a.listeners.headphones)?!1:b.isHeadPhonesPlugged()};a.getDeviceVolume=function(){return b.getDeviceVolume()};\na.setDeviceVolume=function(a){b.setDeviceVolume(a)};a.hideStatusBar=function(){b.hideStatusBar()};a.setOpaqueBackground=function(){b.setOpaqueBackground()};a.disableBackButton=b.disableBackButton;a.isBackButtonDisabled=b.isBackButtonDisabled;a.startDownloader=b.startDownloader;a.getDownloadProgress=b.getDownloadProgress;a.getDownloadStatus=b.getDownloadStatus;a.fireEvent=b.fireEvent;a.saveBlob=b.saveBlob;a.getBlob=b.getBlob;a.setCloseEndCardTracker=b.setCloseEndCardTracker})();\n(function(){var a=window._im_imaiview={ios:{}};window.imaiview=a;a.broadcastEvent=function(){for(var a=Array(arguments.length),c=0;c<arguments.length;c++)a[c]=arguments[c];c=a.shift();try{window.mraid.broadcastEvent(c,a)}catch(e){}};a.getPlatform=function(){return\"android\"};a.getPlatformVersion=function(){return sdkController.getPlatformVersion(\"window.imaiview\")};a.log=function(a){sdkController.log(\"window.imaiview\",a)};a.openEmbedded=function(a){sdkController.openEmbedded(\"window.imaiview\",a)};\na.openExternal=function(a,c){600<=getSdkVersionInt()?sdkController.openExternal(\"window.imaiview\",a,c):sdkController.openExternal(\"window.imaiview\",a)};a.ping=function(a,c){sdkController.ping(\"window.imaiview\",a,c)};a.pingInWebView=function(a,c){sdkController.pingInWebView(\"window.imaiview\",a,c)};a.getSdkVersion=function(){try{var a=sdkController.getSdkVersion(\"window.imaiview\");if(\"string\"==typeof a&&null!=a)return a}catch(c){return\"3.7.0\"}};a.onUserInteraction=function(a){if(\"object\"!=typeof a||\nnull==a)sdkController.onUserInteraction(\"window.imaiview\",null);else try{sdkController.onUserInteraction(\"window.imaiview\",JSON.stringify(a))}catch(c){sdkController.onUserInteraction(\"window.imaiview\",null)}};a.fireAdReady=function(){sdkController.fireAdReady(\"window.imaiview\")};a.fireAdFailed=function(){sdkController.fireAdFailed(\"window.imaiview\")};a.broadcastEvent=function(){window.imai.broadcastEvent.apply(window.imai,arguments)}})();\n(function(){var a=window._im_imaiview;window._im_imai=new InmobiObj;window._im_imai.ios=new InmobiObj;var b=window._im_imai;window.imai=window._im_imai;b.matchString=function(a,b){if(\"string\"!=typeof a||null==a||null==b)return-1;var d=-1;try{d=a.indexOf(b)}catch(k){}return d};b.isHttpUrl=function(a){return\"string\"!=typeof a||null==a?!1:0==b.matchString(a,\"http://\")?!0:0==b.matchString(a,\"https://\")?!0:!1};b.appendTapParams=function(a,e,d){if(!imIsObjValid(e)||!imIsObjValid(d))return a;b.isHttpUrl(a)&&\n(a=-1==b.matchString(a,\"?\")?a+(\"?u-tap-o=\"+e+\",\"+d):a+(\"&u-tap-o=\"+e+\",\"+d));return a};b.performAdClick=function(a,e){e=e||event;if(imIsObjValid(a)){var d=a.clickConfig,k=a.landingConfig;if(!imIsObjValid(d)&&!imIsObjValid(k))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var h=null,f=null,g=null,m=null,n=null,l=null,q=null,p=null;if(imIsObjValid(e))try{m=e.changedTouches[0].pageX,n=e.changedTouches[0].pageY}catch(r){n=\nm=0}imIsObjValid(k)?imIsObjValid(d)?(l=k.url,q=k.fallbackUrl,p=k.urlType,h=d.url,f=d.pingWV,g=d.fr):(l=k.url,p=k.urlType):(l=d.url,p=d.urlType);d=b.getPlatform();try{if(\"boolean\"!=typeof g&&\"number\"!=typeof g||null==g)g=!0;if(0>g||1<g)g=!0;if(\"boolean\"!=typeof f&&\"number\"!=typeof f||null==f)f=!0;if(0>f||1<f)f=!0;if(\"number\"!=typeof p||null==p)p=0;h=b.appendTapParams(h,m,n);imIsObjValid(h)?!0==f?b.pingInWebView(h,g):b.ping(h,g):b.log(\"clickurl provided is null.\");if(imIsObjValid(l))switch(imIsObjValid(h)||\n(l=b.appendTapParams(l,m,n)),p){case 1:b.openEmbedded(l);break;case 2:\"ios\"==d?b.ios.openItunesProductView(l):this.broadcastEvent(\"error\",\"Cannot process openItunesProductView for os\"+d);break;default:b.openExternal(l,q)}else b.log(\"Landing url provided is null.\")}catch(s){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.performActionClick=function(a,e){e=e||event;if(imIsObjValid(a)){var d=a.clickConfig,k=a.landingConfig;\nif(!imIsObjValid(d)&&!imIsObjValid(k))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var h=null,f=null,g=null,m=null,n=null;if(imIsObjValid(e))try{m=e.changedTouches[0].pageX,n=e.changedTouches[0].pageY}catch(l){n=m=0}imIsObjValid(d)&&(h=d.url,f=d.pingWV,g=d.fr);try{if(\"boolean\"!=typeof g&&\"number\"!=typeof g||null==g)g=!0;if(0>g||1<g)g=!0;if(\"boolean\"!=typeof f&&\"number\"!=typeof f||null==f)f=\n!0;if(0>f||1<f)f=!0;h=b.appendTapParams(h,m,n);imIsObjValid(h)?!0==f?b.pingInWebView(h,g):b.ping(h,g):b.log(\"clickurl provided is null.\");b.onUserInteraction(k)}catch(q){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.getVersion=function(){return\"1.0\"};b.getPlatform=a.getPlatform;b.getPlatformVersion=a.getPlatformVersion;b.log=a.log;b.openEmbedded=function(b){mraidview.detectAndBlockFraud(\"imai.openEmbedded\")||a.openEmbedded(b)};\nb.openExternal=function(b,e){mraidview.detectAndBlockFraud(\"imai.openExternal\")||a.openExternal(b,e)};b.ping=a.ping;b.pingInWebView=a.pingInWebView;b.onUserInteraction=a.onUserInteraction;b.getSdkVersion=a.getSdkVersion;b.loadSKStore=a.loadSKStore;b.showSKStore=function(b){mraidview.detectAndBlockFraud(\"imai.showSKStore\")||a.showSKStore(b)};b.ios.openItunesProductView=function(b){mraidview.detectAndBlockFraud(\"imai.ios.openItunesProductView\")||a.ios.openItunesProductView(b)};b.fireAdReady=a.fireAdReady;\nb.fireAdFailed=a.fireAdFailed})();";
        }
        return c;
    }

    /* renamed from: a */
    public final void mo34559a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        String str12 = str9;
        C10787i iVar = this.f32754i;
        Context containerContext = getContainerContext();
        int a = C10777a.m35344a(containerContext);
        GregorianCalendar b = C10777a.m35348b(str3);
        if (b != null) {
            StringBuilder sb = new StringBuilder("Event start: ");
            sb.append(b.get(1));
            String str13 = "-";
            sb.append(str13);
            sb.append(b.get(2));
            sb.append(str13);
            sb.append(b.get(5));
            GregorianCalendar b2 = C10777a.m35348b(str4);
            if (b2 != null) {
                StringBuilder sb2 = new StringBuilder("Event end: ");
                sb2.append(b2.get(1));
                sb2.append(str13);
                sb2.append(b2.get(2));
                sb2.append(str13);
                sb2.append(b2.get(5));
                String str14 = str2;
                Intent putExtra = new Intent("android.intent.action.INSERT").setData(Events.CONTENT_URI).putExtra("calendar_id", str2).putExtra("beginTime", b.getTimeInMillis()).putExtra("endTime", b2.getTimeInMillis()).putExtra("allDay", false).putExtra("title", str6).putExtra("eventLocation", str5).putExtra(Repo.COLUMN_DESCRIPTION, str7);
                String str15 = "availability";
                if (str12.equals("transparent")) {
                    putExtra.putExtra(str15, 1);
                } else if (str12.equals("opaque")) {
                    putExtra.putExtra(str15, 0);
                }
                String a2 = C10787i.m35362a(str10);
                if (a2.length() != 0) {
                    putExtra.putExtra("rrule", a2);
                }
                C107881 r2 = new C10719a(containerContext, a, str8, str11, str3, str) {

                    /* renamed from: a */
                    final /* synthetic */ Context f32967a;

                    /* renamed from: b */
                    final /* synthetic */ int f32968b;

                    /* renamed from: c */
                    final /* synthetic */ String f32969c;

                    /* renamed from: d */
                    final /* synthetic */ String f32970d;

                    /* renamed from: e */
                    final /* synthetic */ String f32971e;

                    /* renamed from: f */
                    final /* synthetic */ String f32972f;

                    {
                        this.f32967a = r2;
                        this.f32968b = r3;
                        this.f32969c = r4;
                        this.f32970d = r5;
                        this.f32971e = r6;
                        this.f32972f = r7;
                    }

                    /* renamed from: a */
                    public final void mo34552a() {
                        int i;
                        String str = "createCalendarEvent";
                        String str2 = "Reminder format is incorrect. Reminder can be set only before the event starts";
                        C10787i.f32964b;
                        if (this.f32968b == C10777a.m35344a(this.f32967a)) {
                            C10787i.f32964b;
                            return;
                        }
                        ContentValues contentValues = new ContentValues();
                        String str3 = this.f32969c;
                        char c = 65535;
                        int hashCode = str3.hashCode();
                        if (hashCode != -1320822226) {
                            if (hashCode != -804109473) {
                                if (hashCode == 476588369 && str3.equals("cancelled")) {
                                    c = 2;
                                }
                            } else if (str3.equals("confirmed")) {
                                c = 1;
                            }
                        } else if (str3.equals("tentative")) {
                            c = 0;
                        }
                        String str4 = "eventStatus";
                        if (c == 0) {
                            contentValues.put(str4, Integer.valueOf(0));
                        } else if (c == 1) {
                            contentValues.put(str4, Integer.valueOf(1));
                        } else if (c == 2) {
                            contentValues.put(str4, Integer.valueOf(2));
                        }
                        ContentResolver contentResolver = this.f32967a.getContentResolver();
                        contentResolver.update(ContentUris.withAppendedId(Events.CONTENT_URI, (long) C10777a.m35344a(this.f32967a)), contentValues, null, null);
                        String str5 = this.f32970d;
                        if (str5 != null && !"".equals(str5)) {
                            try {
                                if (this.f32970d.startsWith("+")) {
                                    i = Integer.parseInt(this.f32970d.substring(1)) / 60000;
                                } else {
                                    i = Integer.parseInt(this.f32970d) / 60000;
                                }
                            } catch (NumberFormatException e) {
                                GregorianCalendar b = C10777a.m35348b(this.f32970d);
                                if (b == null) {
                                    C10787i.f32964b;
                                    new StringBuilder("Invalid reminder date provided. date string: ").append(this.f32970d);
                                    return;
                                }
                                i = ((int) (b.getTimeInMillis() - C10777a.m35348b(this.f32971e).getTimeInMillis())) / 60000;
                                if (i > 0) {
                                    C10787i.this.f32965a.mo34563b(this.f32972f, str2, str);
                                    return;
                                }
                            }
                            int i2 = -i;
                            Uri uri = Reminders.CONTENT_URI;
                            StringBuilder sb = new StringBuilder();
                            sb.append(C10777a.m35344a(this.f32967a));
                            contentResolver.delete(uri, "event_id=?", new String[]{sb.toString()});
                            if (i2 < 0) {
                                C10787i.this.f32965a.mo34563b(this.f32972f, str2, str);
                                return;
                            }
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("event_id", Integer.valueOf(C10777a.m35344a(this.f32967a)));
                            contentValues2.put("method", Integer.valueOf(1));
                            contentValues2.put("minutes", Integer.valueOf(i2));
                            contentResolver.insert(Reminders.CONTENT_URI, contentValues2);
                        }
                    }
                };
                int a3 = InMobiAdActivity.m35176a(putExtra, (C10719a) r2);
                Intent intent = new Intent(containerContext, InMobiAdActivity.class);
                intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 103);
                intent.putExtra("id", a3);
                C10619a.m34834a(containerContext, intent);
            }
        }
    }

    /* renamed from: d */
    public static void m35202d() {
    }

    /* renamed from: a */
    public final void mo33678a() {
        this.f32730P = false;
        try {
            getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException e) {
        } catch (InvocationTargetException e2) {
        }
    }

    @android.annotation.TargetApi(16)
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo34569e(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1886160473: goto L_0x0046;
                case -1647691422: goto L_0x003c;
                case -178324674: goto L_0x0032;
                case 1509574865: goto L_0x0028;
                case 1642189884: goto L_0x001e;
                case 1772979069: goto L_0x0014;
                case 1921345160: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0050
        L_0x000a:
            java.lang.String r0 = "postToSocial"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0009
            r6 = 1
            goto L_0x0051
        L_0x0014:
            java.lang.String r0 = "redirectFraudDetection"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0009
            r6 = 0
            goto L_0x0051
        L_0x001e:
            java.lang.String r0 = "saveContent"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0009
            r6 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r0 = "html5video"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0009
            r6 = 5
            goto L_0x0051
        L_0x0032:
            java.lang.String r0 = "calendar"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0009
            r6 = 6
            goto L_0x0051
        L_0x003c:
            java.lang.String r0 = "inlineVideo"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0009
            r6 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r0 = "playVideo"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0009
            r6 = 2
            goto L_0x0051
        L_0x0050:
            r6 = -1
        L_0x0051:
            switch(r6) {
                case 0: goto L_0x0096;
                case 1: goto L_0x0095;
                case 2: goto L_0x0095;
                case 3: goto L_0x0095;
                case 4: goto L_0x008b;
                case 5: goto L_0x008b;
                case 6: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            return r2
        L_0x0055:
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.VIEW"
            r6.<init>(r0)
            java.lang.String r0 = "vnd.android.cursor.item/event"
            r6.setType(r0)
            android.content.Context r0 = r5.getContainerContext()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r3 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r6 = r0.resolveActivity(r6, r3)
            android.content.Context r0 = com.inmobi.commons.p217a.C10619a.m34839b()
            java.lang.String r3 = "android.permission.WRITE_CALENDAR"
            boolean r0 = com.inmobi.commons.p217a.C10619a.m34842b(r0, r3)
            android.content.Context r3 = com.inmobi.commons.p217a.C10619a.m34839b()
            java.lang.String r4 = "android.permission.READ_CALENDAR"
            boolean r3 = com.inmobi.commons.p217a.C10619a.m34842b(r3, r4)
            if (r6 == 0) goto L_0x008a
            if (r0 == 0) goto L_0x008a
            if (r3 == 0) goto L_0x008a
            return r1
        L_0x008a:
            return r2
        L_0x008b:
            boolean r6 = r5.f32720F
            if (r6 == 0) goto L_0x0094
            boolean r6 = r5.f32730P
            if (r6 == 0) goto L_0x0094
            return r1
        L_0x0094:
            return r2
        L_0x0095:
            return r1
        L_0x0096:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.rendering.RenderView.mo34569e(java.lang.String):boolean");
    }

    /* renamed from: e */
    public final boolean mo34568e() {
        C10487i renderingConfig = getRenderingConfig();
        if (renderingConfig == null) {
            return false;
        }
        if (!renderingConfig.f31949g || this.f32740ac || this.f32741ad) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final int getDownloadProgress() {
        getReferenceContainer().getApkDownloader();
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final int getDownloadStatus() {
        getReferenceContainer().getApkDownloader();
        return -2;
    }

    /* renamed from: f */
    static void m35207f() {
    }

    /* renamed from: g */
    static void m35208g() {
    }

    /* renamed from: a */
    public final void mo34557a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        sb.append(str3);
        sb.append(");");
        mo34556a(str, sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public final void setCloseEndCardTracker(String str) {
        AdContainer referenceContainer = getReferenceContainer();
        if (referenceContainer instanceof C10445bd) {
            NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) ((C10445bd) referenceContainer).getVideoContainerView();
            if (nativeVideoWrapper != null) {
                C10449be beVar = (C10449be) nativeVideoWrapper.getVideoView().getTag();
                if (beVar != null && beVar.mo34158b() != null && beVar.mo34158b().mo34202f() != null) {
                    beVar.mo34158b().mo34202f().mo34186a(new NativeTracker(str, 0, TrackerEventType.TRACKER_EVENT_TYPE_END_CARD_CLOSE, null));
                }
            }
        }
    }
}
