package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareOpenGraphValueContainer.C6801a;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, C6800a> {
    public static final Creator<ShareOpenGraphAction> CREATOR = new C6805d();

    /* renamed from: com.facebook.share.model.ShareOpenGraphAction$a */
    public static final class C6800a extends C6801a<ShareOpenGraphAction, C6800a> {
        /* renamed from: a */
        public C6800a mo20170a(String actionType) {
            mo20180a("og:type", actionType);
            return this;
        }

        /* renamed from: a */
        public ShareOpenGraphAction mo20171a() {
            return new ShareOpenGraphAction(this, null);
        }

        /* renamed from: a */
        public C6800a mo20169a(ShareOpenGraphAction model) {
            if (model == null) {
                return this;
            }
            super.mo20179a(model);
            C6800a aVar = this;
            aVar.mo20170a(model.mo20167c());
            return aVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C6800a mo20168a(Parcel parcel) {
            return mo20169a((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }
    }

    /* synthetic */ ShareOpenGraphAction(C6800a x0, C6805d x1) {
        this(x0);
    }

    private ShareOpenGraphAction(C6800a builder) {
        super((C6801a<P, E>) builder);
    }

    ShareOpenGraphAction(Parcel in) {
        super(in);
    }

    /* renamed from: c */
    public String mo20167c() {
        return mo20175b("og:type");
    }
}
