package com.mopub.mobileads;

import android.text.TextUtils;
import android.util.Pair;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.RewardedAdData.TwoPartKey;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: com.mopub.mobileads.ra */
/* compiled from: RewardedAdData */
class C11442ra {

    /* renamed from: a */
    private final Map<String, CustomEventRewardedAd> f35355a = new TreeMap();

    /* renamed from: b */
    private final Map<String, MoPubReward> f35356b = new TreeMap();

    /* renamed from: c */
    private final Map<String, Set<MoPubReward>> f35357c = new TreeMap();

    /* renamed from: d */
    private final Map<String, String> f35358d = new TreeMap();

    /* renamed from: e */
    private final Map<String, String> f35359e = new TreeMap();

    /* renamed from: f */
    private final Map<Class<? extends CustomEventRewardedAd>, MoPubReward> f35360f = new HashMap();

    /* renamed from: g */
    private final Map<C11443a, Set<String>> f35361g = new HashMap();

    /* renamed from: h */
    private String f35362h;

    /* renamed from: i */
    private String f35363i;

    /* renamed from: com.mopub.mobileads.ra$a */
    /* compiled from: RewardedAdData */
    private static class C11443a extends Pair<Class<? extends CustomEventRewardedAd>, String> {

        /* renamed from: a */
        final Class<? extends CustomEventRewardedAd> f35364a;

        /* renamed from: b */
        final String f35365b;

        public C11443a(Class<? extends CustomEventRewardedAd> customEventClass, String adNetworkId) {
            super(customEventClass, adNetworkId);
            this.f35364a = customEventClass;
            this.f35365b = adNetworkId;
        }
    }

    C11442ra() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public CustomEventRewardedAd mo37520c(String moPubId) {
        return (CustomEventRewardedAd) this.f35355a.get(moPubId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public MoPubReward mo37521d(String moPubId) {
        return (MoPubReward) this.f35356b.get(moPubId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo37517b(String moPubId) {
        return (String) this.f35359e.get(moPubId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37515a(String moPubId, String currencyName, String currencyAmount) {
        Preconditions.checkNotNull(moPubId);
        if (currencyName == null || currencyAmount == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Currency name and amount cannot be null: name = %s, amount = %s", new Object[]{currencyName, currencyAmount}));
            return;
        }
        try {
            int intCurrencyAmount = Integer.parseInt(currencyAmount);
            if (intCurrencyAmount < 0) {
                MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Currency amount cannot be negative: %s", new Object[]{currencyAmount}));
                return;
            }
            if (this.f35357c.containsKey(moPubId)) {
                ((Set) this.f35357c.get(moPubId)).add(MoPubReward.success(currencyName, intCurrencyAmount));
            } else {
                HashSet<MoPubReward> availableRewards = new HashSet<>();
                availableRewards.add(MoPubReward.success(currencyName, intCurrencyAmount));
                this.f35357c.put(moPubId, availableRewards);
            }
        } catch (NumberFormatException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Currency amount must be an integer: %s", new Object[]{currencyAmount}));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Set<MoPubReward> mo37509a(String moPubId) {
        Preconditions.checkNotNull(moPubId);
        Set<MoPubReward> availableRewards = (Set) this.f35357c.get(moPubId);
        return availableRewards == null ? Collections.emptySet() : availableRewards;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37512a(String moPubId, MoPubReward selectedReward) {
        Preconditions.checkNotNull(moPubId);
        Preconditions.checkNotNull(selectedReward);
        Set<MoPubReward> availableRewards = (Set) this.f35357c.get(moPubId);
        if (availableRewards == null || availableRewards.isEmpty()) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "AdUnit %s does not have any rewards.", new Object[]{moPubId}));
        } else if (!availableRewards.contains(selectedReward)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Selected reward is invalid for AdUnit %s.", new Object[]{moPubId}));
        } else {
            mo37519b(moPubId, selectedReward.getLabel(), Integer.toString(selectedReward.getAmount()));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo37523f(String moPubId) {
        Preconditions.checkNotNull(moPubId);
        Set<MoPubReward> availableRewards = (Set) this.f35357c.get(moPubId);
        if (availableRewards != null && !availableRewards.isEmpty()) {
            availableRewards.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo37524g(String moPubId) {
        Preconditions.checkNotNull(moPubId);
        mo37519b(moPubId, null, null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo37522e(String moPubId) {
        if (TextUtils.isEmpty(moPubId)) {
            return null;
        }
        return (String) this.f35358d.get(moPubId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public MoPubReward mo37506a(Class<? extends CustomEventRewardedAd> customEventClass) {
        return (MoPubReward) this.f35360f.get(customEventClass);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Set<String> mo37508a(Class<? extends CustomEventRewardedAd> customEventClass, String adNetworkId) {
        Set<String> set;
        if (adNetworkId == null) {
            Set<String> allIds = new HashSet<>();
            for (Entry<TwoPartKey, Set<String>> entry : this.f35361g.entrySet()) {
                if (customEventClass == ((C11443a) entry.getKey()).f35364a) {
                    allIds.addAll((Collection) entry.getValue());
                }
            }
            return allIds;
        }
        C11443a key = new C11443a(customEventClass, adNetworkId);
        if (this.f35361g.containsKey(key)) {
            set = (Set) this.f35361g.get(key);
        } else {
            set = Collections.emptySet();
        }
        return set;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37513a(String moPubId, CustomEventRewardedAd customEvent, String adNetworkId) {
        this.f35355a.put(moPubId, customEvent);
        mo37511a(customEvent.getClass(), adNetworkId, moPubId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37519b(String moPubId, String currencyName, String currencyAmount) {
        Preconditions.checkNotNull(moPubId);
        if (currencyName == null || currencyAmount == null) {
            this.f35356b.remove(moPubId);
            return;
        }
        try {
            int intCurrencyAmount = Integer.parseInt(currencyAmount);
            if (intCurrencyAmount < 0) {
                MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Currency amount cannot be negative: %s", new Object[]{currencyAmount}));
                return;
            }
            this.f35356b.put(moPubId, MoPubReward.success(currencyName, intCurrencyAmount));
        } catch (NumberFormatException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format(Locale.US, "Currency amount must be an integer: %s", new Object[]{currencyAmount}));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37518b(String moPubId, String serverCompletionUrl) {
        Preconditions.checkNotNull(moPubId);
        this.f35358d.put(moPubId, serverCompletionUrl);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37510a(Class<? extends CustomEventRewardedAd> customEventClass, MoPubReward moPubReward) {
        Preconditions.checkNotNull(customEventClass);
        this.f35360f.put(customEventClass, moPubReward);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37511a(Class<? extends CustomEventRewardedAd> customEventClass, String adNetworkId, String moPubId) {
        C11443a newCustomEventMapping = new C11443a(customEventClass, adNetworkId);
        Iterator<Entry<TwoPartKey, Set<String>>> entryIterator = this.f35361g.entrySet().iterator();
        while (true) {
            if (!entryIterator.hasNext()) {
                break;
            }
            Entry<TwoPartKey, Set<String>> entry = (Entry) entryIterator.next();
            if (!((C11443a) entry.getKey()).equals(newCustomEventMapping) && ((Set) entry.getValue()).contains(moPubId)) {
                ((Set) entry.getValue()).remove(moPubId);
                if (((Set) entry.getValue()).isEmpty()) {
                    entryIterator.remove();
                }
            }
        }
        Set set = (Set) this.f35361g.get(newCustomEventMapping);
        if (set == null) {
            set = new HashSet();
            this.f35361g.put(newCustomEventMapping, set);
        }
        set.add(moPubId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo37525h(String currentAdUnitId) {
        this.f35362h = currentAdUnitId;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37514a(String moPubId, String customData) {
        NoThrow.checkNotNull(moPubId);
        this.f35359e.put(moPubId, customData);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo37507a() {
        return this.f35362h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo37526i(String customerId) {
        this.f35363i = customerId;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo37516b() {
        return this.f35363i;
    }
}
