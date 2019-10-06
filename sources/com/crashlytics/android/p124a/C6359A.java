package com.crashlytics.android.p124a;

import android.os.Bundle;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.a.A */
/* compiled from: FirebaseAnalyticsEventMapper */
public class C6359A {

    /* renamed from: a */
    private static final Set<String> f11343a = new HashSet(Arrays.asList(new String[]{"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"}));

    /* renamed from: a */
    public C6403z mo19340a(C6371M event) {
        Bundle bundle;
        String eventName;
        boolean wasFailedEvent = true;
        boolean isCustomEvent = C6373b.CUSTOM.equals(event.f11360c) && event.f11362e != null;
        boolean isPredefinedEvent = C6373b.PREDEFINED.equals(event.f11360c) && event.f11364g != null;
        if (!isCustomEvent && !isPredefinedEvent) {
            return null;
        }
        if (isPredefinedEvent) {
            bundle = m12288b(event);
        } else {
            bundle = new Bundle();
            Map<String, Object> map = event.f11363f;
            if (map != null) {
                m12287a(bundle, map);
            }
        }
        if (isPredefinedEvent) {
            String successBoolean = (String) event.f11365h.get(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION);
            if (successBoolean == null || Boolean.parseBoolean(successBoolean)) {
                wasFailedEvent = false;
            }
            eventName = m12282a(event.f11364g, wasFailedEvent);
        } else {
            eventName = m12291c(event.f11362e);
        }
        C13920f.m44245e().mo43326c("Answers", "Logging event into firebase...");
        return new C6403z(eventName, bundle);
    }

    /* renamed from: c */
    private String m12291c(String eventName) {
        if (eventName == null || eventName.length() == 0) {
            return "fabric_unnamed_event";
        }
        String str = "fabric_";
        if (f11343a.contains(eventName)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(eventName);
            return sb.toString();
        }
        String eventName2 = eventName.replaceAll("[^\\p{Alnum}_]+", "_");
        if (eventName2.startsWith("ga_") || eventName2.startsWith("google_") || eventName2.startsWith("firebase_") || !Character.isLetter(eventName2.charAt(0))) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(eventName2);
            eventName2 = sb2.toString();
        }
        if (eventName2.length() > 40) {
            eventName2 = eventName2.substring(0, 40);
        }
        return eventName2;
    }

    /* renamed from: a */
    private String m12281a(String attributeName) {
        if (attributeName == null || attributeName.length() == 0) {
            return "fabric_unnamed_parameter";
        }
        String attributeName2 = attributeName.replaceAll("[^\\p{Alnum}_]+", "_");
        if (attributeName2.startsWith("ga_") || attributeName2.startsWith("google_") || attributeName2.startsWith("firebase_") || !Character.isLetter(attributeName2.charAt(0))) {
            StringBuilder sb = new StringBuilder();
            sb.append("fabric_");
            sb.append(attributeName2);
            attributeName2 = sb.toString();
        }
        if (attributeName2.length() > 40) {
            return attributeName2.substring(0, 40);
        }
        return attributeName2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r12.equals(r1) != false) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m12282a(java.lang.String r12, boolean r13) {
        /*
            r11 = this;
            r0 = 0
            java.lang.String r1 = "purchase"
            java.lang.String r2 = "signUp"
            r3 = -1
            r4 = 2
            r5 = 1
            java.lang.String r6 = "login"
            if (r13 == 0) goto L_0x0049
            int r7 = r12.hashCode()
            r8 = -902468296(0xffffffffca356d38, float:-2972494.0)
            if (r7 == r8) goto L_0x0030
            r8 = 103149417(0x625ef69, float:3.1208942E-35)
            if (r7 == r8) goto L_0x0028
            r8 = 1743324417(0x67e90501, float:2.2008074E24)
            if (r7 == r8) goto L_0x0020
        L_0x001f:
            goto L_0x0038
        L_0x0020:
            boolean r7 = r12.equals(r1)
            if (r7 == 0) goto L_0x001f
            r7 = 0
            goto L_0x0039
        L_0x0028:
            boolean r7 = r12.equals(r6)
            if (r7 == 0) goto L_0x001f
            r7 = 2
            goto L_0x0039
        L_0x0030:
            boolean r7 = r12.equals(r2)
            if (r7 == 0) goto L_0x001f
            r7 = 1
            goto L_0x0039
        L_0x0038:
            r7 = -1
        L_0x0039:
            if (r7 == 0) goto L_0x0046
            if (r7 == r5) goto L_0x0043
            if (r7 == r4) goto L_0x0040
            goto L_0x0049
        L_0x0040:
            java.lang.String r0 = "failed_login"
            return r0
        L_0x0043:
            java.lang.String r0 = "failed_sign_up"
            return r0
        L_0x0046:
            java.lang.String r0 = "failed_ecommerce_purchase"
            return r0
        L_0x0049:
            int r7 = r12.hashCode()
            java.lang.String r8 = "share"
            java.lang.String r9 = "search"
            java.lang.String r10 = "invite"
            switch(r7) {
                case -2131650889: goto L_0x00be;
                case -1183699191: goto L_0x00b5;
                case -938102371: goto L_0x00ab;
                case -906336856: goto L_0x00a3;
                case -902468296: goto L_0x009b;
                case -389087554: goto L_0x0091;
                case 23457852: goto L_0x0087;
                case 103149417: goto L_0x007e;
                case 109400031: goto L_0x0076;
                case 196004670: goto L_0x006b;
                case 1664021448: goto L_0x0060;
                case 1743324417: goto L_0x0058;
                default: goto L_0x0056;
            }
        L_0x0056:
            goto L_0x00c9
        L_0x0058:
            boolean r1 = r12.equals(r1)
            if (r1 == 0) goto L_0x0056
            goto L_0x00ca
        L_0x0060:
            java.lang.String r0 = "startCheckout"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0056
            r0 = 2
            goto L_0x00ca
        L_0x006b:
            java.lang.String r0 = "levelStart"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0056
            r0 = 10
            goto L_0x00ca
        L_0x0076:
            boolean r0 = r12.equals(r8)
            if (r0 == 0) goto L_0x0056
            r0 = 5
            goto L_0x00ca
        L_0x007e:
            boolean r0 = r12.equals(r6)
            if (r0 == 0) goto L_0x0056
            r0 = 8
            goto L_0x00ca
        L_0x0087:
            java.lang.String r0 = "addToCart"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0056
            r0 = 1
            goto L_0x00ca
        L_0x0091:
            java.lang.String r0 = "contentView"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0056
            r0 = 3
            goto L_0x00ca
        L_0x009b:
            boolean r0 = r12.equals(r2)
            if (r0 == 0) goto L_0x0056
            r0 = 7
            goto L_0x00ca
        L_0x00a3:
            boolean r0 = r12.equals(r9)
            if (r0 == 0) goto L_0x0056
            r0 = 4
            goto L_0x00ca
        L_0x00ab:
            java.lang.String r0 = "rating"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0056
            r0 = 6
            goto L_0x00ca
        L_0x00b5:
            boolean r0 = r12.equals(r10)
            if (r0 == 0) goto L_0x0056
            r0 = 9
            goto L_0x00ca
        L_0x00be:
            java.lang.String r0 = "levelEnd"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0056
            r0 = 11
            goto L_0x00ca
        L_0x00c9:
            r0 = -1
        L_0x00ca:
            switch(r0) {
                case 0: goto L_0x00eb;
                case 1: goto L_0x00e8;
                case 2: goto L_0x00e5;
                case 3: goto L_0x00e2;
                case 4: goto L_0x00e1;
                case 5: goto L_0x00e0;
                case 6: goto L_0x00dd;
                case 7: goto L_0x00da;
                case 8: goto L_0x00d9;
                case 9: goto L_0x00d8;
                case 10: goto L_0x00d5;
                case 11: goto L_0x00d2;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            java.lang.String r0 = r11.m12291c(r12)
            return r0
        L_0x00d2:
            java.lang.String r0 = "level_end"
            return r0
        L_0x00d5:
            java.lang.String r0 = "level_start"
            return r0
        L_0x00d8:
            return r10
        L_0x00d9:
            return r6
        L_0x00da:
            java.lang.String r0 = "sign_up"
            return r0
        L_0x00dd:
            java.lang.String r0 = "rate_content"
            return r0
        L_0x00e0:
            return r8
        L_0x00e1:
            return r9
        L_0x00e2:
            java.lang.String r0 = "select_content"
            return r0
        L_0x00e5:
            java.lang.String r0 = "begin_checkout"
            return r0
        L_0x00e8:
            java.lang.String r0 = "add_to_cart"
            return r0
        L_0x00eb:
            java.lang.String r0 = "ecommerce_purchase"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.p124a.C6359A.m12282a(java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: b */
    private Bundle m12288b(C6371M event) {
        Bundle bundle = new Bundle();
        boolean equals = "purchase".equals(event.f11364g);
        String str = "itemType";
        String str2 = "item_category";
        String str3 = "itemName";
        String str4 = "itemId";
        String str5 = "itemPrice";
        String str6 = DonationsAnalytics.VALUE;
        String str7 = "item_name";
        String str8 = "item_id";
        String str9 = "currency";
        if (equals) {
            m12286a(bundle, str8, (String) event.f11365h.get(str4));
            m12286a(bundle, str7, (String) event.f11365h.get(str3));
            m12286a(bundle, str2, (String) event.f11365h.get(str));
            m12283a(bundle, str6, m12289b(event.f11365h.get(str5)));
            m12286a(bundle, str9, (String) event.f11365h.get(str9));
        } else {
            if ("addToCart".equals(event.f11364g)) {
                m12286a(bundle, str8, (String) event.f11365h.get(str4));
                m12286a(bundle, str7, (String) event.f11365h.get(str3));
                m12286a(bundle, str2, (String) event.f11365h.get(str));
                m12283a(bundle, "price", m12289b(event.f11365h.get(str5)));
                m12283a(bundle, str6, m12289b(event.f11365h.get(str5)));
                m12286a(bundle, str9, (String) event.f11365h.get(str9));
                bundle.putLong("quantity", 1);
            } else {
                if ("startCheckout".equals(event.f11364g)) {
                    m12285a(bundle, "quantity", Long.valueOf((long) ((Integer) event.f11365h.get("itemCount")).intValue()));
                    m12283a(bundle, str6, m12289b(event.f11365h.get("totalPrice")));
                    m12286a(bundle, str9, (String) event.f11365h.get(str9));
                } else {
                    String str10 = "contentName";
                    String str11 = "contentId";
                    String str12 = "contentType";
                    String str13 = "content_type";
                    if ("contentView".equals(event.f11364g)) {
                        m12286a(bundle, str13, (String) event.f11365h.get(str12));
                        m12286a(bundle, str8, (String) event.f11365h.get(str11));
                        m12286a(bundle, str7, (String) event.f11365h.get(str10));
                    } else {
                        if ("search".equals(event.f11364g)) {
                            m12286a(bundle, "search_term", (String) event.f11365h.get("query"));
                        } else {
                            String str14 = "method";
                            if ("share".equals(event.f11364g)) {
                                m12286a(bundle, str14, (String) event.f11365h.get(str14));
                                m12286a(bundle, str13, (String) event.f11365h.get(str12));
                                m12286a(bundle, str8, (String) event.f11365h.get(str11));
                                m12286a(bundle, str7, (String) event.f11365h.get(str10));
                            } else {
                                String str15 = "rating";
                                if (str15.equals(event.f11364g)) {
                                    m12286a(bundle, str15, String.valueOf(event.f11365h.get(str15)));
                                    m12286a(bundle, str13, (String) event.f11365h.get(str12));
                                    m12286a(bundle, str8, (String) event.f11365h.get(str11));
                                    m12286a(bundle, str7, (String) event.f11365h.get(str10));
                                } else {
                                    if ("signUp".equals(event.f11364g)) {
                                        m12286a(bundle, str14, (String) event.f11365h.get(str14));
                                    } else {
                                        if ("login".equals(event.f11364g)) {
                                            m12286a(bundle, str14, (String) event.f11365h.get(str14));
                                        } else {
                                            if ("invite".equals(event.f11364g)) {
                                                m12286a(bundle, str14, (String) event.f11365h.get(str14));
                                            } else {
                                                if ("levelStart".equals(event.f11364g)) {
                                                    m12286a(bundle, "level_name", (String) event.f11365h.get("levelName"));
                                                } else {
                                                    if ("levelEnd".equals(event.f11364g)) {
                                                        m12283a(bundle, "score", m12280a(event.f11365h.get("score")));
                                                        m12286a(bundle, "level_name", (String) event.f11365h.get("levelName"));
                                                        m12284a(bundle, RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION, m12290b((String) event.f11365h.get(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        m12287a(bundle, event.f11363f);
        return bundle;
    }

    /* renamed from: a */
    private void m12285a(Bundle bundle, String param, Long longValue) {
        if (longValue != null) {
            bundle.putLong(param, longValue.longValue());
        }
    }

    /* renamed from: a */
    private void m12284a(Bundle bundle, String param, Integer intValue) {
        if (intValue != null) {
            bundle.putInt(param, intValue.intValue());
        }
    }

    /* renamed from: a */
    private void m12286a(Bundle bundle, String param, String stringValue) {
        if (stringValue != null) {
            bundle.putString(param, stringValue);
        }
    }

    /* renamed from: a */
    private void m12283a(Bundle bundle, String param, Double doubleValue) {
        Double mappedDouble = m12280a((Object) doubleValue);
        if (mappedDouble != null) {
            bundle.putDouble(param, mappedDouble.doubleValue());
        }
    }

    /* renamed from: a */
    private Double m12280a(Object doubleObj) {
        String doubleString = String.valueOf(doubleObj);
        if (doubleString == null) {
            return null;
        }
        return Double.valueOf(doubleString);
    }

    /* renamed from: b */
    private Integer m12290b(String truthyString) {
        if (truthyString == null) {
            return null;
        }
        return Integer.valueOf(truthyString.equals("true") ? 1 : 0);
    }

    /* renamed from: b */
    private Double m12289b(Object o) {
        if (((Long) o) == null) {
            return null;
        }
        return Double.valueOf(new BigDecimal(((Long) o).longValue()).divide(C6377a.f11398c).doubleValue());
    }

    /* renamed from: a */
    private void m12287a(Bundle mutatedBundle, Map<String, Object> customAttributes) {
        for (Entry<String, Object> o : customAttributes.entrySet()) {
            Object value = o.getValue();
            String attributeKey = m12281a((String) o.getKey());
            if (value instanceof String) {
                mutatedBundle.putString(attributeKey, o.getValue().toString());
            } else if (value instanceof Double) {
                mutatedBundle.putDouble(attributeKey, ((Double) o.getValue()).doubleValue());
            } else if (value instanceof Long) {
                mutatedBundle.putLong(attributeKey, ((Long) o.getValue()).longValue());
            } else if (value instanceof Integer) {
                mutatedBundle.putInt(attributeKey, ((Integer) o.getValue()).intValue());
            }
        }
    }
}
