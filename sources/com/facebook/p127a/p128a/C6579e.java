package com.facebook.p127a.p128a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.facebook.C6787r;
import com.facebook.FacebookException;
import com.facebook.appevents.codeless.CodelessMatcher.MatchedView;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.internal.C6670D;
import com.facebook.internal.C6673E;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6738z;
import com.facebook.p127a.p128a.C6576c.C6577a;
import com.facebook.p127a.p128a.C6583g.C6584a;
import com.facebook.p127a.p128a.p129a.C6566a;
import com.facebook.p127a.p128a.p129a.C6569b;
import com.facebook.p127a.p128a.p129a.C6570c;
import com.facebook.p127a.p128a.p129a.C6570c.C6571a;
import com.facebook.p127a.p128a.p129a.C6574f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.facebook.a.a.e */
/* compiled from: CodelessMatcher */
public class C6579e {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11937a = C6579e.class.getCanonicalName();

    /* renamed from: b */
    private final Handler f11938b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private Set<Activity> f11939c = new HashSet();

    /* renamed from: d */
    private Set<C6581b> f11940d = new HashSet();

    /* renamed from: e */
    private HashMap<String, String> f11941e = new HashMap<>();

    /* renamed from: com.facebook.a.a.e$a */
    /* compiled from: CodelessMatcher */
    public static class C6580a {

        /* renamed from: a */
        private WeakReference<View> f11942a;

        /* renamed from: b */
        private String f11943b;

        public C6580a(View view, String viewMapKey) {
            this.f11942a = new WeakReference<>(view);
            this.f11943b = viewMapKey;
        }

        /* renamed from: a */
        public View mo19759a() {
            WeakReference<View> weakReference = this.f11942a;
            if (weakReference == null) {
                return null;
            }
            return (View) weakReference.get();
        }

        /* renamed from: b */
        public String mo19760b() {
            return this.f11943b;
        }
    }

    /* renamed from: com.facebook.a.a.e$b */
    /* compiled from: CodelessMatcher */
    protected static class C6581b implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {

        /* renamed from: a */
        private WeakReference<View> f11944a;

        /* renamed from: b */
        private List<C6566a> f11945b;

        /* renamed from: c */
        private final Handler f11946c;

        /* renamed from: d */
        private HashMap<String, String> f11947d;

        /* renamed from: e */
        private final String f11948e;

        public C6581b(View rootView, Handler handler, HashMap<String, String> delegateMap, String activityName) {
            this.f11944a = new WeakReference<>(rootView);
            this.f11946c = handler;
            this.f11947d = delegateMap;
            this.f11948e = activityName;
            this.f11946c.postDelayed(this, 200);
        }

        public void run() {
            C6738z appSettings = C6670D.m13306b(C6787r.m13816f());
            if (appSettings != null && appSettings.mo19974b()) {
                this.f11945b = C6566a.m13003a(appSettings.mo19977e());
                if (this.f11945b != null) {
                    View rootView = (View) this.f11944a.get();
                    if (rootView != null) {
                        ViewTreeObserver observer = rootView.getViewTreeObserver();
                        if (observer.isAlive()) {
                            observer.addOnGlobalLayoutListener(this);
                            observer.addOnScrollChangedListener(this);
                        }
                        m13052a();
                    }
                }
            }
        }

        public void onGlobalLayout() {
            m13052a();
        }

        public void onScrollChanged() {
            m13052a();
        }

        /* renamed from: a */
        private void m13052a() {
            if (this.f11945b != null && this.f11944a.get() != null) {
                for (int i = 0; i < this.f11945b.size(); i++) {
                    mo19761a((C6566a) this.f11945b.get(i), (View) this.f11944a.get());
                }
            }
        }

        /* renamed from: a */
        public void mo19761a(C6566a mapping, View rootView) {
            if (mapping != null && rootView != null) {
                if (TextUtils.isEmpty(mapping.mo19747a()) || mapping.mo19747a().equals(this.f11948e)) {
                    List<PathComponent> path = mapping.mo19751e();
                    if (path.size() <= 25) {
                        Iterator it = m13051a(mapping, rootView, path, 0, -1, this.f11948e).iterator();
                        while (it.hasNext()) {
                            m13054a((C6580a) it.next(), rootView, mapping);
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public static List<C6580a> m13051a(C6566a mapping, View view, List<C6570c> path, int level, int index, String mapKey) {
            View view2 = view;
            int i = level;
            StringBuilder sb = new StringBuilder();
            sb.append(mapKey);
            String str = ".";
            sb.append(str);
            sb.append(String.valueOf(index));
            String mapKey2 = sb.toString();
            List<MatchedView> result = new ArrayList<>();
            if (view2 == null) {
                return result;
            }
            if (i >= path.size()) {
                result.add(new C6580a(view2, mapKey2));
                int i2 = index;
            } else {
                C6570c pathElement = (C6570c) path.get(level);
                if (pathElement.f11905a.equals("..")) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        List<View> visibleViews = m13050a((ViewGroup) parent);
                        int childCount = visibleViews.size();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            result.addAll(m13051a(mapping, (View) visibleViews.get(i3), path, i + 1, i3, mapKey2));
                        }
                    }
                    return result;
                } else if (pathElement.f11905a.equals(str)) {
                    result.add(new C6580a(view2, mapKey2));
                    return result;
                } else if (!m13055a(view2, pathElement, index)) {
                    return result;
                } else {
                    if (i == path.size() - 1) {
                        result.add(new C6580a(view2, mapKey2));
                    }
                }
            }
            if (view2 instanceof ViewGroup) {
                List<View> visibleViews2 = m13050a((ViewGroup) view2);
                int childCount2 = visibleViews2.size();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    result.addAll(m13051a(mapping, (View) visibleViews2.get(i4), path, i + 1, i4, mapKey2));
                }
            }
            return result;
        }

        /* renamed from: a */
        private static boolean m13055a(View targetView, C6570c pathElement, int index) {
            String targetTag;
            String targetDesc;
            int i = pathElement.f11906b;
            if (i != -1 && index != i) {
                return false;
            }
            if (!targetView.getClass().getCanonicalName().equals(pathElement.f11905a)) {
                if (!pathElement.f11905a.matches(".*android\\..*")) {
                    return false;
                }
                String[] names = pathElement.f11905a.split("\\.");
                if (names.length <= 0) {
                    return false;
                }
                if (!targetView.getClass().getSimpleName().equals(names[names.length - 1])) {
                    return false;
                }
            }
            if ((pathElement.f11912h & C6571a.ID.mo19752e()) > 0 && pathElement.f11907c != targetView.getId()) {
                return false;
            }
            String str = "";
            if ((pathElement.f11912h & C6571a.TEXT.mo19752e()) > 0) {
                String pathText = pathElement.f11908d;
                String text = C6574f.m13030g(targetView);
                String hashedText = C6694S.m13403a(C6694S.m13446e(text), str);
                if (!pathText.equals(text) && !pathText.equals(hashedText)) {
                    return false;
                }
            }
            if ((pathElement.f11912h & C6571a.DESCRIPTION.mo19752e()) > 0) {
                String pathDesc = pathElement.f11910f;
                if (targetView.getContentDescription() == null) {
                    targetDesc = str;
                } else {
                    targetDesc = String.valueOf(targetView.getContentDescription());
                }
                String hashedDesc = C6694S.m13403a(C6694S.m13446e(targetDesc), str);
                if (!pathDesc.equals(targetDesc) && !pathDesc.equals(hashedDesc)) {
                    return false;
                }
            }
            if ((pathElement.f11912h & C6571a.HINT.mo19752e()) > 0) {
                String pathHint = pathElement.f11911g;
                String targetHint = C6574f.m13029f(targetView);
                String hashedHint = C6694S.m13403a(C6694S.m13446e(targetHint), str);
                if (!pathHint.equals(targetHint) && !pathHint.equals(hashedHint)) {
                    return false;
                }
            }
            if ((pathElement.f11912h & C6571a.TAG.mo19752e()) > 0) {
                String tag = pathElement.f11909e;
                if (targetView.getTag() == null) {
                    targetTag = str;
                } else {
                    targetTag = String.valueOf(targetView.getTag());
                }
                String hashedTag = C6694S.m13403a(C6694S.m13446e(targetTag), str);
                if (tag.equals(targetTag) || tag.equals(hashedTag)) {
                    return true;
                }
                return false;
            }
            return true;
        }

        /* renamed from: a */
        private static List<View> m13050a(ViewGroup viewGroup) {
            List<View> visibleViews = new ArrayList<>();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                if (child.getVisibility() == 0) {
                    visibleViews.add(child);
                }
            }
            return visibleViews;
        }

        /* renamed from: a */
        private void m13054a(C6580a matchedView, View rootView, C6566a mapping) {
            if (mapping != null) {
                try {
                    View view = matchedView.mo19759a();
                    if (view != null) {
                        View RCTRootView = C6574f.m13020a(view);
                        if (RCTRootView != null && C6574f.m13024a(view, RCTRootView)) {
                            m13053a(matchedView, rootView, RCTRootView, mapping);
                        } else if (!view.getClass().getName().startsWith("com.facebook.react")) {
                            String mapKey = matchedView.mo19760b();
                            AccessibilityDelegate existingDelegate = C6574f.m13027d(view);
                            boolean delegateSupportCodelessLogging = true;
                            boolean delegateExists = existingDelegate != null;
                            boolean isCodelessDelegate = delegateExists && (existingDelegate instanceof C6577a);
                            if (!isCodelessDelegate || !((C6577a) existingDelegate).mo19754a()) {
                                delegateSupportCodelessLogging = false;
                            }
                            if (!this.f11947d.containsKey(mapKey) && (!delegateExists || !isCodelessDelegate || !delegateSupportCodelessLogging)) {
                                view.setAccessibilityDelegate(C6576c.m13037a(mapping, rootView, view));
                                this.f11947d.put(mapKey, mapping.mo19748b());
                            }
                        }
                    }
                } catch (FacebookException e) {
                    Log.e(C6579e.f11937a, "Failed to attach auto logging event listener.", e);
                }
            }
        }

        /* renamed from: a */
        private void m13053a(C6580a matchedView, View rootView, View RCTRootView, C6566a mapping) {
            if (mapping != null) {
                View view = matchedView.mo19759a();
                if (view != null && C6574f.m13024a(view, RCTRootView)) {
                    String mapKey = matchedView.mo19760b();
                    OnTouchListener existingListener = C6574f.m13028e(view);
                    boolean listenerSupportCodelessLogging = true;
                    boolean listenerExists = existingListener != null;
                    boolean isCodelessListener = listenerExists && (existingListener instanceof C6584a);
                    if (!isCodelessListener || !((C6584a) existingListener).mo19766h()) {
                        listenerSupportCodelessLogging = false;
                    }
                    if (!this.f11947d.containsKey(mapKey) && (!listenerExists || !isCodelessListener || !listenerSupportCodelessLogging)) {
                        view.setOnTouchListener(C6583g.m13057a(mapping, rootView, view));
                        this.f11947d.put(mapKey, mapping.mo19748b());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo19757a(Activity activity) {
        if (!C6673E.m13317b()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.f11939c.add(activity);
                this.f11941e.clear();
                m13045c();
                return;
            }
            throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
        }
    }

    /* renamed from: b */
    public void mo19758b(Activity activity) {
        if (!C6673E.m13317b()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.f11939c.remove(activity);
                this.f11940d.clear();
                this.f11941e.clear();
                return;
            }
            throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
        }
    }

    /* renamed from: a */
    public static Bundle m13041a(C6566a mapping, View rootView, View hostView) {
        List<MatchedView> matchedViews;
        Bundle params = new Bundle();
        if (mapping == null) {
            return params;
        }
        List<ParameterComponent> parameters = mapping.mo19750d();
        if (parameters != null) {
            Iterator it = parameters.iterator();
            while (it.hasNext()) {
                C6569b component = (C6569b) it.next();
                String str = component.f11902b;
                if (str == null || str.length() <= 0) {
                    if (component.f11903c.size() > 0) {
                        if (component.f11904d.equals("relative")) {
                            matchedViews = C6581b.m13051a(mapping, hostView, component.f11903c, 0, -1, hostView.getClass().getSimpleName());
                        } else {
                            matchedViews = C6581b.m13051a(mapping, rootView, component.f11903c, 0, -1, rootView.getClass().getSimpleName());
                        }
                        Iterator it2 = matchedViews.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            C6580a view = (C6580a) it2.next();
                            if (view.mo19759a() != null) {
                                String text = C6574f.m13030g(view.mo19759a());
                                if (text.length() > 0) {
                                    params.putString(component.f11901a, text);
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    params.putString(component.f11901a, component.f11902b);
                }
            }
        }
        return params;
    }

    /* renamed from: c */
    private void m13045c() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m13044b();
        } else {
            this.f11938b.post(new C6578d(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13044b() {
        for (Activity activity : this.f11939c) {
            this.f11940d.add(new C6581b(activity.getWindow().getDecorView().getRootView(), this.f11938b, this.f11941e, activity.getClass().getSimpleName()));
        }
    }
}
