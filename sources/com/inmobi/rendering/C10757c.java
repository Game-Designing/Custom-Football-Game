package com.inmobi.rendering;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.plus.PlusShare.Builder;
import com.inmobi.ads.AdContainer;
import com.inmobi.ads.AdContainer.RenderingProperties;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10380ah;
import com.inmobi.ads.C10400ak;
import com.inmobi.ads.C10461bm;
import com.inmobi.ads.C10466br;
import com.inmobi.ads.cache.AssetStore;
import com.inmobi.ads.cache.C10515b;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.configs.C10652h;
import com.inmobi.commons.core.network.C10672a;
import com.inmobi.commons.core.network.C10672a.C10674a;
import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.utilities.C10702f;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.p207a.C10299n;
import com.inmobi.rendering.InMobiAdActivity.C10720b;
import com.inmobi.rendering.mraid.C10778b;
import com.inmobi.rendering.mraid.C10779c;
import com.inmobi.rendering.mraid.C10785g;
import com.inmobi.rendering.mraid.C10786h;
import com.inmobi.rendering.mraid.C10787i;
import com.inmobi.rendering.mraid.MediaRenderView;
import com.inmobi.rendering.mraid.MraidMediaProcessor;
import com.inmobi.rendering.mraid.MraidMediaProcessor.C10776a;
import com.inmobi.rendering.mraid.MraidMediaProcessor.HeadphonesPluggedChangeReceiver;
import com.inmobi.rendering.mraid.MraidMediaProcessor.RingerModeChangeReceiver;
import com.mopub.common.AdType;
import com.mopub.common.Constants;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

/* renamed from: com.inmobi.rendering.c */
/* compiled from: JavaScriptBridge */
public class C10757c {

    /* renamed from: a */
    static final String[] f32845a = {"tel", "sms", "calendar", "inlineVideo"};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f32846b = C10757c.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RenderView f32847c;

    /* renamed from: d */
    private RenderingProperties f32848d;

    /* renamed from: e */
    private C10785g f32849e;

    @TargetApi(16)
    /* renamed from: com.inmobi.rendering.c$a */
    /* compiled from: JavaScriptBridge */
    private static class C10770a implements OnGlobalLayoutListener {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f32889a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f32890b;

        /* renamed from: c */
        private View f32891c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Boolean f32892d = Boolean.valueOf(false);

        C10770a(View view) {
            this.f32891c = view;
        }

        public final void onGlobalLayout() {
            try {
                this.f32889a = C10692c.m35106b(this.f32891c.getWidth());
                this.f32890b = C10692c.m35106b(this.f32891c.getHeight());
                if (VERSION.SDK_INT >= 16) {
                    this.f32891c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    this.f32891c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                synchronized (this.f32892d) {
                    this.f32892d.notify();
                }
            } catch (Exception e) {
                C10757c.f32846b;
                new StringBuilder("SDK encountered unexpected error in JavaScriptBridge$1.onGlobalLayout(); ").append(e.getMessage());
            }
        }
    }

    C10757c(RenderView renderView, RenderingProperties renderingProperties) {
        this.f32847c = renderView;
        this.f32848d = renderingProperties;
    }

    @JavascriptInterface
    public void open(final String str, final String str2) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            if (!renderView.mo34568e()) {
                this.f32847c.mo34565c("open");
            } else {
                new Handler(this.f32847c.getContainerContext().getMainLooper()).post(new Runnable() {
                    public final void run() {
                        String str = "open";
                        try {
                            C10757c.this.f32847c.mo34566c(str, str, str2);
                        } catch (Exception e) {
                            C10757c.this.f32847c.mo34563b(str, "Unexpected error", str);
                            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Failed to open URL; SDK encountered unexpected error");
                            C10757c.f32846b;
                            new StringBuilder("SDK encountered unexpected error in handling open() request from creative; ").append(e.getMessage());
                        }
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void openEmbedded(final String str, final String str2) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            if (!renderView.mo34568e()) {
                this.f32847c.mo34565c("openEmbedded");
            } else {
                new Handler(this.f32847c.getContainerContext().getMainLooper()).post(new Runnable() {
                    public final void run() {
                        String str = "openEmbedded";
                        try {
                            C10757c.this.f32847c.mo34566c(str, str, str2);
                        } catch (Exception e) {
                            C10757c.this.f32847c.mo34563b(str, "Unexpected error", str);
                            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Failed to open URL; SDK encountered unexpected error");
                            C10757c.f32846b;
                            new StringBuilder("SDK encountered unexpected error in handling openEmbedded() request from creative; ").append(e.getMessage());
                        }
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void ping(String str, String str2, boolean z) {
        if (this.f32847c != null) {
            String str3 = "ping";
            if (str2 == null || str2.trim().length() == 0 || !URLUtil.isValidUrl(str2)) {
                RenderView renderView = this.f32847c;
                StringBuilder sb = new StringBuilder("Invalid URL:");
                sb.append(str2);
                renderView.mo34563b(str, sb.toString(), str3);
                return;
            }
            StringBuilder sb2 = new StringBuilder("JavaScript called ping() URL: >>> ");
            sb2.append(str2);
            sb2.append(" <<<");
            try {
                new Thread(str2, z) {

                    /* renamed from: a */
                    final /* synthetic */ String f32815a;

                    /* renamed from: b */
                    final /* synthetic */ boolean f32816b;

                    {
                        this.f32815a = r2;
                        this.f32816b = r3;
                    }

                    public final void run() {
                        try {
                            C10652h hVar = new C10652h();
                            C10641b.m34915a().mo34452a((C10639a) hVar, (C10644c) null);
                            if (!hVar.f32477g) {
                                C10736a aVar = new C10736a(this.f32815a, this.f32816b, false, C10738c.f32811j.f31928a + 1);
                                C10738c.f32802a;
                                StringBuilder sb = new StringBuilder("Received click (");
                                sb.append(aVar.f32792b);
                                sb.append(") for pinging over HTTP");
                                C10738c.m35285a(C10738c.this, aVar);
                            }
                        } catch (Exception e) {
                            C10738c.f32802a;
                            new StringBuilder("SDK encountered unexpected error in pinging click; ").append(e.getMessage());
                        }
                    }
                }.start();
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", str3);
                Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
                new StringBuilder("SDK encountered unexpected error in handling ping() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void pingInWebView(String str, String str2, boolean z) {
        if (this.f32847c != null) {
            String str3 = "pingInWebView";
            if (str2 == null || str2.trim().length() == 0 || !URLUtil.isValidUrl(str2)) {
                RenderView renderView = this.f32847c;
                StringBuilder sb = new StringBuilder("Invalid URL:");
                sb.append(str2);
                renderView.mo34563b(str, sb.toString(), str3);
                return;
            }
            StringBuilder sb2 = new StringBuilder("JavaScript called pingInWebView() URL: >>> ");
            sb2.append(str2);
            sb2.append(" <<<");
            try {
                new Thread(str2, z) {

                    /* renamed from: a */
                    final /* synthetic */ String f32822a;

                    /* renamed from: b */
                    final /* synthetic */ boolean f32823b;

                    {
                        this.f32822a = r2;
                        this.f32823b = r3;
                    }

                    public final void run() {
                        try {
                            C10652h hVar = new C10652h();
                            C10641b.m34915a().mo34452a((C10639a) hVar, (C10644c) null);
                            if (!hVar.f32477g) {
                                C10736a aVar = new C10736a(this.f32822a, this.f32823b, true, C10738c.f32811j.f31928a + 1);
                                C10738c.f32802a;
                                StringBuilder sb = new StringBuilder("Received click (");
                                sb.append(aVar.f32792b);
                                sb.append(") for pinging in WebView");
                                C10738c.m35285a(C10738c.this, aVar);
                            }
                        } catch (Exception e) {
                            C10738c.f32802a;
                            new StringBuilder("SDK encountered unexpected error in pinging click over WebView; ").append(e.getMessage());
                        }
                    }
                }.start();
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", str3);
                Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
                new StringBuilder("SDK encountered unexpected error in handling pingInWebView() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void log(String str, String str2) {
    }

    @JavascriptInterface
    public String getPlatformVersion(String str) {
        return Integer.toString(VERSION.SDK_INT);
    }

    @JavascriptInterface
    public void fireAdReady(String str) {
        try {
            this.f32847c.getListener().mo34056w();
        } catch (Exception e) {
            this.f32847c.mo34563b(str, "Unexpected error", "fireAdReady");
            new StringBuilder("SDK encountered unexpected error in handling fireAdReady() signal from creative; ").append(e.getMessage());
        }
    }

    @JavascriptInterface
    public void fireAdFailed(String str) {
        try {
            this.f32847c.getListener().mo34057y();
        } catch (Exception e) {
            this.f32847c.mo34563b(str, "Unexpected error", "fireAdFailed");
            new StringBuilder("SDK encountered unexpected error in handling fireAdFailed() signal from creative; ").append(e.getMessage());
        }
    }

    @JavascriptInterface
    public String getDefaultPosition(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return new JSONObject().toString();
        }
        synchronized (renderView.getDefaultPositionMonitor()) {
            this.f32847c.setDefaultPositionLock();
            new Handler(this.f32847c.getContainerContext().getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        C10757c.this.f32847c.setDefaultPosition();
                    } catch (Exception e) {
                        C10757c.f32846b;
                        new StringBuilder("SDK encountered unexpected error in getting/setting default position; ").append(e.getMessage());
                    }
                }
            });
            while (this.f32847c.f32756k) {
                try {
                    this.f32847c.getDefaultPositionMonitor().wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return this.f32847c.getDefaultPosition();
    }

    @JavascriptInterface
    public String getCurrentPosition(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return "";
        }
        synchronized (renderView.getCurrentPositionMonitor()) {
            this.f32847c.setCurrentPositionLock();
            new Handler(this.f32847c.getContainerContext().getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        C10757c.this.f32847c.setCurrentPosition();
                    } catch (Exception e) {
                        C10757c.f32846b;
                        new StringBuilder("SDK encountered unexpected error in getting/setting current position; ").append(e.getMessage());
                    }
                }
            });
            while (this.f32847c.f32757l) {
                try {
                    this.f32847c.getCurrentPositionMonitor().wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return this.f32847c.getCurrentPosition();
    }

    @JavascriptInterface
    public void setExpandProperties(String str, String str2) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            if (!"Expanded".equals(renderView.getState())) {
                try {
                    this.f32847c.setExpandProperties(C10778b.m35349a(str2));
                } catch (Exception e) {
                    this.f32847c.mo34563b(str, "Unexpected error", "setExpandProperties");
                    new StringBuilder("SDK encountered unexpected error in setExpandProperties(); ").append(e.getMessage());
                }
            }
        }
    }

    @JavascriptInterface
    public String getExpandProperties(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return "";
        }
        return renderView.getExpandProperties().f32931c;
    }

    @JavascriptInterface
    public void expand(final String str, final String str2) {
        if (this.f32848d.f31249a != PlacementType.PLACEMENT_TYPE_FULLSCREEN) {
            RenderView renderView = this.f32847c;
            if (renderView != null) {
                String str3 = "expand";
                if (!renderView.mo34568e()) {
                    this.f32847c.mo34565c(str3);
                    return;
                }
                RenderView renderView2 = this.f32847c;
                if (!renderView2.f32760o) {
                    renderView2.mo34563b(str, "Creative is not visible. Ignoring request.", str3);
                } else if (str2 == null || str2.length() == 0 || str2.startsWith(Constants.HTTP)) {
                    new Handler(this.f32847c.getContainerContext().getMainLooper()).post(new Runnable() {
                        public final void run() {
                            int i;
                            String str = "expand";
                            try {
                                RenderView a = C10757c.this.f32847c;
                                String str2 = str;
                                String str3 = str2;
                                if ("Default".equals(a.f32749d) || "Resized".equals(a.f32749d)) {
                                    a.f32765t = true;
                                    C10779c cVar = a.f32751f;
                                    if (cVar.f32938c == null) {
                                        cVar.f32938c = (ViewGroup) cVar.f32936a.getParent();
                                        cVar.f32939d = cVar.f32938c.indexOfChild(cVar.f32936a);
                                    }
                                    if (cVar.f32936a != null) {
                                        C10778b expandProperties = cVar.f32936a.getExpandProperties();
                                        cVar.f32937b = URLUtil.isValidUrl(str3);
                                        if (cVar.f32937b) {
                                            RenderView renderView = new RenderView(cVar.f32936a.getContainerContext(), new RenderingProperties(PlacementType.PLACEMENT_TYPE_INLINE), null, cVar.f32936a.getImpressionId());
                                            renderView.mo34554a(cVar.f32936a.getListener(), cVar.f32936a.getAdConfig());
                                            renderView.setOriginalRenderView(cVar.f32936a);
                                            renderView.loadUrl(str3);
                                            renderView.setPlacementId(cVar.f32936a.getPlacementId());
                                            renderView.setAllowAutoRedirection(cVar.f32936a.getAllowAutoRedirection());
                                            renderView.setCreativeId(cVar.f32936a.getCreativeId());
                                            i = InMobiAdActivity.m35177a((AdContainer) renderView);
                                            if (expandProperties != null) {
                                                renderView.setUseCustomClose(cVar.f32936a.f32758m);
                                            }
                                        } else {
                                            FrameLayout frameLayout = new FrameLayout(cVar.f32936a.getContainerContext());
                                            LayoutParams layoutParams = new LayoutParams(cVar.f32936a.getWidth(), cVar.f32936a.getHeight());
                                            frameLayout.setId(65535);
                                            cVar.f32938c.addView(frameLayout, cVar.f32939d, layoutParams);
                                            cVar.f32938c.removeView(cVar.f32936a);
                                            i = InMobiAdActivity.m35177a((AdContainer) cVar.f32936a);
                                        }
                                        cVar.f32936a.getListener().mo34051G();
                                        Intent intent = new Intent(cVar.f32936a.getContainerContext(), InMobiAdActivity.class);
                                        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
                                        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", i);
                                        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 200);
                                        C10619a.m34834a(cVar.f32936a.getContainerContext(), intent);
                                    }
                                    a.requestLayout();
                                    a.invalidate();
                                    a.f32759n = true;
                                    a.setFocusable(true);
                                    a.setFocusableInTouchMode(true);
                                    a.requestFocus();
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("command", str);
                                    hashMap.put("scheme", C10466br.m34254a(str2));
                                    a.f32748c.mo34054b("CreativeInvokedAction", hashMap);
                                    return;
                                }
                                new StringBuilder("Render view state must be either DEFAULT or RESIZED to admit the expand request. Current state:").append(a.f32749d);
                            } catch (Exception e) {
                                C10757c.this.f32847c.mo34563b(str, "Unexpected error", str);
                                Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Failed to expand ad; SDK encountered an unexpected error");
                                C10757c.f32846b;
                                new StringBuilder("SDK encountered unexpected error in handling expand() request; ").append(e.getMessage());
                            }
                        }
                    });
                } else {
                    this.f32847c.mo34563b(str, "Invalid URL", str3);
                }
            }
        }
    }

    @JavascriptInterface
    public void setResizeProperties(String str, String str2) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            C10786h a = C10786h.m35359a(str2, renderView.getResizeProperties());
            if (a == null) {
                this.f32847c.mo34563b(str, "setResizeProperties", "All mandatory fields are not present");
            }
            this.f32847c.setResizeProperties(a);
        }
    }

    @JavascriptInterface
    public String getResizeProperties(String str) {
        RenderView renderView = this.f32847c;
        String str2 = "";
        if (renderView == null) {
            return str2;
        }
        C10786h resizeProperties = renderView.getResizeProperties();
        return resizeProperties == null ? str2 : resizeProperties.mo34788a();
    }

    @JavascriptInterface
    public void resize(final String str) {
        if (this.f32848d.f31249a != PlacementType.PLACEMENT_TYPE_FULLSCREEN) {
            RenderView renderView = this.f32847c;
            if (renderView != null) {
                if (renderView.f32760o) {
                    new Handler(renderView.getContainerContext().getMainLooper()).post(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
                            if (r4.equals(r1.f32749d) != false) goto L_0x001e;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                                r6 = this;
                                java.lang.String r0 = "resize"
                                com.inmobi.rendering.c r1 = com.inmobi.rendering.C10757c.this     // Catch:{ Exception -> 0x0063 }
                                com.inmobi.rendering.RenderView r1 = r1.f32847c     // Catch:{ Exception -> 0x0063 }
                                java.lang.String r2 = r4     // Catch:{ Exception -> 0x0063 }
                                java.lang.String r3 = "Default"
                                java.lang.String r4 = r1.f32749d     // Catch:{ Exception -> 0x0063 }
                                boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0063 }
                                java.lang.String r4 = "Resized"
                                if (r3 != 0) goto L_0x001e
                                java.lang.String r3 = r1.f32749d     // Catch:{ Exception -> 0x0063 }
                                boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x0063 }
                                if (r3 == 0) goto L_0x0062
                            L_0x001e:
                                com.inmobi.rendering.mraid.h r3 = r1.getResizeProperties()     // Catch:{ Exception -> 0x0063 }
                                if (r3 == 0) goto L_0x0062
                                r3 = 1
                                r1.f32765t = r3     // Catch:{ Exception -> 0x0063 }
                                com.inmobi.rendering.mraid.f r5 = r1.f32752g     // Catch:{ Exception -> 0x0063 }
                                r5.mo34786a()     // Catch:{ Exception -> 0x0063 }
                                r1.requestLayout()     // Catch:{ Exception -> 0x0063 }
                                r1.invalidate()     // Catch:{ Exception -> 0x0063 }
                                r1.f32759n = r3     // Catch:{ Exception -> 0x0063 }
                                r1.setFocusable(r3)     // Catch:{ Exception -> 0x0063 }
                                r1.setFocusableInTouchMode(r3)     // Catch:{ Exception -> 0x0063 }
                                r1.requestFocus()     // Catch:{ Exception -> 0x0063 }
                                r1.setAndUpdateViewState(r4)     // Catch:{ Exception -> 0x0063 }
                                com.inmobi.rendering.RenderView$a r3 = r1.f32748c     // Catch:{ Exception -> 0x0063 }
                                r3.mo33984c(r1)     // Catch:{ Exception -> 0x0063 }
                                r3 = 0
                                r1.f32765t = r3     // Catch:{ Exception -> 0x0063 }
                                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0063 }
                                r3.<init>()     // Catch:{ Exception -> 0x0063 }
                                java.lang.String r4 = "command"
                                r3.put(r4, r0)     // Catch:{ Exception -> 0x0063 }
                                java.lang.String r4 = "scheme"
                                java.lang.String r2 = com.inmobi.ads.C10466br.m34254a(r2)     // Catch:{ Exception -> 0x0063 }
                                r3.put(r4, r2)     // Catch:{ Exception -> 0x0063 }
                                com.inmobi.rendering.RenderView$a r1 = r1.f32748c     // Catch:{ Exception -> 0x0063 }
                                java.lang.String r2 = "CreativeInvokedAction"
                                r1.mo34054b(r2, r3)     // Catch:{ Exception -> 0x0063 }
                            L_0x0062:
                                return
                            L_0x0063:
                                r1 = move-exception
                                com.inmobi.rendering.c r2 = com.inmobi.rendering.C10757c.this
                                com.inmobi.rendering.RenderView r2 = r2.f32847c
                                java.lang.String r3 = r4
                                java.lang.String r4 = "Unexpected error"
                                r2.mo34563b(r3, r4, r0)
                                com.inmobi.commons.core.utilities.Logger$InternalLogLevel r0 = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR
                                java.lang.String r2 = com.inmobi.rendering.C10757c.f32846b
                                java.lang.String r3 = "Could not resize ad; SDK encountered an unexpected error"
                                com.inmobi.commons.core.utilities.Logger.m35065a(r0, r2, r3)
                                com.inmobi.rendering.C10757c.f32846b
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                java.lang.String r2 = "SDK encountered an unexpected error in handling resize() request; "
                                r0.<init>(r2)
                                java.lang.String r1 = r1.getMessage()
                                r0.append(r1)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.rendering.C10757c.C107699.run():void");
                        }
                    });
                    return;
                }
                renderView.mo34563b(str, "Creative is not visible. Ignoring request.", "resize");
            }
        }
    }

    @JavascriptInterface
    public void setOrientationProperties(String str, String str2) {
        this.f32849e = C10785g.m35358a(str2, this.f32847c.getOrientationProperties());
        this.f32847c.setOrientationProperties(this.f32849e);
    }

    @JavascriptInterface
    public String getOrientationProperties(String str) {
        return this.f32849e.f32956d;
    }

    @JavascriptInterface
    public void onOrientationChange(String str) {
    }

    @JavascriptInterface
    public boolean isViewable(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return false;
        }
        return renderView.f32760o;
    }

    @JavascriptInterface
    public void useCustomClose(final String str, final boolean z) {
        new Handler(this.f32847c.getContainerContext().getMainLooper()).post(new Runnable() {
            public final void run() {
                try {
                    C10757c.this.f32847c.mo34564b(z);
                } catch (Exception e) {
                    C10757c.this.f32847c.mo34563b(str, "Unexpected error", "useCustomClose");
                    C10757c.f32846b;
                    new StringBuilder("SDK encountered internal error in handling useCustomClose() request from creative; ").append(e.getMessage());
                }
            }
        });
    }

    @JavascriptInterface
    public void playVideo(final String str, final String str2) {
        if (this.f32847c != null) {
            if (str2 == null || str2.trim().length() == 0 || !str2.startsWith(Constants.HTTP) || (!str2.endsWith("mp4") && !str2.endsWith("avi") && !str2.endsWith("m4v"))) {
                this.f32847c.mo34563b(str, "Null or empty or invalid media playback URL supplied", "playVideo");
                return;
            }
            StringBuilder sb = new StringBuilder("JavaScript called: playVideo (");
            sb.append(str2);
            sb.append(")");
            new Handler(this.f32847c.getContainerContext().getMainLooper()).post(new Runnable() {
                public final void run() {
                    String str = "playVideo";
                    try {
                        RenderView a = C10757c.this.f32847c;
                        String str2 = str;
                        String trim = str2.trim();
                        if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == a.f32750e.f31249a || "Expanded".equals(a.getViewState())) {
                            if (a.f32747b != null) {
                                if (a.f32747b.get() != null) {
                                    a.setAdActiveFlag(true);
                                    MraidMediaProcessor mraidMediaProcessor = a.f32753h;
                                    Activity activity = (Activity) a.f32747b.get();
                                    mraidMediaProcessor.f32911b = new MediaRenderView(activity);
                                    MediaRenderView mediaRenderView = mraidMediaProcessor.f32911b;
                                    mediaRenderView.f32901h = MediaRenderView.m35325a(trim);
                                    mediaRenderView.f32900g = "anonymous";
                                    if (mediaRenderView.f32895b == null) {
                                        mediaRenderView.f32895b = Bitmap.createBitmap(24, 24, Config.ARGB_8888);
                                        mediaRenderView.f32895b = MediaRenderView.m35326b(mediaRenderView.f32901h);
                                    }
                                    ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                    layoutParams.addRule(13);
                                    mraidMediaProcessor.f32911b.setLayoutParams(layoutParams);
                                    RelativeLayout relativeLayout = new RelativeLayout(activity);
                                    relativeLayout.setOnTouchListener(new OnTouchListener() {
                                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                                            return true;
                                        }
                                    });
                                    relativeLayout.setBackgroundColor(CtaButton.BACKGROUND_COLOR);
                                    relativeLayout.addView(mraidMediaProcessor.f32911b);
                                    viewGroup.addView(relativeLayout, new LayoutParams(-1, -1));
                                    mraidMediaProcessor.f32911b.f32896c = relativeLayout;
                                    mraidMediaProcessor.f32911b.requestFocus();
                                    mraidMediaProcessor.f32911b.setOnKeyListener(new OnKeyListener() {
                                        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                                            if (4 != i || keyEvent.getAction() != 0) {
                                                return false;
                                            }
                                            MraidMediaProcessor.this.f32911b.mo34752a();
                                            return true;
                                        }
                                    });
                                    mraidMediaProcessor.f32911b.f32897d = new C10772a() {
                                        /* renamed from: a */
                                        public final void mo34775a(MediaRenderView mediaRenderView) {
                                            MraidMediaProcessor.f32909f;
                                            MraidMediaProcessor.this.f32910a.setAdActiveFlag(false);
                                            ViewGroup viewGroup = mediaRenderView.f32896c;
                                            if (viewGroup != null) {
                                                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                                            }
                                            mediaRenderView.f32896c = null;
                                        }

                                        /* renamed from: a */
                                        public final void mo34774a() {
                                            MraidMediaProcessor.f32909f;
                                        }
                                    };
                                    MediaRenderView mediaRenderView2 = mraidMediaProcessor.f32911b;
                                    mediaRenderView2.setVideoPath(mediaRenderView2.f32901h);
                                    mediaRenderView2.setOnCompletionListener(mediaRenderView2);
                                    mediaRenderView2.setOnPreparedListener(mediaRenderView2);
                                    mediaRenderView2.setOnErrorListener(mediaRenderView2);
                                    if (mediaRenderView2.f32894a == null && VERSION.SDK_INT >= 19) {
                                        mediaRenderView2.f32894a = new CustomMediaController(mediaRenderView2.getContext());
                                        mediaRenderView2.f32894a.setAnchorView(mediaRenderView2);
                                        mediaRenderView2.setMediaController(mediaRenderView2.f32894a);
                                    }
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("command", str);
                                    hashMap.put("scheme", C10466br.m34254a(str2));
                                    a.f32748c.mo34054b("CreativeInvokedAction", hashMap);
                                }
                            }
                            a.mo34563b(str2, "Media playback is  not allowed before it is visible! Ignoring request ...", str);
                        }
                    } catch (Exception e) {
                        C10757c.this.f32847c.mo34563b(str, "Unexpected error", str);
                        Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Error playing video; SDK encountered an unexpected error");
                        C10757c.f32846b;
                        new StringBuilder("SDK encountered unexpected error in handling playVideo() request from creative; ").append(e.getMessage());
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public String getState(String str) {
        return this.f32847c.getState().toLowerCase(Locale.ENGLISH);
    }

    @JavascriptInterface
    public String getScreenSize(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", C10692c.m35104a().f32627a);
            jSONObject.put("height", C10692c.m35104a().f32628b);
        } catch (JSONException e) {
        } catch (Exception e2) {
            this.f32847c.mo34563b(str, "Unexpected error", "getScreenSize");
            new StringBuilder("SDK encountered unexpected error while getting screen dimensions; ").append(e2.getMessage());
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getMaxSize(String str) {
        int b;
        int c;
        JSONObject jSONObject = new JSONObject();
        try {
            Activity fullScreenActivity = this.f32847c.getFullScreenActivity();
            if (fullScreenActivity == null) {
                if (!(this.f32847c.getContainerContext() instanceof Activity)) {
                    return getScreenSize(str);
                }
                fullScreenActivity = (Activity) this.f32847c.getContainerContext();
            }
            FrameLayout frameLayout = (FrameLayout) fullScreenActivity.findViewById(16908290);
            int b2 = C10692c.m35106b(frameLayout.getWidth());
            int b3 = C10692c.m35106b(frameLayout.getHeight());
            if (this.f32847c.getFullScreenActivity() != null && (b2 == 0 || b3 == 0)) {
                C10770a aVar = new C10770a(frameLayout);
                frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
                synchronized (aVar.f32892d) {
                    try {
                        aVar.f32892d.wait();
                    } catch (InterruptedException e) {
                    }
                    b = aVar.f32889a;
                    c = aVar.f32890b;
                }
                int i = b;
                b3 = c;
                b2 = i;
            }
            try {
                jSONObject.put("width", b2);
                jSONObject.put("height", b3);
            } catch (JSONException e2) {
            }
            new StringBuilder("getMaxSize called:").append(jSONObject.toString());
        } catch (Exception e3) {
            this.f32847c.mo34563b(str, "Unexpected error", "getMaxSize");
            new StringBuilder("SDK encountered unexpected error in handling getMaxSize() request from creative; ").append(e3.getMessage());
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void close(final String str) {
        new Handler(this.f32847c.getContainerContext().getMainLooper()).post(new Runnable() {
            public final void run() {
                try {
                    C10757c.this.f32847c.getReferenceContainer().mo33680b();
                } catch (Exception e) {
                    C10757c.this.f32847c.mo34563b(str, "Unexpected error", "close");
                    Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Failed to close ad; SDK encountered an unexpected error");
                    C10757c.f32846b;
                    new StringBuilder("SDK encountered an expected error in handling the close() request from creative; ").append(e.getMessage());
                }
            }
        });
    }

    @JavascriptInterface
    public String getPlacementType(String str) {
        if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == this.f32848d.f31249a) {
            return AdType.INTERSTITIAL;
        }
        return "inline";
    }

    @JavascriptInterface
    public void storePicture(String str, String str2) {
    }

    @JavascriptInterface
    @TargetApi(23)
    public void createCalendarEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        String str12 = str;
        String str13 = str3;
        String str14 = str4;
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            String str15 = "createCalendarEvent";
            if (!renderView.mo34568e()) {
                this.f32847c.mo34565c(str15);
            } else if (this.f32847c.mo34569e("calendar")) {
                if (str13 == null || str3.trim().length() == 0 || str14 == null || str4.trim().length() == 0) {
                    this.f32847c.mo34563b(str12, "Mandatory parameter(s) start and/or end date not supplied", str15);
                    return;
                }
                StringBuilder sb = new StringBuilder("createCalendarEvent called with parameters: \nevent ID: ");
                sb.append(str2);
                sb.append("; startDate: ");
                sb.append(str13);
                sb.append("; endDate: ");
                sb.append(str14);
                sb.append("; location: ");
                sb.append(str5);
                sb.append("; description: ");
                sb.append(str6);
                sb.append("; summary: ");
                sb.append(str7);
                sb.append("; status: ");
                sb.append(str8);
                sb.append("; transparency: ");
                sb.append(str9);
                sb.append("; recurrence: ");
                sb.append(str10);
                sb.append("; reminder: ");
                sb.append(str11);
                Context b = C10619a.m34839b();
                if (b != null) {
                    if (VERSION.SDK_INT >= 23) {
                        String str16 = "android.permission.WRITE_CALENDAR";
                        String str17 = "android.permission.READ_CALENDAR";
                        if (!(b.checkSelfPermission(str16) == 0 && b.checkSelfPermission(str17) == 0)) {
                            String[] strArr = {str16, str17};
                            final String str18 = str;
                            final String str19 = str2;
                            final String str20 = str3;
                            final String str21 = str4;
                            final String str22 = str5;
                            final String str23 = str6;
                            final String str24 = str7;
                            final String str25 = str8;
                            final String str26 = str9;
                            final String str27 = str10;
                            final String str28 = str11;
                            C107622 r1 = new C10720b() {
                                /* renamed from: a */
                                public final void mo34553a(int[] iArr) {
                                    String str = "createCalendarEvent";
                                    if (iArr.length == 2 && iArr[0] == 0 && iArr[1] == 0) {
                                        try {
                                            C10757c.this.f32847c.mo34559a(str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28);
                                        } catch (Exception e) {
                                            C10757c.this.f32847c.mo34563b(str18, "Unexpected error", str);
                                            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not create calendar event; SDK encountered unexpected error");
                                            C10757c.f32846b;
                                            new StringBuilder("SDK encountered unexpected error in handling createCalendarEvent() request from creative; ").append(e.getMessage());
                                        }
                                    } else {
                                        C10757c.this.f32847c.mo34563b(str18, "Permission denied by user.", str);
                                    }
                                }
                            };
                            InMobiAdActivity.m35183a(strArr, (C10720b) r1);
                            return;
                        }
                    }
                    try {
                        this.f32847c.mo34559a(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
                    } catch (Exception e) {
                        this.f32847c.mo34563b(str12, "Unexpected error", str15);
                        Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not create calendar event; SDK encountered unexpected error");
                        new StringBuilder("SDK encountered unexpected error in handling createCalendarEvent() request from creative; ").append(e.getMessage());
                    }
                }
            }
        }
    }

    @JavascriptInterface
    public void postToSocial(String str, int i, String str2, String str3, String str4) {
        String str5 = Constants.HTTP;
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            String str6 = "postToSocial";
            if (!renderView.mo34568e()) {
                this.f32847c.mo34565c(str6);
                return;
            }
            StringBuilder sb = new StringBuilder("postToSocial called with parameters: socialType: ");
            sb.append(i);
            sb.append("; text: ");
            sb.append(str2);
            sb.append("; link: ");
            sb.append(str3);
            sb.append("; image URL: ");
            sb.append(str4);
            try {
                RenderView renderView2 = this.f32847c;
                if (renderView2.mo34569e(str6)) {
                    C10787i iVar = renderView2.f32754i;
                    Context containerContext = renderView2.getContainerContext();
                    if (str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0 || !str3.startsWith(str5) || str4 == null || str4.length() == 0 || !str4.startsWith(str5) || !str4.endsWith(".jpg")) {
                        iVar.f32965a.mo34563b(str, "Attempting to share with null/empty/invalid parameters", str6);
                        return;
                    }
                    Intent intent = null;
                    if (i != 1) {
                        String str7 = "text/plain";
                        String str8 = " ";
                        if (i != 2) {
                            if (i != 3) {
                                iVar.f32965a.mo34563b(str, "Unsupported type of social network", str6);
                                return;
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str2);
                            sb2.append(str8);
                            sb2.append(str3);
                            sb2.append(str8);
                            sb2.append(str4);
                            String sb3 = sb2.toString();
                            Intent intent2 = new Intent();
                            intent2.setType(str7);
                            intent2.setPackage("com.twitter.android");
                            intent2.putExtra("android.intent.extra.TEXT", sb3);
                            intent = intent2;
                        } else if (C10702f.m35151a("ads") && C10787i.m35364a()) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str2);
                            sb4.append(str8);
                            sb4.append(str3);
                            sb4.append(str8);
                            sb4.append(str4);
                            intent = new Builder(containerContext).setType(str7).setText(sb4.toString()).setContentUrl(Uri.parse(str4)).getIntent();
                        }
                    }
                    if (intent != null) {
                        try {
                            C10619a.m34834a(containerContext, intent);
                            return;
                        } catch (ActivityNotFoundException e) {
                        }
                    }
                    C10787i.m35363a(containerContext, i, str2, str3, str4);
                }
            } catch (Exception e2) {
                this.f32847c.mo34563b(str, "Unexpected error", str6);
                Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not post to social network; SDK encountered an unexpected error");
                new StringBuilder("SDK encountered an unexpected error in handling the postToSocial() request from creative; ").append(e2.getMessage());
            }
        }
    }

    @JavascriptInterface
    public String supports(String str, String str2) {
        if (Arrays.asList(f32845a).contains(str2) || this.f32847c.mo34569e(str2)) {
            return String.valueOf(this.f32847c.mo34569e(str2));
        }
        return AdultContentAnalytics.UNLOCK;
    }

    @JavascriptInterface
    public void openExternal(String str, String str2, String str3) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            String str4 = "openExternal";
            if (!renderView.mo34568e()) {
                this.f32847c.mo34565c(str4);
            } else {
                this.f32847c.mo34558a(str4, str, str2, str3);
            }
        }
    }

    @JavascriptInterface
    public void asyncPing(String str, String str2) {
        String str3 = "asyncPing";
        if (!URLUtil.isValidUrl(str2)) {
            this.f32847c.mo34563b(str, "Invalid url", str3);
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("command", "ping");
            hashMap.put("scheme", C10466br.m34254a(str));
            this.f32847c.mo34560a("CreativeInvokedAction", (Map<String, Object>) hashMap);
            final C10676c cVar = new C10676c("GET", str2);
            cVar.f32583u = false;
            cVar.f32569A = false;
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            new C10672a(cVar, new C10674a() {
                /* renamed from: a */
                public final void mo34261a(C10677d dVar) {
                    C10757c.f32846b;
                    try {
                        C10299n.m33566a().mo33663a(cVar.mo34509g());
                        C10299n.m33566a().mo33664b(dVar.mo34513c());
                        C10299n.m33566a().mo33665c(SystemClock.elapsedRealtime() - elapsedRealtime);
                    } catch (Exception e) {
                        C10757c.f32846b;
                        new StringBuilder("Error in setting request-response data size. ").append(e.getMessage());
                    }
                }

                /* renamed from: b */
                public final void mo34262b(C10677d dVar) {
                    C10757c.f32846b;
                }
            }).mo34498a();
        } catch (Exception e) {
            this.f32847c.mo34563b(str, "Unexpected error", str3);
            new StringBuilder("SDK encountered internal error in handling asyncPing() request from creative; ").append(e.getMessage());
        }
    }

    @JavascriptInterface
    public void showAlert(String str, String str2) {
    }

    @JavascriptInterface
    public void disableCloseRegion(final String str, final boolean z) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            new Handler(renderView.getContainerContext().getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        C10757c.this.f32847c.mo34561a(z);
                    } catch (Exception e) {
                        C10757c.this.f32847c.mo34563b(str, "Unexpected error", "disableCloseRegion");
                        C10757c.f32846b;
                        new StringBuilder("SDK encountered unexpected error in handling disableCloseRegion() request from creative; ").append(e.getMessage());
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void onUserInteraction(String str, String str2) {
        RenderView renderView = this.f32847c;
        String str3 = "onUserInteraction";
        if (renderView == null || renderView.mo34568e()) {
            String str4 = "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ";
            String str5 = "Unexpected error";
            if (str2 == null) {
                try {
                    this.f32847c.getListener().mo34055b(new HashMap<>());
                } catch (Exception e) {
                    this.f32847c.mo34563b(str, str5, str3);
                    new StringBuilder(str4).append(e.getMessage());
                }
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    HashMap hashMap = new HashMap();
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str6 = (String) keys.next();
                        hashMap.put(str6, jSONObject.get(str6));
                    }
                    try {
                        this.f32847c.getListener().mo34055b(hashMap);
                    } catch (Exception e2) {
                        this.f32847c.mo34563b(str, str5, str3);
                        new StringBuilder(str4).append(e2.getMessage());
                    }
                } catch (JSONException e3) {
                    try {
                        this.f32847c.getListener().mo34055b(new HashMap<>());
                    } catch (Exception e4) {
                        this.f32847c.mo34563b(str, str5, str3);
                        new StringBuilder(str4).append(e4.getMessage());
                    }
                }
            }
        } else {
            this.f32847c.mo34565c(str3);
        }
    }

    @JavascriptInterface
    public void incentCompleted(String str, String str2) {
        String str3 = "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ";
        String str4 = "incentCompleted";
        String str5 = "Unexpected error";
        if (str2 == null) {
            try {
                this.f32847c.getListener().mo34052a(new HashMap<>());
            } catch (Exception e) {
                this.f32847c.mo34563b(str, str5, str4);
                new StringBuilder(str3).append(e.getMessage());
            }
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                HashMap hashMap = new HashMap();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str6 = (String) keys.next();
                    hashMap.put(str6, jSONObject.get(str6));
                }
                try {
                    this.f32847c.getListener().mo34052a(hashMap);
                } catch (Exception e2) {
                    this.f32847c.mo34563b(str, str5, str4);
                    new StringBuilder(str3).append(e2.getMessage());
                }
            } catch (JSONException e3) {
                try {
                    this.f32847c.getListener().mo34052a(new HashMap<>());
                } catch (Exception e4) {
                    this.f32847c.mo34563b(str, str5, str4);
                    new StringBuilder(str3).append(e4.getMessage());
                }
            }
        }
    }

    @JavascriptInterface
    public String getOrientation(String str) {
        int b = C10692c.m35105b();
        if (b == 1) {
            return BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        }
        if (b == 3) {
            return "90";
        }
        if (b == 2) {
            return "180";
        }
        if (b == 4) {
            return "270";
        }
        return "-1";
    }

    @JavascriptInterface
    public void saveContent(String str, String str2, String str3) {
        String str4 = "saveContent";
        String str5 = "";
        String str6 = "\");";
        String str7 = "\", 'failed', \"";
        String str8 = "reason";
        String str9 = "sendSaveContentResult(\"saveContent_";
        String str10 = "\\\"";
        String str11 = "\"";
        String str12 = "url";
        if (str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            JSONObject jSONObject = new JSONObject();
            if (str3 == null) {
                str3 = str5;
            }
            try {
                jSONObject.put(str12, str3);
                jSONObject.put(str8, 1);
            } catch (JSONException e) {
            }
            String replace = jSONObject.toString().replace(str11, str10);
            StringBuilder sb = new StringBuilder(str9);
            if (str2 == null) {
                str2 = str5;
            }
            sb.append(str2);
            sb.append(str7);
            sb.append(replace);
            sb.append(str6);
            this.f32847c.mo34556a(str, sb.toString());
            return;
        }
        try {
            RenderView renderView = this.f32847c;
            StringBuilder sb2 = new StringBuilder("saveContent called: content ID: ");
            sb2.append(str2);
            sb2.append("; URL: ");
            sb2.append(str3);
            if (!renderView.mo34569e(str4)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(str12, str3);
                    jSONObject2.put(str8, 5);
                } catch (JSONException e2) {
                }
                String replace2 = jSONObject2.toString().replace(str11, str10);
                StringBuilder sb3 = new StringBuilder(str9);
                sb3.append(str2);
                sb3.append(str7);
                sb3.append(replace2);
                sb3.append(str6);
                renderView.mo34556a(str, sb3.toString());
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(new C10461bm(-1, str3));
            C10515b bVar = new C10515b(UUID.randomUUID().toString(), (Set<C10461bm>) hashSet, renderView.f32768w, str2);
            bVar.f32071g = str;
            AssetStore a = AssetStore.m34369a();
            a.f32017c.execute(new Runnable(bVar) {

                /* renamed from: a */
                final /* synthetic */ C10515b f32032a;

                {
                    this.f32032a = r2;
                }

                public final void run() {
                    AssetStore.this.m34384b(this.f32032a);
                    AssetStore.f32012f;
                    StringBuilder sb = new StringBuilder("Attempting to cache ");
                    sb.append(this.f32032a.f32066b.size());
                    sb.append("remote URLs ");
                    for (C10461bm bmVar : this.f32032a.f32066b) {
                        AssetStore.m34382b(AssetStore.this, bmVar.f31824b);
                    }
                }
            });
        } catch (Exception e3) {
            this.f32847c.mo34563b(str, "Unexpected error", str4);
            new StringBuilder("SDK encountered unexpected error in handling saveContent() request from creative; ").append(e3.getMessage());
        }
    }

    @JavascriptInterface
    public void cancelSaveContent(String str, String str2) {
        try {
            RenderView.m35202d();
        } catch (Exception e) {
            this.f32847c.mo34563b(str, "Unexpected error", "cancelSaveContent");
            new StringBuilder("SDK encountered unexpected error in handling cancelSaveContent() request from creative; ").append(e.getMessage());
        }
    }

    @JavascriptInterface
    public String isDeviceMuted(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return AdultContentAnalytics.UNLOCK;
        }
        boolean z = false;
        try {
            renderView.getMediaProcessor();
            z = MraidMediaProcessor.m35334a();
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in checking if device is muted; ").append(e.getMessage());
        }
        return String.valueOf(z);
    }

    @JavascriptInterface
    public String isHeadphonePlugged(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return AdultContentAnalytics.UNLOCK;
        }
        boolean z = false;
        try {
            renderView.getMediaProcessor();
            z = MraidMediaProcessor.m35337d();
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in checking if headphones are plugged-in; ").append(e.getMessage());
        }
        return String.valueOf(z);
    }

    @JavascriptInterface
    public void registerDeviceMuteEventListener(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                MraidMediaProcessor mediaProcessor = renderView.getMediaProcessor();
                Context b = C10619a.m34839b();
                if (b != null && mediaProcessor.f32912c == null) {
                    mediaProcessor.f32912c = new RingerModeChangeReceiver(str);
                    b.registerReceiver(mediaProcessor.f32912c, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
                }
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "registerDeviceMuteEventListener");
                new StringBuilder("SDK encountered unexpected error in handling registerDeviceMuteEventListener() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void unregisterDeviceMuteEventListener(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                renderView.getMediaProcessor().mo34776b();
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "unRegisterDeviceMuteEventListener");
                new StringBuilder("SDK encountered unexpected error in handling unregisterDeviceMuteEventListener() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void registerDeviceVolumeChangeEventListener(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                MraidMediaProcessor mediaProcessor = renderView.getMediaProcessor();
                Context b = C10619a.m34839b();
                if (b != null && mediaProcessor.f32913d == null) {
                    mediaProcessor.f32913d = new C10776a(str, b, new Handler());
                    b.getContentResolver().registerContentObserver(System.CONTENT_URI, true, mediaProcessor.f32913d);
                }
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "registerDeviceVolumeChangeEventListener");
                new StringBuilder("SDK encountered unexpected error in handling registerDeviceVolumeChangeEventListener() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void unregisterDeviceVolumeChangeEventListener(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                renderView.getMediaProcessor().mo34777c();
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "unregisterDeviceVolumeChangeEventListener");
                new StringBuilder("SDK encountered unexpected error in handling unregisterDeviceVolumeChangeEventListener() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public int getDeviceVolume(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return -1;
        }
        try {
            MraidMediaProcessor mediaProcessor = renderView.getMediaProcessor();
            Context b = C10619a.m34839b();
            if (b == null) {
                return -1;
            }
            if (!mediaProcessor.f32910a.getRenderingConfig().f31955m || !C10619a.m34846d()) {
                return ((AudioManager) b.getSystemService("audio")).getStreamVolume(3);
            }
            return 0;
        } catch (Exception e) {
            this.f32847c.mo34563b(str, "Unexpected error", "getDeviceVolume");
            new StringBuilder("SDK encountered unexpected error in handling getDeviceVolume() request from creative; ").append(e.getMessage());
            return -1;
        }
    }

    @JavascriptInterface
    public void registerHeadphonePluggedEventListener(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                MraidMediaProcessor mediaProcessor = renderView.getMediaProcessor();
                Context b = C10619a.m34839b();
                if (b != null && mediaProcessor.f32914e == null) {
                    mediaProcessor.f32914e = new HeadphonesPluggedChangeReceiver(str);
                    b.registerReceiver(mediaProcessor.f32914e, new IntentFilter("android.intent.action.HEADSET_PLUG"));
                }
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "registerHeadphonePluggedEventListener");
                new StringBuilder("SDK encountered unexpected error in handling registerHeadphonePluggedEventListener() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void unregisterHeadphonePluggedEventListener(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                renderView.getMediaProcessor().mo34778e();
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "unregisterHeadphonePluggedEventListener");
                new StringBuilder("SDK encountered unexpected error in handling unregisterHeadphonePluggedEventListener() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void disableBackButton(String str, boolean z) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            renderView.setDisableBackButton(z);
        }
    }

    @JavascriptInterface
    public boolean isBackButtonDisabled(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return false;
        }
        return renderView.f32762q;
    }

    @JavascriptInterface
    public void registerBackButtonPressedEventListener(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                renderView.f32763r = str;
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "registerBackButtonPressedEventListener");
                new StringBuilder("SDK encountered unexpected error in handling registerBackButtonPressedEventListener() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void unregisterBackButtonPressedEventListener(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                renderView.f32763r = null;
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "unregisterBackButtonPressedEventListener");
                new StringBuilder("SDK encountered unexpected error in handling unregisterBackButtonPressedEventListener() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void startDownloader(String str, String str2, String str3, String str4) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            String str5 = "startDownloader";
            if (!renderView.mo34568e()) {
                this.f32847c.mo34565c(str5);
                return;
            }
            try {
                if (TextUtils.isEmpty(str2)) {
                    this.f32847c.mo34563b(str, "Invalid URL", str5);
                    return;
                }
                RenderView renderView2 = this.f32847c;
                AdContainer referenceContainer = renderView2.getReferenceContainer();
                if (referenceContainer instanceof C10380ah) {
                    C10380ah ahVar = (C10380ah) referenceContainer;
                    C10400ak.m34046a(str2, str3, str4);
                    ahVar.mo34014a(renderView2);
                    return;
                }
                if (referenceContainer instanceof RenderView) {
                    C10400ak.m34046a(str2, str3, str4);
                }
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", str5);
                new StringBuilder("SDK encountered unexpected error in handling startDownloader() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void registerDownloaderCallbacks(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                AdContainer referenceContainer = renderView.getReferenceContainer();
                if (referenceContainer instanceof C10380ah) {
                    ((C10380ah) referenceContainer).mo34014a(renderView);
                }
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "registerDownloaderCallbacks");
                new StringBuilder("SDK encountered unexpected error in handling registerDownloaderCallbacks() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void unregisterDownloaderCallbacks(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                AdContainer referenceContainer = renderView.getReferenceContainer();
                if (referenceContainer instanceof C10380ah) {
                    C10380ah ahVar = (C10380ah) referenceContainer;
                    if (ahVar.f31577z != null) {
                        ahVar.f31577z.remove(renderView);
                    }
                }
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "unregisterDownloaderCallbacks");
                new StringBuilder("SDK encountered unexpected error in handling unregisterDownloaderCallbacks() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public int getDownloadProgress(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return -1;
        }
        try {
            return renderView.getDownloadProgress();
        } catch (Exception e) {
            this.f32847c.mo34563b(str, "Unexpected error", "getDownloadProgress");
            new StringBuilder("SDK encountered unexpected error in handling getDownloadProgress() request from creative; ").append(e.getMessage());
            return -1;
        }
    }

    @JavascriptInterface
    public int getDownloadStatus(String str) {
        RenderView renderView = this.f32847c;
        if (renderView == null) {
            return -1;
        }
        try {
            return renderView.getDownloadStatus();
        } catch (Exception e) {
            this.f32847c.mo34563b(str, "Unexpected error", "getDownloadStatus");
            new StringBuilder("SDK encountered unexpected error in handling getDownloadStatus() request from creative; ").append(e.getMessage());
            return -1;
        }
    }

    @JavascriptInterface
    public void setCloseEndCardTracker(String str, String str2) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            try {
                renderView.setCloseEndCardTracker(str2);
            } catch (Exception e) {
                this.f32847c.mo34563b(str, "Unexpected error", "getDownloadStatus");
                new StringBuilder("SDK encountered unexpected error in handling getDownloadStatus() request from creative; ").append(e.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void fireSkip(String str) {
        RenderView.m35207f();
    }

    @JavascriptInterface
    public void fireComplete(String str) {
        if (this.f32847c != null) {
            RenderView.m35208g();
        }
    }

    @JavascriptInterface
    public void showEndCard(String str) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            AdContainer referenceContainer = renderView.getReferenceContainer();
            if (referenceContainer instanceof C10380ah) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        C10380ah ahVar = C10380ah.this;
                        ahVar.f31569r = true;
                        ahVar.mo34018c((C10400ak) null);
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void saveBlob(String str, String str2) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            C10735a aVar = renderView.f32766u;
            if (aVar != null) {
                aVar.mo34297e(str2);
            }
        }
    }

    @JavascriptInterface
    public void getBlob(String str, String str2) {
        RenderView renderView = this.f32847c;
        if (renderView != null) {
            C10735a aVar = renderView.f32766u;
            if (aVar != null) {
                aVar.mo34289a(str, str2, renderView);
            }
        }
    }

    @JavascriptInterface
    public String getPlatform(String str) {
        return "android";
    }

    @JavascriptInterface
    public String getVersion(String str) {
        return "2.0";
    }

    @JavascriptInterface
    public String getSdkVersion(String str) {
        return "7.2.7";
    }
}
