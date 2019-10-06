package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp.zza;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import com.google.android.gms.internal.ads.zzbp.zza.zzd;
import com.google.android.gms.internal.ads.zzbp.zzg;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.ads.aj */
final class C9318aj {

    /* renamed from: a */
    private static boolean f22088a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static MessageDigest f22089b = null;

    /* renamed from: c */
    private static final Object f22090c = new Object();

    /* renamed from: d */
    private static final Object f22091d = new Object();

    /* renamed from: e */
    static CountDownLatch f22092e = new CountDownLatch(1);

    /* renamed from: a */
    static void m23433a() {
        synchronized (f22091d) {
            if (!f22088a) {
                f22088a = true;
                new Thread(new C9795wj()).start();
            }
        }
    }

    /* renamed from: b */
    private static MessageDigest m23436b() {
        boolean z;
        m23433a();
        try {
            z = f22092e.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            z = false;
        }
        if (!z) {
            return null;
        }
        MessageDigest messageDigest = f22089b;
        if (messageDigest == null) {
            return null;
        }
        return messageDigest;
    }

    /* renamed from: a */
    static String m23430a(zza zza, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        byte[] byteArray = zza.toByteArray();
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24163rc)).booleanValue()) {
            Vector a = m23432a(byteArray, 255);
            if (a == null || a.size() == 0) {
                bArr = m23435a(m23429a(zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            } else {
                zzg.zza l = zzg.m27631l();
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    l.mo30851a(zzdmr.m29656b(m23435a((byte[]) it.next(), str, false)));
                }
                l.mo30852b(zzdmr.m29656b(m23434a(byteArray)));
                bArr = ((zzg) l.mo31612g()).toByteArray();
            }
        } else if (C8777Bq.f20522a != null) {
            bArr = ((zzg) zzg.m27631l().mo30851a(zzdmr.m29656b(C8777Bq.f20522a.mo28946a(byteArray, str != null ? str.getBytes() : new byte[0]))).mo30850a(zzbw.TINK_HYBRID).mo31612g()).toByteArray();
        } else {
            throw new GeneralSecurityException();
        }
        return zzcg.m28402a(bArr, true);
    }

    /* renamed from: a */
    private static Vector<byte[]> m23432a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    /* renamed from: a */
    private static zza m23429a(zzd zzd) {
        C15005zza p = zza.m27422p();
        p.mo30797j((long) zzd.mo30728d());
        return (zza) p.mo31612g();
    }

    /* renamed from: a */
    private static byte[] m23435a(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArr2;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = m23429a(zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr3 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArr2 = ByteBuffer.allocate(Opcodes.ACC_NATIVE).put(m23434a(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[Opcodes.ACC_NATIVE];
        for (C9451gk a : new zzcl().f26819Lc) {
            a.mo28199a(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzdmh(str.getBytes("UTF-8")).mo31529a(bArr4);
        }
        return bArr4;
    }

    /* renamed from: a */
    public static byte[] m23434a(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (f22090c) {
            MessageDigest b = m23436b();
            if (b != null) {
                b.reset();
                b.update(bArr);
                digest = f22089b.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }
}
