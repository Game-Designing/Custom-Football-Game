package p019d.p314k.p315a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p000v4.content.C0515e;
import com.tonyodev.fetch.exception.DownloadInterruptedException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p019d.p314k.p315a.p317b.C13157a;

/* renamed from: d.k.a.i */
/* compiled from: FetchRunnable */
final class C13167i implements Runnable {

    /* renamed from: a */
    private final long f40230a;

    /* renamed from: b */
    private final String f40231b;

    /* renamed from: c */
    private final String f40232c;

    /* renamed from: d */
    private final List<C13157a> f40233d;

    /* renamed from: e */
    private final boolean f40234e;

    /* renamed from: f */
    private final long f40235f;

    /* renamed from: g */
    private final Context f40236g;

    /* renamed from: h */
    private final C0515e f40237h;

    /* renamed from: i */
    private final C13154a f40238i;

    /* renamed from: j */
    private volatile boolean f40239j = false;

    /* renamed from: k */
    private HttpURLConnection f40240k;

    /* renamed from: l */
    private BufferedInputStream f40241l;

    /* renamed from: m */
    private RandomAccessFile f40242m;

    /* renamed from: n */
    private int f40243n;

    /* renamed from: o */
    private long f40244o;

    /* renamed from: p */
    private long f40245p;

    /* renamed from: a */
    static IntentFilter m43011a() {
        return new IntentFilter("com.tonyodev.fetch.action_done");
    }

    C13167i(Context context, long id, String url, String filePath, List<C13157a> headers, long fileSize, boolean loggingEnabled, long onUpdateInterval) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        } else if (url == null) {
            throw new NullPointerException("Url cannot be null");
        } else if (filePath != null) {
            if (headers == null) {
                this.f40233d = new ArrayList();
            } else {
                this.f40233d = headers;
            }
            this.f40230a = id;
            this.f40231b = url;
            this.f40232c = filePath;
            this.f40245p = fileSize;
            this.f40236g = context.getApplicationContext();
            this.f40237h = C0515e.m2597a(this.f40236g);
            this.f40238i = C13154a.m42947a(this.f40236g);
            this.f40234e = loggingEnabled;
            this.f40235f = onUpdateInterval;
            this.f40238i.mo42171a(loggingEnabled);
        } else {
            throw new NullPointerException("FilePath cannot be null");
        }
    }

    public void run() {
        try {
            m43018h();
            C13178t.m43104c(this.f40232c);
            this.f40244o = C13178t.m43108g(this.f40232c);
            this.f40243n = C13178t.m43087a(this.f40244o, this.f40245p);
            this.f40238i.mo42175a(this.f40230a, this.f40244o, this.f40245p);
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(this.f40244o);
            sb.append("-");
            this.f40240k.setRequestProperty("Range", sb.toString());
            String str = "DIE";
            if (!m43015e()) {
                this.f40240k.connect();
                int responseCode = this.f40240k.getResponseCode();
                if (!m43013b(responseCode)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SSRV:");
                    sb2.append(responseCode);
                    throw new IllegalStateException(sb2.toString());
                } else if (!m43015e()) {
                    if (this.f40245p < 1) {
                        m43017g();
                        this.f40238i.mo42175a(this.f40230a, this.f40244o, this.f40245p);
                        this.f40243n = C13178t.m43087a(this.f40244o, this.f40245p);
                    }
                    this.f40242m = new RandomAccessFile(this.f40232c, "rw");
                    if (responseCode == 206) {
                        this.f40242m.seek(this.f40244o);
                    } else {
                        this.f40242m.seek(0);
                    }
                    this.f40241l = new BufferedInputStream(this.f40240k.getInputStream());
                    m43019i();
                    this.f40238i.mo42175a(this.f40230a, this.f40244o, this.f40245p);
                    if (!m43015e()) {
                        if (this.f40244o >= this.f40245p && !m43015e()) {
                            if (this.f40245p < 1) {
                                this.f40245p = C13178t.m43108g(this.f40232c);
                                this.f40238i.mo42175a(this.f40230a, this.f40244o, this.f40245p);
                                this.f40243n = C13178t.m43087a(this.f40244o, this.f40245p);
                            } else {
                                this.f40243n = C13178t.m43087a(this.f40244o, this.f40245p);
                            }
                            if (this.f40238i.mo42174a(this.f40230a, 903, -1)) {
                                C13178t.m43093a(this.f40237h, this.f40230a, 903, this.f40243n, this.f40244o, this.f40245p, -1);
                            }
                        }
                        m43016f();
                        m43014d();
                        return;
                    }
                    throw new DownloadInterruptedException(str, -118);
                } else {
                    throw new DownloadInterruptedException(str, -118);
                }
            } else {
                throw new DownloadInterruptedException(str, -118);
            }
        } catch (Exception exception) {
            if (this.f40234e) {
                exception.printStackTrace();
            }
            int error = C13156b.m42970a(exception.getMessage());
            if (m43012a(error)) {
                if (this.f40238i.mo42174a(this.f40230a, 900, -1)) {
                    C13178t.m43093a(this.f40237h, this.f40230a, 900, this.f40243n, this.f40244o, this.f40245p, -1);
                }
            } else if (this.f40238i.mo42174a(this.f40230a, 904, error)) {
                C13178t.m43093a(this.f40237h, this.f40230a, 904, this.f40243n, this.f40244o, this.f40245p, error);
            }
        } catch (Throwable th) {
            m43016f();
            m43014d();
            throw th;
        }
    }

    /* renamed from: h */
    private void m43018h() throws IOException {
        this.f40240k = (HttpURLConnection) new URL(this.f40231b).openConnection();
        this.f40240k.setRequestMethod("GET");
        this.f40240k.setReadTimeout(20000);
        this.f40240k.setConnectTimeout(15000);
        this.f40240k.setUseCaches(false);
        this.f40240k.setDefaultUseCaches(false);
        this.f40240k.setInstanceFollowRedirects(true);
        this.f40240k.setDoInput(true);
        for (C13157a header : this.f40233d) {
            this.f40240k.addRequestProperty(header.mo42192a(), header.mo42193b());
        }
    }

    /* renamed from: b */
    private boolean m43013b(int responseCode) {
        if (responseCode == 200 || responseCode == 202 || responseCode == 206) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    private void m43017g() {
        try {
            this.f40245p = this.f40244o + Long.valueOf(this.f40240k.getHeaderField("Content-Length")).longValue();
        } catch (Exception e) {
            this.f40245p = -1;
        }
    }

    /* renamed from: i */
    private void m43019i() throws IOException {
        int i = Opcodes.ACC_ABSTRACT;
        byte[] buffer = new byte[Opcodes.ACC_ABSTRACT];
        long startTime = System.nanoTime();
        while (true) {
            int read = this.f40241l.read(buffer, 0, i);
            int read2 = read;
            if (read == -1 || m43015e()) {
            } else {
                this.f40242m.write(buffer, 0, read2);
                this.f40244o += (long) read2;
                if (!C13178t.m43095a(startTime, System.nanoTime(), this.f40235f) || m43015e()) {
                    buffer = buffer;
                    i = Opcodes.ACC_ABSTRACT;
                } else {
                    this.f40243n = C13178t.m43087a(this.f40244o, this.f40245p);
                    byte[] buffer2 = buffer;
                    C13178t.m43093a(this.f40237h, this.f40230a, 901, this.f40243n, this.f40244o, this.f40245p, -1);
                    this.f40238i.mo42175a(this.f40230a, this.f40244o, this.f40245p);
                    startTime = System.nanoTime();
                    buffer = buffer2;
                    i = Opcodes.ACC_ABSTRACT;
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m43012a(int error) {
        if (!C13178t.m43096a(this.f40236g) || error == -118 || error == -104 || error == -103) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private void m43016f() {
        try {
            if (this.f40241l != null) {
                this.f40241l.close();
            }
        } catch (IOException e) {
            if (this.f40234e) {
                e.printStackTrace();
            }
        }
        try {
            if (this.f40242m != null) {
                this.f40242m.close();
            }
        } catch (IOException e2) {
            if (this.f40234e) {
                e2.printStackTrace();
            }
        }
        HttpURLConnection httpURLConnection = this.f40240k;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* renamed from: d */
    private void m43014d() {
        Intent intent = new Intent("com.tonyodev.fetch.action_done");
        intent.putExtra("com.tonyodev.fetch.extra_id", this.f40230a);
        this.f40237h.mo5314a(intent);
    }

    /* renamed from: e */
    private boolean m43015e() {
        return this.f40239j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public synchronized void mo42227c() {
        this.f40239j = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized long mo42226b() {
        return this.f40230a;
    }

    /* renamed from: a */
    static long m43010a(Intent intent) {
        if (intent == null) {
            return -1;
        }
        return intent.getLongExtra("com.tonyodev.fetch.extra_id", -1);
    }
}
