package p019d.p135a.p136a;

import android.content.BroadcastReceiver;
import p019d.p135a.p136a.p137a.C6846b;
import p019d.p135a.p136a.p137a.C6847c;
import p019d.p135a.p136a.p137a.C6849e;

/* renamed from: d.a.a.j */
/* compiled from: PaymentBroadcastReceivers */
class C6918j {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f12696a = C6918j.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C6919k f12697b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C6924p f12698c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C6849e f12699d = new C6877c(this);

    /* renamed from: e */
    private C6846b f12700e = new C6898d(this);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C6847c f12701f = new C6900e(this);

    /* renamed from: g */
    private BroadcastReceiver f12702g = new C6914f(this);

    /* renamed from: h */
    private BroadcastReceiver f12703h = new C6915g(this);

    /* renamed from: i */
    private BroadcastReceiver f12704i = new C6916h(this);

    /* renamed from: j */
    private BroadcastReceiver f12705j = new C6917i(this);

    C6918j(C6924p paymentStateHandler, C6919k paymentRequest) {
        this.f12697b = paymentRequest;
        this.f12698c = paymentStateHandler;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public BroadcastReceiver mo22373h() {
        return this.f12702g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public BroadcastReceiver mo22372g() {
        return this.f12703h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public BroadcastReceiver mo22370e() {
        return this.f12704i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public BroadcastReceiver mo22367b() {
        return this.f12705j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C6849e mo22371f() {
        return this.f12699d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C6847c mo22369d() {
        return this.f12701f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C6846b mo22368c() {
        return this.f12700e;
    }
}
