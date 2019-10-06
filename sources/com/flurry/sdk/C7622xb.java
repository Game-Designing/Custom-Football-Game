package com.flurry.sdk;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.flurry.sdk.C7436Pb.C7437a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import java.util.UUID;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.flurry.sdk.xb */
public class C7622xb {

    /* renamed from: a */
    private static final String f15129a = C7622xb.class.getSimpleName();

    /* renamed from: b */
    private C7627yb f15130b;

    /* renamed from: c */
    private int f15131c;

    /* renamed from: d */
    private byte[] f15132d;

    /* renamed from: e */
    private final C7436Pb<byte[]> f15133e;

    /* renamed from: f */
    private C7443Qb<C7611vb> f15134f;

    public C7622xb() {
        this.f15130b = null;
        this.f15131c = 0;
        this.f15132d = null;
        this.f15134f = null;
        this.f15134f = new C7443Qb<>(m16855b(), "installationNum", 1, new C7617wb(this));
        this.f15133e = new C7436Pb<>(new C7468Vc());
        this.f15130b = new C7627yb();
        byte[] a = m16854a(m16856c());
        if (a != null && VERSION.SDK_INT >= 23) {
            C7635zd.m16874b(m16855b());
            m16853a(a, C7437a.CRYPTO_ALGO_PADDING_7);
        }
        mo24029a();
    }

    /* renamed from: a */
    public final synchronized byte[] mo24029a() {
        byte[] bArr;
        C7437a aVar;
        bArr = this.f15132d;
        if (bArr == null) {
            if (VERSION.SDK_INT < 23) {
                aVar = C7437a.CRYPTO_ALGO_PADDING_5;
            } else {
                aVar = C7437a.CRYPTO_ALGO_PADDING_7;
            }
            byte[] a = m16854a(m16858e());
            if (a == null) {
                String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.ENGLISH);
                byte[] bArr2 = null;
                if (!TextUtils.isEmpty(lowerCase)) {
                    String replaceAll = lowerCase.replaceAll("[^a-f0-9]+", "");
                    if (replaceAll.length() % 2 != 0) {
                        C7513ec.m16639a(4, f15129a, "Input string must contain an even number of characters ".concat(String.valueOf(replaceAll)));
                    } else {
                        bArr2 = C7354Ad.m16268e(replaceAll);
                    }
                }
                m16853a(bArr2, aVar);
                bArr = bArr2;
            } else {
                bArr = a;
            }
            this.f15132d = bArr;
        }
        return bArr;
    }

    /* renamed from: a */
    private boolean m16853a(byte[] bArr, C7437a aVar) {
        C7611vb vbVar;
        try {
            C7635zd.m16874b(m16855b());
            byte[] d = m16857d();
            byte[] a = this.f15133e.mo23879a(bArr, m16858e(), new IvParameterSpec(d), aVar);
            if (a != null) {
                vbVar = new C7611vb(a, d, true, aVar.ordinal());
            } else {
                vbVar = new C7611vb(bArr, new byte[0], false, aVar.ordinal());
            }
            this.f15134f.mo23882a(vbVar);
            return true;
        } catch (IOException e) {
            String str = f15129a;
            StringBuilder sb = new StringBuilder("Error while generating UUID");
            sb.append(e.getMessage());
            C7513ec.m16640a(5, str, sb.toString(), e);
            return false;
        }
    }

    /* renamed from: a */
    private byte[] m16854a(Key key) {
        byte[] bArr = null;
        try {
            C7611vb vbVar = (C7611vb) this.f15134f.mo23881a();
            if (vbVar == null) {
                return null;
            }
            if (!vbVar.f15112a) {
                return vbVar.f15114c;
            }
            byte[] bArr2 = vbVar.f15113b;
            byte[] bArr3 = vbVar.f15114c;
            C7437a a = C7437a.m16450a(vbVar.f15115d);
            if (!(bArr2 == null || bArr3 == null)) {
                bArr = (byte[]) this.f15133e.mo23878a(bArr3, key, new IvParameterSpec(bArr2), a);
            }
            return bArr;
        } catch (IOException e) {
            C7513ec.m16639a(5, f15129a, "Error while reading Android Install Id. Deleting file.");
            return null;
        }
    }

    /* renamed from: b */
    private static File m16855b() {
        StringBuilder sb = new StringBuilder();
        sb.append(C7635zd.m16871a().getPath());
        sb.append(File.separator);
        sb.append("installationNum");
        return new File(sb.toString());
    }

    /* renamed from: c */
    private static SecretKey m16856c() {
        long j;
        String str = C7379Fb.m16300a().f14436h;
        String a = C7619wd.m16849a(C7379Fb.m16300a().f14432d);
        if (!TextUtils.isEmpty(a)) {
            j = C7354Ad.m16269f(a);
        } else {
            j = Long.MIN_VALUE;
        }
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithSHA256And256BitAES-CBC-BC").generateSecret(new PBEKeySpec(str.toCharArray(), ByteBuffer.allocate(8).putLong(j).array(), 1000, Opcodes.ACC_NATIVE)).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            C7513ec.m16640a(4, f15129a, "Error in generate secret key", e);
            return null;
        }
    }

    /* renamed from: e */
    private Key m16858e() {
        if (VERSION.SDK_INT < 23) {
            return m16856c();
        }
        return this.f15130b.mo24031a();
    }

    /* renamed from: d */
    private static byte[] m16857d() {
        try {
            byte[] bArr = new byte[16];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            return bArr;
        } catch (NoSuchAlgorithmException e) {
            C7513ec.m16640a(4, f15129a, "Error in generating iv", e);
            return null;
        }
    }
}
