package com.inmobi.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.moat.analytics.mobile.inm.NativeDisplayTracker;
import com.moat.analytics.mobile.inm.NativeDisplayTracker.MoatUserInteractionType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.ae */
/* compiled from: MoatTrackedNativeV2DisplayAd */
class C10376ae extends C10477bz {

    /* renamed from: d */
    private final String f31524d = C10376ae.class.getSimpleName();

    /* renamed from: e */
    private final WeakReference<Activity> f31525e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public NativeDisplayTracker f31526f;

    /* renamed from: g */
    private Map<String, Object> f31527g;

    /* renamed from: h */
    private C10503ca f31528h;

    C10376ae(Activity activity, C10503ca caVar, Map<String, Object> map) {
        this.f31525e = new WeakReference<>(activity);
        this.f31528h = caVar;
        this.f31527g = map;
    }

    /* renamed from: a */
    public final View mo34004a() {
        return this.f31528h.mo34004a();
    }

    /* renamed from: a */
    public final View mo33956a(View view, ViewGroup viewGroup, boolean z) {
        return this.f31528h.mo33956a(view, viewGroup, z);
    }

    /* renamed from: b */
    public final View mo33960b() {
        return this.f31528h.mo33960b();
    }

    /* renamed from: f */
    public final C10504a mo33964f() {
        return this.f31528h.mo33964f();
    }

    /* renamed from: c */
    public final C10478c mo33961c() {
        return this.f31528h.mo33961c();
    }

    /* renamed from: a */
    public final void mo33959a(View... viewArr) {
        try {
            View b = this.f31528h.mo33960b();
            if (b == null) {
                this.f31528h.mo33959a(viewArr);
                return;
            }
            Activity activity = (Activity) this.f31525e.get();
            if (this.f31528h.mo33961c().f31899k.f31972i && activity != null && ((Boolean) this.f31527g.get("enabled")).booleanValue()) {
                String str = "zMoatIID";
                if (this.f31526f == null) {
                    Application application = activity.getApplication();
                    String str2 = (String) this.f31527g.get("partnerCode");
                    HashMap a = C10577d.m34706a("moatClientLevel", "moatClientSlicer", (JSONArray) this.f31527g.get("clientLevels"), (JSONArray) this.f31527g.get("clientSlicers"), (JSONObject) this.f31527g.get("zMoatExtras"));
                    a.put(str, (String) this.f31527g.get(str));
                    this.f31526f = C10613z.m34816a(application, str2, b, a);
                }
                b.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        C10376ae.this.f31526f.reportUserInteractionEvent(MoatUserInteractionType.TOUCH);
                        StringBuilder sb = new StringBuilder("Received touch event for DisplayTracker(");
                        sb.append(C10376ae.this.f31526f.hashCode());
                        sb.append(")");
                        return true;
                    }
                });
                this.f31526f.startTracking();
                new StringBuilder("Moat initialized for Native Display for ID : ").append(this.f31527g.get(str));
            }
            this.f31528h.mo33959a(viewArr);
        } catch (Exception e) {
            new StringBuilder("Exception in startTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31528h.mo33959a(viewArr);
            throw th;
        }
    }

    /* renamed from: d */
    public final void mo33962d() {
        try {
            if (this.f31526f != null) {
                this.f31526f.stopTracking();
                new StringBuilder("Moat stopped tracking for Native Display for ID : ").append(this.f31527g.get("zMoatIID"));
            }
        } catch (Exception e) {
            new StringBuilder("Exception in stopTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31528h.mo33962d();
            throw th;
        }
        this.f31528h.mo33962d();
    }

    /* renamed from: a */
    public final void mo33957a(int i) {
        if (4 == i) {
            try {
                this.f31526f.reportUserInteractionEvent(MoatUserInteractionType.CLICK);
                StringBuilder sb = new StringBuilder("Received click event for DisplayTracker(");
                sb.append(this.f31526f.hashCode());
                sb.append(")");
            } catch (Exception e) {
                new StringBuilder("Exception in onAdEvent with message : ").append(e.getMessage());
                C10621a.m34854a().mo34423a(new C10658a(e));
            } catch (Throwable th) {
                this.f31528h.mo33957a(i);
                throw th;
            }
        }
        this.f31528h.mo33957a(i);
    }

    /* renamed from: a */
    public final void mo33958a(Context context, int i) {
        this.f31528h.mo33958a(context, i);
    }

    /* renamed from: e */
    public final void mo33963e() {
        this.f31526f = null;
        this.f31525e.clear();
        super.mo33963e();
        this.f31528h.mo33963e();
    }
}
