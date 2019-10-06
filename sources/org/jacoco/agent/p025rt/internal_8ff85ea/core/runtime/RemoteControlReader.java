package org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime;

import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataReader;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.RemoteControlReader */
public class RemoteControlReader extends ExecutionDataReader {
    private IRemoteCommandVisitor remoteCommandVisitor;

    public RemoteControlReader(InputStream input) throws IOException {
        super(input);
    }

    /* access modifiers changed from: protected */
    public boolean readBlock(byte blockid) throws IOException {
        if (blockid == 32) {
            return false;
        }
        if (blockid != 64) {
            return super.readBlock(blockid);
        }
        readDumpCommand();
        return true;
    }

    public void setRemoteCommandVisitor(IRemoteCommandVisitor visitor) {
        this.remoteCommandVisitor = visitor;
    }

    private void readDumpCommand() throws IOException {
        if (this.remoteCommandVisitor != null) {
            this.remoteCommandVisitor.visitDumpCommand(this.f151in.readBoolean(), this.f151in.readBoolean());
            return;
        }
        throw new IOException("No remote command visitor.");
    }
}
