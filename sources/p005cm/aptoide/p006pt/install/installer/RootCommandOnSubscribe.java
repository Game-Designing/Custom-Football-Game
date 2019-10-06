package p005cm.aptoide.p006pt.install.installer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.InstallerAnalytics;
import p005cm.aptoide.p006pt.install.RootCommandTimeoutException;
import p005cm.aptoide.p006pt.install.exception.InstallationException;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.root.RootShell;
import p005cm.aptoide.p006pt.root.exceptions.RootDeniedException;
import p005cm.aptoide.p006pt.root.execution.Command;
import p005cm.aptoide.p006pt.root.execution.Shell;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p029i.C14978f;

/* renamed from: cm.aptoide.pt.install.installer.RootCommandOnSubscribe */
public class RootCommandOnSubscribe implements C0122a<Void> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String SUCCESS_OUTPUT_CONFIRMATION = "success";
    private static final String TAG = RootCommandOnSubscribe.class.getSimpleName();
    public static final String TIMEOUT_EXCEPTION = "Timeout Exception";
    private InstallerAnalytics analytics;
    private String command;
    private final int installId;
    private boolean success = false;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6422149074224316528L, "cm/aptoide/pt/install/installer/RootCommandOnSubscribe", 35);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ String access$000() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = TAG;
        $jacocoInit[29] = true;
        return str;
    }

    static /* synthetic */ int access$100(RootCommandOnSubscribe x0) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = x0.installId;
        $jacocoInit[30] = true;
        return i;
    }

    static /* synthetic */ boolean access$200(RootCommandOnSubscribe x0) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = x0.success;
        $jacocoInit[33] = true;
        return z;
    }

    static /* synthetic */ boolean access$202(RootCommandOnSubscribe x0, boolean x1) {
        boolean[] $jacocoInit = $jacocoInit();
        x0.success = x1;
        $jacocoInit[31] = true;
        return x1;
    }

    static /* synthetic */ InstallerAnalytics access$300(RootCommandOnSubscribe x0) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallerAnalytics installerAnalytics = x0.analytics;
        $jacocoInit[32] = true;
        return installerAnalytics;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((C14980ia) obj);
        $jacocoInit[24] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[34] = true;
    }

    public RootCommandOnSubscribe(int installId2, String command2, InstallerAnalytics analytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installId = installId2;
        this.command = command2;
        this.analytics = analytics2;
        $jacocoInit[0] = true;
    }

    public void call(final C14980ia<? super Void> subscriber) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("call: start with installation id: ");
        sb.append(this.installId);
        String sb2 = sb.toString();
        $jacocoInit[1] = true;
        instance.mo2136d(str, sb2);
        try {
            $jacocoInit[2] = true;
            Shell shell = RootShell.getShell(true);
            $jacocoInit[3] = true;
            if (RootShell.isRootAvailable()) {
                $jacocoInit[4] = true;
                this.analytics.rootInstallStart();
                $jacocoInit[9] = true;
                Command installCommand = new Command(this, this.installId, new String[]{this.command}) {
                    private static transient /* synthetic */ boolean[] $jacocoData;
                    final /* synthetic */ RootCommandOnSubscribe this$0;

                    private static /* synthetic */ boolean[] $jacocoInit() {
                        boolean[] zArr = $jacocoData;
                        if (zArr != null) {
                            return zArr;
                        }
                        boolean[] probes = Offline.getProbes(5059822623160652923L, "cm/aptoide/pt/install/installer/RootCommandOnSubscribe$1", 36);
                        $jacocoData = probes;
                        return probes;
                    }

                    {
                        boolean[] $jacocoInit = $jacocoInit();
                        this.this$0 = this$0;
                        $jacocoInit[0] = true;
                    }

                    public void commandOutput(int id, String line) {
                        boolean[] $jacocoInit = $jacocoInit();
                        Logger instance = Logger.getInstance();
                        $jacocoInit[1] = true;
                        String access$000 = RootCommandOnSubscribe.access$000();
                        StringBuilder sb = new StringBuilder();
                        sb.append("commandOutput: ");
                        sb.append(line);
                        instance.mo2136d(access$000, sb.toString());
                        $jacocoInit[2] = true;
                        if (id != RootCommandOnSubscribe.access$100(this.this$0)) {
                            $jacocoInit[3] = true;
                        } else {
                            String lowerCase = line.toLowerCase();
                            $jacocoInit[4] = true;
                            if (!lowerCase.equals(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)) {
                                $jacocoInit[5] = true;
                            } else {
                                $jacocoInit[6] = true;
                                RootCommandOnSubscribe.access$202(this.this$0, true);
                                $jacocoInit[7] = true;
                            }
                        }
                        super.commandOutput(id, line);
                        $jacocoInit[8] = true;
                    }

                    public void commandTerminated(int id, String reason) {
                        boolean[] $jacocoInit = $jacocoInit();
                        Logger instance = Logger.getInstance();
                        $jacocoInit[9] = true;
                        String access$000 = RootCommandOnSubscribe.access$000();
                        StringBuilder sb = new StringBuilder();
                        sb.append("commandTerminated: ");
                        sb.append(reason);
                        instance.mo2136d(access$000, sb.toString());
                        $jacocoInit[10] = true;
                        super.commandTerminated(id, reason);
                        $jacocoInit[11] = true;
                        if (RootCommandOnSubscribe.access$100(this.this$0) != id) {
                            $jacocoInit[12] = true;
                        } else {
                            $jacocoInit[13] = true;
                            if (reason.equals(RootCommandOnSubscribe.TIMEOUT_EXCEPTION)) {
                                $jacocoInit[14] = true;
                                RootCommandOnSubscribe.access$300(this.this$0).rootInstallTimeout();
                                $jacocoInit[15] = true;
                                subscriber.onError(new RootCommandTimeoutException());
                                $jacocoInit[16] = true;
                            } else if (subscriber.isUnsubscribed()) {
                                $jacocoInit[17] = true;
                            } else {
                                $jacocoInit[18] = true;
                                IllegalStateException e = new IllegalStateException(reason);
                                $jacocoInit[19] = true;
                                RootCommandOnSubscribe.access$300(this.this$0).rootInstallFail(e);
                                $jacocoInit[20] = true;
                                subscriber.onError(e);
                                $jacocoInit[21] = true;
                            }
                        }
                        $jacocoInit[22] = true;
                    }

                    public void commandCompleted(int id, int exitcode) {
                        boolean[] $jacocoInit = $jacocoInit();
                        Logger instance = Logger.getInstance();
                        $jacocoInit[23] = true;
                        String access$000 = RootCommandOnSubscribe.access$000();
                        StringBuilder sb = new StringBuilder();
                        sb.append("commandCompleted: ");
                        sb.append(exitcode);
                        instance.mo2136d(access$000, sb.toString());
                        $jacocoInit[24] = true;
                        if (subscriber.isUnsubscribed()) {
                            $jacocoInit[25] = true;
                        } else if (RootCommandOnSubscribe.access$100(this.this$0) != id) {
                            $jacocoInit[26] = true;
                        } else {
                            $jacocoInit[27] = true;
                            if (RootCommandOnSubscribe.access$200(this.this$0)) {
                                $jacocoInit[28] = true;
                            } else if (exitcode == 0) {
                                $jacocoInit[29] = true;
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("success message wasn't received. Exit code: ");
                                sb2.append(exitcode);
                                IllegalStateException e = new IllegalStateException(sb2.toString());
                                $jacocoInit[32] = true;
                                RootCommandOnSubscribe.access$300(this.this$0).rootInstallFail(e);
                                $jacocoInit[33] = true;
                                subscriber.onError(e);
                                $jacocoInit[34] = true;
                            }
                            subscriber.onCompleted();
                            $jacocoInit[30] = true;
                            RootCommandOnSubscribe.access$300(this.this$0).rootInstallCompleted(exitcode);
                            $jacocoInit[31] = true;
                        }
                        super.commandCompleted(id, exitcode);
                        $jacocoInit[35] = true;
                    }
                };
                $jacocoInit[10] = true;
                subscriber.add(C14978f.m46781a(new C4057D(shell)));
                $jacocoInit[11] = true;
                shell.add(installCommand);
                $jacocoInit[12] = true;
                $jacocoInit[23] = true;
                return;
            }
            $jacocoInit[5] = true;
            subscriber.onError(new InstallationException("No root permissions"));
            $jacocoInit[6] = true;
            $jacocoInit[7] = true;
            Logger.getInstance().mo2136d(TAG, "call: root not available");
            $jacocoInit[8] = true;
        } catch (RootDeniedException | IOException | TimeoutException e) {
            if (e instanceof RootDeniedException) {
                $jacocoInit[13] = true;
                this.analytics.rootInstallCancelled();
                $jacocoInit[14] = true;
                subscriber.onError(new InstallationException("User didn't accept root permissions"));
                $jacocoInit[15] = true;
            } else if (e instanceof TimeoutException) {
                $jacocoInit[16] = true;
                subscriber.onError(new RootCommandTimeoutException());
                $jacocoInit[17] = true;
                this.analytics.rootInstallTimeout();
                $jacocoInit[18] = true;
                Logger instance2 = Logger.getInstance();
                String str2 = TAG;
                $jacocoInit[19] = true;
                instance2.mo2136d(str2, "call: timeout reached");
                $jacocoInit[20] = true;
            } else {
                this.analytics.rootInstallFail(e);
                $jacocoInit[21] = true;
                subscriber.onError(e);
                $jacocoInit[22] = true;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m8609a(Shell shell) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            shell.close();
            $jacocoInit[25] = true;
        } catch (IOException e) {
            $jacocoInit[26] = true;
            e.printStackTrace();
            $jacocoInit[27] = true;
        }
        $jacocoInit[28] = true;
    }
}
