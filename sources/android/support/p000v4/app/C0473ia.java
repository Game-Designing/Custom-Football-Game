package android.support.p000v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.content.C0510b;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.app.ia */
/* compiled from: TaskStackBuilder */
public final class C0473ia implements Iterable<Intent> {

    /* renamed from: a */
    private static final C0475c f1603a;

    /* renamed from: b */
    private final ArrayList<Intent> f1604b = new ArrayList<>();

    /* renamed from: c */
    private final Context f1605c;

    /* renamed from: android.support.v4.app.ia$a */
    /* compiled from: TaskStackBuilder */
    public interface C0013a {
        Intent getSupportParentActivityIntent();
    }

    /* renamed from: android.support.v4.app.ia$b */
    /* compiled from: TaskStackBuilder */
    static class C0474b extends C0475c {
        C0474b() {
        }
    }

    /* renamed from: android.support.v4.app.ia$c */
    /* compiled from: TaskStackBuilder */
    static class C0475c {
        C0475c() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1603a = new C0474b();
        } else {
            f1603a = new C0475c();
        }
    }

    private C0473ia(Context a) {
        this.f1605c = a;
    }

    /* renamed from: a */
    public static C0473ia m2409a(Context context) {
        return new C0473ia(context);
    }

    /* renamed from: a */
    public C0473ia mo5174a(Intent nextIntent) {
        this.f1604b.add(nextIntent);
        return this;
    }

    /* renamed from: a */
    public C0473ia mo5172a(Activity sourceActivity) {
        Intent parent = null;
        if (sourceActivity instanceof C0013a) {
            parent = ((C0013a) sourceActivity).getSupportParentActivityIntent();
        }
        if (parent == null) {
            parent = C0445Y.m2292a(sourceActivity);
        }
        if (parent != null) {
            ComponentName target = parent.getComponent();
            if (target == null) {
                target = parent.resolveActivity(this.f1605c.getPackageManager());
            }
            mo5173a(target);
            mo5174a(parent);
        }
        return this;
    }

    /* renamed from: a */
    public C0473ia mo5173a(ComponentName sourceActivityName) {
        int insertAt = this.f1604b.size();
        try {
            Intent parent = C0445Y.m2293a(this.f1605c, sourceActivityName);
            while (parent != null) {
                this.f1604b.add(insertAt, parent);
                parent = C0445Y.m2293a(this.f1605c, parent.getComponent());
            }
            return this;
        } catch (NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1604b.iterator();
    }

    /* renamed from: a */
    public void mo5175a() {
        mo5176a((Bundle) null);
    }

    /* renamed from: a */
    public void mo5176a(Bundle options) {
        if (!this.f1604b.isEmpty()) {
            ArrayList<Intent> arrayList = this.f1604b;
            Intent[] intents = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intents[0] = new Intent(intents[0]).addFlags(268484608);
            if (!C0510b.m2568a(this.f1605c, intents, options)) {
                Intent topIntent = new Intent(intents[intents.length - 1]);
                topIntent.addFlags(268435456);
                this.f1605c.startActivity(topIntent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
