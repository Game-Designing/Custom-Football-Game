package org.jacoco.agent.p025rt.internal_8ff85ea.output;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import org.jacoco.agent.p025rt.internal_8ff85ea.IExceptionLogger;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.output.TcpServerOutput */
public class TcpServerOutput implements IAgentOutput {
    /* access modifiers changed from: private */
    public TcpConnection connection;
    /* access modifiers changed from: private */
    public final IExceptionLogger logger;
    /* access modifiers changed from: private */
    public ServerSocket serverSocket;
    private Thread worker;

    public TcpServerOutput(IExceptionLogger logger2) {
        this.logger = logger2;
    }

    public void startup(AgentOptions options, final RuntimeData data) throws IOException {
        this.serverSocket = createServerSocket(options);
        this.worker = new Thread(new Runnable() {
            public void run() {
                while (!TcpServerOutput.this.serverSocket.isClosed()) {
                    try {
                        synchronized (TcpServerOutput.this.serverSocket) {
                            TcpServerOutput.this.connection = new TcpConnection(TcpServerOutput.this.serverSocket.accept(), data);
                        }
                        TcpServerOutput.this.connection.init();
                        TcpServerOutput.this.connection.run();
                    } catch (IOException e) {
                        if (!TcpServerOutput.this.serverSocket.isClosed()) {
                            TcpServerOutput.this.logger.logExeption(e);
                        }
                    }
                }
            }
        });
        this.worker.setName(getClass().getName());
        this.worker.setDaemon(true);
        this.worker.start();
    }

    public void shutdown() throws Exception {
        this.serverSocket.close();
        synchronized (this.serverSocket) {
            if (this.connection != null) {
                this.connection.close();
            }
        }
        this.worker.join();
    }

    public void writeExecutionData(boolean reset) throws IOException {
        TcpConnection tcpConnection = this.connection;
        if (tcpConnection != null) {
            tcpConnection.writeExecutionData(reset);
        }
    }

    /* access modifiers changed from: protected */
    public ServerSocket createServerSocket(AgentOptions options) throws IOException {
        return new ServerSocket(options.getPort(), 1, getInetAddress(options.getAddress()));
    }

    /* access modifiers changed from: protected */
    public InetAddress getInetAddress(String address) throws UnknownHostException {
        if ("*".equals(address)) {
            return null;
        }
        return InetAddress.getByName(address);
    }
}
