package org.jacoco.agent.p025rt.internal_8ff85ea.core.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.data.CompactDataOutput;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.data.ExecutionDataWriter */
public class ExecutionDataWriter implements ISessionInfoVisitor, IExecutionDataVisitor {
    public static final byte BLOCK_EXECUTIONDATA = 17;
    public static final byte BLOCK_HEADER = 1;
    public static final byte BLOCK_SESSIONINFO = 16;
    public static final char FORMAT_VERSION = 4103;
    public static final char MAGIC_NUMBER = '샀';
    protected final CompactDataOutput out;

    public ExecutionDataWriter(OutputStream output) throws IOException {
        this.out = new CompactDataOutput(output);
        writeHeader();
    }

    private void writeHeader() throws IOException {
        this.out.writeByte(1);
        this.out.writeChar(49344);
        this.out.writeChar(FORMAT_VERSION);
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void visitSessionInfo(SessionInfo info) {
        try {
            this.out.writeByte(16);
            this.out.writeUTF(info.getId());
            this.out.writeLong(info.getStartTimeStamp());
            this.out.writeLong(info.getDumpTimeStamp());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void visitClassExecution(ExecutionData data) {
        if (data.hasHits()) {
            try {
                this.out.writeByte(17);
                this.out.writeLong(data.getId());
                this.out.writeUTF(data.getName());
                this.out.writeBooleanArray(data.getProbes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static final byte[] getFileHeader() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            new ExecutionDataWriter(buffer);
            return buffer.toByteArray();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
