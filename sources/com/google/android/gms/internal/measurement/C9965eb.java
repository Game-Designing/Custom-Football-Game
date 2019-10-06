package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.eb */
final class C9965eb extends IllegalArgumentException {
    C9965eb(int i, int i2) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
        super(sb.toString());
    }
}
