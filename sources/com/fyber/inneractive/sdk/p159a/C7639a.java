package com.fyber.inneractive.sdk.p159a;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fyber.inneractive.sdk.a.a */
public final class C7639a {

    /* renamed from: a */
    public boolean f15150a;

    /* renamed from: b */
    public Context f15151b;

    /* renamed from: c */
    OutputStreamWriter f15152c;

    /* renamed from: d */
    public String f15153d;

    /* renamed from: e */
    public File f15154e;

    /* renamed from: f */
    FileOutputStream f15155f;

    /* renamed from: g */
    private final String f15156g;

    /* renamed from: com.fyber.inneractive.sdk.a.a$a */
    private static class C7640a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static C7639a f15157a = new C7639a(0);
    }

    /* synthetic */ C7639a(byte b) {
        this();
    }

    private C7639a() {
        this.f15156g = "com.inneractive.automation";
        this.f15150a = false;
        this.f15153d = "config.txt";
        this.f15155f = null;
    }

    /* renamed from: b */
    public final void mo24033b(String str) {
        String str2 = "\n";
        try {
            this.f15155f = new FileOutputStream(this.f15154e, true);
            FileOutputStream fileOutputStream = this.f15155f;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            fileOutputStream.write(sb.toString().getBytes());
            this.f15152c = new OutputStreamWriter(this.f15151b.openFileOutput(this.f15153d, Opcodes.ACC_MANDATED));
            OutputStreamWriter outputStreamWriter = this.f15152c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            outputStreamWriter.write(sb2.toString());
            try {
                if (this.f15155f != null) {
                    this.f15155f.close();
                }
                if (this.f15152c != null) {
                    this.f15152c.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (this.f15155f != null) {
                this.f15155f.close();
            }
            if (this.f15152c != null) {
                this.f15152c.close();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            if (this.f15155f != null) {
                this.f15155f.close();
            }
            if (this.f15152c != null) {
                this.f15152c.close();
            }
        } catch (Throwable th) {
            try {
                if (this.f15155f != null) {
                    this.f15155f.close();
                }
                if (this.f15152c != null) {
                    this.f15152c.close();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static void m16877a(String str) {
        if (C7640a.f15157a.f15150a) {
            StringBuilder sb = new StringBuilder("SDK_EVENT, Event: ");
            sb.append(str);
            String str2 = "IA_CI_LOG";
            Log.v(str2, sb.toString());
            if (str.contains("Tracking URLs array:") && str.contains("eventType") && !str.contains("eventType=0")) {
                int indexOf = str.indexOf("eventType=") + 10;
                int intValue = Integer.valueOf(str.substring(indexOf, indexOf + 2)).intValue();
                if (C7640a.f15157a.f15150a) {
                    String str3 = "VAST_EVENT ";
                    StringBuilder sb2 = new StringBuilder(str3);
                    sb2.append(intValue);
                    Log.v(str2, sb2.toString());
                    C7639a a = C7640a.f15157a;
                    StringBuilder sb3 = new StringBuilder(str3);
                    sb3.append(intValue);
                    a.mo24033b(sb3.toString());
                }
            }
        }
    }
}
