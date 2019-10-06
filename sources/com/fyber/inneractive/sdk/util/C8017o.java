package com.fyber.inneractive.sdk.util;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.p165f.C7729a;
import com.fyber.inneractive.sdk.p165f.C7730b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.Reference;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fyber.inneractive.sdk.util.o */
public final class C8017o {

    /* renamed from: com.fyber.inneractive.sdk.util.o$a */
    public static class C8018a {
        /* renamed from: a */
        public static String m18101a(C7730b bVar, C7729a aVar) {
            return bVar.mo24295a(aVar.f15434s);
        }
    }

    /* renamed from: a */
    public static boolean m18100a(String str) {
        if (str == null || "null".equals(str) || str.length() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static String m18095a(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[Opcodes.ACC_SYNTHETIC];
        int i = 0;
        while (i != -1) {
            stringBuffer.append(new String(bArr, 0, i));
            i = inputStream.read(bArr);
        }
        inputStream.close();
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static boolean m18099a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            throw new IOException("Unable to copy from or to a null stream.");
        }
        byte[] bArr = new byte[65536];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
        StringBuilder sb = new StringBuilder("Copied stream content length = ");
        sb.append(i);
        IAlog.m18021b(sb.toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static void m18098a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static String m18096a(Throwable th) {
        String str = "------\r\n";
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            StringBuilder sb = new StringBuilder(str);
            sb.append(stringWriter.toString());
            sb.append(str);
            return sb.toString();
        } catch (Exception e) {
            return "bad stackToString";
        }
    }

    /* renamed from: a */
    public static void m18097a(View view) {
        if (!(view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup))) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    /* renamed from: a */
    public static <T> T m18094a(Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }
}
