package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.upstream.o */
/* compiled from: DefaultLoadErrorHandlingPolicy */
public class C8495o implements C8497q {

    /* renamed from: a */
    private final int f18768a;

    public C8495o() {
        this(-1);
    }

    public C8495o(int minimumLoadableRetryCount) {
        this.f18768a = minimumLoadableRetryCount;
    }

    /* renamed from: a */
    public long mo26032a(int dataType, long loadDurationMs, IOException exception, int errorCount) {
        if (exception instanceof ParserException) {
            return -9223372036854775807L;
        }
        return (long) Math.min((errorCount - 1) * 1000, 5000);
    }

    /* renamed from: a */
    public int mo26031a(int dataType) {
        int i = this.f18768a;
        if (i != -1) {
            return i;
        }
        return dataType == 7 ? 6 : 3;
    }
}
