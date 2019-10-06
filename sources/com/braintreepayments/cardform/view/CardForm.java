package com.braintreepayments.cardform.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.design.widget.C0277X;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.braintreepayments.cardform.view.CardEditText.C5899a;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p019d.p151c.p152a.C7270a;
import p019d.p151c.p152a.C7279b;
import p019d.p151c.p152a.C7280c;
import p019d.p151c.p152a.C7284g;
import p019d.p151c.p152a.C7285h;
import p019d.p151c.p152a.C7286i;
import p019d.p151c.p152a.p153a.C7271a;
import p019d.p151c.p152a.p153a.C7278h;

public class CardForm extends LinearLayout implements C5899a, OnFocusChangeListener, OnClickListener, OnEditorActionListener, TextWatcher {

    /* renamed from: a */
    private List<C5900a> f10280a;

    /* renamed from: b */
    private ImageView f10281b;

    /* renamed from: c */
    private CardEditText f10282c;

    /* renamed from: d */
    private ExpirationDateEditText f10283d;

    /* renamed from: e */
    private CvvEditText f10284e;

    /* renamed from: f */
    private ImageView f10285f;

    /* renamed from: g */
    private PostalCodeEditText f10286g;

    /* renamed from: h */
    private ImageView f10287h;

    /* renamed from: i */
    private CountryCodeEditText f10288i;

    /* renamed from: j */
    private MobileNumberEditText f10289j;

    /* renamed from: k */
    private TextView f10290k;

    /* renamed from: l */
    private boolean f10291l;

    /* renamed from: m */
    private boolean f10292m;

    /* renamed from: n */
    private boolean f10293n;

    /* renamed from: o */
    private boolean f10294o;

    /* renamed from: p */
    private boolean f10295p;

    /* renamed from: q */
    private String f10296q;

    /* renamed from: r */
    private boolean f10297r = false;

    /* renamed from: s */
    private C7280c f10298s;

    /* renamed from: t */
    private C7279b f10299t;

    /* renamed from: u */
    private C7270a f10300u;

    /* renamed from: v */
    private C5899a f10301v;

    public CardForm(Context context) {
        super(context);
        m10750i();
    }

    public CardForm(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10750i();
    }

    public CardForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m10750i();
    }

    @TargetApi(21)
    public CardForm(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m10750i();
    }

    /* renamed from: i */
    private void m10750i() {
        setVisibility(8);
        setOrientation(1);
        LinearLayout.inflate(getContext(), C7286i.bt_card_form_fields, this);
        this.f10281b = (ImageView) findViewById(C7285h.bt_card_form_card_number_icon);
        this.f10282c = (CardEditText) findViewById(C7285h.bt_card_form_card_number);
        this.f10283d = (ExpirationDateEditText) findViewById(C7285h.bt_card_form_expiration);
        this.f10284e = (CvvEditText) findViewById(C7285h.bt_card_form_cvv);
        this.f10285f = (ImageView) findViewById(C7285h.bt_card_form_postal_code_icon);
        this.f10286g = (PostalCodeEditText) findViewById(C7285h.bt_card_form_postal_code);
        this.f10287h = (ImageView) findViewById(C7285h.bt_card_form_mobile_number_icon);
        this.f10288i = (CountryCodeEditText) findViewById(C7285h.bt_card_form_country_code);
        this.f10289j = (MobileNumberEditText) findViewById(C7285h.bt_card_form_mobile_number);
        this.f10290k = (TextView) findViewById(C7285h.bt_card_form_mobile_number_explanation);
        this.f10280a = new ArrayList();
        setListeners(this.f10282c);
        setListeners(this.f10283d);
        setListeners(this.f10284e);
        setListeners(this.f10286g);
        setListeners(this.f10289j);
        this.f10282c.setOnCardTypeChangedListener(this);
    }

    /* renamed from: a */
    public CardForm mo18434a(boolean required) {
        this.f10291l = required;
        return this;
    }

    /* renamed from: c */
    public CardForm mo18439c(boolean required) {
        this.f10292m = required;
        return this;
    }

    /* renamed from: b */
    public CardForm mo18437b(boolean required) {
        this.f10293n = required;
        return this;
    }

    /* renamed from: e */
    public CardForm mo18441e(boolean required) {
        this.f10294o = required;
        return this;
    }

    /* renamed from: d */
    public CardForm mo18440d(boolean required) {
        this.f10295p = required;
        return this;
    }

    /* renamed from: b */
    public CardForm mo18436b(String actionLabel) {
        this.f10296q = actionLabel;
        return this;
    }

    public void setup(Activity activity) {
        if (VERSION.SDK_INT >= 14) {
            activity.getWindow().setFlags(Opcodes.ACC_ANNOTATION, Opcodes.ACC_ANNOTATION);
        }
        boolean isDarkBackground = C7278h.m15847a(activity);
        this.f10281b.setImageResource(isDarkBackground ? C7284g.bt_ic_card_dark : C7284g.bt_ic_card);
        this.f10285f.setImageResource(isDarkBackground ? C7284g.bt_ic_postal_code_dark : C7284g.bt_ic_postal_code);
        this.f10287h.setImageResource(isDarkBackground ? C7284g.bt_ic_mobile_number_dark : C7284g.bt_ic_mobile_number);
        this.f10283d.setActivity(activity);
        m10747a((View) this.f10281b, this.f10291l);
        m10749a((C5900a) this.f10282c, this.f10291l);
        m10749a((C5900a) this.f10283d, this.f10292m);
        m10749a((C5900a) this.f10284e, this.f10293n);
        m10747a((View) this.f10285f, this.f10294o);
        m10749a((C5900a) this.f10286g, this.f10294o);
        m10747a((View) this.f10287h, this.f10295p);
        m10749a((C5900a) this.f10288i, this.f10295p);
        m10749a((C5900a) this.f10289j, this.f10295p);
        m10747a((View) this.f10290k, this.f10295p);
        for (int i = 0; i < this.f10280a.size(); i++) {
            C0277X editText = (C0277X) this.f10280a.get(i);
            if (i == this.f10280a.size() - 1) {
                editText.setImeOptions(2);
                editText.setImeActionLabel(this.f10296q, 2);
                editText.setOnEditorActionListener(this);
            } else {
                editText.setImeOptions(5);
                editText.setImeActionLabel(null, 1);
                editText.setOnEditorActionListener(null);
            }
        }
        setVisibility(0);
    }

    public void setCardNumberIcon(int res) {
        this.f10281b.setImageResource(res);
    }

    public void setPostalCodeIcon(int res) {
        this.f10285f.setImageResource(res);
    }

    public void setMobileNumberIcon(int res) {
        this.f10287h.setImageResource(res);
    }

    private void setListeners(EditText editText) {
        editText.setOnFocusChangeListener(this);
        editText.setOnClickListener(this);
        editText.addTextChangedListener(this);
    }

    /* renamed from: a */
    private void m10747a(View view, boolean visible) {
        view.setVisibility(visible ? 0 : 8);
    }

    /* renamed from: a */
    private void m10749a(C5900a editText, boolean visible) {
        m10747a((View) editText, visible);
        if (editText.getTextInputLayoutParent() != null) {
            m10747a((View) editText.getTextInputLayoutParent(), visible);
        }
        if (visible) {
            this.f10280a.add(editText);
        } else {
            this.f10280a.remove(editText);
        }
    }

    public void setOnCardFormValidListener(C7280c listener) {
        this.f10298s = listener;
    }

    public void setOnCardFormSubmitListener(C7279b listener) {
        this.f10299t = listener;
    }

    public void setOnFormFieldFocusedListener(C7270a listener) {
        this.f10300u = listener;
    }

    public void setOnCardTypeChangedListener(C5899a listener) {
        this.f10301v = listener;
    }

    public void setEnabled(boolean enabled) {
        this.f10282c.setEnabled(enabled);
        this.f10283d.setEnabled(enabled);
        this.f10284e.setEnabled(enabled);
        this.f10286g.setEnabled(enabled);
        this.f10289j.setEnabled(enabled);
    }

    /* renamed from: h */
    public boolean mo18455h() {
        boolean valid = true;
        boolean z = true;
        if (this.f10291l) {
            valid = 1 != 0 && this.f10282c.mo18431k();
        }
        if (this.f10292m) {
            valid = valid && this.f10283d.mo18431k();
        }
        if (this.f10293n) {
            valid = valid && this.f10284e.mo18431k();
        }
        if (this.f10294o) {
            valid = valid && this.f10286g.mo18431k();
        }
        if (!this.f10295p) {
            return valid;
        }
        if (!valid || !this.f10288i.mo18431k() || !this.f10289j.mo18431k()) {
            z = false;
        }
        return z;
    }

    public CardEditText getCardEditText() {
        return this.f10282c;
    }

    public ExpirationDateEditText getExpirationDateEditText() {
        return this.f10283d;
    }

    public CvvEditText getCvvEditText() {
        return this.f10284e;
    }

    public PostalCodeEditText getPostalCodeEditText() {
        return this.f10286g;
    }

    public CountryCodeEditText getCountryCodeEditText() {
        return this.f10288i;
    }

    public MobileNumberEditText getMobileNumberEditText() {
        return this.f10289j;
    }

    public void setCardNumberError(String errorMessage) {
        if (this.f10291l) {
            this.f10282c.setError(errorMessage);
            m10748a((EditText) this.f10282c);
        }
    }

    public void setExpirationError(String errorMessage) {
        if (this.f10292m) {
            this.f10283d.setError(errorMessage);
            if (!this.f10282c.isFocused()) {
                m10748a((EditText) this.f10283d);
            }
        }
    }

    public void setCvvError(String errorMessage) {
        if (this.f10293n) {
            this.f10284e.setError(errorMessage);
            if (!this.f10282c.isFocused() && !this.f10283d.isFocused()) {
                m10748a((EditText) this.f10284e);
            }
        }
    }

    public void setPostalCodeError(String errorMessage) {
        if (this.f10294o) {
            this.f10286g.setError(errorMessage);
            if (!this.f10282c.isFocused() && !this.f10283d.isFocused() && !this.f10284e.isFocused()) {
                m10748a((EditText) this.f10286g);
            }
        }
    }

    public void setCountryCodeError(String errorMessage) {
        if (this.f10295p) {
            this.f10288i.setError(errorMessage);
            if (!this.f10282c.isFocused() && !this.f10283d.isFocused() && !this.f10284e.isFocused() && !this.f10286g.isFocused()) {
                m10748a((EditText) this.f10288i);
            }
        }
    }

    public void setMobileNumberError(String errorMessage) {
        if (this.f10295p) {
            this.f10289j.setError(errorMessage);
            if (!this.f10282c.isFocused() && !this.f10283d.isFocused() && !this.f10284e.isFocused() && !this.f10286g.isFocused() && !this.f10288i.isFocused()) {
                m10748a((EditText) this.f10289j);
            }
        }
    }

    /* renamed from: a */
    private void m10748a(EditText editText) {
        editText.requestFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(editText, 1);
    }

    public String getCardNumber() {
        return this.f10282c.getText().toString();
    }

    public String getExpirationMonth() {
        return this.f10283d.getMonth();
    }

    public String getExpirationYear() {
        return this.f10283d.getYear();
    }

    public String getCvv() {
        return this.f10284e.getText().toString();
    }

    public String getPostalCode() {
        return this.f10286g.getText().toString();
    }

    public String getCountryCode() {
        return this.f10288i.getCountryCode();
    }

    public String getMobileNumber() {
        return this.f10289j.getMobileNumber();
    }

    /* renamed from: a */
    public void mo18433a(C7271a cardType) {
        this.f10284e.setCardType(cardType);
        C5899a aVar = this.f10301v;
        if (aVar != null) {
            aVar.mo18433a(cardType);
        }
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            C7270a aVar = this.f10300u;
            if (aVar != null) {
                aVar.mo23488a(v);
            }
        }
    }

    public void onClick(View v) {
        C7270a aVar = this.f10300u;
        if (aVar != null) {
            aVar.mo23488a(v);
        }
    }

    public void afterTextChanged(Editable s) {
        boolean valid = mo18455h();
        if (this.f10297r != valid) {
            this.f10297r = valid;
            C7280c cVar = this.f10298s;
            if (cVar != null) {
                cVar.mo11334a(valid);
            }
        }
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == 2) {
            C7279b bVar = this.f10299t;
            if (bVar != null) {
                bVar.mo11335a();
                return true;
            }
        }
        return false;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
}
