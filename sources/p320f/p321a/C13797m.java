package p320f.p321a;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.observers.TestObserver;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13200b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p326c.C13202d;
import p320f.p321a.p326c.C13203e;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p326c.C13205g;
import p320f.p321a.p326c.C13206h;
import p320f.p321a.p326c.C13207i;
import p320f.p321a.p326c.C13208j;
import p320f.p321a.p326c.C13209k;
import p320f.p321a.p326c.C13210l;
import p320f.p321a.p326c.C13211m;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p329b.C13226a;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13272g;
import p320f.p321a.p327d.p331d.C13279e;
import p320f.p321a.p327d.p331d.C13280f;
import p320f.p321a.p327d.p331d.C13285k;
import p320f.p321a.p327d.p331d.C13287m;
import p320f.p321a.p327d.p331d.C13290p;
import p320f.p321a.p327d.p332e.p333a.C13296b;
import p320f.p321a.p327d.p332e.p333a.C13302e;
import p320f.p321a.p327d.p332e.p334b.C13308Aa;
import p320f.p321a.p327d.p332e.p334b.C13311Ab;
import p320f.p321a.p327d.p332e.p334b.C13313B;
import p320f.p321a.p327d.p332e.p334b.C13315Ba;
import p320f.p321a.p327d.p332e.p334b.C13318Bb;
import p320f.p321a.p327d.p332e.p334b.C13321C;
import p320f.p321a.p327d.p332e.p334b.C13323Ca;
import p320f.p321a.p327d.p332e.p334b.C13326Cb;
import p320f.p321a.p327d.p332e.p334b.C13328D;
import p320f.p321a.p327d.p332e.p334b.C13331Da;
import p320f.p321a.p327d.p332e.p334b.C13332Db;
import p320f.p321a.p327d.p332e.p334b.C13335E;
import p320f.p321a.p327d.p332e.p334b.C13338Ea;
import p320f.p321a.p327d.p332e.p334b.C13340Eb;
import p320f.p321a.p327d.p332e.p334b.C13343F;
import p320f.p321a.p327d.p332e.p334b.C13344Fa;
import p320f.p321a.p327d.p332e.p334b.C13346Fb;
import p320f.p321a.p327d.p332e.p334b.C13351G;
import p320f.p321a.p327d.p332e.p334b.C13356Ga;
import p320f.p321a.p327d.p332e.p334b.C13358Gb;
import p320f.p321a.p327d.p332e.p334b.C13361H;
import p320f.p321a.p327d.p332e.p334b.C13364Ha;
import p320f.p321a.p327d.p332e.p334b.C13368Hb;
import p320f.p321a.p327d.p332e.p334b.C13375I;
import p320f.p321a.p327d.p332e.p334b.C13377Ia;
import p320f.p321a.p327d.p332e.p334b.C13380Ib;
import p320f.p321a.p327d.p332e.p334b.C13383J;
import p320f.p321a.p327d.p332e.p334b.C13385Ja;
import p320f.p321a.p327d.p332e.p334b.C13387Jb;
import p320f.p321a.p327d.p332e.p334b.C13391K;
import p320f.p321a.p327d.p332e.p334b.C13393Ka;
import p320f.p321a.p327d.p332e.p334b.C13395Kb;
import p320f.p321a.p327d.p332e.p334b.C13398L;
import p320f.p321a.p327d.p332e.p334b.C13400La;
import p320f.p321a.p327d.p332e.p334b.C13402Lb;
import p320f.p321a.p327d.p332e.p334b.C13404M;
import p320f.p321a.p327d.p332e.p334b.C13406Ma;
import p320f.p321a.p327d.p332e.p334b.C13409N;
import p320f.p321a.p327d.p332e.p334b.C13411Na;
import p320f.p321a.p327d.p332e.p334b.C13412O;
import p320f.p321a.p327d.p332e.p334b.C13418P;
import p320f.p321a.p327d.p332e.p334b.C13419Pa;
import p320f.p321a.p327d.p332e.p334b.C13423Qa;
import p320f.p321a.p327d.p332e.p334b.C13425Ra;
import p320f.p321a.p327d.p332e.p334b.C13428S;
import p320f.p321a.p327d.p332e.p334b.C13430Sa;
import p320f.p321a.p327d.p332e.p334b.C13447T;
import p320f.p321a.p327d.p332e.p334b.C13449Ta;
import p320f.p321a.p327d.p332e.p334b.C13451U;
import p320f.p321a.p327d.p332e.p334b.C13452Ua;
import p320f.p321a.p327d.p332e.p334b.C13454V;
import p320f.p321a.p327d.p332e.p334b.C13455Va;
import p320f.p321a.p327d.p332e.p334b.C13458W;
import p320f.p321a.p327d.p332e.p334b.C13460Wa;
import p320f.p321a.p327d.p332e.p334b.C13464X;
import p320f.p321a.p327d.p332e.p334b.C13467Xa;
import p320f.p321a.p327d.p332e.p334b.C13475Ya;
import p320f.p321a.p327d.p332e.p334b.C13478Z;
import p320f.p321a.p327d.p332e.p334b.C13481Za;
import p320f.p321a.p327d.p332e.p334b.C13483_a;
import p320f.p321a.p327d.p332e.p334b.C13486aa;
import p320f.p321a.p327d.p332e.p334b.C13492b;
import p320f.p321a.p327d.p332e.p334b.C13494ba;
import p320f.p321a.p327d.p332e.p334b.C13497bb;
import p320f.p321a.p327d.p332e.p334b.C13500c;
import p320f.p321a.p327d.p332e.p334b.C13502ca;
import p320f.p321a.p327d.p332e.p334b.C13504cb;
import p320f.p321a.p327d.p332e.p334b.C13505d;
import p320f.p321a.p327d.p332e.p334b.C13508da;
import p320f.p321a.p327d.p332e.p334b.C13510db;
import p320f.p321a.p327d.p332e.p334b.C13512e;
import p320f.p321a.p327d.p332e.p334b.C13515ea;
import p320f.p321a.p327d.p332e.p334b.C13516eb;
import p320f.p321a.p327d.p332e.p334b.C13520fa;
import p320f.p321a.p327d.p332e.p334b.C13521fb;
import p320f.p321a.p327d.p332e.p334b.C13523g;
import p320f.p321a.p327d.p332e.p334b.C13525ga;
import p320f.p321a.p327d.p332e.p334b.C13527gb;
import p320f.p321a.p327d.p332e.p334b.C13529h;
import p320f.p321a.p327d.p332e.p334b.C13532ha;
import p320f.p321a.p327d.p332e.p334b.C13534hb;
import p320f.p321a.p327d.p332e.p334b.C13538ia;
import p320f.p321a.p327d.p332e.p334b.C13539ib;
import p320f.p321a.p327d.p332e.p334b.C13542j;
import p320f.p321a.p327d.p332e.p334b.C13544ja;
import p320f.p321a.p327d.p332e.p334b.C13546jb;
import p320f.p321a.p327d.p332e.p334b.C13548k;
import p320f.p321a.p327d.p332e.p334b.C13549ka;
import p320f.p321a.p327d.p332e.p334b.C13553kb;
import p320f.p321a.p327d.p332e.p334b.C13556l;
import p320f.p321a.p327d.p332e.p334b.C13559la;
import p320f.p321a.p327d.p332e.p334b.C13564lb;
import p320f.p321a.p327d.p332e.p334b.C13566m;
import p320f.p321a.p327d.p332e.p334b.C13570ma;
import p320f.p321a.p327d.p332e.p334b.C13572mb;
import p320f.p321a.p327d.p332e.p334b.C13575n;
import p320f.p321a.p327d.p332e.p334b.C13578na;
import p320f.p321a.p327d.p332e.p334b.C13580nb;
import p320f.p321a.p327d.p332e.p334b.C13582o;
import p320f.p321a.p327d.p332e.p334b.C13585oa;
import p320f.p321a.p327d.p332e.p334b.C13587ob;
import p320f.p321a.p327d.p332e.p334b.C13589p;
import p320f.p321a.p327d.p332e.p334b.C13595pa;
import p320f.p321a.p327d.p332e.p334b.C13612pb;
import p320f.p321a.p327d.p332e.p334b.C13614q;
import p320f.p321a.p327d.p332e.p334b.C13617qa;
import p320f.p321a.p327d.p332e.p334b.C13619qb;
import p320f.p321a.p327d.p332e.p334b.C13623ra;
import p320f.p321a.p327d.p332e.p334b.C13625rb;
import p320f.p321a.p327d.p332e.p334b.C13628s;
import p320f.p321a.p327d.p332e.p334b.C13630sa;
import p320f.p321a.p327d.p332e.p334b.C13632sb;
import p320f.p321a.p327d.p332e.p334b.C13634t;
import p320f.p321a.p327d.p332e.p334b.C13637ta;
import p320f.p321a.p327d.p332e.p334b.C13638tb;
import p320f.p321a.p327d.p332e.p334b.C13640u;
import p320f.p321a.p327d.p332e.p334b.C13645ua;
import p320f.p321a.p327d.p332e.p334b.C13647ub;
import p320f.p321a.p327d.p332e.p334b.C13649v;
import p320f.p321a.p327d.p332e.p334b.C13652va;
import p320f.p321a.p327d.p332e.p334b.C13654vb;
import p320f.p321a.p327d.p332e.p334b.C13656w;
import p320f.p321a.p327d.p332e.p334b.C13658wa;
import p320f.p321a.p327d.p332e.p334b.C13659wb;
import p320f.p321a.p327d.p332e.p334b.C13664x;
import p320f.p321a.p327d.p332e.p334b.C13666xa;
import p320f.p321a.p327d.p332e.p334b.C13668xb;
import p320f.p321a.p327d.p332e.p334b.C13674y;
import p320f.p321a.p327d.p332e.p334b.C13676ya;
import p320f.p321a.p327d.p332e.p334b.C13678yb;
import p320f.p321a.p327d.p332e.p334b.C13680z;
import p320f.p321a.p327d.p332e.p334b.C13682za;
import p320f.p321a.p327d.p332e.p334b.C13684zb;
import p320f.p321a.p327d.p340j.C13740b;
import p320f.p321a.p327d.p340j.C13747i;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p327d.p340j.C13751l;
import p320f.p321a.p341e.C13762a;
import p320f.p321a.p341e.C13763b;
import p320f.p321a.p342f.C13769e;
import p320f.p321a.p342f.C13771g;
import p320f.p321a.p343g.C13774a;
import p320f.p321a.p344h.C13777b;
import p320f.p321a.p344h.C13786c;
import p363i.p368b.C14228a;

/* renamed from: f.a.m */
/* compiled from: Observable */
public abstract class C13797m<T> implements C13802r<T> {
    /* access modifiers changed from: protected */
    public abstract void subscribeActual(C13804t<? super T> tVar);

    public static <T> C13797m<T> amb(Iterable<? extends C13802r<? extends T>> sources) {
        C13264b.m43226a(sources, "sources is null");
        return C13774a.m43821a((C13797m<T>) new C13529h<T>(null, sources));
    }

    public static <T> C13797m<T> ambArray(C13802r<? extends T>... sources) {
        C13264b.m43226a(sources, "sources is null");
        int len = sources.length;
        if (len == 0) {
            return empty();
        }
        if (len == 1) {
            return wrap(sources[0]);
        }
        return C13774a.m43821a((C13797m<T>) new C13529h<T>(sources, null));
    }

    public static int bufferSize() {
        return C13764f.m43802a();
    }

    public static <T, R> C13797m<R> combineLatest(C13212n<? super Object[], ? extends R> combiner, int bufferSize, C13802r<? extends T>... sources) {
        return combineLatest(sources, combiner, bufferSize);
    }

    public static <T, R> C13797m<R> combineLatest(Iterable<? extends C13802r<? extends T>> sources, C13212n<? super Object[], ? extends R> combiner) {
        return combineLatest(sources, combiner, bufferSize());
    }

    public static <T, R> C13797m<R> combineLatest(Iterable<? extends C13802r<? extends T>> sources, C13212n<? super Object[], ? extends R> combiner, int bufferSize) {
        C13264b.m43226a(sources, "sources is null");
        C13264b.m43226a(combiner, "combiner is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        C13634t tVar = new C13634t(null, sources, combiner, bufferSize << 1, false);
        return C13774a.m43821a((C13797m<T>) tVar);
    }

    public static <T, R> C13797m<R> combineLatest(C13802r<? extends T>[] sources, C13212n<? super Object[], ? extends R> combiner) {
        return combineLatest(sources, combiner, bufferSize());
    }

    public static <T, R> C13797m<R> combineLatest(C13802r<? extends T>[] sources, C13212n<? super Object[], ? extends R> combiner, int bufferSize) {
        C13264b.m43226a(sources, "sources is null");
        if (sources.length == 0) {
            return empty();
        }
        C13264b.m43226a(combiner, "combiner is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        C13634t tVar = new C13634t(sources, null, combiner, bufferSize << 1, false);
        return C13774a.m43821a((C13797m<T>) tVar);
    }

    public static <T1, T2, R> C13797m<R> combineLatest(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13201c<? super T1, ? super T2, ? extends R> combiner) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        return combineLatest(C13226a.m43178a(combiner), bufferSize(), (C13802r<? extends T>[]) new C13802r[]{source1, source2});
    }

    public static <T1, T2, T3, R> C13797m<R> combineLatest(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13205g<? super T1, ? super T2, ? super T3, ? extends R> combiner) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        return combineLatest(C13226a.m43179a(combiner), bufferSize(), (C13802r<? extends T>[]) new C13802r[]{source1, source2, source3});
    }

    public static <T1, T2, T3, T4, R> C13797m<R> combineLatest(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13206h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combiner) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        return combineLatest(C13226a.m43180a(combiner), bufferSize(), (C13802r<? extends T>[]) new C13802r[]{source1, source2, source3, source4});
    }

    public static <T1, T2, T3, T4, T5, R> C13797m<R> combineLatest(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13207i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combiner) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        return combineLatest(C13226a.m43181a(combiner), bufferSize(), (C13802r<? extends T>[]) new C13802r[]{source1, source2, source3, source4, source5});
    }

    public static <T1, T2, T3, T4, T5, T6, R> C13797m<R> combineLatest(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13802r<? extends T6> source6, C13208j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> combiner) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        C13264b.m43226a(source6, "source6 is null");
        return combineLatest(C13226a.m43182a(combiner), bufferSize(), (C13802r<? extends T>[]) new C13802r[]{source1, source2, source3, source4, source5, source6});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> C13797m<R> combineLatest(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13802r<? extends T6> source6, C13802r<? extends T7> source7, C13209k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> combiner) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        C13264b.m43226a(source6, "source6 is null");
        C13264b.m43226a(source7, "source7 is null");
        return combineLatest(C13226a.m43183a(combiner), bufferSize(), (C13802r<? extends T>[]) new C13802r[]{source1, source2, source3, source4, source5, source6, source7});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> C13797m<R> combineLatest(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13802r<? extends T6> source6, C13802r<? extends T7> source7, C13802r<? extends T8> source8, C13210l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> combiner) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        C13264b.m43226a(source6, "source6 is null");
        C13264b.m43226a(source7, "source7 is null");
        C13264b.m43226a(source8, "source8 is null");
        return combineLatest(C13226a.m43184a(combiner), bufferSize(), (C13802r<? extends T>[]) new C13802r[]{source1, source2, source3, source4, source5, source6, source7, source8});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> C13797m<R> combineLatest(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13802r<? extends T6> source6, C13802r<? extends T7> source7, C13802r<? extends T8> source8, C13802r<? extends T9> source9, C13211m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> combiner) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        C13264b.m43226a(source6, "source6 is null");
        C13264b.m43226a(source7, "source7 is null");
        C13264b.m43226a(source8, "source8 is null");
        C13264b.m43226a(source9, "source9 is null");
        return combineLatest(C13226a.m43185a(combiner), bufferSize(), (C13802r<? extends T>[]) new C13802r[]{source1, source2, source3, source4, source5, source6, source7, source8, source9});
    }

    public static <T, R> C13797m<R> combineLatestDelayError(C13802r<? extends T>[] sources, C13212n<? super Object[], ? extends R> combiner) {
        return combineLatestDelayError(sources, combiner, bufferSize());
    }

    public static <T, R> C13797m<R> combineLatestDelayError(C13212n<? super Object[], ? extends R> combiner, int bufferSize, C13802r<? extends T>... sources) {
        return combineLatestDelayError(sources, combiner, bufferSize);
    }

    public static <T, R> C13797m<R> combineLatestDelayError(C13802r<? extends T>[] sources, C13212n<? super Object[], ? extends R> combiner, int bufferSize) {
        C13264b.m43222a(bufferSize, "bufferSize");
        C13264b.m43226a(combiner, "combiner is null");
        if (sources.length == 0) {
            return empty();
        }
        C13634t tVar = new C13634t(sources, null, combiner, bufferSize << 1, true);
        return C13774a.m43821a((C13797m<T>) tVar);
    }

    public static <T, R> C13797m<R> combineLatestDelayError(Iterable<? extends C13802r<? extends T>> sources, C13212n<? super Object[], ? extends R> combiner) {
        return combineLatestDelayError(sources, combiner, bufferSize());
    }

    public static <T, R> C13797m<R> combineLatestDelayError(Iterable<? extends C13802r<? extends T>> sources, C13212n<? super Object[], ? extends R> combiner, int bufferSize) {
        C13264b.m43226a(sources, "sources is null");
        C13264b.m43226a(combiner, "combiner is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        C13634t tVar = new C13634t(null, sources, combiner, bufferSize << 1, true);
        return C13774a.m43821a((C13797m<T>) tVar);
    }

    public static <T> C13797m<T> concat(Iterable<? extends C13802r<? extends T>> sources) {
        C13264b.m43226a(sources, "sources is null");
        return fromIterable(sources).concatMapDelayError(C13226a.m43201e(), bufferSize(), false);
    }

    public static <T> C13797m<T> concat(C13802r<? extends C13802r<? extends T>> sources) {
        return concat(sources, bufferSize());
    }

    public static <T> C13797m<T> concat(C13802r<? extends C13802r<? extends T>> sources, int prefetch) {
        C13264b.m43226a(sources, "sources is null");
        C13264b.m43222a(prefetch, "prefetch");
        return C13774a.m43821a((C13797m<T>) new C13640u<T>(sources, C13226a.m43201e(), prefetch, C13747i.IMMEDIATE));
    }

    public static <T> C13797m<T> concat(C13802r<? extends T> source1, C13802r<? extends T> source2) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        return concatArray(source1, source2);
    }

    public static <T> C13797m<T> concat(C13802r<? extends T> source1, C13802r<? extends T> source2, C13802r<? extends T> source3) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        return concatArray(source1, source2, source3);
    }

    public static <T> C13797m<T> concat(C13802r<? extends T> source1, C13802r<? extends T> source2, C13802r<? extends T> source3, C13802r<? extends T> source4) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        return concatArray(source1, source2, source3, source4);
    }

    public static <T> C13797m<T> concatArray(C13802r<? extends T>... sources) {
        if (sources.length == 0) {
            return empty();
        }
        if (sources.length == 1) {
            return wrap(sources[0]);
        }
        return C13774a.m43821a((C13797m<T>) new C13640u<T>(fromArray(sources), C13226a.m43201e(), bufferSize(), C13747i.BOUNDARY));
    }

    public static <T> C13797m<T> concatArrayDelayError(C13802r<? extends T>... sources) {
        if (sources.length == 0) {
            return empty();
        }
        if (sources.length == 1) {
            return wrap(sources[0]);
        }
        return concatDelayError((C13802r<? extends C13802r<? extends T>>) fromArray(sources));
    }

    public static <T> C13797m<T> concatArrayEager(C13802r<? extends T>... sources) {
        return concatArrayEager(bufferSize(), bufferSize(), sources);
    }

    public static <T> C13797m<T> concatArrayEager(int maxConcurrency, int prefetch, C13802r<? extends T>... sources) {
        return fromArray(sources).concatMapEagerDelayError(C13226a.m43201e(), maxConcurrency, prefetch, false);
    }

    public static <T> C13797m<T> concatDelayError(Iterable<? extends C13802r<? extends T>> sources) {
        C13264b.m43226a(sources, "sources is null");
        return concatDelayError((C13802r<? extends C13802r<? extends T>>) fromIterable(sources));
    }

    public static <T> C13797m<T> concatDelayError(C13802r<? extends C13802r<? extends T>> sources) {
        return concatDelayError(sources, bufferSize(), true);
    }

    public static <T> C13797m<T> concatDelayError(C13802r<? extends C13802r<? extends T>> sources, int prefetch, boolean tillTheEnd) {
        C13264b.m43226a(sources, "sources is null");
        C13264b.m43222a(prefetch, "prefetch is null");
        return C13774a.m43821a((C13797m<T>) new C13640u<T>(sources, C13226a.m43201e(), prefetch, tillTheEnd ? C13747i.END : C13747i.BOUNDARY));
    }

    public static <T> C13797m<T> concatEager(C13802r<? extends C13802r<? extends T>> sources) {
        return concatEager(sources, bufferSize(), bufferSize());
    }

    public static <T> C13797m<T> concatEager(C13802r<? extends C13802r<? extends T>> sources, int maxConcurrency, int prefetch) {
        C13264b.m43226a(Integer.valueOf(maxConcurrency), "maxConcurrency is null");
        C13264b.m43226a(Integer.valueOf(prefetch), "prefetch is null");
        return wrap(sources).concatMapEager(C13226a.m43201e(), maxConcurrency, prefetch);
    }

    public static <T> C13797m<T> concatEager(Iterable<? extends C13802r<? extends T>> sources) {
        return concatEager(sources, bufferSize(), bufferSize());
    }

    public static <T> C13797m<T> concatEager(Iterable<? extends C13802r<? extends T>> sources, int maxConcurrency, int prefetch) {
        C13264b.m43226a(Integer.valueOf(maxConcurrency), "maxConcurrency is null");
        C13264b.m43226a(Integer.valueOf(prefetch), "prefetch is null");
        return fromIterable(sources).concatMapEagerDelayError(C13226a.m43201e(), maxConcurrency, prefetch, false);
    }

    public static <T> C13797m<T> create(C13800p<T> source) {
        C13264b.m43226a(source, "source is null");
        return C13774a.m43821a((C13797m<T>) new C13321C<T>(source));
    }

    public static <T> C13797m<T> defer(Callable<? extends C13802r<? extends T>> supplier) {
        C13264b.m43226a(supplier, "supplier is null");
        return C13774a.m43821a((C13797m<T>) new C13343F<T>(supplier));
    }

    public static <T> C13797m<T> empty() {
        return C13774a.m43821a(C13451U.f40899a);
    }

    public static <T> C13797m<T> error(Callable<? extends Throwable> errorSupplier) {
        C13264b.m43226a(errorSupplier, "errorSupplier is null");
        return C13774a.m43821a((C13797m<T>) new C13454V<T>(errorSupplier));
    }

    public static <T> C13797m<T> error(Throwable exception) {
        C13264b.m43226a(exception, "e is null");
        return error(C13226a.m43196b(exception));
    }

    public static <T> C13797m<T> fromArray(T... items) {
        C13264b.m43226a(items, "items is null");
        if (items.length == 0) {
            return empty();
        }
        if (items.length == 1) {
            return just(items[0]);
        }
        return C13774a.m43821a((C13797m<T>) new C13508da<T>(items));
    }

    public static <T> C13797m<T> fromCallable(Callable<? extends T> supplier) {
        C13264b.m43226a(supplier, "supplier is null");
        return C13774a.m43821a((C13797m<T>) new C13515ea<T>(supplier));
    }

    public static <T> C13797m<T> fromFuture(Future<? extends T> future) {
        C13264b.m43226a(future, "future is null");
        return C13774a.m43821a((C13797m<T>) new C13520fa<T>(future, 0, null));
    }

    public static <T> C13797m<T> fromFuture(Future<? extends T> future, long timeout, TimeUnit unit) {
        C13264b.m43226a(future, "future is null");
        C13264b.m43226a(unit, "unit is null");
        return C13774a.m43821a((C13797m<T>) new C13520fa<T>(future, timeout, unit));
    }

    public static <T> C13797m<T> fromFuture(Future<? extends T> future, long timeout, TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(scheduler, "scheduler is null");
        return fromFuture(future, timeout, unit).subscribeOn(scheduler);
    }

    public static <T> C13797m<T> fromFuture(Future<? extends T> future, C13805u scheduler) {
        C13264b.m43226a(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    public static <T> C13797m<T> fromIterable(Iterable<? extends T> source) {
        C13264b.m43226a(source, "source is null");
        return C13774a.m43821a((C13797m<T>) new C13525ga<T>(source));
    }

    public static <T> C13797m<T> fromPublisher(C14228a<? extends T> publisher) {
        C13264b.m43226a(publisher, "publisher is null");
        return C13774a.m43821a((C13797m<T>) new C13532ha<T>(publisher));
    }

    public static <T> C13797m<T> generate(C13204f<C13761e<T>> generator) {
        C13264b.m43226a(generator, "generator  is null");
        return generate(C13226a.m43204h(), C13595pa.m43560a(generator), C13226a.m43200d());
    }

    public static <T, S> C13797m<T> generate(Callable<S> initialState, C13200b<S, C13761e<T>> generator) {
        C13264b.m43226a(generator, "generator  is null");
        return generate(initialState, C13595pa.m43559a(generator), C13226a.m43200d());
    }

    public static <T, S> C13797m<T> generate(Callable<S> initialState, C13200b<S, C13761e<T>> generator, C13204f<? super S> disposeState) {
        C13264b.m43226a(generator, "generator  is null");
        return generate(initialState, C13595pa.m43559a(generator), disposeState);
    }

    public static <T, S> C13797m<T> generate(Callable<S> initialState, C13201c<S, C13761e<T>, S> generator) {
        return generate(initialState, generator, C13226a.m43200d());
    }

    public static <T, S> C13797m<T> generate(Callable<S> initialState, C13201c<S, C13761e<T>, S> generator, C13204f<? super S> disposeState) {
        C13264b.m43226a(initialState, "initialState is null");
        C13264b.m43226a(generator, "generator  is null");
        C13264b.m43226a(disposeState, "disposeState is null");
        return C13774a.m43821a((C13797m<T>) new C13544ja<T>(initialState, generator, disposeState));
    }

    public static C13797m<Long> interval(long initialDelay, long period, TimeUnit unit) {
        return interval(initialDelay, period, unit, C13777b.m43846a());
    }

    public static C13797m<Long> interval(long initialDelay, long period, TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13617qa qaVar = new C13617qa(Math.max(0, initialDelay), Math.max(0, period), unit, scheduler);
        return C13774a.m43821a((C13797m<T>) qaVar);
    }

    public static C13797m<Long> interval(long period, TimeUnit unit) {
        return interval(period, period, unit, C13777b.m43846a());
    }

    public static C13797m<Long> interval(long period, TimeUnit unit, C13805u scheduler) {
        return interval(period, period, unit, scheduler);
    }

    public static C13797m<Long> intervalRange(long start, long count, long initialDelay, long period, TimeUnit unit) {
        return intervalRange(start, count, initialDelay, period, unit, C13777b.m43846a());
    }

    public static C13797m<Long> intervalRange(long start, long count, long initialDelay, long period, TimeUnit unit, C13805u scheduler) {
        long j = count;
        long j2 = initialDelay;
        TimeUnit timeUnit = unit;
        C13805u uVar = scheduler;
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (j == 0) {
            return empty().delay(j2, timeUnit, uVar);
        } else {
            long end = start + (j - 1);
            if (start <= 0 || end >= 0) {
                C13264b.m43226a(timeUnit, "unit is null");
                C13264b.m43226a(uVar, "scheduler is null");
                C13623ra raVar = new C13623ra(start, end, Math.max(0, j2), Math.max(0, period), unit, scheduler);
                return C13774a.m43821a((C13797m<T>) raVar);
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> C13797m<T> just(T item) {
        C13264b.m43226a(item, "The item is null");
        return C13774a.m43821a((C13797m<T>) new C13637ta<T>(item));
    }

    public static <T> C13797m<T> just(T item1, T item2) {
        C13264b.m43226a(item1, "The first item is null");
        C13264b.m43226a(item2, "The second item is null");
        return fromArray(item1, item2);
    }

    public static <T> C13797m<T> just(T item1, T item2, T item3) {
        C13264b.m43226a(item1, "The first item is null");
        C13264b.m43226a(item2, "The second item is null");
        C13264b.m43226a(item3, "The third item is null");
        return fromArray(item1, item2, item3);
    }

    public static <T> C13797m<T> just(T item1, T item2, T item3, T item4) {
        C13264b.m43226a(item1, "The first item is null");
        C13264b.m43226a(item2, "The second item is null");
        C13264b.m43226a(item3, "The third item is null");
        C13264b.m43226a(item4, "The fourth item is null");
        return fromArray(item1, item2, item3, item4);
    }

    public static <T> C13797m<T> just(T item1, T item2, T item3, T item4, T item5) {
        C13264b.m43226a(item1, "The first item is null");
        C13264b.m43226a(item2, "The second item is null");
        C13264b.m43226a(item3, "The third item is null");
        C13264b.m43226a(item4, "The fourth item is null");
        C13264b.m43226a(item5, "The fifth item is null");
        return fromArray(item1, item2, item3, item4, item5);
    }

    public static <T> C13797m<T> just(T item1, T item2, T item3, T item4, T item5, T item6) {
        C13264b.m43226a(item1, "The first item is null");
        C13264b.m43226a(item2, "The second item is null");
        C13264b.m43226a(item3, "The third item is null");
        C13264b.m43226a(item4, "The fourth item is null");
        C13264b.m43226a(item5, "The fifth item is null");
        C13264b.m43226a(item6, "The sixth item is null");
        return fromArray(item1, item2, item3, item4, item5, item6);
    }

    public static <T> C13797m<T> just(T item1, T item2, T item3, T item4, T item5, T item6, T item7) {
        C13264b.m43226a(item1, "The first item is null");
        C13264b.m43226a(item2, "The second item is null");
        C13264b.m43226a(item3, "The third item is null");
        C13264b.m43226a(item4, "The fourth item is null");
        C13264b.m43226a(item5, "The fifth item is null");
        C13264b.m43226a(item6, "The sixth item is null");
        C13264b.m43226a(item7, "The seventh item is null");
        return fromArray(item1, item2, item3, item4, item5, item6, item7);
    }

    public static <T> C13797m<T> just(T item1, T item2, T item3, T item4, T item5, T item6, T item7, T item8) {
        C13264b.m43226a(item1, "The first item is null");
        C13264b.m43226a(item2, "The second item is null");
        C13264b.m43226a(item3, "The third item is null");
        C13264b.m43226a(item4, "The fourth item is null");
        C13264b.m43226a(item5, "The fifth item is null");
        C13264b.m43226a(item6, "The sixth item is null");
        C13264b.m43226a(item7, "The seventh item is null");
        C13264b.m43226a(item8, "The eighth item is null");
        return fromArray(item1, item2, item3, item4, item5, item6, item7, item8);
    }

    public static <T> C13797m<T> just(T item1, T item2, T item3, T item4, T item5, T item6, T item7, T item8, T item9) {
        C13264b.m43226a(item1, "The first item is null");
        C13264b.m43226a(item2, "The second item is null");
        C13264b.m43226a(item3, "The third item is null");
        C13264b.m43226a(item4, "The fourth item is null");
        C13264b.m43226a(item5, "The fifth item is null");
        C13264b.m43226a(item6, "The sixth item is null");
        C13264b.m43226a(item7, "The seventh item is null");
        C13264b.m43226a(item8, "The eighth item is null");
        C13264b.m43226a(item9, "The ninth item is null");
        return fromArray(item1, item2, item3, item4, item5, item6, item7, item8, item9);
    }

    public static <T> C13797m<T> just(T item1, T item2, T item3, T item4, T item5, T item6, T item7, T item8, T item9, T item10) {
        C13264b.m43226a(item1, "The first item is null");
        C13264b.m43226a(item2, "The second item is null");
        C13264b.m43226a(item3, "The third item is null");
        C13264b.m43226a(item4, "The fourth item is null");
        C13264b.m43226a(item5, "The fifth item is null");
        C13264b.m43226a(item6, "The sixth item is null");
        C13264b.m43226a(item7, "The seventh item is null");
        C13264b.m43226a(item8, "The eighth item is null");
        C13264b.m43226a(item9, "The ninth item is null");
        C13264b.m43226a(item10, "The tenth item is null");
        return fromArray(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10);
    }

    public static <T> C13797m<T> merge(Iterable<? extends C13802r<? extends T>> sources, int maxConcurrency, int bufferSize) {
        return fromIterable(sources).flatMap(C13226a.m43201e(), false, maxConcurrency, bufferSize);
    }

    public static <T> C13797m<T> mergeArray(int maxConcurrency, int bufferSize, C13802r<? extends T>... sources) {
        return fromArray(sources).flatMap(C13226a.m43201e(), false, maxConcurrency, bufferSize);
    }

    public static <T> C13797m<T> merge(Iterable<? extends C13802r<? extends T>> sources) {
        return fromIterable(sources).flatMap(C13226a.m43201e());
    }

    public static <T> C13797m<T> merge(Iterable<? extends C13802r<? extends T>> sources, int maxConcurrency) {
        return fromIterable(sources).flatMap(C13226a.m43201e(), maxConcurrency);
    }

    public static <T> C13797m<T> merge(C13802r<? extends C13802r<? extends T>> sources) {
        C13264b.m43226a(sources, "sources is null");
        C13464X x = new C13464X(sources, C13226a.m43201e(), false, MoPubClientPositioning.NO_REPEAT, bufferSize());
        return C13774a.m43821a((C13797m<T>) x);
    }

    public static <T> C13797m<T> merge(C13802r<? extends C13802r<? extends T>> sources, int maxConcurrency) {
        C13264b.m43226a(sources, "sources is null");
        C13264b.m43222a(maxConcurrency, "maxConcurrency");
        C13464X x = new C13464X(sources, C13226a.m43201e(), false, maxConcurrency, bufferSize());
        return C13774a.m43821a((C13797m<T>) x);
    }

    public static <T> C13797m<T> merge(C13802r<? extends T> source1, C13802r<? extends T> source2) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        return fromArray(source1, source2).flatMap(C13226a.m43201e(), false, 2);
    }

    public static <T> C13797m<T> merge(C13802r<? extends T> source1, C13802r<? extends T> source2, C13802r<? extends T> source3) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        return fromArray(source1, source2, source3).flatMap(C13226a.m43201e(), false, 3);
    }

    public static <T> C13797m<T> merge(C13802r<? extends T> source1, C13802r<? extends T> source2, C13802r<? extends T> source3, C13802r<? extends T> source4) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        return fromArray(source1, source2, source3, source4).flatMap(C13226a.m43201e(), false, 4);
    }

    public static <T> C13797m<T> mergeArray(C13802r<? extends T>... sources) {
        return fromArray(sources).flatMap(C13226a.m43201e(), sources.length);
    }

    public static <T> C13797m<T> mergeDelayError(Iterable<? extends C13802r<? extends T>> sources) {
        return fromIterable(sources).flatMap(C13226a.m43201e(), true);
    }

    public static <T> C13797m<T> mergeDelayError(Iterable<? extends C13802r<? extends T>> sources, int maxConcurrency, int bufferSize) {
        return fromIterable(sources).flatMap(C13226a.m43201e(), true, maxConcurrency, bufferSize);
    }

    public static <T> C13797m<T> mergeArrayDelayError(int maxConcurrency, int bufferSize, C13802r<? extends T>... sources) {
        return fromArray(sources).flatMap(C13226a.m43201e(), true, maxConcurrency, bufferSize);
    }

    public static <T> C13797m<T> mergeDelayError(Iterable<? extends C13802r<? extends T>> sources, int maxConcurrency) {
        return fromIterable(sources).flatMap(C13226a.m43201e(), true, maxConcurrency);
    }

    public static <T> C13797m<T> mergeDelayError(C13802r<? extends C13802r<? extends T>> sources) {
        C13264b.m43226a(sources, "sources is null");
        C13464X x = new C13464X(sources, C13226a.m43201e(), true, MoPubClientPositioning.NO_REPEAT, bufferSize());
        return C13774a.m43821a((C13797m<T>) x);
    }

    public static <T> C13797m<T> mergeDelayError(C13802r<? extends C13802r<? extends T>> sources, int maxConcurrency) {
        C13264b.m43226a(sources, "sources is null");
        C13264b.m43222a(maxConcurrency, "maxConcurrency");
        C13464X x = new C13464X(sources, C13226a.m43201e(), true, maxConcurrency, bufferSize());
        return C13774a.m43821a((C13797m<T>) x);
    }

    public static <T> C13797m<T> mergeDelayError(C13802r<? extends T> source1, C13802r<? extends T> source2) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        return fromArray(source1, source2).flatMap(C13226a.m43201e(), true, 2);
    }

    public static <T> C13797m<T> mergeDelayError(C13802r<? extends T> source1, C13802r<? extends T> source2, C13802r<? extends T> source3) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        return fromArray(source1, source2, source3).flatMap(C13226a.m43201e(), true, 3);
    }

    public static <T> C13797m<T> mergeDelayError(C13802r<? extends T> source1, C13802r<? extends T> source2, C13802r<? extends T> source3, C13802r<? extends T> source4) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        return fromArray(source1, source2, source3, source4).flatMap(C13226a.m43201e(), true, 4);
    }

    public static <T> C13797m<T> mergeArrayDelayError(C13802r<? extends T>... sources) {
        return fromArray(sources).flatMap(C13226a.m43201e(), true, sources.length);
    }

    public static <T> C13797m<T> never() {
        return C13774a.m43821a(C13331Da.f40502a);
    }

    public static C13797m<Integer> range(int start, int count) {
        if (count < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(count);
            throw new IllegalArgumentException(sb.toString());
        } else if (count == 0) {
            return empty();
        } else {
            if (count == 1) {
                return just(Integer.valueOf(start));
            }
            if (((long) start) + ((long) (count - 1)) <= 2147483647L) {
                return C13774a.m43821a((C13797m<T>) new C13385Ja<T>(start, count));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    public static C13797m<Long> rangeLong(long start, long count) {
        if (count < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(count);
            throw new IllegalArgumentException(sb.toString());
        } else if (count == 0) {
            return empty();
        } else {
            if (count == 1) {
                return just(Long.valueOf(start));
            }
            long end = (count - 1) + start;
            if (start <= 0 || end >= 0) {
                return C13774a.m43821a((C13797m<T>) new C13393Ka<T>(start, count));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> C13810v<Boolean> sequenceEqual(C13802r<? extends T> source1, C13802r<? extends T> source2) {
        return sequenceEqual(source1, source2, C13264b.m43225a(), bufferSize());
    }

    public static <T> C13810v<Boolean> sequenceEqual(C13802r<? extends T> source1, C13802r<? extends T> source2, C13202d<? super T, ? super T> isEqual) {
        return sequenceEqual(source1, source2, isEqual, bufferSize());
    }

    public static <T> C13810v<Boolean> sequenceEqual(C13802r<? extends T> source1, C13802r<? extends T> source2, C13202d<? super T, ? super T> isEqual, int bufferSize) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(isEqual, "isEqual is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13774a.m43826a((C13810v<T>) new C13497bb<T>(source1, source2, isEqual, bufferSize));
    }

    public static <T> C13810v<Boolean> sequenceEqual(C13802r<? extends T> source1, C13802r<? extends T> source2, int bufferSize) {
        return sequenceEqual(source1, source2, C13264b.m43225a(), bufferSize);
    }

    public static <T> C13797m<T> switchOnNext(C13802r<? extends C13802r<? extends T>> sources, int bufferSize) {
        C13264b.m43226a(sources, "sources is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13774a.m43821a((C13797m<T>) new C13572mb<T>(sources, C13226a.m43201e(), bufferSize, false));
    }

    public static <T> C13797m<T> switchOnNext(C13802r<? extends C13802r<? extends T>> sources) {
        return switchOnNext(sources, bufferSize());
    }

    public static <T> C13797m<T> switchOnNextDelayError(C13802r<? extends C13802r<? extends T>> sources) {
        return switchOnNextDelayError(sources, bufferSize());
    }

    public static <T> C13797m<T> switchOnNextDelayError(C13802r<? extends C13802r<? extends T>> sources, int prefetch) {
        C13264b.m43226a(sources, "sources is null");
        C13264b.m43222a(prefetch, "prefetch");
        return C13774a.m43821a((C13797m<T>) new C13572mb<T>(sources, C13226a.m43201e(), prefetch, true));
    }

    public static C13797m<Long> timer(long delay, TimeUnit unit) {
        return timer(delay, unit, C13777b.m43846a());
    }

    public static C13797m<Long> timer(long delay, TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13774a.m43821a((C13797m<T>) new C13678yb<T>(Math.max(delay, 0), unit, scheduler));
    }

    public static <T> C13797m<T> unsafeCreate(C13802r<T> onSubscribe) {
        C13264b.m43226a(onSubscribe, "source is null");
        C13264b.m43226a(onSubscribe, "onSubscribe is null");
        if (!(onSubscribe instanceof C13797m)) {
            return C13774a.m43821a((C13797m<T>) new C13538ia<T>(onSubscribe));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    public static <T, D> C13797m<T> using(Callable<? extends D> resourceSupplier, C13212n<? super D, ? extends C13802r<? extends T>> sourceSupplier, C13204f<? super D> disposer) {
        return using(resourceSupplier, sourceSupplier, disposer, true);
    }

    public static <T, D> C13797m<T> using(Callable<? extends D> resourceSupplier, C13212n<? super D, ? extends C13802r<? extends T>> sourceSupplier, C13204f<? super D> disposer, boolean eager) {
        C13264b.m43226a(resourceSupplier, "resourceSupplier is null");
        C13264b.m43226a(sourceSupplier, "sourceSupplier is null");
        C13264b.m43226a(disposer, "disposer is null");
        return C13774a.m43821a((C13797m<T>) new C13326Cb<T>(resourceSupplier, sourceSupplier, disposer, eager));
    }

    public static <T> C13797m<T> wrap(C13802r<T> source) {
        C13264b.m43226a(source, "source is null");
        if (source instanceof C13797m) {
            return C13774a.m43821a((C13797m) source);
        }
        return C13774a.m43821a((C13797m<T>) new C13538ia<T>(source));
    }

    public static <T, R> C13797m<R> zip(Iterable<? extends C13802r<? extends T>> sources, C13212n<? super Object[], ? extends R> zipper) {
        C13264b.m43226a(zipper, "zipper is null");
        C13264b.m43226a(sources, "sources is null");
        C13395Kb kb = new C13395Kb(null, sources, zipper, bufferSize(), false);
        return C13774a.m43821a((C13797m<T>) kb);
    }

    public static <T, R> C13797m<R> zip(C13802r<? extends C13802r<? extends T>> sources, C13212n<? super Object[], ? extends R> zipper) {
        C13264b.m43226a(zipper, "zipper is null");
        C13264b.m43226a(sources, "sources is null");
        return C13774a.m43821a(new C13684zb(sources, 16).flatMap(C13595pa.m43573c(zipper)));
    }

    public static <T1, T2, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13201c<? super T1, ? super T2, ? extends R> zipper) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        return zipArray(C13226a.m43178a(zipper), false, bufferSize(), source1, source2);
    }

    public static <T1, T2, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13201c<? super T1, ? super T2, ? extends R> zipper, boolean delayError) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        return zipArray(C13226a.m43178a(zipper), delayError, bufferSize(), source1, source2);
    }

    public static <T1, T2, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13201c<? super T1, ? super T2, ? extends R> zipper, boolean delayError, int bufferSize) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        return zipArray(C13226a.m43178a(zipper), delayError, bufferSize, source1, source2);
    }

    public static <T1, T2, T3, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13205g<? super T1, ? super T2, ? super T3, ? extends R> zipper) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        return zipArray(C13226a.m43179a(zipper), false, bufferSize(), source1, source2, source3);
    }

    public static <T1, T2, T3, T4, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13206h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> zipper) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        return zipArray(C13226a.m43180a(zipper), false, bufferSize(), source1, source2, source3, source4);
    }

    public static <T1, T2, T3, T4, T5, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13207i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> zipper) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        return zipArray(C13226a.m43181a(zipper), false, bufferSize(), source1, source2, source3, source4, source5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13802r<? extends T6> source6, C13208j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> zipper) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        C13264b.m43226a(source6, "source6 is null");
        return zipArray(C13226a.m43182a(zipper), false, bufferSize(), source1, source2, source3, source4, source5, source6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13802r<? extends T6> source6, C13802r<? extends T7> source7, C13209k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> zipper) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        C13264b.m43226a(source6, "source6 is null");
        C13264b.m43226a(source7, "source7 is null");
        return zipArray(C13226a.m43183a(zipper), false, bufferSize(), source1, source2, source3, source4, source5, source6, source7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13802r<? extends T6> source6, C13802r<? extends T7> source7, C13802r<? extends T8> source8, C13210l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> zipper) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        C13264b.m43226a(source6, "source6 is null");
        C13264b.m43226a(source7, "source7 is null");
        C13264b.m43226a(source8, "source8 is null");
        return zipArray(C13226a.m43184a(zipper), false, bufferSize(), source1, source2, source3, source4, source5, source6, source7, source8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> C13797m<R> zip(C13802r<? extends T1> source1, C13802r<? extends T2> source2, C13802r<? extends T3> source3, C13802r<? extends T4> source4, C13802r<? extends T5> source5, C13802r<? extends T6> source6, C13802r<? extends T7> source7, C13802r<? extends T8> source8, C13802r<? extends T9> source9, C13211m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> zipper) {
        C13264b.m43226a(source1, "source1 is null");
        C13264b.m43226a(source2, "source2 is null");
        C13264b.m43226a(source3, "source3 is null");
        C13264b.m43226a(source4, "source4 is null");
        C13264b.m43226a(source5, "source5 is null");
        C13264b.m43226a(source6, "source6 is null");
        C13264b.m43226a(source7, "source7 is null");
        C13264b.m43226a(source8, "source8 is null");
        C13264b.m43226a(source9, "source9 is null");
        return zipArray(C13226a.m43185a(zipper), false, bufferSize(), source1, source2, source3, source4, source5, source6, source7, source8, source9);
    }

    public static <T, R> C13797m<R> zipArray(C13212n<? super Object[], ? extends R> zipper, boolean delayError, int bufferSize, C13802r<? extends T>... sources) {
        if (sources.length == 0) {
            return empty();
        }
        C13264b.m43226a(zipper, "zipper is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        C13395Kb kb = new C13395Kb(sources, null, zipper, bufferSize, delayError);
        return C13774a.m43821a((C13797m<T>) kb);
    }

    public static <T, R> C13797m<R> zipIterable(Iterable<? extends C13802r<? extends T>> sources, C13212n<? super Object[], ? extends R> zipper, boolean delayError, int bufferSize) {
        C13264b.m43226a(zipper, "zipper is null");
        C13264b.m43226a(sources, "sources is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        C13395Kb kb = new C13395Kb(null, sources, zipper, bufferSize, delayError);
        return C13774a.m43821a((C13797m<T>) kb);
    }

    public final C13810v<Boolean> all(C13214p<? super T> predicate) {
        C13264b.m43226a(predicate, "predicate is null");
        return C13774a.m43826a((C13810v<T>) new C13523g<T>(this, predicate));
    }

    public final C13797m<T> ambWith(C13802r<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return ambArray(this, other);
    }

    public final C13810v<Boolean> any(C13214p<? super T> predicate) {
        C13264b.m43226a(predicate, "predicate is null");
        return C13774a.m43826a((C13810v<T>) new C13542j<T>(this, predicate));
    }

    /* renamed from: as */
    public final <R> R mo42826as(C13798n<T, ? extends R> converter) {
        C13264b.m43226a(converter, "converter is null");
        return converter.mo43144a(this);
    }

    public final T blockingFirst() {
        BlockingFirstObserver<T> s = new C13279e<>();
        subscribe((C13804t<? super T>) s);
        T v = s.mo42322a();
        if (v != null) {
            return v;
        }
        throw new NoSuchElementException();
    }

    public final T blockingFirst(T defaultItem) {
        BlockingFirstObserver<T> s = new C13279e<>();
        subscribe((C13804t<? super T>) s);
        T v = s.mo42322a();
        return v != null ? v : defaultItem;
    }

    public final void blockingForEach(C13204f<? super T> onNext) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                onNext.accept(it.next());
            } catch (Throwable e) {
                C13980a.m44462b(e);
                ((C13194b) it).dispose();
                throw C13748j.m43761a(e);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final Iterable<T> blockingIterable(int bufferSize) {
        C13264b.m43222a(bufferSize, "bufferSize");
        return new C13492b(this, bufferSize);
    }

    public final T blockingLast() {
        BlockingLastObserver<T> s = new C13280f<>();
        subscribe((C13804t<? super T>) s);
        T v = s.mo42322a();
        if (v != null) {
            return v;
        }
        throw new NoSuchElementException();
    }

    public final T blockingLast(T defaultItem) {
        BlockingLastObserver<T> s = new C13280f<>();
        subscribe((C13804t<? super T>) s);
        T v = s.mo42322a();
        return v != null ? v : defaultItem;
    }

    public final Iterable<T> blockingLatest() {
        return new C13500c(this);
    }

    public final Iterable<T> blockingMostRecent(T initialValue) {
        return new C13505d(this, initialValue);
    }

    public final Iterable<T> blockingNext() {
        return new C13512e(this);
    }

    public final T blockingSingle() {
        T v = singleElement().mo42791b();
        if (v != null) {
            return v;
        }
        throw new NoSuchElementException();
    }

    public final T blockingSingle(T defaultItem) {
        return single(defaultItem).mo43158b();
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new C13287m());
    }

    public final void blockingSubscribe() {
        C13548k.m43505a(this);
    }

    public final void blockingSubscribe(C13204f<? super T> onNext) {
        C13548k.m43506a(this, onNext, C13226a.f40315f, C13226a.f40312c);
    }

    public final void blockingSubscribe(C13204f<? super T> onNext, C13204f<? super Throwable> onError) {
        C13548k.m43506a(this, onNext, onError, C13226a.f40312c);
    }

    public final void blockingSubscribe(C13204f<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete) {
        C13548k.m43506a(this, onNext, onError, onComplete);
    }

    public final void blockingSubscribe(C13804t<? super T> subscriber) {
        C13548k.m43507a(this, subscriber);
    }

    public final C13797m<List<T>> buffer(int count) {
        return buffer(count, count);
    }

    public final C13797m<List<T>> buffer(int count, int skip) {
        return buffer(count, skip, C13740b.m43745e());
    }

    public final <U extends Collection<? super T>> C13797m<U> buffer(int count, int skip, Callable<U> bufferSupplier) {
        C13264b.m43222a(count, "count");
        C13264b.m43222a(skip, "skip");
        C13264b.m43226a(bufferSupplier, "bufferSupplier is null");
        return C13774a.m43821a((C13797m<T>) new C13556l<T>(this, count, skip, bufferSupplier));
    }

    public final <U extends Collection<? super T>> C13797m<U> buffer(int count, Callable<U> bufferSupplier) {
        return buffer(count, count, bufferSupplier);
    }

    public final C13797m<List<T>> buffer(long timespan, long timeskip, TimeUnit unit) {
        return buffer(timespan, timeskip, unit, C13777b.m43846a(), C13740b.m43745e());
    }

    public final C13797m<List<T>> buffer(long timespan, long timeskip, TimeUnit unit, C13805u scheduler) {
        return buffer(timespan, timeskip, unit, scheduler, C13740b.m43745e());
    }

    public final <U extends Collection<? super T>> C13797m<U> buffer(long timespan, long timeskip, TimeUnit unit, C13805u scheduler, Callable<U> bufferSupplier) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13264b.m43226a(bufferSupplier, "bufferSupplier is null");
        C13589p pVar = new C13589p(this, timespan, timeskip, unit, scheduler, bufferSupplier, MoPubClientPositioning.NO_REPEAT, false);
        return C13774a.m43821a((C13797m<T>) pVar);
    }

    public final C13797m<List<T>> buffer(long timespan, TimeUnit unit) {
        return buffer(timespan, unit, C13777b.m43846a(), (int) MoPubClientPositioning.NO_REPEAT);
    }

    public final C13797m<List<T>> buffer(long timespan, TimeUnit unit, int count) {
        return buffer(timespan, unit, C13777b.m43846a(), count);
    }

    public final C13797m<List<T>> buffer(long timespan, TimeUnit unit, C13805u scheduler, int count) {
        return buffer(timespan, unit, scheduler, count, C13740b.m43745e(), false);
    }

    public final <U extends Collection<? super T>> C13797m<U> buffer(long timespan, TimeUnit unit, C13805u scheduler, int count, Callable<U> bufferSupplier, boolean restartTimerOnMaxSize) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13264b.m43226a(bufferSupplier, "bufferSupplier is null");
        C13264b.m43222a(count, "count");
        C13589p pVar = new C13589p(this, timespan, timespan, unit, scheduler, bufferSupplier, count, restartTimerOnMaxSize);
        return C13774a.m43821a((C13797m<T>) pVar);
    }

    public final C13797m<List<T>> buffer(long timespan, TimeUnit unit, C13805u scheduler) {
        return buffer(timespan, unit, scheduler, MoPubClientPositioning.NO_REPEAT, C13740b.m43745e(), false);
    }

    public final <TOpening, TClosing> C13797m<List<T>> buffer(C13802r<? extends TOpening> openingIndicator, C13212n<? super TOpening, ? extends C13802r<? extends TClosing>> closingIndicator) {
        return buffer(openingIndicator, closingIndicator, C13740b.m43745e());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> C13797m<U> buffer(C13802r<? extends TOpening> openingIndicator, C13212n<? super TOpening, ? extends C13802r<? extends TClosing>> closingIndicator, Callable<U> bufferSupplier) {
        C13264b.m43226a(openingIndicator, "openingIndicator is null");
        C13264b.m43226a(closingIndicator, "closingIndicator is null");
        C13264b.m43226a(bufferSupplier, "bufferSupplier is null");
        return C13774a.m43821a((C13797m<T>) new C13566m<T>(this, openingIndicator, closingIndicator, bufferSupplier));
    }

    public final <B> C13797m<List<T>> buffer(C13802r<B> boundary) {
        return buffer(boundary, C13740b.m43745e());
    }

    public final <B> C13797m<List<T>> buffer(C13802r<B> boundary, int initialCapacity) {
        C13264b.m43222a(initialCapacity, "initialCapacity");
        return buffer(boundary, C13226a.m43192a(initialCapacity));
    }

    public final <B, U extends Collection<? super T>> C13797m<U> buffer(C13802r<B> boundary, Callable<U> bufferSupplier) {
        C13264b.m43226a(boundary, "boundary is null");
        C13264b.m43226a(bufferSupplier, "bufferSupplier is null");
        return C13774a.m43821a((C13797m<T>) new C13582o<T>(this, boundary, bufferSupplier));
    }

    public final <B> C13797m<List<T>> buffer(Callable<? extends C13802r<B>> boundarySupplier) {
        return buffer(boundarySupplier, C13740b.m43745e());
    }

    public final <B, U extends Collection<? super T>> C13797m<U> buffer(Callable<? extends C13802r<B>> boundarySupplier, Callable<U> bufferSupplier) {
        C13264b.m43226a(boundarySupplier, "boundarySupplier is null");
        C13264b.m43226a(bufferSupplier, "bufferSupplier is null");
        return C13774a.m43821a((C13797m<T>) new C13575n<T>(this, boundarySupplier, bufferSupplier));
    }

    public final C13797m<T> cache() {
        return C13614q.m43581a(this);
    }

    public final C13797m<T> cacheWithInitialCapacity(int initialCapacity) {
        return C13614q.m43582a(this, initialCapacity);
    }

    public final <U> C13797m<U> cast(Class<U> clazz) {
        C13264b.m43226a(clazz, "clazz is null");
        return map(C13226a.m43186a(clazz));
    }

    public final <U> C13810v<U> collect(Callable<? extends U> initialValueSupplier, C13200b<? super U, ? super T> collector) {
        C13264b.m43226a(initialValueSupplier, "initialValueSupplier is null");
        C13264b.m43226a(collector, "collector is null");
        return C13774a.m43826a((C13810v<T>) new C13628s<T>(this, initialValueSupplier, collector));
    }

    public final <U> C13810v<U> collectInto(U initialValue, C13200b<? super U, ? super T> collector) {
        C13264b.m43226a(initialValue, "initialValue is null");
        return collect(C13226a.m43196b(initialValue), collector);
    }

    public final <R> C13797m<R> compose(C13803s<? super T, ? extends R> composer) {
        C13264b.m43226a(composer, "composer is null");
        return wrap(composer.mo43146a(this));
    }

    public final <R> C13797m<R> concatMap(C13212n<? super T, ? extends C13802r<? extends R>> mapper) {
        return concatMap(mapper, 2);
    }

    public final <R> C13797m<R> concatMap(C13212n<? super T, ? extends C13802r<? extends R>> mapper, int prefetch) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43222a(prefetch, "prefetch");
        if (!(this instanceof C13272g)) {
            return C13774a.m43821a((C13797m<T>) new C13640u<T>(this, mapper, prefetch, C13747i.IMMEDIATE));
        }
        T v = ((C13272g) this).call();
        if (v == null) {
            return empty();
        }
        return C13475Ya.m43449a(v, mapper);
    }

    public final <R> C13797m<R> concatMapDelayError(C13212n<? super T, ? extends C13802r<? extends R>> mapper) {
        return concatMapDelayError(mapper, bufferSize(), true);
    }

    public final <R> C13797m<R> concatMapDelayError(C13212n<? super T, ? extends C13802r<? extends R>> mapper, int prefetch, boolean tillTheEnd) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43222a(prefetch, "prefetch");
        if (this instanceof C13272g) {
            T v = ((C13272g) this).call();
            if (v == null) {
                return empty();
            }
            return C13475Ya.m43449a(v, mapper);
        }
        return C13774a.m43821a((C13797m<T>) new C13640u<T>(this, mapper, prefetch, tillTheEnd ? C13747i.END : C13747i.BOUNDARY));
    }

    public final <R> C13797m<R> concatMapEager(C13212n<? super T, ? extends C13802r<? extends R>> mapper) {
        return concatMapEager(mapper, MoPubClientPositioning.NO_REPEAT, bufferSize());
    }

    public final <R> C13797m<R> concatMapEager(C13212n<? super T, ? extends C13802r<? extends R>> mapper, int maxConcurrency, int prefetch) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43222a(maxConcurrency, "maxConcurrency");
        C13264b.m43222a(prefetch, "prefetch");
        C13656w wVar = new C13656w(this, mapper, C13747i.IMMEDIATE, maxConcurrency, prefetch);
        return C13774a.m43821a((C13797m<T>) wVar);
    }

    public final <R> C13797m<R> concatMapEagerDelayError(C13212n<? super T, ? extends C13802r<? extends R>> mapper, boolean tillTheEnd) {
        return concatMapEagerDelayError(mapper, MoPubClientPositioning.NO_REPEAT, bufferSize(), tillTheEnd);
    }

    public final <R> C13797m<R> concatMapEagerDelayError(C13212n<? super T, ? extends C13802r<? extends R>> mapper, int maxConcurrency, int prefetch, boolean tillTheEnd) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43222a(maxConcurrency, "maxConcurrency");
        C13264b.m43222a(prefetch, "prefetch");
        C13656w wVar = new C13656w(this, mapper, tillTheEnd ? C13747i.END : C13747i.BOUNDARY, maxConcurrency, prefetch);
        return C13774a.m43821a((C13797m<T>) wVar);
    }

    public final C13192b concatMapCompletable(C13212n<? super T, ? extends C13215d> mapper) {
        return concatMapCompletable(mapper, 2);
    }

    public final C13192b concatMapCompletable(C13212n<? super T, ? extends C13215d> mapper, int capacityHint) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43222a(capacityHint, "capacityHint");
        return C13774a.m43815a((C13192b) new C13649v(this, mapper, capacityHint));
    }

    public final <U> C13797m<U> concatMapIterable(C13212n<? super T, ? extends Iterable<? extends U>> mapper) {
        C13264b.m43226a(mapper, "mapper is null");
        return C13774a.m43821a((C13797m<T>) new C13502ca<T>(this, mapper));
    }

    public final <U> C13797m<U> concatMapIterable(C13212n<? super T, ? extends Iterable<? extends U>> mapper, int prefetch) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43222a(prefetch, "prefetch");
        return concatMap(C13595pa.m43561a(mapper), prefetch);
    }

    public final C13797m<T> concatWith(C13802r<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return concat((C13802r<? extends T>) this, other);
    }

    public final C13797m<T> concatWith(C13814z<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13680z<T>(this, other));
    }

    public final C13797m<T> concatWith(C13794j<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13674y<T>(this, other));
    }

    public final C13797m<T> concatWith(C13215d other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13664x<T>(this, other));
    }

    public final C13810v<Boolean> contains(Object element) {
        C13264b.m43226a(element, "element is null");
        return any(C13226a.m43191a(element));
    }

    public final C13810v<Long> count() {
        return C13774a.m43826a((C13810v<T>) new C13313B<T>(this));
    }

    public final <U> C13797m<T> debounce(C13212n<? super T, ? extends C13802r<U>> debounceSelector) {
        C13264b.m43226a(debounceSelector, "debounceSelector is null");
        return C13774a.m43821a((C13797m<T>) new C13328D<T>(this, debounceSelector));
    }

    public final C13797m<T> debounce(long timeout, TimeUnit unit) {
        return debounce(timeout, unit, C13777b.m43846a());
    }

    public final C13797m<T> debounce(long timeout, TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13335E e = new C13335E(this, timeout, unit, scheduler);
        return C13774a.m43821a((C13797m<T>) e);
    }

    public final C13797m<T> defaultIfEmpty(T defaultItem) {
        C13264b.m43226a(defaultItem, "defaultItem is null");
        return switchIfEmpty(just(defaultItem));
    }

    public final <U> C13797m<T> delay(C13212n<? super T, ? extends C13802r<U>> itemDelay) {
        C13264b.m43226a(itemDelay, "itemDelay is null");
        return flatMap(C13595pa.m43570b(itemDelay));
    }

    public final C13797m<T> delay(long delay, TimeUnit unit) {
        return delay(delay, unit, C13777b.m43846a(), false);
    }

    public final C13797m<T> delay(long delay, TimeUnit unit, boolean delayError) {
        return delay(delay, unit, C13777b.m43846a(), delayError);
    }

    public final C13797m<T> delay(long delay, TimeUnit unit, C13805u scheduler) {
        return delay(delay, unit, scheduler, false);
    }

    public final C13797m<T> delay(long delay, TimeUnit unit, C13805u scheduler, boolean delayError) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13351G g = new C13351G(this, delay, unit, scheduler, delayError);
        return C13774a.m43821a((C13797m<T>) g);
    }

    public final <U, V> C13797m<T> delay(C13802r<U> subscriptionDelay, C13212n<? super T, ? extends C13802r<V>> itemDelay) {
        return delaySubscription(subscriptionDelay).delay(itemDelay);
    }

    public final <U> C13797m<T> delaySubscription(C13802r<U> other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13361H<T>(this, other));
    }

    public final C13797m<T> delaySubscription(long delay, TimeUnit unit) {
        return delaySubscription(delay, unit, C13777b.m43846a());
    }

    public final C13797m<T> delaySubscription(long delay, TimeUnit unit, C13805u scheduler) {
        return delaySubscription(timer(delay, unit, scheduler));
    }

    public final <T2> C13797m<T2> dematerialize() {
        return C13774a.m43821a((C13797m<T>) new C13375I<T>(this));
    }

    public final C13797m<T> distinct() {
        return distinct(C13226a.m43201e(), C13226a.m43199c());
    }

    public final <K> C13797m<T> distinct(C13212n<? super T, K> keySelector) {
        return distinct(keySelector, C13226a.m43199c());
    }

    public final <K> C13797m<T> distinct(C13212n<? super T, K> keySelector, Callable<? extends Collection<? super K>> collectionSupplier) {
        C13264b.m43226a(keySelector, "keySelector is null");
        C13264b.m43226a(collectionSupplier, "collectionSupplier is null");
        return C13774a.m43821a((C13797m<T>) new C13391K<T>(this, keySelector, collectionSupplier));
    }

    public final C13797m<T> distinctUntilChanged() {
        return distinctUntilChanged(C13226a.m43201e());
    }

    public final <K> C13797m<T> distinctUntilChanged(C13212n<? super T, K> keySelector) {
        C13264b.m43226a(keySelector, "keySelector is null");
        return C13774a.m43821a((C13797m<T>) new C13398L<T>(this, keySelector, C13264b.m43225a()));
    }

    public final C13797m<T> distinctUntilChanged(C13202d<? super T, ? super T> comparer) {
        C13264b.m43226a(comparer, "comparer is null");
        return C13774a.m43821a((C13797m<T>) new C13398L<T>(this, C13226a.m43201e(), comparer));
    }

    public final C13797m<T> doAfterNext(C13204f<? super T> onAfterNext) {
        C13264b.m43226a(onAfterNext, "onAfterNext is null");
        return C13774a.m43821a((C13797m<T>) new C13404M<T>(this, onAfterNext));
    }

    public final C13797m<T> doAfterTerminate(C13199a onFinally) {
        C13264b.m43226a(onFinally, "onFinally is null");
        return doOnEach(C13226a.m43200d(), C13226a.m43200d(), C13226a.f40312c, onFinally);
    }

    public final C13797m<T> doFinally(C13199a onFinally) {
        C13264b.m43226a(onFinally, "onFinally is null");
        return C13774a.m43821a((C13797m<T>) new C13409N<T>(this, onFinally));
    }

    public final C13797m<T> doOnDispose(C13199a onDispose) {
        return doOnLifecycle(C13226a.m43200d(), onDispose);
    }

    public final C13797m<T> doOnComplete(C13199a onComplete) {
        return doOnEach(C13226a.m43200d(), C13226a.m43200d(), onComplete, C13226a.f40312c);
    }

    private C13797m<T> doOnEach(C13204f<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete, C13199a onAfterTerminate) {
        C13264b.m43226a(onNext, "onNext is null");
        C13264b.m43226a(onError, "onError is null");
        C13264b.m43226a(onComplete, "onComplete is null");
        C13264b.m43226a(onAfterTerminate, "onAfterTerminate is null");
        C13412O o = new C13412O(this, onNext, onError, onComplete, onAfterTerminate);
        return C13774a.m43821a((C13797m<T>) o);
    }

    public final C13797m<T> doOnEach(C13204f<? super C13795k<T>> onNotification) {
        C13264b.m43226a(onNotification, "consumer is null");
        return doOnEach(C13226a.m43197c(onNotification), C13226a.m43193b(onNotification), C13226a.m43173a(onNotification), C13226a.f40312c);
    }

    public final C13797m<T> doOnEach(C13804t<? super T> observer) {
        C13264b.m43226a(observer, "observer is null");
        return doOnEach(C13595pa.m43572c(observer), C13595pa.m43569b(observer), C13595pa.m43558a(observer), C13226a.f40312c);
    }

    public final C13797m<T> doOnError(C13204f<? super Throwable> onError) {
        C13204f d = C13226a.m43200d();
        C13199a aVar = C13226a.f40312c;
        return doOnEach(d, onError, aVar, aVar);
    }

    public final C13797m<T> doOnLifecycle(C13204f<? super C13194b> onSubscribe, C13199a onDispose) {
        C13264b.m43226a(onSubscribe, "onSubscribe is null");
        C13264b.m43226a(onDispose, "onDispose is null");
        return C13774a.m43821a((C13797m<T>) new C13418P<T>(this, onSubscribe, onDispose));
    }

    public final C13797m<T> doOnNext(C13204f<? super T> onNext) {
        C13204f d = C13226a.m43200d();
        C13199a aVar = C13226a.f40312c;
        return doOnEach(onNext, d, aVar, aVar);
    }

    public final C13797m<T> doOnSubscribe(C13204f<? super C13194b> onSubscribe) {
        return doOnLifecycle(onSubscribe, C13226a.f40312c);
    }

    public final C13797m<T> doOnTerminate(C13199a onTerminate) {
        C13264b.m43226a(onTerminate, "onTerminate is null");
        return doOnEach(C13226a.m43200d(), C13226a.m43177a(onTerminate), onTerminate, C13226a.f40312c);
    }

    public final C13775h<T> elementAt(long index) {
        if (index >= 0) {
            return C13774a.m43819a((C13775h<T>) new C13428S<T>(this, index));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("index >= 0 required but it was ");
        sb.append(index);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final C13810v<T> elementAt(long index, T defaultItem) {
        if (index >= 0) {
            C13264b.m43226a(defaultItem, "defaultItem is null");
            return C13774a.m43826a((C13810v<T>) new C13447T<T>(this, index, defaultItem));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("index >= 0 required but it was ");
        sb.append(index);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final C13810v<T> elementAtOrError(long index) {
        if (index >= 0) {
            return C13774a.m43826a((C13810v<T>) new C13447T<T>(this, index, null));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("index >= 0 required but it was ");
        sb.append(index);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final C13797m<T> filter(C13214p<? super T> predicate) {
        C13264b.m43226a(predicate, "predicate is null");
        return C13774a.m43821a((C13797m<T>) new C13458W<T>(this, predicate));
    }

    public final C13775h<T> firstElement() {
        return elementAt(0);
    }

    public final C13810v<T> first(T defaultItem) {
        return elementAt(0, defaultItem);
    }

    public final C13810v<T> firstOrError() {
        return elementAtOrError(0);
    }

    public final <R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends R>> mapper) {
        return flatMap(mapper, false);
    }

    public final <R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends R>> mapper, boolean delayErrors) {
        return flatMap(mapper, delayErrors, (int) MoPubClientPositioning.NO_REPEAT);
    }

    public final <R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends R>> mapper, boolean delayErrors, int maxConcurrency) {
        return flatMap(mapper, delayErrors, maxConcurrency, bufferSize());
    }

    public final <R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends R>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43222a(maxConcurrency, "maxConcurrency");
        C13264b.m43222a(bufferSize, "bufferSize");
        if (this instanceof C13272g) {
            T v = ((C13272g) this).call();
            if (v == null) {
                return empty();
            }
            return C13475Ya.m43449a(v, mapper);
        }
        C13464X x = new C13464X(this, mapper, delayErrors, maxConcurrency, bufferSize);
        return C13774a.m43821a((C13797m<T>) x);
    }

    public final <R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends R>> onNextMapper, C13212n<? super Throwable, ? extends C13802r<? extends R>> onErrorMapper, Callable<? extends C13802r<? extends R>> onCompleteSupplier) {
        C13264b.m43226a(onNextMapper, "onNextMapper is null");
        C13264b.m43226a(onErrorMapper, "onErrorMapper is null");
        C13264b.m43226a(onCompleteSupplier, "onCompleteSupplier is null");
        return merge((C13802r<? extends C13802r<? extends T>>) new C13676ya<Object>(this, onNextMapper, onErrorMapper, onCompleteSupplier));
    }

    public final <R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends R>> onNextMapper, C13212n<Throwable, ? extends C13802r<? extends R>> onErrorMapper, Callable<? extends C13802r<? extends R>> onCompleteSupplier, int maxConcurrency) {
        C13264b.m43226a(onNextMapper, "onNextMapper is null");
        C13264b.m43226a(onErrorMapper, "onErrorMapper is null");
        C13264b.m43226a(onCompleteSupplier, "onCompleteSupplier is null");
        return merge((C13802r<? extends C13802r<? extends T>>) new C13676ya<Object>(this, onNextMapper, onErrorMapper, onCompleteSupplier), maxConcurrency);
    }

    public final <R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends R>> mapper, int maxConcurrency) {
        return flatMap(mapper, false, maxConcurrency, bufferSize());
    }

    public final <U, R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends U>> mapper, C13201c<? super T, ? super U, ? extends R> resultSelector) {
        return flatMap(mapper, resultSelector, false, bufferSize(), bufferSize());
    }

    public final <U, R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends U>> mapper, C13201c<? super T, ? super U, ? extends R> combiner, boolean delayErrors) {
        return flatMap(mapper, combiner, delayErrors, bufferSize(), bufferSize());
    }

    public final <U, R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends U>> mapper, C13201c<? super T, ? super U, ? extends R> combiner, boolean delayErrors, int maxConcurrency) {
        return flatMap(mapper, combiner, delayErrors, maxConcurrency, bufferSize());
    }

    public final <U, R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends U>> mapper, C13201c<? super T, ? super U, ? extends R> combiner, boolean delayErrors, int maxConcurrency, int bufferSize) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43226a(combiner, "combiner is null");
        return flatMap(C13595pa.m43562a(mapper, combiner), delayErrors, maxConcurrency, bufferSize);
    }

    public final <U, R> C13797m<R> flatMap(C13212n<? super T, ? extends C13802r<? extends U>> mapper, C13201c<? super T, ? super U, ? extends R> combiner, int maxConcurrency) {
        return flatMap(mapper, combiner, false, maxConcurrency, bufferSize());
    }

    public final C13192b flatMapCompletable(C13212n<? super T, ? extends C13215d> mapper) {
        return flatMapCompletable(mapper, false);
    }

    public final C13192b flatMapCompletable(C13212n<? super T, ? extends C13215d> mapper, boolean delayErrors) {
        C13264b.m43226a(mapper, "mapper is null");
        return C13774a.m43815a((C13192b) new C13478Z(this, mapper, delayErrors));
    }

    public final <U> C13797m<U> flatMapIterable(C13212n<? super T, ? extends Iterable<? extends U>> mapper) {
        C13264b.m43226a(mapper, "mapper is null");
        return C13774a.m43821a((C13797m<T>) new C13502ca<T>(this, mapper));
    }

    public final <U, V> C13797m<V> flatMapIterable(C13212n<? super T, ? extends Iterable<? extends U>> mapper, C13201c<? super T, ? super U, ? extends V> resultSelector) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43226a(resultSelector, "resultSelector is null");
        return flatMap(C13595pa.m43561a(mapper), resultSelector, false, bufferSize(), bufferSize());
    }

    public final <R> C13797m<R> flatMapMaybe(C13212n<? super T, ? extends C13794j<? extends R>> mapper) {
        return flatMapMaybe(mapper, false);
    }

    public final <R> C13797m<R> flatMapMaybe(C13212n<? super T, ? extends C13794j<? extends R>> mapper, boolean delayErrors) {
        C13264b.m43226a(mapper, "mapper is null");
        return C13774a.m43821a((C13797m<T>) new C13486aa<T>(this, mapper, delayErrors));
    }

    public final <R> C13797m<R> flatMapSingle(C13212n<? super T, ? extends C13814z<? extends R>> mapper) {
        return flatMapSingle(mapper, false);
    }

    public final <R> C13797m<R> flatMapSingle(C13212n<? super T, ? extends C13814z<? extends R>> mapper, boolean delayErrors) {
        C13264b.m43226a(mapper, "mapper is null");
        return C13774a.m43821a((C13797m<T>) new C13494ba<T>(this, mapper, delayErrors));
    }

    public final C13194b forEach(C13204f<? super T> onNext) {
        return subscribe(onNext);
    }

    public final C13194b forEachWhile(C13214p<? super T> onNext) {
        return forEachWhile(onNext, C13226a.f40315f, C13226a.f40312c);
    }

    public final C13194b forEachWhile(C13214p<? super T> onNext, C13204f<? super Throwable> onError) {
        return forEachWhile(onNext, onError, C13226a.f40312c);
    }

    public final C13194b forEachWhile(C13214p<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete) {
        C13264b.m43226a(onNext, "onNext is null");
        C13264b.m43226a(onError, "onError is null");
        C13264b.m43226a(onComplete, "onComplete is null");
        ForEachWhileObserver<T> o = new C13285k<>(onNext, onError, onComplete);
        subscribe((C13804t<? super T>) o);
        return o;
    }

    public final <K> C13797m<C13763b<K, T>> groupBy(C13212n<? super T, ? extends K> keySelector) {
        return groupBy(keySelector, C13226a.m43201e(), false, bufferSize());
    }

    public final <K> C13797m<C13763b<K, T>> groupBy(C13212n<? super T, ? extends K> keySelector, boolean delayError) {
        return groupBy(keySelector, C13226a.m43201e(), delayError, bufferSize());
    }

    public final <K, V> C13797m<C13763b<K, V>> groupBy(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector) {
        return groupBy(keySelector, valueSelector, false, bufferSize());
    }

    public final <K, V> C13797m<C13763b<K, V>> groupBy(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector, boolean delayError) {
        return groupBy(keySelector, valueSelector, delayError, bufferSize());
    }

    public final <K, V> C13797m<C13763b<K, V>> groupBy(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector, boolean delayError, int bufferSize) {
        C13264b.m43226a(keySelector, "keySelector is null");
        C13264b.m43226a(valueSelector, "valueSelector is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        C13549ka kaVar = new C13549ka(this, keySelector, valueSelector, bufferSize, delayError);
        return C13774a.m43821a((C13797m<T>) kaVar);
    }

    public final <TRight, TLeftEnd, TRightEnd, R> C13797m<R> groupJoin(C13802r<? extends TRight> other, C13212n<? super T, ? extends C13802r<TLeftEnd>> leftEnd, C13212n<? super TRight, ? extends C13802r<TRightEnd>> rightEnd, C13201c<? super T, ? super C13797m<TRight>, ? extends R> resultSelector) {
        C13264b.m43226a(other, "other is null");
        C13264b.m43226a(leftEnd, "leftEnd is null");
        C13264b.m43226a(rightEnd, "rightEnd is null");
        C13264b.m43226a(resultSelector, "resultSelector is null");
        C13559la laVar = new C13559la(this, other, leftEnd, rightEnd, resultSelector);
        return C13774a.m43821a((C13797m<T>) laVar);
    }

    public final C13797m<T> hide() {
        return C13774a.m43821a((C13797m<T>) new C13570ma<T>(this));
    }

    public final C13192b ignoreElements() {
        return C13774a.m43815a((C13192b) new C13585oa(this));
    }

    public final C13810v<Boolean> isEmpty() {
        return all(C13226a.m43189a());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> C13797m<R> join(C13802r<? extends TRight> other, C13212n<? super T, ? extends C13802r<TLeftEnd>> leftEnd, C13212n<? super TRight, ? extends C13802r<TRightEnd>> rightEnd, C13201c<? super T, ? super TRight, ? extends R> resultSelector) {
        C13264b.m43226a(other, "other is null");
        C13264b.m43226a(leftEnd, "leftEnd is null");
        C13264b.m43226a(rightEnd, "rightEnd is null");
        C13264b.m43226a(resultSelector, "resultSelector is null");
        C13630sa saVar = new C13630sa(this, other, leftEnd, rightEnd, resultSelector);
        return C13774a.m43821a((C13797m<T>) saVar);
    }

    public final C13775h<T> lastElement() {
        return C13774a.m43819a((C13775h<T>) new C13645ua<T>(this));
    }

    public final C13810v<T> last(T defaultItem) {
        C13264b.m43226a(defaultItem, "defaultItem is null");
        return C13774a.m43826a((C13810v<T>) new C13652va<T>(this, defaultItem));
    }

    public final C13810v<T> lastOrError() {
        return C13774a.m43826a((C13810v<T>) new C13652va<T>(this, null));
    }

    public final <R> C13797m<R> lift(C13801q<? extends R, ? super T> lifter) {
        C13264b.m43226a(lifter, "onLift is null");
        return C13774a.m43821a((C13797m<T>) new C13658wa<T>(this, lifter));
    }

    public final <R> C13797m<R> map(C13212n<? super T, ? extends R> mapper) {
        C13264b.m43226a(mapper, "mapper is null");
        return C13774a.m43821a((C13797m<T>) new C13666xa<T>(this, mapper));
    }

    public final C13797m<C13795k<T>> materialize() {
        return C13774a.m43821a((C13797m<T>) new C13682za<T>(this));
    }

    public final C13797m<T> mergeWith(C13802r<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return merge((C13802r<? extends T>) this, other);
    }

    public final C13797m<T> mergeWith(C13814z<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13323Ca<T>(this, other));
    }

    public final C13797m<T> mergeWith(C13794j<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13315Ba<T>(this, other));
    }

    public final C13797m<T> mergeWith(C13215d other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13308Aa<T>(this, other));
    }

    public final C13797m<T> observeOn(C13805u scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    public final C13797m<T> observeOn(C13805u scheduler, boolean delayError) {
        return observeOn(scheduler, delayError, bufferSize());
    }

    public final C13797m<T> observeOn(C13805u scheduler, boolean delayError, int bufferSize) {
        C13264b.m43226a(scheduler, "scheduler is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13774a.m43821a((C13797m<T>) new C13338Ea<T>(this, scheduler, delayError, bufferSize));
    }

    public final <U> C13797m<U> ofType(Class<U> clazz) {
        C13264b.m43226a(clazz, "clazz is null");
        return filter(C13226a.m43195b(clazz)).cast(clazz);
    }

    public final C13797m<T> onErrorResumeNext(C13212n<? super Throwable, ? extends C13802r<? extends T>> resumeFunction) {
        C13264b.m43226a(resumeFunction, "resumeFunction is null");
        return C13774a.m43821a((C13797m<T>) new C13344Fa<T>(this, resumeFunction, false));
    }

    public final C13797m<T> onErrorResumeNext(C13802r<? extends T> next) {
        C13264b.m43226a(next, "next is null");
        return onErrorResumeNext(C13226a.m43198c(next));
    }

    public final C13797m<T> onErrorReturn(C13212n<? super Throwable, ? extends T> valueSupplier) {
        C13264b.m43226a(valueSupplier, "valueSupplier is null");
        return C13774a.m43821a((C13797m<T>) new C13356Ga<T>(this, valueSupplier));
    }

    public final C13797m<T> onErrorReturnItem(T item) {
        C13264b.m43226a(item, "item is null");
        return onErrorReturn(C13226a.m43198c(item));
    }

    public final C13797m<T> onExceptionResumeNext(C13802r<? extends T> next) {
        C13264b.m43226a(next, "next is null");
        return C13774a.m43821a((C13797m<T>) new C13344Fa<T>(this, C13226a.m43198c(next), true));
    }

    public final C13797m<T> onTerminateDetach() {
        return C13774a.m43821a((C13797m<T>) new C13383J<T>(this));
    }

    public final C13762a<T> publish() {
        return C13364Ha.m43308a((C13802r<T>) this);
    }

    public final <R> C13797m<R> publish(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector) {
        C13264b.m43226a(selector, "selector is null");
        return C13774a.m43821a((C13797m<T>) new C13377Ia<T>(this, selector));
    }

    public final C13775h<T> reduce(C13201c<T, T, T> reducer) {
        C13264b.m43226a(reducer, "reducer is null");
        return C13774a.m43819a((C13775h<T>) new C13400La<T>(this, reducer));
    }

    public final <R> C13810v<R> reduce(R seed, C13201c<R, ? super T, R> reducer) {
        C13264b.m43226a(seed, "seed is null");
        C13264b.m43226a(reducer, "reducer is null");
        return C13774a.m43826a((C13810v<T>) new C13406Ma<T>(this, seed, reducer));
    }

    public final <R> C13810v<R> reduceWith(Callable<R> seedSupplier, C13201c<R, ? super T, R> reducer) {
        C13264b.m43226a(seedSupplier, "seedSupplier is null");
        C13264b.m43226a(reducer, "reducer is null");
        return C13774a.m43826a((C13810v<T>) new C13411Na<T>(this, seedSupplier, reducer));
    }

    public final C13797m<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final C13797m<T> repeat(long times) {
        if (times < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("times >= 0 required but it was ");
            sb.append(times);
            throw new IllegalArgumentException(sb.toString());
        } else if (times == 0) {
            return empty();
        } else {
            return C13774a.m43821a((C13797m<T>) new C13419Pa<T>(this, times));
        }
    }

    public final C13797m<T> repeatUntil(C13203e stop) {
        C13264b.m43226a(stop, "stop is null");
        return C13774a.m43821a((C13797m<T>) new C13423Qa<T>(this, stop));
    }

    public final C13797m<T> repeatWhen(C13212n<? super C13797m<Object>, ? extends C13802r<?>> handler) {
        C13264b.m43226a(handler, "handler is null");
        return C13774a.m43821a((C13797m<T>) new C13425Ra<T>(this, handler));
    }

    public final C13762a<T> replay() {
        return C13430Sa.m43366a((C13802r<? extends T>) this);
    }

    public final <R> C13797m<R> replay(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector) {
        C13264b.m43226a(selector, "selector is null");
        return C13430Sa.m43371a(C13595pa.m43565a(this), selector);
    }

    public final <R> C13797m<R> replay(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector, int bufferSize) {
        C13264b.m43226a(selector, "selector is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13430Sa.m43371a(C13595pa.m43566a(this, bufferSize), selector);
    }

    public final <R> C13797m<R> replay(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector, int bufferSize, long time, TimeUnit unit) {
        return replay(selector, bufferSize, time, unit, C13777b.m43846a());
    }

    public final <R> C13797m<R> replay(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector, int bufferSize, long time, TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(selector, "selector is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13430Sa.m43371a(C13595pa.m43567a(this, bufferSize, time, unit, scheduler), selector);
    }

    public final <R> C13797m<R> replay(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector, int bufferSize, C13805u scheduler) {
        C13264b.m43226a(selector, "selector is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13430Sa.m43371a(C13595pa.m43566a(this, bufferSize), C13595pa.m43563a(selector, scheduler));
    }

    public final <R> C13797m<R> replay(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector, long time, TimeUnit unit) {
        return replay(selector, time, unit, C13777b.m43846a());
    }

    public final <R> C13797m<R> replay(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector, long time, TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(selector, "selector is null");
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13430Sa.m43371a(C13595pa.m43568a(this, time, unit, scheduler), selector);
    }

    public final <R> C13797m<R> replay(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector, C13805u scheduler) {
        C13264b.m43226a(selector, "selector is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13430Sa.m43371a(C13595pa.m43565a(this), C13595pa.m43563a(selector, scheduler));
    }

    public final C13762a<T> replay(int bufferSize) {
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13430Sa.m43367a((C13802r<T>) this, bufferSize);
    }

    public final C13762a<T> replay(int bufferSize, long time, TimeUnit unit) {
        return replay(bufferSize, time, unit, C13777b.m43846a());
    }

    public final C13762a<T> replay(int bufferSize, long time, TimeUnit unit, C13805u scheduler) {
        C13264b.m43222a(bufferSize, "bufferSize");
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13430Sa.m43369a(this, time, unit, scheduler, bufferSize);
    }

    public final C13762a<T> replay(int bufferSize, C13805u scheduler) {
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13430Sa.m43365a(replay(bufferSize), scheduler);
    }

    public final C13762a<T> replay(long time, TimeUnit unit) {
        return replay(time, unit, C13777b.m43846a());
    }

    public final C13762a<T> replay(long time, TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13430Sa.m43368a(this, time, unit, scheduler);
    }

    public final C13762a<T> replay(C13805u scheduler) {
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13430Sa.m43365a(replay(), scheduler);
    }

    public final C13797m<T> retry() {
        return retry(Long.MAX_VALUE, C13226a.m43194b());
    }

    public final C13797m<T> retry(C13202d<? super Integer, ? super Throwable> predicate) {
        C13264b.m43226a(predicate, "predicate is null");
        return C13774a.m43821a((C13797m<T>) new C13449Ta<T>(this, predicate));
    }

    public final C13797m<T> retry(long times) {
        return retry(times, C13226a.m43194b());
    }

    public final C13797m<T> retry(long times, C13214p<? super Throwable> predicate) {
        if (times >= 0) {
            C13264b.m43226a(predicate, "predicate is null");
            return C13774a.m43821a((C13797m<T>) new C13452Ua<T>(this, times, predicate));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("times >= 0 required but it was ");
        sb.append(times);
        throw new IllegalArgumentException(sb.toString());
    }

    public final C13797m<T> retry(C13214p<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    public final C13797m<T> retryUntil(C13203e stop) {
        C13264b.m43226a(stop, "stop is null");
        return retry(Long.MAX_VALUE, C13226a.m43190a(stop));
    }

    public final C13797m<T> retryWhen(C13212n<? super C13797m<Throwable>, ? extends C13802r<?>> handler) {
        C13264b.m43226a(handler, "handler is null");
        return C13774a.m43821a((C13797m<T>) new C13455Va<T>(this, handler));
    }

    public final void safeSubscribe(C13804t<? super T> s) {
        C13264b.m43226a(s, "s is null");
        if (s instanceof C13769e) {
            subscribe(s);
        } else {
            subscribe((C13804t<? super T>) new C13769e<Object>(s));
        }
    }

    public final C13797m<T> sample(long period, TimeUnit unit) {
        return sample(period, unit, C13777b.m43846a());
    }

    public final C13797m<T> sample(long period, TimeUnit unit, boolean emitLast) {
        return sample(period, unit, C13777b.m43846a(), emitLast);
    }

    public final C13797m<T> sample(long period, TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13460Wa wa = new C13460Wa(this, period, unit, scheduler, false);
        return C13774a.m43821a((C13797m<T>) wa);
    }

    public final C13797m<T> sample(long period, TimeUnit unit, C13805u scheduler, boolean emitLast) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13460Wa wa = new C13460Wa(this, period, unit, scheduler, emitLast);
        return C13774a.m43821a((C13797m<T>) wa);
    }

    public final <U> C13797m<T> sample(C13802r<U> sampler) {
        C13264b.m43226a(sampler, "sampler is null");
        return C13774a.m43821a((C13797m<T>) new C13467Xa<T>(this, sampler, false));
    }

    public final <U> C13797m<T> sample(C13802r<U> sampler, boolean emitLast) {
        C13264b.m43226a(sampler, "sampler is null");
        return C13774a.m43821a((C13797m<T>) new C13467Xa<T>(this, sampler, emitLast));
    }

    public final C13797m<T> scan(C13201c<T, T, T> accumulator) {
        C13264b.m43226a(accumulator, "accumulator is null");
        return C13774a.m43821a((C13797m<T>) new C13481Za<T>(this, accumulator));
    }

    public final <R> C13797m<R> scan(R initialValue, C13201c<R, ? super T, R> accumulator) {
        C13264b.m43226a(initialValue, "seed is null");
        return scanWith(C13226a.m43196b(initialValue), accumulator);
    }

    public final <R> C13797m<R> scanWith(Callable<R> seedSupplier, C13201c<R, ? super T, R> accumulator) {
        C13264b.m43226a(seedSupplier, "seedSupplier is null");
        C13264b.m43226a(accumulator, "accumulator is null");
        return C13774a.m43821a((C13797m<T>) new C13483_a<T>(this, seedSupplier, accumulator));
    }

    public final C13797m<T> serialize() {
        return C13774a.m43821a((C13797m<T>) new C13504cb<T>(this));
    }

    public final C13797m<T> share() {
        return publish().mo42778a();
    }

    public final C13775h<T> singleElement() {
        return C13774a.m43819a((C13775h<T>) new C13510db<T>(this));
    }

    public final C13810v<T> single(T defaultItem) {
        C13264b.m43226a(defaultItem, "defaultItem is null");
        return C13774a.m43826a((C13810v<T>) new C13516eb<T>(this, defaultItem));
    }

    public final C13810v<T> singleOrError() {
        return C13774a.m43826a((C13810v<T>) new C13516eb<T>(this, null));
    }

    public final C13797m<T> skip(long count) {
        if (count <= 0) {
            return C13774a.m43821a(this);
        }
        return C13774a.m43821a((C13797m<T>) new C13521fb<T>(this, count));
    }

    public final C13797m<T> skip(long time, TimeUnit unit) {
        return skipUntil(timer(time, unit));
    }

    public final C13797m<T> skip(long time, TimeUnit unit, C13805u scheduler) {
        return skipUntil(timer(time, unit, scheduler));
    }

    public final C13797m<T> skipLast(int count) {
        if (count < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(count);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (count == 0) {
            return C13774a.m43821a(this);
        } else {
            return C13774a.m43821a((C13797m<T>) new C13527gb<T>(this, count));
        }
    }

    public final C13797m<T> skipLast(long time, TimeUnit unit) {
        return skipLast(time, unit, C13777b.m43849d(), false, bufferSize());
    }

    public final C13797m<T> skipLast(long time, TimeUnit unit, boolean delayError) {
        return skipLast(time, unit, C13777b.m43849d(), delayError, bufferSize());
    }

    public final C13797m<T> skipLast(long time, TimeUnit unit, C13805u scheduler) {
        return skipLast(time, unit, scheduler, false, bufferSize());
    }

    public final C13797m<T> skipLast(long time, TimeUnit unit, C13805u scheduler, boolean delayError) {
        return skipLast(time, unit, scheduler, delayError, bufferSize());
    }

    public final C13797m<T> skipLast(long time, TimeUnit unit, C13805u scheduler, boolean delayError, int bufferSize) {
        int i = bufferSize;
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13264b.m43222a(i, "bufferSize");
        C13534hb hbVar = new C13534hb(this, time, unit, scheduler, i << 1, delayError);
        return C13774a.m43821a((C13797m<T>) hbVar);
    }

    public final <U> C13797m<T> skipUntil(C13802r<U> other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13539ib<T>(this, other));
    }

    public final C13797m<T> skipWhile(C13214p<? super T> predicate) {
        C13264b.m43226a(predicate, "predicate is null");
        return C13774a.m43821a((C13797m<T>) new C13546jb<T>(this, predicate));
    }

    public final C13797m<T> sorted() {
        return toList().mo43159c().map(C13226a.m43187a(C13226a.m43202f())).flatMapIterable(C13226a.m43201e());
    }

    public final C13797m<T> sorted(Comparator<? super T> sortFunction) {
        C13264b.m43226a(sortFunction, "sortFunction is null");
        return toList().mo43159c().map(C13226a.m43187a(sortFunction)).flatMapIterable(C13226a.m43201e());
    }

    public final C13797m<T> startWith(Iterable<? extends T> items) {
        return concatArray(fromIterable(items), this);
    }

    public final C13797m<T> startWith(C13802r<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return concatArray(other, this);
    }

    public final C13797m<T> startWith(T item) {
        C13264b.m43226a(item, "item is null");
        return concatArray(just(item), this);
    }

    public final C13797m<T> startWithArray(T... items) {
        Observable<T> fromArray = fromArray(items);
        if (fromArray == empty()) {
            return C13774a.m43821a(this);
        }
        return concatArray(fromArray, this);
    }

    public final C13194b subscribe() {
        return subscribe(C13226a.m43200d(), C13226a.f40315f, C13226a.f40312c, C13226a.m43200d());
    }

    public final C13194b subscribe(C13204f<? super T> onNext) {
        return subscribe(onNext, C13226a.f40315f, C13226a.f40312c, C13226a.m43200d());
    }

    public final C13194b subscribe(C13204f<? super T> onNext, C13204f<? super Throwable> onError) {
        return subscribe(onNext, onError, C13226a.f40312c, C13226a.m43200d());
    }

    public final C13194b subscribe(C13204f<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete) {
        return subscribe(onNext, onError, onComplete, C13226a.m43200d());
    }

    public final C13194b subscribe(C13204f<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete, C13204f<? super C13194b> onSubscribe) {
        C13264b.m43226a(onNext, "onNext is null");
        C13264b.m43226a(onError, "onError is null");
        C13264b.m43226a(onComplete, "onComplete is null");
        C13264b.m43226a(onSubscribe, "onSubscribe is null");
        LambdaObserver<T> ls = new C13290p<>(onNext, onError, onComplete, onSubscribe);
        subscribe((C13804t<? super T>) ls);
        return ls;
    }

    public final void subscribe(C13804t<? super T> observer) {
        C13264b.m43226a(observer, "observer is null");
        try {
            C13804t a = C13774a.m43822a(this, observer);
            C13264b.m43226a(a, "Plugin returned null Observer");
            subscribeActual(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable e2) {
            C13980a.m44462b(e2);
            C13774a.m43836b(e2);
            NullPointerException npe = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            npe.initCause(e2);
            throw npe;
        }
    }

    public final <E extends C13804t<? super T>> E subscribeWith(E observer) {
        subscribe((C13804t<? super T>) observer);
        return observer;
    }

    public final C13797m<T> subscribeOn(C13805u scheduler) {
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13774a.m43821a((C13797m<T>) new C13553kb<T>(this, scheduler));
    }

    public final C13797m<T> switchIfEmpty(C13802r<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13564lb<T>(this, other));
    }

    public final <R> C13797m<R> switchMap(C13212n<? super T, ? extends C13802r<? extends R>> mapper) {
        return switchMap(mapper, bufferSize());
    }

    public final <R> C13797m<R> switchMap(C13212n<? super T, ? extends C13802r<? extends R>> mapper, int bufferSize) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        if (!(this instanceof C13272g)) {
            return C13774a.m43821a((C13797m<T>) new C13572mb<T>(this, mapper, bufferSize, false));
        }
        T v = ((C13272g) this).call();
        if (v == null) {
            return empty();
        }
        return C13475Ya.m43449a(v, mapper);
    }

    public final <R> C13797m<R> switchMapSingle(C13212n<? super T, ? extends C13814z<? extends R>> mapper) {
        return C13595pa.m43564a(this, mapper);
    }

    public final <R> C13797m<R> switchMapSingleDelayError(C13212n<? super T, ? extends C13814z<? extends R>> mapper) {
        return C13595pa.m43571b(this, mapper);
    }

    public final <R> C13797m<R> switchMapDelayError(C13212n<? super T, ? extends C13802r<? extends R>> mapper) {
        return switchMapDelayError(mapper, bufferSize());
    }

    public final <R> C13797m<R> switchMapDelayError(C13212n<? super T, ? extends C13802r<? extends R>> mapper, int bufferSize) {
        C13264b.m43226a(mapper, "mapper is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        if (!(this instanceof C13272g)) {
            return C13774a.m43821a((C13797m<T>) new C13572mb<T>(this, mapper, bufferSize, true));
        }
        T v = ((C13272g) this).call();
        if (v == null) {
            return empty();
        }
        return C13475Ya.m43449a(v, mapper);
    }

    public final C13797m<T> take(long count) {
        if (count >= 0) {
            return C13774a.m43821a((C13797m<T>) new C13580nb<T>(this, count));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("count >= 0 required but it was ");
        sb.append(count);
        throw new IllegalArgumentException(sb.toString());
    }

    public final C13797m<T> take(long time, TimeUnit unit) {
        return takeUntil((C13802r<U>) timer(time, unit));
    }

    public final C13797m<T> take(long time, TimeUnit unit, C13805u scheduler) {
        return takeUntil((C13802r<U>) timer(time, unit, scheduler));
    }

    public final C13797m<T> takeLast(int count) {
        if (count < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count >= 0 required but it was ");
            sb.append(count);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (count == 0) {
            return C13774a.m43821a((C13797m<T>) new C13578na<T>(this));
        } else {
            if (count == 1) {
                return C13774a.m43821a((C13797m<T>) new C13612pb<T>(this));
            }
            return C13774a.m43821a((C13797m<T>) new C13587ob<T>(this, count));
        }
    }

    public final C13797m<T> takeLast(long count, long time, TimeUnit unit) {
        return takeLast(count, time, unit, C13777b.m43849d(), false, bufferSize());
    }

    public final C13797m<T> takeLast(long count, long time, TimeUnit unit, C13805u scheduler) {
        return takeLast(count, time, unit, scheduler, false, bufferSize());
    }

    public final C13797m<T> takeLast(long count, long time, TimeUnit unit, C13805u scheduler, boolean delayError, int bufferSize) {
        long j = count;
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        if (j >= 0) {
            C13619qb qbVar = new C13619qb(this, count, time, unit, scheduler, bufferSize, delayError);
            return C13774a.m43821a((C13797m<T>) qbVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("count >= 0 required but it was ");
        sb.append(j);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final C13797m<T> takeLast(long time, TimeUnit unit) {
        return takeLast(time, unit, C13777b.m43849d(), false, bufferSize());
    }

    public final C13797m<T> takeLast(long time, TimeUnit unit, boolean delayError) {
        return takeLast(time, unit, C13777b.m43849d(), delayError, bufferSize());
    }

    public final C13797m<T> takeLast(long time, TimeUnit unit, C13805u scheduler) {
        return takeLast(time, unit, scheduler, false, bufferSize());
    }

    public final C13797m<T> takeLast(long time, TimeUnit unit, C13805u scheduler, boolean delayError) {
        return takeLast(time, unit, scheduler, delayError, bufferSize());
    }

    public final C13797m<T> takeLast(long time, TimeUnit unit, C13805u scheduler, boolean delayError, int bufferSize) {
        return takeLast(Long.MAX_VALUE, time, unit, scheduler, delayError, bufferSize);
    }

    public final <U> C13797m<T> takeUntil(C13802r<U> other) {
        C13264b.m43226a(other, "other is null");
        return C13774a.m43821a((C13797m<T>) new C13625rb<T>(this, other));
    }

    public final C13797m<T> takeUntil(C13214p<? super T> stopPredicate) {
        C13264b.m43226a(stopPredicate, "predicate is null");
        return C13774a.m43821a((C13797m<T>) new C13632sb<T>(this, stopPredicate));
    }

    public final C13797m<T> takeWhile(C13214p<? super T> predicate) {
        C13264b.m43226a(predicate, "predicate is null");
        return C13774a.m43821a((C13797m<T>) new C13638tb<T>(this, predicate));
    }

    public final C13797m<T> throttleFirst(long windowDuration, TimeUnit unit) {
        return throttleFirst(windowDuration, unit, C13777b.m43846a());
    }

    public final C13797m<T> throttleFirst(long skipDuration, TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13647ub ubVar = new C13647ub(this, skipDuration, unit, scheduler);
        return C13774a.m43821a((C13797m<T>) ubVar);
    }

    public final C13797m<T> throttleLast(long intervalDuration, TimeUnit unit) {
        return sample(intervalDuration, unit);
    }

    public final C13797m<T> throttleLast(long intervalDuration, TimeUnit unit, C13805u scheduler) {
        return sample(intervalDuration, unit, scheduler);
    }

    public final C13797m<T> throttleWithTimeout(long timeout, TimeUnit unit) {
        return debounce(timeout, unit);
    }

    public final C13797m<T> throttleWithTimeout(long timeout, TimeUnit unit, C13805u scheduler) {
        return debounce(timeout, unit, scheduler);
    }

    public final C13797m<C13786c<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, C13777b.m43846a());
    }

    public final C13797m<C13786c<T>> timeInterval(C13805u scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    public final C13797m<C13786c<T>> timeInterval(TimeUnit unit) {
        return timeInterval(unit, C13777b.m43846a());
    }

    public final C13797m<C13786c<T>> timeInterval(TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13774a.m43821a((C13797m<T>) new C13654vb<T>(this, unit, scheduler));
    }

    public final <V> C13797m<T> timeout(C13212n<? super T, ? extends C13802r<V>> itemTimeoutIndicator) {
        return timeout0(null, itemTimeoutIndicator, null);
    }

    public final <V> C13797m<T> timeout(C13212n<? super T, ? extends C13802r<V>> itemTimeoutIndicator, C13802r<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return timeout0(null, itemTimeoutIndicator, other);
    }

    public final C13797m<T> timeout(long timeout, TimeUnit timeUnit) {
        return timeout0(timeout, timeUnit, null, C13777b.m43846a());
    }

    public final C13797m<T> timeout(long timeout, TimeUnit timeUnit, C13802r<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return timeout0(timeout, timeUnit, other, C13777b.m43846a());
    }

    public final C13797m<T> timeout(long timeout, TimeUnit timeUnit, C13805u scheduler, C13802r<? extends T> other) {
        C13264b.m43226a(other, "other is null");
        return timeout0(timeout, timeUnit, other, scheduler);
    }

    public final C13797m<T> timeout(long timeout, TimeUnit timeUnit, C13805u scheduler) {
        return timeout0(timeout, timeUnit, null, scheduler);
    }

    public final <U, V> C13797m<T> timeout(C13802r<U> firstTimeoutIndicator, C13212n<? super T, ? extends C13802r<V>> itemTimeoutIndicator) {
        C13264b.m43226a(firstTimeoutIndicator, "firstTimeoutIndicator is null");
        return timeout0(firstTimeoutIndicator, itemTimeoutIndicator, null);
    }

    public final <U, V> C13797m<T> timeout(C13802r<U> firstTimeoutIndicator, C13212n<? super T, ? extends C13802r<V>> itemTimeoutIndicator, C13802r<? extends T> other) {
        C13264b.m43226a(firstTimeoutIndicator, "firstTimeoutIndicator is null");
        C13264b.m43226a(other, "other is null");
        return timeout0(firstTimeoutIndicator, itemTimeoutIndicator, other);
    }

    private C13797m<T> timeout0(long timeout, TimeUnit timeUnit, C13802r<? extends T> other, C13805u scheduler) {
        C13264b.m43226a(timeUnit, "timeUnit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13668xb xbVar = new C13668xb(this, timeout, timeUnit, scheduler, other);
        return C13774a.m43821a((C13797m<T>) xbVar);
    }

    private <U, V> C13797m<T> timeout0(C13802r<U> firstTimeoutIndicator, C13212n<? super T, ? extends C13802r<V>> itemTimeoutIndicator, C13802r<? extends T> other) {
        C13264b.m43226a(itemTimeoutIndicator, "itemTimeoutIndicator is null");
        return C13774a.m43821a((C13797m<T>) new C13659wb<T>(this, firstTimeoutIndicator, itemTimeoutIndicator, other));
    }

    public final C13797m<C13786c<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, C13777b.m43846a());
    }

    public final C13797m<C13786c<T>> timestamp(C13805u scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    public final C13797m<C13786c<T>> timestamp(TimeUnit unit) {
        return timestamp(unit, C13777b.m43846a());
    }

    public final C13797m<C13786c<T>> timestamp(TimeUnit unit, C13805u scheduler) {
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43226a(scheduler, "scheduler is null");
        return map(C13226a.m43188a(unit, scheduler));
    }

    /* renamed from: to */
    public final <R> R mo43097to(C13212n<? super C13797m<T>, R> converter) {
        try {
            C13264b.m43226a(converter, "converter is null");
            return converter.apply(this);
        } catch (Throwable ex) {
            C13980a.m44462b(ex);
            throw C13748j.m43761a(ex);
        }
    }

    public final C13810v<List<T>> toList() {
        return toList(16);
    }

    public final C13810v<List<T>> toList(int capacityHint) {
        C13264b.m43222a(capacityHint, "capacityHint");
        return C13774a.m43826a((C13810v<T>) new C13311Ab<T>((C13802r<T>) this, capacityHint));
    }

    public final <U extends Collection<? super T>> C13810v<U> toList(Callable<U> collectionSupplier) {
        C13264b.m43226a(collectionSupplier, "collectionSupplier is null");
        return C13774a.m43826a((C13810v<T>) new C13311Ab<T>((C13802r<T>) this, collectionSupplier));
    }

    public final <K> C13810v<Map<K, T>> toMap(C13212n<? super T, ? extends K> keySelector) {
        C13264b.m43226a(keySelector, "keySelector is null");
        return collect(C13751l.m43770e(), C13226a.m43174a(keySelector));
    }

    public final <K, V> C13810v<Map<K, V>> toMap(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector) {
        C13264b.m43226a(keySelector, "keySelector is null");
        C13264b.m43226a(valueSelector, "valueSelector is null");
        return collect(C13751l.m43770e(), C13226a.m43175a(keySelector, valueSelector));
    }

    public final <K, V> C13810v<Map<K, V>> toMap(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector, Callable<? extends Map<K, V>> mapSupplier) {
        C13264b.m43226a(keySelector, "keySelector is null");
        C13264b.m43226a(valueSelector, "valueSelector is null");
        C13264b.m43226a(mapSupplier, "mapSupplier is null");
        return collect(mapSupplier, C13226a.m43175a(keySelector, valueSelector));
    }

    public final <K> C13810v<Map<K, Collection<T>>> toMultimap(C13212n<? super T, ? extends K> keySelector) {
        return toMultimap(keySelector, C13226a.m43201e(), C13751l.m43770e(), C13740b.m43746f());
    }

    public final <K, V> C13810v<Map<K, Collection<V>>> toMultimap(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector) {
        return toMultimap(keySelector, valueSelector, C13751l.m43770e(), C13740b.m43746f());
    }

    public final <K, V> C13810v<Map<K, Collection<V>>> toMultimap(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector, Callable<? extends Map<K, Collection<V>>> mapSupplier, C13212n<? super K, ? extends Collection<? super V>> collectionFactory) {
        C13264b.m43226a(keySelector, "keySelector is null");
        C13264b.m43226a(valueSelector, "valueSelector is null");
        C13264b.m43226a(mapSupplier, "mapSupplier is null");
        C13264b.m43226a(collectionFactory, "collectionFactory is null");
        return collect(mapSupplier, C13226a.m43176a(keySelector, valueSelector, collectionFactory));
    }

    public final <K, V> C13810v<Map<K, Collection<V>>> toMultimap(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector, Callable<Map<K, Collection<V>>> mapSupplier) {
        return toMultimap(keySelector, valueSelector, mapSupplier, C13740b.m43746f());
    }

    public final C13764f<T> toFlowable(C13184a strategy) {
        Flowable<T> o = new C13296b<>(this);
        int i = C13796l.f41958a[strategy.ordinal()];
        if (i == 1) {
            return o.mo42783c();
        }
        if (i == 2) {
            return o.mo42784d();
        }
        if (i == 3) {
            return o;
        }
        if (i != 4) {
            return o.mo42782b();
        }
        return C13774a.m43818a((C13764f<T>) new C13302e<T>(o));
    }

    public final C13810v<List<T>> toSortedList() {
        return toSortedList(C13226a.m43203g());
    }

    public final C13810v<List<T>> toSortedList(Comparator<? super T> comparator) {
        C13264b.m43226a(comparator, "comparator is null");
        return toList().mo43154a(C13226a.m43187a(comparator));
    }

    public final C13810v<List<T>> toSortedList(Comparator<? super T> comparator, int capacityHint) {
        C13264b.m43226a(comparator, "comparator is null");
        return toList(capacityHint).mo43154a(C13226a.m43187a(comparator));
    }

    public final C13810v<List<T>> toSortedList(int capacityHint) {
        return toSortedList(C13226a.m43203g(), capacityHint);
    }

    public final C13797m<T> unsubscribeOn(C13805u scheduler) {
        C13264b.m43226a(scheduler, "scheduler is null");
        return C13774a.m43821a((C13797m<T>) new C13318Bb<T>(this, scheduler));
    }

    public final C13797m<C13797m<T>> window(long count) {
        return window(count, count, bufferSize());
    }

    public final C13797m<C13797m<T>> window(long count, long skip) {
        return window(count, skip, bufferSize());
    }

    public final C13797m<C13797m<T>> window(long count, long skip, int bufferSize) {
        C13264b.m43224a(count, "count");
        C13264b.m43224a(skip, "skip");
        C13264b.m43222a(bufferSize, "bufferSize");
        C13332Db db = new C13332Db(this, count, skip, bufferSize);
        return C13774a.m43821a((C13797m<T>) db);
    }

    public final C13797m<C13797m<T>> window(long timespan, long timeskip, TimeUnit unit) {
        return window(timespan, timeskip, unit, C13777b.m43846a(), bufferSize());
    }

    public final C13797m<C13797m<T>> window(long timespan, long timeskip, TimeUnit unit, C13805u scheduler) {
        return window(timespan, timeskip, unit, scheduler, bufferSize());
    }

    public final C13797m<C13797m<T>> window(long timespan, long timeskip, TimeUnit unit, C13805u scheduler, int bufferSize) {
        C13264b.m43224a(timespan, "timespan");
        C13264b.m43224a(timeskip, "timeskip");
        C13264b.m43222a(bufferSize, "bufferSize");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13264b.m43226a(unit, "unit is null");
        C13368Hb hb = new C13368Hb(this, timespan, timeskip, unit, scheduler, Long.MAX_VALUE, bufferSize, false);
        return C13774a.m43821a((C13797m<T>) hb);
    }

    public final C13797m<C13797m<T>> window(long timespan, TimeUnit unit) {
        return window(timespan, unit, C13777b.m43846a(), Long.MAX_VALUE, false);
    }

    public final C13797m<C13797m<T>> window(long timespan, TimeUnit unit, long count) {
        return window(timespan, unit, C13777b.m43846a(), count, false);
    }

    public final C13797m<C13797m<T>> window(long timespan, TimeUnit unit, long count, boolean restart) {
        return window(timespan, unit, C13777b.m43846a(), count, restart);
    }

    public final C13797m<C13797m<T>> window(long timespan, TimeUnit unit, C13805u scheduler) {
        return window(timespan, unit, scheduler, Long.MAX_VALUE, false);
    }

    public final C13797m<C13797m<T>> window(long timespan, TimeUnit unit, C13805u scheduler, long count) {
        return window(timespan, unit, scheduler, count, false);
    }

    public final C13797m<C13797m<T>> window(long timespan, TimeUnit unit, C13805u scheduler, long count, boolean restart) {
        return window(timespan, unit, scheduler, count, restart, bufferSize());
    }

    public final C13797m<C13797m<T>> window(long timespan, TimeUnit unit, C13805u scheduler, long count, boolean restart, int bufferSize) {
        C13264b.m43222a(bufferSize, "bufferSize");
        C13264b.m43226a(scheduler, "scheduler is null");
        C13264b.m43226a(unit, "unit is null");
        C13264b.m43224a(count, "count");
        C13368Hb hb = new C13368Hb(this, timespan, timespan, unit, scheduler, count, bufferSize, restart);
        return C13774a.m43821a((C13797m<T>) hb);
    }

    public final <B> C13797m<C13797m<T>> window(C13802r<B> boundary) {
        return window(boundary, bufferSize());
    }

    public final <B> C13797m<C13797m<T>> window(C13802r<B> boundary, int bufferSize) {
        C13264b.m43226a(boundary, "boundary is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13774a.m43821a((C13797m<T>) new C13340Eb<T>(this, boundary, bufferSize));
    }

    public final <U, V> C13797m<C13797m<T>> window(C13802r<U> openingIndicator, C13212n<? super U, ? extends C13802r<V>> closingIndicator) {
        return window(openingIndicator, closingIndicator, bufferSize());
    }

    public final <U, V> C13797m<C13797m<T>> window(C13802r<U> openingIndicator, C13212n<? super U, ? extends C13802r<V>> closingIndicator, int bufferSize) {
        C13264b.m43226a(openingIndicator, "openingIndicator is null");
        C13264b.m43226a(closingIndicator, "closingIndicator is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13774a.m43821a((C13797m<T>) new C13346Fb<T>(this, openingIndicator, closingIndicator, bufferSize));
    }

    public final <B> C13797m<C13797m<T>> window(Callable<? extends C13802r<B>> boundary) {
        return window(boundary, bufferSize());
    }

    public final <B> C13797m<C13797m<T>> window(Callable<? extends C13802r<B>> boundary, int bufferSize) {
        C13264b.m43226a(boundary, "boundary is null");
        C13264b.m43222a(bufferSize, "bufferSize");
        return C13774a.m43821a((C13797m<T>) new C13358Gb<T>(this, boundary, bufferSize));
    }

    public final <U, R> C13797m<R> withLatestFrom(C13802r<? extends U> other, C13201c<? super T, ? super U, ? extends R> combiner) {
        C13264b.m43226a(other, "other is null");
        C13264b.m43226a(combiner, "combiner is null");
        return C13774a.m43821a((C13797m<T>) new C13380Ib<T>(this, combiner, other));
    }

    public final <T1, T2, R> C13797m<R> withLatestFrom(C13802r<T1> o1, C13802r<T2> o2, C13205g<? super T, ? super T1, ? super T2, R> combiner) {
        C13264b.m43226a(o1, "o1 is null");
        C13264b.m43226a(o2, "o2 is null");
        C13264b.m43226a(combiner, "combiner is null");
        return withLatestFrom((C13802r<?>[]) new C13802r[]{o1, o2}, (C13212n<? super Object[], R>) C13226a.m43179a(combiner));
    }

    public final <T1, T2, T3, R> C13797m<R> withLatestFrom(C13802r<T1> o1, C13802r<T2> o2, C13802r<T3> o3, C13206h<? super T, ? super T1, ? super T2, ? super T3, R> combiner) {
        C13264b.m43226a(o1, "o1 is null");
        C13264b.m43226a(o2, "o2 is null");
        C13264b.m43226a(o3, "o3 is null");
        C13264b.m43226a(combiner, "combiner is null");
        return withLatestFrom((C13802r<?>[]) new C13802r[]{o1, o2, o3}, (C13212n<? super Object[], R>) C13226a.m43180a(combiner));
    }

    public final <T1, T2, T3, T4, R> C13797m<R> withLatestFrom(C13802r<T1> o1, C13802r<T2> o2, C13802r<T3> o3, C13802r<T4> o4, C13207i<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> combiner) {
        C13264b.m43226a(o1, "o1 is null");
        C13264b.m43226a(o2, "o2 is null");
        C13264b.m43226a(o3, "o3 is null");
        C13264b.m43226a(o4, "o4 is null");
        C13264b.m43226a(combiner, "combiner is null");
        return withLatestFrom((C13802r<?>[]) new C13802r[]{o1, o2, o3, o4}, (C13212n<? super Object[], R>) C13226a.m43181a(combiner));
    }

    public final <R> C13797m<R> withLatestFrom(C13802r<?>[] others, C13212n<? super Object[], R> combiner) {
        C13264b.m43226a(others, "others is null");
        C13264b.m43226a(combiner, "combiner is null");
        return C13774a.m43821a((C13797m<T>) new C13387Jb<T>((C13802r<T>) this, others, combiner));
    }

    public final <R> C13797m<R> withLatestFrom(Iterable<? extends C13802r<?>> others, C13212n<? super Object[], R> combiner) {
        C13264b.m43226a(others, "others is null");
        C13264b.m43226a(combiner, "combiner is null");
        return C13774a.m43821a((C13797m<T>) new C13387Jb<T>((C13802r<T>) this, others, combiner));
    }

    public final <U, R> C13797m<R> zipWith(Iterable<U> other, C13201c<? super T, ? super U, ? extends R> zipper) {
        C13264b.m43226a(other, "other is null");
        C13264b.m43226a(zipper, "zipper is null");
        return C13774a.m43821a((C13797m<T>) new C13402Lb<T>(this, other, zipper));
    }

    public final <U, R> C13797m<R> zipWith(C13802r<? extends U> other, C13201c<? super T, ? super U, ? extends R> zipper) {
        C13264b.m43226a(other, "other is null");
        return zip(this, other, zipper);
    }

    public final <U, R> C13797m<R> zipWith(C13802r<? extends U> other, C13201c<? super T, ? super U, ? extends R> zipper, boolean delayError) {
        return zip((C13802r<? extends T1>) this, other, zipper, delayError);
    }

    public final <U, R> C13797m<R> zipWith(C13802r<? extends U> other, C13201c<? super T, ? super U, ? extends R> zipper, boolean delayError, int bufferSize) {
        return zip((C13802r<? extends T1>) this, other, zipper, delayError, bufferSize);
    }

    public final C13771g<T> test() {
        TestObserver<T> ts = new C13771g<>();
        subscribe((C13804t<? super T>) ts);
        return ts;
    }

    public final C13771g<T> test(boolean dispose) {
        TestObserver<T> ts = new C13771g<>();
        if (dispose) {
            ts.dispose();
        }
        subscribe((C13804t<? super T>) ts);
        return ts;
    }
}
