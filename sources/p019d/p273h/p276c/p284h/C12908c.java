package p019d.p273h.p276c.p284h;

import android.content.Context;
import android.text.TextUtils;
import java.util.Calendar;
import java.util.TimeZone;
import p019d.p273h.p276c.p281e.C12817i;
import p019d.p273h.p276c.p281e.C12820l;
import p019d.p273h.p276c.p281e.C12822n;
import p019d.p273h.p276c.p281e.C12824o;

/* renamed from: d.h.c.h.c */
/* compiled from: CappingManager */
public class C12908c {

    /* renamed from: d.h.c.h.c$a */
    /* compiled from: CappingManager */
    public enum C12909a {
        CAPPED_PER_DELIVERY,
        CAPPED_PER_COUNT,
        CAPPED_PER_PACE,
        NOT_CAPPED
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m41889a(android.content.Context r4, p019d.p273h.p276c.p281e.C12817i r5) {
        /*
            java.lang.Class<d.h.c.h.c> r0 = p019d.p273h.p276c.p284h.C12908c.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x001e
            if (r5 != 0) goto L_0x0008
            goto L_0x001e
        L_0x0008:
            d.h.c.e.n r1 = r5.mo41494a()     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            java.lang.String r2 = "Interstitial"
            java.lang.String r3 = r5.mo41496c()     // Catch:{ all -> 0x001b }
            m41893a(r4, r2, r3, r1)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return
        L_0x001b:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.p284h.C12908c.m41889a(android.content.Context, d.h.c.e.i):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m41890a(android.content.Context r4, p019d.p273h.p276c.p281e.C12820l r5) {
        /*
            java.lang.Class<d.h.c.h.c> r0 = p019d.p273h.p276c.p284h.C12908c.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x001e
            if (r5 != 0) goto L_0x0008
            goto L_0x001e
        L_0x0008:
            d.h.c.e.n r1 = r5.mo41502a()     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            java.lang.String r2 = "Rewarded Video"
            java.lang.String r3 = r5.mo41504c()     // Catch:{ all -> 0x001b }
            m41893a(r4, r2, r3, r1)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return
        L_0x001b:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.p284h.C12908c.m41890a(android.content.Context, d.h.c.e.l):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m41888a(android.content.Context r4, p019d.p273h.p276c.p281e.C12814f r5) {
        /*
            java.lang.Class<d.h.c.h.c> r0 = p019d.p273h.p276c.p284h.C12908c.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x001e
            if (r5 != 0) goto L_0x0008
            goto L_0x001e
        L_0x0008:
            d.h.c.e.n r1 = r5.mo41494a()     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            java.lang.String r2 = "Banner"
            java.lang.String r3 = r5.mo41496c()     // Catch:{ all -> 0x001b }
            m41893a(r4, r2, r3, r1)     // Catch:{ all -> 0x001b }
            monitor-exit(r0)
            return
        L_0x001b:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x001e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.p284h.C12908c.m41888a(android.content.Context, d.h.c.e.f):void");
    }

    /* renamed from: c */
    public static synchronized C12909a m41898c(Context context, C12817i placement) {
        synchronized (C12908c.class) {
            if (!(context == null || placement == null)) {
                if (placement.mo41494a() != null) {
                    C12909a b = m41894b(context, "Interstitial", placement.mo41496c());
                    return b;
                }
            }
            C12909a aVar = C12909a.NOT_CAPPED;
            return aVar;
        }
    }

    /* renamed from: b */
    public static synchronized boolean m41897b(Context context, String placementName) {
        boolean z;
        synchronized (C12908c.class) {
            z = m41894b(context, "Banner", placementName) != C12909a.NOT_CAPPED;
        }
        return z;
    }

    /* renamed from: c */
    public static synchronized C12909a m41899c(Context context, C12820l placement) {
        synchronized (C12908c.class) {
            if (!(context == null || placement == null)) {
                if (placement.mo41502a() != null) {
                    C12909a b = m41894b(context, "Rewarded Video", placement.mo41504c());
                    return b;
                }
            }
            C12909a aVar = C12909a.NOT_CAPPED;
            return aVar;
        }
    }

    /* renamed from: b */
    public static synchronized void m41895b(Context context, C12817i placement) {
        synchronized (C12908c.class) {
            if (placement != null) {
                m41892a(context, "Interstitial", placement.mo41496c());
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m41896b(Context context, C12820l placement) {
        synchronized (C12908c.class) {
            if (placement != null) {
                m41892a(context, "Rewarded Video", placement.mo41504c());
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m41891a(Context context, String placementName) {
        synchronized (C12908c.class) {
            if (!TextUtils.isEmpty(placementName)) {
                m41892a(context, "Banner", placementName);
            }
        }
    }

    /* renamed from: a */
    private static String m41887a(String adUnit, String baseConst, String placementName) {
        StringBuilder sb = new StringBuilder();
        sb.append(adUnit);
        String str = "_";
        sb.append(str);
        sb.append(baseConst);
        sb.append(str);
        sb.append(placementName);
        return sb.toString();
    }

    /* renamed from: b */
    private static C12909a m41894b(Context context, String adUnit, String placementName) {
        Context context2 = context;
        String str = adUnit;
        String str2 = placementName;
        long currentTime = System.currentTimeMillis();
        if (!C12916j.m41969a(context2, m41887a(str, "CappingManager.IS_DELIVERY_ENABLED", str2), true)) {
            return C12909a.CAPPED_PER_DELIVERY;
        }
        boolean isPacingEnabled = C12916j.m41969a(context2, m41887a(str, "CappingManager.IS_PACING_ENABLED", str2), false);
        if (isPacingEnabled) {
            boolean z = isPacingEnabled;
            if (currentTime - C12916j.m41957a(context2, m41887a(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), 0) < ((long) (C12916j.m41956a(context2, m41887a(str, "CappingManager.SECONDS_BETWEEN_SHOWS", str2), 0) * 1000))) {
                return C12909a.CAPPED_PER_PACE;
            }
        }
        boolean isCappingEnabled = C12916j.m41969a(context2, m41887a(str, "CappingManager.IS_CAPPING_ENABLED", str2), false);
        if (isCappingEnabled) {
            int maxNumberOfShows = C12916j.m41956a(context2, m41887a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String currentNumberOfShowsKey = m41887a(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int currentNumberOfShows = C12916j.m41956a(context2, currentNumberOfShowsKey, 0);
            String timeThresholdKey = m41887a(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2);
            boolean z2 = isCappingEnabled;
            if (currentTime >= C12916j.m41957a(context2, timeThresholdKey, 0)) {
                C12916j.m41976b(context2, currentNumberOfShowsKey, 0);
                C12916j.m41977b(context2, timeThresholdKey, 0);
            } else if (currentNumberOfShows >= maxNumberOfShows) {
                return C12909a.CAPPED_PER_COUNT;
            }
        }
        return C12909a.NOT_CAPPED;
    }

    /* renamed from: a */
    private static void m41892a(Context context, String adUnit, String placementName) {
        Context context2 = context;
        String str = adUnit;
        String str2 = placementName;
        String isPacingEnabledKey = m41887a(str, "CappingManager.IS_PACING_ENABLED", str2);
        boolean isPacingEnabled = C12916j.m41969a(context2, isPacingEnabledKey, false);
        if (isPacingEnabled) {
            C12916j.m41977b(context2, m41887a(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), System.currentTimeMillis());
        }
        if (C12916j.m41969a(context2, m41887a(str, "CappingManager.IS_CAPPING_ENABLED", str2), false)) {
            int a = C12916j.m41956a(context2, m41887a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String currentNumberOfShowsKey = m41887a(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int currentNumberOfShows = C12916j.m41956a(context2, currentNumberOfShowsKey, 0);
            if (currentNumberOfShows == 0) {
                String cappingTypeString = C12916j.m41980c(context2, m41887a(str, "CappingManager.CAPPING_TYPE", str2), C12824o.PER_DAY.toString());
                C12824o cappingType = null;
                C12824o[] values = C12824o.values();
                int length = values.length;
                String str3 = isPacingEnabledKey;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    boolean isPacingEnabled2 = isPacingEnabled;
                    C12824o type = values[i];
                    C12824o[] oVarArr = values;
                    if (type.f39495d.equals(cappingTypeString)) {
                        cappingType = type;
                        break;
                    }
                    i++;
                    isPacingEnabled = isPacingEnabled2;
                    values = oVarArr;
                }
                C12916j.m41977b(context2, m41887a(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2), m41886a(cappingType));
            } else {
                boolean z = isPacingEnabled;
            }
            C12916j.m41976b(context2, currentNumberOfShowsKey, currentNumberOfShows + 1);
            return;
        }
        boolean z2 = isPacingEnabled;
    }

    /* renamed from: a */
    private static long m41886a(C12824o cappingType) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i = C12907b.f39632a[cappingType.ordinal()];
        if (i == 1) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(11, 0);
            calendar.add(6, 1);
        } else if (i == 2) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.add(11, 1);
        }
        return calendar.getTimeInMillis();
    }

    /* renamed from: a */
    private static void m41893a(Context context, String adUnit, String placementName, C12822n availabilitySettings) {
        boolean isDeliveryEnabled = availabilitySettings.mo41513e();
        C12916j.m41978b(context, m41887a(adUnit, "CappingManager.IS_DELIVERY_ENABLED", placementName), isDeliveryEnabled);
        if (isDeliveryEnabled) {
            boolean isCappingEnabled = availabilitySettings.mo41512d();
            C12916j.m41978b(context, m41887a(adUnit, "CappingManager.IS_CAPPING_ENABLED", placementName), isCappingEnabled);
            if (isCappingEnabled) {
                C12916j.m41976b(context, m41887a(adUnit, "CappingManager.MAX_NUMBER_OF_SHOWS", placementName), availabilitySettings.mo41510b());
                C12916j.m41989f(context, m41887a(adUnit, "CappingManager.CAPPING_TYPE", placementName), availabilitySettings.mo41509a().toString());
            }
            boolean isPacingEnabled = availabilitySettings.mo41514f();
            C12916j.m41978b(context, m41887a(adUnit, "CappingManager.IS_PACING_ENABLED", placementName), isPacingEnabled);
            if (isPacingEnabled) {
                C12916j.m41976b(context, m41887a(adUnit, "CappingManager.SECONDS_BETWEEN_SHOWS", placementName), availabilitySettings.mo41511c());
            }
        }
    }
}
