package com.bumptech.glide.p100c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C6354n;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.c.q */
/* compiled from: SupportRequestManagerFragment */
public class C5946q extends Fragment {

    /* renamed from: a */
    private final C5927a f10471a;

    /* renamed from: b */
    private final C5944o f10472b;

    /* renamed from: c */
    private final Set<C5946q> f10473c;

    /* renamed from: d */
    private C5946q f10474d;

    /* renamed from: e */
    private C6354n f10475e;

    /* renamed from: f */
    private Fragment f10476f;

    /* renamed from: com.bumptech.glide.c.q$a */
    /* compiled from: SupportRequestManagerFragment */
    private class C5947a implements C5944o {
        C5947a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(C5946q.this);
            sb.append("}");
            return sb.toString();
        }
    }

    public C5946q() {
        this(new C5927a());
    }

    @SuppressLint({"ValidFragment"})
    public C5946q(C5927a lifecycle) {
        this.f10472b = new C5947a();
        this.f10473c = new HashSet();
        this.f10471a = lifecycle;
    }

    /* renamed from: a */
    public void mo18629a(C6354n requestManager) {
        this.f10475e = requestManager;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C5927a mo18630b() {
        return this.f10471a;
    }

    /* renamed from: c */
    public C6354n mo18631c() {
        return this.f10475e;
    }

    /* renamed from: d */
    public C5944o mo18632d() {
        return this.f10472b;
    }

    /* renamed from: a */
    private void m10985a(C5946q child) {
        this.f10473c.add(child);
    }

    /* renamed from: b */
    private void m10986b(C5946q child) {
        this.f10473c.remove(child);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18628a(Fragment parentFragmentHint) {
        this.f10476f = parentFragmentHint;
        if (parentFragmentHint != null && parentFragmentHint.getActivity() != null) {
            m10984a(parentFragmentHint.getActivity());
        }
    }

    /* renamed from: e */
    private Fragment m10987e() {
        Fragment fragment = getParentFragment();
        return fragment != null ? fragment : this.f10476f;
    }

    /* renamed from: a */
    private void m10984a(C0014p activity) {
        m10988f();
        this.f10474d = C5926c.m10916a((Context) activity).mo18586h().mo18619b(activity);
        if (!equals(this.f10474d)) {
            this.f10474d.m10985a(this);
        }
    }

    /* renamed from: f */
    private void m10988f() {
        C5946q qVar = this.f10474d;
        if (qVar != null) {
            qVar.m10986b(this);
            this.f10474d = null;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            m10984a(getActivity());
        } catch (IllegalStateException e) {
            String str = "SupportRMFragment";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root", e);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f10476f = null;
        m10988f();
    }

    public void onStart() {
        super.onStart();
        this.f10471a.mo18592b();
    }

    public void onStop() {
        super.onStop();
        this.f10471a.mo18594c();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f10471a.mo18590a();
        m10988f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        sb.append(m10987e());
        sb.append("}");
        return sb.toString();
    }
}
