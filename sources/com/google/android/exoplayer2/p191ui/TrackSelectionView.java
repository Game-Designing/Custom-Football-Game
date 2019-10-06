package com.google.android.exoplayer2.p191ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.C8430g.C8431a;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride;
import com.google.android.exoplayer2.util.C8514e;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.ui.TrackSelectionView */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: a */
    private final int f18540a;

    /* renamed from: b */
    private final LayoutInflater f18541b;

    /* renamed from: c */
    private final CheckedTextView f18542c;

    /* renamed from: d */
    private final CheckedTextView f18543d;

    /* renamed from: e */
    private final C8441a f18544e;

    /* renamed from: f */
    private boolean f18545f;

    /* renamed from: g */
    private C8451i f18546g;

    /* renamed from: h */
    private CheckedTextView[][] f18547h;

    /* renamed from: i */
    private DefaultTrackSelector f18548i;

    /* renamed from: j */
    private int f18549j;

    /* renamed from: k */
    private TrackGroupArray f18550k;

    /* renamed from: l */
    private boolean f18551l;

    /* renamed from: m */
    private SelectionOverride f18552m;

    /* renamed from: com.google.android.exoplayer2.ui.TrackSelectionView$a */
    private class C8441a implements OnClickListener {
        private C8441a() {
        }

        public void onClick(View view) {
            TrackSelectionView.this.m20125a(view);
        }
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public TrackSelectionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TrackSelectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray attributeArray = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        this.f18540a = attributeArray.getResourceId(0, 0);
        attributeArray.recycle();
        this.f18541b = LayoutInflater.from(context);
        this.f18544e = new C8441a();
        this.f18546g = new C8444c(getResources());
        this.f18542c = (CheckedTextView) this.f18541b.inflate(17367055, this, false);
        this.f18542c.setBackgroundResource(this.f18540a);
        this.f18542c.setText(C8446e.exo_track_selection_none);
        this.f18542c.setEnabled(false);
        this.f18542c.setFocusable(true);
        this.f18542c.setOnClickListener(this.f18544e);
        this.f18542c.setVisibility(8);
        addView(this.f18542c);
        addView(this.f18541b.inflate(C8445d.exo_list_divider, this, false));
        this.f18543d = (CheckedTextView) this.f18541b.inflate(17367055, this, false);
        this.f18543d.setBackgroundResource(this.f18540a);
        this.f18543d.setText(C8446e.exo_track_selection_auto);
        this.f18543d.setEnabled(false);
        this.f18543d.setFocusable(true);
        this.f18543d.setOnClickListener(this.f18544e);
        addView(this.f18543d);
    }

    public void setAllowAdaptiveSelections(boolean allowAdaptiveSelections) {
        if (this.f18545f != allowAdaptiveSelections) {
            this.f18545f = allowAdaptiveSelections;
            m20132d();
        }
    }

    public void setShowDisableOption(boolean showDisableOption) {
        this.f18542c.setVisibility(showDisableOption ? 0 : 8);
    }

    public void setTrackNameProvider(C8451i trackNameProvider) {
        C8514e.m20486a(trackNameProvider);
        this.f18546g = trackNameProvider;
        m20132d();
    }

    /* renamed from: d */
    private void m20132d() {
        C8431a trackInfo;
        for (int i = getChildCount() - 1; i >= 3; i--) {
            removeViewAt(i);
        }
        DefaultTrackSelector defaultTrackSelector = this.f18548i;
        if (defaultTrackSelector == null) {
            trackInfo = null;
        } else {
            trackInfo = defaultTrackSelector.mo25848b();
        }
        if (this.f18548i == null || trackInfo == null) {
            this.f18542c.setEnabled(false);
            this.f18543d.setEnabled(false);
            return;
        }
        this.f18542c.setEnabled(true);
        this.f18543d.setEnabled(true);
        this.f18550k = trackInfo.mo25854b(this.f18549j);
        Parameters parameters = this.f18548i.mo25810c();
        this.f18551l = parameters.mo25812a(this.f18549j);
        this.f18552m = parameters.mo25811a(this.f18549j, this.f18550k);
        this.f18547h = new CheckedTextView[this.f18550k.f18155b][];
        int groupIndex = 0;
        while (true) {
            TrackGroupArray trackGroupArray = this.f18550k;
            if (groupIndex < trackGroupArray.f18155b) {
                TrackGroup group = trackGroupArray.mo25651a(groupIndex);
                boolean enableAdaptiveSelections = this.f18545f && this.f18550k.mo25651a(groupIndex).f18151a > 1 && trackInfo.mo25852a(this.f18549j, groupIndex, false) != 0;
                this.f18547h[groupIndex] = new CheckedTextView[group.f18151a];
                for (int trackIndex = 0; trackIndex < group.f18151a; trackIndex++) {
                    if (trackIndex == 0) {
                        addView(this.f18541b.inflate(C8445d.exo_list_divider, this, false));
                    }
                    CheckedTextView trackView = (CheckedTextView) this.f18541b.inflate(enableAdaptiveSelections ? 17367056 : 17367055, this, false);
                    trackView.setBackgroundResource(this.f18540a);
                    trackView.setText(this.f18546g.mo25912a(group.mo25645a(trackIndex)));
                    if (trackInfo.mo25851a(this.f18549j, groupIndex, trackIndex) == 4) {
                        trackView.setFocusable(true);
                        trackView.setTag(Pair.create(Integer.valueOf(groupIndex), Integer.valueOf(trackIndex)));
                        trackView.setOnClickListener(this.f18544e);
                    } else {
                        trackView.setFocusable(false);
                        trackView.setEnabled(false);
                    }
                    this.f18547h[groupIndex][trackIndex] = trackView;
                    addView(trackView);
                }
                groupIndex++;
            } else {
                m20131c();
                return;
            }
        }
    }

    /* renamed from: c */
    private void m20131c() {
        this.f18542c.setChecked(this.f18551l);
        this.f18543d.setChecked(!this.f18551l && this.f18552m == null);
        int i = 0;
        while (i < this.f18547h.length) {
            int j = 0;
            while (true) {
                CheckedTextView[][] checkedTextViewArr = this.f18547h;
                if (j >= checkedTextViewArr[i].length) {
                    break;
                }
                CheckedTextView checkedTextView = checkedTextViewArr[i][j];
                SelectionOverride selectionOverride = this.f18552m;
                checkedTextView.setChecked(selectionOverride != null && selectionOverride.f18424a == i && selectionOverride.mo25818a(j));
                j++;
            }
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20125a(View view) {
        if (view == this.f18542c) {
            m20128b();
        } else if (view == this.f18543d) {
            m20124a();
        } else {
            m20129b(view);
        }
        m20131c();
    }

    /* renamed from: b */
    private void m20128b() {
        this.f18551l = true;
        this.f18552m = null;
    }

    /* renamed from: a */
    private void m20124a() {
        this.f18551l = false;
        this.f18552m = null;
    }

    /* renamed from: b */
    private void m20129b(View view) {
        this.f18551l = false;
        Pair<Integer, Integer> tag = (Pair) view.getTag();
        int groupIndex = ((Integer) tag.first).intValue();
        int trackIndex = ((Integer) tag.second).intValue();
        SelectionOverride selectionOverride = this.f18552m;
        if (selectionOverride == null || selectionOverride.f18424a != groupIndex || !this.f18545f) {
            this.f18552m = new SelectionOverride(groupIndex, trackIndex);
            return;
        }
        int overrideLength = selectionOverride.f18426c;
        int[] overrideTracks = selectionOverride.f18425b;
        if (!((CheckedTextView) view).isChecked()) {
            this.f18552m = new SelectionOverride(groupIndex, m20127a(overrideTracks, trackIndex));
        } else if (overrideLength == 1) {
            this.f18552m = null;
            this.f18551l = true;
        } else {
            this.f18552m = new SelectionOverride(groupIndex, m20130b(overrideTracks, trackIndex));
        }
    }

    /* renamed from: a */
    private static int[] m20127a(int[] tracks, int addedTrack) {
        int[] tracks2 = Arrays.copyOf(tracks, tracks.length + 1);
        tracks2[tracks2.length - 1] = addedTrack;
        return tracks2;
    }

    /* renamed from: b */
    private static int[] m20130b(int[] tracks, int removedTrack) {
        int[] newTracks = new int[(tracks.length - 1)];
        int trackCount = 0;
        for (int track : tracks) {
            if (track != removedTrack) {
                int trackCount2 = trackCount + 1;
                newTracks[trackCount] = track;
                trackCount = trackCount2;
            }
        }
        return newTracks;
    }
}
