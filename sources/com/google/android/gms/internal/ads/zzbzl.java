package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzbzl {

    /* renamed from: a */
    private final Context f26193a;

    /* renamed from: b */
    private final zzaxb f26194b;

    /* renamed from: c */
    private final zzcxv f26195c;

    /* renamed from: d */
    private final zzbyx f26196d;

    /* renamed from: e */
    private final zzbyt f26197e;

    /* renamed from: f */
    private final zzbzt f26198f;

    /* renamed from: g */
    private final Executor f26199g;

    /* renamed from: h */
    private final Executor f26200h;

    /* renamed from: i */
    private final zzady f26201i;

    public zzbzl(Context context, zzaxb zzaxb, zzcxv zzcxv, zzbyx zzbyx, zzbyt zzbyt, zzbzt zzbzt, Executor executor, Executor executor2) {
        this.f26193a = context;
        this.f26194b = zzaxb;
        this.f26195c = zzcxv;
        this.f26201i = zzcxv.f27605i;
        this.f26196d = zzbyx;
        this.f26197e = zzbyt;
        this.f26198f = zzbzt;
        this.f26199g = executor;
        this.f26200h = executor2;
    }

    /* renamed from: a */
    public final void mo31068a(zzcab zzcab) {
        this.f26199g.execute(new C9730th(this, zzcab));
    }

    /* renamed from: a */
    private static void m28118a(LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* renamed from: b */
    public final void mo31071b(zzcab zzcab) {
        if (zzcab != null && this.f26198f != null && zzcab.mo31053b() != null) {
            try {
                zzcab.mo31053b().addView(this.f26198f.mo31077a());
            } catch (zzbhj e) {
                zzawz.m26002e("web view can not be obtained", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static boolean m28120a(zzcab zzcab, String[] strArr) {
        Map d = zzcab.mo31055d();
        if (d == null) {
            return false;
        }
        for (String str : strArr) {
            if (d.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo31069a(ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View q = this.f26197e.mo31019q();
        if (q == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (q.getParent() instanceof ViewGroup) {
            ((ViewGroup) q.getParent()).removeView(q);
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23989Pc)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(q, layoutParams);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo31070b(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.f26197e.mo31019q() != null) {
            if (2 == this.f26197e.mo31016n() || 1 == this.f26197e.mo31016n()) {
                this.f26194b.mo30204a(this.f26195c.f27602f, String.valueOf(this.f26197e.mo31016n()), z);
            } else if (6 == this.f26197e.mo31016n()) {
                this.f26194b.mo30204a(this.f26195c.f27602f, "2", z);
                this.f26194b.mo30204a(this.f26195c.f27602f, "1", z);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final /* synthetic */ void mo31072c(zzcab zzcab) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        zzaei zzaei = null;
        if (this.f26196d.mo31031c() || this.f26196d.mo31030b()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
            int i = 0;
            while (true) {
                if (i >= 2) {
                    viewGroup = null;
                    break;
                }
                View a = zzcab.mo31051a(strArr[i]);
                if (a != null && (a instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) a;
                    break;
                }
                i++;
            }
        } else {
            viewGroup = null;
        }
        boolean z = viewGroup != null;
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (this.f26197e.mo31017o() != null) {
            view = this.f26197e.mo31017o();
            zzady zzady = this.f26201i;
            if (zzady != null && !z) {
                m28118a(layoutParams, zzady.f24269e);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(this.f26197e.mo31026x() instanceof zzadt)) {
            view = null;
        } else {
            zzadt zzadt = (zzadt) this.f26197e.mo31026x();
            if (!z) {
                m28118a(layoutParams, zzadt.mo29635nb());
            }
            View zzadu = new zzadu(this.f26193a, zzadt, layoutParams);
            zzadu.setContentDescription((CharSequence) zzyt.m31536e().mo29599a(zzacu.f23971Mc));
            view = zzadu;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcab.mo31050a().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout b = zzcab.mo31053b();
                if (b != null) {
                    b.addView(adChoicesView);
                }
            }
            zzcab.mo31052a(zzcab.mo31058g(), view, true);
        }
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24015Te)).booleanValue()) {
            mo31071b(zzcab);
        }
        String[] strArr2 = zzbzj.f26183b;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                viewGroup2 = null;
                break;
            }
            View a2 = zzcab.mo31051a(strArr2[i2]);
            if (a2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) a2;
                break;
            }
            i2++;
        }
        this.f26200h.execute(new C9751uh(this, viewGroup2));
        if (viewGroup2 != null) {
            if (!mo31069a(viewGroup2)) {
                viewGroup2.removeAllViews();
                View a3 = zzcab.mo31050a();
                Context context = a3 != null ? a3.getContext() : null;
                if (context != null && this.f26197e.mo31010h() != null && !this.f26197e.mo31010h().isEmpty()) {
                    Object obj = this.f26197e.mo31010h().get(0);
                    if (obj instanceof IBinder) {
                        zzaei = zzaej.m24846a((IBinder) obj);
                    }
                    if (zzaei != null) {
                        try {
                            IObjectWrapper Pa = zzaei.mo29639Pa();
                            if (Pa != null) {
                                Drawable drawable = (Drawable) ObjectWrapper.m22187H(Pa);
                                if (drawable != null) {
                                    ImageView imageView = new ImageView(context);
                                    imageView.setImageDrawable(drawable);
                                    imageView.setScaleType(ScaleType.CENTER_INSIDE);
                                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                    viewGroup2.addView(imageView);
                                }
                            }
                        } catch (RemoteException e) {
                            zzbad.m26359d("Could not get drawable from image");
                        }
                    }
                }
            } else if (this.f26197e.mo31020r() != null) {
                this.f26197e.mo31020r().mo28721a((zzadx) new C9772vh(this, zzcab, viewGroup2));
            }
        }
    }
}
