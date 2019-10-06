package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.ads.Bt */
final class C8780Bt {
    @VisibleForTesting

    /* renamed from: a */
    private ByteArrayOutputStream f20528a = new ByteArrayOutputStream(Opcodes.ACC_SYNTHETIC);
    @VisibleForTesting

    /* renamed from: b */
    private Base64OutputStream f20529b = new Base64OutputStream(this.f20528a, 10);

    /* renamed from: a */
    public final void mo28066a(byte[] bArr) throws IOException {
        this.f20529b.write(bArr);
    }

    public final String toString() {
        String str = "HashManager: Unable to convert to Base64.";
        try {
            this.f20529b.close();
        } catch (IOException e) {
            zzbad.m26356b(str, e);
        }
        try {
            this.f20528a.close();
            return this.f20528a.toString();
        } catch (IOException e2) {
            zzbad.m26356b(str, e2);
            return "";
        } finally {
            this.f20528a = null;
            this.f20529b = null;
        }
    }
}
