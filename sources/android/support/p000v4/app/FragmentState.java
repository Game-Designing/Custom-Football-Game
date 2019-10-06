package android.support.p000v4.app;

import android.arch.lifecycle.C0165s;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* renamed from: android.support.v4.app.FragmentState */
final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new C0422E();

    /* renamed from: a */
    final String f1410a;

    /* renamed from: b */
    final int f1411b;

    /* renamed from: c */
    final boolean f1412c;

    /* renamed from: d */
    final int f1413d;

    /* renamed from: e */
    final int f1414e;

    /* renamed from: f */
    final String f1415f;

    /* renamed from: g */
    final boolean f1416g;

    /* renamed from: h */
    final boolean f1417h;

    /* renamed from: i */
    final Bundle f1418i;

    /* renamed from: j */
    final boolean f1419j;

    /* renamed from: k */
    Bundle f1420k;

    /* renamed from: l */
    Fragment f1421l;

    FragmentState(Fragment frag) {
        this.f1410a = frag.getClass().getName();
        this.f1411b = frag.mIndex;
        this.f1412c = frag.mFromLayout;
        this.f1413d = frag.mFragmentId;
        this.f1414e = frag.mContainerId;
        this.f1415f = frag.mTag;
        this.f1416g = frag.mRetainInstance;
        this.f1417h = frag.mDetached;
        this.f1418i = frag.mArguments;
        this.f1419j = frag.mHidden;
    }

    FragmentState(Parcel in) {
        this.f1410a = in.readString();
        this.f1411b = in.readInt();
        boolean z = true;
        this.f1412c = in.readInt() != 0;
        this.f1413d = in.readInt();
        this.f1414e = in.readInt();
        this.f1415f = in.readString();
        this.f1416g = in.readInt() != 0;
        this.f1417h = in.readInt() != 0;
        this.f1418i = in.readBundle();
        if (in.readInt() == 0) {
            z = false;
        }
        this.f1419j = z;
        this.f1420k = in.readBundle();
    }

    /* renamed from: a */
    public Fragment mo5029a(C0485s host, C0483q container, Fragment parent, C0419B childNonConfig, C0165s viewModelStore) {
        if (this.f1421l == null) {
            Context context = host.mo5227c();
            Bundle bundle = this.f1418i;
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            if (container != null) {
                this.f1421l = container.mo5196a(context, this.f1410a, this.f1418i);
            } else {
                this.f1421l = Fragment.instantiate(context, this.f1410a, this.f1418i);
            }
            Bundle bundle2 = this.f1420k;
            if (bundle2 != null) {
                bundle2.setClassLoader(context.getClassLoader());
                this.f1421l.mSavedFragmentState = this.f1420k;
            }
            this.f1421l.setIndex(this.f1411b, parent);
            Fragment fragment = this.f1421l;
            fragment.mFromLayout = this.f1412c;
            fragment.mRestored = true;
            fragment.mFragmentId = this.f1413d;
            fragment.mContainerId = this.f1414e;
            fragment.mTag = this.f1415f;
            fragment.mRetainInstance = this.f1416g;
            fragment.mDetached = this.f1417h;
            fragment.mHidden = this.f1419j;
            fragment.mFragmentManager = host.f1618e;
            if (C0409A.f1337a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiated fragment ");
                sb.append(this.f1421l);
                Log.v("FragmentManager", sb.toString());
            }
        }
        Fragment fragment2 = this.f1421l;
        fragment2.mChildNonConfig = childNonConfig;
        fragment2.mViewModelStore = viewModelStore;
        return fragment2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f1410a);
        dest.writeInt(this.f1411b);
        dest.writeInt(this.f1412c ? 1 : 0);
        dest.writeInt(this.f1413d);
        dest.writeInt(this.f1414e);
        dest.writeString(this.f1415f);
        dest.writeInt(this.f1416g ? 1 : 0);
        dest.writeInt(this.f1417h ? 1 : 0);
        dest.writeBundle(this.f1418i);
        dest.writeInt(this.f1419j ? 1 : 0);
        dest.writeBundle(this.f1420k);
    }
}
