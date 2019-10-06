package p005cm.aptoide.p006pt.root.execution;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;
import p005cm.aptoide.p006pt.root.RootShell;

/* renamed from: cm.aptoide.pt.root.execution.Command */
public class Command {
    String[] command = new String[0];
    protected Context context = null;
    boolean executing = false;
    ExecutionMonitor executionMonitor = null;
    int exitCode = -1;
    boolean finished = false;
    boolean handlerEnabled = true;

    /* renamed from: id */
    int f8281id = 0;
    protected boolean javaCommand = false;
    Handler mHandler = null;
    boolean terminated = false;
    int timeout = RootShell.defaultCommandTimeout;
    public int totalOutput = 0;
    public int totalOutputProcessed = 0;
    protected boolean used = false;

    /* renamed from: cm.aptoide.pt.root.execution.Command$CommandHandler */
    private class CommandHandler extends Handler {
        public static final String ACTION = "action";
        public static final int COMMAND_COMPLETED = 2;
        public static final int COMMAND_OUTPUT = 1;
        public static final int COMMAND_TERMINATED = 3;
        public static final String TEXT = "text";

        private CommandHandler() {
        }

        public final void handleMessage(Message msg) {
            int action = msg.getData().getInt("action");
            String text = msg.getData().getString(TEXT);
            if (action == 1) {
                Command command = Command.this;
                command.commandOutput(command.f8281id, text);
            } else if (action == 2) {
                Command command2 = Command.this;
                command2.commandCompleted(command2.f8281id, command2.exitCode);
            } else if (action == 3) {
                Command command3 = Command.this;
                command3.commandTerminated(command3.f8281id, text);
            }
        }
    }

    /* renamed from: cm.aptoide.pt.root.execution.Command$ExecutionMonitor */
    private class ExecutionMonitor extends Thread {
        private final Command command;

        public ExecutionMonitor(Command command2) {
            this.command = command2;
        }

        public void run() {
            Command command2 = this.command;
            if (command2.timeout > 0) {
                synchronized (command2) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Command ");
                        sb.append(this.command.f8281id);
                        sb.append(" is waiting for: ");
                        sb.append(this.command.timeout);
                        RootShell.log(sb.toString());
                        this.command.wait((long) this.command.timeout);
                    } catch (InterruptedException e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Exception: ");
                        sb2.append(e);
                        RootShell.log(sb2.toString());
                    }
                    if (!this.command.isFinished()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Timeout Exception has occurred for command: ");
                        sb3.append(this.command.f8281id);
                        sb3.append(".");
                        RootShell.log(sb3.toString());
                        Command.this.terminate(RootCommandOnSubscribe.TIMEOUT_EXCEPTION);
                    }
                }
            }
        }
    }

    public Command(int id, String... command2) {
        this.command = command2;
        this.f8281id = id;
        createHandler(RootShell.handlerEnabled);
    }

    public Command(int id, boolean handlerEnabled2, String... command2) {
        this.command = command2;
        this.f8281id = id;
        createHandler(handlerEnabled2);
    }

    public Command(int id, int timeout2, String... command2) {
        this.command = command2;
        this.f8281id = id;
        this.timeout = timeout2;
        createHandler(RootShell.handlerEnabled);
    }

    public void commandOutput(int id, String line) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append(", ");
        sb.append(line);
        RootShell.log("Command", sb.toString());
        this.totalOutputProcessed++;
    }

    public void commandTerminated(int id, String reason) {
    }

    public void commandCompleted(int id, int exitcode) {
    }

    /* access modifiers changed from: protected */
    public final void commandFinished() {
        if (!this.terminated) {
            synchronized (this) {
                if (this.mHandler == null || !this.handlerEnabled) {
                    commandCompleted(this.f8281id, this.exitCode);
                } else {
                    Message msg = this.mHandler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 2);
                    msg.setData(bundle);
                    this.mHandler.sendMessage(msg);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Command ");
                sb.append(this.f8281id);
                sb.append(" finished.");
                RootShell.log(sb.toString());
                finishCommand();
            }
        }
    }

    private void createHandler(boolean handlerEnabled2) {
        this.handlerEnabled = handlerEnabled2;
        if (Looper.myLooper() == null || !handlerEnabled2) {
            RootShell.log("CommandHandler not created");
            return;
        }
        RootShell.log("CommandHandler created");
        this.mHandler = new CommandHandler();
    }

    public final void finish() {
        RootShell.log("Command finished at users request!");
        commandFinished();
    }

    /* access modifiers changed from: protected */
    public final void finishCommand() {
        this.executing = false;
        this.finished = true;
        notifyAll();
    }

    public final String getCommand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.command.length; i++) {
            if (i > 0) {
                sb.append(10);
            }
            sb.append(this.command[i]);
        }
        return sb.toString();
    }

    public final boolean isExecuting() {
        return this.executing;
    }

    public final boolean isHandlerEnabled() {
        return this.handlerEnabled;
    }

    public final boolean isFinished() {
        return this.finished;
    }

    public final int getExitCode() {
        return this.exitCode;
    }

    /* access modifiers changed from: protected */
    public final void setExitCode(int code) {
        synchronized (this) {
            this.exitCode = code;
        }
    }

    /* access modifiers changed from: protected */
    public final void startExecution() {
        this.used = true;
        this.executionMonitor = new ExecutionMonitor(this);
        this.executionMonitor.setPriority(1);
        this.executionMonitor.start();
        this.executing = true;
    }

    public final void terminate() {
        RootShell.log("Terminating command at users request!");
        terminated("Terminated at users request!");
    }

    /* access modifiers changed from: protected */
    public final void terminate(String reason) {
        try {
            Shell.closeAll();
            RootShell.log("Terminating all shells.");
            terminated(reason);
        } catch (IOException e) {
        }
    }

    /* access modifiers changed from: protected */
    public final void terminated(String reason) {
        synchronized (this) {
            if (this.mHandler == null || !this.handlerEnabled) {
                commandTerminated(this.f8281id, reason);
            } else {
                Message msg = this.mHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("action", 3);
                bundle.putString(CommandHandler.TEXT, reason);
                msg.setData(bundle);
                this.mHandler.sendMessage(msg);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Command ");
            sb.append(this.f8281id);
            sb.append(" did not finish because it was terminated. Termination reason: ");
            sb.append(reason);
            RootShell.log(sb.toString());
            setExitCode(-1);
            this.terminated = true;
            finishCommand();
        }
    }

    /* access modifiers changed from: protected */
    public final void output(int id, String line) {
        this.totalOutput++;
        Handler handler = this.mHandler;
        if (handler == null || !this.handlerEnabled) {
            commandOutput(id, line);
            return;
        }
        Message msg = handler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString(CommandHandler.TEXT, line);
        msg.setData(bundle);
        this.mHandler.sendMessage(msg);
    }
}
