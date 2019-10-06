package org.jacoco.agent.p025rt.internal_8ff85ea.output;

import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.output.IAgentOutput */
public interface IAgentOutput {
    void shutdown() throws Exception;

    void startup(AgentOptions agentOptions, RuntimeData runtimeData) throws Exception;

    void writeExecutionData(boolean z) throws IOException;
}
