package p024io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: io.reactivex.exceptions.CompositeException */
public final class CompositeException extends RuntimeException {

    /* renamed from: a */
    private final List<Throwable> f42353a;

    /* renamed from: b */
    private final String f42354b;

    /* renamed from: c */
    private Throwable f42355c;

    /* renamed from: io.reactivex.exceptions.CompositeException$a */
    static final class C13976a extends RuntimeException {
        C13976a() {
        }

        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$b */
    static abstract class C13977b {
        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract void mo43483a(Object obj);

        C13977b() {
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$c */
    static final class C13978c extends C13977b {

        /* renamed from: a */
        private final PrintStream f42356a;

        C13978c(PrintStream printStream) {
            this.f42356a = printStream;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43483a(Object o) {
            this.f42356a.println(o);
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$d */
    static final class C13979d extends C13977b {

        /* renamed from: a */
        private final PrintWriter f42357a;

        C13979d(PrintWriter printWriter) {
            this.f42357a = printWriter;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43483a(Object o) {
            this.f42357a.println(o);
        }
    }

    public CompositeException(Throwable... exceptions) {
        this((Iterable<? extends Throwable>) exceptions == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(exceptions));
    }

    public CompositeException(Iterable<? extends Throwable> errors) {
        Set<Throwable> deDupedExceptions = new LinkedHashSet<>();
        List<Throwable> localExceptions = new ArrayList<>();
        if (errors != null) {
            for (Throwable ex : errors) {
                if (ex instanceof CompositeException) {
                    deDupedExceptions.addAll(((CompositeException) ex).mo43476a());
                } else if (ex != null) {
                    deDupedExceptions.add(ex);
                } else {
                    deDupedExceptions.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            deDupedExceptions.add(new NullPointerException("errors was null"));
        }
        if (!deDupedExceptions.isEmpty()) {
            localExceptions.addAll(deDupedExceptions);
            this.f42353a = Collections.unmodifiableList(localExceptions);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f42353a.size());
            sb.append(" exceptions occurred. ");
            this.f42354b = sb.toString();
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    /* renamed from: a */
    public List<Throwable> mo43476a() {
        return this.f42353a;
    }

    public String getMessage() {
        return this.f42354b;
    }

    public synchronized Throwable getCause() {
        if (this.f42355c == null) {
            C13976a localCause = new C13976a();
            Set<Throwable> seenCauses = new HashSet<>();
            Throwable chain = localCause;
            for (Throwable e : this.f42353a) {
                if (!seenCauses.contains(e)) {
                    seenCauses.add(e);
                    for (Throwable child : m44453a(e)) {
                        if (seenCauses.contains(child)) {
                            e = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            seenCauses.add(child);
                        }
                    }
                    try {
                        chain.initCause(e);
                    } catch (Throwable th) {
                    }
                    chain = m44456b(chain);
                }
            }
            this.f42355c = localCause;
        }
        return this.f42355c;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream s) {
        m44454a((C13977b) new C13978c(s));
    }

    public void printStackTrace(PrintWriter s) {
        m44454a((C13977b) new C13979d(s));
    }

    /* renamed from: a */
    private void m44454a(C13977b s) {
        StackTraceElement[] stackTrace;
        StringBuilder b = new StringBuilder(128);
        b.append(this);
        b.append(10);
        for (StackTraceElement myStackElement : getStackTrace()) {
            b.append("\tat ");
            b.append(myStackElement);
            b.append(10);
        }
        int i = 1;
        for (Throwable ex : this.f42353a) {
            b.append("  ComposedException ");
            b.append(i);
            b.append(" :\n");
            m44455a(b, ex, "\t");
            i++;
        }
        s.mo43483a(b.toString());
    }

    /* renamed from: a */
    private void m44455a(StringBuilder b, Throwable ex, String prefix) {
        StackTraceElement[] stackTrace;
        b.append(prefix);
        b.append(ex);
        b.append(10);
        for (StackTraceElement stackElement : ex.getStackTrace()) {
            b.append("\t\tat ");
            b.append(stackElement);
            b.append(10);
        }
        if (ex.getCause() != null) {
            b.append("\tCaused by: ");
            m44455a(b, ex.getCause(), "");
        }
    }

    /* renamed from: a */
    private List<Throwable> m44453a(Throwable ex) {
        List<Throwable> list = new ArrayList<>();
        Throwable root = ex.getCause();
        if (root == null || root == ex) {
            return list;
        }
        while (true) {
            list.add(root);
            Throwable cause = root.getCause();
            if (cause == null || cause == root) {
                return list;
            }
            root = cause;
        }
        return list;
    }

    /* renamed from: b */
    private Throwable m44456b(Throwable e) {
        Throwable root = e.getCause();
        if (root == null || this.f42355c == root) {
            return e;
        }
        while (true) {
            Throwable cause = root.getCause();
            if (cause == null || cause == root) {
                return root;
            }
            root = cause;
        }
        return root;
    }
}
