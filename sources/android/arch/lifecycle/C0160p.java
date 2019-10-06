package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.C0148d.C0000a;
import android.os.Bundle;

/* renamed from: android.arch.lifecycle.p */
/* compiled from: ReportFragment */
public class C0160p extends Fragment {

    /* renamed from: a */
    private C0161a f226a;

    /* renamed from: android.arch.lifecycle.p$a */
    /* compiled from: ReportFragment */
    interface C0161a {
        void onCreate();

        void onResume();

        void onStart();
    }

    /* renamed from: a */
    public static void m869a(Activity activity) {
        FragmentManager manager = activity.getFragmentManager();
        String str = "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag";
        if (manager.findFragmentByTag(str) == null) {
            manager.beginTransaction().add(new C0160p(), str).commit();
            manager.executePendingTransactions();
        }
    }

    /* renamed from: a */
    private void m871a(C0161a listener) {
        if (listener != null) {
            listener.onCreate();
        }
    }

    /* renamed from: c */
    private void m873c(C0161a listener) {
        if (listener != null) {
            listener.onStart();
        }
    }

    /* renamed from: b */
    private void m872b(C0161a listener) {
        if (listener != null) {
            listener.onResume();
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        m871a(this.f226a);
        m870a(C0000a.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        m873c(this.f226a);
        m870a(C0000a.ON_START);
    }

    public void onResume() {
        super.onResume();
        m872b(this.f226a);
        m870a(C0000a.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        m870a(C0000a.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        m870a(C0000a.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        m870a(C0000a.ON_DESTROY);
        this.f226a = null;
    }

    /* renamed from: a */
    private void m870a(C0000a event) {
        Activity activity = getActivity();
        if (activity instanceof C0154i) {
            ((C0154i) activity).getLifecycle().mo3755b(event);
            return;
        }
        if (activity instanceof C0001f) {
            C0148d lifecycle = ((C0001f) activity).getLifecycle();
            if (lifecycle instanceof C0152h) {
                ((C0152h) lifecycle).mo3755b(event);
            }
        }
    }
}
