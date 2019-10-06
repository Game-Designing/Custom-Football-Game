package android.support.p001v7.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.v7.app.w */
/* compiled from: AppCompatDelegateImplV9 */
class C0789w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0737D f2378a;

    C0789w(C0737D this$0) {
        this.f2378a = this$0;
    }

    public void run() {
        C0737D d = this.f2378a;
        if ((d.f2198O & 1) != 0) {
            d.mo6103e(0);
        }
        C0737D d2 = this.f2378a;
        if ((d2.f2198O & Opcodes.ACC_SYNTHETIC) != 0) {
            d2.mo6103e(108);
        }
        C0737D d3 = this.f2378a;
        d3.f2197N = false;
        d3.f2198O = 0;
    }
}
