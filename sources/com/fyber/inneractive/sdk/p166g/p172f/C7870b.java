package com.fyber.inneractive.sdk.p166g.p172f;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.C7636R;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.mraid.C7970s;
import com.fyber.inneractive.sdk.mraid.C7972u;
import com.fyber.inneractive.sdk.mraid.C7974w;
import com.fyber.inneractive.sdk.mraid.C7976y;
import com.fyber.inneractive.sdk.p166g.p171e.C7860e;
import com.fyber.inneractive.sdk.p174i.C7908j;
import com.fyber.inneractive.sdk.p179l.C7927c;
import com.fyber.inneractive.sdk.p179l.C7930d;
import com.fyber.inneractive.sdk.p179l.C7930d.C7939a;
import com.fyber.inneractive.sdk.p179l.C7930d.C7942d;
import com.fyber.inneractive.sdk.p179l.C7930d.C7943e;
import com.fyber.inneractive.sdk.p179l.C7930d.C7944f;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.C8034w;
import com.fyber.inneractive.sdk.util.IAlog;
import com.vungle.warren.model.Advertisement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import p363i.p364a.p365a.C14216d;
import p363i.p364a.p366b.C14220a;
import p363i.p364a.p366b.C14225c;
import p363i.p364a.p366b.C14225c.C14226a;
import p363i.p364a.p366b.C14227d;
import p363i.p364a.p366b.p367a.C14221a;
import p363i.p364a.p366b.p367a.C14222b;

/* renamed from: com.fyber.inneractive.sdk.g.f.b */
public final class C7870b extends C7930d<C7876a> {

    /* renamed from: P */
    private static boolean f15917P = false;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public Context f15918L;

    /* renamed from: M */
    private C7908j f15919M;

    /* renamed from: N */
    private boolean f15920N;

    /* renamed from: O */
    private boolean f15921O;

    /* renamed from: a */
    public C7712j f15922a;

    /* renamed from: b */
    public C7869a f15923b;

    /* renamed from: c */
    int f15924c;

    /* renamed from: d */
    boolean f15925d;

    /* renamed from: e */
    public Boolean f15926e;

    /* renamed from: f */
    boolean f15927f;

    /* renamed from: g */
    Runnable f15928g;

    /* renamed from: com.fyber.inneractive.sdk.g.f.b$a */
    public interface C7876a extends C7942d {
        /* renamed from: a */
        void mo24529a(int i, int i2);

        /* renamed from: a_ */
        void mo24527a_();

        /* renamed from: e */
        void mo24471e();

        /* renamed from: h */
        void mo24530h();

        /* renamed from: i */
        void mo24531i();

        /* renamed from: j */
        void mo24532j();
    }

    /* renamed from: com.fyber.inneractive.sdk.g.f.b$b */
    public class C7877b {
        public C7877b() {
        }

        @JavascriptInterface
        public final void vpaidAdLoaded() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdLoaded");
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void vpaidAdStarted() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdStarted");
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void vpaidAdVideoStart(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdVideoStart. Duration: ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
            C7870b.m17662a(C7870b.this, str);
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    C7870b.this.mo24649a(C7869a.Playing);
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdPaused() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdPaused");
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    C7870b.this.mo24649a(C7869a.Paused);
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdPlaying(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdPlaying, duration:");
            sb.append(str);
            IAlog.m18021b(sb.toString());
            C7870b.m17662a(C7870b.this, str);
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    C7870b.this.mo24649a(C7869a.Playing);
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdError(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdError - ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    C7870b bVar = C7870b.this;
                    if (bVar.f15923b != C7869a.Completed) {
                        bVar.mo24649a(C7869a.Error);
                    }
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdLog(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdLog: ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void vpaidAdUserAcceptInvitation() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdUserAcceptInvitation");
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void vpaidAdUserMinimize() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdUserMinimize");
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void vpaidAdUserClose() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdUserClose");
            IAlog.m18021b(sb.toString());
            C7870b bVar = C7870b.this;
            C7869a aVar = bVar.f15923b;
            C7869a aVar2 = C7869a.Closing;
            if (aVar != aVar2) {
                bVar.f15923b = aVar2;
                bVar.mo24735a((Runnable) new Runnable() {
                    public final void run() {
                        if (C7870b.this.f16138l != null) {
                            ((C7876a) C7870b.this.f16138l).mo24530h();
                        }
                    }
                });
            }
        }

        @JavascriptInterface
        public final void vpaidAdSkippableStateChange(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdSkippableStateChange: ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
            if (str != null && C7870b.this.f15922a.mo24210f().mo24221h() != UnitDisplayType.REWARDED) {
                C7870b.this.f15926e = Boolean.valueOf(str);
            }
        }

        @JavascriptInterface
        public final void vpaidAdExpandedChange() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdExpandedChange");
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void vpaidAdSizeChange() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdSizeChange");
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void vpaidAdDurationChange(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdDurationChange duration:");
            sb.append(str);
            IAlog.m18021b(sb.toString());
            vpaidAdDuration(str);
        }

        @JavascriptInterface
        public final void vpaidAdDuration(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdDuration: ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
            C7870b.m17662a(C7870b.this, str);
        }

        @JavascriptInterface
        public final void vpaidAdRemainingTimeChange(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdRemainingTimeChange: ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void vpaidAdImpression() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdImpression");
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    if (C7870b.this.f16138l != null) {
                        ((C7876a) C7870b.this.f16138l).mo24531i();
                    }
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdInteraction(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdInteraction ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void adWasClicked() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("adWasClicked");
            IAlog.m18021b(sb.toString());
            C7870b.this.f15927f = true;
        }

        @JavascriptInterface
        public final void canNotAutoplay() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("canNotAutoplay");
            IAlog.m18021b(sb.toString());
            C7870b.this.f15925d = false;
        }

        @JavascriptInterface
        public final void vpaidAdVideoFirstQuartile() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdVideoFirstQuartile");
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    if (C7870b.this.f16138l != null) {
                        C7876a aVar = (C7876a) C7870b.this.f16138l;
                        int i = C7870b.this.f15924c;
                        aVar.mo24529a(i, i / 4);
                    }
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdVideoMidpoint() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdVideoMidpoint");
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    if (C7870b.this.f16138l != null) {
                        C7876a aVar = (C7876a) C7870b.this.f16138l;
                        int i = C7870b.this.f15924c;
                        aVar.mo24529a(i, i / 2);
                    }
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdVideoThirdQuartile() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdVideoThirdQuartile");
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    if (C7870b.this.f16138l != null) {
                        C7876a aVar = (C7876a) C7870b.this.f16138l;
                        int i = C7870b.this.f15924c;
                        aVar.mo24529a(i, (i * 3) / 4);
                    }
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdVideoComplete() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdVideoComplete");
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    C7870b.this.f15926e = Boolean.valueOf(true);
                    if (C7870b.this.f16138l != null) {
                        C7876a aVar = (C7876a) C7870b.this.f16138l;
                        int i = C7870b.this.f15924c;
                        aVar.mo24529a(i, i);
                    }
                    C7870b.this.mo24649a(C7869a.Completed);
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdStopped() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdStopped called");
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    C7870b bVar = C7870b.this;
                    C7869a aVar = bVar.f15923b;
                    if (aVar == C7869a.Stopping) {
                        bVar.mo24649a(C7869a.Stopped);
                        C7870b.this.mo24652b();
                        return;
                    }
                    if (aVar != C7869a.Completed) {
                        bVar.mo24649a(C7869a.Stopped);
                    }
                }
            });
        }

        @JavascriptInterface
        public final void vpaidAdSkipped() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdSkipped");
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void vpaidAdVolumeChanged(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("vpaidAdVolumeChanged: ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
        }

        @JavascriptInterface
        public final void onVPaidPlayerError(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("onVPaidPlayerError: ");
            sb.append(str);
            sb.append(" code = ");
            sb.append(str2);
            IAlog.m18021b(sb.toString());
            if (str2 != null && str2.equals("567")) {
                C7870b.this.f15926e = Boolean.valueOf(true);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(IAlog.m18018a((Object) C7870b.this));
                sb2.append("onVPaidPlayerError: critical error occured");
                IAlog.m18021b(sb2.toString());
                C7870b.this.mo24735a((Runnable) new Runnable() {
                    public final void run() {
                        C7870b.this.mo24649a(C7869a.Error);
                        if (C7870b.this.f16138l != null) {
                            ((C7876a) C7870b.this.f16138l).mo24532j();
                        }
                    }
                });
            }
        }

        @JavascriptInterface
        public final void requestFullScreen() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("requestFullScreen: ");
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    if (C7870b.this.f16138l != null) {
                        ((C7876a) C7870b.this.f16138l).mo24527a_();
                    }
                }
            });
        }

        @JavascriptInterface
        public final void exitFullScreen() {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) C7870b.this));
            sb.append("exitFullScreen: ");
            IAlog.m18021b(sb.toString());
            C7870b.this.mo24735a((Runnable) new Runnable() {
                public final void run() {
                    if (C7870b.this.f16138l != null) {
                        ((C7876a) C7870b.this.f16138l).mo24471e();
                    }
                }
            });
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m17681g(C7870b bVar) {
        bVar.mo24735a((Runnable) new Runnable() {

            /* renamed from: a */
            final /* synthetic */ int f15932a = 15;

            /* renamed from: b */
            final /* synthetic */ int f15933b = 15;

            public final void run() {
                C7870b.this.f16134h.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100, 0, (float) C8006j.m18072b(this.f15932a), (float) C8006j.m18072b(this.f15933b), 0));
            }
        });
        bVar.mo24736a((Runnable) new Runnable() {

            /* renamed from: a */
            final /* synthetic */ int f15935a = 15;

            /* renamed from: b */
            final /* synthetic */ int f15936b = 15;

            public final void run() {
                C7870b.this.f16134h.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100, 1, (float) C8006j.m18072b(this.f15935a), (float) C8006j.m18072b(this.f15936b), 0));
            }
        }, 100);
    }

    public C7870b(Context context, C7908j jVar, C7712j jVar2) {
        super(context, true, true, jVar2.mo24210f().mo24221h() == UnitDisplayType.INTERSTITIAL ? C7943e.INTERSTITIAL : C7943e.INLINE, C7939a.f16207b, C7944f.f16223c);
        this.f15923b = C7869a.Idle;
        this.f15924c = 0;
        this.f15925d = true;
        this.f15926e = null;
        this.f15927f = false;
        this.f15918L = context;
        this.f15919M = jVar;
        this.f15922a = jVar2;
        this.f16134h.setId(C7636R.C7637id.inneractive_webview_vast_vpaid);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24648a() {
        super.mo24648a();
        if (!f15917P) {
            f15917P = true;
            if (VERSION.SDK_INT == 19) {
                WebView webView = new WebView(this.f15918L.getApplicationContext());
                webView.setBackgroundColor(0);
                webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
                LayoutParams layoutParams = new LayoutParams();
                layoutParams.width = 1;
                layoutParams.height = 1;
                layoutParams.type = 2005;
                layoutParams.flags = 16777240;
                layoutParams.format = -2;
                layoutParams.gravity = 8388659;
                ((WindowManager) this.f15918L.getSystemService("window")).addView(webView, layoutParams);
            }
        }
        WebSettings settings = this.f16134h.getSettings();
        if (VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        this.f16134h.addJavascriptInterface(new C7877b(), "vpaidClient");
        int min = Math.min(C8006j.m18081t(), C8006j.m18080s());
        Point point = new Point();
        UnitDisplayType h = this.f15922a.mo24210f().mo24221h();
        int min2 = Math.min(C8006j.m18081t(), C8006j.m18080s());
        if (h == UnitDisplayType.INTERSTITIAL) {
            point.x = C8006j.m18081t();
            point.y = C8006j.m18080s();
        } else if (h == UnitDisplayType.SQUARE) {
            point.x = Math.min(min, min2) - C8006j.m18072b(this.f15922a.mo24210f().mo24218e().intValue() * 2);
            point.y = point.x;
        } else if (h == UnitDisplayType.LANDSCAPE) {
            point.x = Math.min(min, min2) - C8006j.m18072b(this.f15922a.mo24210f().mo24218e().intValue() * 2);
            point.y = ((point.x * 9) / 16) + C7860e.f15872h;
        } else if (h == UnitDisplayType.MRECT) {
            point.x = C8006j.m18072b(300);
            point.y = C8006j.m18072b(250);
        } else {
            point = null;
        }
        if (point != null) {
            this.f16134h.mo24753a(point.x, point.y);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo24647a(String str, String str2, String str3) {
        String str4;
        String a = C8008a.m18082a("vpaid_html_template.html");
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", Advertisement.KEY_VIDEO);
            Map<String, String> map = this.f15919M.f16048q;
            if (map != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (String str5 : map.keySet()) {
                    jSONObject2.put(str5, map.get(str5));
                }
                jSONObject.put("headers", jSONObject2);
            }
            String str6 = "spotType";
            if (this.f15922a.mo24210f().mo24221h().equals(UnitDisplayType.MRECT)) {
                str4 = "rectangle";
            } else {
                str4 = this.f15922a.mo24210f().mo24221h().toString();
            }
            jSONObject.put(str6, str4);
            jSONObject.put(InneractiveFullscreenAdActivity.EXTRA_KEY_SPOT_ID, mo24658f());
            jSONObject.put("unitId", this.f15922a.mo24204a());
            jSONObject.put("unitType", this.f15919M.f16045n);
            jSONObject.put("unitDisplayType", this.f15919M.f16046o);
            jSONObject.put("isSDK", true);
            Boolean e = IAConfigManager.m16991e();
            if (e != null) {
                jSONObject.put("gdprPrivacyConsent", e.booleanValue() ? 1 : 0);
            }
            JSONObject jSONObject3 = new JSONObject();
            ArrayList<Pair<String, String>> arrayList = this.f15919M.f16049s.f16073j;
            jSONObject3.put("firstVastXML", ((Pair) arrayList.get(0)).second);
            if (arrayList.size() > 1) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 1; i < arrayList.size(); i++) {
                    JSONObject jSONObject4 = new JSONObject();
                    Pair pair = (Pair) arrayList.get(i);
                    jSONObject4.put("vastURL", pair.first);
                    jSONObject4.put("vastXML", pair.second);
                    jSONArray.put(jSONObject4);
                }
                jSONObject3.put("unwrappedVastXMLs", jSONArray);
            }
            jSONObject.put("vpaidAd", jSONObject3);
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("Spot settings Json = ");
            sb.append(jSONObject.toString());
            IAlog.m18021b(sb.toString());
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("Failed creating Settings json object: ");
            sb2.append(e2.getMessage());
            IAlog.m18021b(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(IAlog.m18018a((Object) this));
        sb3.append("buildHtml: building object took ");
        sb3.append(System.currentTimeMillis() - currentTimeMillis);
        String str7 = " msec";
        sb3.append(str7);
        IAlog.m18021b(sb3.toString());
        String m = IAConfigManager.m16999m();
        long currentTimeMillis2 = System.currentTimeMillis();
        String a2 = C8008a.m18082a("ia_mraid_bridge.txt");
        HashMap hashMap = new HashMap();
        hashMap.put("appIdTemplate", IAConfigManager.m16994h());
        hashMap.put("spotIdTemplate", mo24658f());
        hashMap.put("appConfigTemplate", IAConfigManager.m16979b());
        hashMap.put("spotsSettingsTemplate", jSONObject.toString());
        StringBuilder sb4 = new StringBuilder();
        if (TextUtils.isEmpty(m)) {
            m = "https://cdn2.inner-active.mobi/client/ia-js-tags/ia-tag-sdk.min-android-7.2.2.js";
        }
        sb4.append(m);
        sb4.append("?_t=");
        sb4.append(String.valueOf(System.currentTimeMillis()));
        hashMap.put("tagUrlTemplate", sb4.toString());
        hashMap.put("mraidTemplate", a2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(IAlog.m18018a((Object) this));
        sb5.append("buildHtml: getters took ");
        sb5.append(System.currentTimeMillis() - currentTimeMillis2);
        sb5.append(str7);
        IAlog.m18021b(sb5.toString());
        long currentTimeMillis3 = System.currentTimeMillis();
        String a3 = m17660a(a, (Map<String, String>) hashMap);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(IAlog.m18018a((Object) this));
        sb6.append("buildHtml: replace took ");
        sb6.append(System.currentTimeMillis() - currentTimeMillis3);
        sb6.append(str7);
        IAlog.m18021b(sb6.toString());
        return a3;
    }

    /* renamed from: a */
    public final boolean mo24651a(String str) {
        Uri parse = Uri.parse(str);
        String uri = parse.toString();
        parse.getScheme();
        if (uri.startsWith("iavpaidbridgeready")) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append(" Bridge finished loading!");
            IAlog.m18021b(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("got onVPaidBridgeLoaded. Loading creating");
            IAlog.m18021b(sb2.toString());
            this.f16164A = C7976y.DEFAULT;
            mo24771a((C7970s) C7972u.m18000a(C7943e.INTERSTITIAL));
            mo24771a((C7970s) C7974w.m18004a(this.f16164A));
            mo24788t();
            StringBuilder sb3 = new StringBuilder("IAVPAIDWrapperInstance.loadCreative(iaTag.api(), '");
            sb3.append(mo24658f());
            sb3.append("');");
            mo24741e(sb3.toString());
            return true;
        } else if (!uri.startsWith("iavpaidadloaded")) {
            return super.mo24651a(str);
        } else {
            if (!this.f15921O) {
                this.f15921O = true;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(IAlog.m18018a((Object) this));
                sb4.append(" Creative finished loading!");
                IAlog.m18021b(sb4.toString());
                if (this.f15923b == C7869a.Idle) {
                    mo24649a(C7869a.Paused);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(IAlog.m18018a((Object) this));
                    sb5.append("got onVPaidAdReadyAndLoaded");
                    IAlog.m18021b(sb5.toString());
                    mo24746j();
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(IAlog.m18018a((Object) this));
                    sb6.append("got onVPaidAdReadyAndLoaded on the wrong player state! - ");
                    sb6.append(this.f15923b);
                    sb6.append(" state must be idle");
                    IAlog.m18021b(sb6.toString());
                }
            } else {
                this.f15923b = C7869a.Preparing;
                this.f15920N = false;
                mo24657e_();
            }
            return true;
        }
    }

    /* renamed from: b */
    public final boolean mo24653b(String str) {
        return mo24654c(str);
    }

    /* renamed from: a */
    public final void mo24650a(final boolean z) {
        mo24736a((Runnable) new Runnable() {
            public final void run() {
                if (C7870b.this.f16134h.getWidth() > 0 && C7870b.this.f16134h.getHeight() > 0) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) C7870b.this.f15918L.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    int width = (int) (((float) C7870b.this.f16134h.getWidth()) / displayMetrics.density);
                    int height = (int) (((float) C7870b.this.f16134h.getHeight()) / displayMetrics.density);
                    C7927c f = C7870b.this.f16134h;
                    StringBuilder sb = new StringBuilder("IAVPAIDWrapperInstance.resizeAd(");
                    sb.append(width);
                    sb.append(", ");
                    sb.append(height);
                    sb.append(", '");
                    sb.append(z ? "fullscreen" : "normal");
                    sb.append("');");
                    f.mo24754a(sb.toString());
                }
            }
        }, 75);
    }

    /* renamed from: b */
    public final void mo24652b() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("destroy called");
        IAlog.m18021b(sb.toString());
        C7869a aVar = this.f15923b;
        if (aVar == C7869a.Stopping) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("pending destroy until ad stops");
            IAlog.m18021b(sb2.toString());
        } else if (aVar == C7869a.Playing || aVar == C7869a.Seeking || aVar == C7869a.Paused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(IAlog.m18018a((Object) this));
            sb3.append("waiting for ad to stop");
            IAlog.m18021b(sb3.toString());
            C8034w.m18120a().mo24869a(this.f16134h);
            mo24779m();
            C7869a aVar2 = this.f15923b;
            if (!(aVar2 == C7869a.Stopped || aVar2 == C7869a.Error || aVar2 == C7869a.Completed)) {
                mo24649a(C7869a.Stopping);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(IAlog.m18018a((Object) this));
                sb4.append("stop ad called");
                IAlog.m18021b(sb4.toString());
                mo24741e("IAVPAIDWrapperInstance.stopAd();");
                if (this.f15928g == null) {
                    this.f15928g = new Runnable() {
                        public final void run() {
                            StringBuilder sb = new StringBuilder();
                            sb.append(IAlog.m18018a((Object) C7870b.this));
                            sb.append("stop timeout. destroying web view");
                            IAlog.m18021b(sb.toString());
                            C7870b.this.mo24649a(C7869a.Stopped);
                            C7870b.this.mo24652b();
                        }
                    };
                    mo24736a(this.f15928g, 3000);
                }
            }
        } else {
            mo24649a(C7869a.Destroyed);
            super.mo24652b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24649a(C7869a aVar) {
        if (this.f15923b != aVar) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append("updating player state with ");
            sb.append(aVar);
            IAlog.m18021b(sb.toString());
            this.f15923b = aVar;
        }
    }

    /* renamed from: e_ */
    public final void mo24657e_() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("startPlaying called. player state = ");
        sb.append(this.f15923b);
        IAlog.m18021b(sb.toString());
        C7869a aVar = this.f15923b;
        if (aVar == C7869a.Destroyed || aVar == C7869a.Error || aVar == C7869a.Closing || this.f16134h == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(IAlog.m18018a((Object) this));
            sb2.append("startPlaying called in illegal state, or web view is already destroyed");
            IAlog.m18021b(sb2.toString());
        } else if (aVar == C7869a.Playing) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(IAlog.m18018a((Object) this));
            sb3.append("startPlaying called in playing state, do nothing");
            IAlog.m18021b(sb3.toString());
        } else {
            C7869a aVar2 = C7869a.Seeking;
            if (aVar != aVar2) {
                if (!this.f15920N) {
                    if (this.f15925d) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(IAlog.m18018a((Object) this));
                        sb4.append("startPlaying the video for the first time");
                        IAlog.m18021b(sb4.toString());
                        StringBuilder sb5 = new StringBuilder("IAVPAIDWrapperInstance.startPlaying(iaTag.api() , '");
                        sb5.append(mo24658f());
                        sb5.append("');");
                        mo24741e(sb5.toString());
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(IAlog.m18018a((Object) this));
                        sb6.append("VPaid auto play not supported - simulating click");
                        IAlog.m18021b(sb6.toString());
                        mo24735a((Runnable) new Runnable() {
                            public final void run() {
                                C7870b.m17681g(C7870b.this);
                            }
                        });
                    }
                    this.f15920N = true;
                } else if (!(aVar == aVar2 || aVar == C7869a.Playing)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(IAlog.m18018a((Object) this));
                    sb7.append("resumeVideo called");
                    IAlog.m18021b(sb7.toString());
                    mo24741e("IAVPAIDWrapperInstance.resumeAd();");
                }
                mo24649a(C7869a.Seeking);
            }
        }
    }

    /* renamed from: d */
    public final void mo24655d() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("pauseVideo called");
        IAlog.m18021b(sb.toString());
        C7869a aVar = this.f15923b;
        if (aVar != C7869a.Paused && aVar != C7869a.Completed) {
            mo24649a(C7869a.Paused);
            mo24741e("IAVPAIDWrapperInstance.pauseAd();");
        }
    }

    /* renamed from: a */
    private static String m17660a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str.length() << 1);
        int i = 0;
        C14226a aVar = new C14226a(0);
        C14227d dVar = aVar.f43140a;
        dVar.f43143b = true;
        dVar.f43142a = false;
        for (String str2 : map.keySet()) {
            C14225c cVar = aVar.f43141b;
            if (!str2.isEmpty()) {
                if (cVar.f43138a.f43145d) {
                    str2 = str2.toLowerCase();
                }
                cVar.f43139b.mo44333a(str2).mo44336b(str2);
            }
        }
        aVar.f43141b.mo44337a();
        C14225c cVar2 = aVar.f43141b;
        C14221a aVar2 = new C14221a();
        cVar2.mo44338a((CharSequence) str, (C14222b) aVar2);
        List<C14220a> a = aVar2.mo44330a();
        if (cVar2.f43138a.f43143b) {
            C14225c.m45764a((CharSequence) str, a);
        }
        if (cVar2.f43138a.f43144c) {
            C14225c.m45765b(str, a);
        }
        if (!cVar2.f43138a.f43142a) {
            new C14216d(a).mo44327a(a);
        }
        for (C14220a aVar3 : a) {
            sb.append(str.substring(i, aVar3.f43120a));
            sb.append((String) map.get(aVar3.f43131c));
            i = aVar3.f43121b + 1;
        }
        sb.append(str.substring(i));
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final boolean mo24656e() {
        return this.f15927f && this.f16142p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final boolean mo24654c(String str) {
        boolean c = super.mo24654c(str);
        if (c) {
            StringBuilder sb = new StringBuilder("IAVPAIDWrapperInstance.VPAIDclickWasDone(iaTag.api(), '");
            sb.append(mo24658f());
            sb.append("');");
            mo24741e(sb.toString());
        }
        return c;
    }

    /* renamed from: f */
    public final String mo24658f() {
        StringBuilder sb = new StringBuilder("spot-");
        sb.append(this.f15922a.mo24206b());
        return sb.toString();
    }

    /* renamed from: a */
    static /* synthetic */ void m17662a(C7870b bVar, String str) {
        try {
            int floatValue = (int) Float.valueOf(str).floatValue();
            if (floatValue > 0) {
                bVar.f15924c = floatValue;
            }
        } catch (Throwable th) {
        }
    }
}
