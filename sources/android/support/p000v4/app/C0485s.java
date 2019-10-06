package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.s */
/* compiled from: FragmentHostCallback */
public abstract class C0485s<E> extends C0483q {

    /* renamed from: a */
    private final Activity f1614a;

    /* renamed from: b */
    final Context f1615b;

    /* renamed from: c */
    private final Handler f1616c;

    /* renamed from: d */
    final int f1617d;

    /* renamed from: e */
    final C0409A f1618e;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo222a(Fragment fragment);

    /* renamed from: a */
    public abstract void mo223a(Fragment fragment, Intent intent, int i, Bundle bundle);

    /* renamed from: a */
    public abstract void mo224a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException;

    /* renamed from: a */
    public abstract void mo225a(Fragment fragment, String[] strArr, int i);

    /* renamed from: a */
    public abstract void mo226a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: a */
    public abstract boolean mo228a(String str);

    /* renamed from: b */
    public abstract boolean mo229b(Fragment fragment);

    /* renamed from: f */
    public abstract E mo230f();

    /* renamed from: g */
    public abstract LayoutInflater mo231g();

    /* renamed from: h */
    public abstract int mo232h();

    /* renamed from: i */
    public abstract boolean mo233i();

    /* renamed from: j */
    public abstract void mo234j();

    C0485s(C0014p activity) {
        this(activity, activity, activity.mHandler, 0);
    }

    C0485s(Activity activity, Context context, Handler handler, int windowAnimations) {
        this.f1618e = new C0409A();
        this.f1614a = activity;
        this.f1615b = context;
        this.f1616c = handler;
        this.f1617d = windowAnimations;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Activity mo5226b() {
        return this.f1614a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Context mo5227c() {
        return this.f1615b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Handler mo5229e() {
        return this.f1616c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C0409A mo5228d() {
        return this.f1618e;
    }
}
