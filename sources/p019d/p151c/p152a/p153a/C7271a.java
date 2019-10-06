package p019d.p151c.p152a.p153a;

import android.text.TextUtils;
import java.util.regex.Pattern;
import p019d.p151c.p152a.C7284g;
import p019d.p151c.p152a.C7287j;

/* renamed from: d.c.a.a.a */
/* compiled from: CardType */
public enum C7271a {
    VISA("^4\\d*", C7284g.bt_ic_visa, 16, 16, 3, C7287j.bt_cvv),
    MASTERCARD("^(5[1-5]|222[1-9]|22[3-9]|2[3-6]|27[0-1]|2720)\\d*", C7284g.bt_ic_mastercard, 16, 16, 3, C7287j.bt_cvc),
    DISCOVER("^(6011|65|64[4-9]|622)\\d*", C7284g.bt_ic_discover, 16, 16, 3, C7287j.bt_cid),
    AMEX("^3[47]\\d*", C7284g.bt_ic_amex, 15, 15, 4, C7287j.bt_cid),
    DINERS_CLUB("^(36|38|30[0-5])\\d*", C7284g.bt_ic_diners_club, 14, 14, 3, C7287j.bt_cvv),
    JCB("^35\\d*", C7284g.bt_ic_jcb, 16, 16, 3, C7287j.bt_cvv),
    MAESTRO("^(5018|5020|5038|6020|6304|6703|6759|676[1-3])\\d*", C7284g.bt_ic_maestro, 12, 19, 3, C7287j.bt_cvc),
    UNIONPAY("^62\\d*", C7284g.bt_ic_unionpay, 16, 19, 3, C7287j.bt_cvn),
    UNKNOWN("\\d+", C7284g.bt_ic_unknown, 12, 19, 3, C7287j.bt_cvv),
    EMPTY("^$", C7284g.bt_ic_unknown, 12, 19, 3, C7287j.bt_cvv);
    

    /* renamed from: k */
    private static final int[] f14125k = null;

    /* renamed from: l */
    private static final int[] f14126l = null;

    /* renamed from: n */
    private final Pattern f14128n;

    /* renamed from: o */
    private final int f14129o;

    /* renamed from: p */
    private final int f14130p;

    /* renamed from: q */
    private final int f14131q;

    /* renamed from: r */
    private final int f14132r;

    /* renamed from: s */
    private final int f14133s;

    static {
        f14125k = new int[]{4, 10};
        f14126l = new int[]{4, 8, 12};
    }

    private C7271a(String regex, int frontResource, int minCardLength, int maxCardLength, int securityCodeLength, int securityCodeName) {
        this.f14128n = Pattern.compile(regex);
        this.f14129o = frontResource;
        this.f14130p = minCardLength;
        this.f14131q = maxCardLength;
        this.f14132r = securityCodeLength;
        this.f14133s = securityCodeName;
    }

    /* renamed from: a */
    public static C7271a m15821a(String cardNumber) {
        C7271a[] values;
        for (C7271a cardType : values()) {
            if (cardType.mo23492g().matcher(cardNumber).matches()) {
                return cardType;
            }
        }
        return EMPTY;
    }

    /* renamed from: g */
    public Pattern mo23492g() {
        return this.f14128n;
    }

    /* renamed from: e */
    public int mo23490e() {
        return this.f14129o;
    }

    /* renamed from: j */
    public int mo23494j() {
        return this.f14133s;
    }

    /* renamed from: i */
    public int mo23493i() {
        return this.f14132r;
    }

    /* renamed from: f */
    public int mo23491f() {
        return this.f14131q;
    }

    /* renamed from: s */
    public int[] mo23495s() {
        return this == AMEX ? f14125k : f14126l;
    }

    /* renamed from: b */
    public static boolean m15822b(String cardNumber) {
        String reversed = new StringBuffer(cardNumber).reverse().toString();
        int len = reversed.length();
        int oddSum = 0;
        int evenSum = 0;
        int i = 0;
        while (i < len) {
            char c = reversed.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.digit(c, 10);
                if (i % 2 == 0) {
                    oddSum += digit;
                } else {
                    evenSum += (digit / 5) + ((digit * 2) % 10);
                }
                i++;
            } else {
                throw new IllegalArgumentException(String.format("Not a digit: '%s'", new Object[]{Character.valueOf(c)}));
            }
        }
        if ((oddSum + evenSum) % 10 == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo23489c(String cardNumber) {
        if (TextUtils.isEmpty(cardNumber)) {
            return false;
        }
        int numberLength = cardNumber.length();
        if (numberLength < this.f14130p || numberLength > this.f14131q || !this.f14128n.matcher(cardNumber).matches()) {
            return false;
        }
        return m15822b(cardNumber);
    }
}
