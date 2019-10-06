package org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime;

import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.RemoteControlWriter */
public class RemoteControlWriter extends ExecutionDataWriter implements IRemoteCommandVisitor {
    public static final byte BLOCK_CMDDUMP = 64;
    public static final byte BLOCK_CMDOK = 32;

    public RemoteControlWriter(OutputStream output) throws IOException {
        super(output);
    }

    public void sendCmdOk() throws IOException {
        this.out.writeByte(32);
    }

    public void visitDumpCommand(boolean dump, boolean reset) throws IOException {
        this.out.writeByte(64);
        this.out.writeBoolean(dump);
        this.out.writeBoolean(reset);
    }
}
