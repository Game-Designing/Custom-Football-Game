package p019d.p273h.p285d.p294g;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.sdk.data.C10896i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p019d.p273h.p285d.p295h.C13001d;
import p019d.p273h.p285d.p295h.C13002e;
import p019d.p273h.p285d.p295h.C13003f;
import p019d.p273h.p285d.p295h.C13004g;

/* renamed from: d.h.d.g.a */
/* compiled from: DownloadManager */
public class C12992a {

    /* renamed from: a */
    private static C12992a f39937a;

    /* renamed from: b */
    private C12993a f39938b = mo41859a();

    /* renamed from: c */
    private Thread f39939c;

    /* renamed from: d */
    private String f39940d;

    /* renamed from: d.h.d.g.a$a */
    /* compiled from: DownloadManager */
    static class C12993a extends Handler {

        /* renamed from: a */
        C12995c f39941a;

        C12993a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41867a(C12995c listener) {
            if (listener != null) {
                this.f39941a = listener;
                return;
            }
            throw new IllegalArgumentException();
        }

        public void handleMessage(Message msg) {
            int i = msg.what;
            if (i == 1016) {
                this.f39941a.mo35460a((C10896i) msg.obj);
            } else if (i == 1017) {
                this.f39941a.mo35474b((C10896i) msg.obj);
            }
        }

        /* renamed from: a */
        public void mo41866a() {
            this.f39941a = null;
        }
    }

    /* renamed from: d.h.d.g.a$b */
    /* compiled from: DownloadManager */
    static class C12994b implements Callable<C12996d> {

        /* renamed from: a */
        private String f39942a;

        /* renamed from: b */
        private String f39943b;

        /* renamed from: c */
        private String f39944c;

        /* renamed from: d */
        private long f39945d;

        /* renamed from: e */
        private String f39946e;

        public C12994b(String url, String directory, String fileName, long connectionRetries, String tmpFilesDirectory) {
            this.f39942a = url;
            this.f39943b = directory;
            this.f39944c = fileName;
            this.f39945d = connectionRetries;
            this.f39946e = tmpFilesDirectory;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo41869a(byte[] data, String destFileName) throws Exception {
            return C13002e.m42419a(data, destFileName);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo41871a(String fromName, String toName) throws Exception {
            return C13002e.m42433e(fromName, toName);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public byte[] mo41872a(InputStream in) throws IOException {
            return C12992a.m42362a(in);
        }

        public C12996d call() {
            String str = "DownloadManager";
            C12996d results = null;
            if (this.f39945d == 0) {
                this.f39945d = 1;
            }
            for (int tryIndex = 0; ((long) tryIndex) < this.f39945d; tryIndex++) {
                results = mo41870a(this.f39942a, tryIndex);
                int responseCode = results.f39948b;
                if (responseCode != 1008 && responseCode != 1009) {
                    break;
                }
            }
            if (!(results == null || results.f39949c == null)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f39943b);
                sb.append(File.separator);
                sb.append(this.f39944c);
                String origFileName = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f39946e);
                sb2.append(File.separator);
                sb2.append("tmp_");
                sb2.append(this.f39944c);
                String tmpFileName = sb2.toString();
                try {
                    if (mo41869a(results.f39949c, tmpFileName) == 0) {
                        results.f39948b = 1006;
                    } else if (!mo41871a(tmpFileName, origFileName)) {
                        results.f39948b = 1020;
                    }
                } catch (FileNotFoundException e) {
                    results.f39948b = 1018;
                } catch (Exception e2) {
                    if (!TextUtils.isEmpty(e2.getMessage())) {
                        C13003f.m42438c(str, e2.getMessage());
                    }
                    results.f39948b = 1009;
                } catch (Error err) {
                    if (!TextUtils.isEmpty(err.getMessage())) {
                        C13003f.m42438c(str, err.getMessage());
                    }
                    results.f39948b = 1019;
                }
            }
            return results;
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0084, code lost:
            if (r2 != null) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00aa, code lost:
            if (r2 == null) goto L_0x0132;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ce, code lost:
            if (r2 == null) goto L_0x0132;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f7, code lost:
            if (r2 == null) goto L_0x0132;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0109, code lost:
            if (r2 == null) goto L_0x0132;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x011b, code lost:
            if (r2 == null) goto L_0x0132;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x012d, code lost:
            if (r2 == null) goto L_0x0132;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x012f, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0132, code lost:
            r1.f39947a = r9;
            r1.f39948b = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0137, code lost:
            return r1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a, all -> 0x0088 }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x007a A[SYNTHETIC, Splitter:B:16:0x007a] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public p019d.p273h.p285d.p294g.C12992a.C12996d mo41870a(java.lang.String r9, int r10) {
            /*
                r8 = this;
                java.lang.String r0 = "DownloadManager"
                d.h.d.g.a$d r1 = new d.h.d.g.a$d
                r1.<init>()
                r2 = 0
                r3 = 0
                boolean r4 = android.text.TextUtils.isEmpty(r9)
                if (r4 == 0) goto L_0x0016
                r1.f39947a = r9
                r0 = 1007(0x3ef, float:1.411E-42)
                r1.f39948b = r0
                return r1
            L_0x0016:
                r4 = 0
                java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r5.<init>(r9)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r5.toURI()     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                java.net.URLConnection r6 = r5.openConnection()     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r2 = r6
                java.lang.String r6 = "GET"
                r2.setRequestMethod(r6)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r6 = 5000(0x1388, float:7.006E-42)
                r2.setConnectTimeout(r6)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r2.setReadTimeout(r6)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r2.connect()     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                int r6 = r2.getResponseCode()     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r3 = r6
                r6 = 200(0xc8, float:2.8E-43)
                if (r3 < r6) goto L_0x0050
                r7 = 400(0x190, float:5.6E-43)
                if (r3 < r7) goto L_0x0044
                goto L_0x0050
            L_0x0044:
                java.io.InputStream r7 = r2.getInputStream()     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r4 = r7
                byte[] r7 = r8.mo41872a(r4)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r1.f39949c = r7     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                goto L_0x0052
            L_0x0050:
                r3 = 1011(0x3f3, float:1.417E-42)
            L_0x0052:
                if (r3 == r6) goto L_0x0078
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r6.<init>()     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                java.lang.String r7 = " RESPONSE CODE: "
                r6.append(r7)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r6.append(r3)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                java.lang.String r7 = " URL: "
                r6.append(r7)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r6.append(r9)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                java.lang.String r7 = " ATTEMPT: "
                r6.append(r7)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                r6.append(r10)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                java.lang.String r6 = r6.toString()     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
                p019d.p273h.p285d.p295h.C13003f.m42438c(r0, r6)     // Catch:{ MalformedURLException -> 0x011e, URISyntaxException -> 0x010c, SocketTimeoutException -> 0x00fa, FileNotFoundException -> 0x00e8, Exception -> 0x00ae, Error -> 0x008a }
            L_0x0078:
                if (r4 == 0) goto L_0x0083
                r4.close()     // Catch:{ IOException -> 0x007e }
                goto L_0x0083
            L_0x007e:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0084
            L_0x0083:
            L_0x0084:
                if (r2 == 0) goto L_0x0132
                goto L_0x012f
            L_0x0088:
                r0 = move-exception
                goto L_0x00d2
            L_0x008a:
                r5 = move-exception
                r3 = 1019(0x3fb, float:1.428E-42)
                java.lang.String r6 = r5.getMessage()     // Catch:{ all -> 0x0088 }
                boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0088 }
                if (r6 != 0) goto L_0x009e
                java.lang.String r6 = r5.getMessage()     // Catch:{ all -> 0x0088 }
                p019d.p273h.p285d.p295h.C13003f.m42438c(r0, r6)     // Catch:{ all -> 0x0088 }
            L_0x009e:
                if (r4 == 0) goto L_0x00a9
                r4.close()     // Catch:{ IOException -> 0x00a4 }
                goto L_0x00a9
            L_0x00a4:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x00aa
            L_0x00a9:
            L_0x00aa:
                if (r2 == 0) goto L_0x0132
                goto L_0x012f
            L_0x00ae:
                r5 = move-exception
                java.lang.String r6 = r5.getMessage()     // Catch:{ all -> 0x0088 }
                boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0088 }
                if (r6 != 0) goto L_0x00c0
                java.lang.String r6 = r5.getMessage()     // Catch:{ all -> 0x0088 }
                p019d.p273h.p285d.p295h.C13003f.m42438c(r0, r6)     // Catch:{ all -> 0x0088 }
            L_0x00c0:
                r3 = 1009(0x3f1, float:1.414E-42)
                if (r4 == 0) goto L_0x00cd
                r4.close()     // Catch:{ IOException -> 0x00c8 }
                goto L_0x00cd
            L_0x00c8:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x00ce
            L_0x00cd:
            L_0x00ce:
                if (r2 == 0) goto L_0x0132
                goto L_0x012f
            L_0x00d2:
                if (r4 == 0) goto L_0x00dd
                r4.close()     // Catch:{ IOException -> 0x00d8 }
                goto L_0x00dd
            L_0x00d8:
                r5 = move-exception
                r5.printStackTrace()
                goto L_0x00de
            L_0x00dd:
            L_0x00de:
                if (r2 == 0) goto L_0x00e3
                r2.disconnect()
            L_0x00e3:
                r1.f39947a = r9
                r1.f39948b = r3
                throw r0
            L_0x00e8:
                r0 = move-exception
                r3 = 1018(0x3fa, float:1.427E-42)
                if (r4 == 0) goto L_0x00f6
                r4.close()     // Catch:{ IOException -> 0x00f1 }
                goto L_0x00f6
            L_0x00f1:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x00f7
            L_0x00f6:
            L_0x00f7:
                if (r2 == 0) goto L_0x0132
                goto L_0x012f
            L_0x00fa:
                r0 = move-exception
                r3 = 1008(0x3f0, float:1.413E-42)
                if (r4 == 0) goto L_0x0108
                r4.close()     // Catch:{ IOException -> 0x0103 }
                goto L_0x0108
            L_0x0103:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0109
            L_0x0108:
            L_0x0109:
                if (r2 == 0) goto L_0x0132
                goto L_0x012f
            L_0x010c:
                r0 = move-exception
                r3 = 1010(0x3f2, float:1.415E-42)
                if (r4 == 0) goto L_0x011a
                r4.close()     // Catch:{ IOException -> 0x0115 }
                goto L_0x011a
            L_0x0115:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x011b
            L_0x011a:
            L_0x011b:
                if (r2 == 0) goto L_0x0132
                goto L_0x012f
            L_0x011e:
                r0 = move-exception
                r3 = 1004(0x3ec, float:1.407E-42)
                if (r4 == 0) goto L_0x012c
                r4.close()     // Catch:{ IOException -> 0x0127 }
                goto L_0x012c
            L_0x0127:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x012d
            L_0x012c:
            L_0x012d:
                if (r2 == 0) goto L_0x0132
            L_0x012f:
                r2.disconnect()
            L_0x0132:
                r1.f39947a = r9
                r1.f39948b = r3
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p285d.p294g.C12992a.C12994b.mo41870a(java.lang.String, int):d.h.d.g.a$d");
        }
    }

    /* renamed from: d.h.d.g.a$c */
    /* compiled from: DownloadManager */
    public interface C12995c {
        /* renamed from: a */
        void mo35460a(C10896i iVar);

        /* renamed from: b */
        void mo35474b(C10896i iVar);
    }

    /* renamed from: d.h.d.g.a$d */
    /* compiled from: DownloadManager */
    static class C12996d {

        /* renamed from: a */
        public String f39947a;

        /* renamed from: b */
        int f39948b;

        /* renamed from: c */
        byte[] f39949c;

        C12996d() {
        }
    }

    /* renamed from: d.h.d.g.a$e */
    /* compiled from: DownloadManager */
    static class C12997e implements Runnable {

        /* renamed from: a */
        private final String f39950a;

        /* renamed from: b */
        private String f39951b;

        /* renamed from: c */
        private String f39952c;

        /* renamed from: d */
        private String f39953d = mo41877a(this.f39951b);

        /* renamed from: e */
        private long f39954e = mo41874a();

        /* renamed from: f */
        private String f39955f;

        /* renamed from: g */
        Handler f39956g;

        C12997e(C10896i file, Handler downloadHandler, String cacheRootDir, String tempFilesDirectory) {
            this.f39951b = file.mo35662c();
            this.f39952c = file.mo35664e();
            this.f39955f = cacheRootDir;
            this.f39956g = downloadHandler;
            this.f39950a = tempFilesDirectory;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo41877a(String file) {
            return C13004g.m42452b(this.f39951b);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C12994b mo41875a(String url, String directory, String fileName, long connectionRetries, String tmpFilesDirectory) {
            C12994b bVar = new C12994b(url, directory, fileName, connectionRetries, tmpFilesDirectory);
            return bVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public Message mo41879b() {
            return new Message();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo41878a(String cacheRootDirectory, String directory) {
            return C13002e.m42432d(cacheRootDirectory, directory);
        }

        public void run() {
            C10896i ssaFile = new C10896i(this.f39953d, this.f39952c);
            Message msg = mo41879b();
            msg.obj = ssaFile;
            String folderName = mo41878a(this.f39955f, this.f39952c);
            if (folderName == null) {
                msg.what = 1017;
                ssaFile.mo35640f("unable_to_create_folder");
                this.f39956g.sendMessage(msg);
                return;
            }
            int code = mo41875a(this.f39951b, folderName, ssaFile.mo35662c(), this.f39954e, this.f39950a).call().f39948b;
            if (code != 200) {
                if (!(code == 404 || code == 1018 || code == 1019)) {
                    switch (code) {
                        case 1004:
                        case 1005:
                        case 1006:
                            break;
                        default:
                            switch (code) {
                                case 1008:
                                case 1009:
                                case 1010:
                                case 1011:
                                    break;
                                default:
                                    return;
                            }
                    }
                }
                String errMsg = mo41876a(code);
                msg.what = 1017;
                ssaFile.mo35640f(errMsg);
                this.f39956g.sendMessage(msg);
                return;
            }
            msg.what = 1016;
            this.f39956g.sendMessage(msg);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo41876a(int errorCode) {
            StringBuilder sb = new StringBuilder();
            sb.append("not defined message for ");
            sb.append(errorCode);
            String errMsg = sb.toString();
            if (errorCode != 404) {
                if (errorCode == 1018) {
                    return "file not found exception";
                }
                if (errorCode == 1019) {
                    return "out of memory exception";
                }
                switch (errorCode) {
                    case 1004:
                        return "malformed url exception";
                    case 1005:
                        break;
                    case 1006:
                        return "http empty response";
                    default:
                        switch (errorCode) {
                            case 1008:
                                return "socket timeout exception";
                            case 1009:
                                return "io exception";
                            case 1010:
                                return "uri syntax exception";
                            case 1011:
                                return "http error code";
                            default:
                                return errMsg;
                        }
                }
            }
            return "http not found";
        }

        /* renamed from: a */
        public long mo41874a() {
            return Long.parseLong(C13001d.m42395g().mo41902c());
        }
    }

    private C12992a(String cacheRootDirectory) {
        this.f39940d = cacheRootDirectory;
        String str = "temp";
        C13002e.m42425a(this.f39940d, str);
        C13002e.m42432d(this.f39940d, str);
    }

    /* renamed from: a */
    public static synchronized C12992a m42361a(String cacheRootDirectory) {
        C12992a aVar;
        synchronized (C12992a.class) {
            if (f39937a == null) {
                f39937a = new C12992a(cacheRootDirectory);
            }
            aVar = f39937a;
        }
        return aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C12993a mo41859a() {
        return new C12993a();
    }

    /* renamed from: a */
    public void mo41861a(C12995c listener) {
        this.f39938b.mo41867a(listener);
    }

    /* renamed from: d */
    public void mo41865d() {
        f39937a = null;
        this.f39938b.mo41866a();
        this.f39938b = null;
    }

    /* renamed from: a */
    public void mo41860a(C10896i file) {
        new Thread(new C12997e(file, this.f39938b, this.f39940d, mo41862b())).start();
    }

    /* renamed from: b */
    public void mo41863b(C10896i file) {
        this.f39939c = new Thread(new C12997e(file, this.f39938b, this.f39940d, mo41862b()));
        this.f39939c.start();
    }

    /* renamed from: c */
    public boolean mo41864c() {
        Thread thread = this.f39939c;
        return thread != null && thread.isAlive();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo41862b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39940d);
        sb.append(File.separator);
        sb.append("temp");
        return sb.toString();
    }

    /* renamed from: a */
    static byte[] m42362a(InputStream in) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[Opcodes.ACC_ANNOTATION];
        while (true) {
            int read = in.read(data, 0, data.length);
            int bytesRead = read;
            if (read != -1) {
                buffer.write(data, 0, bytesRead);
            } else {
                buffer.flush();
                return buffer.toByteArray();
            }
        }
    }
}
