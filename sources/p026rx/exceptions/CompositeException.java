package p026rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: rx.exceptions.CompositeException */
public final class CompositeException extends RuntimeException {

    /* renamed from: a */
    private final List<Throwable> f44241a;

    /* renamed from: b */
    private final String f44242b;

    /* renamed from: c */
    private Throwable f44243c;

    /* renamed from: rx.exceptions.CompositeException$a */
    static final class C14922a extends RuntimeException {
        C14922a() {
        }

        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* renamed from: rx.exceptions.CompositeException$b */
    static abstract class C14923b {
        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract Object mo46131a();

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract void mo46132a(Object obj);

        C14923b() {
        }
    }

    /* renamed from: rx.exceptions.CompositeException$c */
    static final class C14924c extends C14923b {

        /* renamed from: a */
        private final PrintStream f44244a;

        C14924c(PrintStream printStream) {
            this.f44244a = printStream;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Object mo46131a() {
            return this.f44244a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo46132a(Object o) {
            this.f44244a.println(o);
        }
    }

    /* renamed from: rx.exceptions.CompositeException$d */
    static final class C14925d extends C14923b {

        /* renamed from: a */
        private final PrintWriter f44245a;

        C14925d(PrintWriter printWriter) {
            this.f44245a = printWriter;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Object mo46131a() {
            return this.f44245a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo46132a(Object o) {
            this.f44245a.println(o);
        }
    }

    @Deprecated
    public CompositeException(String messagePrefix, Collection<? extends Throwable> errors) {
        Set<Throwable> deDupedExceptions = new LinkedHashSet<>();
        List<Throwable> localExceptions = new ArrayList<>();
        if (errors != null) {
            for (Throwable ex : errors) {
                if (ex instanceof CompositeException) {
                    deDupedExceptions.addAll(((CompositeException) ex).mo46124a());
                } else if (ex != null) {
                    deDupedExceptions.add(ex);
                } else {
                    deDupedExceptions.add(new NullPointerException());
                }
            }
        } else {
            deDupedExceptions.add(new NullPointerException());
        }
        localExceptions.addAll(deDupedExceptions);
        this.f44241a = Collections.unmodifiableList(localExceptions);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f44241a.size());
        sb.append(" exceptions occurred. ");
        this.f44242b = sb.toString();
    }

    public CompositeException(Collection<? extends Throwable> errors) {
        this(null, errors);
    }

    public CompositeException(Throwable... errors) {
        Throwable[] arr$;
        Set<Throwable> deDupedExceptions = new LinkedHashSet<>();
        List<Throwable> localExceptions = new ArrayList<>();
        if (errors != null) {
            for (Throwable ex : errors) {
                if (ex instanceof CompositeException) {
                    deDupedExceptions.addAll(((CompositeException) ex).mo46124a());
                } else if (ex != null) {
                    deDupedExceptions.add(ex);
                } else {
                    deDupedExceptions.add(new NullPointerException());
                }
            }
        } else {
            deDupedExceptions.add(new NullPointerException());
        }
        localExceptions.addAll(deDupedExceptions);
        this.f44241a = Collections.unmodifiableList(localExceptions);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f44241a.size());
        sb.append(" exceptions occurred. ");
        this.f44242b = sb.toString();
    }

    /* renamed from: a */
    public List<Throwable> mo46124a() {
        return this.f44241a;
    }

    public String getMessage() {
        return this.f44242b;
    }

    public synchronized Throwable getCause() {
        if (this.f44243c == null) {
            C14922a localCause = new C14922a();
            Set<Throwable> seenCauses = new HashSet<>();
            Throwable chain = localCause;
            for (Throwable e : this.f44241a) {
                if (!seenCauses.contains(e)) {
                    seenCauses.add(e);
                    for (Throwable child : m46655a(e)) {
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
                    chain = m46658b(chain);
                }
            }
            this.f44243c = localCause;
        }
        return this.f44243c;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream s) {
        m46657a((C14923b) new C14924c(s));
    }

    public void printStackTrace(PrintWriter s) {
        m46657a((C14923b) new C14925d(s));
    }

    /* renamed from: a */
    private void m46657a(C14923b s) {
        StackTraceElement[] arr$;
        StringBuilder b = new StringBuilder(128);
        b.append(this);
        b.append(10);
        for (StackTraceElement myStackElement : getStackTrace()) {
            b.append("\tat ");
            b.append(myStackElement);
            b.append(10);
        }
        int i = 1;
        for (Throwable ex : this.f44241a) {
            b.append("  ComposedException ");
            b.append(i);
            b.append(" :\n");
            m46656a(b, ex, "\t");
            i++;
        }
        synchronized (s.mo46131a()) {
            s.mo46132a(b.toString());
        }
    }

    /* renamed from: a */
    private void m46656a(StringBuilder b, Throwable ex, String prefix) {
        StackTraceElement[] arr$;
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
            m46656a(b, ex.getCause(), "");
        }
    }

    /* renamed from: a */
    private List<Throwable> m46655a(Throwable ex) {
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
            root = root.getCause();
        }
        return list;
    }

    /* renamed from: b */
    private Throwable m46658b(Throwable e) {
        Throwable root = e.getCause();
        if (root == null || root == e) {
            return e;
        }
        while (true) {
            Throwable cause = root.getCause();
            if (cause == null || cause == root) {
                return root;
            }
            root = root.getCause();
        }
        return root;
    }
}
