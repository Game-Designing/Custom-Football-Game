package com.trello.rxlifecycle.p017b.p018a;

import android.os.Bundle;
import android.support.p001v7.app.C0019n;
import com.trello.rxlifecycle.C0095e;
import com.trello.rxlifecycle.C0096f;
import com.trello.rxlifecycle.C0097g;
import com.trello.rxlifecycle.p263a.C12542a;
import com.trello.rxlifecycle.p263a.C12547f;
import p026rx.C0120S;
import p026rx.p028h.C0134b;

/* renamed from: com.trello.rxlifecycle.b.a.a */
/* compiled from: RxAppCompatActivity */
public abstract class C0093a extends C0019n implements C0095e<C12542a> {
    private final C0134b<C12542a> lifecycleSubject = C0134b.m768p();

    public final C0120S<C12542a> lifecycle() {
        return this.lifecycleSubject.mo3605a();
    }

    public final <T> C0096f<T> bindUntilEvent(C12542a event) {
        return C0097g.m559a((C0120S<R>) this.lifecycleSubject, event);
    }

    public final <T> C0096f<T> bindToLifecycle() {
        return C12547f.m41051a(this.lifecycleSubject);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.lifecycleSubject.onNext(C12542a.CREATE);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.lifecycleSubject.onNext(C12542a.START);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.lifecycleSubject.onNext(C12542a.RESUME);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.lifecycleSubject.onNext(C12542a.PAUSE);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.lifecycleSubject.onNext(C12542a.STOP);
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.lifecycleSubject.onNext(C12542a.DESTROY);
        super.onDestroy();
    }
}
