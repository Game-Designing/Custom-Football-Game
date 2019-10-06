package com.trello.rxlifecycle.p017b.p018a;

import android.app.Activity;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.View;
import com.trello.rxlifecycle.C0095e;
import com.trello.rxlifecycle.C0096f;
import com.trello.rxlifecycle.C0097g;
import com.trello.rxlifecycle.p263a.C12543b;
import com.trello.rxlifecycle.p263a.C12547f;
import p026rx.C0120S;
import p026rx.p028h.C0134b;

/* renamed from: com.trello.rxlifecycle.b.a.c */
/* compiled from: RxFragment */
public abstract class C0094c extends Fragment implements C0095e<C12543b> {
    private final C0134b<C12543b> lifecycleSubject = C0134b.m768p();

    public final C0120S<C12543b> lifecycle() {
        return this.lifecycleSubject.mo3605a();
    }

    public final <T> C0096f<T> bindUntilEvent(C12543b event) {
        return C0097g.m559a((C0120S<R>) this.lifecycleSubject, event);
    }

    public final <T> C0096f<T> bindToLifecycle() {
        return C12547f.m41052b(this.lifecycleSubject);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.lifecycleSubject.onNext(C12543b.ATTACH);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.lifecycleSubject.onNext(C12543b.CREATE);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.lifecycleSubject.onNext(C12543b.CREATE_VIEW);
    }

    public void onStart() {
        super.onStart();
        this.lifecycleSubject.onNext(C12543b.START);
    }

    public void onResume() {
        super.onResume();
        this.lifecycleSubject.onNext(C12543b.RESUME);
    }

    public void onPause() {
        this.lifecycleSubject.onNext(C12543b.PAUSE);
        super.onPause();
    }

    public void onStop() {
        this.lifecycleSubject.onNext(C12543b.STOP);
        super.onStop();
    }

    public void onDestroyView() {
        this.lifecycleSubject.onNext(C12543b.DESTROY_VIEW);
        super.onDestroyView();
    }

    public void onDestroy() {
        this.lifecycleSubject.onNext(C12543b.DESTROY);
        super.onDestroy();
    }

    public void onDetach() {
        this.lifecycleSubject.onNext(C12543b.DETACH);
        super.onDetach();
    }
}
