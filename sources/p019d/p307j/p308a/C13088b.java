package p019d.p307j.p308a;

import android.os.SystemClock;

/* renamed from: d.j.a.b */
/* compiled from: DownloadSpeedMonitor */
public class C13088b implements C13152y, C13151x {

    /* renamed from: a */
    private long f40074a;

    /* renamed from: b */
    private long f40075b;

    /* renamed from: c */
    private long f40076c;

    /* renamed from: d */
    private long f40077d;

    /* renamed from: e */
    private int f40078e;

    /* renamed from: f */
    private long f40079f;

    /* renamed from: g */
    private int f40080g = 5;

    public void start() {
        this.f40077d = SystemClock.uptimeMillis();
        this.f40076c = this.f40079f;
    }

    /* renamed from: b */
    public void mo42059b(long sofarBytes) {
        if (this.f40077d > 0) {
            long j = this.f40076c;
            if (j > 0) {
                long downloadSize = sofarBytes - j;
                this.f40074a = 0;
                long interval = SystemClock.uptimeMillis() - this.f40077d;
                if (interval < 0) {
                    this.f40078e = (int) downloadSize;
                } else {
                    this.f40078e = (int) (downloadSize / interval);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo42058a(long sofarBytes) {
        if (this.f40080g > 0) {
            boolean isUpdateData = false;
            if (this.f40074a == 0) {
                isUpdateData = true;
            } else {
                long interval = SystemClock.uptimeMillis() - this.f40074a;
                if (interval >= ((long) this.f40080g) || (this.f40078e == 0 && interval > 0)) {
                    this.f40078e = (int) ((sofarBytes - this.f40075b) / interval);
                    this.f40078e = Math.max(0, this.f40078e);
                    isUpdateData = true;
                }
            }
            if (isUpdateData) {
                this.f40075b = sofarBytes;
                this.f40074a = SystemClock.uptimeMillis();
            }
        }
    }

    public void reset() {
        this.f40078e = 0;
        this.f40074a = 0;
    }

    /* renamed from: h */
    public int mo42060h() {
        return this.f40078e;
    }
}
