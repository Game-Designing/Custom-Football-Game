package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;

@zzard
public final class zzvh {
    /* renamed from: a */
    public static void m31293a(String[] strArr, int i, int i2, PriorityQueue<zzvi> priorityQueue) {
        String[] strArr2 = strArr;
        int i3 = i2;
        if (strArr2.length < i3) {
            m31292a(i, m31294b(strArr2, 0, strArr2.length), m31291a(strArr2, 0, strArr2.length), strArr2.length, priorityQueue);
            return;
        }
        long b = m31294b(strArr2, 0, i3);
        m31292a(i, b, m31291a(strArr2, 0, i3), i2, priorityQueue);
        long a = m31290a(16785407, i3 - 1);
        for (int i4 = 1; i4 < (strArr2.length - i3) + 1; i4++) {
            long j = b + 1073807359;
            b = (((((j - ((((((long) zzve.m31286a(strArr2[i4 - 1])) + 2147483647L) % 1073807359) * a) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) zzve.m31286a(strArr2[(i4 + i3) - 1])) + 2147483647L) % 1073807359)) % 1073807359;
            m31292a(i, b, m31291a(strArr2, i4, i3), strArr2.length, priorityQueue);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private static void m31292a(int i, long j, String str, int i2, PriorityQueue<zzvi> priorityQueue) {
        zzvi zzvi = new zzvi(j, str, i2);
        if ((priorityQueue.size() != i || (((zzvi) priorityQueue.peek()).f29532c <= zzvi.f29532c && ((zzvi) priorityQueue.peek()).f29530a <= zzvi.f29530a)) && !priorityQueue.contains(zzvi)) {
            priorityQueue.add(zzvi);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private static String m31291a(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzbad.m26355b("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    /* renamed from: b */
    private static long m31294b(String[] strArr, int i, int i2) {
        long a = (((long) zzve.m31286a(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            a = (((a * 16785407) % 1073807359) + ((((long) zzve.m31286a(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }

    @VisibleForTesting
    /* renamed from: a */
    private static long m31290a(long j, int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return j;
        }
        if (i % 2 == 0) {
            return m31290a((j * j) % 1073807359, i / 2) % 1073807359;
        }
        return (j * (m31290a((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }
}
