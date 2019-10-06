package p005cm.aptoide.p006pt.root;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.root.exceptions.RootDeniedException;
import p005cm.aptoide.p006pt.root.execution.Command;
import p005cm.aptoide.p006pt.root.execution.Shell;
import p005cm.aptoide.p006pt.root.execution.Shell.ShellContext;

/* renamed from: cm.aptoide.pt.root.RootShell */
public class RootShell {
    private static final String TAG = RootShell.class.getSimpleName();
    public static boolean debugMode = false;
    public static int defaultCommandTimeout = 20000;
    public static boolean handlerEnabled = true;
    public static final String version = "RootShell v1.4.1-aptoide";

    /* renamed from: cm.aptoide.pt.root.RootShell$5 */
    static /* synthetic */ class C46445 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$root$RootShell$LogLevel = new int[LogLevel.values().length];

        static {
            try {
                $SwitchMap$cm$aptoide$pt$root$RootShell$LogLevel[LogLevel.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$root$RootShell$LogLevel[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$root$RootShell$LogLevel[LogLevel.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$root$RootShell$LogLevel[LogLevel.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: cm.aptoide.pt.root.RootShell$LogLevel */
    public enum LogLevel {
        VERBOSE,
        ERROR,
        DEBUG,
        WARN
    }

    public static void closeAllShells() throws IOException {
        Shell.closeAll();
    }

    public static void closeCustomShell() throws IOException {
        Shell.closeCustomShell();
    }

    public static void closeShell(boolean root) throws IOException {
        if (root) {
            Shell.closeRootShell();
        } else {
            Shell.closeShell();
        }
    }

    public static boolean exists(String file) {
        return exists(file, false);
    }

    public static boolean exists(String file, boolean isDir) {
        String str = "Exception: ";
        final List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("ls ");
        sb.append(isDir ? "-d " : " ");
        String cmdToExecute = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cmdToExecute);
        sb2.append(file);
        Command command = new Command(0, false, new String[]{sb2.toString()}) {
            public void commandOutput(int id, String line) {
                RootShell.log(line);
                result.add(line);
                super.commandOutput(id, line);
            }
        };
        try {
            getShell(false).add(command);
            commandWait(getShell(false), command);
            for (String line : result) {
                if (line.trim().equals(file)) {
                    return true;
                }
            }
            result.clear();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cmdToExecute);
            sb3.append(file);
            Command command2 = new Command(0, false, new String[]{sb3.toString()}) {
                public void commandOutput(int id, String line) {
                    RootShell.log(line);
                    result.add(line);
                    super.commandOutput(id, line);
                }
            };
            try {
                getShell(true).add(command2);
                commandWait(getShell(true), command2);
                List<String> final_result = new ArrayList<>();
                final_result.addAll(result);
                for (String line2 : final_result) {
                    if (line2.trim().equals(file)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                if (e instanceof RootDeniedException) {
                    return true;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(e);
                log(sb4.toString());
                return false;
            }
        } catch (Exception e2) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(e2);
            log(sb5.toString());
            return false;
        }
    }

    public static List<String> findBinary(String binaryName, boolean singlePath) {
        return findBinary(binaryName, null, singlePath);
    }

    public static List<String> findBinary(String binaryName, List<String> searchPaths, boolean singlePath) {
        List<String> searchPaths2;
        String path;
        String str = binaryName;
        String str2 = "/";
        ArrayList arrayList = new ArrayList();
        boolean found = false;
        if (searchPaths == null) {
            searchPaths2 = getPath();
        } else {
            searchPaths2 = searchPaths;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Checking for ");
        sb.append(str);
        log(sb.toString());
        try {
            Iterator it = searchPaths2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String path2 = (String) it.next();
                if (!path2.endsWith(str2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(path2);
                    sb2.append(str2);
                    path = sb2.toString();
                } else {
                    path = path2;
                }
                final String currentPath = path;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("stat ");
                sb3.append(path);
                sb3.append(str);
                final String str3 = binaryName;
                final ArrayList arrayList2 = arrayList;
                C46423 r1 = new Command(0, false, new String[]{sb3.toString()}) {
                    public void commandOutput(int id, String line) {
                        if (line.contains("File: ") && line.contains(str3)) {
                            arrayList2.add(currentPath);
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append(" was found here: ");
                            sb.append(currentPath);
                            RootShell.log(sb.toString());
                        }
                        RootShell.log(line);
                        super.commandOutput(id, line);
                    }
                };
                commandWait(getShell(false), getShell(false).add(r1));
                if (arrayList.size() > 0 && singlePath) {
                    break;
                }
            }
            found = !arrayList.isEmpty();
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(" was not found, more information MAY be available with Debugging on.");
            log(sb4.toString());
        }
        if (!found) {
            log("Trying second method");
            for (String path3 : searchPaths2) {
                if (!path3.endsWith(str2)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(path3);
                    sb5.append(str2);
                    path3 = sb5.toString();
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append(path3);
                sb6.append(str);
                if (exists(sb6.toString())) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str);
                    sb7.append(" was found here: ");
                    sb7.append(path3);
                    log(sb7.toString());
                    arrayList.add(path3);
                    if (arrayList.size() > 0 && singlePath) {
                        break;
                    }
                } else {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str);
                    sb8.append(" was NOT found here: ");
                    sb8.append(path3);
                    log(sb8.toString());
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static Shell getCustomShell(String shellPath, int timeout) throws IOException, TimeoutException, RootDeniedException {
        return getCustomShell(shellPath, timeout);
    }

    public static List<String> getPath() {
        return Arrays.asList(System.getenv("PATH").split(":"));
    }

    public static Shell getShell(boolean root, int timeout, ShellContext shellContext, int retry) throws IOException, TimeoutException, RootDeniedException {
        if (root) {
            return Shell.startRootShell(timeout, shellContext, retry);
        }
        return Shell.startShell(timeout);
    }

    public static Shell getShell(boolean root, int timeout, ShellContext shellContext) throws IOException, TimeoutException, RootDeniedException {
        return getShell(root, timeout, shellContext, 3);
    }

    public static Shell getShell(boolean root, ShellContext shellContext) throws IOException, TimeoutException, RootDeniedException {
        return getShell(root, 0, shellContext, 3);
    }

    public static Shell getShell(boolean root, int timeout) throws IOException, TimeoutException, RootDeniedException {
        return getShell(root, timeout, Shell.defaultContext, 3);
    }

    public static Shell getShell(boolean root) throws IOException, TimeoutException, RootDeniedException {
        return getShell(root, 0);
    }

    public static boolean isAccessGiven() {
        final Set<String> ID = new HashSet<>();
        try {
            log("Checking for Root access");
            Command command = new Command(Opcodes.IFLE, false, new String[]{"id"}) {
                public void commandOutput(int id, String line) {
                    if (id == 158) {
                        ID.addAll(Arrays.asList(line.split(" ")));
                    }
                    super.commandOutput(id, line);
                }
            };
            Shell.startRootShell().add(command);
            commandWait(Shell.startRootShell(), command);
            for (String userid : ID) {
                log(userid);
                if (userid.toLowerCase().contains("uid=0")) {
                    log("Access Given");
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Logger.getInstance().mo2142e(TAG, (Throwable) e);
            return false;
        }
    }

    public static boolean isBusyboxAvailable() {
        return findBinary("busybox", true).size() > 0 || findBinary("toybox", true).size() > 0;
    }

    public static boolean isRootAvailable() {
        return findBinary("su", true).size() > 0;
    }

    public static void log(String msg) {
        log(null, msg, LogLevel.DEBUG, null);
    }

    public static void log(String TAG2, String msg) {
        log(TAG2, msg, LogLevel.DEBUG, null);
    }

    public static void log(String msg, LogLevel type, Exception e) {
        log(null, msg, type, e);
    }

    public static boolean islog() {
        return debugMode;
    }

    public static void log(String TAG2, String msg, LogLevel type, Exception e) {
        if (msg != null && !msg.equals("") && debugMode) {
            if (TAG2 == null) {
                TAG2 = version;
            }
            int i = C46445.$SwitchMap$cm$aptoide$pt$root$RootShell$LogLevel[type.ordinal()];
            if (i == 1) {
                Log.v(TAG2, msg);
            } else if (i == 2) {
                Log.e(TAG2, msg, e);
            } else if (i == 3) {
                Log.d(TAG2, msg);
            } else if (i == 4) {
                Log.w(TAG2, msg);
            }
        }
    }

    private static void commandWait(Shell shell, Command cmd) throws Exception {
        while (!cmd.isFinished()) {
            log(version, shell.getCommandQueuePositionString(cmd));
            StringBuilder sb = new StringBuilder();
            sb.append("Processed ");
            sb.append(cmd.totalOutputProcessed);
            sb.append(" of ");
            sb.append(cmd.totalOutput);
            sb.append(" output from command.");
            log(version, sb.toString());
            synchronized (cmd) {
                try {
                    if (!cmd.isFinished()) {
                        cmd.wait(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!cmd.isExecuting() && !cmd.isFinished()) {
                if (!shell.isExecuting && !shell.isReading) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: ");
                    sb2.append(cmd.getCommand());
                    log(version, sb2.toString());
                    Exception e2 = new Exception();
                    e2.setStackTrace(Thread.currentThread().getStackTrace());
                    e2.printStackTrace();
                } else if (!shell.isExecuting || shell.isReading) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Waiting for a command to be executed in a shell that is not reading! \n\n Command: ");
                    sb3.append(cmd.getCommand());
                    log(version, sb3.toString());
                    Exception e3 = new Exception();
                    e3.setStackTrace(Thread.currentThread().getStackTrace());
                    e3.printStackTrace();
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: ");
                    sb4.append(cmd.getCommand());
                    log(version, sb4.toString());
                    Exception e4 = new Exception();
                    e4.setStackTrace(Thread.currentThread().getStackTrace());
                    e4.printStackTrace();
                }
            }
        }
    }
}
