package com.google.android.exoplayer2.upstream.cache;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.upstream.cache.Cache.CacheException;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8515f;
import com.google.android.exoplayer2.util.C8538w;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.exoplayer2.upstream.cache.h */
/* compiled from: CachedContentIndex */
class C8472h {

    /* renamed from: a */
    private final HashMap<String, C8471g> f18680a;

    /* renamed from: b */
    private final SparseArray<String> f18681b;

    /* renamed from: c */
    private final SparseBooleanArray f18682c;

    /* renamed from: d */
    private final C8515f f18683d;

    /* renamed from: e */
    private final Cipher f18684e;

    /* renamed from: f */
    private final SecretKeySpec f18685f;

    /* renamed from: g */
    private final boolean f18686g;

    /* renamed from: h */
    private boolean f18687h;

    /* renamed from: i */
    private C8538w f18688i;

    public C8472h(File cacheDir, byte[] secretKey, boolean encrypt) {
        this.f18686g = encrypt;
        if (secretKey != null) {
            C8514e.m20488a(secretKey.length == 16);
            try {
                this.f18684e = m20240e();
                this.f18685f = new SecretKeySpec(secretKey, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
            }
        } else {
            C8514e.m20490b(!encrypt);
            this.f18684e = null;
            this.f18685f = null;
        }
        this.f18680a = new HashMap<>();
        this.f18681b = new SparseArray<>();
        this.f18682c = new SparseBooleanArray();
        this.f18683d = new C8515f(new File(cacheDir, "cached_content_index.exi"));
    }

    /* renamed from: b */
    public void mo25983b() {
        C8514e.m20490b(!this.f18687h);
        if (!m20242f()) {
            this.f18683d.mo26068a();
            this.f18680a.clear();
            this.f18681b.clear();
        }
    }

    /* renamed from: d */
    public void mo25987d() throws CacheException {
        if (this.f18687h) {
            m20243g();
            this.f18687h = false;
            int removedIdCount = this.f18682c.size();
            for (int i = 0; i < removedIdCount; i++) {
                this.f18681b.remove(this.f18682c.keyAt(i));
            }
            this.f18682c.clear();
        }
    }

    /* renamed from: d */
    public C8471g mo25986d(String key) {
        C8471g cachedContent = (C8471g) this.f18680a.get(key);
        return cachedContent == null ? m20241f(key) : cachedContent;
    }

    /* renamed from: b */
    public C8471g mo25982b(String key) {
        return (C8471g) this.f18680a.get(key);
    }

    /* renamed from: a */
    public Collection<C8471g> mo25980a() {
        return this.f18680a.values();
    }

    /* renamed from: a */
    public int mo25978a(String key) {
        return mo25986d(key).f18675a;
    }

    /* renamed from: a */
    public String mo25979a(int id) {
        return (String) this.f18681b.get(id);
    }

    /* renamed from: e */
    public void mo25988e(String key) {
        C8471g cachedContent = (C8471g) this.f18680a.get(key);
        if (cachedContent != null && cachedContent.mo25974c() && !cachedContent.mo25975d()) {
            this.f18680a.remove(key);
            this.f18687h = true;
            this.f18681b.put(cachedContent.f18675a, null);
            this.f18682c.put(cachedContent.f18675a, true);
        }
    }

    /* renamed from: c */
    public void mo25985c() {
        String[] keys = new String[this.f18680a.size()];
        this.f18680a.keySet().toArray(keys);
        for (String key : keys) {
            mo25988e(key);
        }
    }

    /* renamed from: a */
    public void mo25981a(String key, C8475k mutations) {
        if (mo25986d(key).mo25971a(mutations)) {
            this.f18687h = true;
        }
    }

    /* renamed from: c */
    public C8473i mo25984c(String key) {
        C8471g cachedContent = mo25982b(key);
        return cachedContent != null ? cachedContent.mo25965a() : C8476l.f18691a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A[Catch:{ IOException -> 0x00a4, all -> 0x009d }, LOOP:0: B:30:0x0068->B:31:0x006a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0086  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m20242f() {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            com.google.android.exoplayer2.util.f r3 = r11.f18683d     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            java.io.InputStream r3 = r3.mo26070b()     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r3.<init>(r2)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r0 = r3
            int r3 = r0.readInt()     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            if (r3 < 0) goto L_0x0097
            r4 = 2
            if (r3 <= r4) goto L_0x001e
            goto L_0x0097
        L_0x001e:
            int r5 = r0.readInt()     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r6 = r5 & 1
            r7 = 1
            if (r6 == 0) goto L_0x005c
            javax.crypto.Cipher r6 = r11.f18684e     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            if (r6 != 0) goto L_0x0031
            com.google.android.exoplayer2.util.C8509F.m20451a(r0)
            return r1
        L_0x0031:
            r6 = 16
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r0.readFully(r6)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            javax.crypto.spec.IvParameterSpec r8 = new javax.crypto.spec.IvParameterSpec     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r8.<init>(r6)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            javax.crypto.Cipher r9 = r11.f18684e     // Catch:{ InvalidKeyException -> 0x0055, InvalidAlgorithmParameterException -> 0x0053 }
            javax.crypto.spec.SecretKeySpec r10 = r11.f18685f     // Catch:{ InvalidKeyException -> 0x0055, InvalidAlgorithmParameterException -> 0x0053 }
            r9.init(r4, r10, r8)     // Catch:{ InvalidKeyException -> 0x0055, InvalidAlgorithmParameterException -> 0x0053 }
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            javax.crypto.CipherInputStream r9 = new javax.crypto.CipherInputStream     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            javax.crypto.Cipher r10 = r11.f18684e     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r9.<init>(r2, r10)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r4.<init>(r9)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r0 = r4
        L_0x0052:
            goto L_0x0062
        L_0x0053:
            r4 = move-exception
            goto L_0x0056
        L_0x0055:
            r4 = move-exception
        L_0x0056:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r7.<init>(r4)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            throw r7     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
        L_0x005c:
            boolean r4 = r11.f18686g     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            if (r4 == 0) goto L_0x0052
            r11.f18687h = r7     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
        L_0x0062:
            int r4 = r0.readInt()     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r6 = 0
            r8 = 0
        L_0x0068:
            if (r8 >= r4) goto L_0x0079
            com.google.android.exoplayer2.upstream.cache.g r9 = com.google.android.exoplayer2.upstream.cache.C8471g.m20225a(r3, r0)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r11.m20239a(r9)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            int r10 = r9.mo25964a(r3)     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            int r6 = r6 + r10
            int r8 = r8 + 1
            goto L_0x0068
        L_0x0079:
            int r8 = r0.readInt()     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            int r9 = r0.read()     // Catch:{ IOException -> 0x00a4, all -> 0x009d }
            r10 = -1
            if (r9 != r10) goto L_0x0086
            r9 = 1
            goto L_0x0087
        L_0x0086:
            r9 = 0
        L_0x0087:
            if (r8 != r6) goto L_0x0091
            if (r9 != 0) goto L_0x008c
            goto L_0x0091
        L_0x008c:
            com.google.android.exoplayer2.util.C8509F.m20451a(r0)
            return r7
        L_0x0091:
            com.google.android.exoplayer2.util.C8509F.m20451a(r0)
            return r1
        L_0x0097:
            com.google.android.exoplayer2.util.C8509F.m20451a(r0)
            return r1
        L_0x009d:
            r1 = move-exception
            if (r0 == 0) goto L_0x00a3
            com.google.android.exoplayer2.util.C8509F.m20451a(r0)
        L_0x00a3:
            throw r1
        L_0x00a4:
            r2 = move-exception
            if (r0 == 0) goto L_0x00ab
            com.google.android.exoplayer2.util.C8509F.m20451a(r0)
        L_0x00ab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.C8472h.m20242f():boolean");
    }

    /* renamed from: g */
    private void m20243g() throws CacheException {
        DataOutputStream output = null;
        try {
            OutputStream outputStream = this.f18683d.mo26071c();
            if (this.f18688i == null) {
                this.f18688i = new C8538w(outputStream);
            } else {
                this.f18688i.mo26149a(outputStream);
            }
            output = new DataOutputStream(this.f18688i);
            output.writeInt(2);
            output.writeInt(this.f18686g ? 1 : 0);
            if (this.f18686g) {
                byte[] initializationVector = new byte[16];
                new Random().nextBytes(initializationVector);
                output.write(initializationVector);
                try {
                    this.f18684e.init(1, this.f18685f, new IvParameterSpec(initializationVector));
                    output.flush();
                    output = new DataOutputStream(new CipherOutputStream(this.f18688i, this.f18684e));
                } catch (InvalidKeyException e) {
                    e = e;
                } catch (InvalidAlgorithmParameterException e2) {
                    e = e2;
                }
            }
            output.writeInt(this.f18680a.size());
            int hashCode = 0;
            for (C8471g cachedContent : this.f18680a.values()) {
                cachedContent.mo25968a(output);
                hashCode += cachedContent.mo25964a(2);
            }
            output.writeInt(hashCode);
            this.f18683d.mo26069a(output);
            C8509F.m20451a((Closeable) null);
            return;
            throw new IllegalStateException(e);
        } catch (IOException e3) {
            throw new CacheException((Throwable) e3);
        } catch (Throwable th) {
            C8509F.m20451a((Closeable) output);
            throw th;
        }
    }

    /* renamed from: f */
    private C8471g m20241f(String key) {
        C8471g cachedContent = new C8471g(m20238a(this.f18681b), key);
        m20239a(cachedContent);
        this.f18687h = true;
        return cachedContent;
    }

    /* renamed from: a */
    private void m20239a(C8471g cachedContent) {
        this.f18680a.put(cachedContent.f18676b, cachedContent);
        this.f18681b.put(cachedContent.f18675a, cachedContent.f18676b);
    }

    /* renamed from: e */
    private static Cipher m20240e() throws NoSuchPaddingException, NoSuchAlgorithmException {
        String str = "AES/CBC/PKCS5PADDING";
        if (C8509F.f18793a == 18) {
            try {
                return Cipher.getInstance(str, "BC");
            } catch (Throwable th) {
            }
        }
        return Cipher.getInstance(str);
    }

    /* renamed from: a */
    public static int m20238a(SparseArray<String> idToKey) {
        int size = idToKey.size();
        int id = size == 0 ? 0 : idToKey.keyAt(size - 1) + 1;
        if (id < 0) {
            int id2 = 0;
            while (id < size && id == idToKey.keyAt(id)) {
                id2 = id + 1;
            }
        }
        return id;
    }
}
