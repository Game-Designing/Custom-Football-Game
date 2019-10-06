package android.support.p000v4.app;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.Fragment.SavedState;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: android.support.v4.app.t */
/* compiled from: FragmentManager */
public abstract class C0486t {

    /* renamed from: android.support.v4.app.t$a */
    /* compiled from: FragmentManager */
    public interface C0487a {
        String getName();
    }

    /* renamed from: android.support.v4.app.t$b */
    /* compiled from: FragmentManager */
    public static abstract class C0488b {
        /* renamed from: b */
        public void mo5235b(C0486t fm, Fragment f, Context context) {
        }

        /* renamed from: a */
        public void mo5231a(C0486t fm, Fragment f, Context context) {
        }

        /* renamed from: c */
        public void mo5238c(C0486t fm, Fragment f, Bundle savedInstanceState) {
        }

        /* renamed from: b */
        public void mo5236b(C0486t fm, Fragment f, Bundle savedInstanceState) {
        }

        /* renamed from: a */
        public void mo5232a(C0486t fm, Fragment f, Bundle savedInstanceState) {
        }

        /* renamed from: a */
        public void mo5233a(C0486t fm, Fragment f, View v, Bundle savedInstanceState) {
        }

        /* renamed from: e */
        public void mo5241e(C0486t fm, Fragment f) {
        }

        /* renamed from: d */
        public void mo5239d(C0486t fm, Fragment f) {
        }

        /* renamed from: c */
        public void mo5237c(C0486t fm, Fragment f) {
        }

        /* renamed from: f */
        public void mo5242f(C0486t fm, Fragment f) {
        }

        /* renamed from: d */
        public void mo5240d(C0486t fm, Fragment f, Bundle outState) {
        }

        /* renamed from: g */
        public void mo5243g(C0486t fm, Fragment f) {
        }

        /* renamed from: a */
        public void mo5230a(C0486t fm, Fragment f) {
        }

        /* renamed from: b */
        public void mo5234b(C0486t fm, Fragment f) {
        }
    }

    /* renamed from: android.support.v4.app.t$c */
    /* compiled from: FragmentManager */
    public interface C0489c {
        void onBackStackChanged();
    }

    /* renamed from: a */
    public abstract SavedState mo4905a(Fragment fragment);

    /* renamed from: a */
    public abstract Fragment mo4906a(int i);

    /* renamed from: a */
    public abstract Fragment mo4907a(Bundle bundle, String str);

    /* renamed from: a */
    public abstract Fragment mo4908a(String str);

    /* renamed from: a */
    public abstract C0424G mo4909a();

    /* renamed from: a */
    public abstract void mo4910a(int i, int i2);

    /* renamed from: a */
    public abstract void mo4914a(Bundle bundle, String str, Fragment fragment);

    /* renamed from: a */
    public abstract void mo4925a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: a */
    public abstract boolean mo4929a(String str, int i);

    /* renamed from: b */
    public abstract C0487a mo4933b(int i);

    /* renamed from: b */
    public abstract boolean mo4940b();

    /* renamed from: c */
    public abstract int mo4943c();

    /* renamed from: d */
    public abstract List<Fragment> mo4948d();

    /* renamed from: e */
    public abstract boolean mo4955e();

    /* renamed from: f */
    public abstract void mo4956f();

    /* renamed from: g */
    public abstract boolean mo4961g();
}
