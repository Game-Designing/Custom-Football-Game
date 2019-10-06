package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Bp */
final class C8776Bp extends C8755Ap<FieldDescriptorType, Object> {
    C8776Bp(int i) {
        super(i, null);
    }

    /* renamed from: b */
    public final void mo28030b() {
        if (!mo28028a()) {
            for (int i = 0; i < mo28031c(); i++) {
                Entry b = mo28029b(i);
                if (((zzdnu) b.getKey()).mo31598m()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Entry entry : mo28034d()) {
                if (((zzdnu) entry.getKey()).mo31598m()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.mo28030b();
    }
}
