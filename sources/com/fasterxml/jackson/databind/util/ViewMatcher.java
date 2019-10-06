package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public class ViewMatcher implements Serializable {
    protected static final ViewMatcher EMPTY = new ViewMatcher();

    private static final class Multi extends ViewMatcher implements Serializable {
        private final Class<?>[] _views;

        public Multi(Class<?>[] v) {
            this._views = v;
        }

        public boolean isVisibleForView(Class<?> activeView) {
            for (Class<?> view : this._views) {
                if (activeView == view || view.isAssignableFrom(activeView)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class Single extends ViewMatcher {
        private final Class<?> _view;

        public Single(Class<?> v) {
            this._view = v;
        }

        public boolean isVisibleForView(Class<?> activeView) {
            Class<?> cls = this._view;
            return activeView == cls || cls.isAssignableFrom(activeView);
        }
    }

    public boolean isVisibleForView(Class<?> cls) {
        return false;
    }

    public static ViewMatcher construct(Class<?>[] views) {
        if (views == null) {
            return EMPTY;
        }
        int length = views.length;
        if (length == 0) {
            return EMPTY;
        }
        if (length != 1) {
            return new Multi(views);
        }
        return new Single(views[0]);
    }
}
