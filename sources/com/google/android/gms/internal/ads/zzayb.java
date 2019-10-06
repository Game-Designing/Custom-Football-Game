package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager.BadTokenException;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzayb {

    /* renamed from: a */
    private final Context f24973a;

    /* renamed from: b */
    private String f24974b;

    /* renamed from: c */
    private String f24975c;

    /* renamed from: d */
    private String f24976d;

    /* renamed from: e */
    private String f24977e;

    /* renamed from: f */
    private int f24978f;

    /* renamed from: g */
    private int f24979g;

    /* renamed from: h */
    private PointF f24980h;

    /* renamed from: i */
    private PointF f24981i;

    /* renamed from: j */
    private Handler f24982j;

    /* renamed from: k */
    private Runnable f24983k;

    public zzayb(Context context) {
        this.f24978f = 0;
        this.f24983k = new C9553lc(this);
        this.f24973a = context;
        this.f24979g = ViewConfiguration.get(context).getScaledTouchSlop();
        zzk.zzlu().mo30298b();
        this.f24982j = zzk.zzlu().mo30297a();
    }

    public zzayb(Context context, String str) {
        this(context);
        this.f24974b = str;
    }

    /* renamed from: a */
    public final void mo30268a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.f24978f = 0;
            this.f24980h = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.f24978f;
        if (i != -1) {
            boolean z = true;
            if (i == 0 && actionMasked == 5) {
                this.f24978f = 5;
                this.f24981i = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                this.f24982j.postDelayed(this.f24983k, ((Long) zzyt.m31536e().mo29599a(zzacu.f23924Ed)).longValue());
                return;
            }
            if (this.f24978f == 5) {
                if (pointerCount == 2) {
                    if (actionMasked == 2) {
                        boolean z2 = false;
                        for (int i2 = 0; i2 < historySize; i2++) {
                            if (!m26216a(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2))) {
                                z2 = true;
                            }
                        }
                        if (m26216a(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                            z = z2;
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    this.f24978f = -1;
                    this.f24982j.removeCallbacks(this.f24983k);
                }
            }
        }
    }

    /* renamed from: a */
    private final boolean m26216a(float f, float f2, float f3, float f4) {
        return Math.abs(this.f24980h.x - f) < ((float) this.f24979g) && Math.abs(this.f24980h.y - f2) < ((float) this.f24979g) && Math.abs(this.f24981i.x - f3) < ((float) this.f24979g) && Math.abs(this.f24981i.y - f4) < ((float) this.f24979g);
    }

    /* renamed from: a */
    public final void mo30266a() {
        String str;
        String str2;
        try {
            if (!(this.f24973a instanceof Activity)) {
                zzbad.m26357c("Can not create dialog without Activity Context");
                return;
            }
            if (!TextUtils.isEmpty(zzk.zzlq().mo30278a())) {
                str = "Creative Preview (Enabled)";
            } else {
                str = "Creative Preview";
            }
            if (zzk.zzlq().mo30281b()) {
                str2 = "Troubleshooting (Enabled)";
            } else {
                str2 = "Troubleshooting";
            }
            ArrayList arrayList = new ArrayList();
            int a = m26215a((List<String>) arrayList, "Ad Information", true);
            int a2 = m26215a((List<String>) arrayList, str, true);
            int a3 = m26215a((List<String>) arrayList, str2, true);
            Builder builder = new Builder(this.f24973a, zzk.zzli().mo30260d());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new C9575mc(this, a, a2, a3));
            builder.create().show();
        } catch (BadTokenException e) {
            zzawz.m26002e("", e);
        }
    }

    /* renamed from: a */
    public final void mo30269a(String str) {
        this.f24975c = str;
    }

    /* renamed from: d */
    public final void mo30276d(String str) {
        this.f24976d = str;
    }

    /* renamed from: b */
    public final void mo30272b(String str) {
        this.f24974b = str;
    }

    /* renamed from: c */
    public final void mo30274c(String str) {
        this.f24977e = str;
    }

    /* renamed from: a */
    private static int m26215a(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.f24974b);
        sb.append(",DebugSignal: ");
        sb.append(this.f24977e);
        sb.append(",AFMA Version: ");
        sb.append(this.f24976d);
        sb.append(",Ad Unit ID: ");
        sb.append(this.f24975c);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo30271b() {
        zzk.zzlq().mo30280a(this.f24973a, this.f24975c, this.f24976d, this.f24977e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final /* synthetic */ void mo30273c() {
        zzk.zzlq().mo30279a(this.f24973a, this.f24975c, this.f24976d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30270a(String str, DialogInterface dialogInterface, int i) {
        zzk.zzlg();
        zzaxi.m26109a(this.f24973a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0070, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0075;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void mo30267a(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L_0x009e
            android.content.Context r1 = r0.f24973a
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto L_0x000f
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.ads.zzbad.m26357c(r1)
            return
        L_0x000f:
            java.lang.String r1 = r0.f24974b
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0073
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.zzk.zzlg()
            java.util.Map r1 = com.google.android.gms.internal.ads.zzaxi.m26107a(r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0040:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0064
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L_0x0040
        L_0x0064:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            java.lang.String r1 = "No debug information"
        L_0x0075:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.f24973a
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            com.google.android.gms.internal.ads.nc r3 = new com.google.android.gms.internal.ads.nc
            r3.<init>(r0, r1)
            java.lang.String r1 = "Share"
            r2.setPositiveButton(r1, r3)
            android.content.DialogInterface$OnClickListener r1 = com.google.android.gms.internal.ads.C9619oc.f22831a
            java.lang.String r3 = "Close"
            r2.setNegativeButton(r3, r1)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            return
        L_0x009e:
            if (r5 != r2) goto L_0x00af
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.internal.ads.zzbad.m26352a(r1)
            com.google.android.gms.internal.ads.pc r1 = new com.google.android.gms.internal.ads.pc
            r1.<init>(r0)
            com.google.android.gms.internal.ads.zzaxg.m26094a(r1)
            return
        L_0x00af:
            if (r5 != r3) goto L_0x00bf
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.internal.ads.zzbad.m26352a(r1)
            com.google.android.gms.internal.ads.qc r1 = new com.google.android.gms.internal.ads.qc
            r1.<init>(r0)
            com.google.android.gms.internal.ads.zzaxg.m26094a(r1)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayb.mo30267a(int, int, int, android.content.DialogInterface, int):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final /* synthetic */ void mo30275d() {
        this.f24978f = 4;
        mo30266a();
    }
}
