package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.res.Resources;
import android.view.WindowManager;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.WidgetsArgs */
public class WidgetsArgs extends HashMapNotNull<Key, GridSizeObject> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.WidgetsArgs$GridSizeObject */
    protected static class GridSizeObject {
        private int grid_row_size;

        public GridSizeObject(int grid_row_size2) {
            this.grid_row_size = grid_row_size2;
        }

        public int getGrid_row_size() {
            return this.grid_row_size;
        }

        public void setGrid_row_size(int grid_row_size2) {
            this.grid_row_size = grid_row_size2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.WidgetsArgs$Key */
    public enum Key {
        APPS_GROUP,
        MY_STORES_SUBSCRIBED,
        STORES_RECOMMENDED,
        STORES_GROUP
    }

    public WidgetsArgs() {
    }

    public WidgetsArgs(int appsRowSize, int storesRowSize) {
        add(Key.APPS_GROUP, appsRowSize);
        add(Key.STORES_GROUP, storesRowSize);
    }

    public static WidgetsArgs createDefault(Resources resources, WindowManager windowManager) {
        return new WidgetsArgs().add(Key.APPS_GROUP, Type.APPS_GROUP.getPerLineCount(resources, windowManager)).add(Key.STORES_GROUP, Type.STORES_GROUP.getPerLineCount(resources, windowManager)).add(Key.MY_STORES_SUBSCRIBED, Type.MY_STORES_SUBSCRIBED.getPerLineCount(resources, windowManager)).add(Key.STORES_RECOMMENDED, Type.STORES_RECOMMENDED.getPerLineCount(resources, windowManager));
    }

    public static WidgetsArgs createWithLineMultiplier(Resources resources, WindowManager windowManager, int multiplier) {
        return new WidgetsArgs().add(Key.APPS_GROUP, Type.APPS_GROUP.getPerLineCount(resources, windowManager) * multiplier).add(Key.STORES_GROUP, Type.STORES_GROUP.getPerLineCount(resources, windowManager)).add(Key.MY_STORES_SUBSCRIBED, Type.MY_STORES_SUBSCRIBED.getPerLineCount(resources, windowManager)).add(Key.STORES_RECOMMENDED, Type.STORES_RECOMMENDED.getPerLineCount(resources, windowManager));
    }

    public WidgetsArgs add(Key key, int gridRowSize) {
        if (!containsKey(key)) {
            put(key, new GridSizeObject(gridRowSize));
        }
        return this;
    }
}
