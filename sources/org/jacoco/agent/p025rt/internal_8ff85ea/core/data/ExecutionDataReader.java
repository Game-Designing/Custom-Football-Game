package org.jacoco.agent.p025rt.internal_8ff85ea.core.data;

import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.data.CompactDataInput;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.data.ExecutionDataReader */
public class ExecutionDataReader {
    private IExecutionDataVisitor executionDataVisitor = null;
    private boolean firstBlock = true;

    /* renamed from: in */
    protected final CompactDataInput f151in;
    private ISessionInfoVisitor sessionInfoVisitor = null;

    public ExecutionDataReader(InputStream input) {
        this.f151in = new CompactDataInput(input);
    }

    public void setSessionInfoVisitor(ISessionInfoVisitor visitor) {
        this.sessionInfoVisitor = visitor;
    }

    public void setExecutionDataVisitor(IExecutionDataVisitor visitor) {
        this.executionDataVisitor = visitor;
    }

    public boolean read() throws IOException, IncompatibleExecDataVersionException {
        byte type;
        do {
            int i = this.f151in.read();
            if (i == -1) {
                return false;
            }
            type = (byte) i;
            if (!this.firstBlock || type == 1) {
                this.firstBlock = false;
            } else {
                throw new IOException("Invalid execution data file.");
            }
        } while (readBlock(type) != 0);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean readBlock(byte blocktype) throws IOException {
        if (blocktype == 1) {
            readHeader();
            return true;
        } else if (blocktype == 16) {
            readSessionInfo();
            return true;
        } else if (blocktype == 17) {
            readExecutionData();
            return true;
        } else {
            throw new IOException(String.format("Unknown block type %x.", new Object[]{Byte.valueOf(blocktype)}));
        }
    }

    private void readHeader() throws IOException {
        if (this.f151in.readChar() == 49344) {
            char version = this.f151in.readChar();
            if (version != ExecutionDataWriter.FORMAT_VERSION) {
                throw new IncompatibleExecDataVersionException(version);
            }
            return;
        }
        throw new IOException("Invalid execution data file.");
    }

    private void readSessionInfo() throws IOException {
        if (this.sessionInfoVisitor != null) {
            String id = this.f151in.readUTF();
            long start = this.f151in.readLong();
            long dump = this.f151in.readLong();
            ISessionInfoVisitor iSessionInfoVisitor = this.sessionInfoVisitor;
            SessionInfo sessionInfo = new SessionInfo(id, start, dump);
            iSessionInfoVisitor.visitSessionInfo(sessionInfo);
            return;
        }
        throw new IOException("No session info visitor.");
    }

    private void readExecutionData() throws IOException {
        if (this.executionDataVisitor != null) {
            this.executionDataVisitor.visitClassExecution(new ExecutionData(this.f151in.readLong(), this.f151in.readUTF(), this.f151in.readBooleanArray()));
            return;
        }
        throw new IOException("No execution data visitor.");
    }
}
