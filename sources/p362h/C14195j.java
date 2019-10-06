package p362h;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RemoteControlWriter;

/* renamed from: h.j */
/* compiled from: ByteString */
public class C14195j implements Serializable, Comparable<C14195j> {

    /* renamed from: a */
    static final char[] f43081a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static final C14195j f43082b = m45647a(new byte[0]);

    /* renamed from: c */
    final byte[] f43083c;

    /* renamed from: d */
    transient int f43084d;

    /* renamed from: e */
    transient String f43085e;

    C14195j(byte[] data) {
        this.f43083c = data;
    }

    /* renamed from: a */
    public static C14195j m45647a(byte... data) {
        if (data != null) {
            return new C14195j((byte[]) data.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: c */
    public static C14195j m45649c(String s) {
        if (s != null) {
            C14195j byteString = new C14195j(s.getBytes(C14183E.f43062a));
            byteString.f43085e = s;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: a */
    public static C14195j m45646a(String s, Charset charset) {
        if (s == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new C14195j(s.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    /* renamed from: v */
    public String mo44289v() {
        String result = this.f43085e;
        if (result != null) {
            return result;
        }
        String str = new String(this.f43083c, C14183E.f43062a);
        this.f43085e = str;
        return str;
    }

    /* renamed from: e */
    public String mo44278e() {
        return C14188d.m45558a(this.f43083c);
    }

    /* renamed from: g */
    public C14195j mo44281g() {
        return m45650d("MD5");
    }

    /* renamed from: i */
    public C14195j mo44283i() {
        return m45650d("SHA-1");
    }

    /* renamed from: j */
    public C14195j mo44284j() {
        return m45650d("SHA-256");
    }

    /* renamed from: d */
    private C14195j m45650d(String algorithm) {
        try {
            return m45647a(MessageDigest.getInstance(algorithm).digest(this.f43083c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public static C14195j m45645a(String base64) {
        if (base64 != null) {
            byte[] decoded = C14188d.m45560a(base64);
            if (decoded != null) {
                return new C14195j(decoded);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    /* renamed from: f */
    public String mo44280f() {
        byte[] bArr = this.f43083c;
        char[] result = new char[(bArr.length * 2)];
        int c = 0;
        for (byte b : bArr) {
            int c2 = c + 1;
            char[] cArr = f43081a;
            result[c] = cArr[(b >> 4) & 15];
            c = c2 + 1;
            result[c2] = cArr[b & 15];
        }
        return new String(result);
    }

    /* renamed from: b */
    public static C14195j m45648b(String hex) {
        if (hex == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (hex.length() % 2 == 0) {
            byte[] result = new byte[(hex.length() / 2)];
            for (int i = 0; i < result.length; i++) {
                result[i] = (byte) ((m45642a(hex.charAt(i * 2)) << 4) + m45642a(hex.charAt((i * 2) + 1)));
            }
            return m45647a(result);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected hex string: ");
            sb.append(hex);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    private static int m45642a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected hex digit: ");
        sb.append(c);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public static C14195j m45644a(InputStream in, int byteCount) throws IOException {
        if (in == null) {
            throw new IllegalArgumentException("in == null");
        } else if (byteCount >= 0) {
            byte[] result = new byte[byteCount];
            int offset = 0;
            while (offset < byteCount) {
                int read = in.read(result, offset, byteCount - offset);
                if (read != -1) {
                    offset += read;
                } else {
                    throw new EOFException();
                }
            }
            return new C14195j(result);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(byteCount);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: t */
    public C14195j mo44286t() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f43083c;
            if (i >= bArr.length) {
                return this;
            }
            byte c = bArr[i];
            if (c < 65 || c > 90) {
                i++;
            } else {
                byte[] lowercase = (byte[]) bArr.clone();
                lowercase[i] = (byte) (c + RemoteControlWriter.BLOCK_CMDOK);
                for (int i2 = i + 1; i2 < lowercase.length; i2++) {
                    byte c2 = lowercase[i2];
                    if (c2 >= 65 && c2 <= 90) {
                        lowercase[i2] = (byte) (c2 + RemoteControlWriter.BLOCK_CMDOK);
                    }
                }
                return new C14195j(lowercase);
            }
        }
    }

    /* renamed from: a */
    public C14195j mo44272a(int beginIndex, int endIndex) {
        if (beginIndex >= 0) {
            byte[] bArr = this.f43083c;
            if (endIndex <= bArr.length) {
                int subLen = endIndex - beginIndex;
                if (subLen < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (beginIndex == 0 && endIndex == bArr.length) {
                    return this;
                } else {
                    byte[] copy = new byte[subLen];
                    System.arraycopy(this.f43083c, beginIndex, copy, 0, subLen);
                    return new C14195j(copy);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("endIndex > length(");
                sb.append(this.f43083c.length);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    /* renamed from: a */
    public byte mo44270a(int pos) {
        return this.f43083c[pos];
    }

    /* renamed from: s */
    public int mo44285s() {
        return this.f43083c.length;
    }

    /* renamed from: u */
    public byte[] mo44288u() {
        return (byte[]) this.f43083c.clone();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo44273a(C14191g buffer) {
        byte[] bArr = this.f43083c;
        buffer.write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public boolean mo44274a(int offset, C14195j other, int otherOffset, int byteCount) {
        return other.mo44275a(otherOffset, this.f43083c, offset, byteCount);
    }

    /* renamed from: a */
    public boolean mo44275a(int offset, byte[] other, int otherOffset, int byteCount) {
        if (offset >= 0) {
            byte[] bArr = this.f43083c;
            if (offset <= bArr.length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && C14183E.m45556a(bArr, offset, other, otherOffset, byteCount)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final boolean mo44276b(C14195j prefix) {
        return mo44274a(0, prefix, 0, prefix.mo44285s());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (((p362h.C14195j) r6).mo44275a(0, r3, 0, r3.length) != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof p362h.C14195j
            r2 = 0
            if (r1 == 0) goto L_0x0020
            r1 = r6
            h.j r1 = (p362h.C14195j) r1
            int r1 = r1.mo44285s()
            byte[] r3 = r5.f43083c
            int r4 = r3.length
            if (r1 != r4) goto L_0x0020
            r1 = r6
            h.j r1 = (p362h.C14195j) r1
            int r4 = r3.length
            boolean r1 = r1.mo44275a(r2, r3, r2, r4)
            if (r1 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p362h.C14195j.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int result = this.f43084d;
        if (result != 0) {
            return result;
        }
        int hashCode = Arrays.hashCode(this.f43083c);
        this.f43084d = hashCode;
        return hashCode;
    }

    /* renamed from: a */
    public int compareTo(C14195j byteString) {
        int sizeA = mo44285s();
        int sizeB = byteString.mo44285s();
        int i = 0;
        int size = Math.min(sizeA, sizeB);
        while (true) {
            int i2 = -1;
            if (i < size) {
                int byteA = mo44270a(i) & 255;
                int byteB = byteString.mo44270a(i) & 255;
                if (byteA == byteB) {
                    i++;
                } else {
                    if (byteA >= byteB) {
                        i2 = 1;
                    }
                    return i2;
                }
            } else if (sizeA == sizeB) {
                return 0;
            } else {
                if (sizeA >= sizeB) {
                    i2 = 1;
                }
                return i2;
            }
        }
    }

    public String toString() {
        String str;
        String str2;
        if (this.f43083c.length == 0) {
            return "[size=0]";
        }
        String text = mo44289v();
        int i = m45643a(text, 64);
        String str3 = "…]";
        String str4 = "[size=";
        String str5 = "]";
        if (i == -1) {
            if (this.f43083c.length <= 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[hex=");
                sb.append(mo44280f());
                sb.append(str5);
                str2 = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(this.f43083c.length);
                sb2.append(" hex=");
                sb2.append(mo44272a(0, 64).mo44280f());
                sb2.append(str3);
                str2 = sb2.toString();
            }
            return str2;
        }
        String safeText = text.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (i < text.length()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str4);
            sb3.append(this.f43083c.length);
            sb3.append(" text=");
            sb3.append(safeText);
            sb3.append(str3);
            str = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("[text=");
            sb4.append(safeText);
            sb4.append(str5);
            str = sb4.toString();
        }
        return str;
    }

    /* renamed from: a */
    static int m45643a(String s, int codePointCount) {
        int i = 0;
        int j = 0;
        int length = s.length();
        while (i < length) {
            if (j == codePointCount) {
                return i;
            }
            int c = s.codePointAt(i);
            if ((Character.isISOControl(c) && c != 10 && c != 13) || c == 65533) {
                return -1;
            }
            j++;
            i += Character.charCount(c);
        }
        return s.length();
    }

    private void readObject(ObjectInputStream in) throws IOException {
        C14195j byteString = m45644a((InputStream) in, in.readInt());
        try {
            Field field = C14195j.class.getDeclaredField("c");
            field.setAccessible(true);
            field.set(this, byteString.f43083c);
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.f43083c.length);
        out.write(this.f43083c);
    }
}
