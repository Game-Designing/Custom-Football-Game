package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@zzard
public final class zzuo {

    /* renamed from: a */
    private final int f29467a;

    /* renamed from: b */
    private final int f29468b;

    /* renamed from: c */
    private final int f29469c;

    /* renamed from: d */
    private final boolean f29470d;

    /* renamed from: e */
    private final zzvb f29471e;

    /* renamed from: f */
    private final zzvk f29472f;

    /* renamed from: g */
    private final Object f29473g = new Object();

    /* renamed from: h */
    private ArrayList<String> f29474h = new ArrayList<>();

    /* renamed from: i */
    private ArrayList<String> f29475i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<zzuz> f29476j = new ArrayList<>();

    /* renamed from: k */
    private int f29477k = 0;

    /* renamed from: l */
    private int f29478l = 0;

    /* renamed from: m */
    private int f29479m = 0;

    /* renamed from: n */
    private int f29480n;

    /* renamed from: o */
    private String f29481o;

    /* renamed from: p */
    private String f29482p;

    /* renamed from: q */
    private String f29483q;

    public zzuo(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        String str = "";
        this.f29481o = str;
        this.f29482p = str;
        this.f29483q = str;
        this.f29467a = i;
        this.f29468b = i2;
        this.f29469c = i3;
        this.f29470d = z;
        this.f29471e = new zzvb(i4);
        this.f29472f = new zzvk(i5, i6, i7);
    }

    /* renamed from: b */
    public final boolean mo32267b() {
        boolean z;
        synchronized (this.f29473g) {
            z = this.f29479m == 0;
        }
        return z;
    }

    /* renamed from: c */
    public final String mo32268c() {
        return this.f29481o;
    }

    /* renamed from: d */
    public final String mo32269d() {
        return this.f29482p;
    }

    /* renamed from: e */
    public final String mo32270e() {
        return this.f29483q;
    }

    /* renamed from: f */
    public final void mo32272f() {
        synchronized (this.f29473g) {
            this.f29480n -= 100;
        }
    }

    /* renamed from: g */
    public final void mo32273g() {
        synchronized (this.f29473g) {
            this.f29479m--;
        }
    }

    /* renamed from: h */
    public final void mo32274h() {
        synchronized (this.f29473g) {
            this.f29479m++;
        }
    }

    /* renamed from: a */
    public final void mo32265a(String str, boolean z, float f, float f2, float f3, float f4) {
        m31240c(str, z, f, f2, f3, f4);
        synchronized (this.f29473g) {
            if (this.f29479m < 0) {
                zzbad.m26352a("ActivityContent: negative number of WebViews.");
            }
            mo32277j();
        }
    }

    /* renamed from: b */
    public final void mo32266b(String str, boolean z, float f, float f2, float f3, float f4) {
        m31240c(str, z, f, f2, f3, f4);
    }

    /* renamed from: c */
    private final void m31240c(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.f29469c) {
            synchronized (this.f29473g) {
                this.f29474h.add(str);
                this.f29477k += str.length();
                if (z) {
                    this.f29475i.add(str);
                    ArrayList<zzuz> arrayList = this.f29476j;
                    zzuz zzuz = new zzuz(f, f2, f3, f4, this.f29475i.size() - 1);
                    arrayList.add(zzuz);
                }
            }
        }
    }

    /* renamed from: i */
    public final void mo32276i() {
        synchronized (this.f29473g) {
            int a = m31238a(this.f29477k, this.f29478l);
            if (a > this.f29480n) {
                this.f29480n = a;
            }
        }
    }

    /* renamed from: j */
    public final void mo32277j() {
        synchronized (this.f29473g) {
            int a = m31238a(this.f29477k, this.f29478l);
            if (a > this.f29480n) {
                this.f29480n = a;
                if (!zzk.zzlk().mo30177i().mo30220i()) {
                    this.f29481o = this.f29471e.mo32306a(this.f29474h);
                    this.f29482p = this.f29471e.mo32306a(this.f29475i);
                }
                if (!zzk.zzlk().mo30177i().mo30219h()) {
                    this.f29483q = this.f29472f.mo32312a(this.f29475i, this.f29476j);
                }
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private final int m31238a(int i, int i2) {
        if (this.f29470d) {
            return this.f29468b;
        }
        return (i * this.f29467a) + (i2 * this.f29468b);
    }

    /* renamed from: a */
    public final int mo32263a() {
        return this.f29480n;
    }

    /* renamed from: a */
    public final void mo32264a(int i) {
        this.f29478l = i;
    }

    /* renamed from: a */
    private static String m31239a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            sb.append((String) obj);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }

    public final String toString() {
        int i = this.f29478l;
        int i2 = this.f29480n;
        int i3 = this.f29477k;
        String a = m31239a(this.f29474h, 100);
        String a2 = m31239a(this.f29475i, 100);
        String str = this.f29481o;
        String str2 = this.f29482p;
        String str3 = this.f29483q;
        StringBuilder sb = new StringBuilder(String.valueOf(a).length() + Opcodes.IF_ACMPEQ + String.valueOf(a2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(a);
        sb.append("\n viewableText");
        sb.append(a2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: k */
    public final int mo32278k() {
        return this.f29477k;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzuo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzuo) obj).f29481o;
        if (str == null || !str.equals(this.f29481o)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f29481o.hashCode();
    }
}
