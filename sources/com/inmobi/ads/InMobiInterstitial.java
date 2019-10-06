package com.inmobi.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p001v7.widget.RecyclerView;
import com.inmobi.ads.C10365ac;
import com.inmobi.ads.C10365ac.C10372a;
import com.inmobi.ads.C10455bi;
import com.inmobi.ads.C10545i.C10575b;
import com.inmobi.ads.C10545i.C10578e;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.inmobi.ads.p212c.C10491a;
import com.inmobi.ads.p212c.C10500b;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p217a.C10619a;
import com.squareup.picasso.Picasso;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

public final class InMobiInterstitial {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f31300a = InMobiInterstitial.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static ConcurrentHashMap<C10365ac, ArrayList<WeakReference<InterstitialAdRequestListener>>> f31301m = new ConcurrentHashMap<>(2, 0.9f, 3);

    /* renamed from: b */
    private C10365ac f31302b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C10319a f31303c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public InterstitialAdListener2 f31304d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public InterstitialAdEventListener f31305e;

    /* renamed from: f */
    private Context f31306f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f31307g;

    /* renamed from: h */
    private boolean f31308h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f31309i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Map<String, String> f31310j;

    /* renamed from: k */
    private boolean f31311k;

    /* renamed from: l */
    private boolean f31312l;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f31313n;

    /* renamed from: o */
    private C10579j f31314o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public JSONObject f31315p;

    /* renamed from: q */
    private final C10575b f31316q;

    /* renamed from: com.inmobi.ads.InMobiInterstitial$3 */
    static /* synthetic */ class C103183 {

        /* renamed from: a */
        static final /* synthetic */ int[] f31324a = new int[StatusCode.values().length];

        static {
            try {
                f31324a[StatusCode.NETWORK_UNREACHABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f31324a[StatusCode.REQUEST_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f31324a[StatusCode.AD_ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f31324a[StatusCode.EARLY_REFRESH_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f31324a[StatusCode.MISSING_REQUIRED_DEPENDENCIES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f31324a[StatusCode.MONETIZATION_DISABLED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public interface InterstitialAdListener2 {
        void onAdDismissed(InMobiInterstitial inMobiInterstitial);

        void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial);

        void onAdDisplayed(InMobiInterstitial inMobiInterstitial);

        void onAdInteraction(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map);

        void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus);

        void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial);

        void onAdReceived(InMobiInterstitial inMobiInterstitial);

        void onAdRewardActionCompleted(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map);

        void onAdWillDisplay(InMobiInterstitial inMobiInterstitial);

        void onUserLeftApplication(InMobiInterstitial inMobiInterstitial);
    }

    public interface InterstitialAdRequestListener {
        void onAdRequestCompleted(InMobiAdRequestStatus inMobiAdRequestStatus, InMobiInterstitial inMobiInterstitial);
    }

    /* renamed from: com.inmobi.ads.InMobiInterstitial$a */
    static final class C10319a extends Handler {

        /* renamed from: a */
        private WeakReference<InMobiInterstitial> f31325a;

        C10319a(InMobiInterstitial inMobiInterstitial) {
            super(Looper.getMainLooper());
            this.f31325a = new WeakReference<>(inMobiInterstitial);
        }

        public final void handleMessage(Message message) {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f31325a.get();
            if (inMobiInterstitial != null) {
                try {
                    Map map = null;
                    switch (message.what) {
                        case 1:
                            InMobiAdRequestStatus inMobiAdRequestStatus = (InMobiAdRequestStatus) message.obj;
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
                            }
                            if (inMobiInterstitial.f31304d != null) {
                                inMobiInterstitial.f31304d.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
                                return;
                            }
                            break;
                        case 2:
                            if (message.getData().getBoolean("available")) {
                                if (inMobiInterstitial.f31305e != null) {
                                    inMobiInterstitial.f31305e.onAdReceived(inMobiInterstitial);
                                }
                                if (inMobiInterstitial.f31304d != null) {
                                    inMobiInterstitial.f31304d.onAdReceived(inMobiInterstitial);
                                    return;
                                }
                            }
                            break;
                        case 3:
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onAdLoadSucceeded(inMobiInterstitial);
                            }
                            if (inMobiInterstitial.f31304d != null) {
                                inMobiInterstitial.f31304d.onAdLoadSucceeded(inMobiInterstitial);
                                return;
                            }
                            break;
                        case 4:
                            if (message.obj != null) {
                                map = (Map) message.obj;
                            }
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onRewardsUnlocked(inMobiInterstitial, map);
                            }
                            if (inMobiInterstitial.f31304d != null) {
                                inMobiInterstitial.f31304d.onAdRewardActionCompleted(inMobiInterstitial, map);
                                return;
                            }
                            break;
                        case 5:
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onAdDisplayFailed(inMobiInterstitial);
                            }
                            if (inMobiInterstitial.f31304d != null) {
                                inMobiInterstitial.f31304d.onAdDisplayFailed(inMobiInterstitial);
                                return;
                            }
                            break;
                        case 6:
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onAdWillDisplay(inMobiInterstitial);
                            }
                            if (inMobiInterstitial.f31304d != null) {
                                inMobiInterstitial.f31304d.onAdWillDisplay(inMobiInterstitial);
                                return;
                            }
                            break;
                        case 7:
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onAdDisplayed(inMobiInterstitial);
                            }
                            if (inMobiInterstitial.f31304d != null) {
                                inMobiInterstitial.f31304d.onAdDisplayed(inMobiInterstitial);
                                return;
                            }
                            break;
                        case 9:
                            if (message.obj != null) {
                                map = (Map) message.obj;
                            }
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onAdClicked(inMobiInterstitial, map);
                            }
                            if (inMobiInterstitial.f31304d != null) {
                                inMobiInterstitial.f31304d.onAdInteraction(inMobiInterstitial, map);
                                return;
                            }
                            break;
                        case 10:
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onAdDismissed(inMobiInterstitial);
                            }
                            if (inMobiInterstitial.f31304d != null) {
                                inMobiInterstitial.f31304d.onAdDismissed(inMobiInterstitial);
                                return;
                            }
                            break;
                        case 11:
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onUserLeftApplication(inMobiInterstitial);
                            }
                            if (inMobiInterstitial.f31304d != null) {
                                inMobiInterstitial.f31304d.onUserLeftApplication(inMobiInterstitial);
                                return;
                            }
                            break;
                        case 12:
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onRequestPayloadCreated((byte[]) message.obj);
                                return;
                            }
                            break;
                        case 13:
                            if (inMobiInterstitial.f31305e != null) {
                                inMobiInterstitial.f31305e.onRequestPayloadCreationFailed((InMobiAdRequestStatus) message.obj);
                                return;
                            }
                            break;
                        default:
                            InMobiInterstitial.f31300a;
                            break;
                    }
                } catch (Exception e) {
                    Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.f31300a, "Publisher handler caused unexpected error");
                    InMobiInterstitial.f31300a;
                    new StringBuilder("Callback threw unexpected error: ").append(e.getMessage());
                }
            }
        }
    }

    /* synthetic */ InMobiInterstitial(Context context, long j, byte b) {
        this(context, j);
    }

    @Deprecated
    public InMobiInterstitial(Context context, long j, InterstitialAdListener2 interstitialAdListener2) {
        this.f31308h = false;
        this.f31312l = false;
        this.f31313n = "";
        this.f31316q = new C10575b() {
            /* renamed from: a */
            public final void mo33782a(boolean z) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                Bundle bundle = new Bundle();
                bundle.putBoolean("available", z);
                obtain.setData(bundle);
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* renamed from: a */
            public final void mo33781a(C10545i iVar) {
                InMobiInterstitial.this.m33641a("AR", "");
                InMobiInterstitial.this.f31313n = iVar.f32188x;
                InMobiInterstitial.this.f31315p = iVar.f32173i;
                InMobiInterstitial.this.f31303c.sendEmptyMessage(3);
            }

            /* renamed from: a */
            public final void mo33748a(InMobiAdRequestStatus inMobiAdRequestStatus) {
                String str = "ART";
                switch (C103183.f31324a[inMobiAdRequestStatus.getStatusCode().ordinal()]) {
                    case 1:
                        InMobiInterstitial.this.m33641a(str, "NetworkNotAvailable");
                        break;
                    case 2:
                        InMobiInterstitial.this.m33641a(str, "LoadInProgress");
                        break;
                    case 3:
                        InMobiInterstitial.this.m33641a(str, "ReloadNotPermitted");
                        break;
                    case 4:
                        InMobiInterstitial.this.m33641a(str, "FrequentRequests");
                        break;
                    case 5:
                        InMobiInterstitial.this.m33641a(str, "MissingRequiredDependencies");
                        break;
                    case 6:
                        InMobiInterstitial.this.m33641a(str, "MonetizationDisabled");
                        break;
                    default:
                        InMobiInterstitial.this.m33641a("AF", "");
                        break;
                }
                if (!InMobiInterstitial.m33646c()) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = inMobiAdRequestStatus;
                    InMobiInterstitial.this.f31303c.sendMessage(obtain);
                }
            }

            /* renamed from: b */
            public final void mo33783b() {
                InMobiInterstitial.this.f31303c.sendEmptyMessage(5);
            }

            /* renamed from: c */
            public final void mo33784c() {
                InMobiInterstitial.this.f31303c.sendEmptyMessage(6);
            }

            /* renamed from: d */
            public final void mo33753d() {
                InMobiInterstitial.this.m33641a("AVD", "");
                InMobiInterstitial.this.f31303c.sendEmptyMessage(7);
            }

            /* renamed from: e */
            public final void mo33754e() {
                InMobiInterstitial.this.m33641a("AVCD", "");
                InMobiInterstitial.this.f31303c.sendEmptyMessage(10);
                C10500b d = C10500b.m34347d();
                C10455bi a = C10455bi.m34229a(InMobiInterstitial.this.f31307g, InMobiInterstitial.this.f31310j, "int", InMobiInterstitial.this.f31309i);
                if (C10491a.f31976b.mo34205c(d.f31984c).f31940a) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(a) {

                        /* renamed from: a */
                        final /* synthetic */ C10455bi f32004a;

                        {
                            this.f32004a = r2;
                        }

                        public final void run() {
                            try {
                                C10500b.m34344a(C10500b.this);
                                if (!C10491a.f31975a.containsKey(this.f32004a)) {
                                    C10500b.f32000d;
                                    StringBuilder sb = new StringBuilder("preLoadAdUnit. pid:");
                                    sb.append(this.f32004a.f31801a);
                                    sb.append(" tp:");
                                    sb.append(this.f32004a.f31802b);
                                    if (this.f32004a.f31803c == null && this.f32004a.f31802b != null) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("tp", this.f32004a.f31802b);
                                        this.f32004a.f31803c = hashMap;
                                    }
                                    C10502a aVar = new C10502a(this.f32004a);
                                    C10500b.f32003g.add(aVar);
                                    C10365ac a = C10372a.m33886a(C10619a.m34839b(), this.f32004a, aVar);
                                    a.f32169e = this.f32004a.f31804d;
                                    a.f32170f = this.f32004a.f31803c;
                                    a.f32178n = true;
                                    C10491a.f31975a.put(this.f32004a, a);
                                    a.mo33988e(aVar);
                                }
                            } catch (Exception e) {
                                C10500b.f32000d;
                                new StringBuilder("SDK encountered an unexpected error preloading ad units; ").append(e.getMessage());
                                C10621a.m34854a().mo34423a(new C10658a(e));
                            }
                        }
                    });
                }
            }

            /* renamed from: a */
            public final void mo33749a(Map<Object, Object> map) {
                InMobiInterstitial.this.m33641a("AVCL", "");
                Message obtain = Message.obtain();
                obtain.what = 9;
                obtain.obj = map;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* renamed from: f */
            public final void mo33755f() {
                InMobiInterstitial.this.f31303c.sendEmptyMessage(11);
            }

            /* renamed from: b */
            public final void mo33752b(Map<Object, Object> map) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = map;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public final void mo33750a(byte[] bArr) {
                Message obtain = Message.obtain();
                obtain.what = 12;
                obtain.obj = bArr;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public final void mo33751b(InMobiAdRequestStatus inMobiAdRequestStatus) {
                Message obtain = Message.obtain();
                obtain.what = 13;
                obtain.obj = inMobiAdRequestStatus;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }
        };
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Please initialize the SDK before creating an Interstitial ad");
        } else if (interstitialAdListener2 == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "The Interstitial ad cannot be created as no event listener was supplied. Please attach a listener to proceed");
        } else if (context == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Unable to create Interstitial ad with null context object.");
        } else {
            this.f31308h = true;
            this.f31306f = context.getApplicationContext();
            this.f31307g = j;
            this.f31304d = interstitialAdListener2;
            this.f31303c = new C10319a(this);
        }
    }

    public InMobiInterstitial(Context context, long j, InterstitialAdEventListener interstitialAdEventListener) {
        this.f31308h = false;
        this.f31312l = false;
        this.f31313n = "";
        this.f31316q = new C10575b() {
            /* renamed from: a */
            public final void mo33782a(boolean z) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                Bundle bundle = new Bundle();
                bundle.putBoolean("available", z);
                obtain.setData(bundle);
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* renamed from: a */
            public final void mo33781a(C10545i iVar) {
                InMobiInterstitial.this.m33641a("AR", "");
                InMobiInterstitial.this.f31313n = iVar.f32188x;
                InMobiInterstitial.this.f31315p = iVar.f32173i;
                InMobiInterstitial.this.f31303c.sendEmptyMessage(3);
            }

            /* renamed from: a */
            public final void mo33748a(InMobiAdRequestStatus inMobiAdRequestStatus) {
                String str = "ART";
                switch (C103183.f31324a[inMobiAdRequestStatus.getStatusCode().ordinal()]) {
                    case 1:
                        InMobiInterstitial.this.m33641a(str, "NetworkNotAvailable");
                        break;
                    case 2:
                        InMobiInterstitial.this.m33641a(str, "LoadInProgress");
                        break;
                    case 3:
                        InMobiInterstitial.this.m33641a(str, "ReloadNotPermitted");
                        break;
                    case 4:
                        InMobiInterstitial.this.m33641a(str, "FrequentRequests");
                        break;
                    case 5:
                        InMobiInterstitial.this.m33641a(str, "MissingRequiredDependencies");
                        break;
                    case 6:
                        InMobiInterstitial.this.m33641a(str, "MonetizationDisabled");
                        break;
                    default:
                        InMobiInterstitial.this.m33641a("AF", "");
                        break;
                }
                if (!InMobiInterstitial.m33646c()) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = inMobiAdRequestStatus;
                    InMobiInterstitial.this.f31303c.sendMessage(obtain);
                }
            }

            /* renamed from: b */
            public final void mo33783b() {
                InMobiInterstitial.this.f31303c.sendEmptyMessage(5);
            }

            /* renamed from: c */
            public final void mo33784c() {
                InMobiInterstitial.this.f31303c.sendEmptyMessage(6);
            }

            /* renamed from: d */
            public final void mo33753d() {
                InMobiInterstitial.this.m33641a("AVD", "");
                InMobiInterstitial.this.f31303c.sendEmptyMessage(7);
            }

            /* renamed from: e */
            public final void mo33754e() {
                InMobiInterstitial.this.m33641a("AVCD", "");
                InMobiInterstitial.this.f31303c.sendEmptyMessage(10);
                C10500b d = C10500b.m34347d();
                C10455bi a = C10455bi.m34229a(InMobiInterstitial.this.f31307g, InMobiInterstitial.this.f31310j, "int", InMobiInterstitial.this.f31309i);
                if (C10491a.f31976b.mo34205c(d.f31984c).f31940a) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(a) {

                        /* renamed from: a */
                        final /* synthetic */ C10455bi f32004a;

                        {
                            this.f32004a = r2;
                        }

                        public final void run() {
                            try {
                                C10500b.m34344a(C10500b.this);
                                if (!C10491a.f31975a.containsKey(this.f32004a)) {
                                    C10500b.f32000d;
                                    StringBuilder sb = new StringBuilder("preLoadAdUnit. pid:");
                                    sb.append(this.f32004a.f31801a);
                                    sb.append(" tp:");
                                    sb.append(this.f32004a.f31802b);
                                    if (this.f32004a.f31803c == null && this.f32004a.f31802b != null) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("tp", this.f32004a.f31802b);
                                        this.f32004a.f31803c = hashMap;
                                    }
                                    C10502a aVar = new C10502a(this.f32004a);
                                    C10500b.f32003g.add(aVar);
                                    C10365ac a = C10372a.m33886a(C10619a.m34839b(), this.f32004a, aVar);
                                    a.f32169e = this.f32004a.f31804d;
                                    a.f32170f = this.f32004a.f31803c;
                                    a.f32178n = true;
                                    C10491a.f31975a.put(this.f32004a, a);
                                    a.mo33988e(aVar);
                                }
                            } catch (Exception e) {
                                C10500b.f32000d;
                                new StringBuilder("SDK encountered an unexpected error preloading ad units; ").append(e.getMessage());
                                C10621a.m34854a().mo34423a(new C10658a(e));
                            }
                        }
                    });
                }
            }

            /* renamed from: a */
            public final void mo33749a(Map<Object, Object> map) {
                InMobiInterstitial.this.m33641a("AVCL", "");
                Message obtain = Message.obtain();
                obtain.what = 9;
                obtain.obj = map;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* renamed from: f */
            public final void mo33755f() {
                InMobiInterstitial.this.f31303c.sendEmptyMessage(11);
            }

            /* renamed from: b */
            public final void mo33752b(Map<Object, Object> map) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = map;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public final void mo33750a(byte[] bArr) {
                Message obtain = Message.obtain();
                obtain.what = 12;
                obtain.obj = bArr;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public final void mo33751b(InMobiAdRequestStatus inMobiAdRequestStatus) {
                Message obtain = Message.obtain();
                obtain.what = 13;
                obtain.obj = inMobiAdRequestStatus;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }
        };
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Please initialize the SDK before creating an Interstitial ad");
        } else if (interstitialAdEventListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "The Interstitial ad cannot be created as no event listener was supplied. Please attach a listener to proceed");
        } else if (context == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Unable to create Interstitial ad with null context object.");
        } else {
            this.f31308h = true;
            this.f31306f = context.getApplicationContext();
            this.f31307g = j;
            this.f31305e = interstitialAdEventListener;
            this.f31303c = new C10319a(this);
        }
    }

    private InMobiInterstitial(Context context, long j) {
        this.f31308h = false;
        this.f31312l = false;
        this.f31313n = "";
        this.f31316q = new C10575b() {
            /* renamed from: a */
            public final void mo33782a(boolean z) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                Bundle bundle = new Bundle();
                bundle.putBoolean("available", z);
                obtain.setData(bundle);
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* renamed from: a */
            public final void mo33781a(C10545i iVar) {
                InMobiInterstitial.this.m33641a("AR", "");
                InMobiInterstitial.this.f31313n = iVar.f32188x;
                InMobiInterstitial.this.f31315p = iVar.f32173i;
                InMobiInterstitial.this.f31303c.sendEmptyMessage(3);
            }

            /* renamed from: a */
            public final void mo33748a(InMobiAdRequestStatus inMobiAdRequestStatus) {
                String str = "ART";
                switch (C103183.f31324a[inMobiAdRequestStatus.getStatusCode().ordinal()]) {
                    case 1:
                        InMobiInterstitial.this.m33641a(str, "NetworkNotAvailable");
                        break;
                    case 2:
                        InMobiInterstitial.this.m33641a(str, "LoadInProgress");
                        break;
                    case 3:
                        InMobiInterstitial.this.m33641a(str, "ReloadNotPermitted");
                        break;
                    case 4:
                        InMobiInterstitial.this.m33641a(str, "FrequentRequests");
                        break;
                    case 5:
                        InMobiInterstitial.this.m33641a(str, "MissingRequiredDependencies");
                        break;
                    case 6:
                        InMobiInterstitial.this.m33641a(str, "MonetizationDisabled");
                        break;
                    default:
                        InMobiInterstitial.this.m33641a("AF", "");
                        break;
                }
                if (!InMobiInterstitial.m33646c()) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = inMobiAdRequestStatus;
                    InMobiInterstitial.this.f31303c.sendMessage(obtain);
                }
            }

            /* renamed from: b */
            public final void mo33783b() {
                InMobiInterstitial.this.f31303c.sendEmptyMessage(5);
            }

            /* renamed from: c */
            public final void mo33784c() {
                InMobiInterstitial.this.f31303c.sendEmptyMessage(6);
            }

            /* renamed from: d */
            public final void mo33753d() {
                InMobiInterstitial.this.m33641a("AVD", "");
                InMobiInterstitial.this.f31303c.sendEmptyMessage(7);
            }

            /* renamed from: e */
            public final void mo33754e() {
                InMobiInterstitial.this.m33641a("AVCD", "");
                InMobiInterstitial.this.f31303c.sendEmptyMessage(10);
                C10500b d = C10500b.m34347d();
                C10455bi a = C10455bi.m34229a(InMobiInterstitial.this.f31307g, InMobiInterstitial.this.f31310j, "int", InMobiInterstitial.this.f31309i);
                if (C10491a.f31976b.mo34205c(d.f31984c).f31940a) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(a) {

                        /* renamed from: a */
                        final /* synthetic */ C10455bi f32004a;

                        {
                            this.f32004a = r2;
                        }

                        public final void run() {
                            try {
                                C10500b.m34344a(C10500b.this);
                                if (!C10491a.f31975a.containsKey(this.f32004a)) {
                                    C10500b.f32000d;
                                    StringBuilder sb = new StringBuilder("preLoadAdUnit. pid:");
                                    sb.append(this.f32004a.f31801a);
                                    sb.append(" tp:");
                                    sb.append(this.f32004a.f31802b);
                                    if (this.f32004a.f31803c == null && this.f32004a.f31802b != null) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("tp", this.f32004a.f31802b);
                                        this.f32004a.f31803c = hashMap;
                                    }
                                    C10502a aVar = new C10502a(this.f32004a);
                                    C10500b.f32003g.add(aVar);
                                    C10365ac a = C10372a.m33886a(C10619a.m34839b(), this.f32004a, aVar);
                                    a.f32169e = this.f32004a.f31804d;
                                    a.f32170f = this.f32004a.f31803c;
                                    a.f32178n = true;
                                    C10491a.f31975a.put(this.f32004a, a);
                                    a.mo33988e(aVar);
                                }
                            } catch (Exception e) {
                                C10500b.f32000d;
                                new StringBuilder("SDK encountered an unexpected error preloading ad units; ").append(e.getMessage());
                                C10621a.m34854a().mo34423a(new C10658a(e));
                            }
                        }
                    });
                }
            }

            /* renamed from: a */
            public final void mo33749a(Map<Object, Object> map) {
                InMobiInterstitial.this.m33641a("AVCL", "");
                Message obtain = Message.obtain();
                obtain.what = 9;
                obtain.obj = map;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* renamed from: f */
            public final void mo33755f() {
                InMobiInterstitial.this.f31303c.sendEmptyMessage(11);
            }

            /* renamed from: b */
            public final void mo33752b(Map<Object, Object> map) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = map;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public final void mo33750a(byte[] bArr) {
                Message obtain = Message.obtain();
                obtain.what = 12;
                obtain.obj = bArr;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public final void mo33751b(InMobiAdRequestStatus inMobiAdRequestStatus) {
                Message obtain = Message.obtain();
                obtain.what = 13;
                obtain.obj = inMobiAdRequestStatus;
                InMobiInterstitial.this.f31303c.sendMessage(obtain);
            }
        };
        this.f31308h = true;
        this.f31306f = context;
        this.f31307g = j;
        this.f31303c = new C10319a(this);
    }

    @Deprecated
    public final void setInterstitialAdListener(InterstitialAdListener2 interstitialAdListener2) {
        this.f31304d = interstitialAdListener2;
    }

    public final void setListener(InterstitialAdEventListener interstitialAdEventListener) {
        if (interstitialAdEventListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Please pass a non-null listener to the interstitial.");
        } else {
            this.f31305e = interstitialAdEventListener;
        }
    }

    public final void setKeywords(String str) {
        if (this.f31308h) {
            this.f31309i = str;
        }
    }

    /* renamed from: a */
    private boolean m33642a(boolean z) {
        if (!this.f31308h) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "InMobiInterstitial is not initialized, your call is ignored.");
        } else if (!z ? this.f31305e == null : this.f31304d == null && this.f31305e == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Listener supplied is null, your call is ignored.");
        } else if (this.f31306f != null) {
            return true;
        } else {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Context supplied is null, your call is ignored.");
        }
        return false;
    }

    public final void getSignals() {
        if (m33642a(false)) {
            if (this.f31302b == null) {
                this.f31302b = C10372a.m33887b(this.f31306f, C10455bi.m34229a(this.f31307g, this.f31310j, "int", this.f31309i), this.f31316q);
            }
            m33641a("ARR", "");
            m33640a(this.f31302b);
            this.f31302b.mo34303o();
        }
    }

    public final void load(byte[] bArr) {
        if (m33642a(false)) {
            C10365ac acVar = this.f31302b;
            if (acVar == null) {
                Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Either getSignals() is not called or InMobiInterstitial is not initialized, your call is ignored.");
                return;
            }
            this.f31312l = true;
            if (acVar.mo33987d(this.f31316q)) {
                acVar.mo34291a(bArr);
            }
        }
    }

    public final void load() {
        String str = "";
        try {
            if (m33642a(true)) {
                C10455bi a = C10455bi.m34229a(this.f31307g, this.f31310j, "int", this.f31309i);
                C10500b d = C10500b.m34347d();
                C10545i iVar = null;
                String str2 = " tp:";
                if (!C10491a.f31976b.mo34205c(d.f31984c).f31940a) {
                    StringBuilder sb = new StringBuilder("No cached ad unit found as config is disabled. pid:");
                    sb.append(a.f31801a);
                    sb.append(str2);
                    sb.append(a.f31802b);
                } else {
                    d.mo34211a(a);
                    C10545i iVar2 = (C10545i) C10491a.f31975a.get(a);
                    if (iVar2 == null) {
                        StringBuilder sb2 = new StringBuilder("No cached ad unit found for pid:");
                        sb2.append(a.f31801a);
                        sb2.append(str2);
                        sb2.append(a.f31802b);
                    } else if (iVar2.mo34300h()) {
                        StringBuilder sb3 = new StringBuilder("Expired cached ad unit found for pid:");
                        sb3.append(a.f31801a);
                        sb3.append(str2);
                        sb3.append(a.f31802b);
                        iVar2.mo33995v();
                        C10491a.f31975a.remove(a);
                        C10500b.m34346a("AdUnitExpired", iVar2);
                    } else {
                        StringBuilder sb4 = new StringBuilder("Cached ad unit found for pid:");
                        sb4.append(a.f31801a);
                        sb4.append(str2);
                        sb4.append(a.f31802b);
                        C10500b.m34345a((C10545i) C10491a.f31975a.remove(a));
                        iVar = iVar2;
                    }
                }
                this.f31312l = true;
                if (iVar != null) {
                    this.f31302b = (C10365ac) iVar;
                } else {
                    this.f31302b = C10372a.m33886a(this.f31306f, a, this.f31316q);
                }
                m33641a("ARR", str);
                m33640a(this.f31302b);
                C10365ac acVar = this.f31302b;
                InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                String str3 = f31300a;
                StringBuilder sb5 = new StringBuilder("Fetching an Interstitial ad for placement id: ");
                sb5.append(acVar.f32168d);
                Logger.m35065a(internalLogLevel, str3, sb5.toString());
                this.f31313n = str;
                this.f31315p = this.f31302b.f32166b;
                acVar.mo34285a(this.f31316q);
                acVar.mo33988e(this.f31316q);
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Unable to load ad; SDK encountered an unexpected error");
            new StringBuilder("Load failed with unexpected error: ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33641a(String str, String str2) {
        if (this.f31314o == null) {
            this.f31314o = new C10580k(this.f31302b);
        }
        this.f31314o.mo34335a(this.f31316q, str, str2);
    }

    @Deprecated
    public static void requestAd(Context context, InMobiAdRequest inMobiAdRequest, InterstitialAdRequestListener interstitialAdRequestListener) {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Please initialize the SDK before calling requestAd. Ignoring request");
        } else if (interstitialAdRequestListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Please supply a non null InterstitialAdRequestListener. Ignoring request");
        } else if (inMobiAdRequest == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Please supply a non null InMobiAdRequest. Ignoring request");
        } else if (context == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Please supply a non null Context. Ignoring request");
        } else {
            C10365ac acVar = null;
            try {
                RecyclerView.class.getName();
                Picasso.class.getName();
                C103141 r1 = new C10578e() {
                    /* renamed from: a */
                    public final void mo33744a(C10545i iVar) {
                        try {
                            if (iVar instanceof C10365ac) {
                                ArrayList arrayList = (ArrayList) InMobiInterstitial.f31301m.get(iVar);
                                if (arrayList != null) {
                                    InMobiInterstitial.f31301m.remove(iVar);
                                    Handler handler = new Handler(Looper.getMainLooper());
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        WeakReference weakReference = (WeakReference) it.next();
                                        if (weakReference != null) {
                                            final InterstitialAdRequestListener interstitialAdRequestListener = (InterstitialAdRequestListener) weakReference.get();
                                            if (interstitialAdRequestListener != null) {
                                                final InMobiInterstitial inMobiInterstitial = new InMobiInterstitial(iVar.mo34283a(), iVar.f32168d, 0);
                                                inMobiInterstitial.setKeywords(iVar.f32169e);
                                                inMobiInterstitial.setExtras(iVar.f32170f);
                                                handler.post(new Runnable() {
                                                    public final void run() {
                                                        try {
                                                            interstitialAdRequestListener.onAdRequestCompleted(new InMobiAdRequestStatus(StatusCode.NO_ERROR), inMobiInterstitial);
                                                        } catch (Exception e) {
                                                            Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.f31300a, "Publisher handler caused unexpected error");
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            InMobiInterstitial.f31300a;
                            new StringBuilder("SDK encountered unexpected error in onAdPrefetchSucceeded ").append(e.getMessage());
                        }
                    }

                    /* renamed from: a */
                    public final void mo33745a(C10545i iVar, final InMobiAdRequestStatus inMobiAdRequestStatus) {
                        try {
                            if (iVar instanceof C10365ac) {
                                ArrayList arrayList = (ArrayList) InMobiInterstitial.f31301m.get(iVar);
                                if (arrayList != null && arrayList.size() > 0) {
                                    WeakReference weakReference = (WeakReference) arrayList.get(arrayList.size() - 1);
                                    if (weakReference != null) {
                                        arrayList.remove(weakReference);
                                        if (arrayList.size() == 0) {
                                            InMobiInterstitial.f31301m.remove(iVar);
                                        }
                                        final InterstitialAdRequestListener interstitialAdRequestListener = (InterstitialAdRequestListener) weakReference.get();
                                        if (interstitialAdRequestListener != null) {
                                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                public final void run() {
                                                    try {
                                                        interstitialAdRequestListener.onAdRequestCompleted(inMobiAdRequestStatus, null);
                                                    } catch (Exception e) {
                                                        Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.f31300a, "Publisher handler caused unexpected error");
                                                    }
                                                }
                                            });
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            InMobiInterstitial.f31300a;
                            new StringBuilder("SDK encountered unexpected error in onAdPrefetchFailed ").append(e.getMessage());
                        }
                    }
                };
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Repo.COLUMN_DESCRIPTION, "requestAd Api called");
                    try {
                        C10659b.m34983a();
                        C10659b.m34987a("ads", "GenericEvents", hashMap);
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                        sb.append(e.getMessage());
                        sb.append(")");
                    }
                    Iterator it = f31301m.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C10365ac acVar2 = (C10365ac) ((Entry) it.next()).getKey();
                        if (acVar2 != null && acVar2.f32168d == inMobiAdRequest.f31254a) {
                            acVar = acVar2;
                            break;
                        }
                    }
                    if (acVar != null) {
                        ArrayList arrayList = (ArrayList) f31301m.get(acVar);
                        arrayList.add(new WeakReference(interstitialAdRequestListener));
                        C10365ac a = m33634a(context, inMobiAdRequest, (C10578e) r1);
                        f31301m.put(a, arrayList);
                        a.mo33993q();
                        return;
                    }
                    C10365ac a2 = m33634a(context, inMobiAdRequest, (C10578e) r1);
                    a2.f32181q = r1;
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new WeakReference(interstitialAdRequestListener));
                    f31301m.put(a2, arrayList2);
                    a2.mo33993q();
                } catch (Exception e2) {
                    new StringBuilder("SDK encountered unexpected error in requestAd").append(e2.getMessage());
                }
            } catch (NoClassDefFoundError e3) {
                Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Some of the dependency libraries for Interstitial not found. Ignoring request");
                interstitialAdRequestListener.onAdRequestCompleted(new InMobiAdRequestStatus(StatusCode.MISSING_REQUIRED_DEPENDENCIES), null);
            }
        }
    }

    /* renamed from: a */
    private static C10365ac m33634a(Context context, InMobiAdRequest inMobiAdRequest, C10578e eVar) {
        C10365ac a = C10372a.m33886a(context.getApplicationContext(), C10455bi.m34229a(inMobiAdRequest.f31254a, inMobiAdRequest.f31259f, "int", inMobiAdRequest.f31258e), null);
        a.f32170f = inMobiAdRequest.f31259f;
        a.f32169e = inMobiAdRequest.f31258e;
        a.mo33972a(MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY);
        a.f32178n = true;
        a.f32181q = eVar;
        return a;
    }

    /* renamed from: a */
    private void m33640a(C10365ac acVar) {
        acVar.mo34080a(this.f31306f);
        acVar.f32170f = this.f31310j;
        acVar.f32169e = this.f31309i;
        acVar.mo33972a(MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY);
        if (this.f31311k) {
            AdContainer j = acVar.mo34302j();
            if (j != null) {
                acVar.f31504y = true;
                j.mo33678a();
            }
        }
        acVar.f32178n = false;
    }

    public final void show() {
        try {
            if (!this.f31312l) {
                Logger.m35065a(InternalLogLevel.ERROR, f31300a, "load() must be called before trying to show the ad");
                return;
            }
            if (this.f31308h && this.f31302b != null) {
                m33641a("AVR", "");
                this.f31302b.mo33989f(this.f31316q);
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31300a, "Unable to show ad; SDK encountered an unexpected error");
            new StringBuilder("Show failed with unexpected error: ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    @Deprecated
    public final void show(int i, int i2) {
        show();
    }

    public final boolean isReady() {
        if (this.f31308h) {
            C10365ac acVar = this.f31302b;
            if (acVar != null && acVar.mo33969O()) {
                return true;
            }
        }
        return false;
    }

    public final JSONObject getAdMetaInfo() {
        JSONObject jSONObject = this.f31315p;
        if (jSONObject == null) {
            return new JSONObject();
        }
        return jSONObject;
    }

    public final String getCreativeId() {
        return this.f31313n;
    }

    public final void setExtras(Map<String, String> map) {
        if (this.f31308h) {
            this.f31310j = map;
        }
    }

    public final void disableHardwareAcceleration() {
        if (this.f31308h) {
            this.f31311k = true;
        }
    }

    /* renamed from: c */
    static /* synthetic */ boolean m33646c() {
        return Message.obtain() == null;
    }
}
