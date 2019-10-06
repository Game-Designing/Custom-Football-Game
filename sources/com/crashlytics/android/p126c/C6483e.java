package com.crashlytics.android.p126c;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p350b.C13868y;

/* renamed from: com.crashlytics.android.c.e */
/* compiled from: CLSUUID */
class C6483e {

    /* renamed from: a */
    private static final AtomicLong f11645a = new AtomicLong(0);

    /* renamed from: b */
    private static String f11646b;

    public C6483e(C13868y idManager) {
        byte[] bytes = new byte[10];
        m12669c(bytes);
        m12667b(bytes);
        m12665a(bytes);
        String idSha = C13852l.m44048c(idManager.mo43262d());
        String timeSeqPid = C13852l.m44030a(bytes);
        f11646b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{timeSeqPid.substring(0, 12), timeSeqPid.substring(12, 16), timeSeqPid.subSequence(16, 20), idSha.substring(0, 12)}).toUpperCase(Locale.US);
    }

    /* renamed from: c */
    private void m12669c(byte[] bytes) {
        long time = new Date().getTime();
        long tvUsec = time % 1000;
        byte[] timeBytes = m12666a(time / 1000);
        bytes[0] = timeBytes[0];
        bytes[1] = timeBytes[1];
        bytes[2] = timeBytes[2];
        bytes[3] = timeBytes[3];
        byte[] msecsBytes = m12668b(tvUsec);
        bytes[4] = msecsBytes[0];
        bytes[5] = msecsBytes[1];
    }

    /* renamed from: b */
    private void m12667b(byte[] bytes) {
        byte[] sequenceBytes = m12668b(f11645a.incrementAndGet());
        bytes[6] = sequenceBytes[0];
        bytes[7] = sequenceBytes[1];
    }

    /* renamed from: a */
    private void m12665a(byte[] bytes) {
        byte[] pidBytes = m12668b((long) Integer.valueOf(Process.myPid()).shortValue());
        bytes[8] = pidBytes[0];
        bytes[9] = pidBytes[1];
    }

    /* renamed from: a */
    private static byte[] m12666a(long value) {
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.putInt((int) value);
        buf.order(ByteOrder.BIG_ENDIAN);
        buf.position(0);
        return buf.array();
    }

    /* renamed from: b */
    private static byte[] m12668b(long value) {
        ByteBuffer buf = ByteBuffer.allocate(2);
        buf.putShort((short) ((int) value));
        buf.order(ByteOrder.BIG_ENDIAN);
        buf.position(0);
        return buf.array();
    }

    public String toString() {
        return f11646b;
    }
}
