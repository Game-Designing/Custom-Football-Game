package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.Do */
final class C8817Do implements C9801wp {

    /* renamed from: a */
    private final zzdnd f20756a;

    /* renamed from: b */
    private int f20757b;

    /* renamed from: c */
    private int f20758c;

    /* renamed from: d */
    private int f20759d = 0;

    /* renamed from: a */
    public static C8817Do m22419a(zzdnd zzdnd) {
        C8817Do doR = zzdnd.f27979d;
        if (doR != null) {
            return doR;
        }
        return new C8817Do(zzdnd);
    }

    private C8817Do(zzdnd zzdnd) {
        zzdod.m29917a(zzdnd, "input");
        this.f20756a = zzdnd;
        this.f20756a.f27979d = this;
    }

    /* renamed from: n */
    public final int mo28157n() throws IOException {
        int i = this.f20759d;
        if (i != 0) {
            this.f20757b = i;
            this.f20759d = 0;
        } else {
            this.f20757b = this.f20756a.mo28086d();
        }
        int i2 = this.f20757b;
        if (i2 == 0 || i2 == this.f20758c) {
            return MoPubClientPositioning.NO_REPEAT;
        }
        return i2 >>> 3;
    }

    public final int getTag() {
        return this.f20757b;
    }

    /* renamed from: o */
    public final boolean mo28160o() throws IOException {
        if (!this.f20756a.mo28102s()) {
            int i = this.f20757b;
            if (i != this.f20758c) {
                return this.f20756a.mo28083b(i);
            }
        }
        return false;
    }

    /* renamed from: a */
    private final void m22420a(int i) throws IOException {
        if ((this.f20757b & 7) != i) {
            throw zzdok.m29933f();
        }
    }

    public final double readDouble() throws IOException {
        m22420a(1);
        return this.f20756a.mo28080a();
    }

    public final float readFloat() throws IOException {
        m22420a(5);
        return this.f20756a.mo28082b();
    }

    /* renamed from: b */
    public final long mo28130b() throws IOException {
        m22420a(0);
        return this.f20756a.mo28088e();
    }

    /* renamed from: d */
    public final long mo28136d() throws IOException {
        m22420a(0);
        return this.f20756a.mo28089f();
    }

    /* renamed from: f */
    public final int mo28140f() throws IOException {
        m22420a(0);
        return this.f20756a.mo28090g();
    }

    /* renamed from: e */
    public final long mo28138e() throws IOException {
        m22420a(1);
        return this.f20756a.mo28091h();
    }

    /* renamed from: g */
    public final int mo28142g() throws IOException {
        m22420a(5);
        return this.f20756a.mo28092i();
    }

    /* renamed from: l */
    public final boolean mo28154l() throws IOException {
        m22420a(0);
        return this.f20756a.mo28093j();
    }

    public final String readString() throws IOException {
        m22420a(2);
        return this.f20756a.mo28085c();
    }

    /* renamed from: m */
    public final String mo28155m() throws IOException {
        m22420a(2);
        return this.f20756a.mo28094k();
    }

    /* renamed from: a */
    public final <T> T mo28127a(C9822xp<T> xpVar, zzdno zzdno) throws IOException {
        m22420a(2);
        return m22423c(xpVar, zzdno);
    }

    /* renamed from: b */
    public final <T> T mo28131b(C9822xp<T> xpVar, zzdno zzdno) throws IOException {
        m22420a(3);
        return m22425d(xpVar, zzdno);
    }

    /* renamed from: c */
    private final <T> T m22423c(C9822xp<T> xpVar, zzdno zzdno) throws IOException {
        int m = this.f20756a.mo28096m();
        zzdnd zzdnd = this.f20756a;
        if (zzdnd.f27976a < zzdnd.f27977b) {
            int c = zzdnd.mo28084c(m);
            T a = xpVar.mo29080a();
            this.f20756a.f27976a++;
            xpVar.mo29082a(a, this, zzdno);
            xpVar.mo29088d(a);
            this.f20756a.mo28081a(0);
            zzdnd zzdnd2 = this.f20756a;
            zzdnd2.f27976a--;
            zzdnd2.mo28087d(c);
            return a;
        }
        throw new zzdok("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: d */
    private final <T> T m22425d(C9822xp<T> xpVar, zzdno zzdno) throws IOException {
        int i = this.f20758c;
        this.f20758c = ((this.f20757b >>> 3) << 3) | 4;
        try {
            T a = xpVar.mo29080a();
            xpVar.mo29082a(a, this, zzdno);
            xpVar.mo29088d(a);
            if (this.f20757b == this.f20758c) {
                return a;
            }
            throw zzdok.m29934g();
        } finally {
            this.f20758c = i;
        }
    }

    /* renamed from: p */
    public final zzdmr mo28161p() throws IOException {
        m22420a(2);
        return this.f20756a.mo28095l();
    }

    /* renamed from: h */
    public final int mo28145h() throws IOException {
        m22420a(0);
        return this.f20756a.mo28096m();
    }

    /* renamed from: i */
    public final int mo28147i() throws IOException {
        m22420a(0);
        return this.f20756a.mo28097n();
    }

    /* renamed from: j */
    public final int mo28149j() throws IOException {
        m22420a(5);
        return this.f20756a.mo28098o();
    }

    /* renamed from: k */
    public final long mo28151k() throws IOException {
        m22420a(1);
        return this.f20756a.mo28099p();
    }

    /* renamed from: a */
    public final int mo28126a() throws IOException {
        m22420a(0);
        return this.f20756a.mo28100q();
    }

    /* renamed from: c */
    public final long mo28134c() throws IOException {
        m22420a(0);
        return this.f20756a.mo28101r();
    }

    /* renamed from: d */
    public final void mo28137d(List<Double> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C8880Go) {
            C8880Go go = (C8880Go) list;
            int i = this.f20757b & 7;
            if (i == 1) {
                do {
                    go.mo28267a(this.f20756a.mo28080a());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int m = this.f20756a.mo28096m();
                m22422b(m);
                int t = this.f20756a.mo28103t() + m;
                do {
                    go.mo28267a(this.f20756a.mo28080a());
                } while (this.f20756a.mo28103t() < t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.f20756a.mo28080a()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int m2 = this.f20756a.mo28096m();
                m22422b(m2);
                int t2 = this.f20756a.mo28103t() + m2;
                do {
                    list.add(Double.valueOf(this.f20756a.mo28080a()));
                } while (this.f20756a.mo28103t() < t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: c */
    public final void mo28135c(List<Float> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9069Po) {
            C9069Po po = (C9069Po) list;
            int i = this.f20757b & 7;
            if (i == 2) {
                int m = this.f20756a.mo28096m();
                m22424c(m);
                int t = this.f20756a.mo28103t() + m;
                do {
                    po.mo28520a(this.f20756a.mo28082b());
                } while (this.f20756a.mo28103t() < t);
            } else if (i == 5) {
                do {
                    po.mo28520a(this.f20756a.mo28082b());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 2) {
                int m2 = this.f20756a.mo28096m();
                m22424c(m2);
                int t2 = this.f20756a.mo28103t() + m2;
                do {
                    list.add(Float.valueOf(this.f20756a.mo28082b()));
                } while (this.f20756a.mo28103t() < t2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.f20756a.mo28082b()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: n */
    public final void mo28158n(List<Long> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9324ap) {
            C9324ap apVar = (C9324ap) list;
            int i = this.f20757b & 7;
            if (i == 0) {
                do {
                    apVar.mo28856a(this.f20756a.mo28088e());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int t = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    apVar.mo28856a(this.f20756a.mo28088e());
                } while (this.f20756a.mo28103t() < t);
                m22426d(t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f20756a.mo28088e()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int t2 = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    list.add(Long.valueOf(this.f20756a.mo28088e()));
                } while (this.f20756a.mo28103t() < t2);
                m22426d(t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: m */
    public final void mo28156m(List<Long> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9324ap) {
            C9324ap apVar = (C9324ap) list;
            int i = this.f20757b & 7;
            if (i == 0) {
                do {
                    apVar.mo28856a(this.f20756a.mo28089f());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int t = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    apVar.mo28856a(this.f20756a.mo28089f());
                } while (this.f20756a.mo28103t() < t);
                m22426d(t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f20756a.mo28089f()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int t2 = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    list.add(Long.valueOf(this.f20756a.mo28089f()));
                } while (this.f20756a.mo28103t() < t2);
                m22426d(t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: q */
    public final void mo28163q(List<Integer> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            int i = this.f20757b & 7;
            if (i == 0) {
                do {
                    to.mo28619d(this.f20756a.mo28090g());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int t = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    to.mo28619d(this.f20756a.mo28090g());
                } while (this.f20756a.mo28103t() < t);
                m22426d(t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28090g()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int t2 = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28090g()));
                } while (this.f20756a.mo28103t() < t2);
                m22426d(t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: p */
    public final void mo28162p(List<Long> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9324ap) {
            C9324ap apVar = (C9324ap) list;
            int i = this.f20757b & 7;
            if (i == 1) {
                do {
                    apVar.mo28856a(this.f20756a.mo28091h());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int m = this.f20756a.mo28096m();
                m22422b(m);
                int t = this.f20756a.mo28103t() + m;
                do {
                    apVar.mo28856a(this.f20756a.mo28091h());
                } while (this.f20756a.mo28103t() < t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f20756a.mo28091h()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int m2 = this.f20756a.mo28096m();
                m22422b(m2);
                int t2 = this.f20756a.mo28103t() + m2;
                do {
                    list.add(Long.valueOf(this.f20756a.mo28091h()));
                } while (this.f20756a.mo28103t() < t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: j */
    public final void mo28150j(List<Integer> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            int i = this.f20757b & 7;
            if (i == 2) {
                int m = this.f20756a.mo28096m();
                m22424c(m);
                int t = this.f20756a.mo28103t() + m;
                do {
                    to.mo28619d(this.f20756a.mo28092i());
                } while (this.f20756a.mo28103t() < t);
            } else if (i == 5) {
                do {
                    to.mo28619d(this.f20756a.mo28092i());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 2) {
                int m2 = this.f20756a.mo28096m();
                m22424c(m2);
                int t2 = this.f20756a.mo28103t() + m2;
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28092i()));
                } while (this.f20756a.mo28103t() < t2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28092i()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: i */
    public final void mo28148i(List<Boolean> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9653po) {
            C9653po poVar = (C9653po) list;
            int i = this.f20757b & 7;
            if (i == 0) {
                do {
                    poVar.mo29122a(this.f20756a.mo28093j());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int t = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    poVar.mo29122a(this.f20756a.mo28093j());
                } while (this.f20756a.mo28103t() < t);
                m22426d(t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f20756a.mo28093j()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int t2 = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    list.add(Boolean.valueOf(this.f20756a.mo28093j()));
                } while (this.f20756a.mo28103t() < t2);
                m22426d(t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: o */
    public final void mo28159o(List<String> list) throws IOException {
        m22421a(list, false);
    }

    /* renamed from: l */
    public final void mo28153l(List<String> list) throws IOException {
        m22421a(list, true);
    }

    /* renamed from: a */
    private final void m22421a(List<String> list, boolean z) throws IOException {
        int d;
        int d2;
        if ((this.f20757b & 7) != 2) {
            throw zzdok.m29933f();
        } else if (!(list instanceof zzdot) || z) {
            do {
                list.add(z ? mo28155m() : readString());
                if (!this.f20756a.mo28102s()) {
                    d = this.f20756a.mo28086d();
                } else {
                    return;
                }
            } while (d == this.f20757b);
            this.f20759d = d;
        } else {
            zzdot zzdot = (zzdot) list;
            do {
                zzdot.mo31625a(mo28161p());
                if (!this.f20756a.mo28102s()) {
                    d2 = this.f20756a.mo28086d();
                } else {
                    return;
                }
            } while (d2 == this.f20757b);
            this.f20759d = d2;
        }
    }

    /* renamed from: a */
    public final <T> void mo28129a(List<T> list, C9822xp<T> xpVar, zzdno zzdno) throws IOException {
        int d;
        int i = this.f20757b;
        if ((i & 7) == 2) {
            do {
                list.add(m22423c(xpVar, zzdno));
                if (!this.f20756a.mo28102s() && this.f20759d == 0) {
                    d = this.f20756a.mo28086d();
                } else {
                    return;
                }
            } while (d == i);
            this.f20759d = d;
            return;
        }
        throw zzdok.m29933f();
    }

    /* renamed from: b */
    public final <T> void mo28133b(List<T> list, C9822xp<T> xpVar, zzdno zzdno) throws IOException {
        int d;
        int i = this.f20757b;
        if ((i & 7) == 3) {
            do {
                list.add(m22425d(xpVar, zzdno));
                if (!this.f20756a.mo28102s() && this.f20759d == 0) {
                    d = this.f20756a.mo28086d();
                } else {
                    return;
                }
            } while (d == i);
            this.f20759d = d;
            return;
        }
        throw zzdok.m29933f();
    }

    /* renamed from: k */
    public final void mo28152k(List<zzdmr> list) throws IOException {
        int d;
        if ((this.f20757b & 7) == 2) {
            do {
                list.add(mo28161p());
                if (!this.f20756a.mo28102s()) {
                    d = this.f20756a.mo28086d();
                } else {
                    return;
                }
            } while (d == this.f20757b);
            this.f20759d = d;
            return;
        }
        throw zzdok.m29933f();
    }

    /* renamed from: f */
    public final void mo28141f(List<Integer> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            int i = this.f20757b & 7;
            if (i == 0) {
                do {
                    to.mo28619d(this.f20756a.mo28096m());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int t = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    to.mo28619d(this.f20756a.mo28096m());
                } while (this.f20756a.mo28103t() < t);
                m22426d(t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28096m()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int t2 = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28096m()));
                } while (this.f20756a.mo28103t() < t2);
                m22426d(t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: e */
    public final void mo28139e(List<Integer> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            int i = this.f20757b & 7;
            if (i == 0) {
                do {
                    to.mo28619d(this.f20756a.mo28097n());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int t = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    to.mo28619d(this.f20756a.mo28097n());
                } while (this.f20756a.mo28103t() < t);
                m22426d(t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28097n()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int t2 = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28097n()));
                } while (this.f20756a.mo28103t() < t2);
                m22426d(t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: h */
    public final void mo28146h(List<Integer> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            int i = this.f20757b & 7;
            if (i == 2) {
                int m = this.f20756a.mo28096m();
                m22424c(m);
                int t = this.f20756a.mo28103t() + m;
                do {
                    to.mo28619d(this.f20756a.mo28098o());
                } while (this.f20756a.mo28103t() < t);
            } else if (i == 5) {
                do {
                    to.mo28619d(this.f20756a.mo28098o());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 2) {
                int m2 = this.f20756a.mo28096m();
                m22424c(m2);
                int t2 = this.f20756a.mo28103t() + m2;
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28098o()));
                } while (this.f20756a.mo28103t() < t2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28098o()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: g */
    public final void mo28143g(List<Long> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9324ap) {
            C9324ap apVar = (C9324ap) list;
            int i = this.f20757b & 7;
            if (i == 1) {
                do {
                    apVar.mo28856a(this.f20756a.mo28099p());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int m = this.f20756a.mo28096m();
                m22422b(m);
                int t = this.f20756a.mo28103t() + m;
                do {
                    apVar.mo28856a(this.f20756a.mo28099p());
                } while (this.f20756a.mo28103t() < t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.f20756a.mo28099p()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int m2 = this.f20756a.mo28096m();
                m22422b(m2);
                int t2 = this.f20756a.mo28103t() + m2;
                do {
                    list.add(Long.valueOf(this.f20756a.mo28099p()));
                } while (this.f20756a.mo28103t() < t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: b */
    public final void mo28132b(List<Integer> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9156To) {
            C9156To to = (C9156To) list;
            int i = this.f20757b & 7;
            if (i == 0) {
                do {
                    to.mo28619d(this.f20756a.mo28100q());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int t = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    to.mo28619d(this.f20756a.mo28100q());
                } while (this.f20756a.mo28103t() < t);
                m22426d(t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28100q()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int t2 = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    list.add(Integer.valueOf(this.f20756a.mo28100q()));
                } while (this.f20756a.mo28103t() < t2);
                m22426d(t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: a */
    public final void mo28128a(List<Long> list) throws IOException {
        int d;
        int d2;
        if (list instanceof C9324ap) {
            C9324ap apVar = (C9324ap) list;
            int i = this.f20757b & 7;
            if (i == 0) {
                do {
                    apVar.mo28856a(this.f20756a.mo28101r());
                    if (!this.f20756a.mo28102s()) {
                        d2 = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d2 == this.f20757b);
                this.f20759d = d2;
            } else if (i == 2) {
                int t = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    apVar.mo28856a(this.f20756a.mo28101r());
                } while (this.f20756a.mo28103t() < t);
                m22426d(t);
            } else {
                throw zzdok.m29933f();
            }
        } else {
            int i2 = this.f20757b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.f20756a.mo28101r()));
                    if (!this.f20756a.mo28102s()) {
                        d = this.f20756a.mo28086d();
                    } else {
                        return;
                    }
                } while (d == this.f20757b);
                this.f20759d = d;
            } else if (i2 == 2) {
                int t2 = this.f20756a.mo28103t() + this.f20756a.mo28096m();
                do {
                    list.add(Long.valueOf(this.f20756a.mo28101r()));
                } while (this.f20756a.mo28103t() < t2);
                m22426d(t2);
            } else {
                throw zzdok.m29933f();
            }
        }
    }

    /* renamed from: b */
    private static void m22422b(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzdok.m29934g();
        }
    }

    /* renamed from: c */
    private static void m22424c(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzdok.m29934g();
        }
    }

    /* renamed from: d */
    private final void m22426d(int i) throws IOException {
        if (this.f20756a.mo28103t() != i) {
            throw zzdok.m29928a();
        }
    }
}
