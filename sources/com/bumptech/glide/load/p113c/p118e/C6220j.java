package com.bumptech.glide.load.p113c.p118e;

import android.util.Log;
import com.bumptech.glide.load.C6230e;
import com.bumptech.glide.load.C6230e.C6231a;
import com.bumptech.glide.load.C6343f;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6245b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.bumptech.glide.load.c.e.j */
/* compiled from: StreamGifDecoder */
public class C6220j implements C6350l<InputStream, C6208c> {

    /* renamed from: a */
    private final List<C6230e> f10978a;

    /* renamed from: b */
    private final C6350l<ByteBuffer, C6208c> f10979b;

    /* renamed from: c */
    private final C6245b f10980c;

    public C6220j(List<C6230e> parsers, C6350l<ByteBuffer, C6208c> byteBufferDecoder, C6245b byteArrayPool) {
        this.f10978a = parsers;
        this.f10979b = byteBufferDecoder;
        this.f10980c = byteArrayPool;
    }

    /* renamed from: a */
    public boolean mo18973a(InputStream source, C6349k options) throws IOException {
        return !((Boolean) options.mo19310a(C6219i.f10977b)).booleanValue() && C6343f.m12242b(this.f10978a, source, this.f10980c) == C6231a.GIF;
    }

    /* renamed from: a */
    public C6236E<C6208c> mo18972a(InputStream source, int width, int height, C6349k options) throws IOException {
        byte[] data = m11857a(source);
        if (data == null) {
            return null;
        }
        return this.f10979b.mo18972a(ByteBuffer.wrap(data), width, height, options);
    }

    /* renamed from: a */
    private static byte[] m11857a(InputStream is) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(Opcodes.ACC_ENUM);
        try {
            byte[] data = new byte[Opcodes.ACC_ENUM];
            while (true) {
                int read = is.read(data);
                int nRead = read;
                if (read != -1) {
                    buffer.write(data, 0, nRead);
                } else {
                    buffer.flush();
                    return buffer.toByteArray();
                }
            }
        } catch (IOException e) {
            String str = "StreamGifDecoder";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Error reading data from stream", e);
            }
            return null;
        }
    }
}
