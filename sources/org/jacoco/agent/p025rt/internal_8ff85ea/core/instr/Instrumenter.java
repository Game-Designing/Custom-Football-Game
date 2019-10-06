package org.jacoco.agent.p025rt.internal_8ff85ea.core.instr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassReader;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.ClassWriter;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.ContentTypeDetector;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.Java9Support;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.Pack200Streams;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow.ClassProbesAdapter;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr.ClassInstrumenter;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr.ProbeArrayStrategyFactory;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.instr.SignatureRemover;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.instr.Instrumenter */
public class Instrumenter {
    private final IExecutionDataAccessorGenerator accessorGenerator;
    private final SignatureRemover signatureRemover = new SignatureRemover();

    public Instrumenter(IExecutionDataAccessorGenerator runtime) {
        this.accessorGenerator = runtime;
    }

    public void setRemoveSignatures(boolean flag) {
        this.signatureRemover.setActive(flag);
    }

    public byte[] instrument(ClassReader reader) {
        ClassWriter writer = new ClassWriter(reader, 0) {
            /* access modifiers changed from: protected */
            public String getCommonSuperClass(String type1, String type2) {
                throw new IllegalStateException();
            }
        };
        reader.accept(new ClassProbesAdapter(new ClassInstrumenter(ProbeArrayStrategyFactory.createFor(reader, this.accessorGenerator), writer), true), 8);
        return writer.toByteArray();
    }

    public byte[] instrument(byte[] buffer, String name) throws IOException {
        try {
            if (!Java9Support.isPatchRequired(buffer)) {
                return instrument(new ClassReader(buffer));
            }
            byte[] result = instrument(new ClassReader(Java9Support.downgrade(buffer)));
            Java9Support.upgrade(result);
            return result;
        } catch (RuntimeException e) {
            throw instrumentError(name, e);
        }
    }

    public byte[] instrument(InputStream input, String name) throws IOException {
        try {
            return instrument(Java9Support.readFully(input), name);
        } catch (RuntimeException e) {
            throw instrumentError(name, e);
        }
    }

    public void instrument(InputStream input, OutputStream output, String name) throws IOException {
        try {
            output.write(instrument(Java9Support.readFully(input), name));
        } catch (RuntimeException e) {
            throw instrumentError(name, e);
        }
    }

    private IOException instrumentError(String name, RuntimeException cause) {
        IOException ex = new IOException(String.format("Error while instrumenting class %s.", new Object[]{name}));
        ex.initCause(cause);
        return ex;
    }

    public int instrumentAll(InputStream input, OutputStream output, String name) throws IOException {
        ContentTypeDetector detector = new ContentTypeDetector(input);
        int type = detector.getType();
        if (type == -889275714) {
            instrument(detector.getInputStream(), output, name);
            return 1;
        } else if (type == -889270259) {
            return instrumentPack200(detector.getInputStream(), output, name);
        } else {
            if (type == 529203200) {
                return instrumentGzip(detector.getInputStream(), output, name);
            }
            if (type == 1347093252) {
                return instrumentZip(detector.getInputStream(), output, name);
            }
            copy(detector.getInputStream(), output);
            return 0;
        }
    }

    private int instrumentZip(InputStream input, OutputStream output, String name) throws IOException {
        ZipInputStream zipin = new ZipInputStream(input);
        ZipOutputStream zipout = new ZipOutputStream(output);
        int count = 0;
        while (true) {
            ZipEntry nextEntry = zipin.getNextEntry();
            ZipEntry entry = nextEntry;
            if (nextEntry != null) {
                String entryName = entry.getName();
                if (!this.signatureRemover.removeEntry(entryName)) {
                    zipout.putNextEntry(new ZipEntry(entryName));
                    if (!this.signatureRemover.filterEntry(entryName, zipin, zipout)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(name);
                        sb.append("@");
                        sb.append(entryName);
                        count += instrumentAll(zipin, zipout, sb.toString());
                    }
                    zipout.closeEntry();
                }
            } else {
                zipout.finish();
                return count;
            }
        }
    }

    private int instrumentGzip(InputStream input, OutputStream output, String name) throws IOException {
        GZIPOutputStream gzout = new GZIPOutputStream(output);
        int count = instrumentAll(new GZIPInputStream(input), gzout, name);
        gzout.finish();
        return count;
    }

    private int instrumentPack200(InputStream input, OutputStream output, String name) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int count = instrumentAll(Pack200Streams.unpack(input), buffer, name);
        Pack200Streams.pack(buffer.toByteArray(), output);
        return count;
    }

    private void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[Opcodes.ACC_ABSTRACT];
        while (true) {
            int read = input.read(buffer);
            int len = read;
            if (read != -1) {
                output.write(buffer, 0, len);
            } else {
                return;
            }
        }
    }
}
