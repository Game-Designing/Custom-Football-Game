package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {

    /* renamed from: b */
    private boolean f19984b;

    /* renamed from: c */
    private ArrayList<Integer> f19985c;

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public abstract T mo27676a(int i, int i2);

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: c */
    public abstract String mo27678c();

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
        if (r6.f19952a.mo27668b(r4, r7, r3) == null) goto L_0x006a;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get(int r7) {
        /*
            r6 = this;
            r6.m21711d()
            int r0 = r6.m21710a(r7)
            r1 = 0
            if (r7 < 0) goto L_0x0069
            java.util.ArrayList<java.lang.Integer> r2 = r6.f19985c
            int r2 = r2.size()
            if (r7 != r2) goto L_0x0013
            goto L_0x0069
        L_0x0013:
            java.util.ArrayList<java.lang.Integer> r2 = r6.f19985c
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            if (r7 != r2) goto L_0x0031
            com.google.android.gms.common.data.DataHolder r2 = r6.f19952a
            int r2 = r2.getCount()
            java.util.ArrayList<java.lang.Integer> r4 = r6.f19985c
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r2 = r2 - r4
            goto L_0x004c
        L_0x0031:
            java.util.ArrayList<java.lang.Integer> r2 = r6.f19985c
            int r4 = r7 + 1
            java.lang.Object r2 = r2.get(r4)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.ArrayList<java.lang.Integer> r4 = r6.f19985c
            java.lang.Object r4 = r4.get(r7)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r2 = r2 - r4
        L_0x004c:
            if (r2 != r3) goto L_0x0067
            int r7 = r6.m21710a(r7)
            com.google.android.gms.common.data.DataHolder r3 = r6.f19952a
            int r3 = r3.mo27665a(r7)
            java.lang.String r4 = r6.mo27677b()
            if (r4 == 0) goto L_0x0067
            com.google.android.gms.common.data.DataHolder r5 = r6.f19952a
            java.lang.String r7 = r5.mo27668b(r4, r7, r3)
            if (r7 != 0) goto L_0x0067
            goto L_0x006a
        L_0x0067:
            r1 = r2
            goto L_0x006a
        L_0x0069:
        L_0x006a:
            java.lang.Object r7 = r6.mo27676a(r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.EntityBuffer.get(int):java.lang.Object");
    }

    @KeepForSdk
    public int getCount() {
        m21711d();
        return this.f19985c.size();
    }

    /* renamed from: d */
    private final void m21711d() {
        synchronized (this) {
            if (!this.f19984b) {
                int count = this.f19952a.getCount();
                this.f19985c = new ArrayList<>();
                if (count > 0) {
                    this.f19985c.add(Integer.valueOf(0));
                    String c = mo27678c();
                    String b = this.f19952a.mo27668b(c, 0, this.f19952a.mo27665a(0));
                    int i = 1;
                    while (i < count) {
                        int a = this.f19952a.mo27665a(i);
                        String b2 = this.f19952a.mo27668b(c, i, a);
                        if (b2 != null) {
                            if (!b2.equals(b)) {
                                this.f19985c.add(Integer.valueOf(i));
                                b = b2;
                            }
                            i++;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(c);
                            sb.append(", at row: ");
                            sb.append(i);
                            sb.append(", for window: ");
                            sb.append(a);
                            throw new NullPointerException(sb.toString());
                        }
                    }
                }
                this.f19984b = true;
            }
        }
    }

    /* renamed from: a */
    private final int m21710a(int i) {
        if (i >= 0 && i < this.f19985c.size()) {
            return ((Integer) this.f19985c.get(i)).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: b */
    public String mo27677b() {
        return null;
    }
}
