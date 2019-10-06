package com.crashlytics.android.p126c;

import java.io.IOException;
import java.io.InputStream;
import p024io.fabric.sdk.android.p348a.p350b.C13832C.C13835c;

/* renamed from: com.crashlytics.android.c.Fa */
/* compiled from: QueueFileLogStore */
class C6417Fa implements C13835c {

    /* renamed from: a */
    final /* synthetic */ byte[] f11487a;

    /* renamed from: b */
    final /* synthetic */ int[] f11488b;

    /* renamed from: c */
    final /* synthetic */ C6419Ga f11489c;

    C6417Fa(C6419Ga this$0, byte[] bArr, int[] iArr) {
        this.f11489c = this$0;
        this.f11487a = bArr;
        this.f11488b = iArr;
    }

    /* renamed from: a */
    public void mo19446a(InputStream in, int length) throws IOException {
        try {
            in.read(this.f11487a, this.f11488b[0], length);
            int[] iArr = this.f11488b;
            iArr[0] = iArr[0] + length;
        } finally {
            in.close();
        }
    }
}
