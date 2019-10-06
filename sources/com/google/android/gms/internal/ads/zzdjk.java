package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzdjk implements zzdbj {

    /* renamed from: a */
    private final byte[] f27903a;

    /* renamed from: b */
    private final byte[] f27904b;

    /* renamed from: c */
    private final SecretKeySpec f27905c;

    /* renamed from: d */
    private final int f27906d;

    public zzdjk(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.f27906d = i;
            zzdlx.m29630a(bArr.length);
            this.f27905c = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
            instance.init(1, this.f27905c);
            this.f27903a = m29582a(instance.doFinal(new byte[16]));
            this.f27904b = m29582a(this.f27903a);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    /* renamed from: b */
    private static byte[] m29583b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    /* renamed from: a */
    private static byte[] m29582a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7));
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i = Opcodes.I2D;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    /* renamed from: a */
    private final byte[] m29581a(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(m29583b(bArr3, this.f27903a));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        byte[] bArr4 = doFinal;
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArr4[i5] = (byte) (bArr4[i5] ^ bArr[(i2 + i4) + i5]);
            }
            bArr4 = cipher.doFinal(bArr4);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = m29583b(copyOfRange, this.f27903a);
        } else {
            byte[] copyOf = Arrays.copyOf(this.f27904b, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(m29583b(bArr4, bArr2));
    }

    /* renamed from: a */
    public final byte[] mo28854a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        byte[] bArr4 = bArr;
        int length = bArr4.length;
        int i = this.f27906d;
        if (length <= (MoPubClientPositioning.NO_REPEAT - i) - 16) {
            byte[] bArr5 = new byte[(bArr4.length + i + 16)];
            byte[] a = zzdlo.m29627a(i);
            System.arraycopy(a, 0, bArr5, 0, this.f27906d);
            Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
            instance.init(1, this.f27905c);
            byte[] a2 = m29581a(instance, 0, a, 0, a.length);
            if (bArr2 == null) {
                bArr3 = new byte[0];
            } else {
                bArr3 = bArr2;
            }
            byte[] a3 = m29581a(instance, 1, bArr3, 0, bArr3.length);
            Cipher instance2 = Cipher.getInstance("AES/CTR/NOPADDING");
            instance2.init(1, this.f27905c, new IvParameterSpec(a2));
            instance2.doFinal(bArr, 0, bArr4.length, bArr5, this.f27906d);
            byte[] a4 = m29581a(instance, 2, bArr5, this.f27906d, bArr4.length);
            int length2 = bArr4.length + this.f27906d;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr5[length2 + i2] = (byte) ((a3[i2] ^ a2[i2]) ^ a4[i2]);
            }
            return bArr5;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
