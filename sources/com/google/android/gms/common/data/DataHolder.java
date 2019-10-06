package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@KeepName
@KeepForSdk
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @KeepForSdk
    public static final Creator<DataHolder> CREATOR = new zac();

    /* renamed from: a */
    private static final Builder f19967a = new C8692a(new String[0], null);

    /* renamed from: b */
    private final int f19968b;

    /* renamed from: c */
    private final String[] f19969c;

    /* renamed from: d */
    private Bundle f19970d;

    /* renamed from: e */
    private final CursorWindow[] f19971e;

    /* renamed from: f */
    private final int f19972f;

    /* renamed from: g */
    private final Bundle f19973g;

    /* renamed from: h */
    private int[] f19974h;

    /* renamed from: i */
    private int f19975i;

    /* renamed from: j */
    private boolean f19976j = false;

    /* renamed from: k */
    private boolean f19977k = true;

    @KeepForSdk
    public static class Builder {

        /* renamed from: a */
        private final String[] f19978a;

        /* renamed from: b */
        private final ArrayList<HashMap<String, Object>> f19979b;

        /* renamed from: c */
        private final String f19980c;

        /* renamed from: d */
        private final HashMap<Object, Integer> f19981d;

        /* renamed from: e */
        private boolean f19982e;

        /* renamed from: f */
        private String f19983f;

        private Builder(String[] strArr, String str) {
            Preconditions.m21857a(strArr);
            this.f19978a = strArr;
            this.f19979b = new ArrayList<>();
            this.f19980c = str;
            this.f19981d = new HashMap<>();
            this.f19982e = false;
            this.f19983f = null;
        }

        /* synthetic */ Builder(String[] strArr, String str, C8692a aVar) {
            this(strArr, null);
        }
    }

    public static class zaa extends RuntimeException {
    }

    @Constructor
    DataHolder(@Param(id = 1000) int i, @Param(id = 1) String[] strArr, @Param(id = 2) CursorWindow[] cursorWindowArr, @Param(id = 3) int i2, @Param(id = 4) Bundle bundle) {
        this.f19968b = i;
        this.f19969c = strArr;
        this.f19971e = cursorWindowArr;
        this.f19972f = i2;
        this.f19973g = bundle;
    }

    /* renamed from: d */
    public final void mo27671d() {
        this.f19970d = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.f19969c;
            if (i2 >= strArr.length) {
                break;
            }
            this.f19970d.putInt(strArr[i2], i2);
            i2++;
        }
        this.f19974h = new int[this.f19971e.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f19971e;
            if (i < cursorWindowArr.length) {
                this.f19974h[i] = i3;
                i3 += this.f19971e[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
                i++;
            } else {
                this.f19975i = i3;
                return;
            }
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21971a(parcel, 1, this.f19969c, false);
        SafeParcelWriter.m21970a(parcel, 2, (T[]) this.f19971e, i, false);
        SafeParcelWriter.m21957a(parcel, 3, mo27669c());
        SafeParcelWriter.m21959a(parcel, 4, mo27666a(), false);
        SafeParcelWriter.m21957a(parcel, 1000, this.f19968b);
        SafeParcelWriter.m21954a(parcel, a);
        if ((i & 1) != 0) {
            close();
        }
    }

    @KeepForSdk
    /* renamed from: c */
    public final int mo27669c() {
        return this.f19972f;
    }

    @KeepForSdk
    /* renamed from: a */
    public final Bundle mo27666a() {
        return this.f19973g;
    }

    /* renamed from: a */
    private final void m21703a(String str, int i) {
        Bundle bundle = this.f19970d;
        if (bundle == null || !bundle.containsKey(str)) {
            String str2 = "No such column: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.f19975i) {
            throw new CursorIndexOutOfBoundsException(i, this.f19975i);
        }
    }

    @KeepForSdk
    /* renamed from: b */
    public final String mo27668b(String str, int i, int i2) {
        m21703a(str, i);
        return this.f19971e[i2].getString(i, this.f19970d.getInt(str));
    }

    @KeepForSdk
    /* renamed from: a */
    public final byte[] mo27667a(String str, int i, int i2) {
        m21703a(str, i);
        return this.f19971e[i2].getBlob(i, this.f19970d.getInt(str));
    }

    @KeepForSdk
    public final int getCount() {
        return this.f19975i;
    }

    @KeepForSdk
    /* renamed from: a */
    public final int mo27665a(int i) {
        int i2 = 0;
        Preconditions.m21867b(i >= 0 && i < this.f19975i);
        while (true) {
            int[] iArr = this.f19974h;
            if (i2 >= iArr.length) {
                break;
            } else if (i < iArr[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        if (i2 == this.f19974h.length) {
            return i2 - 1;
        }
        return i2;
    }

    @KeepForSdk
    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.f19976j;
        }
        return z;
    }

    @KeepForSdk
    public final void close() {
        synchronized (this) {
            if (!this.f19976j) {
                this.f19976j = true;
                for (CursorWindow close : this.f19971e) {
                    close.close();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.f19977k && this.f19971e.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + Opcodes.GETSTATIC);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }
}
