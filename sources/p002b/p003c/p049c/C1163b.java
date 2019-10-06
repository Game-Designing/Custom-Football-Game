package p002b.p003c.p049c;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.app.C0460d;
import android.support.p000v4.app.C0476j;
import android.support.p000v4.content.C0510b;
import java.util.ArrayList;

/* renamed from: b.c.c.b */
/* compiled from: CustomTabsIntent */
public final class C1163b {

    /* renamed from: a */
    public final Intent f3816a;

    /* renamed from: b */
    public final Bundle f3817b;

    /* renamed from: b.c.c.b$a */
    /* compiled from: CustomTabsIntent */
    public static final class C1164a {

        /* renamed from: a */
        private final Intent f3818a;

        /* renamed from: b */
        private ArrayList<Bundle> f3819b;

        /* renamed from: c */
        private Bundle f3820c;

        /* renamed from: d */
        private ArrayList<Bundle> f3821d;

        /* renamed from: e */
        private boolean f3822e;

        public C1164a() {
            this(null);
        }

        public C1164a(C1165c session) {
            this.f3818a = new Intent("android.intent.action.VIEW");
            this.f3819b = null;
            this.f3820c = null;
            this.f3821d = null;
            this.f3822e = true;
            if (session == null) {
                Bundle bundle = new Bundle();
                if (session == null) {
                    C0476j.m2416a(bundle, "android.support.customtabs.extra.SESSION", null);
                    this.f3818a.putExtras(bundle);
                    return;
                }
                session.mo8788a();
                throw null;
            }
            Intent intent = this.f3818a;
            session.mo8789b();
            throw null;
        }

        /* renamed from: a */
        public C1164a mo8781a(int color) {
            this.f3818a.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", color);
            return this;
        }

        /* renamed from: a */
        public C1164a mo8783a(Bitmap icon) {
            this.f3818a.putExtra("android.support.customtabs.extra.CLOSE_BUTTON_ICON", icon);
            return this;
        }

        /* renamed from: a */
        public C1164a mo8785a(boolean showTitle) {
            this.f3818a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", showTitle);
            return this;
        }

        /* renamed from: a */
        public C1164a mo8784a(String label, PendingIntent pendingIntent) {
            if (this.f3819b == null) {
                this.f3819b = new ArrayList<>();
            }
            Bundle bundle = new Bundle();
            bundle.putString("android.support.customtabs.customaction.MENU_ITEM_TITLE", label);
            bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", pendingIntent);
            this.f3819b.add(bundle);
            return this;
        }

        /* renamed from: a */
        public C1164a mo8780a() {
            this.f3818a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
            return this;
        }

        /* renamed from: b */
        public C1164a mo8786b(Context context, int enterResId, int exitResId) {
            this.f3820c = C0460d.m2360a(context, enterResId, exitResId).mo5140a();
            return this;
        }

        /* renamed from: a */
        public C1164a mo8782a(Context context, int enterResId, int exitResId) {
            this.f3818a.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", C0460d.m2360a(context, enterResId, exitResId).mo5140a());
            return this;
        }

        /* renamed from: b */
        public C1163b mo8787b() {
            ArrayList<Bundle> arrayList = this.f3819b;
            if (arrayList != null) {
                this.f3818a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f3821d;
            if (arrayList2 != null) {
                this.f3818a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f3818a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f3822e);
            return new C1163b(this.f3818a, this.f3820c);
        }
    }

    /* renamed from: a */
    public void mo8779a(Context context, Uri url) {
        this.f3816a.setData(url);
        C0510b.m2567a(context, this.f3816a, this.f3817b);
    }

    private C1163b(Intent intent, Bundle startAnimationBundle) {
        this.f3816a = intent;
        this.f3817b = startAnimationBundle;
    }
}
