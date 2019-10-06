package com.adyen.p081ui.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import com.adyen.p081ui.p084c.C5628b;
import java.util.ArrayList;
import java.util.Calendar;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.adyen.ui.views.ExpiryDateEditText */
public class ExpiryDateEditText extends C5651l {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C5628b f9545a;

    /* renamed from: com.adyen.ui.views.ExpiryDateEditText$a */
    class C5637a implements TextWatcher {

        /* renamed from: a */
        private final String f9546a = String.valueOf('/');

        /* renamed from: b */
        private boolean f9547b;

        C5637a() {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            this.f9547b = count == 0;
        }

        public void afterTextChanged(Editable s) {
            ExpiryDateEditText.this.removeTextChangedListener(this);
            int length = s.length();
            String str = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
            if (length == 1 && s.charAt(0) > '1') {
                s.insert(0, str);
            }
            if (s.length() == 2 && !this.f9547b) {
                if (s.toString().matches("\\d/")) {
                    s.insert(0, str);
                } else if (!s.toString().contains(this.f9546a)) {
                    s.append('/');
                }
            }
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (i == 2) {
                    if (c != '/') {
                        if (!Character.isDigit(c)) {
                            s.replace(i, i + 1, this.f9546a);
                        } else {
                            s.insert(i, this.f9546a);
                            if (this.f9547b) {
                                int selectionStart = ExpiryDateEditText.this.getSelectionStart();
                                int selectionEnd = ExpiryDateEditText.this.getSelectionEnd();
                                ExpiryDateEditText.this.setSelection(selectionStart + -1 == i ? selectionStart - 1 : selectionStart, selectionEnd + -1 == i ? selectionEnd - 1 : selectionEnd);
                            }
                        }
                    }
                } else if (!Character.isDigit(c)) {
                    s.delete(i, i + 1);
                }
                i++;
            }
            boolean inputDateValid = ExpiryDateEditText.this.m9957a(s.toString());
            if (ExpiryDateEditText.this.f9545a != null) {
                ExpiryDateEditText.this.f9545a.mo17782a(ExpiryDateEditText.this, inputDateValid);
            }
            if (inputDateValid) {
                View next = ExpiryDateEditText.this.focusSearch(66);
                if (next != null) {
                    next.requestFocus();
                }
            }
            ExpiryDateEditText.this.addTextChangedListener(this);
        }
    }

    /* renamed from: a */
    private void m9955a() {
        ArrayList<InputFilter> dateFilters = new ArrayList<>();
        dateFilters.add(new LengthFilter(5));
        setFilters((InputFilter[]) dateFilters.toArray(new InputFilter[dateFilters.size()]));
        addTextChangedListener(new C5637a());
        setOnFocusChangeListener(new C5659q(this));
    }

    public ExpiryDateEditText(Context context) {
        super(context);
        m9955a();
    }

    public ExpiryDateEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m9955a();
    }

    public ExpiryDateEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m9955a();
    }

    @TargetApi(21)
    public ExpiryDateEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m9955a();
    }

    public void setValidator(C5628b validator) {
        this.f9545a = validator;
        this.f9545a.mo17781a((View) this);
    }

    public String getMonth() {
        return getText().toString().substring(0, 2);
    }

    public String getFullYear() {
        StringBuilder sb = new StringBuilder();
        sb.append("20");
        sb.append(getText().toString().substring(3, 5));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m9957a(String dateStr) {
        boolean z = false;
        if (dateStr.length() != 5) {
            return false;
        }
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(1) - 2000;
        int currentMonth = c.get(2) + 1;
        if ((Integer.parseInt(dateStr.substring(3, 5)) * 12) + Integer.parseInt(dateStr.substring(0, 2)) >= ((currentYear * 12) + currentMonth) - 3) {
            z = true;
        }
        return z;
    }
}
