package android.support.p000v4.app;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.aa */
/* compiled from: NotificationCompat */
public class C0448aa {

    /* renamed from: android.support.v4.app.aa$a */
    /* compiled from: NotificationCompat */
    public static class C0449a {

        /* renamed from: a */
        final Bundle f1503a;

        /* renamed from: b */
        private final C0466ea[] f1504b;

        /* renamed from: c */
        private final C0466ea[] f1505c;

        /* renamed from: d */
        private boolean f1506d;

        /* renamed from: e */
        public int f1507e;

        /* renamed from: f */
        public CharSequence f1508f;

        /* renamed from: g */
        public PendingIntent f1509g;

        public C0449a(int icon, CharSequence title, PendingIntent intent) {
            this(icon, title, intent, new Bundle(), null, null, true);
        }

        C0449a(int icon, CharSequence title, PendingIntent intent, Bundle extras, C0466ea[] remoteInputs, C0466ea[] dataOnlyRemoteInputs, boolean allowGeneratedReplies) {
            this.f1507e = icon;
            this.f1508f = C0451c.m2309a(title);
            this.f1509g = intent;
            this.f1503a = extras != null ? extras : new Bundle();
            this.f1504b = remoteInputs;
            this.f1505c = dataOnlyRemoteInputs;
            this.f1506d = allowGeneratedReplies;
        }

        /* renamed from: e */
        public int mo5100e() {
            return this.f1507e;
        }

        /* renamed from: g */
        public CharSequence mo5102g() {
            return this.f1508f;
        }

        /* renamed from: a */
        public PendingIntent mo5096a() {
            return this.f1509g;
        }

        /* renamed from: d */
        public Bundle mo5099d() {
            return this.f1503a;
        }

        /* renamed from: b */
        public boolean mo5097b() {
            return this.f1506d;
        }

        /* renamed from: f */
        public C0466ea[] mo5101f() {
            return this.f1504b;
        }

        /* renamed from: c */
        public C0466ea[] mo5098c() {
            return this.f1505c;
        }
    }

    /* renamed from: android.support.v4.app.aa$b */
    /* compiled from: NotificationCompat */
    public static class C0450b extends C0452d {

        /* renamed from: e */
        private CharSequence f1510e;

        /* renamed from: a */
        public C0450b mo5103a(CharSequence cs) {
            this.f1510e = C0451c.m2309a(cs);
            return this;
        }

        /* renamed from: a */
        public void mo5104a(C0446Z builder) {
            if (VERSION.SDK_INT >= 16) {
                BigTextStyle style = new BigTextStyle(builder.mo5094a()).setBigContentTitle(this.f1552b).bigText(this.f1510e);
                if (this.f1554d) {
                    style.setSummaryText(this.f1553c);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.aa$c */
    /* compiled from: NotificationCompat */
    public static class C0451c {

        /* renamed from: A */
        Bundle f1511A;

        /* renamed from: B */
        int f1512B;

        /* renamed from: C */
        int f1513C;

        /* renamed from: D */
        Notification f1514D;

        /* renamed from: E */
        RemoteViews f1515E;

        /* renamed from: F */
        RemoteViews f1516F;

        /* renamed from: G */
        RemoteViews f1517G;

        /* renamed from: H */
        String f1518H;

        /* renamed from: I */
        int f1519I;

        /* renamed from: J */
        String f1520J;

        /* renamed from: K */
        long f1521K;

        /* renamed from: L */
        int f1522L;

        /* renamed from: M */
        Notification f1523M;
        @Deprecated

        /* renamed from: N */
        public ArrayList<String> f1524N;

        /* renamed from: a */
        public Context f1525a;

        /* renamed from: b */
        public ArrayList<C0449a> f1526b;

        /* renamed from: c */
        CharSequence f1527c;

        /* renamed from: d */
        CharSequence f1528d;

        /* renamed from: e */
        PendingIntent f1529e;

        /* renamed from: f */
        PendingIntent f1530f;

        /* renamed from: g */
        RemoteViews f1531g;

        /* renamed from: h */
        Bitmap f1532h;

        /* renamed from: i */
        CharSequence f1533i;

        /* renamed from: j */
        int f1534j;

        /* renamed from: k */
        int f1535k;

        /* renamed from: l */
        boolean f1536l;

        /* renamed from: m */
        boolean f1537m;

        /* renamed from: n */
        C0452d f1538n;

        /* renamed from: o */
        CharSequence f1539o;

        /* renamed from: p */
        CharSequence[] f1540p;

        /* renamed from: q */
        int f1541q;

        /* renamed from: r */
        int f1542r;

        /* renamed from: s */
        boolean f1543s;

        /* renamed from: t */
        String f1544t;

        /* renamed from: u */
        boolean f1545u;

        /* renamed from: v */
        String f1546v;

        /* renamed from: w */
        boolean f1547w;

        /* renamed from: x */
        boolean f1548x;

        /* renamed from: y */
        boolean f1549y;

        /* renamed from: z */
        String f1550z;

        public C0451c(Context context, String channelId) {
            this.f1526b = new ArrayList<>();
            this.f1536l = true;
            this.f1547w = false;
            this.f1512B = 0;
            this.f1513C = 0;
            this.f1519I = 0;
            this.f1522L = 0;
            this.f1523M = new Notification();
            this.f1525a = context;
            this.f1518H = channelId;
            this.f1523M.when = System.currentTimeMillis();
            this.f1523M.audioStreamType = -1;
            this.f1535k = 0;
            this.f1524N = new ArrayList<>();
        }

        @Deprecated
        public C0451c(Context context) {
            this(context, null);
        }

        /* renamed from: a */
        public C0451c mo5109a(long when) {
            this.f1523M.when = when;
            return this;
        }

        /* renamed from: c */
        public C0451c mo5120c(int icon) {
            this.f1523M.icon = icon;
            return this;
        }

        /* renamed from: c */
        public C0451c mo5121c(CharSequence title) {
            this.f1527c = m2309a(title);
            return this;
        }

        /* renamed from: b */
        public C0451c mo5118b(CharSequence text) {
            this.f1528d = m2309a(text);
            return this;
        }

        /* renamed from: a */
        public C0451c mo5107a(int max, int progress, boolean indeterminate) {
            this.f1541q = max;
            this.f1542r = progress;
            this.f1543s = indeterminate;
            return this;
        }

        /* renamed from: a */
        public C0451c mo5110a(PendingIntent intent) {
            this.f1529e = intent;
            return this;
        }

        /* renamed from: b */
        public C0451c mo5117b(PendingIntent intent) {
            this.f1523M.deleteIntent = intent;
            return this;
        }

        /* renamed from: d */
        public C0451c mo5123d(CharSequence tickerText) {
            this.f1523M.tickerText = m2309a(tickerText);
            return this;
        }

        /* renamed from: a */
        public C0451c mo5111a(Bitmap icon) {
            this.f1532h = icon;
            return this;
        }

        /* renamed from: c */
        public C0451c mo5122c(boolean ongoing) {
            m2310a(2, ongoing);
            return this;
        }

        /* renamed from: a */
        public C0451c mo5115a(boolean autoCancel) {
            m2310a(16, autoCancel);
            return this;
        }

        /* renamed from: b */
        public C0451c mo5119b(boolean b) {
            this.f1547w = b;
            return this;
        }

        /* renamed from: a */
        private void m2310a(int mask, boolean value) {
            if (value) {
                this.f1523M.flags |= mask;
                return;
            }
            this.f1523M.flags &= mask ^ -1;
        }

        /* renamed from: b */
        public C0451c mo5116b(int pri) {
            this.f1535k = pri;
            return this;
        }

        /* renamed from: a */
        public C0451c mo5108a(int icon, CharSequence title, PendingIntent intent) {
            this.f1526b.add(new C0449a(icon, title, intent));
            return this;
        }

        /* renamed from: a */
        public C0451c mo5112a(C0449a action) {
            this.f1526b.add(action);
            return this;
        }

        /* renamed from: a */
        public C0451c mo5113a(C0452d style) {
            if (this.f1538n != style) {
                this.f1538n = style;
                C0452d dVar = this.f1538n;
                if (dVar != null) {
                    dVar.mo5125a(this);
                }
            }
            return this;
        }

        /* renamed from: a */
        public C0451c mo5106a(int argb) {
            this.f1512B = argb;
            return this;
        }

        /* renamed from: a */
        public C0451c mo5114a(String channelId) {
            this.f1518H = channelId;
            return this;
        }

        /* renamed from: a */
        public Notification mo5105a() {
            return new C0457ba(this).mo5138b();
        }

        /* renamed from: a */
        protected static CharSequence m2309a(CharSequence cs) {
            if (cs == null) {
                return cs;
            }
            if (cs.length() > 5120) {
                cs = cs.subSequence(0, 5120);
            }
            return cs;
        }
    }

    /* renamed from: android.support.v4.app.aa$d */
    /* compiled from: NotificationCompat */
    public static abstract class C0452d {

        /* renamed from: a */
        protected C0451c f1551a;

        /* renamed from: b */
        CharSequence f1552b;

        /* renamed from: c */
        CharSequence f1553c;

        /* renamed from: d */
        boolean f1554d = false;

        /* renamed from: a */
        public abstract void mo5104a(C0446Z z);

        /* renamed from: a */
        public void mo5125a(C0451c builder) {
            if (this.f1551a != builder) {
                this.f1551a = builder;
                C0451c cVar = this.f1551a;
                if (cVar != null) {
                    cVar.mo5113a(this);
                }
            }
        }

        /* renamed from: c */
        public RemoteViews mo5127c(C0446Z builder) {
            return null;
        }

        /* renamed from: b */
        public RemoteViews mo5126b(C0446Z builder) {
            return null;
        }

        /* renamed from: d */
        public RemoteViews mo5128d(C0446Z builder) {
            return null;
        }

        /* renamed from: a */
        public void mo5124a(Bundle extras) {
        }
    }

    /* renamed from: a */
    public static Bundle m2299a(Notification notification) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return C0459ca.m2355a(notification);
        }
        return null;
    }
}
