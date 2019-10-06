package com.crashlytics.android.p126c;

/* renamed from: com.crashlytics.android.c.xa */
/* compiled from: MiddleOutStrategy */
class C6529xa implements C6442Oa {

    /* renamed from: a */
    private final int f11724a;

    public C6529xa(int trimmedSize) {
        this.f11724a = trimmedSize;
    }

    /* renamed from: a */
    public StackTraceElement[] mo19452a(StackTraceElement[] stacktrace) {
        int length = stacktrace.length;
        int i = this.f11724a;
        if (length <= i) {
            return stacktrace;
        }
        int backHalf = i / 2;
        int frontHalf = i - backHalf;
        StackTraceElement[] trimmed = new StackTraceElement[i];
        System.arraycopy(stacktrace, 0, trimmed, 0, frontHalf);
        System.arraycopy(stacktrace, stacktrace.length - backHalf, trimmed, frontHalf, backHalf);
        return trimmed;
    }
}
