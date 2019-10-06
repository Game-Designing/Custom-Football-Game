package org.jacoco.agent.p025rt.internal_8ff85ea.output;

import java.io.IOException;
import java.net.Socket;
import org.jacoco.agent.p025rt.internal_8ff85ea.IExceptionLogger;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.output.TcpClientOutput */
public class TcpClientOutput implements IAgentOutput {
    /* access modifiers changed from: private */
    public TcpConnection connection;
    /* access modifiers changed from: private */
    public final IExceptionLogger logger;
    private Thread worker;

    public TcpClientOutput(IExceptionLogger logger2) {
        this.logger = logger2;
    }

    public void startup(AgentOptions options, RuntimeData data) throws IOException {
        this.connection = new TcpConnection(createSocket(options), data);
        this.connection.init();
        this.worker = new Thread(new Runnable() {
            public void run() {
                try {
                    TcpClientOutput.this.connection.run();
                } catch (IOException e) {
                    TcpClientOutput.this.logger.logExeption(e);
                }
            }
        });
        this.worker.setName(getClass().getName());
        this.worker.setDaemon(true);
        this.worker.start();
    }

    public void shutdown() throws Exception {
        this.connection.close();
        this.worker.join();
    }

    public void writeExecutionData(boolean reset) throws IOException {
        this.connection.writeExecutionData(reset);
    }

    /* access modifiers changed from: protected */
    public Socket createSocket(AgentOptions options) throws IOException {
        return new Socket(options.getAddress(), options.getPort());
    }
}
