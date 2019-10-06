package p005cm.aptoide.p006pt.root.execution;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import p005cm.aptoide.p006pt.root.RootShell;
import p005cm.aptoide.p006pt.root.RootShell.LogLevel;
import p005cm.aptoide.p006pt.root.exceptions.RootDeniedException;

/* renamed from: cm.aptoide.pt.root.execution.Shell */
public class Shell {
    private static Shell customShell = null;
    public static ShellContext defaultContext = ShellContext.NORMAL;
    private static Shell rootShell = null;
    private static Shell shell = null;
    private static String[] suVersion = {null, null};
    private static final String token = "F*D^W@#FGF";
    /* access modifiers changed from: private */
    public boolean close = false;
    /* access modifiers changed from: private */
    public final List<Command> commands = new ArrayList();
    /* access modifiers changed from: private */
    public String error = "";
    /* access modifiers changed from: private */
    public final BufferedReader errorStream;
    private Runnable input = new Runnable() {
        public void run() {
            while (true) {
                try {
                    synchronized (Shell.this.commands) {
                        while (!Shell.this.close && Shell.this.write >= Shell.this.commands.size()) {
                            Shell.this.isExecuting = false;
                            Shell.this.commands.wait();
                        }
                    }
                    if (Shell.this.write >= Shell.this.maxCommands) {
                        while (Shell.this.read != Shell.this.write) {
                            RootShell.log("Waiting for read and write to catch up before cleanup.");
                        }
                        Shell.this.cleanCommands();
                    }
                    if (Shell.this.write < Shell.this.commands.size()) {
                        Shell.this.isExecuting = true;
                        Command cmd = (Command) Shell.this.commands.get(Shell.this.write);
                        cmd.startExecution();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Executing: ");
                        sb.append(cmd.getCommand());
                        sb.append(" with context: ");
                        sb.append(Shell.this.shellContext);
                        RootShell.log(sb.toString());
                        Shell.this.outputStream.write(cmd.getCommand());
                        Shell.this.outputStream.flush();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("\necho F*D^W@#FGF ");
                        sb2.append(Shell.this.totalExecuted);
                        sb2.append(" $?\n");
                        Shell.this.outputStream.write(sb2.toString());
                        Shell.this.outputStream.flush();
                        Shell.this.write = Shell.this.write + 1;
                        Shell.this.totalExecuted = Shell.this.totalExecuted + 1;
                    } else if (Shell.this.close) {
                        Shell.this.isExecuting = false;
                        Shell.this.outputStream.write("\nexit 0\n");
                        Shell.this.outputStream.flush();
                        RootShell.log("Closing shell");
                        Shell.this.write = 0;
                        Shell shell = Shell.this;
                        shell.closeQuietly((Writer) shell.outputStream);
                        return;
                    }
                } catch (IOException | InterruptedException e) {
                    try {
                        RootShell.log(e.getMessage(), LogLevel.ERROR, e);
                        return;
                    } finally {
                        Shell.this.write = 0;
                        Shell shell2 = Shell.this;
                        shell2.closeQuietly((Writer) shell2.outputStream);
                    }
                }
            }
            while (true) {
            }
        }
    };
    /* access modifiers changed from: private */
    public final BufferedReader inputStream;
    private boolean isCleaning = false;
    public boolean isClosed = false;
    public boolean isExecuting = false;
    public boolean isReading = false;
    private Boolean isSELinuxEnforcing = null;
    /* access modifiers changed from: private */
    public int maxCommands = 5000;
    private Runnable output = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            p005cm.aptoide.p006pt.root.execution.Shell.access$1200(r11.this$0).waitFor();
            p005cm.aptoide.p006pt.root.execution.Shell.access$1200(r11.this$0).destroy();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r11 = this;
                r0 = 0
            L_0x0001:
                r1 = 0
                r2 = 1
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                boolean r3 = r3.close     // Catch:{ IOException -> 0x018f }
                if (r3 == 0) goto L_0x0029
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                java.io.BufferedReader r3 = r3.inputStream     // Catch:{ IOException -> 0x018f }
                boolean r3 = r3.ready()     // Catch:{ IOException -> 0x018f }
                if (r3 != 0) goto L_0x0029
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                int r3 = r3.read     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Shell r4 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                java.util.List r4 = r4.commands     // Catch:{ IOException -> 0x018f }
                int r4 = r4.size()     // Catch:{ IOException -> 0x018f }
                if (r3 >= r4) goto L_0x005b
            L_0x0029:
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                r3.isReading = r1     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                java.io.BufferedReader r3 = r3.inputStream     // Catch:{ IOException -> 0x018f }
                java.lang.String r3 = r3.readLine()     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Shell r4 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                r4.isReading = r2     // Catch:{ IOException -> 0x018f }
                if (r3 != 0) goto L_0x003e
                goto L_0x005b
            L_0x003e:
                if (r0 != 0) goto L_0x00ce
                cm.aptoide.pt.root.execution.Shell r4 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                int r4 = r4.read     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Shell r5 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                java.util.List r5 = r5.commands     // Catch:{ IOException -> 0x018f }
                int r5 = r5.size()     // Catch:{ IOException -> 0x018f }
                if (r4 < r5) goto L_0x00bb
                cm.aptoide.pt.root.execution.Shell r4 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                boolean r4 = r4.close     // Catch:{ IOException -> 0x018f }
                if (r4 == 0) goto L_0x0001
            L_0x005b:
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ Exception -> 0x006e }
                java.lang.Process r3 = r3.proc     // Catch:{ Exception -> 0x006e }
                r3.waitFor()     // Catch:{ Exception -> 0x006e }
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ Exception -> 0x006e }
                java.lang.Process r3 = r3.proc     // Catch:{ Exception -> 0x006e }
                r3.destroy()     // Catch:{ Exception -> 0x006e }
                goto L_0x006f
            L_0x006e:
                r3 = move-exception
            L_0x006f:
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                int r3 = r3.read     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Shell r4 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                java.util.List r4 = r4.commands     // Catch:{ IOException -> 0x018f }
                int r4 = r4.size()     // Catch:{ IOException -> 0x018f }
                if (r3 >= r4) goto L_0x00b3
                if (r0 != 0) goto L_0x0096
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                java.util.List r3 = r3.commands     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Shell r4 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                int r4 = r4.read     // Catch:{ IOException -> 0x018f }
                java.lang.Object r3 = r3.get(r4)     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Command r3 = (p005cm.aptoide.p006pt.root.execution.Command) r3     // Catch:{ IOException -> 0x018f }
                r0 = r3
            L_0x0096:
                int r3 = r0.totalOutput     // Catch:{ IOException -> 0x018f }
                int r4 = r0.totalOutputProcessed     // Catch:{ IOException -> 0x018f }
                if (r3 >= r4) goto L_0x00a7
                java.lang.String r3 = "All output not processed!"
                r0.terminated(r3)     // Catch:{ IOException -> 0x018f }
                java.lang.String r3 = "Did you forget the super.commandOutput call or are you waiting on the command object?"
                r0.terminated(r3)     // Catch:{ IOException -> 0x018f }
                goto L_0x00ac
            L_0x00a7:
                java.lang.String r3 = "Unexpected Termination."
                r0.terminated(r3)     // Catch:{ IOException -> 0x018f }
            L_0x00ac:
                r0 = 0
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                r3.read = r3.read + 1     // Catch:{ IOException -> 0x018f }
                goto L_0x006f
            L_0x00b3:
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                r3.read = r1     // Catch:{ IOException -> 0x018f }
                goto L_0x019a
            L_0x00bb:
                cm.aptoide.pt.root.execution.Shell r4 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                java.util.List r4 = r4.commands     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Shell r5 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                int r5 = r5.read     // Catch:{ IOException -> 0x018f }
                java.lang.Object r4 = r4.get(r5)     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Command r4 = (p005cm.aptoide.p006pt.root.execution.Command) r4     // Catch:{ IOException -> 0x018f }
                r0 = r4
            L_0x00ce:
                r4 = -1
                java.lang.String r5 = "F*D^W@#FGF"
                int r5 = r3.indexOf(r5)     // Catch:{ IOException -> 0x018f }
                r4 = r5
                r5 = -1
                if (r4 != r5) goto L_0x00df
                int r5 = r0.f8281id     // Catch:{ IOException -> 0x018f }
                r0.output(r5, r3)     // Catch:{ IOException -> 0x018f }
                goto L_0x00fe
            L_0x00df:
                if (r4 <= 0) goto L_0x00fe
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018f }
                r5.<init>()     // Catch:{ IOException -> 0x018f }
                java.lang.String r6 = "Found token, line: "
                r5.append(r6)     // Catch:{ IOException -> 0x018f }
                r5.append(r3)     // Catch:{ IOException -> 0x018f }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x018f }
                p005cm.aptoide.p006pt.root.RootShell.log(r5)     // Catch:{ IOException -> 0x018f }
                int r5 = r0.f8281id     // Catch:{ IOException -> 0x018f }
                java.lang.String r6 = r3.substring(r1, r4)     // Catch:{ IOException -> 0x018f }
                r0.output(r5, r6)     // Catch:{ IOException -> 0x018f }
            L_0x00fe:
                if (r4 < 0) goto L_0x018b
                java.lang.String r5 = r3.substring(r4)     // Catch:{ IOException -> 0x018f }
                r3 = r5
                java.lang.String r5 = " "
                java.lang.String[] r5 = r3.split(r5)     // Catch:{ IOException -> 0x018f }
                int r6 = r5.length     // Catch:{ IOException -> 0x018f }
                r7 = 2
                if (r6 < r7) goto L_0x018b
                r6 = r5[r2]     // Catch:{ IOException -> 0x018f }
                if (r6 == 0) goto L_0x018b
                r6 = 0
                r8 = r5[r2]     // Catch:{ NumberFormatException -> 0x011c }
                int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x011c }
                r6 = r8
                goto L_0x011d
            L_0x011c:
                r8 = move-exception
            L_0x011d:
                r8 = -1
                r7 = r5[r7]     // Catch:{ NumberFormatException -> 0x0126 }
                int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x0126 }
                r8 = r7
                goto L_0x0127
            L_0x0126:
                r7 = move-exception
            L_0x0127:
                cm.aptoide.pt.root.execution.Shell r7 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                int r7 = r7.totalRead     // Catch:{ IOException -> 0x018f }
                if (r6 != r7) goto L_0x018b
                cm.aptoide.pt.root.execution.Shell r7 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                r7.processErrors(r0)     // Catch:{ IOException -> 0x018f }
                r7 = r1
            L_0x0135:
                int r9 = r0.totalOutput     // Catch:{ IOException -> 0x018f }
                int r10 = r0.totalOutputProcessed     // Catch:{ IOException -> 0x018f }
                if (r9 <= r10) goto L_0x0173
                if (r7 != 0) goto L_0x015f
                int r7 = r7 + 1
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018f }
                r9.<init>()     // Catch:{ IOException -> 0x018f }
                java.lang.String r10 = "Waiting for output to be processed. "
                r9.append(r10)     // Catch:{ IOException -> 0x018f }
                int r10 = r0.totalOutputProcessed     // Catch:{ IOException -> 0x018f }
                r9.append(r10)     // Catch:{ IOException -> 0x018f }
                java.lang.String r10 = " Of "
                r9.append(r10)     // Catch:{ IOException -> 0x018f }
                int r10 = r0.totalOutput     // Catch:{ IOException -> 0x018f }
                r9.append(r10)     // Catch:{ IOException -> 0x018f }
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x018f }
                p005cm.aptoide.p006pt.root.RootShell.log(r9)     // Catch:{ IOException -> 0x018f }
            L_0x015f:
                monitor-enter(r11)     // Catch:{ Exception -> 0x016a }
                r9 = 2000(0x7d0, double:9.88E-321)
                r11.wait(r9)     // Catch:{ all -> 0x0167 }
                monitor-exit(r11)     // Catch:{ all -> 0x0167 }
                goto L_0x0172
            L_0x0167:
                r9 = move-exception
                monitor-exit(r11)     // Catch:{ all -> 0x0167 }
                throw r9     // Catch:{ Exception -> 0x016a }
            L_0x016a:
                r9 = move-exception
                java.lang.String r10 = r9.getMessage()     // Catch:{ IOException -> 0x018f }
                p005cm.aptoide.p006pt.root.RootShell.log(r10)     // Catch:{ IOException -> 0x018f }
            L_0x0172:
                goto L_0x0135
            L_0x0173:
                java.lang.String r9 = "Read all output"
                p005cm.aptoide.p006pt.root.RootShell.log(r9)     // Catch:{ IOException -> 0x018f }
                r0.setExitCode(r8)     // Catch:{ IOException -> 0x018f }
                r0.commandFinished()     // Catch:{ IOException -> 0x018f }
                r0 = 0
                cm.aptoide.pt.root.execution.Shell r9 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                r9.read = r9.read + 1     // Catch:{ IOException -> 0x018f }
                cm.aptoide.pt.root.execution.Shell r9 = p005cm.aptoide.p006pt.root.execution.Shell.this     // Catch:{ IOException -> 0x018f }
                r9.totalRead = r9.totalRead + 1     // Catch:{ IOException -> 0x018f }
                goto L_0x0001
            L_0x018b:
                goto L_0x0001
            L_0x018d:
                r0 = move-exception
                goto L_0x01c2
            L_0x018f:
                r0 = move-exception
                java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x018d }
                cm.aptoide.pt.root.RootShell$LogLevel r4 = p005cm.aptoide.p006pt.root.RootShell.LogLevel.ERROR     // Catch:{ all -> 0x018d }
                p005cm.aptoide.p006pt.root.RootShell.log(r3, r4, r0)     // Catch:{ all -> 0x018d }
            L_0x019a:
                cm.aptoide.pt.root.execution.Shell r0 = p005cm.aptoide.p006pt.root.execution.Shell.this
                java.io.OutputStreamWriter r3 = r0.outputStream
                r0.closeQuietly(r3)
                cm.aptoide.pt.root.execution.Shell r0 = p005cm.aptoide.p006pt.root.execution.Shell.this
                java.io.BufferedReader r3 = r0.errorStream
                r0.closeQuietly(r3)
                cm.aptoide.pt.root.execution.Shell r0 = p005cm.aptoide.p006pt.root.execution.Shell.this
                java.io.BufferedReader r3 = r0.inputStream
                r0.closeQuietly(r3)
                java.lang.String r0 = "Shell destroyed"
                p005cm.aptoide.p006pt.root.RootShell.log(r0)
                cm.aptoide.pt.root.execution.Shell r0 = p005cm.aptoide.p006pt.root.execution.Shell.this
                r0.isClosed = r2
                r0.isReading = r1
                return
            L_0x01c2:
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this
                java.io.OutputStreamWriter r4 = r3.outputStream
                r3.closeQuietly(r4)
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this
                java.io.BufferedReader r4 = r3.errorStream
                r3.closeQuietly(r4)
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this
                java.io.BufferedReader r4 = r3.inputStream
                r3.closeQuietly(r4)
                java.lang.String r3 = "Shell destroyed"
                p005cm.aptoide.p006pt.root.RootShell.log(r3)
                cm.aptoide.pt.root.execution.Shell r3 = p005cm.aptoide.p006pt.root.execution.Shell.this
                r3.isClosed = r2
                r3.isReading = r1
                goto L_0x01ea
            L_0x01e9:
                throw r0
            L_0x01ea:
                goto L_0x01e9
            */
            throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.root.execution.Shell.C46502.run():void");
        }
    };
    /* access modifiers changed from: private */
    public final OutputStreamWriter outputStream;
    /* access modifiers changed from: private */
    public final Process proc;
    /* access modifiers changed from: private */
    public int read = 0;
    /* access modifiers changed from: private */
    public ShellContext shellContext = ShellContext.NORMAL;
    private int shellTimeout = 25000;
    private ShellType shellType = null;
    /* access modifiers changed from: private */
    public int totalExecuted = 0;
    /* access modifiers changed from: private */
    public int totalRead = 0;
    /* access modifiers changed from: private */
    public int write = 0;

    /* renamed from: cm.aptoide.pt.root.execution.Shell$ShellContext */
    public enum ShellContext {
        NORMAL("normal"),
        SHELL("u:r:shell:s0"),
        SYSTEM_SERVER("u:r:system_server:s0"),
        SYSTEM_APP("u:r:system_app:s0"),
        PLATFORM_APP("u:r:platform_app:s0"),
        UNTRUSTED_APP("u:r:untrusted_app:s0"),
        RECOVERY("u:r:recovery:s0");
        
        private String value;

        private ShellContext(String value2) {
            this.value = value2;
        }

        public String getValue() {
            return this.value;
        }
    }

    /* renamed from: cm.aptoide.pt.root.execution.Shell$ShellType */
    public enum ShellType {
        NORMAL,
        ROOT,
        CUSTOM
    }

    /* renamed from: cm.aptoide.pt.root.execution.Shell$Worker */
    protected static class Worker extends Thread {
        public int exit;
        public Shell shell;

        private Worker(Shell shell2) {
            this.exit = -911;
            this.shell = shell2;
        }

        private void setShellOom() {
            Field field;
            try {
                Class<?> processClass = this.shell.proc.getClass();
                try {
                    field = processClass.getDeclaredField("pid");
                } catch (NoSuchFieldException e) {
                    field = processClass.getDeclaredField("id");
                }
                field.setAccessible(true);
                int pid = ((Integer) field.get(this.shell.proc)).intValue();
                OutputStreamWriter access$700 = this.shell.outputStream;
                StringBuilder sb = new StringBuilder();
                sb.append("(echo -17 > /proc/");
                sb.append(pid);
                sb.append("/oom_adj) &> /dev/null\n");
                access$700.write(sb.toString());
                this.shell.outputStream.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
                this.shell.outputStream.flush();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void run() {
            try {
                this.shell.outputStream.write("echo Started\n");
                this.shell.outputStream.flush();
                while (true) {
                    String line = this.shell.inputStream.readLine();
                    if (line == null) {
                        throw new EOFException();
                    } else if (!"".equals(line)) {
                        if ("Started".equals(line)) {
                            this.exit = 1;
                            setShellOom();
                            return;
                        }
                        this.shell.error = "unknown error occurred.";
                    }
                }
            } catch (IOException e) {
                this.exit = -42;
                if (e.getMessage() != null) {
                    this.shell.error = e.getMessage();
                } else {
                    this.shell.error = "RootAccess denied?.";
                }
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x01c2=Splitter:B:35:0x01c2, B:29:0x01a4=Splitter:B:29:0x01a4} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Shell(java.lang.String r7, p005cm.aptoide.p006pt.root.execution.Shell.ShellType r8, p005cm.aptoide.p006pt.root.execution.Shell.ShellContext r9, int r10) throws java.io.IOException, java.util.concurrent.TimeoutException, p005cm.aptoide.p006pt.root.exceptions.RootDeniedException {
        /*
            r6 = this;
            r6.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.commands = r0
            r0 = 0
            r6.isExecuting = r0
            r6.isReading = r0
            r6.isClosed = r0
            r1 = 25000(0x61a8, float:3.5032E-41)
            r6.shellTimeout = r1
            r1 = 0
            r6.shellType = r1
            cm.aptoide.pt.root.execution.Shell$ShellContext r2 = p005cm.aptoide.p006pt.root.execution.Shell.ShellContext.NORMAL
            r6.shellContext = r2
            java.lang.String r2 = ""
            r6.error = r2
            r6.close = r0
            r6.isSELinuxEnforcing = r1
            r2 = 5000(0x1388, float:7.006E-42)
            r6.maxCommands = r2
            r6.read = r0
            r6.write = r0
            r6.totalExecuted = r0
            r6.totalRead = r0
            r6.isCleaning = r0
            cm.aptoide.pt.root.execution.Shell$1 r2 = new cm.aptoide.pt.root.execution.Shell$1
            r2.<init>()
            r6.input = r2
            cm.aptoide.pt.root.execution.Shell$2 r2 = new cm.aptoide.pt.root.execution.Shell$2
            r2.<init>()
            r6.output = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Starting shell: "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            p005cm.aptoide.p006pt.root.RootShell.log(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Context: "
            r2.append(r3)
            java.lang.String r3 = r9.getValue()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            p005cm.aptoide.p006pt.root.RootShell.log(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Timeout: "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            p005cm.aptoide.p006pt.root.RootShell.log(r2)
            r6.shellType = r8
            if (r10 <= 0) goto L_0x0086
            r2 = r10
            goto L_0x0088
        L_0x0086:
            int r2 = r6.shellTimeout
        L_0x0088:
            r6.shellTimeout = r2
            r6.shellContext = r9
            cm.aptoide.pt.root.execution.Shell$ShellContext r2 = r6.shellContext
            cm.aptoide.pt.root.execution.Shell$ShellContext r3 = p005cm.aptoide.p006pt.root.execution.Shell.ShellContext.NORMAL
            if (r2 != r3) goto L_0x009e
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()
            java.lang.Process r0 = r0.exec(r7)
            r6.proc = r0
            goto L_0x012f
        L_0x009e:
            java.lang.String r0 = r6.getSuVersion(r0)
            r2 = 1
            java.lang.String r2 = r6.getSuVersion(r2)
            boolean r3 = r6.isSELinuxEnforcing()
            if (r3 == 0) goto L_0x00e0
            if (r0 == 0) goto L_0x00e0
            if (r2 == 0) goto L_0x00e0
            java.lang.String r3 = "SUPERSU"
            boolean r3 = r0.endsWith(r3)
            if (r3 == 0) goto L_0x00e0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            int r3 = r3.intValue()
            r4 = 190(0xbe, float:2.66E-43)
            if (r3 < r4) goto L_0x00e0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r4 = " --context "
            r3.append(r4)
            cm.aptoide.pt.root.execution.Shell$ShellContext r4 = r6.shellContext
            java.lang.String r4 = r4.getValue()
            r3.append(r4)
            java.lang.String r7 = r3.toString()
            goto L_0x0125
        L_0x00e0:
            java.lang.String r3 = "Su binary --context switch not supported!"
            p005cm.aptoide.p006pt.root.RootShell.log(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Su binary display version: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            p005cm.aptoide.p006pt.root.RootShell.log(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Su binary internal version: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            p005cm.aptoide.p006pt.root.RootShell.log(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "SELinuxEnforcing: "
            r3.append(r4)
            boolean r4 = r6.isSELinuxEnforcing()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            p005cm.aptoide.p006pt.root.RootShell.log(r3)
        L_0x0125:
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()
            java.lang.Process r3 = r3.exec(r7)
            r6.proc = r3
        L_0x012f:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            java.lang.Process r3 = r6.proc
            java.io.InputStream r3 = r3.getInputStream()
            java.lang.String r4 = "UTF-8"
            r2.<init>(r3, r4)
            r0.<init>(r2)
            r6.inputStream = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            java.lang.Process r3 = r6.proc
            java.io.InputStream r3 = r3.getErrorStream()
            r2.<init>(r3, r4)
            r0.<init>(r2)
            r6.errorStream = r0
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter
            java.lang.Process r2 = r6.proc
            java.io.OutputStream r2 = r2.getOutputStream()
            r0.<init>(r2, r4)
            r6.outputStream = r0
            cm.aptoide.pt.root.execution.Shell$Worker r0 = new cm.aptoide.pt.root.execution.Shell$Worker
            r0.<init>()
            r0.start()
            int r1 = r6.shellTimeout     // Catch:{ InterruptedException -> 0x01d9 }
            long r1 = (long) r1     // Catch:{ InterruptedException -> 0x01d9 }
            r0.join(r1)     // Catch:{ InterruptedException -> 0x01d9 }
            int r1 = r0.exit     // Catch:{ InterruptedException -> 0x01d9 }
            r2 = -911(0xfffffffffffffc71, float:NaN)
            if (r1 == r2) goto L_0x01bb
            int r1 = r0.exit     // Catch:{ InterruptedException -> 0x01d9 }
            r2 = -42
            if (r1 == r2) goto L_0x019d
            java.lang.Thread r1 = new java.lang.Thread     // Catch:{ InterruptedException -> 0x01d9 }
            java.lang.Runnable r2 = r6.input     // Catch:{ InterruptedException -> 0x01d9 }
            java.lang.String r3 = "Shell Input"
            r1.<init>(r2, r3)     // Catch:{ InterruptedException -> 0x01d9 }
            r2 = 5
            r1.setPriority(r2)     // Catch:{ InterruptedException -> 0x01d9 }
            r1.start()     // Catch:{ InterruptedException -> 0x01d9 }
            java.lang.Thread r3 = new java.lang.Thread     // Catch:{ InterruptedException -> 0x01d9 }
            java.lang.Runnable r4 = r6.output     // Catch:{ InterruptedException -> 0x01d9 }
            java.lang.String r5 = "Shell Output"
            r3.<init>(r4, r5)     // Catch:{ InterruptedException -> 0x01d9 }
            r3.setPriority(r2)     // Catch:{ InterruptedException -> 0x01d9 }
            r3.start()     // Catch:{ InterruptedException -> 0x01d9 }
            return
        L_0x019d:
            java.lang.Process r1 = r6.proc     // Catch:{ Exception -> 0x01a3 }
            r1.destroy()     // Catch:{ Exception -> 0x01a3 }
            goto L_0x01a4
        L_0x01a3:
            r1 = move-exception
        L_0x01a4:
            java.io.BufferedReader r1 = r6.inputStream     // Catch:{ InterruptedException -> 0x01d9 }
            r6.closeQuietly(r1)     // Catch:{ InterruptedException -> 0x01d9 }
            java.io.BufferedReader r1 = r6.errorStream     // Catch:{ InterruptedException -> 0x01d9 }
            r6.closeQuietly(r1)     // Catch:{ InterruptedException -> 0x01d9 }
            java.io.OutputStreamWriter r1 = r6.outputStream     // Catch:{ InterruptedException -> 0x01d9 }
            r6.closeQuietly(r1)     // Catch:{ InterruptedException -> 0x01d9 }
            cm.aptoide.pt.root.exceptions.RootDeniedException r1 = new cm.aptoide.pt.root.exceptions.RootDeniedException     // Catch:{ InterruptedException -> 0x01d9 }
            java.lang.String r2 = "Root Access Denied"
            r1.<init>(r2)     // Catch:{ InterruptedException -> 0x01d9 }
            throw r1     // Catch:{ InterruptedException -> 0x01d9 }
        L_0x01bb:
            java.lang.Process r1 = r6.proc     // Catch:{ Exception -> 0x01c1 }
            r1.destroy()     // Catch:{ Exception -> 0x01c1 }
            goto L_0x01c2
        L_0x01c1:
            r1 = move-exception
        L_0x01c2:
            java.io.BufferedReader r1 = r6.inputStream     // Catch:{ InterruptedException -> 0x01d9 }
            r6.closeQuietly(r1)     // Catch:{ InterruptedException -> 0x01d9 }
            java.io.BufferedReader r1 = r6.errorStream     // Catch:{ InterruptedException -> 0x01d9 }
            r6.closeQuietly(r1)     // Catch:{ InterruptedException -> 0x01d9 }
            java.io.OutputStreamWriter r1 = r6.outputStream     // Catch:{ InterruptedException -> 0x01d9 }
            r6.closeQuietly(r1)     // Catch:{ InterruptedException -> 0x01d9 }
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException     // Catch:{ InterruptedException -> 0x01d9 }
            java.lang.String r2 = r6.error     // Catch:{ InterruptedException -> 0x01d9 }
            r1.<init>(r2)     // Catch:{ InterruptedException -> 0x01d9 }
            throw r1     // Catch:{ InterruptedException -> 0x01d9 }
        L_0x01d9:
            r1 = move-exception
            r0.interrupt()
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            java.util.concurrent.TimeoutException r2 = new java.util.concurrent.TimeoutException
            r2.<init>()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.root.execution.Shell.<init>(java.lang.String, cm.aptoide.pt.root.execution.Shell$ShellType, cm.aptoide.pt.root.execution.Shell$ShellContext, int):void");
    }

    public static void closeCustomShell() throws IOException {
        RootShell.log("Request to close custom shell!");
        Shell shell2 = customShell;
        if (shell2 != null) {
            shell2.close();
        }
    }

    public static void closeRootShell() throws IOException {
        RootShell.log("Request to close root shell!");
        Shell shell2 = rootShell;
        if (shell2 != null) {
            shell2.close();
        }
    }

    public static void closeShell() throws IOException {
        RootShell.log("Request to close normal shell!");
        Shell shell2 = shell;
        if (shell2 != null) {
            shell2.close();
        }
    }

    public static void closeAll() throws IOException {
        RootShell.log("Request to close all shells!");
        closeShell();
        closeRootShell();
        closeCustomShell();
    }

    public static Shell getOpenShell() {
        Shell shell2 = customShell;
        if (shell2 != null) {
            return shell2;
        }
        Shell shell3 = rootShell;
        if (shell3 != null) {
            return shell3;
        }
        return shell;
    }

    public static boolean isShellOpen() {
        return shell == null;
    }

    public static boolean isCustomShellOpen() {
        return customShell == null;
    }

    public static boolean isRootShellOpen() {
        return rootShell == null;
    }

    public static boolean isAnyShellOpen() {
        return (shell == null && rootShell == null && customShell == null) ? false : true;
    }

    public static Command runRootCommand(Command command) throws IOException, TimeoutException, RootDeniedException {
        return startRootShell().add(command);
    }

    public static Command runCommand(Command command) throws IOException, TimeoutException {
        return startShell().add(command);
    }

    public static Shell startRootShell() throws IOException, TimeoutException, RootDeniedException {
        return startRootShell(0, 3);
    }

    public static Shell startRootShell(int timeout) throws IOException, TimeoutException, RootDeniedException {
        return startRootShell(timeout, 3);
    }

    public static Shell startRootShell(int timeout, int retry) throws IOException, TimeoutException, RootDeniedException {
        return startRootShell(timeout, defaultContext, retry);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r0 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p005cm.aptoide.p006pt.root.execution.Shell startRootShell(int r4, p005cm.aptoide.p006pt.root.execution.Shell.ShellContext r5, int r6) throws java.io.IOException, java.util.concurrent.TimeoutException, p005cm.aptoide.p006pt.root.exceptions.RootDeniedException {
        /*
            r0 = 0
            cm.aptoide.pt.root.execution.Shell r1 = rootShell
            if (r1 != 0) goto L_0x004b
            java.lang.String r1 = "Starting Root Shell!"
            p005cm.aptoide.p006pt.root.RootShell.log(r1)
            java.lang.String r1 = "su"
        L_0x000c:
            cm.aptoide.pt.root.execution.Shell r2 = rootShell
            if (r2 != 0) goto L_0x0049
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            r2.<init>()     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            java.lang.String r3 = "Trying to open Root Shell, attempt #"
            r2.append(r3)     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            r2.append(r0)     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            p005cm.aptoide.p006pt.root.RootShell.log(r2)     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            cm.aptoide.pt.root.execution.Shell r2 = new cm.aptoide.pt.root.execution.Shell     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            cm.aptoide.pt.root.execution.Shell$ShellType r3 = p005cm.aptoide.p006pt.root.execution.Shell.ShellType.ROOT     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            r2.<init>(r1, r3, r5, r4)     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            rootShell = r2     // Catch:{ IOException -> 0x003c, RootDeniedException -> 0x003a, TimeoutException -> 0x002e }
            goto L_0x000c
        L_0x002e:
            r2 = move-exception
            int r3 = r0 + 1
            if (r0 >= r6) goto L_0x0034
            goto L_0x0041
        L_0x0034:
            java.lang.String r0 = "TimeoutException, could not start shell"
            p005cm.aptoide.p006pt.root.RootShell.log(r0)
            throw r2
        L_0x003a:
            r2 = move-exception
            throw r2
        L_0x003c:
            r2 = move-exception
            int r3 = r0 + 1
            if (r0 >= r6) goto L_0x0043
        L_0x0041:
            r0 = r3
            goto L_0x000c
        L_0x0043:
            java.lang.String r0 = "IOException, could not start shell"
            p005cm.aptoide.p006pt.root.RootShell.log(r0)
            throw r2
        L_0x0049:
            r2 = r0
            goto L_0x009f
        L_0x004b:
            cm.aptoide.pt.root.execution.Shell$ShellContext r1 = r1.shellContext
            if (r1 == r5) goto L_0x0099
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            r1.<init>()     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            java.lang.String r2 = "Context is different than open shell, switching context... "
            r1.append(r2)     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            cm.aptoide.pt.root.execution.Shell r2 = rootShell     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            cm.aptoide.pt.root.execution.Shell$ShellContext r2 = r2.shellContext     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            r1.append(r2)     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            java.lang.String r2 = " VS "
            r1.append(r2)     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            r1.append(r5)     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            p005cm.aptoide.p006pt.root.RootShell.log(r1)     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            cm.aptoide.pt.root.execution.Shell r1 = rootShell     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            r1.switchRootShellContext(r5)     // Catch:{ IOException -> 0x008d, RootDeniedException -> 0x0081, TimeoutException -> 0x0075 }
            goto L_0x009e
        L_0x0075:
            r1 = move-exception
            int r2 = r0 + 1
            if (r0 >= r6) goto L_0x007b
            goto L_0x0092
        L_0x007b:
            java.lang.String r0 = "TimeoutException, could not switch context!"
            p005cm.aptoide.p006pt.root.RootShell.log(r0)
            throw r1
        L_0x0081:
            r1 = move-exception
            int r2 = r0 + 1
            if (r0 >= r6) goto L_0x0087
            goto L_0x0092
        L_0x0087:
            java.lang.String r0 = "RootDeniedException, could not switch context!"
            p005cm.aptoide.p006pt.root.RootShell.log(r0)
            throw r1
        L_0x008d:
            r1 = move-exception
            int r2 = r0 + 1
            if (r0 >= r6) goto L_0x0093
        L_0x0092:
            goto L_0x009f
        L_0x0093:
            java.lang.String r0 = "IOException, could not switch context!"
            p005cm.aptoide.p006pt.root.RootShell.log(r0)
            throw r1
        L_0x0099:
            java.lang.String r1 = "Using Existing Root Shell!"
            p005cm.aptoide.p006pt.root.RootShell.log(r1)
        L_0x009e:
            r2 = r0
        L_0x009f:
            cm.aptoide.pt.root.execution.Shell r0 = rootShell
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.root.execution.Shell.startRootShell(int, cm.aptoide.pt.root.execution.Shell$ShellContext, int):cm.aptoide.pt.root.execution.Shell");
    }

    public static Shell startCustomShell(String shellPath) throws IOException, TimeoutException, RootDeniedException {
        return startCustomShell(shellPath, 0);
    }

    public static Shell startCustomShell(String shellPath, int timeout) throws IOException, TimeoutException, RootDeniedException {
        if (customShell == null) {
            RootShell.log("Starting Custom Shell!");
            customShell = new Shell(shellPath, ShellType.CUSTOM, ShellContext.NORMAL, timeout);
        } else {
            RootShell.log("Using Existing Custom Shell!");
        }
        return customShell;
    }

    public static Shell startShell() throws IOException, TimeoutException {
        return startShell(0);
    }

    public static Shell startShell(int timeout) throws IOException, TimeoutException {
        try {
            if (shell == null) {
                RootShell.log("Starting Shell!");
                shell = new Shell("/system/bin/sh", ShellType.NORMAL, ShellContext.NORMAL, timeout);
            } else {
                RootShell.log("Using Existing Shell!");
            }
            return shell;
        } catch (RootDeniedException e) {
            throw new IOException();
        }
    }

    public Command add(Command command) throws IOException {
        if (this.close) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        } else if (!command.used) {
            do {
            } while (this.isCleaning);
            this.commands.add(command);
            notifyThreads();
            return command;
        } else {
            throw new IllegalStateException("This command has already been executed. (Don't re-use command instances.)");
        }
    }

    public final void useCWD(Context context) throws IOException, TimeoutException, RootDeniedException {
        StringBuilder sb = new StringBuilder();
        sb.append("cd ");
        sb.append(context.getApplicationInfo().dataDir);
        add(new Command(-1, false, sb.toString()));
    }

    /* access modifiers changed from: private */
    public void cleanCommands() {
        this.isCleaning = true;
        int i = this.maxCommands;
        int toClean = Math.abs(i - (i / 4));
        StringBuilder sb = new StringBuilder();
        sb.append("Cleaning up: ");
        sb.append(toClean);
        RootShell.log(sb.toString());
        for (int i2 = 0; i2 < toClean; i2++) {
            this.commands.remove(0);
        }
        this.read = this.commands.size() - 1;
        this.write = this.commands.size() - 1;
        this.isCleaning = false;
    }

    /* access modifiers changed from: private */
    public void closeQuietly(Reader input2) {
        if (input2 != null) {
            try {
                input2.close();
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void closeQuietly(Writer output2) {
        if (output2 != null) {
            try {
                output2.close();
            } catch (Exception e) {
            }
        }
    }

    public void close() throws IOException {
        RootShell.log("Request to close shell!");
        int count = 0;
        while (this.isExecuting) {
            RootShell.log("Waiting on shell to finish executing before closing...");
            count++;
            if (count > 10000) {
                break;
            }
        }
        synchronized (this.commands) {
            this.close = true;
            notifyThreads();
        }
        RootShell.log("Shell Closed!");
        if (this == rootShell) {
            rootShell = null;
        } else if (this == shell) {
            shell = null;
        } else if (this == customShell) {
            customShell = null;
        }
    }

    public int getCommandQueuePosition(Command cmd) {
        return this.commands.indexOf(cmd);
    }

    public String getCommandQueuePositionString(Command cmd) {
        StringBuilder sb = new StringBuilder();
        sb.append("Command is in position ");
        sb.append(getCommandQueuePosition(cmd));
        sb.append(" currently executing command at position ");
        sb.append(this.write);
        sb.append(" and the number of commands is ");
        sb.append(this.commands.size());
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        suVersion[r0] = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String getSuVersion(boolean r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            if (r10 == 0) goto L_0x0005
            r0 = 0
            goto L_0x0006
        L_0x0005:
            r0 = 1
        L_0x0006:
            java.lang.String[] r1 = suVersion     // Catch:{ all -> 0x008a }
            r1 = r1[r0]     // Catch:{ all -> 0x008a }
            if (r1 != 0) goto L_0x0084
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x007e, InterruptedException -> 0x0078 }
            if (r10 == 0) goto L_0x0017
            java.lang.String r4 = "su -V"
            goto L_0x0019
        L_0x0017:
            java.lang.String r4 = "su -v"
        L_0x0019:
            java.lang.Process r3 = r3.exec(r4, r2)     // Catch:{ IOException -> 0x007e, InterruptedException -> 0x0078 }
            r3.waitFor()     // Catch:{ IOException -> 0x007e, InterruptedException -> 0x0078 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x008a }
            r4.<init>()     // Catch:{ all -> 0x008a }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x008a }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x008a }
            java.io.InputStream r7 = r3.getInputStream()     // Catch:{ all -> 0x008a }
            r6.<init>(r7)     // Catch:{ all -> 0x008a }
            r5.<init>(r6)     // Catch:{ all -> 0x008a }
        L_0x0035:
            java.lang.String r6 = r5.readLine()     // Catch:{ IOException -> 0x0041 }
            r2 = r6
            if (r6 == 0) goto L_0x0040
            r4.add(r2)     // Catch:{ IOException -> 0x0041 }
            goto L_0x0035
        L_0x0040:
            goto L_0x0042
        L_0x0041:
            r2 = move-exception
        L_0x0042:
            r5.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0047
        L_0x0046:
            r2 = move-exception
        L_0x0047:
            r3.destroy()     // Catch:{ all -> 0x008a }
            r2 = r4
            java.util.Iterator r6 = r2.iterator()     // Catch:{ all -> 0x008a }
        L_0x0050:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x0073
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x008a }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x008a }
            if (r10 != 0) goto L_0x0068
            java.lang.String r8 = "."
            boolean r8 = r7.contains(r8)     // Catch:{ all -> 0x008a }
            if (r8 == 0) goto L_0x0072
            r1 = r7
            goto L_0x0073
        L_0x0068:
            int r8 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x0071 }
            if (r8 <= 0) goto L_0x0070
            r1 = r7
            goto L_0x0073
        L_0x0070:
            goto L_0x0072
        L_0x0071:
            r8 = move-exception
        L_0x0072:
            goto L_0x0050
        L_0x0073:
            java.lang.String[] r6 = suVersion     // Catch:{ all -> 0x008a }
            r6[r0] = r1     // Catch:{ all -> 0x008a }
            goto L_0x0084
        L_0x0078:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x008a }
            monitor-exit(r9)
            return r2
        L_0x007e:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x008a }
            monitor-exit(r9)
            return r2
        L_0x0084:
            java.lang.String[] r1 = suVersion     // Catch:{ all -> 0x008a }
            r1 = r1[r0]     // Catch:{ all -> 0x008a }
            monitor-exit(r9)
            return r1
        L_0x008a:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x008e
        L_0x008d:
            throw r10
        L_0x008e:
            goto L_0x008d
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.root.execution.Shell.getSuVersion(boolean):java.lang.String");
    }

    public synchronized boolean isSELinuxEnforcing() {
        FileInputStream fileInputStream;
        if (this.isSELinuxEnforcing == null) {
            Boolean enforcing = null;
            if (VERSION.SDK_INT >= 17) {
                boolean z = true;
                if (new File("/sys/fs/selinux/enforce").exists()) {
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        enforcing = Boolean.valueOf(fileInputStream.read() == 49);
                        fileInputStream.close();
                    } catch (Exception e) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                }
                if (enforcing == null) {
                    if (VERSION.SDK_INT < 19) {
                        z = false;
                    }
                    enforcing = Boolean.valueOf(z);
                }
            }
            if (enforcing == null) {
                enforcing = Boolean.valueOf(false);
            }
            this.isSELinuxEnforcing = enforcing;
        }
        return this.isSELinuxEnforcing.booleanValue();
    }

    /* access modifiers changed from: protected */
    public void notifyThreads() {
        new Thread() {
            public void run() {
                synchronized (Shell.this.commands) {
                    Shell.this.commands.notifyAll();
                }
            }
        }.start();
    }

    public void processErrors(Command command) {
        while (this.errorStream.ready() && command != null) {
            try {
                String line = this.errorStream.readLine();
                if (line != null) {
                    command.output(command.f8281id, line);
                } else {
                    return;
                }
            } catch (Exception e) {
                RootShell.log(e.getMessage(), LogLevel.ERROR, e);
                return;
            }
        }
    }

    public Shell switchRootShellContext(ShellContext shellContext2) throws IOException, TimeoutException, RootDeniedException {
        if (this.shellType == ShellType.ROOT) {
            try {
                closeRootShell();
            } catch (Exception e) {
                RootShell.log("Problem closing shell while trying to switch context...");
            }
            return startRootShell(this.shellTimeout, shellContext2, 0);
        }
        RootShell.log("Can only switch context on a root shell!");
        return this;
    }
}
