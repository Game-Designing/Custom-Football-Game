package com.facebook.p127a.p128a.p129a;

import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment.BundleCons;

/* renamed from: com.facebook.a.a.a.c */
/* compiled from: PathComponent */
public final class C6570c {

    /* renamed from: a */
    public final String f11905a;

    /* renamed from: b */
    public final int f11906b;

    /* renamed from: c */
    public final int f11907c;

    /* renamed from: d */
    public final String f11908d;

    /* renamed from: e */
    public final String f11909e;

    /* renamed from: f */
    public final String f11910f;

    /* renamed from: g */
    public final String f11911g;

    /* renamed from: h */
    public final int f11912h;

    /* renamed from: com.facebook.a.a.a.c$a */
    /* compiled from: PathComponent */
    public enum C6571a {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        

        /* renamed from: g */
        private final int f11919g;

        private C6571a(int value) {
            this.f11919g = value;
        }

        /* renamed from: e */
        public int mo19752e() {
            return this.f11919g;
        }
    }

    C6570c(JSONObject component) throws JSONException {
        this.f11905a = component.getString("class_name");
        this.f11906b = component.optInt("index", -1);
        this.f11907c = component.optInt("id");
        this.f11908d = component.optString(CommandHandler.TEXT);
        this.f11909e = component.optString(BundleCons.TAG);
        this.f11910f = component.optString(Repo.COLUMN_DESCRIPTION);
        this.f11911g = component.optString("hint");
        this.f11912h = component.optInt("match_bitmask");
    }
}
