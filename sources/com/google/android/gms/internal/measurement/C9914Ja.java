package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.Ja */
final class C9914Ja extends C9912Ia<FieldDescriptorType, Object> {
    C9914Ja(int i) {
        super(i, null);
    }

    /* renamed from: b */
    public final void mo32568b() {
        if (!mo32566a()) {
            for (int i = 0; i < mo32569c(); i++) {
                Entry b = mo32567b(i);
                if (((zzuh) b.getKey()).mo32889q()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Entry entry : mo32572d()) {
                if (((zzuh) entry.getKey()).mo32889q()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.mo32568b();
    }
}
