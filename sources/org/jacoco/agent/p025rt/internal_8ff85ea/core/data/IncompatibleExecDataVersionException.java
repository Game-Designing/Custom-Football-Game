package org.jacoco.agent.p025rt.internal_8ff85ea.core.data;

import java.io.IOException;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.data.IncompatibleExecDataVersionException */
public class IncompatibleExecDataVersionException extends IOException {
    private static final long serialVersionUID = 1;
    private final int actualVersion;

    public IncompatibleExecDataVersionException(int actualVersion2) {
        super(String.format("Cannot read execution data version 0x%x. This version of JaCoCo uses execution data version 0x%x.", new Object[]{Integer.valueOf(actualVersion2), Integer.valueOf(ExecutionDataWriter.FORMAT_VERSION)}));
        this.actualVersion = actualVersion2;
    }

    public int getExpectedVersion() {
        return ExecutionDataWriter.FORMAT_VERSION;
    }

    public int getActualVersion() {
        return this.actualVersion;
    }
}
