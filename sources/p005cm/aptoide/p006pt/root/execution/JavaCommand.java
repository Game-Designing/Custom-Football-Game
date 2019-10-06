package p005cm.aptoide.p006pt.root.execution;

import android.content.Context;

/* renamed from: cm.aptoide.pt.root.execution.JavaCommand */
public class JavaCommand extends Command {
    public JavaCommand(int id, Context context, String... command) {
        super(id, command);
        this.context = context;
    }

    public JavaCommand(int id, boolean handlerEnabled, Context context, String... command) {
        super(id, handlerEnabled, command);
        this.context = context;
    }

    public JavaCommand(int id, int timeout, Context context, String... command) {
        super(id, timeout, command);
        this.context = context;
    }

    public void commandOutput(int id, String line) {
        super.commandOutput(id, line);
    }

    public void commandTerminated(int id, String reason) {
    }

    public void commandCompleted(int id, int exitCode) {
    }
}
