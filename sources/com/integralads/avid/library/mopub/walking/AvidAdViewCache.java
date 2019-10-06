package com.integralads.avid.library.mopub.walking;

import android.view.View;
import android.view.ViewParent;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.utils.AvidViewUtil;
import com.integralads.avid.library.mopub.weakreference.AvidView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class AvidAdViewCache {
    private final AvidAdSessionRegistry adSessionRegistry;
    private final HashMap<View, String> adViews = new HashMap<>();
    private final HashMap<View, ArrayList<String>> friendlyObstructions = new HashMap<>();
    private final HashSet<String> hiddenSessionIds = new HashSet<>();
    private boolean isAdViewProcessed;
    private final HashSet<View> rootViews = new HashSet<>();
    private final HashSet<String> visibleSessionIds = new HashSet<>();

    public AvidAdViewCache(AvidAdSessionRegistry adSessionRegistry2) {
        this.adSessionRegistry = adSessionRegistry2;
    }

    public HashSet<String> getVisibleSessionIds() {
        return this.visibleSessionIds;
    }

    public HashSet<String> getHiddenSessionIds() {
        return this.hiddenSessionIds;
    }

    public void prepare() {
        for (InternalAvidAdSession adSession : this.adSessionRegistry.getInternalAvidAdSessions()) {
            View adView = adSession.getView();
            if (adSession.isActive() && adView != null) {
                if (buildRootViews(adView)) {
                    this.visibleSessionIds.add(adSession.getAvidAdSessionId());
                    this.adViews.put(adView, adSession.getAvidAdSessionId());
                    prepareFriendlyObstructions(adSession);
                } else {
                    this.hiddenSessionIds.add(adSession.getAvidAdSessionId());
                }
            }
        }
    }

    private boolean buildRootViews(View adView) {
        if (!adView.hasWindowFocus()) {
            return false;
        }
        HashSet<View> temp = new HashSet<>();
        View view = adView;
        while (view != null) {
            if (!AvidViewUtil.isViewVisible(view)) {
                return false;
            }
            temp.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.rootViews.addAll(temp);
        return true;
    }

    private void prepareFriendlyObstructions(InternalAvidAdSession adSession) {
        Iterator it = adSession.getObstructionsWhiteList().getWhiteList().iterator();
        while (it.hasNext()) {
            AvidView avidView = (AvidView) it.next();
            if (!avidView.isEmpty()) {
                addFriendlyObstruction((View) avidView.get(), adSession);
            }
        }
    }

    private void addFriendlyObstruction(View obstruction, InternalAvidAdSession adSession) {
        ArrayList arrayList = (ArrayList) this.friendlyObstructions.get(obstruction);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.friendlyObstructions.put(obstruction, arrayList);
        }
        arrayList.add(adSession.getAvidAdSessionId());
    }

    public void cleanup() {
        this.adViews.clear();
        this.friendlyObstructions.clear();
        this.rootViews.clear();
        this.visibleSessionIds.clear();
        this.hiddenSessionIds.clear();
        this.isAdViewProcessed = false;
    }

    public void onAdViewProcessed() {
        this.isAdViewProcessed = true;
    }

    public String getSessionId(View view) {
        if (this.adViews.size() == 0) {
            return null;
        }
        String sessionId = (String) this.adViews.get(view);
        if (sessionId != null) {
            this.adViews.remove(view);
        }
        return sessionId;
    }

    public ArrayList<String> getFriendlySessionIds(View view) {
        if (this.friendlyObstructions.size() == 0) {
            return null;
        }
        ArrayList<String> friendlySessionIds = (ArrayList) this.friendlyObstructions.get(view);
        if (friendlySessionIds != null) {
            this.friendlyObstructions.remove(view);
            Collections.sort(friendlySessionIds);
        }
        return friendlySessionIds;
    }

    public ViewType getViewType(View view) {
        if (this.rootViews.contains(view)) {
            return ViewType.ROOT_VIEW;
        }
        return this.isAdViewProcessed ? ViewType.OBSTRUCTION_VIEW : ViewType.UNDERLYING_VIEW;
    }

    /* access modifiers changed from: 0000 */
    public HashMap<View, String> getAdViews() {
        return this.adViews;
    }

    /* access modifiers changed from: 0000 */
    public HashMap<View, ArrayList<String>> getFriendlyObstructions() {
        return this.friendlyObstructions;
    }

    /* access modifiers changed from: 0000 */
    public HashSet<View> getRootViews() {
        return this.rootViews;
    }
}
