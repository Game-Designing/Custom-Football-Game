package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.Pack200Streams */
public final class Pack200Streams {

    /* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.Pack200Streams$NoCloseInput */
    private static class NoCloseInput extends FilterInputStream {
        protected NoCloseInput(InputStream in) {
            super(in);
        }

        public void close() throws IOException {
        }
    }

    public static InputStream unpack(InputStream input) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        JarOutputStream jar = new JarOutputStream(buffer);
        Pack200.newUnpacker().unpack(new NoCloseInput(input), jar);
        jar.finish();
        return new ByteArrayInputStream(buffer.toByteArray());
    }

    public static void pack(byte[] source, OutputStream output) throws IOException {
        Pack200.newPacker().pack(new JarInputStream(new ByteArrayInputStream(source)), output);
    }

    private Pack200Streams() {
    }
}
