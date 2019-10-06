package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p001v7.view.menu.C0858D;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0879p;
import android.support.p001v7.view.menu.C0890v;

public class BottomNavigationPresenter implements C0890v {

    /* renamed from: a */
    private C0873l f710a;

    /* renamed from: b */
    private C0218d f711b;

    /* renamed from: c */
    private boolean f712c = false;

    /* renamed from: d */
    private int f713d;

    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C0219e();

        /* renamed from: a */
        int f714a;

        SavedState() {
        }

        SavedState(Parcel in) {
            this.f714a = in.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.f714a);
        }
    }

    /* renamed from: a */
    public void mo4077a(C0218d menuView) {
        this.f711b = menuView;
    }

    /* renamed from: a */
    public void mo4075a(Context context, C0873l menu) {
        this.f711b.mo4100a(this.f710a);
        this.f710a = menu;
    }

    /* renamed from: a */
    public void mo4079a(boolean cleared) {
        if (!this.f712c) {
            if (cleared) {
                this.f711b.mo4123a();
            } else {
                this.f711b.mo4125b();
            }
        }
    }

    /* renamed from: a */
    public boolean mo4080a(C0858D subMenu) {
        return false;
    }

    /* renamed from: a */
    public void mo4078a(C0873l menu, boolean allMenusAreClosing) {
    }

    /* renamed from: b */
    public boolean mo4083b() {
        return false;
    }

    /* renamed from: a */
    public boolean mo4081a(C0873l menu, C0879p item) {
        return false;
    }

    /* renamed from: b */
    public boolean mo4084b(C0873l menu, C0879p item) {
        return false;
    }

    /* renamed from: a */
    public void mo4074a(int id) {
        this.f713d = id;
    }

    public int getId() {
        return this.f713d;
    }

    /* renamed from: a */
    public Parcelable mo4073a() {
        SavedState savedState = new SavedState();
        savedState.f714a = this.f711b.getSelectedItemId();
        return savedState;
    }

    /* renamed from: a */
    public void mo4076a(Parcelable state) {
        if (state instanceof SavedState) {
            this.f711b.mo4124a(((SavedState) state).f714a);
        }
    }

    /* renamed from: b */
    public void mo4082b(boolean updateSuspended) {
        this.f712c = updateSuspended;
    }
}
