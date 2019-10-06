package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.regex.Pattern;

public class InneractiveUserConfig {

    /* renamed from: a */
    private int f15410a = -1;

    /* renamed from: b */
    private Gender f15411b = null;

    /* renamed from: c */
    private String f15412c = null;

    public enum Gender {
        MALE,
        FEMALE
    }

    public InneractiveUserConfig setAge(int i) {
        if (i <= 0 || i > 120) {
            IAlog.m18023d("The Age is invalid. Please use a number between 1 and 120");
        } else {
            this.f15410a = i;
        }
        return this;
    }

    public int getAge() {
        return this.f15410a;
    }

    public InneractiveUserConfig setGender(Gender gender) {
        if (gender != null) {
            this.f15411b = gender;
        } else {
            IAlog.m18023d("The gender is invalid. Please use one of the suggested InneractiveAdView.Gender");
        }
        return this;
    }

    public Gender getGender() {
        return this.f15411b;
    }

    public InneractiveUserConfig setZipCode(String str) {
        if (str == null || !Pattern.compile("(^\\d{5}$)|(^\\d{5}-\\d{4}$)").matcher(str).matches()) {
            IAlog.m18022c("The zipcode format is invalid. Please use a valid value.");
        } else {
            this.f15412c = str;
        }
        return this;
    }

    public String getZipCode() {
        return this.f15412c;
    }
}
