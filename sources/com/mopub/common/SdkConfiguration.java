package com.mopub.common;

import com.mopub.common.logging.MoPubLog.LogLevel;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SdkConfiguration {

    /* renamed from: a */
    private final String f111a;

    /* renamed from: b */
    private final Set<String> f112b;

    /* renamed from: c */
    private final MediationSettings[] f113c;

    /* renamed from: d */
    private final Map<String, Map<String, String>> f114d;

    /* renamed from: e */
    private final Map<String, Map<String, String>> f115e;

    /* renamed from: f */
    private final LogLevel f116f;

    /* renamed from: g */
    private final boolean f117g;

    public static class Builder {

        /* renamed from: a */
        private String f118a;

        /* renamed from: b */
        private final Set<String> f119b;

        /* renamed from: c */
        private MediationSettings[] f120c;

        /* renamed from: d */
        private LogLevel f121d = LogLevel.NONE;

        /* renamed from: e */
        private final Map<String, Map<String, String>> f122e;

        /* renamed from: f */
        private final Map<String, Map<String, String>> f123f;

        /* renamed from: g */
        private boolean f124g;

        public Builder(String adUnitId) {
            this.f118a = adUnitId;
            this.f119b = DefaultAdapterClasses.getClassNamesSet();
            this.f120c = new MediationSettings[0];
            this.f122e = new HashMap();
            this.f123f = new HashMap();
            this.f124g = false;
        }

        public Builder withAdditionalNetwork(String adapterConfigurationClass) {
            Preconditions.checkNotNull(adapterConfigurationClass);
            this.f119b.add(adapterConfigurationClass);
            return this;
        }

        public Builder withMediationSettings(MediationSettings... mediationSettings) {
            Preconditions.checkNotNull(mediationSettings);
            this.f120c = mediationSettings;
            return this;
        }

        public Builder withLogLevel(LogLevel logLevel) {
            Preconditions.checkNotNull(logLevel);
            this.f121d = logLevel;
            return this;
        }

        public Builder withMediatedNetworkConfiguration(String adapterConfigurationClass, Map<String, String> mediatedNetworkConfiguration) {
            Preconditions.checkNotNull(adapterConfigurationClass);
            Preconditions.checkNotNull(mediatedNetworkConfiguration);
            this.f122e.put(adapterConfigurationClass, mediatedNetworkConfiguration);
            return this;
        }

        public Builder withMoPubRequestOptions(String adapterConfigurationClass, Map<String, String> mopubRequestOptions) {
            Preconditions.checkNotNull(adapterConfigurationClass);
            Preconditions.checkNotNull(mopubRequestOptions);
            this.f123f.put(adapterConfigurationClass, mopubRequestOptions);
            return this;
        }

        public Builder withLegitimateInterestAllowed(boolean legitimateInterestAllowed) {
            this.f124g = legitimateInterestAllowed;
            return this;
        }

        public SdkConfiguration build() {
            SdkConfiguration sdkConfiguration = new SdkConfiguration(this.f118a, this.f119b, this.f120c, this.f121d, this.f122e, this.f123f, this.f124g);
            return sdkConfiguration;
        }
    }

    private SdkConfiguration(String adUnitId, Set<String> adapterConfigurationClasses, MediationSettings[] mediationSettings, LogLevel logLevel, Map<String, Map<String, String>> mediatedNetworkConfigurations, Map<String, Map<String, String>> moPubRequestOptions, boolean legitimateInterestAllowed) {
        Preconditions.checkNotNull(adUnitId);
        Preconditions.checkNotNull(adapterConfigurationClasses);
        Preconditions.checkNotNull(mediatedNetworkConfigurations);
        Preconditions.checkNotNull(moPubRequestOptions);
        this.f111a = adUnitId;
        this.f112b = adapterConfigurationClasses;
        this.f113c = mediationSettings;
        this.f116f = logLevel;
        this.f114d = mediatedNetworkConfigurations;
        this.f115e = moPubRequestOptions;
        this.f117g = legitimateInterestAllowed;
    }

    public String getAdUnitId() {
        return this.f111a;
    }

    public Set<String> getAdapterConfigurationClasses() {
        return Collections.unmodifiableSet(this.f112b);
    }

    public MediationSettings[] getMediationSettings() {
        MediationSettings[] mediationSettingsArr = this.f113c;
        return (MediationSettings[]) Arrays.copyOf(mediationSettingsArr, mediationSettingsArr.length);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public LogLevel mo3275a() {
        return this.f116f;
    }

    public Map<String, Map<String, String>> getMediatedNetworkConfigurations() {
        return Collections.unmodifiableMap(this.f114d);
    }

    public Map<String, Map<String, String>> getMoPubRequestOptions() {
        return Collections.unmodifiableMap(this.f115e);
    }

    public boolean getLegitimateInterestAllowed() {
        return this.f117g;
    }
}
