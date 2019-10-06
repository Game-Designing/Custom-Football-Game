package org.jacoco.agent.p025rt.internal_8ff85ea.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.output.FileOutput */
public class FileOutput implements IAgentOutput {
    private boolean append;
    private RuntimeData data;
    private File destFile;

    public final void startup(AgentOptions options, RuntimeData data2) throws IOException {
        this.data = data2;
        this.destFile = new File(options.getDestfile()).getAbsoluteFile();
        this.append = options.getAppend();
        File folder = this.destFile.getParentFile();
        if (folder != null) {
            folder.mkdirs();
        }
        openFile().close();
    }

    public void writeExecutionData(boolean reset) throws IOException {
        OutputStream output = openFile();
        try {
            ExecutionDataWriter writer = new ExecutionDataWriter(output);
            this.data.collect(writer, writer, reset);
        } finally {
            output.close();
        }
    }

    public void shutdown() throws IOException {
    }

    private OutputStream openFile() throws IOException {
        FileOutputStream file = new FileOutputStream(this.destFile, this.append);
        file.getChannel().lock();
        return file;
    }
}
