package p005cm.aptoide.p006pt.util;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.BaseException;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0120S.C0123b;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p400f.C14949t;
import rx.Observable.Operator;
import rx.Subscriber;

/* renamed from: cm.aptoide.pt.util.RxJavaStackTracer */
public class RxJavaStackTracer extends C14949t {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.util.RxJavaStackTracer$OperatorTraceOnError */
    static class OperatorTraceOnError<T> implements C0123b<T, T> {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final StackTraceElement[] trace = new Throwable().getStackTrace();

        /* renamed from: cm.aptoide.pt.util.RxJavaStackTracer$OperatorTraceOnError$TracedException */
        private static class TracedException extends RuntimeException {
            private static transient /* synthetic */ boolean[] $jacocoData;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(9090859578675282924L, "cm/aptoide/pt/util/RxJavaStackTracer$OperatorTraceOnError$TracedException", 2);
                $jacocoData = probes;
                return probes;
            }

            public TracedException(Throwable throwable, StackTraceElement[] trace) {
                boolean[] $jacocoInit = $jacocoInit();
                super(throwable);
                $jacocoInit[0] = true;
                setStackTrace(trace);
                $jacocoInit[1] = true;
            }
        }

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-4006062204942679198L, "cm/aptoide/pt/util/RxJavaStackTracer$OperatorTraceOnError", 7);
            $jacocoData = probes;
            return probes;
        }

        OperatorTraceOnError() {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
            $jacocoInit[1] = true;
        }

        static /* synthetic */ StackTraceElement[] access$000(OperatorTraceOnError x0) {
            boolean[] $jacocoInit = $jacocoInit();
            StackTraceElement[] stackTraceElementArr = x0.trace;
            $jacocoInit[6] = true;
            return stackTraceElementArr;
        }

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            boolean[] $jacocoInit = $jacocoInit();
            C14980ia call = call((C14980ia) obj);
            $jacocoInit[5] = true;
            return call;
        }

        public static <T> OperatorTraceOnError<T> traceOnError() {
            boolean[] $jacocoInit = $jacocoInit();
            OperatorTraceOnError<T> operatorTraceOnError = new OperatorTraceOnError<>();
            $jacocoInit[2] = true;
            return operatorTraceOnError;
        }

        public C14980ia<? super T> call(final C14980ia<? super T> child) {
            boolean[] $jacocoInit = $jacocoInit();
            Subscriber<T> parent = new C14980ia<T>(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ OperatorTraceOnError this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(8332600353526753389L, "cm/aptoide/pt/util/RxJavaStackTracer$OperatorTraceOnError$1", 7);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }

                public void onCompleted() {
                    boolean[] $jacocoInit = $jacocoInit();
                    child.onCompleted();
                    $jacocoInit[1] = true;
                }

                public void onError(Throwable throwable) {
                    boolean[] $jacocoInit = $jacocoInit();
                    if (BaseException.class.isAssignableFrom(throwable.getClass())) {
                        $jacocoInit[2] = true;
                        child.onError(throwable);
                        $jacocoInit[3] = true;
                    } else {
                        child.onError(new TracedException(throwable, OperatorTraceOnError.access$000(this.this$0)));
                        $jacocoInit[4] = true;
                    }
                    $jacocoInit[5] = true;
                }

                public void onNext(T t) {
                    boolean[] $jacocoInit = $jacocoInit();
                    child.onNext(t);
                    $jacocoInit[6] = true;
                }
            };
            $jacocoInit[3] = true;
            child.add(parent);
            $jacocoInit[4] = true;
            return parent;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3903988333532152508L, "cm/aptoide/pt/util/RxJavaStackTracer", 2);
        $jacocoData = probes;
        return probes;
    }

    public RxJavaStackTracer() {
        $jacocoInit()[0] = true;
    }

    public <T> C0122a<T> onSubscribeStart(C0120S<? extends T> s, final C0122a<T> onSubscribe) {
        boolean[] $jacocoInit = $jacocoInit();
        C51591 r1 = new C0122a<T>(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ RxJavaStackTracer this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-6702454466125790004L, "cm/aptoide/pt/util/RxJavaStackTracer$1", 15);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public /* bridge */ /* synthetic */ void call(Object obj) {
                boolean[] $jacocoInit = $jacocoInit();
                call((C14980ia) obj);
                $jacocoInit[14] = true;
            }

            public void call(C14980ia<? super T> o) {
                Subscriber<? super T> st;
                boolean[] $jacocoInit = $jacocoInit();
                try {
                    Operator<T, T> operator = OperatorTraceOnError.traceOnError();
                    $jacocoInit[1] = true;
                    C0123b onLift = this.this$0.onLift(operator);
                    $jacocoInit[2] = true;
                    st = (C14980ia) onLift.call(o);
                    try {
                        $jacocoInit[3] = true;
                        st.onStart();
                        $jacocoInit[4] = true;
                        onSubscribe.call(st);
                        $jacocoInit[5] = true;
                    } catch (Throwable th) {
                        e = th;
                        $jacocoInit[6] = true;
                        C14927a.m46678c(e);
                        $jacocoInit[7] = true;
                        st.onError(e);
                        $jacocoInit[8] = true;
                        $jacocoInit[9] = true;
                        $jacocoInit[13] = true;
                    }
                } catch (Throwable e) {
                    $jacocoInit[10] = true;
                    C14927a.m46678c(e);
                    $jacocoInit[11] = true;
                    o.onError(e);
                    $jacocoInit[12] = true;
                }
                $jacocoInit[9] = true;
                $jacocoInit[13] = true;
            }
        };
        $jacocoInit[1] = true;
        return r1;
    }
}
