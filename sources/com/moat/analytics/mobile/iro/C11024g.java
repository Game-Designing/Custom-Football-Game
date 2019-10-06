package com.moat.analytics.mobile.iro;

import android.support.p001v7.widget.LinearLayoutManager;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.iro.g */
abstract class C11024g extends C11016d {

    /* renamed from: ˋॱ */
    private int f33698 = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: ˏॱ */
    private double f33699 = Double.NaN;

    /* renamed from: ͺ */
    private int f33700 = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: ॱˊ */
    private int f33701 = C11026a.f33707;

    /* renamed from: ॱˋ */
    private int f33702 = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: ॱˎ */
    private int f33703 = 0;

    /* renamed from: com.moat.analytics.mobile.iro.g$a */
    enum C11026a {
        ;
        

        /* renamed from: ˊ */
        public static final int f33705 = 0;

        /* renamed from: ˋ */
        public static final int f33706 = 0;

        /* renamed from: ˎ */
        public static final int f33707 = 0;

        /* renamed from: ˏ */
        public static final int f33708 = 0;

        /* renamed from: ॱ */
        public static final int f33709 = 0;

        static {
            f33707 = 1;
            f33709 = 2;
            f33705 = 3;
            f33706 = 4;
            f33708 = 5;
            int[] iArr = {1, 2, 3, 4, 5};
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ʻॱ */
    public abstract Integer mo36090();

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋॱ */
    public abstract Integer mo36092();

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱˊ */
    public abstract boolean mo36093();

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱˎ */
    public abstract boolean mo36094();

    C11024g(String str) {
        super(str);
    }

    /* renamed from: ˋ */
    public final boolean mo36071(Map<String, String> map, View view) {
        try {
            boolean r4 = super.mo36071(map, view);
            if (!r4) {
                return r4;
            }
            this.f33661.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        if (!C11024g.this.mo36093() || C11024g.this.mo36073()) {
                            C11024g.this.mo36074();
                        } else if (Boolean.valueOf(C11024g.this.mo36091()).booleanValue()) {
                            C11024g.this.f33661.postDelayed(this, 200);
                        } else {
                            C11024g.this.mo36074();
                        }
                    } catch (Exception e) {
                        C11024g.this.mo36074();
                        C11043o.m36351(e);
                    }
                }
            }, 200);
            return r4;
        } catch (Exception e) {
            C11011b.m36234(3, "IntervalVideoTracker", this, "Problem with video loop");
            mo36063("trackVideoAd", e);
            return false;
        }
    }

    public void stopTracking() {
        try {
            dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            super.stopTracking();
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    public void setPlayerVolume(Double d) {
        super.setPlayerVolume(d);
        this.f33699 = mo36075().doubleValue();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public final JSONObject mo36070(MoatAdEvent moatAdEvent) {
        Integer num;
        if (!moatAdEvent.f33622.equals(MoatAdEvent.f33619)) {
            num = moatAdEvent.f33622;
        } else {
            try {
                num = mo36092();
            } catch (Exception e) {
                num = Integer.valueOf(this.f33700);
            }
            moatAdEvent.f33622 = num;
        }
        if (moatAdEvent.f33622.intValue() < 0 || (moatAdEvent.f33622.intValue() == 0 && moatAdEvent.f33624 == MoatAdEventType.AD_EVT_COMPLETE && this.f33700 > 0)) {
            num = Integer.valueOf(this.f33700);
            moatAdEvent.f33622 = num;
        }
        if (moatAdEvent.f33624 == MoatAdEventType.AD_EVT_COMPLETE) {
            if (num.intValue() != Integer.MIN_VALUE) {
                int i = this.f33702;
                if (i != Integer.MIN_VALUE && C11016d.m36252(num, Integer.valueOf(i))) {
                    this.f33701 = C11026a.f33708;
                }
            }
            this.f33701 = C11026a.f33706;
            moatAdEvent.f33624 = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo36070(moatAdEvent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ʼॱ */
    public final boolean mo36091() throws C11043o {
        if (!mo36093() || mo36073()) {
            return false;
        }
        try {
            int intValue = mo36092().intValue();
            if (this.f33700 >= 0 && intValue < 0) {
                return false;
            }
            this.f33700 = intValue;
            if (intValue == 0) {
                return true;
            }
            int intValue2 = mo36090().intValue();
            boolean r4 = mo36094();
            double d = (double) intValue2;
            Double.isNaN(d);
            double d2 = d / 4.0d;
            double doubleValue = mo36075().doubleValue();
            MoatAdEventType moatAdEventType = null;
            if (intValue > this.f33698) {
                this.f33698 = intValue;
            }
            if (this.f33702 == Integer.MIN_VALUE) {
                this.f33702 = intValue2;
            }
            if (r4) {
                if (this.f33701 == C11026a.f33707) {
                    moatAdEventType = MoatAdEventType.AD_EVT_START;
                    this.f33701 = C11026a.f33705;
                } else if (this.f33701 == C11026a.f33709) {
                    moatAdEventType = MoatAdEventType.AD_EVT_PLAYING;
                    this.f33701 = C11026a.f33705;
                } else {
                    double d3 = (double) intValue;
                    Double.isNaN(d3);
                    int floor = ((int) Math.floor(d3 / d2)) - 1;
                    if (floor >= 0 && floor < 3) {
                        MoatAdEventType moatAdEventType2 = C11016d.f33658[floor];
                        if (!this.f33659.containsKey(moatAdEventType2)) {
                            this.f33659.put(moatAdEventType2, Integer.valueOf(1));
                            moatAdEventType = moatAdEventType2;
                        }
                    }
                }
            } else if (this.f33701 != C11026a.f33709) {
                moatAdEventType = MoatAdEventType.AD_EVT_PAUSED;
                this.f33701 = C11026a.f33709;
            }
            boolean z = moatAdEventType != null;
            if (!z && !Double.isNaN(this.f33699) && Math.abs(this.f33699 - doubleValue) > 0.05d) {
                moatAdEventType = MoatAdEventType.AD_EVT_VOLUME_CHANGE;
                z = true;
            }
            if (z) {
                dispatchEvent(new MoatAdEvent(moatAdEventType, Integer.valueOf(intValue), mo36072()));
            }
            this.f33699 = doubleValue;
            this.f33703 = 0;
            return true;
        } catch (Exception e) {
            int i = this.f33703;
            this.f33703 = i + 1;
            if (i < 5) {
                return true;
            }
            return false;
        }
    }
}
