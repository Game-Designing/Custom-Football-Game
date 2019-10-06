package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6344g;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {

    /* renamed from: a */
    private static final StackTraceElement[] f11032a = new StackTraceElement[0];

    /* renamed from: b */
    private final List<Throwable> f11033b;

    /* renamed from: c */
    private C6344g f11034c;

    /* renamed from: d */
    private C6031a f11035d;

    /* renamed from: e */
    private Class<?> f11036e;

    /* renamed from: f */
    private String f11037f;

    /* renamed from: com.bumptech.glide.load.engine.GlideException$a */
    private static final class C6239a implements Appendable {

        /* renamed from: a */
        private final Appendable f11038a;

        /* renamed from: b */
        private boolean f11039b = true;

        C6239a(Appendable appendable) {
            this.f11038a = appendable;
        }

        public Appendable append(char c) throws IOException {
            boolean z = false;
            if (this.f11039b) {
                this.f11039b = false;
                this.f11038a.append("  ");
            }
            if (c == 10) {
                z = true;
            }
            this.f11039b = z;
            this.f11038a.append(c);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence charSequence2 = m11911a(charSequence);
            append(charSequence2, 0, charSequence2.length());
            return this;
        }

        public Appendable append(CharSequence charSequence, int start, int end) throws IOException {
            CharSequence charSequence2 = m11911a(charSequence);
            boolean z = false;
            if (this.f11039b) {
                this.f11039b = false;
                this.f11038a.append("  ");
            }
            if (charSequence2.length() > 0 && charSequence2.charAt(end - 1) == 10) {
                z = true;
            }
            this.f11039b = z;
            this.f11038a.append(charSequence2, start, end);
            return this;
        }

        /* renamed from: a */
        private CharSequence m11911a(CharSequence sequence) {
            if (sequence == null) {
                return "";
            }
            return sequence;
        }
    }

    public GlideException(String message) {
        this(message, Collections.emptyList());
    }

    public GlideException(String detailMessage, Throwable cause) {
        this(detailMessage, Collections.singletonList(cause));
    }

    public GlideException(String detailMessage, List<Throwable> causes) {
        this.f11037f = detailMessage;
        setStackTrace(f11032a);
        this.f11033b = causes;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19105a(C6344g key, C6031a dataSource) {
        mo19106a(key, dataSource, null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19106a(C6344g key, C6031a dataSource, Class<?> dataClass) {
        this.f11034c = key;
        this.f11035d = dataSource;
        this.f11036e = dataClass;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    /* renamed from: a */
    public List<Throwable> mo19104a() {
        return this.f11033b;
    }

    /* renamed from: b */
    public List<Throwable> mo19108b() {
        List<Throwable> rootCauses = new ArrayList<>();
        m11903a((Throwable) this, rootCauses);
        return rootCauses;
    }

    /* renamed from: a */
    public void mo19107a(String tag) {
        List<Throwable> causes = mo19108b();
        int size = causes.size();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            sb.append(i + 1);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(tag, sb.toString(), (Throwable) causes.get(i));
        }
    }

    /* renamed from: a */
    private void m11903a(Throwable throwable, List<Throwable> rootCauses) {
        if (throwable instanceof GlideException) {
            for (Throwable t : ((GlideException) throwable).mo19104a()) {
                m11903a(t, rootCauses);
            }
            return;
        }
        rootCauses.add(throwable);
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream err) {
        m11901a((Appendable) err);
    }

    public void printStackTrace(PrintWriter err) {
        m11901a((Appendable) err);
    }

    /* renamed from: a */
    private void m11901a(Appendable appendable) {
        m11902a((Throwable) this, appendable);
        m11904a(mo19104a(), (Appendable) new C6239a(appendable));
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f11037f);
        String str3 = ", ";
        String str4 = "";
        if (this.f11036e != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(this.f11036e);
            str = sb2.toString();
        } else {
            str = str4;
        }
        sb.append(str);
        if (this.f11035d != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(this.f11035d);
            str2 = sb3.toString();
        } else {
            str2 = str4;
        }
        sb.append(str2);
        if (this.f11034c != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(this.f11034c);
            str4 = sb4.toString();
        }
        StringBuilder result = sb.append(str4);
        List<Throwable> rootCauses = mo19108b();
        if (rootCauses.isEmpty()) {
            return result.toString();
        }
        if (rootCauses.size() == 1) {
            result.append("\nThere was 1 cause:");
        } else {
            result.append("\nThere were ");
            result.append(rootCauses.size());
            result.append(" causes:");
        }
        for (Throwable cause : rootCauses) {
            result.append(10);
            result.append(cause.getClass().getName());
            result.append('(');
            result.append(cause.getMessage());
            result.append(')');
        }
        result.append("\n call GlideException#logRootCauses(String) for more detail");
        return result.toString();
    }

    /* renamed from: a */
    private static void m11902a(Throwable t, Appendable appendable) {
        try {
            appendable.append(t.getClass().toString()).append(": ").append(t.getMessage()).append(10);
        } catch (IOException e) {
            throw new RuntimeException(t);
        }
    }

    /* renamed from: a */
    private static void m11904a(List<Throwable> causes, Appendable appendable) {
        try {
            m11905b(causes, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    private static void m11905b(List<Throwable> causes, Appendable appendable) throws IOException {
        int size = causes.size();
        for (int i = 0; i < size; i++) {
            appendable.append("Cause (").append(String.valueOf(i + 1)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable cause = (Throwable) causes.get(i);
            if (cause instanceof GlideException) {
                ((GlideException) cause).m11901a(appendable);
            } else {
                m11902a(cause, appendable);
            }
        }
    }
}
