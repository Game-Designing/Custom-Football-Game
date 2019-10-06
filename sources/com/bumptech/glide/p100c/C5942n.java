package com.bumptech.glide.p100c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0424G;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C6354n;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;
import java.util.HashMap;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: com.bumptech.glide.c.n */
/* compiled from: RequestManagerRetriever */
public class C5942n implements Callback {

    /* renamed from: a */
    private static final C5943a f10459a = new C5941m();

    /* renamed from: b */
    private volatile C6354n f10460b;

    /* renamed from: c */
    final Map<FragmentManager, C5939l> f10461c = new HashMap();

    /* renamed from: d */
    final Map<C0486t, C5946q> f10462d = new HashMap();

    /* renamed from: e */
    private final Handler f10463e;

    /* renamed from: f */
    private final C5943a f10464f;

    /* renamed from: g */
    private final C1253b<View, Fragment> f10465g = new C1253b<>();

    /* renamed from: h */
    private final C1253b<View, android.app.Fragment> f10466h = new C1253b<>();

    /* renamed from: i */
    private final Bundle f10467i = new Bundle();

    /* renamed from: com.bumptech.glide.c.n$a */
    /* compiled from: RequestManagerRetriever */
    public interface C5943a {
        /* renamed from: a */
        C6354n mo18613a(C5926c cVar, C5936i iVar, C5944o oVar, Context context);
    }

    public C5942n(C5943a factory) {
        this.f10464f = factory != null ? factory : f10459a;
        this.f10463e = new Handler(Looper.getMainLooper(), this);
    }

    /* renamed from: b */
    private C6354n m10967b(Context context) {
        if (this.f10460b == null) {
            synchronized (this) {
                if (this.f10460b == null) {
                    this.f10460b = this.f10464f.mo18613a(C5926c.m10916a(context.getApplicationContext()), new C5928b(), new C5935h(), context.getApplicationContext());
                }
            }
        }
        return this.f10460b;
    }

    /* renamed from: a */
    public C6354n mo18615a(Context context) {
        if (context != null) {
            if (C6026k.m11288d() && !(context instanceof Application)) {
                if (context instanceof C0014p) {
                    return mo18617a((C0014p) context);
                }
                if (context instanceof Activity) {
                    return mo18614a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return mo18615a(((ContextWrapper) context).getBaseContext());
                }
            }
            return m10967b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    /* renamed from: a */
    public C6354n mo18617a(C0014p activity) {
        if (C6026k.m11287c()) {
            return mo18615a(activity.getApplicationContext());
        }
        m10968c(activity);
        return m10966a((Context) activity, activity.getSupportFragmentManager(), (Fragment) null, m10969d(activity));
    }

    /* renamed from: a */
    public C6354n mo18616a(Fragment fragment) {
        C6024i.m11265a(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (C6026k.m11287c()) {
            return mo18615a(fragment.getActivity().getApplicationContext());
        }
        return m10966a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    /* renamed from: a */
    public C6354n mo18614a(Activity activity) {
        if (C6026k.m11287c()) {
            return mo18615a(activity.getApplicationContext());
        }
        m10968c(activity);
        return m10965a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null, m10969d(activity));
    }

    @TargetApi(17)
    /* renamed from: c */
    private static void m10968c(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    /* renamed from: b */
    public C5939l mo18618b(Activity activity) {
        return m10963a(activity.getFragmentManager(), (android.app.Fragment) null, m10969d(activity));
    }

    /* renamed from: a */
    private C5939l m10963a(FragmentManager fm, android.app.Fragment parentHint, boolean isParentVisible) {
        String str = "com.bumptech.glide.manager";
        C5939l current = (C5939l) fm.findFragmentByTag(str);
        if (current == null) {
            current = (C5939l) this.f10461c.get(fm);
            if (current == null) {
                current = new C5939l();
                current.mo18602a(parentHint);
                if (isParentVisible) {
                    current.mo18601a().mo18592b();
                }
                this.f10461c.put(fm, current);
                fm.beginTransaction().add(current, str).commitAllowingStateLoss();
                this.f10463e.obtainMessage(1, fm).sendToTarget();
            }
        }
        return current;
    }

    @Deprecated
    /* renamed from: a */
    private C6354n m10965a(Context context, FragmentManager fm, android.app.Fragment parentHint, boolean isParentVisible) {
        C5939l current = m10963a(fm, parentHint, isParentVisible);
        C6354n requestManager = current.mo18604b();
        if (requestManager != null) {
            return requestManager;
        }
        C6354n requestManager2 = this.f10464f.mo18613a(C5926c.m10916a(context), current.mo18601a(), current.mo18605c(), context);
        current.mo18603a(requestManager2);
        return requestManager2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C5946q mo18619b(C0014p activity) {
        return m10964a(activity.getSupportFragmentManager(), (Fragment) null, m10969d(activity));
    }

    /* renamed from: d */
    private static boolean m10969d(Activity activity) {
        return !activity.isFinishing();
    }

    /* renamed from: a */
    private C5946q m10964a(C0486t fm, Fragment parentHint, boolean isParentVisible) {
        String str = "com.bumptech.glide.manager";
        C5946q current = (C5946q) fm.mo4908a(str);
        if (current == null) {
            current = (C5946q) this.f10462d.get(fm);
            if (current == null) {
                current = new C5946q();
                current.mo18628a(parentHint);
                if (isParentVisible) {
                    current.mo18630b().mo18592b();
                }
                this.f10462d.put(fm, current);
                C0424G a = fm.mo4909a();
                a.mo5037a((Fragment) current, str);
                a.mo5039b();
                this.f10463e.obtainMessage(2, fm).sendToTarget();
            }
        }
        return current;
    }

    /* renamed from: a */
    private C6354n m10966a(Context context, C0486t fm, Fragment parentHint, boolean isParentVisible) {
        C5946q current = m10964a(fm, parentHint, isParentVisible);
        C6354n requestManager = current.mo18631c();
        if (requestManager != null) {
            return requestManager;
        }
        C6354n requestManager2 = this.f10464f.mo18613a(C5926c.m10916a(context), current.mo18630b(), current.mo18632d(), context);
        current.mo18629a(requestManager2);
        return requestManager2;
    }

    public boolean handleMessage(Message message) {
        boolean handled = true;
        Object removed = null;
        Object key = null;
        int i = message.what;
        if (i == 1) {
            FragmentManager fm = (FragmentManager) message.obj;
            key = fm;
            removed = this.f10461c.remove(fm);
        } else if (i != 2) {
            handled = false;
        } else {
            C0486t supportFm = (C0486t) message.obj;
            key = supportFm;
            removed = this.f10462d.remove(supportFm);
        }
        if (handled && removed == null) {
            String str = "RMRetriever";
            if (Log.isLoggable(str, 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to remove expected request manager fragment, manager: ");
                sb.append(key);
                Log.w(str, sb.toString());
            }
        }
        return handled;
    }
}
