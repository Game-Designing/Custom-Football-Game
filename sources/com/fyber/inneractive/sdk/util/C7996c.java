package com.fyber.inneractive.sdk.util;

import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fyber.inneractive.sdk.util.c */
public final class C7996c {

    /* renamed from: a */
    private static C7996c f16325a = new C7996c();

    /* renamed from: b */
    private Queue<ByteBuffer> f16326b = new ConcurrentLinkedQueue();

    /* renamed from: a */
    public static C7996c m18038a() {
        return f16325a;
    }

    private C7996c() {
        for (int i = 0; i < 2; i++) {
            this.f16326b.offer(ByteBuffer.allocateDirect(Opcodes.ACC_ENUM));
        }
    }

    /* renamed from: b */
    public final ByteBuffer mo24838b() {
        ByteBuffer byteBuffer = (ByteBuffer) this.f16326b.poll();
        return byteBuffer == null ? ByteBuffer.allocateDirect(Opcodes.ACC_ENUM) : byteBuffer;
    }

    /* renamed from: a */
    public final void mo24837a(ByteBuffer byteBuffer) {
        this.f16326b.offer(byteBuffer);
    }

    /* renamed from: b */
    public static byte[] m18039b(ByteBuffer byteBuffer) {
        if (byteBuffer == null || !byteBuffer.hasArray()) {
            return new byte[Opcodes.ACC_ANNOTATION];
        }
        return byteBuffer.array();
    }
}
