package com.adyen.p081ui.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import com.adyen.p081ui.p083b.C5598f.C5599a;
import com.adyen.p081ui.p084c.C5628b;
import com.adyen.p081ui.p084c.C5630c;
import com.adyen.utils.CardType;
import com.adyen.utils.Luhn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import p019d.p135a.p136a.p142e.C6907g;
import p019d.p135a.p136a.p142e.C6912j;

/* renamed from: com.adyen.ui.views.CreditCardEditText */
public class CreditCardEditText extends C5651l {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C5628b f9535a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CVCEditText f9536b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f9537c;

    /* renamed from: d */
    private String f9538d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, C5599a> f9539e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Integer[] f9540f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<C5635a> f9541g = new CopyOnWriteArrayList();

    /* renamed from: com.adyen.ui.views.CreditCardEditText$a */
    public interface C5635a {
        /* renamed from: a */
        void mo17734a(C5599a aVar);
    }

    /* renamed from: com.adyen.ui.views.CreditCardEditText$b */
    private class C5636b implements TextWatcher {

        /* renamed from: a */
        private final String f9542a;

        /* renamed from: b */
        private boolean f9543b;

        private C5636b() {
            this.f9542a = String.valueOf(' ');
        }

        /* synthetic */ C5636b(CreditCardEditText x0, C5655m x1) {
            this();
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            this.f9543b = count == 0;
        }

        public void afterTextChanged(Editable s) {
            CreditCardEditText.this.removeTextChangedListener(this);
            int length = s.length();
            int nextGroupStart = 4;
            int i = 0;
            while (i < length) {
                char c = s.charAt(i);
                if (i == nextGroupStart) {
                    if (c != ' ') {
                        if (!Character.isDigit(c)) {
                            s.replace(i, i + 1, this.f9542a);
                        } else {
                            s.insert(i, this.f9542a);
                            length = s.length();
                            if (this.f9543b) {
                                int selectionStart = CreditCardEditText.this.getSelectionStart();
                                int selectionEnd = CreditCardEditText.this.getSelectionEnd();
                                CreditCardEditText.this.setSelection(selectionStart + -1 == i ? selectionStart - 1 : selectionStart, selectionEnd + -1 == i ? selectionEnd - 1 : selectionEnd);
                            }
                        }
                    }
                    nextGroupStart += 5;
                } else if (!Character.isDigit(c)) {
                    s.delete(i, i + 1);
                    length = s.length();
                }
                i++;
            }
            CreditCardEditText.this.addTextChangedListener(this);
            int cvcLength = 3;
            CardType cardType = CardType.detect(s.toString().replace(" ", ""), new ArrayList<>(CreditCardEditText.this.f9539e.keySet()));
            if (cardType == CardType.amex) {
                cvcLength = 4;
            }
            if (cardType != CardType.UNKNOWN) {
                if (!C6912j.m14060a(CreditCardEditText.this.f9537c)) {
                    Context context = CreditCardEditText.this.getContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(CreditCardEditText.this.f9537c);
                    sb.append(cardType);
                    sb.append(".png");
                    C6907g.m14048a(CreditCardEditText.this.getContext(), new C5658p(this), C5630c.m9930a(context, sb.toString()), null);
                }
                CreditCardEditText.this.f9540f = cardType.getNumberOfDigits();
            } else {
                CreditCardEditText.this.mo17792a();
                CreditCardEditText.this.f9540f = null;
            }
            if (CreditCardEditText.this.f9536b != null) {
                for (C5635a cvcFieldStatusListener : CreditCardEditText.this.f9541g) {
                    cvcFieldStatusListener.mo17734a((C5599a) CreditCardEditText.this.f9539e.get(cardType.name()));
                }
                CreditCardEditText.this.f9536b.setMaxLength(cvcLength);
            }
            if (CreditCardEditText.this.f9535a != null) {
                C5628b e = CreditCardEditText.this.f9535a;
                CreditCardEditText creditCardEditText = CreditCardEditText.this;
                e.mo17782a(creditCardEditText, creditCardEditText.m9947b(s.toString()));
            }
        }
    }

    /* renamed from: b */
    private void m9946b() {
        ArrayList<InputFilter> cardNoFilters = new ArrayList<>();
        cardNoFilters.add(new LengthFilter(23));
        cardNoFilters.add(new C5655m(this));
        setFilters((InputFilter[]) cardNoFilters.toArray(new InputFilter[cardNoFilters.size()]));
        addTextChangedListener(new C5636b(this, null));
        setOnFocusChangeListener(new C5656n(this));
    }

    public CreditCardEditText(Context context) {
        super(context);
        m9946b();
    }

    public CreditCardEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m9946b();
    }

    public CreditCardEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m9946b();
    }

    /* renamed from: a */
    public void mo17793a(C5635a cvcFieldStatusListener) {
        this.f9541g.add(cvcFieldStatusListener);
    }

    public void setValidator(C5628b validator) {
        this.f9535a = validator;
        this.f9535a.mo17781a((View) this);
    }

    public String getCCNumber() {
        return getText().toString().replace(" ", "");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m9947b(String str) {
        boolean luhn = Luhn.check(str);
        boolean length = false;
        Integer[] numArr = this.f9540f;
        if (numArr != null) {
            boolean length2 = false;
            for (Integer i : numArr) {
                if (str.replaceAll(" ", "").length() == i.intValue()) {
                    length2 = true;
                }
            }
            length = length2;
        }
        if (!luhn || !length) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void setCCIcon(Bitmap bitmap) {
        setCompoundDrawablesWithIntrinsicBounds(C5630c.m9927a(getContext(), bitmap, (int) getTextSize()), null, null, null);
    }

    public void setCVCEditText(CVCEditText cvcEditText) {
        this.f9536b = cvcEditText;
    }

    public void setLogoUrl(String cardIconUrl) {
        this.f9538d = cardIconUrl;
        this.f9537c = m9940a(cardIconUrl);
    }

    /* renamed from: a */
    public void mo17792a() {
        if (!C6912j.m14060a(this.f9538d)) {
            C6907g.m14048a(getContext(), new C5657o(this), C5630c.m9930a(getContext(), this.f9538d), null);
        }
    }

    /* renamed from: a */
    private String m9940a(String logoUrl) {
        int lastIndexOfSeparator = logoUrl.lastIndexOf("/");
        if (lastIndexOfSeparator == -1) {
            return "";
        }
        return logoUrl.substring(0, lastIndexOfSeparator + 1);
    }

    public void setAllowedCardTypes(Map<String, C5599a> allowedCardTypes) {
        this.f9539e = allowedCardTypes;
    }
}
