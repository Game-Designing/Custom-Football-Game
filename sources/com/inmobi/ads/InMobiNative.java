package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p001v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.C10545i.C10575b;
import com.inmobi.ads.C10545i.C10578e;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.ads.listeners.VideoEventListener;
import com.inmobi.ads.p212c.C10491a;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10694e;
import com.inmobi.commons.p217a.C10619a;
import com.squareup.picasso.Picasso;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

public final class InMobiNative {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f31326a = InMobiNative.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static ConcurrentHashMap<C10396aj, WeakReference<NativeAdRequestListener>> f31327j = new ConcurrentHashMap<>(5, 0.9f, 3);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C10323a f31328b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public NativeAdListener f31329c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public NativeAdEventListener f31330d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public VideoEventListener f31331e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C10396aj f31332f;

    /* renamed from: g */
    private String f31333g;

    /* renamed from: h */
    private Map<String, String> f31334h;

    /* renamed from: i */
    private long f31335i;

    /* renamed from: k */
    private Downloader f31336k;

    /* renamed from: l */
    private WeakReference<View> f31337l;

    /* renamed from: m */
    private boolean f31338m;

    /* renamed from: n */
    private boolean f31339n;

    /* renamed from: o */
    private WeakReference<Context> f31340o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LockScreenListener f31341p;

    /* renamed from: q */
    private C10579j f31342q;

    /* renamed from: r */
    private final C10575b f31343r;

    /* renamed from: com.inmobi.ads.InMobiNative$3 */
    static /* synthetic */ class C103223 {

        /* renamed from: a */
        static final /* synthetic */ int[] f31346a = new int[StatusCode.values().length];

        static {
            try {
                f31346a[StatusCode.NETWORK_UNREACHABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f31346a[StatusCode.REQUEST_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f31346a[StatusCode.AD_ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f31346a[StatusCode.EARLY_REFRESH_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f31346a[StatusCode.MISSING_REQUIRED_DEPENDENCIES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f31346a[StatusCode.REPETITIVE_LOAD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f31346a[StatusCode.MONETIZATION_DISABLED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public final class Downloader {
        public static final int STATE_DOWNLOADED = 1;
        public static final int STATE_DOWNLOADING = 0;
        public static final int STATE_ERROR = 2;
        public static final int STATE_INITIALIZING = -1;
        public static final int STATE_UNINITIALIZED = -2;

        public Downloader() {
        }

        public final int getDownloadProgress() {
            if (!C10619a.m34838a()) {
                Logger.m35065a(InternalLogLevel.ERROR, InMobiNative.f31326a, "InMobiNative is not initialized.Ignoring getDownloadProgress()");
                return 0;
            }
            try {
                if (InMobiNative.this.f31332f != null) {
                    AdContainer j = InMobiNative.this.f31332f.mo34302j();
                    return (j == null || j.getApkDownloader() != null) ? 0 : 0;
                }
            } catch (Exception e) {
                Logger.m35065a(InternalLogLevel.ERROR, InMobiNative.f31326a, "Encountered unexpected error in getting download progress");
            }
            return 0;
        }

        public final int getDownloadStatus() {
            if (!C10619a.m34838a()) {
                Logger.m35065a(InternalLogLevel.ERROR, InMobiNative.f31326a, "InMobiNative is not initialized.Ignoring getDownloadStatus()");
                return -2;
            }
            try {
                if (InMobiNative.this.f31332f != null) {
                    AdContainer j = InMobiNative.this.f31332f.mo34302j();
                    return (j == null || j.getApkDownloader() != null) ? -2 : -2;
                }
            } catch (Exception e) {
                Logger.m35065a(InternalLogLevel.ERROR, InMobiNative.f31326a, "Encountered unexpected error in getting download progress");
            }
            return -2;
        }
    }

    public interface LockScreenListener {
        void onActionRequired(InMobiNative inMobiNative);
    }

    public interface NativeAdListener {
        void onAdClicked(InMobiNative inMobiNative);

        void onAdFullScreenDismissed(InMobiNative inMobiNative);

        void onAdFullScreenDisplayed(InMobiNative inMobiNative);

        void onAdFullScreenWillDisplay(InMobiNative inMobiNative);

        void onAdImpressed(InMobiNative inMobiNative);

        void onAdLoadFailed(InMobiNative inMobiNative, InMobiAdRequestStatus inMobiAdRequestStatus);

        void onAdLoadSucceeded(InMobiNative inMobiNative);

        void onAdStatusChanged(InMobiNative inMobiNative);

        void onMediaPlaybackComplete(InMobiNative inMobiNative);

        void onUserSkippedMedia(InMobiNative inMobiNative);

        void onUserWillLeaveApplication(InMobiNative inMobiNative);
    }

    public interface NativeAdRequestListener {
        void onAdRequestCompleted(InMobiAdRequestStatus inMobiAdRequestStatus, InMobiNative inMobiNative);
    }

    /* renamed from: com.inmobi.ads.InMobiNative$a */
    static final class C10323a extends Handler {

        /* renamed from: a */
        private WeakReference<InMobiNative> f31348a;

        C10323a(InMobiNative inMobiNative) {
            super(Looper.getMainLooper());
            this.f31348a = new WeakReference<>(inMobiNative);
        }

        public final void handleMessage(Message message) {
            InMobiNative inMobiNative = (InMobiNative) this.f31348a.get();
            if (inMobiNative == null) {
                Logger.m35065a(InternalLogLevel.ERROR, InMobiNative.f31326a, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            try {
                switch (message.what) {
                    case 1:
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onAdLoadSucceeded(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onAdLoadSucceeded(inMobiNative);
                            return;
                        }
                        break;
                    case 2:
                        InMobiAdRequestStatus inMobiAdRequestStatus = (InMobiAdRequestStatus) message.obj;
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onAdLoadFailed(inMobiNative, inMobiAdRequestStatus);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onAdLoadFailed(inMobiNative, inMobiAdRequestStatus);
                            return;
                        }
                        break;
                    case 3:
                        if (inMobiNative.f31341p != null) {
                            inMobiNative.f31341p.onActionRequired(inMobiNative);
                        }
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onAdFullScreenWillDisplay(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onAdFullScreenWillDisplay(inMobiNative);
                            return;
                        }
                        break;
                    case 4:
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onAdFullScreenDisplayed(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onAdFullScreenDisplayed(inMobiNative);
                            return;
                        }
                        break;
                    case 5:
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onAdFullScreenDismissed(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onAdFullScreenDismissed(inMobiNative);
                            return;
                        }
                        break;
                    case 6:
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onAdImpressed(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onAdImpressed(inMobiNative);
                            return;
                        }
                        break;
                    case 7:
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onAdClicked(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onAdClicked(inMobiNative);
                            return;
                        }
                        break;
                    case 8:
                        if (inMobiNative.f31341p != null) {
                            inMobiNative.f31341p.onActionRequired(inMobiNative);
                        }
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onUserWillLeaveApplication(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onUserWillLeaveApplication(inMobiNative);
                            return;
                        }
                        break;
                    case 9:
                        if (inMobiNative.f31331e != null) {
                            inMobiNative.f31331e.onVideoCompleted(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onMediaPlaybackComplete(inMobiNative);
                            return;
                        }
                        break;
                    case 10:
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onAdStatusChanged(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onAdStatusChanged(inMobiNative);
                            return;
                        }
                        break;
                    case 11:
                        if (inMobiNative.f31331e != null) {
                            inMobiNative.f31331e.onVideoSkipped(inMobiNative);
                            return;
                        } else if (inMobiNative.f31329c != null) {
                            inMobiNative.f31329c.onUserSkippedMedia(inMobiNative);
                            return;
                        }
                        break;
                    case 12:
                        byte[] bArr = (byte[]) message.obj;
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onRequestPayloadCreated(bArr);
                            return;
                        }
                        break;
                    case 13:
                        if (inMobiNative.f31330d != null) {
                            inMobiNative.f31330d.onRequestPayloadCreationFailed((InMobiAdRequestStatus) message.obj);
                            return;
                        }
                        break;
                    case 14:
                        if (inMobiNative.f31331e != null) {
                            inMobiNative.f31331e.onAudioStateChanged(inMobiNative, ((Boolean) message.obj).booleanValue());
                            return;
                        }
                        break;
                    default:
                        InMobiNative.f31326a;
                        break;
                }
            } catch (Exception e) {
                Logger.m35065a(InternalLogLevel.ERROR, InMobiNative.f31326a, "Publisher handler caused unexpected error");
                InMobiNative.f31326a;
                new StringBuilder("Callback threw unexpected error: ").append(e.getMessage());
            }
        }
    }

    /* synthetic */ InMobiNative(Context context, C10455bi biVar, byte b) {
        this(context, biVar);
    }

    @Deprecated
    public InMobiNative(Context context, long j, NativeAdListener nativeAdListener) {
        this.f31339n = true;
        this.f31343r = new C10575b() {
            /* renamed from: a */
            public final void mo33747a() {
                InMobiNative.this.m33667a("AR", "");
                InMobiNative.this.f31328b.sendEmptyMessage(1);
            }

            /* renamed from: a */
            public final void mo33748a(InMobiAdRequestStatus inMobiAdRequestStatus) {
                String str = "ART";
                switch (C103223.f31346a[inMobiAdRequestStatus.getStatusCode().ordinal()]) {
                    case 1:
                        InMobiNative.this.m33667a(str, "NetworkNotAvailable");
                        break;
                    case 2:
                    case 3:
                        InMobiNative.this.m33667a(str, "LoadInProgress");
                        break;
                    case 4:
                        InMobiNative.this.m33667a(str, "FrequentRequests");
                        break;
                    case 5:
                        InMobiNative.this.m33667a(str, "MissingRequiredDependencies");
                        break;
                    case 6:
                        InMobiNative.this.m33667a(str, "ReloadNotPermitted");
                        break;
                    case 7:
                        InMobiNative.this.m33667a(str, "MonetizationDisabled");
                        break;
                    default:
                        InMobiNative.this.m33667a("AF", "");
                        break;
                }
                if (!InMobiNative.m33672c()) {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = inMobiAdRequestStatus;
                    InMobiNative.this.f31328b.sendMessage(obtain);
                }
            }

            /* renamed from: b */
            public final void mo33783b() {
                InMobiNative.f31326a;
            }

            /* renamed from: c */
            public final void mo33784c() {
                InMobiNative.this.f31328b.sendEmptyMessage(3);
            }

            /* renamed from: d */
            public final void mo33753d() {
                InMobiNative.this.m33667a("AVE", "");
                InMobiNative.this.f31328b.sendEmptyMessage(4);
            }

            /* renamed from: e */
            public final void mo33754e() {
                InMobiNative.this.m33667a("AVCO", "");
                InMobiNative.this.f31328b.sendEmptyMessage(5);
            }

            /* renamed from: a */
            public final void mo33749a(Map<Object, Object> map) {
                InMobiNative.this.m33667a("AVCL", "");
                InMobiNative.this.f31328b.sendEmptyMessage(7);
            }

            /* renamed from: f */
            public final void mo33755f() {
                InMobiNative.this.f31328b.sendEmptyMessage(8);
            }

            /* renamed from: g */
            public final void mo33828g() {
                InMobiNative.this.f31328b.sendEmptyMessage(6);
            }

            /* renamed from: h */
            public final void mo33829h() {
                InMobiNative.this.f31328b.sendEmptyMessage(9);
            }

            /* renamed from: j */
            public final void mo33830j() {
                InMobiNative.this.f31328b.sendEmptyMessage(11);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public final void mo33750a(byte[] bArr) {
                Message obtain = Message.obtain();
                obtain.what = 12;
                obtain.obj = bArr;
                InMobiNative.this.f31328b.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public final void mo33751b(InMobiAdRequestStatus inMobiAdRequestStatus) {
                Message obtain = Message.obtain();
                obtain.what = 13;
                obtain.obj = inMobiAdRequestStatus;
                InMobiNative.this.f31328b.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public final void mo33827b(boolean z) {
                Message obtain = Message.obtain();
                obtain.what = 14;
                obtain.obj = Boolean.valueOf(z);
                InMobiNative.this.f31328b.sendMessage(obtain);
            }
        };
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please initialize the SDK before creating a Native ad");
        } else if (context == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Context is null, Native ad cannot be created.");
        } else if (nativeAdListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Listener supplied is null, the Native ad cannot be created.");
        } else {
            this.f31335i = j;
            this.f31340o = new WeakReference<>(context);
            this.f31329c = nativeAdListener;
            this.f31336k = new Downloader();
            this.f31328b = new C10323a(this);
        }
    }

    public InMobiNative(Context context, long j, NativeAdEventListener nativeAdEventListener) {
        this.f31339n = true;
        this.f31343r = new C10575b() {
            /* renamed from: a */
            public final void mo33747a() {
                InMobiNative.this.m33667a("AR", "");
                InMobiNative.this.f31328b.sendEmptyMessage(1);
            }

            /* renamed from: a */
            public final void mo33748a(InMobiAdRequestStatus inMobiAdRequestStatus) {
                String str = "ART";
                switch (C103223.f31346a[inMobiAdRequestStatus.getStatusCode().ordinal()]) {
                    case 1:
                        InMobiNative.this.m33667a(str, "NetworkNotAvailable");
                        break;
                    case 2:
                    case 3:
                        InMobiNative.this.m33667a(str, "LoadInProgress");
                        break;
                    case 4:
                        InMobiNative.this.m33667a(str, "FrequentRequests");
                        break;
                    case 5:
                        InMobiNative.this.m33667a(str, "MissingRequiredDependencies");
                        break;
                    case 6:
                        InMobiNative.this.m33667a(str, "ReloadNotPermitted");
                        break;
                    case 7:
                        InMobiNative.this.m33667a(str, "MonetizationDisabled");
                        break;
                    default:
                        InMobiNative.this.m33667a("AF", "");
                        break;
                }
                if (!InMobiNative.m33672c()) {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = inMobiAdRequestStatus;
                    InMobiNative.this.f31328b.sendMessage(obtain);
                }
            }

            /* renamed from: b */
            public final void mo33783b() {
                InMobiNative.f31326a;
            }

            /* renamed from: c */
            public final void mo33784c() {
                InMobiNative.this.f31328b.sendEmptyMessage(3);
            }

            /* renamed from: d */
            public final void mo33753d() {
                InMobiNative.this.m33667a("AVE", "");
                InMobiNative.this.f31328b.sendEmptyMessage(4);
            }

            /* renamed from: e */
            public final void mo33754e() {
                InMobiNative.this.m33667a("AVCO", "");
                InMobiNative.this.f31328b.sendEmptyMessage(5);
            }

            /* renamed from: a */
            public final void mo33749a(Map<Object, Object> map) {
                InMobiNative.this.m33667a("AVCL", "");
                InMobiNative.this.f31328b.sendEmptyMessage(7);
            }

            /* renamed from: f */
            public final void mo33755f() {
                InMobiNative.this.f31328b.sendEmptyMessage(8);
            }

            /* renamed from: g */
            public final void mo33828g() {
                InMobiNative.this.f31328b.sendEmptyMessage(6);
            }

            /* renamed from: h */
            public final void mo33829h() {
                InMobiNative.this.f31328b.sendEmptyMessage(9);
            }

            /* renamed from: j */
            public final void mo33830j() {
                InMobiNative.this.f31328b.sendEmptyMessage(11);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public final void mo33750a(byte[] bArr) {
                Message obtain = Message.obtain();
                obtain.what = 12;
                obtain.obj = bArr;
                InMobiNative.this.f31328b.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public final void mo33751b(InMobiAdRequestStatus inMobiAdRequestStatus) {
                Message obtain = Message.obtain();
                obtain.what = 13;
                obtain.obj = inMobiAdRequestStatus;
                InMobiNative.this.f31328b.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public final void mo33827b(boolean z) {
                Message obtain = Message.obtain();
                obtain.what = 14;
                obtain.obj = Boolean.valueOf(z);
                InMobiNative.this.f31328b.sendMessage(obtain);
            }
        };
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please initialize the SDK before creating a Native ad");
        } else if (context == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Context is null, Native ad cannot be created.");
        } else if (nativeAdEventListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Listener supplied is null, the Native ad cannot be created.");
        } else {
            this.f31335i = j;
            this.f31340o = new WeakReference<>(context);
            this.f31330d = nativeAdEventListener;
            this.f31336k = new Downloader();
            this.f31328b = new C10323a(this);
        }
    }

    private InMobiNative(Context context, C10455bi biVar) {
        this.f31339n = true;
        this.f31343r = new C10575b() {
            /* renamed from: a */
            public final void mo33747a() {
                InMobiNative.this.m33667a("AR", "");
                InMobiNative.this.f31328b.sendEmptyMessage(1);
            }

            /* renamed from: a */
            public final void mo33748a(InMobiAdRequestStatus inMobiAdRequestStatus) {
                String str = "ART";
                switch (C103223.f31346a[inMobiAdRequestStatus.getStatusCode().ordinal()]) {
                    case 1:
                        InMobiNative.this.m33667a(str, "NetworkNotAvailable");
                        break;
                    case 2:
                    case 3:
                        InMobiNative.this.m33667a(str, "LoadInProgress");
                        break;
                    case 4:
                        InMobiNative.this.m33667a(str, "FrequentRequests");
                        break;
                    case 5:
                        InMobiNative.this.m33667a(str, "MissingRequiredDependencies");
                        break;
                    case 6:
                        InMobiNative.this.m33667a(str, "ReloadNotPermitted");
                        break;
                    case 7:
                        InMobiNative.this.m33667a(str, "MonetizationDisabled");
                        break;
                    default:
                        InMobiNative.this.m33667a("AF", "");
                        break;
                }
                if (!InMobiNative.m33672c()) {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = inMobiAdRequestStatus;
                    InMobiNative.this.f31328b.sendMessage(obtain);
                }
            }

            /* renamed from: b */
            public final void mo33783b() {
                InMobiNative.f31326a;
            }

            /* renamed from: c */
            public final void mo33784c() {
                InMobiNative.this.f31328b.sendEmptyMessage(3);
            }

            /* renamed from: d */
            public final void mo33753d() {
                InMobiNative.this.m33667a("AVE", "");
                InMobiNative.this.f31328b.sendEmptyMessage(4);
            }

            /* renamed from: e */
            public final void mo33754e() {
                InMobiNative.this.m33667a("AVCO", "");
                InMobiNative.this.f31328b.sendEmptyMessage(5);
            }

            /* renamed from: a */
            public final void mo33749a(Map<Object, Object> map) {
                InMobiNative.this.m33667a("AVCL", "");
                InMobiNative.this.f31328b.sendEmptyMessage(7);
            }

            /* renamed from: f */
            public final void mo33755f() {
                InMobiNative.this.f31328b.sendEmptyMessage(8);
            }

            /* renamed from: g */
            public final void mo33828g() {
                InMobiNative.this.f31328b.sendEmptyMessage(6);
            }

            /* renamed from: h */
            public final void mo33829h() {
                InMobiNative.this.f31328b.sendEmptyMessage(9);
            }

            /* renamed from: j */
            public final void mo33830j() {
                InMobiNative.this.f31328b.sendEmptyMessage(11);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public final void mo33750a(byte[] bArr) {
                Message obtain = Message.obtain();
                obtain.what = 12;
                obtain.obj = bArr;
                InMobiNative.this.f31328b.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public final void mo33751b(InMobiAdRequestStatus inMobiAdRequestStatus) {
                Message obtain = Message.obtain();
                obtain.what = 13;
                obtain.obj = inMobiAdRequestStatus;
                InMobiNative.this.f31328b.sendMessage(obtain);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public final void mo33827b(boolean z) {
                Message obtain = Message.obtain();
                obtain.what = 14;
                obtain.obj = Boolean.valueOf(z);
                InMobiNative.this.f31328b.sendMessage(obtain);
            }
        };
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please initialize the SDK before creating an InMobiNative ad");
        } else if (context == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Context is null, Native ad cannot be created.");
        } else {
            this.f31332f = C10396aj.m34024a(context, biVar, this.f31343r, 0);
            this.f31335i = biVar.f31801a;
            this.f31340o = new WeakReference<>(context);
            this.f31328b = new C10323a(this);
        }
    }

    @Deprecated
    public final void setNativeAdListener(NativeAdListener nativeAdListener) {
        this.f31329c = nativeAdListener;
    }

    public final void setListener(NativeAdEventListener nativeAdEventListener) {
        if (nativeAdEventListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please pass a non-null listener to the native.");
        } else {
            this.f31330d = nativeAdEventListener;
        }
    }

    public final void setVideoEventListener(VideoEventListener videoEventListener) {
        if (videoEventListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please pass a non-null listener to the native.");
        } else {
            this.f31331e = videoEventListener;
        }
    }

    /* renamed from: a */
    private boolean m33668a(boolean z) {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized, your call is ignored.");
        } else if (!z ? this.f31330d != null : !(this.f31343r == null && this.f31330d == null)) {
            WeakReference<Context> weakReference = this.f31340o;
            if (weakReference != null && weakReference.get() != null) {
                return true;
            }
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Context supplied is null, your call is ignored.");
        } else {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Listener supplied is null, your call is ignored.");
        }
        return false;
    }

    public final void getSignals() {
        if (m33668a(false)) {
            m33674d();
            m33667a("ARR", "");
            C10396aj ajVar = this.f31332f;
            if (ajVar != null) {
                ajVar.mo34303o();
            }
        }
    }

    public final void load(byte[] bArr) {
        if (m33668a(false)) {
            C10396aj ajVar = this.f31332f;
            if (ajVar == null) {
                Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Either getSignals() is not called or InMobiNative is not initialized, your call is ignored.");
                return;
            }
            ajVar.mo34291a(bArr);
        }
    }

    /* renamed from: d */
    private void m33674d() {
        WeakReference<Context> weakReference = this.f31340o;
        Context context = weakReference == null ? null : (Context) weakReference.get();
        if (context != null) {
            C10396aj ajVar = this.f31332f;
            if (ajVar == null) {
                C10455bi a = C10455bi.m34229a(this.f31335i, this.f31334h, "native", this.f31333g);
                a.f31806f = context instanceof Activity ? MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY : MonetizationContext.MONETIZATION_CONTEXT_OTHER;
                this.f31332f = C10396aj.m34024a(context, a, this.f31343r, 0);
            } else {
                ajVar.mo34080a(context);
                this.f31332f.mo33972a(context instanceof Activity ? MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY : MonetizationContext.MONETIZATION_CONTEXT_OTHER);
            }
            C10396aj ajVar2 = this.f31332f;
            ajVar2.f32178n = false;
            ajVar2.f32169e = this.f31333g;
            ajVar2.f32170f = this.f31334h;
        }
    }

    public final void load() {
        String str = "native";
        try {
            if (m33668a(true)) {
                String str2 = "";
                String str3 = "ARR";
                if (this.f31338m) {
                    m33667a(str3, str2);
                    this.f31343r.mo33748a(new InMobiAdRequestStatus(StatusCode.REPETITIVE_LOAD));
                    Logger.m35065a(InternalLogLevel.ERROR, f31326a, "You can call load() on an instance of InMobiNative only once if the ad request has been successful. Ignoring InMobiNative.load()");
                    return;
                }
                m33674d();
                if (this.f31332f != null) {
                    m33667a(str3, str2);
                    C10455bi a = C10455bi.m34229a(this.f31335i, this.f31334h, str, this.f31333g);
                    a.f31806f = this.f31332f.mo33991l();
                    this.f31332f.mo33992n();
                    C10491a.m34323a(str).mo34211a(a);
                }
            }
        } catch (Exception e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not load ad; SDK encountered an unexpected error");
            new StringBuilder("SDK encountered unexpected error in loading ad; ").append(e.getMessage());
        }
    }

    public final void load(Context context) {
        if (m33668a(true)) {
            this.f31340o = new WeakReference<>(context);
            load();
        }
    }

    @Deprecated
    public static void requestAd(Context context, InMobiAdRequest inMobiAdRequest, NativeAdRequestListener nativeAdRequestListener) {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please initialize the SDK before calling requestAd. Ignoring request");
        } else if (nativeAdRequestListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please supply a non null NativeAdRequestListener. Ignoring request");
        } else if (inMobiAdRequest == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please supply a non null InMobiAdRequest. Ignoring request");
        } else if (context == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please supply a non null Context. Ignoring request");
        } else {
            try {
                RecyclerView.class.getName();
                Picasso.class.getName();
                final C10455bi a = C10455bi.m34229a(inMobiAdRequest.f31254a, inMobiAdRequest.f31259f, "native", inMobiAdRequest.f31258e);
                a.f31806f = inMobiAdRequest.f31255b;
                C103201 r2 = new C10578e() {
                    /* renamed from: a */
                    public final void mo33744a(C10545i iVar) {
                        if (iVar instanceof C10396aj) {
                            try {
                                C10491a.f31975a.remove(a);
                                WeakReference weakReference = (WeakReference) InMobiNative.f31327j.get(iVar);
                                if (weakReference != null) {
                                    InMobiNative.f31327j.remove(iVar);
                                    NativeAdRequestListener nativeAdRequestListener = (NativeAdRequestListener) weakReference.get();
                                    if (nativeAdRequestListener != null) {
                                        C10455bi a = C10455bi.m34229a(iVar.f32168d, iVar.f32170f, "native", iVar.f32169e);
                                        a.f31806f = iVar.mo33991l();
                                        InMobiNative inMobiNative = new InMobiNative(iVar.mo34283a(), a, 0);
                                        inMobiNative.setKeywords(iVar.f32169e);
                                        inMobiNative.setExtras(iVar.f32170f);
                                        nativeAdRequestListener.onAdRequestCompleted(new InMobiAdRequestStatus(StatusCode.NO_ERROR), inMobiNative);
                                    }
                                }
                            } catch (Exception e) {
                                InMobiNative.f31326a;
                                new StringBuilder("SDK encountered unexpected error in onAdPrefetchSucceeded ").append(e.getMessage());
                            }
                        }
                    }

                    /* renamed from: a */
                    public final void mo33745a(C10545i iVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
                        if (iVar instanceof C10396aj) {
                            try {
                                C10491a.f31975a.remove(a);
                                WeakReference weakReference = (WeakReference) InMobiNative.f31327j.get(iVar);
                                if (weakReference != null) {
                                    InMobiNative.f31327j.remove(iVar);
                                    NativeAdRequestListener nativeAdRequestListener = (NativeAdRequestListener) weakReference.get();
                                    if (nativeAdRequestListener != null) {
                                        nativeAdRequestListener.onAdRequestCompleted(inMobiAdRequestStatus, null);
                                    }
                                }
                            } catch (Exception e) {
                                InMobiNative.f31326a;
                                new StringBuilder("SDK encountered unexpected error in onAdPrefetchFailed ").append(e.getMessage());
                            }
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
                    C10396aj a2 = C10396aj.m34024a(context.getApplicationContext(), a, null, 2);
                    a2.f32170f = inMobiAdRequest.f31259f;
                    a2.f32169e = inMobiAdRequest.f31258e;
                    a2.f32181q = r2;
                    a2.f32178n = true;
                    f31327j.put(a2, new WeakReference(nativeAdRequestListener));
                    a2.mo33993q();
                } catch (Exception e2) {
                    new StringBuilder("SDK encountered unexpected error in requestAd").append(e2.getMessage());
                }
            } catch (NoClassDefFoundError e3) {
                Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Some of the dependency libraries for InMobiNative not found. Ignoring request");
                nativeAdRequestListener.onAdRequestCompleted(new InMobiAdRequestStatus(StatusCode.MISSING_REQUIRED_DEPENDENCIES), null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33667a(String str, String str2) {
        if (this.f31342q == null) {
            this.f31342q = new C10580k(this.f31332f);
        }
        this.f31342q.mo34335a(this.f31343r, str, str2);
    }

    public final void showOnLockScreen(LockScreenListener lockScreenListener) {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please initialize the SDK before calling showOnLockScreen.");
        } else if (lockScreenListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please provided non null LockScreenListener. Ignoring showOnLockScreen");
        } else {
            WeakReference<Context> weakReference = this.f31340o;
            if (weakReference == null || weakReference.get() == null) {
                Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized. Provided context is null. Ignoring showOnLockScreen");
                return;
            }
            try {
                if (this.f31332f == null) {
                    this.f31332f = C10396aj.m34024a((Context) this.f31340o.get(), C10455bi.m34229a(this.f31335i, this.f31334h, "native", this.f31333g), this.f31343r, 0);
                }
                this.f31332f.f31598A = true;
                this.f31341p = lockScreenListener;
            } catch (Exception e) {
                Logger.m35065a(InternalLogLevel.ERROR, f31326a, "SDK encountered unexpected error in showOnLockScreen");
            }
        }
    }

    public final void takeAction() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Please initialize the SDK before calling takeAction.");
            return;
        }
        try {
            if (this.f31332f != null) {
                C10396aj ajVar = this.f31332f;
                if (ajVar.f32179o != null) {
                    ajVar.f32179o.mo34040r();
                }
                return;
            }
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized. Ignoring takeAction");
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "SDK encountered unexpected error in takeAction");
        }
    }

    public final void pause() {
        try {
            if (this.f31332f != null) {
                C10396aj ajVar = this.f31332f;
                if (ajVar.f32165a == 5 && !(ajVar.mo34283a() instanceof Activity)) {
                    AdContainer j = ajVar.mo34302j();
                    if (j != null) {
                        ((C10380ah) j).mo34039q();
                    }
                }
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not pause ad; SDK encountered an unexpected error");
            new StringBuilder("SDK encountered unexpected error in pausing ad; ").append(e.getMessage());
        }
    }

    public final void resume() {
        try {
            if (this.f31332f != null) {
                C10396aj ajVar = this.f31332f;
                if (ajVar.f32165a == 5 && !(ajVar.mo34283a() instanceof Activity)) {
                    AdContainer j = ajVar.mo34302j();
                    if (j != null) {
                        ((C10380ah) j).mo34038p();
                    }
                }
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not resume ad; SDK encountered an unexpected error");
            new StringBuilder("SDK encountered unexpected error in resuming ad; ").append(e.getMessage());
        }
    }

    public final View getPrimaryViewOfWidth(Context context, View view, ViewGroup viewGroup, int i) {
        View view2;
        String str = "";
        try {
            if (!C10619a.m34838a()) {
                Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiSdk is not initialized. Ignoring InMobiNative.getPrimaryView()");
                return null;
            } else if (context == null) {
                Logger.m35065a(InternalLogLevel.ERROR, f31326a, "View can not be rendered using null context");
                return null;
            } else if (this.f31332f == null) {
                Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized. Ignoring InMobiNative.getPrimaryView()");
                return null;
            } else {
                this.f31340o = new WeakReference<>(context);
                this.f31332f.mo34080a(context);
                C10396aj ajVar = this.f31332f;
                boolean z = this.f31339n;
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    Logger.m35065a(InternalLogLevel.ERROR, InMobiNative.class.getSimpleName(), "Please ensure that you call getPrimaryView() on the UI thread");
                    view2 = null;
                } else if (!C10694e.m35115e()) {
                    ajVar.mo33969O();
                    view2 = null;
                } else if (ajVar.mo34079P() || ajVar.f32165a == 7) {
                    C10380ah ahVar = ajVar.f32179o;
                    if (ahVar != null) {
                        ahVar.f31572u = ajVar.f31598A;
                        ahVar.f31570s = i;
                        ahVar.f31571t = z;
                        C10503ca viewableAd = ahVar.getViewableAd();
                        view2 = viewableAd.mo33956a(view, viewGroup, true);
                        ajVar.f31602z = new WeakReference<>(view2);
                        if (ajVar.f32182r != 0 || ajVar.f32184t) {
                            viewableAd.mo33959a(new View[0]);
                        } else {
                            ajVar.f32183s.post(new Runnable(viewableAd) {

                                /* renamed from: a */
                                final /* synthetic */ C10503ca f31605a;

                                {
                                    this.f31605a = r2;
                                }

                                public final void run() {
                                    this.f31605a.mo33959a(new View[0]);
                                }
                            });
                        }
                    } else {
                        view2 = null;
                    }
                } else {
                    Logger.m35065a(InternalLogLevel.ERROR, C10396aj.f31597y, "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling getPrimaryView().");
                    if (ajVar.f31602z != null) {
                        View view3 = (View) ajVar.f31602z.get();
                        if (view3 != null) {
                            View view4 = new View(C10619a.m34839b());
                            view4.setLayoutParams(view3.getLayoutParams());
                            view2 = view4;
                        } else {
                            view2 = null;
                        }
                    } else {
                        view2 = null;
                    }
                }
                this.f31337l = new WeakReference<>(view2);
                View view5 = (View) this.f31337l.get();
                m33667a("AVR", str);
                if (view5 == null) {
                    if (this.f31332f.mo34079P()) {
                        m33667a("AVFB", str);
                    } else {
                        m33667a("AVRR", str);
                    }
                    C10659b.m34983a();
                    C10659b.m34987a("ads", "PrimaryViewInflationFailed", new HashMap());
                    return null;
                }
                m33667a("AVD", str);
                this.f31338m = true;
                return view5;
            }
        } catch (Exception e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not pause ad; SDK encountered an unexpected error");
            new StringBuilder("SDK encountered unexpected error in pausing ad; ").append(e.getMessage());
            return null;
        }
    }

    @Deprecated
    public final View getPrimaryViewOfWidth(View view, ViewGroup viewGroup, int i) {
        WeakReference<Context> weakReference = this.f31340o;
        if (weakReference != null && weakReference.get() != null) {
            return getPrimaryViewOfWidth((Context) this.f31340o.get(), view, viewGroup, i);
        }
        Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized or provided context is null.");
        return null;
    }

    public final JSONObject getCustomAdContent() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.setExtras()");
            return null;
        }
        try {
            if (this.f31332f != null) {
                AdContainer j = this.f31332f.mo34302j();
                if (j != null) {
                    C10406ao aoVar = (C10406ao) j.getDataModel();
                    if (aoVar != null) {
                        return aoVar.f31659i.f31670a;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not get the ad customJson ; SDK encountered unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return null;
    }

    public final String getAdTitle() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdTitle()");
            return null;
        }
        try {
            if (this.f31332f != null) {
                AdContainer j = this.f31332f.mo34302j();
                if (j != null) {
                    C10406ao aoVar = (C10406ao) j.getDataModel();
                    if (aoVar != null) {
                        return aoVar.f31659i.f31671b.f31674a;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not get the ad title; SDK encountered unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return null;
    }

    public final String getAdDescription() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdDescription()");
            return null;
        }
        try {
            if (this.f31332f != null) {
                AdContainer j = this.f31332f.mo34302j();
                if (j != null) {
                    C10406ao aoVar = (C10406ao) j.getDataModel();
                    if (aoVar != null) {
                        return aoVar.f31659i.f31671b.f31675b;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not get the description; SDK encountered unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return null;
    }

    public final String getAdIconUrl() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdIconUrl()");
            return null;
        }
        try {
            if (this.f31332f != null) {
                AdContainer j = this.f31332f.mo34302j();
                if (j != null) {
                    C10406ao aoVar = (C10406ao) j.getDataModel();
                    if (aoVar != null) {
                        return aoVar.f31659i.f31671b.f31676c;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not get the iconUrl; SDK encountered unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return null;
    }

    public final String getAdLandingPageUrl() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdLandingPageUrl()");
            return null;
        }
        try {
            if (this.f31332f != null) {
                AdContainer j = this.f31332f.mo34302j();
                if (j != null) {
                    C10406ao aoVar = (C10406ao) j.getDataModel();
                    if (aoVar != null) {
                        return aoVar.f31659i.f31671b.f31679f;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not get the adLandingPageUrl; SDK encountered unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return null;
    }

    public final String getAdCtaText() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdCtaText()");
            return null;
        }
        try {
            if (this.f31332f != null) {
                AdContainer j = this.f31332f.mo34302j();
                if (j != null) {
                    C10406ao aoVar = (C10406ao) j.getDataModel();
                    if (aoVar != null) {
                        return aoVar.f31659i.f31671b.f31677d;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not get the ctaText; SDK encountered unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return null;
    }

    public final float getAdRating() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.getAdRating()");
            return 0.0f;
        }
        try {
            if (this.f31332f != null) {
                AdContainer j = this.f31332f.mo34302j();
                if (j != null) {
                    C10406ao aoVar = (C10406ao) j.getDataModel();
                    if (aoVar != null) {
                        return aoVar.f31659i.f31671b.f31678e;
                    }
                }
                return 0.0f;
            }
        } catch (Exception e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not get rating; SDK encountered an unexpected error");
            new StringBuilder("SDK encountered unexpected error in getAdRating(); ").append(e.getMessage());
        }
        return 0.0f;
    }

    public final boolean isAppDownload() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.isAppDownload()");
            return false;
        }
        try {
            if (this.f31332f != null) {
                AdContainer j = this.f31332f.mo34302j();
                if (j != null) {
                    C10406ao aoVar = (C10406ao) j.getDataModel();
                    if (aoVar != null) {
                        return aoVar.f31659i.f31671b.f31680g;
                    }
                }
                return false;
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not get isAppDownload; SDK encountered unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return false;
    }

    public final void reportAdClickAndOpenLandingPage() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.reportAdClickAndOpenLandingPage()");
            return;
        }
        try {
            if (this.f31332f != null) {
                AdContainer j = this.f31332f.mo34302j();
                if (j != null) {
                    C10380ah ahVar = (C10380ah) j;
                    C10406ao h = ahVar.mo34023h();
                    if (h != null) {
                        ahVar.mo34010a((View) null, h.f31659i.f31672c);
                        ahVar.mo34013a(h.f31659i.f31672c, true);
                    }
                }
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "reportAdClickAndOpenLandingPage failed; SDK encountered unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    public final boolean isReady() {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.isReady()");
            return false;
        }
        C10396aj ajVar = this.f31332f;
        if (ajVar == null || !ajVar.mo34079P()) {
            return false;
        }
        return true;
    }

    public final JSONObject getAdMetaInfo() {
        if (C10619a.m34838a()) {
            C10396aj ajVar = this.f31332f;
            if (ajVar != null) {
                return ajVar.f32173i;
            }
        }
        return new JSONObject();
    }

    public final void setExtras(Map<String, String> map) {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.setExtras()");
            return;
        }
        try {
            if (this.f31332f != null) {
                this.f31332f.f32170f = map;
            }
            this.f31334h = map;
        } catch (Exception e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not set extras; SDK encountered an unexpected error");
            new StringBuilder("SDK encountered unexpected error in setting extras ").append(e.getMessage());
        }
    }

    public final void setKeywords(String str) {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized.Ignoring InMobiNative.setKeywords()");
            return;
        }
        try {
            if (this.f31332f != null) {
                this.f31332f.f32169e = str;
            }
            this.f31333g = str;
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Could not set keywords on Native ad; SDK encountered unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
            new StringBuilder("SDK encountered unexpected error in setting keywords; ").append(e.getMessage());
        }
    }

    public final void destroy() {
        try {
            if (!C10619a.m34838a()) {
                Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized. Ignoring InMobiNative.destroy()");
            }
            if (this.f31328b != null) {
                this.f31328b.removeMessages(0);
            }
            View view = this.f31337l == null ? null : (View) this.f31337l.get();
            if (view != null) {
                ((ViewGroup) view).removeAllViews();
            }
            if (this.f31332f != null) {
                this.f31332f.mo33969O();
            }
            if (this.f31342q != null) {
                this.f31342q = null;
            }
            this.f31332f = null;
            this.f31329c = null;
            this.f31330d = null;
            this.f31331e = null;
            this.f31336k = null;
            this.f31338m = false;
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Failed to destroy ad; SDK encountered an unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    public final void setDownloaderEnabled(boolean z) {
        this.f31339n = z;
    }

    public final Downloader getDownloader() {
        try {
            if (C10619a.m34838a()) {
                return this.f31336k;
            }
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "InMobiNative is not initialized. Ignoring InMobiNative.getDownloader()");
            return null;
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31326a, "Failed to get Downloader; SDK encountered an unexpected error");
            C10621a.m34854a().mo34423a(new C10658a(e));
            return null;
        }
    }

    public final String getCreativeId() {
        if (C10619a.m34838a()) {
            C10396aj ajVar = this.f31332f;
            if (ajVar != null) {
                return ajVar.f32188x;
            }
        }
        return "";
    }

    /* renamed from: c */
    static /* synthetic */ boolean m33672c() {
        return Message.obtain() == null;
    }
}
