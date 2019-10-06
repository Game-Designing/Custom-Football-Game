package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class DataBufferRef {
    @KeepForSdk

    /* renamed from: a */
    protected final DataHolder f19962a;
    @KeepForSdk

    /* renamed from: b */
    protected int f19963b;

    /* renamed from: c */
    private int f19964c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo27662a(int i) {
        Preconditions.m21867b(i >= 0 && i < this.f19962a.getCount());
        this.f19963b = i;
        this.f19964c = this.f19962a.mo27665a(this.f19963b);
    }

    public int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f19963b), Integer.valueOf(this.f19964c), this.f19962a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataBufferRef)) {
            return false;
        }
        DataBufferRef dataBufferRef = (DataBufferRef) obj;
        if (!Objects.m21851a(Integer.valueOf(dataBufferRef.f19963b), Integer.valueOf(this.f19963b)) || !Objects.m21851a(Integer.valueOf(dataBufferRef.f19964c), Integer.valueOf(this.f19964c)) || dataBufferRef.f19962a != this.f19962a) {
            return false;
        }
        return true;
    }
}
