package android.support.p000v4.content;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p002b.p003c.p053g.p061f.C1257f;

/* renamed from: android.support.v4.content.c */
/* compiled from: Loader */
public class C0511c<D> {

    /* renamed from: a */
    int f1662a;

    /* renamed from: b */
    C0513b<D> f1663b;

    /* renamed from: c */
    C0512a<D> f1664c;

    /* renamed from: d */
    Context f1665d;

    /* renamed from: e */
    boolean f1666e = false;

    /* renamed from: f */
    boolean f1667f = false;

    /* renamed from: g */
    boolean f1668g = true;

    /* renamed from: h */
    boolean f1669h = false;

    /* renamed from: i */
    boolean f1670i = false;

    /* renamed from: android.support.v4.content.c$a */
    /* compiled from: Loader */
    public interface C0512a<D> {
        /* renamed from: a */
        void mo5310a(C0511c<D> cVar);
    }

    /* renamed from: android.support.v4.content.c$b */
    /* compiled from: Loader */
    public interface C0513b<D> {
        /* renamed from: a */
        void mo5060a(C0511c<D> cVar, D d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo5265h() {
        throw null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo5303l() {
        throw null;
    }

    public C0511c(Context context) {
        this.f1665d = context.getApplicationContext();
    }

    /* renamed from: b */
    public void mo5294b(D data) {
        C0513b<D> bVar = this.f1663b;
        if (bVar != null) {
            bVar.mo5060a(this, data);
        }
    }

    /* renamed from: d */
    public void mo5297d() {
        C0512a<D> aVar = this.f1664c;
        if (aVar != null) {
            aVar.mo5310a(this);
        }
    }

    /* renamed from: a */
    public void mo5292a(int id, C0513b<D> listener) {
        if (this.f1663b == null) {
            this.f1663b = listener;
            this.f1662a = id;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    /* renamed from: a */
    public void mo5293a(C0513b<D> listener) {
        C0513b<D> bVar = this.f1663b;
        if (bVar == null) {
            throw new IllegalStateException("No listener register");
        } else if (bVar == listener) {
            this.f1663b = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    /* renamed from: f */
    public boolean mo5299f() {
        return this.f1667f;
    }

    /* renamed from: p */
    public final void mo5307p() {
        this.f1666e = true;
        this.f1668g = false;
        this.f1667f = false;
        mo5303l();
    }

    /* renamed from: b */
    public boolean mo5295b() {
        return mo5265h();
    }

    /* renamed from: e */
    public void mo5298e() {
        mo5266j();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo5266j() {
    }

    /* renamed from: q */
    public void mo5308q() {
        this.f1666e = false;
        mo5304m();
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo5304m() {
    }

    /* renamed from: a */
    public void mo5291a() {
        this.f1667f = true;
        mo5300g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo5300g() {
    }

    /* renamed from: n */
    public void mo5305n() {
        mo5302k();
        this.f1668g = true;
        this.f1666e = false;
        this.f1667f = false;
        this.f1669h = false;
        this.f1670i = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo5302k() {
    }

    /* renamed from: c */
    public void mo5296c() {
        this.f1670i = false;
    }

    /* renamed from: o */
    public void mo5306o() {
        if (this.f1670i) {
            mo5301i();
        }
    }

    /* renamed from: i */
    public void mo5301i() {
        if (this.f1666e) {
            mo5298e();
        } else {
            this.f1669h = true;
        }
    }

    /* renamed from: a */
    public String mo5290a(D data) {
        StringBuilder sb = new StringBuilder(64);
        C1257f.m5913a(data, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        C1257f.m5913a(this, sb);
        sb.append(" id=");
        sb.append(this.f1662a);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo5262a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix);
        writer.print("mId=");
        writer.print(this.f1662a);
        writer.print(" mListener=");
        writer.println(this.f1663b);
        if (this.f1666e || this.f1669h || this.f1670i) {
            writer.print(prefix);
            writer.print("mStarted=");
            writer.print(this.f1666e);
            writer.print(" mContentChanged=");
            writer.print(this.f1669h);
            writer.print(" mProcessingChange=");
            writer.println(this.f1670i);
        }
        if (this.f1667f || this.f1668g) {
            writer.print(prefix);
            writer.print("mAbandoned=");
            writer.print(this.f1667f);
            writer.print(" mReset=");
            writer.println(this.f1668g);
        }
    }
}
