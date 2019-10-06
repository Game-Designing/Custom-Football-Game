package com.getkeepsafe.relinker.p181a;

import com.getkeepsafe.relinker.p181a.C8053c.C8054a;
import com.getkeepsafe.relinker.p181a.C8053c.C8055b;
import com.getkeepsafe.relinker.p181a.C8053c.C8056c;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.getkeepsafe.relinker.a.f */
/* compiled from: ElfParser */
public class C8060f implements Closeable, C8053c {

    /* renamed from: a */
    private final int f16428a = 1179403647;

    /* renamed from: b */
    private final FileChannel f16429b;

    public C8060f(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f16429b = new FileInputStream(file).getChannel();
    }

    /* renamed from: a */
    public C8055b mo24882a() throws IOException {
        this.f16429b.position(0);
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        if (mo24890e(buffer, 0) == 1179403647) {
            short fileClass = mo24883a(buffer, 4);
            boolean bigEndian = mo24883a(buffer, 5) == 2;
            if (fileClass == 1) {
                return new C8058d(bigEndian, this);
            }
            if (fileClass == 2) {
                return new C8059e(bigEndian, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    /* renamed from: b */
    public List<String> mo24886b() throws IOException {
        long numProgramHeaderEntries;
        long i;
        C8054a dynStructure;
        long vStringTableOff;
        this.f16429b.position(0);
        List<String> dependencies = new ArrayList<>();
        C8055b header = mo24882a();
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(header.f16412a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long numProgramHeaderEntries2 = (long) header.f16417f;
        if (numProgramHeaderEntries2 == 65535) {
            numProgramHeaderEntries = header.mo24881a(0).f16425a;
        } else {
            numProgramHeaderEntries = numProgramHeaderEntries2;
        }
        long i2 = 0;
        while (true) {
            if (i2 >= numProgramHeaderEntries) {
                i = 0;
                break;
            }
            C8056c programHeader = header.mo24880a(i2);
            if (programHeader.f16421a == 2) {
                i = programHeader.f16422b;
                break;
            }
            i2++;
        }
        if (i == 0) {
            return Collections.unmodifiableList(dependencies);
        }
        int i3 = 0;
        List<Long> arrayList = new ArrayList<>();
        long vStringTableOff2 = 0;
        while (true) {
            dynStructure = header.mo24879a(i, i3);
            vStringTableOff = vStringTableOff2;
            long vStringTableOff3 = dynStructure.f16410a;
            if (vStringTableOff3 == 1) {
                arrayList.add(Long.valueOf(dynStructure.f16411b));
            } else if (vStringTableOff3 == 5) {
                vStringTableOff = dynStructure.f16411b;
            }
            int i4 = i3 + 1;
            if (dynStructure.f16410a == 0) {
                break;
            }
            List<Long> neededOffsets = arrayList;
            C8054a aVar = dynStructure;
            vStringTableOff2 = vStringTableOff;
            i3 = i4;
        }
        if (vStringTableOff != 0) {
            List<Long> neededOffsets2 = arrayList;
            C8054a aVar2 = dynStructure;
            long stringTableOff = m18159a(header, numProgramHeaderEntries, vStringTableOff);
            for (Long strOff : neededOffsets2) {
                dependencies.add(mo24889d(buffer, strOff.longValue() + stringTableOff));
            }
            return dependencies;
        }
        List<Long> neededOffsets3 = arrayList;
        C8054a aVar3 = dynStructure;
        throw new IllegalStateException("String table offset not found!");
    }

    /* renamed from: a */
    private long m18159a(C8055b header, long numEntries, long vma) throws IOException {
        for (long i = 0; i < numEntries; i++) {
            C8056c programHeader = header.mo24880a(i);
            if (programHeader.f16421a == 1) {
                long j = programHeader.f16423c;
                if (j <= vma && vma <= programHeader.f16424d + j) {
                    return (vma - j) + programHeader.f16422b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public void close() throws IOException {
        this.f16429b.close();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo24889d(ByteBuffer buffer, long offset) throws IOException {
        StringBuilder builder = new StringBuilder();
        while (true) {
            long offset2 = 1 + offset;
            short a = mo24883a(buffer, offset);
            short c = a;
            if (a == 0) {
                return builder.toString();
            }
            builder.append((char) c);
            offset = offset2;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public long mo24887c(ByteBuffer buffer, long offset) throws IOException {
        mo24884a(buffer, offset, 8);
        return buffer.getLong();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public long mo24890e(ByteBuffer buffer, long offset) throws IOException {
        mo24884a(buffer, offset, 4);
        return ((long) buffer.getInt()) & 4294967295L;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo24885b(ByteBuffer buffer, long offset) throws IOException {
        mo24884a(buffer, offset, 2);
        return buffer.getShort() & 65535;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public short mo24883a(ByteBuffer buffer, long offset) throws IOException {
        mo24884a(buffer, offset, 1);
        return (short) (buffer.get() & 255);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24884a(ByteBuffer buffer, long offset, int length) throws IOException {
        buffer.position(0);
        buffer.limit(length);
        long bytesRead = 0;
        while (bytesRead < ((long) length)) {
            int read = this.f16429b.read(buffer, offset + bytesRead);
            if (read != -1) {
                bytesRead += (long) read;
            } else {
                throw new EOFException();
            }
        }
        buffer.position(0);
    }
}
