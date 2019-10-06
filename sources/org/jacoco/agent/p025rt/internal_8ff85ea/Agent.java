package org.jacoco.agent.p025rt.internal_8ff85ea;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.IAgent;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.JaCoCo;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AbstractRuntime;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions.OutputMode;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RuntimeData;
import org.jacoco.agent.p025rt.internal_8ff85ea.output.FileOutput;
import org.jacoco.agent.p025rt.internal_8ff85ea.output.IAgentOutput;
import org.jacoco.agent.p025rt.internal_8ff85ea.output.NoneOutput;
import org.jacoco.agent.p025rt.internal_8ff85ea.output.TcpClientOutput;
import org.jacoco.agent.p025rt.internal_8ff85ea.output.TcpServerOutput;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.Agent */
public class Agent implements IAgent {
    private static Agent singleton;
    private final RuntimeData data = new RuntimeData();
    private Callable<Void> jmxRegistration;
    private final IExceptionLogger logger;
    private final AgentOptions options;
    private IAgentOutput output;

    /* renamed from: org.jacoco.agent.rt.internal_8ff85ea.Agent$2 */
    static /* synthetic */ class C01132 {
        static final /* synthetic */ int[] $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode = new int[OutputMode.values().length];

        static {
            try {
                $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode[OutputMode.file.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode[OutputMode.tcpserver.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode[OutputMode.tcpclient.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode[OutputMode.none.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static synchronized Agent getInstance(AgentOptions options2) {
        Agent agent;
        synchronized (Agent.class) {
            if (singleton == null) {
                Agent agent2 = new Agent(options2, IExceptionLogger.SYSTEM_ERR);
                agent2.startup();
                Runtime.getRuntime().addShutdownHook(new Thread(agent2) {
                    final /* synthetic */ Agent val$agent;

                    {
                        this.val$agent = r1;
                    }

                    public void run() {
                        this.val$agent.shutdown();
                    }
                });
                singleton = agent2;
            }
            agent = singleton;
        }
        return agent;
    }

    public static synchronized Agent getInstance() throws IllegalStateException {
        Agent agent;
        synchronized (Agent.class) {
            if (singleton != null) {
                agent = singleton;
            } else {
                throw new IllegalStateException("JaCoCo agent not started.");
            }
        }
        return agent;
    }

    Agent(AgentOptions options2, IExceptionLogger logger2) {
        this.options = options2;
        this.logger = logger2;
    }

    public RuntimeData getData() {
        return this.data;
    }

    public void startup() {
        try {
            String sessionId = this.options.getSessionId();
            if (sessionId == null) {
                sessionId = createSessionId();
            }
            this.data.setSessionId(sessionId);
            this.output = createAgentOutput();
            this.output.startup(this.options, this.data);
            if (this.options.getJmx()) {
                this.jmxRegistration = new JmxRegistration(this);
            }
        } catch (Exception e) {
            this.logger.logExeption(e);
        }
    }

    public void shutdown() {
        try {
            if (this.options.getDumpOnExit()) {
                this.output.writeExecutionData(false);
            }
            this.output.shutdown();
            if (this.jmxRegistration != null) {
                this.jmxRegistration.call();
            }
        } catch (Exception e) {
            this.logger.logExeption(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public IAgentOutput createAgentOutput() {
        OutputMode controllerType = this.options.getOutput();
        int i = C01132.$SwitchMap$org$jacoco$core$runtime$AgentOptions$OutputMode[controllerType.ordinal()];
        if (i == 1) {
            return new FileOutput();
        }
        if (i == 2) {
            return new TcpServerOutput(this.logger);
        }
        if (i == 3) {
            return new TcpClientOutput(this.logger);
        }
        if (i == 4) {
            return new NoneOutput();
        }
        throw new AssertionError(controllerType);
    }

    private String createSessionId() {
        String host;
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            host = "unknownhost";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(host);
        sb.append("-");
        sb.append(AbstractRuntime.createRandomId());
        return sb.toString();
    }

    public String getVersion() {
        return JaCoCo.VERSION;
    }

    public String getSessionId() {
        return this.data.getSessionId();
    }

    public void setSessionId(String id) {
        this.data.setSessionId(id);
    }

    public void reset() {
        this.data.reset();
    }

    public byte[] getExecutionData(boolean reset) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ExecutionDataWriter writer = new ExecutionDataWriter(buffer);
            this.data.collect(writer, writer, reset);
            return buffer.toByteArray();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public void dump(boolean reset) throws IOException {
        this.output.writeExecutionData(reset);
    }
}
