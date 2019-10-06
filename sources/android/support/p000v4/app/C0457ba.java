package android.support.p000v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.app.C0448aa.C0449a;
import android.support.p000v4.app.C0448aa.C0451c;
import android.support.p000v4.app.C0448aa.C0452d;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.app.ba */
/* compiled from: NotificationCompatBuilder */
class C0457ba implements C0446Z {

    /* renamed from: a */
    private final Builder f1557a;

    /* renamed from: b */
    private final C0451c f1558b;

    /* renamed from: c */
    private RemoteViews f1559c;

    /* renamed from: d */
    private RemoteViews f1560d;

    /* renamed from: e */
    private final List<Bundle> f1561e = new ArrayList();

    /* renamed from: f */
    private final Bundle f1562f = new Bundle();

    /* renamed from: g */
    private int f1563g;

    /* renamed from: h */
    private RemoteViews f1564h;

    C0457ba(C0451c b) {
        this.f1558b = b;
        if (VERSION.SDK_INT >= 26) {
            this.f1557a = new Builder(b.f1525a, b.f1518H);
        } else {
            this.f1557a = new Builder(b.f1525a);
        }
        Notification n = b.f1523M;
        this.f1557a.setWhen(n.when).setSmallIcon(n.icon, n.iconLevel).setContent(n.contentView).setTicker(n.tickerText, b.f1531g).setVibrate(n.vibrate).setLights(n.ledARGB, n.ledOnMS, n.ledOffMS).setOngoing((n.flags & 2) != 0).setOnlyAlertOnce((n.flags & 8) != 0).setAutoCancel((n.flags & 16) != 0).setDefaults(n.defaults).setContentTitle(b.f1527c).setContentText(b.f1528d).setContentInfo(b.f1533i).setContentIntent(b.f1529e).setDeleteIntent(n.deleteIntent).setFullScreenIntent(b.f1530f, (n.flags & 128) != 0).setLargeIcon(b.f1532h).setNumber(b.f1534j).setProgress(b.f1541q, b.f1542r, b.f1543s);
        if (VERSION.SDK_INT < 21) {
            this.f1557a.setSound(n.sound, n.audioStreamType);
        }
        if (VERSION.SDK_INT >= 16) {
            this.f1557a.setSubText(b.f1539o).setUsesChronometer(b.f1537m).setPriority(b.f1535k);
            Iterator it = b.f1526b.iterator();
            while (it.hasNext()) {
                m2350a((C0449a) it.next());
            }
            Bundle bundle = b.f1511A;
            if (bundle != null) {
                this.f1562f.putAll(bundle);
            }
            if (VERSION.SDK_INT < 20) {
                if (b.f1547w) {
                    this.f1562f.putBoolean("android.support.localOnly", true);
                }
                String str = b.f1544t;
                if (str != null) {
                    this.f1562f.putString("android.support.groupKey", str);
                    if (b.f1545u) {
                        this.f1562f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1562f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = b.f1546v;
                if (str2 != null) {
                    this.f1562f.putString("android.support.sortKey", str2);
                }
            }
            this.f1559c = b.f1515E;
            this.f1560d = b.f1516F;
        }
        if (VERSION.SDK_INT >= 19) {
            this.f1557a.setShowWhen(b.f1536l);
            if (VERSION.SDK_INT < 21) {
                ArrayList<String> arrayList = b.f1524N;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Bundle bundle2 = this.f1562f;
                    ArrayList<String> arrayList2 = b.f1524N;
                    bundle2.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
                }
            }
        }
        if (VERSION.SDK_INT >= 20) {
            this.f1557a.setLocalOnly(b.f1547w).setGroup(b.f1544t).setGroupSummary(b.f1545u).setSortKey(b.f1546v);
            this.f1563g = b.f1522L;
        }
        if (VERSION.SDK_INT >= 21) {
            this.f1557a.setCategory(b.f1550z).setColor(b.f1512B).setVisibility(b.f1513C).setPublicVersion(b.f1514D).setSound(n.sound, n.audioAttributes);
            Iterator it2 = b.f1524N.iterator();
            while (it2.hasNext()) {
                this.f1557a.addPerson((String) it2.next());
            }
            this.f1564h = b.f1517G;
        }
        if (VERSION.SDK_INT >= 24) {
            this.f1557a.setExtras(b.f1511A).setRemoteInputHistory(b.f1540p);
            RemoteViews remoteViews = b.f1515E;
            if (remoteViews != null) {
                this.f1557a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = b.f1516F;
            if (remoteViews2 != null) {
                this.f1557a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = b.f1517G;
            if (remoteViews3 != null) {
                this.f1557a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            this.f1557a.setBadgeIconType(b.f1519I).setShortcutId(b.f1520J).setTimeoutAfter(b.f1521K).setGroupAlertBehavior(b.f1522L);
            if (b.f1549y) {
                this.f1557a.setColorized(b.f1548x);
            }
            if (!TextUtils.isEmpty(b.f1518H)) {
                this.f1557a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    /* renamed from: a */
    public Builder mo5094a() {
        return this.f1557a;
    }

    /* renamed from: b */
    public Notification mo5138b() {
        C0452d style = this.f1558b.f1538n;
        if (style != null) {
            style.mo5104a((C0446Z) this);
        }
        RemoteViews styleContentView = style != null ? style.mo5127c(this) : null;
        Notification n = mo5139c();
        if (styleContentView != null) {
            n.contentView = styleContentView;
        } else {
            RemoteViews remoteViews = this.f1558b.f1515E;
            if (remoteViews != null) {
                n.contentView = remoteViews;
            }
        }
        if (VERSION.SDK_INT >= 16 && style != null) {
            RemoteViews styleBigContentView = style.mo5126b(this);
            if (styleBigContentView != null) {
                n.bigContentView = styleBigContentView;
            }
        }
        if (VERSION.SDK_INT >= 21 && style != null) {
            RemoteViews styleHeadsUpContentView = this.f1558b.f1538n.mo5128d(this);
            if (styleHeadsUpContentView != null) {
                n.headsUpContentView = styleHeadsUpContentView;
            }
        }
        if (VERSION.SDK_INT >= 16 && style != null) {
            Bundle extras = C0448aa.m2299a(n);
            if (extras != null) {
                style.mo5124a(extras);
            }
        }
        return n;
    }

    /* renamed from: a */
    private void m2350a(C0449a action) {
        Bundle actionExtras;
        int i = VERSION.SDK_INT;
        if (i >= 20) {
            Action.Builder actionBuilder = new Action.Builder(action.mo5100e(), action.mo5102g(), action.mo5096a());
            if (action.mo5101f() != null) {
                for (RemoteInput remoteInput : C0466ea.m2368a(action.mo5101f())) {
                    actionBuilder.addRemoteInput(remoteInput);
                }
            }
            if (action.mo5099d() != null) {
                actionExtras = new Bundle(action.mo5099d());
            } else {
                actionExtras = new Bundle();
            }
            actionExtras.putBoolean("android.support.allowGeneratedReplies", action.mo5097b());
            if (VERSION.SDK_INT >= 24) {
                actionBuilder.setAllowGeneratedReplies(action.mo5097b());
            }
            actionBuilder.addExtras(actionExtras);
            this.f1557a.addAction(actionBuilder.build());
        } else if (i >= 16) {
            this.f1561e.add(C0459ca.m2354a(this.f1557a, action));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Notification mo5139c() {
        int i = VERSION.SDK_INT;
        if (i >= 26) {
            return this.f1557a.build();
        }
        if (i >= 24) {
            Notification notification = this.f1557a.build();
            if (this.f1563g != 0) {
                if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || this.f1563g != 2)) {
                    m2349a(notification);
                }
                if (notification.getGroup() != null && (notification.flags & 512) == 0 && this.f1563g == 1) {
                    m2349a(notification);
                }
            }
            return notification;
        } else if (i >= 21) {
            this.f1557a.setExtras(this.f1562f);
            Notification notification2 = this.f1557a.build();
            RemoteViews remoteViews = this.f1559c;
            if (remoteViews != null) {
                notification2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1560d;
            if (remoteViews2 != null) {
                notification2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f1564h;
            if (remoteViews3 != null) {
                notification2.headsUpContentView = remoteViews3;
            }
            if (this.f1563g != 0) {
                if (!(notification2.getGroup() == null || (notification2.flags & 512) == 0 || this.f1563g != 2)) {
                    m2349a(notification2);
                }
                if (notification2.getGroup() != null && (notification2.flags & 512) == 0 && this.f1563g == 1) {
                    m2349a(notification2);
                }
            }
            return notification2;
        } else if (i >= 20) {
            this.f1557a.setExtras(this.f1562f);
            Notification notification3 = this.f1557a.build();
            RemoteViews remoteViews4 = this.f1559c;
            if (remoteViews4 != null) {
                notification3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1560d;
            if (remoteViews5 != null) {
                notification3.bigContentView = remoteViews5;
            }
            if (this.f1563g != 0) {
                if (!(notification3.getGroup() == null || (notification3.flags & 512) == 0 || this.f1563g != 2)) {
                    m2349a(notification3);
                }
                if (notification3.getGroup() != null && (notification3.flags & 512) == 0 && this.f1563g == 1) {
                    m2349a(notification3);
                }
            }
            return notification3;
        } else {
            String str = "android.support.actionExtras";
            if (i >= 19) {
                SparseArray<Bundle> actionExtrasMap = C0459ca.m2357a(this.f1561e);
                if (actionExtrasMap != null) {
                    this.f1562f.putSparseParcelableArray(str, actionExtrasMap);
                }
                this.f1557a.setExtras(this.f1562f);
                Notification notification4 = this.f1557a.build();
                RemoteViews remoteViews6 = this.f1559c;
                if (remoteViews6 != null) {
                    notification4.contentView = remoteViews6;
                }
                RemoteViews remoteViews7 = this.f1560d;
                if (remoteViews7 != null) {
                    notification4.bigContentView = remoteViews7;
                }
                return notification4;
            } else if (i < 16) {
                return this.f1557a.getNotification();
            } else {
                Notification notification5 = this.f1557a.build();
                Bundle extras = C0448aa.m2299a(notification5);
                Bundle mergeBundle = new Bundle(this.f1562f);
                for (String key : this.f1562f.keySet()) {
                    if (extras.containsKey(key)) {
                        mergeBundle.remove(key);
                    }
                }
                extras.putAll(mergeBundle);
                SparseArray<Bundle> actionExtrasMap2 = C0459ca.m2357a(this.f1561e);
                if (actionExtrasMap2 != null) {
                    C0448aa.m2299a(notification5).putSparseParcelableArray(str, actionExtrasMap2);
                }
                RemoteViews remoteViews8 = this.f1559c;
                if (remoteViews8 != null) {
                    notification5.contentView = remoteViews8;
                }
                RemoteViews remoteViews9 = this.f1560d;
                if (remoteViews9 != null) {
                    notification5.bigContentView = remoteViews9;
                }
                return notification5;
            }
        }
    }

    /* renamed from: a */
    private void m2349a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
