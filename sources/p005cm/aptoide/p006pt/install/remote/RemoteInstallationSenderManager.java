package p005cm.aptoide.p006pt.install.remote;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p346g.p347a.C13815a;
import p346g.p347a.C13820c;
import p346g.p347a.C13821d;
import p346g.p347a.C13823e;

/* renamed from: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager */
public class RemoteInstallationSenderManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    static final int DISCOVERY_TO = 20000;
    static final String INVALID_PAYLOAD_RESPONSE = "INVALIDPAYLOAD";
    static final String PAYLOAD_TAG = "apkinstall_appid=";
    static final String SERVER_TAG_TO_REMOVE = ".local.";
    static final String SERVICE_TYPE = "_aptoide-rmtinst._tcp.local.";
    static final String SUCCESS_TAG = "receivedpayload=";
    static final String TAG = RemoteInstallationSenderManager.class.getSimpleName();
    static final int TIMEOUT = 10000;
    SocketClientThread clientServerThread;
    Context context;
    Handler handler = new Handler();
    C13815a jmDNS;
    RemoteInstallationSenderListener listener;
    MulticastLock multicastLock;

    /* renamed from: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager$SocketClientThread */
    private class SocketClientThread extends AsyncTask<Void, Void, Boolean> {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String app;
        private ReceiverDevice device;
        final /* synthetic */ RemoteInstallationSenderManager this$0;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-4899584583112408516L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager$SocketClientThread", 98);
            $jacocoData = probes;
            return probes;
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            boolean[] $jacocoInit = $jacocoInit();
            Boolean doInBackground = doInBackground((Void[]) objArr);
            $jacocoInit[97] = true;
            return doInBackground;
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            boolean[] $jacocoInit = $jacocoInit();
            onPostExecute((Boolean) obj);
            $jacocoInit[96] = true;
        }

        public SocketClientThread(RemoteInstallationSenderManager remoteInstallationSenderManager, ReceiverDevice device2, String app2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = remoteInstallationSenderManager;
            this.device = device2;
            this.app = app2;
            $jacocoInit[0] = true;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x02fd  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x0302  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x030f  */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x0314  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0240  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0245  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x027b  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0280  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x028d  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0292  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x02c2  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x02c7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(java.lang.Void... r13) {
            /*
                r12 = this;
                java.lang.String r0 = "Remote Install - SocketClientThread BR Closing Error: "
                java.lang.String r1 = "Remote Install - SocketClientThread Closing Error: "
                boolean[] r2 = $jacocoInit()
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 1
                r7 = 0
                r2[r6] = r6     // Catch:{ IOException -> 0x0231, all -> 0x022e }
                java.net.Socket r8 = new java.net.Socket     // Catch:{ IOException -> 0x022c }
                cm.aptoide.pt.install.remote.ReceiverDevice r9 = r12.device     // Catch:{ IOException -> 0x022c }
                java.net.InetAddress r9 = r9.getAddress()     // Catch:{ IOException -> 0x022c }
                cm.aptoide.pt.install.remote.ReceiverDevice r10 = r12.device     // Catch:{ IOException -> 0x022c }
                int r10 = r10.getPort()     // Catch:{ IOException -> 0x022c }
                r8.<init>(r9, r10)     // Catch:{ IOException -> 0x022c }
                r3 = r8
                r8 = 2
                r2[r8] = r6     // Catch:{ IOException -> 0x022c }
                r8 = 10000(0x2710, float:1.4013E-41)
                r3.setSoTimeout(r8)     // Catch:{ IOException -> 0x022c }
                r8 = 3
                r2[r8] = r6     // Catch:{ IOException -> 0x022c }
                java.io.PrintWriter r8 = new java.io.PrintWriter     // Catch:{ IOException -> 0x022c }
                java.io.OutputStream r9 = r3.getOutputStream()     // Catch:{ IOException -> 0x022c }
                r8.<init>(r9, r6)     // Catch:{ IOException -> 0x022c }
                r4 = r8
                r8 = 4
                r2[r8] = r6     // Catch:{ IOException -> 0x022c }
                java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ IOException -> 0x022c }
                java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x022c }
                java.io.InputStream r10 = r3.getInputStream()     // Catch:{ IOException -> 0x022c }
                r9.<init>(r10)     // Catch:{ IOException -> 0x022c }
                r8.<init>(r9)     // Catch:{ IOException -> 0x022c }
                r7 = r8
                r8 = 5
                r2[r8] = r6     // Catch:{ IOException -> 0x022c }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x022c }
                r8.<init>()     // Catch:{ IOException -> 0x022c }
                java.lang.String r9 = "apkinstall_appid="
                r8.append(r9)     // Catch:{ IOException -> 0x022c }
                java.lang.String r9 = r12.app     // Catch:{ IOException -> 0x022c }
                r8.append(r9)     // Catch:{ IOException -> 0x022c }
                java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x022c }
                r4.println(r8)     // Catch:{ IOException -> 0x022c }
                r8 = 6
                r2[r8] = r6     // Catch:{ IOException -> 0x022c }
                java.lang.String r8 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG     // Catch:{ IOException -> 0x022c }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x022c }
                r9.<init>()     // Catch:{ IOException -> 0x022c }
                java.lang.String r10 = "Remote Install - SocketClientThread Sent: apkinstall_appid="
                r9.append(r10)     // Catch:{ IOException -> 0x022c }
                java.lang.String r10 = r12.app     // Catch:{ IOException -> 0x022c }
                r9.append(r10)     // Catch:{ IOException -> 0x022c }
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x022c }
                android.util.Log.i(r8, r9)     // Catch:{ IOException -> 0x022c }
                r8 = 7
                r2[r8] = r6     // Catch:{ IOException -> 0x022c }
                java.lang.String r8 = r7.readLine()     // Catch:{ IOException -> 0x022c }
                r9 = 8
                r2[r9] = r6     // Catch:{ IOException -> 0x022c }
                java.lang.String r9 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG     // Catch:{ IOException -> 0x022c }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x022c }
                r10.<init>()     // Catch:{ IOException -> 0x022c }
                java.lang.String r11 = "Remote Install - SocketClientThread Received: "
                r10.append(r11)     // Catch:{ IOException -> 0x022c }
                r10.append(r8)     // Catch:{ IOException -> 0x022c }
                java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x022c }
                android.util.Log.i(r9, r10)     // Catch:{ IOException -> 0x022c }
                r9 = 9
                r2[r9] = r6     // Catch:{ IOException -> 0x022c }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x022c }
                r9.<init>()     // Catch:{ IOException -> 0x022c }
                java.lang.String r10 = "receivedpayload="
                r9.append(r10)     // Catch:{ IOException -> 0x022c }
                java.lang.String r10 = r12.app     // Catch:{ IOException -> 0x022c }
                r9.append(r10)     // Catch:{ IOException -> 0x022c }
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x022c }
                boolean r9 = r8.equals(r9)     // Catch:{ IOException -> 0x022c }
                if (r9 != 0) goto L_0x01b0
                r9 = 10
                r2[r9] = r6     // Catch:{ IOException -> 0x022c }
                java.lang.String r9 = "INVALIDPAYLOAD"
                boolean r9 = r8.equals(r9)     // Catch:{ IOException -> 0x022c }
                if (r9 == 0) goto L_0x013f
                r9 = 28
                r2[r9] = r6     // Catch:{ IOException -> 0x022c }
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)     // Catch:{ IOException -> 0x022c }
                r10 = 29
                r2[r10] = r6     // Catch:{ IOException -> 0x022c }
                boolean r5 = r3.isClosed()
                if (r5 == 0) goto L_0x00dd
                r1 = 31
                r2[r1] = r6
                goto L_0x0106
            L_0x00dd:
                r5 = 32
                r2[r5] = r6     // Catch:{ IOException -> 0x00e9 }
                r3.close()     // Catch:{ IOException -> 0x00e9 }
                r1 = 33
                r2[r1] = r6
                goto L_0x0106
            L_0x00e9:
                r5 = move-exception
                r10 = 34
                r2[r10] = r6
                java.lang.String r10 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                r11.append(r1)
                r11.append(r5)
                java.lang.String r1 = r11.toString()
                android.util.Log.e(r10, r1)
                r1 = 35
                r2[r1] = r6
            L_0x0106:
                r1 = 37
                r2[r1] = r6
                r4.close()
                r1 = 38
                r2[r1] = r6
                r1 = 40
                r2[r1] = r6     // Catch:{ IOException -> 0x011d }
                r7.close()     // Catch:{ IOException -> 0x011d }
                r0 = 41
                r2[r0] = r6
                goto L_0x013a
            L_0x011d:
                r1 = move-exception
                r5 = 42
                r2[r5] = r6
                java.lang.String r5 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r0)
                r10.append(r1)
                java.lang.String r0 = r10.toString()
                android.util.Log.e(r5, r0)
                r0 = 43
                r2[r0] = r6
            L_0x013a:
                r0 = 44
                r2[r0] = r6
                return r9
            L_0x013f:
                boolean r8 = r3.isClosed()
                if (r8 == 0) goto L_0x014a
                r1 = 46
                r2[r1] = r6
                goto L_0x0173
            L_0x014a:
                r8 = 47
                r2[r8] = r6     // Catch:{ IOException -> 0x0156 }
                r3.close()     // Catch:{ IOException -> 0x0156 }
                r1 = 48
                r2[r1] = r6
                goto L_0x0173
            L_0x0156:
                r8 = move-exception
                r9 = 49
                r2[r9] = r6
                java.lang.String r9 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r1)
                r10.append(r8)
                java.lang.String r1 = r10.toString()
                android.util.Log.e(r9, r1)
                r1 = 50
                r2[r1] = r6
            L_0x0173:
                r1 = 52
                r2[r1] = r6
                r4.close()
                r1 = 53
                r2[r1] = r6
                r1 = 55
                r2[r1] = r6     // Catch:{ IOException -> 0x018a }
                r7.close()     // Catch:{ IOException -> 0x018a }
                r0 = 56
                r2[r0] = r6
                goto L_0x01a7
            L_0x018a:
                r1 = move-exception
                r8 = 57
                r2[r8] = r6
                java.lang.String r8 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                r9.append(r0)
                r9.append(r1)
                java.lang.String r0 = r9.toString()
                android.util.Log.e(r8, r0)
                r0 = 58
                r2[r0] = r6
            L_0x01a7:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r5)
                r1 = 91
                r2[r1] = r6
                return r0
            L_0x01b0:
                r9 = 11
                r2[r9] = r6     // Catch:{ IOException -> 0x022c }
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r6)     // Catch:{ IOException -> 0x022c }
                r10 = 12
                r2[r10] = r6     // Catch:{ IOException -> 0x022c }
                boolean r5 = r3.isClosed()
                if (r5 == 0) goto L_0x01c7
                r1 = 14
                r2[r1] = r6
                goto L_0x01f0
            L_0x01c7:
                r5 = 15
                r2[r5] = r6     // Catch:{ IOException -> 0x01d3 }
                r3.close()     // Catch:{ IOException -> 0x01d3 }
                r1 = 16
                r2[r1] = r6
                goto L_0x01f0
            L_0x01d3:
                r5 = move-exception
                r10 = 17
                r2[r10] = r6
                java.lang.String r10 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                r11.append(r1)
                r11.append(r5)
                java.lang.String r1 = r11.toString()
                android.util.Log.e(r10, r1)
                r1 = 18
                r2[r1] = r6
            L_0x01f0:
                r1 = 20
                r2[r1] = r6
                r4.close()
                r1 = 21
                r2[r1] = r6
                r1 = 23
                r2[r1] = r6     // Catch:{ IOException -> 0x0207 }
                r7.close()     // Catch:{ IOException -> 0x0207 }
                r0 = 24
                r2[r0] = r6
                goto L_0x0224
            L_0x0207:
                r1 = move-exception
                r5 = 25
                r2[r5] = r6
                java.lang.String r5 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r0)
                r10.append(r1)
                java.lang.String r0 = r10.toString()
                android.util.Log.e(r5, r0)
                r0 = 26
                r2[r0] = r6
            L_0x0224:
                r0 = 27
                r2[r0] = r6
                return r9
            L_0x0229:
                r5 = move-exception
                goto L_0x02c0
            L_0x022c:
                r8 = move-exception
                goto L_0x0232
            L_0x022e:
                r5 = move-exception
                goto L_0x02c0
            L_0x0231:
                r8 = move-exception
            L_0x0232:
                r9 = 59
                r2[r9] = r6     // Catch:{ all -> 0x0229 }
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0229 }
                r9 = 60
                r2[r9] = r6     // Catch:{ all -> 0x0229 }
                if (r3 != 0) goto L_0x0245
                r1 = 61
                r2[r1] = r6
                goto L_0x0279
            L_0x0245:
                boolean r9 = r3.isClosed()
                if (r9 == 0) goto L_0x0250
                r1 = 62
                r2[r1] = r6
                goto L_0x0279
            L_0x0250:
                r9 = 63
                r2[r9] = r6     // Catch:{ IOException -> 0x025c }
                r3.close()     // Catch:{ IOException -> 0x025c }
                r1 = 64
                r2[r1] = r6
                goto L_0x0279
            L_0x025c:
                r9 = move-exception
                r10 = 65
                r2[r10] = r6
                java.lang.String r10 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                r11.append(r1)
                r11.append(r9)
                java.lang.String r1 = r11.toString()
                android.util.Log.e(r10, r1)
                r1 = 66
                r2[r1] = r6
            L_0x0279:
                if (r4 != 0) goto L_0x0280
                r1 = 67
                r2[r1] = r6
                goto L_0x028b
            L_0x0280:
                r1 = 68
                r2[r1] = r6
                r4.close()
                r1 = 69
                r2[r1] = r6
            L_0x028b:
                if (r7 != 0) goto L_0x0292
                r0 = 70
                r2[r0] = r6
                goto L_0x02bb
            L_0x0292:
                r1 = 71
                r2[r1] = r6     // Catch:{ IOException -> 0x029e }
                r7.close()     // Catch:{ IOException -> 0x029e }
                r0 = 72
                r2[r0] = r6
                goto L_0x02bb
            L_0x029e:
                r1 = move-exception
                r9 = 73
                r2[r9] = r6
                java.lang.String r9 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r0)
                r10.append(r1)
                java.lang.String r0 = r10.toString()
                android.util.Log.e(r9, r0)
                r0 = 74
                r2[r0] = r6
            L_0x02bb:
                r0 = 75
                r2[r0] = r6
                return r5
            L_0x02c0:
                if (r3 != 0) goto L_0x02c7
                r1 = 76
                r2[r1] = r6
                goto L_0x02fb
            L_0x02c7:
                boolean r8 = r3.isClosed()
                if (r8 == 0) goto L_0x02d2
                r1 = 77
                r2[r1] = r6
                goto L_0x02fb
            L_0x02d2:
                r8 = 78
                r2[r8] = r6     // Catch:{ IOException -> 0x02de }
                r3.close()     // Catch:{ IOException -> 0x02de }
                r1 = 79
                r2[r1] = r6
                goto L_0x02fb
            L_0x02de:
                r8 = move-exception
                r9 = 80
                r2[r9] = r6
                java.lang.String r9 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r1)
                r10.append(r8)
                java.lang.String r1 = r10.toString()
                android.util.Log.e(r9, r1)
                r1 = 81
                r2[r1] = r6
            L_0x02fb:
                if (r4 != 0) goto L_0x0302
                r1 = 82
                r2[r1] = r6
                goto L_0x030d
            L_0x0302:
                r1 = 83
                r2[r1] = r6
                r4.close()
                r1 = 84
                r2[r1] = r6
            L_0x030d:
                if (r7 != 0) goto L_0x0314
                r0 = 85
                r2[r0] = r6
                goto L_0x033d
            L_0x0314:
                r1 = 86
                r2[r1] = r6     // Catch:{ IOException -> 0x0320 }
                r7.close()     // Catch:{ IOException -> 0x0320 }
                r0 = 87
                r2[r0] = r6
                goto L_0x033d
            L_0x0320:
                r1 = move-exception
                r8 = 88
                r2[r8] = r6
                java.lang.String r8 = p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.TAG
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                r9.append(r0)
                r9.append(r1)
                java.lang.String r0 = r9.toString()
                android.util.Log.e(r8, r0)
                r0 = 89
                r2[r0] = r6
            L_0x033d:
                r0 = 90
                r2[r0] = r6
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.install.remote.RemoteInstallationSenderManager.SocketClientThread.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean success) {
            boolean[] $jacocoInit = $jacocoInit();
            if (success.booleanValue()) {
                $jacocoInit[92] = true;
                this.this$0.listener.onAppSendSuccess();
                $jacocoInit[93] = true;
            } else {
                this.this$0.listener.onAppSendUnsuccess();
                $jacocoInit[94] = true;
            }
            super.onPostExecute(success);
            $jacocoInit[95] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5211071604718620536L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager", 17);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[16] = true;
    }

    public RemoteInstallationSenderManager(Context context2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    public void discoverAptoideTVServices(RemoteInstallationSenderListener listener2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.listener = listener2;
        $jacocoInit[2] = true;
        Thread thread = new Thread(new Runnable(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ RemoteInstallationSenderManager this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-3884260621555038665L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager$1", 14);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void run() {
                boolean[] $jacocoInit = $jacocoInit();
                try {
                    WifiManager wifi = (WifiManager) this.this$0.context.getSystemService("wifi");
                    $jacocoInit[1] = true;
                    RemoteInstallationSenderManager remoteInstallationSenderManager = this.this$0;
                    Class cls = this.this$0.context.getClass();
                    $jacocoInit[2] = true;
                    String name = cls.getName();
                    $jacocoInit[3] = true;
                    remoteInstallationSenderManager.multicastLock = wifi.createMulticastLock(name);
                    $jacocoInit[4] = true;
                    this.this$0.multicastLock.setReferenceCounted(true);
                    $jacocoInit[5] = true;
                    this.this$0.multicastLock.acquire();
                    $jacocoInit[6] = true;
                    this.this$0.jmDNS = C13815a.m43911a(this.this$0.getAddress(), Build.MODEL);
                    $jacocoInit[7] = true;
                    this.this$0.jmDNS.mo43160a(RemoteInstallationSenderManager.SERVICE_TYPE, (C13823e) new C13823e(this) {
                        private static transient /* synthetic */ boolean[] $jacocoData;
                        final /* synthetic */ C41101 this$1;

                        private static /* synthetic */ boolean[] $jacocoInit() {
                            boolean[] zArr = $jacocoData;
                            if (zArr != null) {
                                return zArr;
                            }
                            boolean[] probes = Offline.getProbes(2816055556638547015L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager$1$1", 22);
                            $jacocoData = probes;
                            return probes;
                        }

                        {
                            boolean[] $jacocoInit = $jacocoInit();
                            this.this$1 = this$1;
                            $jacocoInit[0] = true;
                        }

                        public void serviceAdded(C13820c event) {
                            boolean[] $jacocoInit = $jacocoInit();
                            String str = RemoteInstallationSenderManager.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Remote Installation - A service has been added: ");
                            sb.append(event.mo43166b());
                            Log.i(str, sb.toString());
                            $jacocoInit[1] = true;
                        }

                        public void serviceRemoved(C13820c event) {
                            boolean[] $jacocoInit = $jacocoInit();
                            C13821d info = event.mo43166b();
                            $jacocoInit[2] = true;
                            final InetAddress address = info.mo43173c()[0];
                            $jacocoInit[3] = true;
                            final int port = info.mo43178l();
                            $jacocoInit[4] = true;
                            String name = info.mo43182p();
                            $jacocoInit[5] = true;
                            String str = RemoteInstallationSenderManager.SERVER_TAG_TO_REMOVE;
                            if (!name.contains(str)) {
                                $jacocoInit[6] = true;
                            } else {
                                $jacocoInit[7] = true;
                                name = name.substring(0, name.length() - str.length());
                                $jacocoInit[8] = true;
                            }
                            $jacocoInit[9] = true;
                            final String fName = name;
                            String str2 = RemoteInstallationSenderManager.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Remote Installation - A service has been removed: ");
                            sb.append(event.mo43166b());
                            Log.i(str2, sb.toString());
                            $jacocoInit[10] = true;
                            this.this$1.this$0.runOnUiThread(new Runnable(this) {
                                private static transient /* synthetic */ boolean[] $jacocoData;
                                final /* synthetic */ C41111 this$2;

                                private static /* synthetic */ boolean[] $jacocoInit() {
                                    boolean[] zArr = $jacocoData;
                                    if (zArr != null) {
                                        return zArr;
                                    }
                                    boolean[] probes = Offline.getProbes(5777070078181328425L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager$1$1$1", 3);
                                    $jacocoData = probes;
                                    return probes;
                                }

                                {
                                    boolean[] $jacocoInit = $jacocoInit();
                                    this.this$2 = this$2;
                                    $jacocoInit[0] = true;
                                }

                                public void run() {
                                    boolean[] $jacocoInit = $jacocoInit();
                                    RemoteInstallationSenderListener remoteInstallationSenderListener = this.this$2.this$1.this$0.listener;
                                    ReceiverDevice receiverDevice = new ReceiverDevice(fName, address, port);
                                    $jacocoInit[1] = true;
                                    remoteInstallationSenderListener.onAptoideTVServiceLost(receiverDevice);
                                    $jacocoInit[2] = true;
                                }
                            });
                            $jacocoInit[11] = true;
                        }

                        public void serviceResolved(C13820c event) {
                            boolean[] $jacocoInit = $jacocoInit();
                            C13821d info = event.mo43166b();
                            $jacocoInit[12] = true;
                            final InetAddress address = info.mo43173c()[0];
                            $jacocoInit[13] = true;
                            final int port = info.mo43178l();
                            $jacocoInit[14] = true;
                            String name = info.mo43182p();
                            $jacocoInit[15] = true;
                            String str = RemoteInstallationSenderManager.SERVER_TAG_TO_REMOVE;
                            if (!name.contains(str)) {
                                $jacocoInit[16] = true;
                            } else {
                                $jacocoInit[17] = true;
                                name = name.substring(0, name.length() - str.length());
                                $jacocoInit[18] = true;
                            }
                            $jacocoInit[19] = true;
                            final String fName = name;
                            String str2 = RemoteInstallationSenderManager.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Remote Installation - A service has been resolved: ");
                            sb.append(event.mo43166b());
                            Log.i(str2, sb.toString());
                            $jacocoInit[20] = true;
                            this.this$1.this$0.runOnUiThread(new Runnable(this) {
                                private static transient /* synthetic */ boolean[] $jacocoData;
                                final /* synthetic */ C41111 this$2;

                                private static /* synthetic */ boolean[] $jacocoInit() {
                                    boolean[] zArr = $jacocoData;
                                    if (zArr != null) {
                                        return zArr;
                                    }
                                    boolean[] probes = Offline.getProbes(-6970702091895538696L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager$1$1$2", 3);
                                    $jacocoData = probes;
                                    return probes;
                                }

                                {
                                    boolean[] $jacocoInit = $jacocoInit();
                                    this.this$2 = this$2;
                                    $jacocoInit[0] = true;
                                }

                                public void run() {
                                    boolean[] $jacocoInit = $jacocoInit();
                                    RemoteInstallationSenderListener remoteInstallationSenderListener = this.this$2.this$1.this$0.listener;
                                    ReceiverDevice receiverDevice = new ReceiverDevice(fName, address, port);
                                    $jacocoInit[1] = true;
                                    remoteInstallationSenderListener.onAptoideTVServiceFound(receiverDevice);
                                    $jacocoInit[2] = true;
                                }
                            });
                            $jacocoInit[21] = true;
                        }
                    });
                    $jacocoInit[8] = true;
                    this.this$0.runOnUiThread(new Runnable(this) {
                        private static transient /* synthetic */ boolean[] $jacocoData;
                        final /* synthetic */ C41101 this$1;

                        private static /* synthetic */ boolean[] $jacocoInit() {
                            boolean[] zArr = $jacocoData;
                            if (zArr != null) {
                                return zArr;
                            }
                            boolean[] probes = Offline.getProbes(-6840716154184411423L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager$1$2", 2);
                            $jacocoData = probes;
                            return probes;
                        }

                        {
                            boolean[] $jacocoInit = $jacocoInit();
                            this.this$1 = this$1;
                            $jacocoInit[0] = true;
                        }

                        public void run() {
                            boolean[] $jacocoInit = $jacocoInit();
                            this.this$1.this$0.listener.onDiscoveryStarted();
                            $jacocoInit[1] = true;
                        }
                    });
                    $jacocoInit[9] = true;
                } catch (IOException e) {
                    $jacocoInit[10] = true;
                    this.this$0.runOnUiThread(new Runnable(this) {
                        private static transient /* synthetic */ boolean[] $jacocoData;
                        final /* synthetic */ C41101 this$1;

                        private static /* synthetic */ boolean[] $jacocoInit() {
                            boolean[] zArr = $jacocoData;
                            if (zArr != null) {
                                return zArr;
                            }
                            boolean[] probes = Offline.getProbes(6199690511323645477L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager$1$3", 2);
                            $jacocoData = probes;
                            return probes;
                        }

                        {
                            boolean[] $jacocoInit = $jacocoInit();
                            this.this$1 = this$1;
                            $jacocoInit[0] = true;
                        }

                        public void run() {
                            boolean[] $jacocoInit = $jacocoInit();
                            this.this$1.this$0.listener.onNoNetworkAccess();
                            $jacocoInit[1] = true;
                        }
                    });
                    $jacocoInit[11] = true;
                    String str = RemoteInstallationSenderManager.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Remote Installation - Error on discover: ");
                    sb.append(e);
                    Log.i(str, sb.toString());
                    $jacocoInit[12] = true;
                }
                $jacocoInit[13] = true;
            }
        });
        $jacocoInit[3] = true;
        thread.start();
        $jacocoInit[4] = true;
        runOnUiThread(new Runnable(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ RemoteInstallationSenderManager this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(1359609553357623499L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager$2", 2);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void run() {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0.stopDiscoveringAptoideTVServices();
                $jacocoInit[1] = true;
            }
        }, 20000);
        $jacocoInit[5] = true;
    }

    /* access modifiers changed from: 0000 */
    public InetAddress getAddress() throws UnknownHostException {
        boolean[] $jacocoInit = $jacocoInit();
        WifiManager wifi = (WifiManager) this.context.getSystemService("wifi");
        $jacocoInit[6] = true;
        WifiInfo wifiInfo = wifi.getConnectionInfo();
        $jacocoInit[7] = true;
        int intaddr = wifiInfo.getIpAddress();
        byte[] byteaddr = {(byte) (intaddr & 255), (byte) ((intaddr >> 8) & 255), (byte) ((intaddr >> 16) & 255), (byte) ((intaddr >> 24) & 255)};
        $jacocoInit[8] = true;
        InetAddress byAddress = InetAddress.getByAddress(byteaddr);
        $jacocoInit[9] = true;
        return byAddress;
    }

    /* access modifiers changed from: 0000 */
    public void runOnUiThread(Runnable runnable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.handler.post(runnable);
        $jacocoInit[10] = true;
    }

    /* access modifiers changed from: 0000 */
    public void runOnUiThread(Runnable runnable, long time) {
        boolean[] $jacocoInit = $jacocoInit();
        this.handler.postDelayed(runnable, time);
        $jacocoInit[11] = true;
    }

    public void stopDiscoveringAptoideTVServices() {
        boolean[] $jacocoInit = $jacocoInit();
        C41173 r1 = new AsyncTask<Void, Void, Void>(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            private boolean closed = false;
            final /* synthetic */ RemoteInstallationSenderManager this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-2432421259864992141L, "cm/aptoide/pt/install/remote/RemoteInstallationSenderManager$3", 18);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            /* access modifiers changed from: protected */
            public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
                boolean[] $jacocoInit = $jacocoInit();
                Void doInBackground = doInBackground((Void[]) objArr);
                $jacocoInit[17] = true;
                return doInBackground;
            }

            /* access modifiers changed from: protected */
            public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
                boolean[] $jacocoInit = $jacocoInit();
                onPostExecute((Void) obj);
                $jacocoInit[16] = true;
            }

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... params) {
                boolean[] $jacocoInit = $jacocoInit();
                try {
                    if (this.this$0.jmDNS == null) {
                        $jacocoInit[1] = true;
                    } else {
                        $jacocoInit[2] = true;
                        this.this$0.jmDNS.mo43161j();
                        $jacocoInit[3] = true;
                        this.this$0.jmDNS.close();
                        this.closed = true;
                        this.this$0.jmDNS = null;
                        $jacocoInit[4] = true;
                    }
                    if (this.this$0.multicastLock == null) {
                        $jacocoInit[5] = true;
                    } else {
                        $jacocoInit[6] = true;
                        this.this$0.multicastLock.release();
                        this.this$0.multicastLock = null;
                        $jacocoInit[7] = true;
                    }
                    $jacocoInit[8] = true;
                } catch (Exception ex) {
                    $jacocoInit[9] = true;
                    ex.printStackTrace();
                    $jacocoInit[10] = true;
                }
                $jacocoInit[11] = true;
                return null;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void aVoid) {
                boolean[] $jacocoInit = $jacocoInit();
                if (!this.closed) {
                    $jacocoInit[12] = true;
                } else {
                    $jacocoInit[13] = true;
                    this.this$0.listener.onDiscoveryStopped();
                    $jacocoInit[14] = true;
                }
                super.onPostExecute(aVoid);
                $jacocoInit[15] = true;
            }
        };
        Void[] voidArr = {null};
        $jacocoInit[12] = true;
        r1.execute(voidArr);
        $jacocoInit[13] = true;
    }

    public void sendAppId(ReceiverDevice device, String app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.clientServerThread = new SocketClientThread(this, device, app);
        $jacocoInit[14] = true;
        this.clientServerThread.execute(new Void[0]);
        $jacocoInit[15] = true;
    }
}
