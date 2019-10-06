package com.paypal.android.sdk;

import android.util.Log;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

/* renamed from: com.paypal.android.sdk.jb */
public final class C11836jb {

    /* renamed from: a */
    private static List f37244a = Arrays.asList(new String[]{"AUD", "BRL", "CAD", "CHF", "CZK", "DKK", "EUR", "GBP", "HKD", "HUF", "ILS", "JPY", "MXN", "MYR", "NOK", "NZD", "PHP", "PLN", "RUB", "SEK", "SGD", "THB", "TWD", "TRY", "USD"});

    /* renamed from: b */
    private static String f37245b = "JPY, HUF, TWD";

    /* renamed from: c */
    private static final Locale f37246c = Locale.US;

    /* renamed from: d */
    private static final Locale f37247d = Locale.GERMANY;

    /* renamed from: e */
    private static List f37248e = null;

    /* renamed from: f */
    private static NumberFormat f37249f = null;

    /* renamed from: a */
    public static String m39178a(double d, String str) {
        return m39179a(d, str, (DecimalFormat) NumberFormat.getInstance(f37246c));
    }

    /* renamed from: a */
    private static String m39179a(double d, String str, DecimalFormat decimalFormat) {
        decimalFormat.applyPattern(f37245b.indexOf(str.toUpperCase(Locale.US)) == -1 ? "#####0.00" : "#######0");
        return decimalFormat.format(d);
    }

    /* renamed from: a */
    public static String m39180a(double d, Currency currency) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(m39181a(currency).equals(",") ? f37247d : f37246c);
        decimalFormat.applyPattern(f37245b.indexOf(currency.getCurrencyCode().toUpperCase(Locale.US)) == -1 ? "#####0.00" : "#######0");
        return decimalFormat.format(d);
    }

    /* renamed from: a */
    private static String m39181a(Currency currency) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setCurrency(currency);
        String format = decimalFormat.format(1.56d);
        String str = ".";
        return format.indexOf(str) > 0 ? str : ",";
    }

    /* renamed from: a */
    public static String m39182a(Locale locale, String str, double d, String str2, boolean z) {
        String str3;
        String symbol = Currency.getInstance(str2).getSymbol();
        Currency instance = Currency.getInstance(str2);
        if (f37249f == null) {
            f37249f = NumberFormat.getCurrencyInstance(locale);
        }
        f37249f.setCurrency(instance);
        boolean z2 = !(f37249f.format(1234.56d).indexOf("1") == 0);
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        String str5 = " ";
        if (z2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(symbol);
            sb2.append(str5);
            str3 = sb2.toString();
        } else {
            str3 = str4;
        }
        sb.append(str3);
        String str6 = "GBP";
        String str7 = "EUR";
        if (str.equalsIgnoreCase("AU")) {
            str6 = "AUD";
        } else if (!str.equalsIgnoreCase("GB") && !str.equalsIgnoreCase("UK")) {
            if (str.equalsIgnoreCase("CA")) {
                str6 = "CAD";
            } else {
                if (!str.equalsIgnoreCase("AT")) {
                    if (str.equalsIgnoreCase("CZ")) {
                        str6 = "CZK";
                    } else if (str.equalsIgnoreCase("DK")) {
                        str6 = "DKK";
                    } else if (!str.equalsIgnoreCase("FR") && !str.equalsIgnoreCase("DE")) {
                        if (str.equalsIgnoreCase("HU")) {
                            str6 = "HUF";
                        } else if (!str.equalsIgnoreCase("IE") && !str.equalsIgnoreCase("IT") && !str.equalsIgnoreCase("NL")) {
                            if (str.equalsIgnoreCase("PL")) {
                                str6 = "PLN";
                            } else if (!str.equalsIgnoreCase("PT") && !str.equalsIgnoreCase("ES")) {
                                if (str.equalsIgnoreCase("SE")) {
                                    str6 = "SEK";
                                } else {
                                    if (!str.equalsIgnoreCase("ZA")) {
                                        if (str.equalsIgnoreCase("NZ")) {
                                            str6 = "NZD";
                                        } else if (!str.equalsIgnoreCase("LT")) {
                                            if (str.equalsIgnoreCase("JP")) {
                                                str6 = "JPY";
                                            } else if (str.equalsIgnoreCase("BR")) {
                                                str6 = "BRL";
                                            } else if (str.equalsIgnoreCase("MY")) {
                                                str6 = "MYR";
                                            } else if (str.equalsIgnoreCase("MX")) {
                                                str6 = "MXN";
                                            } else if (str.equalsIgnoreCase("RU")) {
                                                str6 = "RUB";
                                            }
                                        }
                                    }
                                    str6 = "USD";
                                }
                            }
                        }
                    }
                }
                str6 = str7;
            }
        }
        sb.append(m39179a(d, str2, (DecimalFormat) NumberFormat.getInstance(m39181a(Currency.getInstance(str6)).equals(",") ? f37247d : f37246c)));
        if (!z2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str5);
            sb3.append(symbol);
            str4 = sb3.toString();
        }
        sb.append(str4);
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m39183a(String str) {
        if (str == null) {
            return false;
        }
        try {
            Currency instance = Currency.getInstance(str);
            if (f37248e == null) {
                f37248e = new ArrayList();
                for (String instance2 : f37244a) {
                    f37248e.add(Currency.getInstance(instance2));
                }
                Collections.sort(f37248e, new C11840kb());
            }
            return f37248e.contains(instance);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m39184a(BigDecimal bigDecimal, String str, boolean z) {
        String sb;
        String str2 = "paypal.sdk";
        if (bigDecimal == null) {
            sb = "The specified amount is null.";
        } else if (!z || BigDecimal.ZERO.compareTo(bigDecimal) == -1) {
            if (m39183a(str)) {
                if (Arrays.asList(new String[]{"HUF", "JPY", "TWD"}).contains(str) && bigDecimal.scale() > 0) {
                    StringBuilder sb2 = new StringBuilder("The specified currency (");
                    sb2.append(str);
                    sb2.append(") does not support fractional amounts.");
                    sb = sb2.toString();
                }
            }
            return true;
        } else {
            sb = "The specified amount must be greater than zero.";
        }
        Log.e(str2, sb);
        return false;
    }
}
