package p019d.p135a.p136a.p142e;

import android.util.Log;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import p019d.p135a.p136a.p139c.C6878a;

/* renamed from: d.a.a.e.a */
/* compiled from: AmountUtil */
public final class C6901a {

    /* renamed from: a */
    private static final String f12677a = C6901a.class.getSimpleName();

    private C6901a() {
    }

    /* renamed from: a */
    public static String m14038a(C6878a amount, boolean includeCurrencyCode, Locale locale) {
        long amountValue = amount.mo22301b();
        String currencyCode = amount.mo22300a();
        String valueString = m14037a(amountValue, m14040b(currencyCode), locale);
        if (!includeCurrencyCode) {
            return valueString;
        }
        String currencySymbol = m14039a(currencyCode);
        StringBuilder amountStringBuilder = new StringBuilder(currencySymbol);
        if (currencySymbol.length() > 1) {
            amountStringBuilder.append(" ");
        }
        amountStringBuilder.append(valueString);
        return amountStringBuilder.toString();
    }

    /* renamed from: a */
    public static String m14037a(long amountValue, int exponent, Locale locale) {
        long j = amountValue;
        int i = exponent;
        if (i > 0) {
            String sign = j < 0 ? "-" : "";
            long absAmountValue = Math.abs(amountValue);
            long power = 1;
            for (int i2 = 0; i2 < i; i2++) {
                power *= 10;
            }
            String str = "d";
            if (locale != null) {
                DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(locale);
                String highValue = NumberFormat.getInstance(locale).format(absAmountValue / power);
                StringBuilder sb = new StringBuilder();
                sb.append("%s%s%s%0");
                sb.append(i);
                sb.append(str);
                return String.format(sb.toString(), new Object[]{sign, highValue, Character.valueOf(dfs.getDecimalSeparator()), Long.valueOf(absAmountValue % power)});
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("%s%d.%0");
            sb2.append(i);
            sb2.append(str);
            return String.format(sb2.toString(), new Object[]{sign, Long.valueOf(absAmountValue / power), Long.valueOf(absAmountValue % power)});
        } else if (locale != null) {
            return NumberFormat.getInstance(locale).format(j);
        } else {
            return String.valueOf(amountValue);
        }
    }

    /* renamed from: a */
    private static String m14039a(String currencyCode) {
        Currency currency = null;
        try {
            currency = Currency.getInstance(currencyCode);
        } catch (IllegalArgumentException e) {
        }
        return currency != null ? currency.getSymbol() : currencyCode;
    }

    /* renamed from: b */
    private static int m14040b(String currencyCode) {
        if ("ISK".equals(currencyCode) || "CLP".equals(currencyCode) || "MXP".equals(currencyCode)) {
            return 2;
        }
        if ("MRO".equals(currencyCode)) {
            return 1;
        }
        if ("IDR".equals(currencyCode) || "VND".equals(currencyCode) || "UGX".equals(currencyCode) || "CVE".equals(currencyCode)) {
            return 0;
        }
        if ("ZMW".equals(currencyCode)) {
            return 2;
        }
        if ("GHC".equals(currencyCode) || "BYR".equals(currencyCode)) {
            return 0;
        }
        if ("BYN".equals(currencyCode) || "RSD".equals(currencyCode)) {
            return 2;
        }
        Currency curr = null;
        try {
            curr = Currency.getInstance(currencyCode);
        } catch (IllegalArgumentException exception) {
            Log.d(f12677a, "Currency is incorrect: ", exception);
        }
        int exponent = 0;
        if (curr != null) {
            exponent = curr.getDefaultFractionDigits();
            if (exponent == -1) {
                exponent = 0;
            }
        }
        return exponent;
    }
}
