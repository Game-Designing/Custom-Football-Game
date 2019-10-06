package p026rx.p390c.p395e.p397b;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: rx.c.e.b.u */
/* compiled from: SpscArrayQueue */
abstract class C14860u<E> extends C14845f<E> {

    /* renamed from: f */
    private static final Integer f44143f = Integer.getInteger("jctools.spsc.max.lookahead.step", Opcodes.ACC_SYNTHETIC);

    /* renamed from: g */
    protected final int f44144g;

    public C14860u(int capacity) {
        super(capacity);
        this.f44144g = Math.min(capacity / 4, f44143f.intValue());
    }
}
