package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;
import p002b.p003c.p053g.p061f.C1273q;

public final class zzbyt {

    /* renamed from: a */
    private int f26122a;

    /* renamed from: b */
    private zzaar f26123b;

    /* renamed from: c */
    private zzaea f26124c;

    /* renamed from: d */
    private View f26125d;

    /* renamed from: e */
    private List<zzadw> f26126e;

    /* renamed from: f */
    private List<zzabj> f26127f = Collections.emptyList();

    /* renamed from: g */
    private zzabj f26128g;

    /* renamed from: h */
    private Bundle f26129h;

    /* renamed from: i */
    private zzbgz f26130i;

    /* renamed from: j */
    private zzbgz f26131j;

    /* renamed from: k */
    private IObjectWrapper f26132k;

    /* renamed from: l */
    private View f26133l;

    /* renamed from: m */
    private IObjectWrapper f26134m;

    /* renamed from: n */
    private double f26135n;

    /* renamed from: o */
    private zzaei f26136o;

    /* renamed from: p */
    private zzaei f26137p;

    /* renamed from: q */
    private String f26138q;

    /* renamed from: r */
    private C1273q<String, zzadw> f26139r = new C1273q<>();

    /* renamed from: s */
    private C1273q<String, String> f26140s = new C1273q<>();

    /* renamed from: t */
    private float f26141t;

    /* renamed from: a */
    public final synchronized void mo30989a(int i) {
        this.f26122a = i;
    }

    /* renamed from: a */
    public final synchronized void mo30992a(zzaar zzaar) {
        this.f26123b = zzaar;
    }

    /* renamed from: a */
    public final synchronized void mo30994a(zzaea zzaea) {
        this.f26124c = zzaea;
    }

    /* renamed from: a */
    public final synchronized void mo31000a(List<zzadw> list) {
        this.f26126e = list;
    }

    /* renamed from: b */
    public final synchronized void mo31004b(List<zzabj> list) {
        this.f26127f = list;
    }

    /* renamed from: a */
    public final synchronized void mo30993a(zzabj zzabj) {
        this.f26128g = zzabj;
    }

    /* renamed from: a */
    public final synchronized void mo30990a(View view) {
        this.f26133l = view;
    }

    /* renamed from: a */
    public final synchronized void mo30988a(double d) {
        this.f26135n = d;
    }

    /* renamed from: a */
    public final synchronized void mo30995a(zzaei zzaei) {
        this.f26136o = zzaei;
    }

    /* renamed from: b */
    public final synchronized void mo31002b(zzaei zzaei) {
        this.f26137p = zzaei;
    }

    /* renamed from: a */
    public final synchronized void mo30997a(String str) {
        this.f26138q = str;
    }

    /* renamed from: a */
    public final synchronized void mo30996a(zzbgz zzbgz) {
        this.f26130i = zzbgz;
    }

    /* renamed from: b */
    public final synchronized void mo31003b(zzbgz zzbgz) {
        this.f26131j = zzbgz;
    }

    /* renamed from: a */
    public final synchronized void mo30991a(IObjectWrapper iObjectWrapper) {
        this.f26132k = iObjectWrapper;
    }

    /* renamed from: a */
    public final synchronized void mo30999a(String str, String str2) {
        if (str2 == null) {
            this.f26140s.remove(str);
        } else {
            this.f26140s.put(str, str2);
        }
    }

    /* renamed from: a */
    public final synchronized void mo30998a(String str, zzadw zzadw) {
        if (zzadw == null) {
            this.f26139r.remove(str);
        } else {
            this.f26139r.put(str, zzadw);
        }
    }

    /* renamed from: a */
    private final synchronized void m27988a(float f) {
        this.f26141t = f;
    }

    /* renamed from: b */
    private final synchronized String m27992b(String str) {
        return (String) this.f26140s.get(str);
    }

    /* renamed from: n */
    public final synchronized int mo31016n() {
        return this.f26122a;
    }

    /* renamed from: m */
    public final synchronized zzaar mo31015m() {
        return this.f26123b;
    }

    /* renamed from: x */
    public final synchronized zzaea mo31026x() {
        return this.f26124c;
    }

    /* renamed from: o */
    public final synchronized View mo31017o() {
        return this.f26125d;
    }

    /* renamed from: g */
    public final synchronized String mo31009g() {
        return m27992b("headline");
    }

    /* renamed from: h */
    public final synchronized List<zzadw> mo31010h() {
        return this.f26126e;
    }

    /* renamed from: i */
    public final synchronized List<zzabj> mo31011i() {
        return this.f26127f;
    }

    /* renamed from: p */
    public final synchronized zzabj mo31018p() {
        return this.f26128g;
    }

    /* renamed from: c */
    public final synchronized String mo31005c() {
        return m27992b("body");
    }

    /* renamed from: f */
    public final synchronized Bundle mo31008f() {
        if (this.f26129h == null) {
            this.f26129h = new Bundle();
        }
        return this.f26129h;
    }

    /* renamed from: d */
    public final synchronized String mo31006d() {
        return m27992b("call_to_action");
    }

    /* renamed from: q */
    public final synchronized View mo31019q() {
        return this.f26133l;
    }

    /* renamed from: y */
    public final synchronized IObjectWrapper mo31027y() {
        return this.f26134m;
    }

    /* renamed from: l */
    public final synchronized String mo31014l() {
        return m27992b("store");
    }

    /* renamed from: j */
    public final synchronized String mo31012j() {
        return m27992b("price");
    }

    /* renamed from: k */
    public final synchronized double mo31013k() {
        return this.f26135n;
    }

    /* renamed from: w */
    public final synchronized zzaei mo31025w() {
        return this.f26136o;
    }

    /* renamed from: b */
    public final synchronized String mo31001b() {
        return m27992b("advertiser");
    }

    /* renamed from: z */
    public final synchronized zzaei mo31028z() {
        return this.f26137p;
    }

    /* renamed from: e */
    public final synchronized String mo31007e() {
        return this.f26138q;
    }

    /* renamed from: r */
    public final synchronized zzbgz mo31020r() {
        return this.f26130i;
    }

    /* renamed from: s */
    public final synchronized zzbgz mo31021s() {
        return this.f26131j;
    }

    /* renamed from: t */
    public final synchronized IObjectWrapper mo31022t() {
        return this.f26132k;
    }

    /* renamed from: u */
    public final synchronized C1273q<String, zzadw> mo31023u() {
        return this.f26139r;
    }

    /* renamed from: A */
    public final synchronized float mo30986A() {
        return this.f26141t;
    }

    /* renamed from: v */
    public final synchronized C1273q<String, String> mo31024v() {
        return this.f26140s;
    }

    /* renamed from: a */
    public final synchronized void mo30987a() {
        if (this.f26130i != null) {
            this.f26130i.destroy();
            this.f26130i = null;
        }
        if (this.f26131j != null) {
            this.f26131j.destroy();
            this.f26131j = null;
        }
        this.f26132k = null;
        this.f26139r.clear();
        this.f26140s.clear();
        this.f26123b = null;
        this.f26124c = null;
        this.f26125d = null;
        this.f26126e = null;
        this.f26129h = null;
        this.f26133l = null;
        this.f26134m = null;
        this.f26136o = null;
        this.f26137p = null;
        this.f26138q = null;
    }

    /* renamed from: a */
    public static zzbyt m27986a(zzand zzand) {
        try {
            zzaar videoController = zzand.getVideoController();
            zzaea l = zzand.mo29922l();
            View view = (View) m27991b(zzand.mo29912B());
            String o = zzand.mo29925o();
            List<zzadw> q = zzand.mo29927q();
            String p = zzand.mo29926p();
            Bundle extras = zzand.getExtras();
            String m = zzand.mo29923m();
            View view2 = (View) m27991b(zzand.mo29911A());
            IObjectWrapper n = zzand.mo29924n();
            String x = zzand.mo29929x();
            zzaei J = zzand.mo29915J();
            zzbyt zzbyt = new zzbyt();
            zzbyt.f26122a = 1;
            zzbyt.f26123b = videoController;
            zzbyt.f26124c = l;
            zzbyt.f26125d = view;
            zzbyt.mo30999a("headline", o);
            zzbyt.f26126e = q;
            zzbyt.mo30999a("body", p);
            zzbyt.f26129h = extras;
            zzbyt.mo30999a("call_to_action", m);
            zzbyt.f26133l = view2;
            zzbyt.f26134m = n;
            zzbyt.mo30999a("advertiser", x);
            zzbyt.f26137p = J;
            return zzbyt;
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    /* renamed from: a */
    public static zzbyt m27985a(zzana zzana) {
        try {
            zzaar videoController = zzana.getVideoController();
            zzaea l = zzana.mo29902l();
            View view = (View) m27991b(zzana.mo29891B());
            String o = zzana.mo29905o();
            List<zzadw> q = zzana.mo29907q();
            String p = zzana.mo29906p();
            Bundle extras = zzana.getExtras();
            String m = zzana.mo29903m();
            View view2 = (View) m27991b(zzana.mo29890A());
            IObjectWrapper n = zzana.mo29904n();
            String store = zzana.getStore();
            String u = zzana.mo29910u();
            double j = zzana.mo29901j();
            zzaei t = zzana.mo29909t();
            zzbyt zzbyt = new zzbyt();
            zzaei zzaei = t;
            zzbyt.f26122a = 2;
            zzbyt.f26123b = videoController;
            zzbyt.f26124c = l;
            zzbyt.f26125d = view;
            zzbyt.mo30999a("headline", o);
            zzbyt.f26126e = q;
            zzbyt.mo30999a("body", p);
            zzbyt.f26129h = extras;
            zzbyt.mo30999a("call_to_action", m);
            zzbyt.f26133l = view2;
            zzbyt.f26134m = n;
            zzbyt.mo30999a("store", store);
            zzbyt.mo30999a("price", u);
            zzbyt.f26135n = j;
            zzbyt.f26136o = zzaei;
            return zzbyt;
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    /* renamed from: a */
    public static zzbyt m27987a(zzang zzang) {
        try {
            return m27984a(zzang.getVideoController(), zzang.mo29942l(), (View) m27991b(zzang.mo29931B()), zzang.mo29945o(), zzang.mo29947q(), zzang.mo29946p(), zzang.getExtras(), zzang.mo29943m(), (View) m27991b(zzang.mo29930A()), zzang.mo29944n(), zzang.getStore(), zzang.mo29950u(), zzang.mo29941j(), zzang.mo29949t(), zzang.mo29951x(), zzang.mo29940ia());
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    /* renamed from: b */
    public static zzbyt m27989b(zzana zzana) {
        try {
            return m27984a(zzana.getVideoController(), zzana.mo29902l(), (View) m27991b(zzana.mo29891B()), zzana.mo29905o(), zzana.mo29907q(), zzana.mo29906p(), zzana.getExtras(), zzana.mo29903m(), (View) m27991b(zzana.mo29890A()), zzana.mo29904n(), zzana.getStore(), zzana.mo29910u(), zzana.mo29901j(), zzana.mo29909t(), null, 0.0f);
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    /* renamed from: b */
    public static zzbyt m27990b(zzand zzand) {
        try {
            return m27984a(zzand.getVideoController(), zzand.mo29922l(), (View) m27991b(zzand.mo29912B()), zzand.mo29925o(), zzand.mo29927q(), zzand.mo29926p(), zzand.getExtras(), zzand.mo29923m(), (View) m27991b(zzand.mo29911A()), zzand.mo29924n(), null, null, -1.0d, zzand.mo29915J(), zzand.mo29929x(), 0.0f);
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    /* renamed from: a */
    private static zzbyt m27984a(zzaar zzaar, zzaea zzaea, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzaei zzaei, String str6, float f) {
        zzbyt zzbyt = new zzbyt();
        zzbyt.f26122a = 6;
        zzbyt.f26123b = zzaar;
        zzbyt.f26124c = zzaea;
        zzbyt.f26125d = view;
        String str7 = str;
        zzbyt.mo30999a("headline", str);
        zzbyt.f26126e = list;
        String str8 = str2;
        zzbyt.mo30999a("body", str2);
        zzbyt.f26129h = bundle;
        String str9 = str3;
        zzbyt.mo30999a("call_to_action", str3);
        zzbyt.f26133l = view2;
        zzbyt.f26134m = iObjectWrapper;
        String str10 = str4;
        zzbyt.mo30999a("store", str4);
        String str11 = str5;
        zzbyt.mo30999a("price", str5);
        zzbyt.f26135n = d;
        zzbyt.f26136o = zzaei;
        zzbyt.mo30999a("advertiser", str6);
        zzbyt.m27988a(f);
        return zzbyt;
    }

    /* renamed from: b */
    private static <T> T m27991b(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.m22187H(iObjectWrapper);
    }
}
