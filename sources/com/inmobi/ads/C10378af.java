package com.inmobi.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.C10478c.C10490l;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.moat.analytics.mobile.inm.MoatAdEvent;
import com.moat.analytics.mobile.inm.MoatAdEventType;
import com.moat.analytics.mobile.inm.ReactiveVideoTracker;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.af */
/* compiled from: MoatTrackedNativeVideoAd */
class C10378af extends C10477bz {

    /* renamed from: d */
    private static final String f31530d = C10378af.class.getSimpleName();

    /* renamed from: e */
    private final WeakReference<Activity> f31531e;

    /* renamed from: f */
    private ReactiveVideoTracker f31532f;

    /* renamed from: g */
    private Map<String, Object> f31533g;

    /* renamed from: h */
    private C10503ca f31534h;

    /* renamed from: i */
    private boolean f31535i = false;

    C10378af(Activity activity, C10503ca caVar, C10445bd bdVar, Map<String, Object> map) {
        super(bdVar);
        this.f31531e = new WeakReference<>(activity);
        this.f31534h = caVar;
        this.f31533g = map;
        this.f31532f = (ReactiveVideoTracker) map.get("moatTracker");
    }

    /* renamed from: a */
    public final View mo33956a(View view, ViewGroup viewGroup, boolean z) {
        return this.f31534h.mo33956a(view, viewGroup, z);
    }

    /* renamed from: b */
    public final View mo33960b() {
        return this.f31534h.mo33960b();
    }

    /* renamed from: c */
    public final C10478c mo33961c() {
        return this.f31534h.mo33961c();
    }

    /* renamed from: a */
    public final void mo33959a(View... viewArr) {
        try {
            Activity activity = (Activity) this.f31531e.get();
            C10490l lVar = this.f31534h.mo33961c().f31899k;
            if (activity != null && (this.f32007a instanceof C10445bd) && lVar.f31972i && ((Boolean) this.f31533g.get("enabled")).booleanValue() && this.f31532f == null) {
                this.f31532f = C10613z.m34817a(activity.getApplication(), (String) this.f31533g.get("partnerCode"));
                this.f31533g.put("moatTracker", this.f31532f);
                this.f31535i = true;
            }
        } catch (Exception e) {
            new StringBuilder("Exception in startTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31534h.mo33959a(viewArr);
            throw th;
        }
        this.f31534h.mo33959a(viewArr);
    }

    /* renamed from: d */
    public final void mo33962d() {
        try {
            if (!((C10445bd) this.f32007a).mo34024i() && this.f31532f != null) {
                this.f31532f.stopTracking();
            }
        } catch (Exception e) {
            new StringBuilder("Exception in stopTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31534h.mo33962d();
            throw th;
        }
        this.f31534h.mo33962d();
    }

    @SuppressLint({"SwitchIntDef"})
    /* renamed from: a */
    public final void mo33957a(int i) {
        String str = "zMoatVASTIDs";
        try {
            if (this.f31532f != null) {
                StringBuilder sb = new StringBuilder("Received event : ");
                sb.append(i);
                sb.append(" for VideoTracker(");
                sb.append(this.f31532f.hashCode());
                sb.append(")");
                switch (i) {
                    case 1:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_ENTER_FULLSCREEN));
                        break;
                    case 2:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_EXIT_FULLSCREEN));
                        break;
                    case 3:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_STOPPED));
                        break;
                    case 5:
                    case 16:
                        NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) this.f32007a.getVideoContainerView();
                        if (!(nativeVideoWrapper == null || this.f31532f == null)) {
                            NativeVideoView videoView = nativeVideoWrapper.getVideoView();
                            if (this.f31535i) {
                                ReactiveVideoTracker reactiveVideoTracker = this.f31532f;
                                HashMap a = C10577d.m34706a("level", "slicer", (JSONArray) this.f31533g.get("clientLevels"), (JSONArray) this.f31533g.get("clientSlicers"), (JSONObject) this.f31533g.get("zMoatExtras"));
                                a.put(str, (String) this.f31533g.get(str));
                                reactiveVideoTracker.trackVideoAd(a, Integer.valueOf(videoView.getDuration()), nativeVideoWrapper);
                                this.f31535i = false;
                                break;
                            } else {
                                this.f31532f.changeTargetView(nativeVideoWrapper);
                            }
                        }
                        break;
                    case 6:
                        NativeVideoWrapper nativeVideoWrapper2 = (NativeVideoWrapper) this.f32007a.getVideoContainerView();
                        if (nativeVideoWrapper2 != null) {
                            this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_START, Integer.valueOf(nativeVideoWrapper2.getVideoView().getMediaPlayer().getCurrentPosition())));
                            break;
                        }
                        break;
                    case 7:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_PAUSED));
                        break;
                    case 8:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_PLAYING));
                        break;
                    case 9:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_FIRST_QUARTILE));
                        break;
                    case 10:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_MID_POINT));
                        break;
                    case 11:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_THIRD_QUARTILE));
                        break;
                    case 12:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
                        break;
                    case 13:
                        this.f31532f.setPlayerVolume(MoatAdEvent.VOLUME_MUTED);
                        break;
                    case 14:
                        this.f31532f.setPlayerVolume(MoatAdEvent.VOLUME_UNMUTED);
                        break;
                    case 15:
                        this.f31532f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_SKIPPED));
                        break;
                }
            }
        } catch (Exception e) {
            new StringBuilder("Exception in onAdEvent with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31534h.mo33957a(i);
            throw th;
        }
        this.f31534h.mo33957a(i);
    }

    /* renamed from: a */
    public final void mo33958a(Context context, int i) {
        this.f31534h.mo33958a(context, i);
    }

    /* renamed from: e */
    public final void mo33963e() {
        this.f31532f = null;
        this.f31531e.clear();
        super.mo33963e();
        this.f31534h.mo33963e();
    }
}
