package org.jacoco.agent.p025rt;

import java.io.IOException;

/* renamed from: org.jacoco.agent.rt.IAgent */
public interface IAgent {
    void dump(boolean z) throws IOException;

    byte[] getExecutionData(boolean z);

    String getSessionId();

    String getVersion();

    void reset();

    void setSessionId(String str);
}
