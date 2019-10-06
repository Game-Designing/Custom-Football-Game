package com.bumptech.glide.p100c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.C6354n;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* renamed from: com.bumptech.glide.c.l */
/* compiled from: RequestManagerFragment */
public class C5939l extends Fragment {

    /* renamed from: a */
    private final C5927a f10452a;

    /* renamed from: b */
    private final C5944o f10453b;

    /* renamed from: c */
    private final Set<C5939l> f10454c;

    /* renamed from: d */
    private C6354n f10455d;

    /* renamed from: e */
    private C5939l f10456e;

    /* renamed from: f */
    private Fragment f10457f;

    /* renamed from: com.bumptech.glide.c.l$a */
    /* compiled from: RequestManagerFragment */
    private class C5940a implements C5944o {
        C5940a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(C5939l.this);
            sb.append("}");
            return sb.toString();
        }
    }

    public C5939l() {
        this(new C5927a());
    }

    @SuppressLint({"ValidFragment"})
    C5939l(C5927a lifecycle) {
        this.f10453b = new C5940a();
        this.f10454c = new HashSet();
        this.f10452a = lifecycle;
    }

    /* renamed from: a */
    public void mo18603a(C6354n requestManager) {
        this.f10455d = requestManager;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C5927a mo18601a() {
        return this.f10452a;
    }

    /* renamed from: b */
    public C6354n mo18604b() {
        return this.f10455d;
    }

    /* renamed from: c */
    public C5944o mo18605c() {
        return this.f10453b;
    }

    /* renamed from: a */
    private void m10953a(C5939l child) {
        this.f10454c.add(child);
    }

    /* renamed from: b */
    private void m10954b(C5939l child) {
        this.f10454c.remove(child);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18602a(Fragment parentFragmentHint) {
        this.f10457f = parentFragmentHint;
        if (parentFragmentHint != null && parentFragmentHint.getActivity() != null) {
            m10952a(parentFragmentHint.getActivity());
        }
    }

    @TargetApi(17)
    /* renamed from: d */
    private Fragment m10955d() {
        Fragment fragment;
        if (VERSION.SDK_INT >= 17) {
            fragment = getParentFragment();
        } else {
            fragment = null;
        }
        return fragment != null ? fragment : this.f10457f;
    }

    /* renamed from: a */
    private void m10952a(Activity activity) {
        m10956e();
        this.f10456e = C5926c.m10916a((Context) activity).mo18586h().mo18618b(activity);
        if (!equals(this.f10456e)) {
            this.f10456e.m10953a(this);
        }
    }

    /* renamed from: e */
    private void m10956e() {
        C5939l lVar = this.f10456e;
        if (lVar != null) {
            lVar.m10954b(this);
            this.f10456e = null;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m10952a(activity);
        } catch (IllegalStateException e) {
            String str = "RMFragment";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root", e);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        m10956e();
    }

    public void onStart() {
        super.onStart();
        this.f10452a.mo18592b();
    }

    public void onStop() {
        super.onStop();
        this.f10452a.mo18594c();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f10452a.mo18590a();
        m10956e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        sb.append(m10955d());
        sb.append("}");
        return sb.toString();
    }
}
