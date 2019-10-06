package com.inmobi.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10380ah.C10390c;
import com.inmobi.rendering.RenderView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.ads.at */
/* compiled from: NativeInflater */
public class C10415at extends C10504a implements C10430b {

    /* renamed from: b */
    private static final String f31697b = C10415at.class.getSimpleName();

    /* renamed from: a */
    final C10419au f31698a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C10380ah f31699c;

    /* renamed from: d */
    private final C10431c f31700d = new C10431c() {
        /* renamed from: a */
        public final void mo34115a(int i, C10400ak akVar) {
            if (!C10415at.this.mo34114b()) {
                C10415at.this.f31699c.mo34007a(i, akVar);
            }
        }
    };

    /* renamed from: e */
    private final C10429a f31701e = new C10429a() {
        /* renamed from: a */
        public final void mo34116a(View view, C10400ak akVar) {
            if (!C10415at.this.mo34114b()) {
                C10415at.this.f31699c.mo34010a(view, akVar);
                C10415at.this.f31699c.mo34013a(akVar, false);
            }
        }
    };

    /* renamed from: f */
    private final C10452bg f31702f = new C10452bg() {
        /* renamed from: a */
        public final void mo34118a(NativeVideoView nativeVideoView) {
            if (!C10415at.this.mo34114b() && (C10415at.this.f31699c instanceof C10445bd)) {
                C10445bd bdVar = (C10445bd) C10415at.this.f31699c;
                nativeVideoView.setIsLockScreen(bdVar.f31572u);
                NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) nativeVideoView.getParent();
                bdVar.f31775B = new WeakReference<>(nativeVideoWrapper);
                NativeVideoController mediaController = nativeVideoWrapper.getVideoView().getMediaController();
                if (mediaController != null) {
                    mediaController.setVideoAd(bdVar);
                }
            }
        }

        /* renamed from: a */
        public final void mo34120a(C10449be beVar, int i) {
            if (!C10415at.this.mo34114b() && (C10415at.this.f31699c instanceof C10445bd)) {
                ((C10445bd) C10415at.this.f31699c).mo34148a(beVar, i);
            }
        }

        /* renamed from: a */
        public final void mo34117a() {
            if (!C10415at.this.mo34114b() && (C10415at.this.f31699c instanceof C10445bd)) {
                ((C10445bd) C10415at.this.f31699c).mo34154w();
            }
        }

        /* renamed from: a */
        public final void mo34119a(C10449be beVar) {
            if (!C10415at.this.mo34114b() && (C10415at.this.f31699c instanceof C10445bd)) {
                C10445bd bdVar = (C10445bd) C10415at.this.f31699c;
                if (!bdVar.f31563l) {
                    if (PlacementType.PLACEMENT_TYPE_INLINE == bdVar.f31553b.f31249a) {
                        String str = "currentMediaVolume";
                        String str2 = "lastMediaVolume";
                        if (((Integer) beVar.f31629v.get(str)).intValue() > 0 && ((Integer) beVar.f31629v.get(str2)).intValue() == 0) {
                            bdVar.mo34152d(beVar);
                        }
                        if (((Integer) beVar.f31629v.get(str)).intValue() == 0 && ((Integer) beVar.f31629v.get(str2)).intValue() > 0) {
                            bdVar.mo34151c(beVar);
                        }
                    }
                    String str3 = "didStartPlaying";
                    if (!((Boolean) beVar.f31629v.get(str3)).booleanValue()) {
                        beVar.f31629v.put(str3, Boolean.valueOf(true));
                        bdVar.getViewableAd().mo33957a(6);
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("isCached", "1");
                            bdVar.mo34015a("VideoPlayed", (Map<String, Object>) hashMap);
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                            sb.append(e.getMessage());
                            sb.append(")");
                        }
                    }
                }
            }
        }

        /* renamed from: b */
        public final void mo34121b(C10449be beVar) {
            if (!C10415at.this.mo34114b() && (C10415at.this.f31699c instanceof C10445bd)) {
                ((C10445bd) C10415at.this.f31699c).mo34147a(beVar);
            }
        }

        /* renamed from: c */
        public final void mo34123c(C10449be beVar) {
            if (!C10415at.this.mo34114b() && (C10415at.this.f31699c instanceof C10445bd)) {
                ((C10445bd) C10415at.this.f31699c).mo34149b(beVar);
            }
        }

        /* renamed from: d */
        public final void mo34124d(C10449be beVar) {
            if (!C10415at.this.mo34114b() && (C10415at.this.f31699c instanceof C10445bd)) {
                C10445bd bdVar = (C10445bd) C10415at.this.f31699c;
                if (!((Boolean) beVar.f31629v.get("didSignalVideoCompleted")).booleanValue()) {
                    bdVar.mo34030o();
                    C10390c e = bdVar.mo34020e();
                    if (e != null) {
                        e.mo34069h();
                    }
                }
                if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == bdVar.f31553b.f31249a) {
                    bdVar.mo34018c((C10400ak) beVar);
                }
            }
        }

        /* renamed from: b */
        public final void mo34122b(C10449be beVar, int i) {
            if (!C10415at.this.mo34114b() && (C10415at.this.f31699c instanceof C10445bd)) {
                ((C10445bd) C10415at.this.f31699c).mo34150b(beVar, i);
            }
        }

        /* renamed from: e */
        public final void mo34125e(C10449be beVar) {
            if (!C10415at.this.mo34114b() && (C10415at.this.f31699c instanceof C10445bd)) {
                ((C10445bd) C10415at.this.f31699c).mo34153e(beVar);
            }
        }
    };

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ boolean mo34114b() {
        return super.mo34114b();
    }

    public C10415at(Context context, C10478c cVar, C10380ah ahVar, C10406ao aoVar) {
        this.f31699c = ahVar;
        C10419au auVar = new C10419au(context, cVar, this.f31699c, aoVar, this.f31700d, this.f31701e, this);
        this.f31698a = auVar;
        NativeViewFactory nativeViewFactory = this.f31698a.f31711d;
        NativeViewFactory.m33747a(ahVar.f31570s);
        this.f31698a.f31708a = this.f31702f;
    }

    /* renamed from: a */
    public final View mo34111a(View view, ViewGroup viewGroup, boolean z, RenderView renderView) {
        C10433aw awVar;
        String str = "InMobiAdView";
        if (view != null) {
            View findViewWithTag = view.findViewWithTag(str);
            if (findViewWithTag != null) {
                C10433aw awVar2 = (C10433aw) findViewWithTag;
                if (z) {
                    awVar = this.f31698a.mo34130b(awVar2, viewGroup, renderView);
                } else {
                    awVar = this.f31698a.mo34128a(awVar2, viewGroup, renderView);
                }
            } else if (z) {
                awVar = this.f31698a.mo34130b(null, viewGroup, renderView);
            } else {
                awVar = this.f31698a.mo34128a(null, viewGroup, renderView);
            }
        } else if (z) {
            awVar = this.f31698a.mo34130b(null, viewGroup, renderView);
        } else {
            awVar = this.f31698a.mo34128a(null, viewGroup, renderView);
        }
        awVar.f31748a = new WeakReference<>(this.f31699c);
        awVar.setTag(str);
        return awVar;
    }

    /* renamed from: a */
    public final void mo34112a() {
        this.f31698a.mo34131b();
        super.mo34112a();
    }

    /* renamed from: a */
    public final void mo34113a(C10443bb bbVar) {
        if (bbVar.f31618k == 1) {
            this.f31699c.mo33680b();
        }
    }
}
