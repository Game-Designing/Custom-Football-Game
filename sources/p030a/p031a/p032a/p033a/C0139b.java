package p030a.p031a.p032a.p033a;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: a.a.a.a.b */
/* compiled from: PRNGFixes */
public class C0139b {

    /* renamed from: a */
    private static final byte[] f170a = m786e();

    /* renamed from: a.a.a.a.b$a */
    /* compiled from: PRNGFixes */
    public static class C0140a extends SecureRandomSpi {

        /* renamed from: a */
        private static final File f171a = new File("/dev/urandom");

        /* renamed from: b */
        private static final Object f172b = new Object();

        /* renamed from: c */
        private static DataInputStream f173c;

        /* renamed from: d */
        private static OutputStream f174d;

        /* renamed from: e */
        private boolean f175e;

        /* access modifiers changed from: protected */
        public void engineSetSeed(byte[] bytes) {
            OutputStream out;
            try {
                synchronized (f172b) {
                    out = m790b();
                }
                out.write(bytes);
                out.flush();
                this.f175e = true;
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to mix seed into ");
                sb.append(f171a);
                throw new SecurityException(sb.toString(), e);
            }
        }

        /* access modifiers changed from: protected */
        public void engineNextBytes(byte[] bytes) {
            DataInputStream in;
            if (!this.f175e) {
                engineSetSeed(C0139b.m785d());
            }
            try {
                synchronized (f172b) {
                    in = m789a();
                }
                synchronized (in) {
                    in.readFully(bytes);
                }
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to read from ");
                sb.append(f171a);
                throw new SecurityException(sb.toString(), e);
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGenerateSeed(int size) {
            byte[] seed = new byte[size];
            engineNextBytes(seed);
            return seed;
        }

        /* renamed from: a */
        private DataInputStream m789a() {
            DataInputStream dataInputStream;
            synchronized (f172b) {
                if (f173c == null) {
                    try {
                        f173c = new DataInputStream(new FileInputStream(f171a));
                    } catch (IOException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to open ");
                        sb.append(f171a);
                        sb.append(" for reading");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                dataInputStream = f173c;
            }
            return dataInputStream;
        }

        /* renamed from: b */
        private OutputStream m790b() {
            OutputStream outputStream;
            synchronized (f172b) {
                if (f174d == null) {
                    try {
                        f174d = new FileOutputStream(f171a);
                    } catch (IOException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to open ");
                        sb.append(f171a);
                        sb.append(" for writing");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                outputStream = f174d;
            }
            return outputStream;
        }
    }

    /* renamed from: a.a.a.a.b$b */
    /* compiled from: PRNGFixes */
    private static class C0141b extends Provider {
        public C0141b() {
            super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
            put("SecureRandom.SHA1PRNG", C0140a.class.getName());
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    /* renamed from: b */
    public static void m783b() {
        m784c();
        m788g();
    }

    /* renamed from: c */
    private static void m784c() throws SecurityException {
        int i = VERSION.SDK_INT;
        if (i >= 16 && i <= 18) {
            try {
                Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[]{byte[].class}).invoke(null, new Object[]{m785d()});
                int bytesRead = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[]{String.class, Long.TYPE}).invoke(null, new Object[]{"/dev/urandom", Integer.valueOf(Opcodes.ACC_ABSTRACT)})).intValue();
                if (bytesRead != 1024) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected number of bytes read from Linux PRNG: ");
                    sb.append(bytesRead);
                    throw new IOException(sb.toString());
                }
            } catch (Exception e) {
                throw new SecurityException("Failed to seed OpenSSL PRNG", e);
            }
        }
    }

    /* renamed from: g */
    private static void m788g() throws SecurityException {
        if (VERSION.SDK_INT <= 18) {
            Provider[] secureRandomProviders = Security.getProviders("SecureRandom.SHA1PRNG");
            if (secureRandomProviders == null || secureRandomProviders.length < 1 || !C0141b.class.equals(secureRandomProviders[0].getClass())) {
                Security.insertProviderAt(new C0141b(), 1);
            }
            SecureRandom rng1 = new SecureRandom();
            if (C0141b.class.equals(rng1.getProvider().getClass())) {
                try {
                    SecureRandom rng2 = SecureRandom.getInstance("SHA1PRNG");
                    if (!C0141b.class.equals(rng2.getProvider().getClass())) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: ");
                        sb.append(rng2.getProvider().getClass());
                        throw new SecurityException(sb.toString());
                    }
                } catch (NoSuchAlgorithmException e) {
                    throw new SecurityException("SHA1PRNG not available", e);
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("new SecureRandom() backed by wrong Provider: ");
                sb2.append(rng1.getProvider().getClass());
                throw new SecurityException(sb2.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static byte[] m785d() {
        try {
            ByteArrayOutputStream seedBuffer = new ByteArrayOutputStream();
            DataOutputStream seedBufferOut = new DataOutputStream(seedBuffer);
            seedBufferOut.writeLong(System.currentTimeMillis());
            seedBufferOut.writeLong(System.nanoTime());
            seedBufferOut.writeInt(Process.myPid());
            seedBufferOut.writeInt(Process.myUid());
            seedBufferOut.write(f170a);
            seedBufferOut.close();
            return seedBuffer.toByteArray();
        } catch (IOException e) {
            throw new SecurityException("Failed to generate seed", e);
        }
    }

    /* renamed from: f */
    private static String m787f() {
        try {
            return (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: e */
    private static byte[] m786e() {
        StringBuilder result = new StringBuilder();
        String fingerprint = Build.FINGERPRINT;
        if (fingerprint != null) {
            result.append(fingerprint);
        }
        String serial = m787f();
        if (serial != null) {
            result.append(serial);
        }
        try {
            return result.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }
}
