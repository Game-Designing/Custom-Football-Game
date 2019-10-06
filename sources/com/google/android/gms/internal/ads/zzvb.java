package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzard
public final class zzvb {

    /* renamed from: a */
    private final int f29525a;

    /* renamed from: b */
    private final int f29526b;

    /* renamed from: c */
    private final int f29527c;

    /* renamed from: d */
    private final zzva f29528d = new zzvf();

    public zzvb(int i) {
        this.f29526b = i;
        this.f29525a = 6;
        this.f29527c = 0;
    }

    /* renamed from: a */
    public final String mo32306a(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb.append(((String) obj).toLowerCase(Locale.US));
            sb.append(10);
        }
        return m31284a(sb.toString());
    }

    @VisibleForTesting
    /* renamed from: a */
    private final String m31284a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        C8780Bt bt = new C8780Bt();
        PriorityQueue priorityQueue = new PriorityQueue(this.f29526b, new C8759At(this));
        for (String a : split) {
            String[] a2 = zzve.m31287a(a, false);
            if (a2.length != 0) {
                zzvh.m31293a(a2, this.f29526b, this.f29525a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                bt.mo28066a(this.f29528d.mo32305a(((zzvi) it.next()).f29531b));
            } catch (IOException e) {
                zzbad.m26356b("Error while writing hash to byteStream", e);
            }
        }
        return bt.toString();
    }
}
