package org.jacoco.agent.p025rt.internal_8ff85ea.output;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.IRemoteCommandVisitor;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RemoteControlReader;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RemoteControlWriter;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.output.TcpConnection */
class TcpConnection implements IRemoteCommandVisitor {
    private final RuntimeData data;
    private boolean initialized = false;
    private RemoteControlReader reader;
    private final Socket socket;
    private RemoteControlWriter writer;

    public TcpConnection(Socket socket2, RuntimeData data2) {
        this.socket = socket2;
        this.data = data2;
    }

    public void init() throws IOException {
        this.writer = new RemoteControlWriter(this.socket.getOutputStream());
        this.reader = new RemoteControlReader(this.socket.getInputStream());
        this.reader.setRemoteCommandVisitor(this);
        this.initialized = true;
    }

    public void run() throws IOException {
        do {
            try {
            } catch (SocketException e) {
                if (!this.socket.isClosed()) {
                    throw e;
                }
            } catch (Throwable th) {
                close();
                throw th;
            }
        } while (this.reader.read());
        close();
    }

    public void writeExecutionData(boolean reset) throws IOException {
        if (this.initialized && !this.socket.isClosed()) {
            visitDumpCommand(true, reset);
        }
    }

    public void close() throws IOException {
        if (!this.socket.isClosed()) {
            this.socket.close();
        }
    }

    public void visitDumpCommand(boolean dump, boolean reset) throws IOException {
        if (dump) {
            RuntimeData runtimeData = this.data;
            RemoteControlWriter remoteControlWriter = this.writer;
            runtimeData.collect(remoteControlWriter, remoteControlWriter, reset);
        } else if (reset) {
            this.data.reset();
        }
        this.writer.sendCmdOk();
    }
}
