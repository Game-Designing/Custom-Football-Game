package p005cm.aptoide.p006pt.dataprovider.model.p009v7;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.User;

/* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets */
public class GetStoreWidgets extends BaseV7EndlessDataListResponse<WSWidget> {

    /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets$WSWidget */
    public static class WSWidget {
        public static final String ADS_TYPE = "ADS";
        public static final String APPS_GROUP_TYPE = "APPS_GROUP";
        public static final String CATEGORIES_TYPE = "DISPLAYS";
        public static final String COMMENTS_TYPE = "COMMENTS";
        public static final String REVIEWS_TYPE = "REVIEWS";
        public static final String STORE_GROUP = "STORES_GROUP";
        public static final String TIMELINE_TYPE = "TIMELINE";
        private List<Action> actions;
        private Data data;
        private String tag;
        private String title;
        private Type type;
        private String view;
        private Object viewObject;

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets$WSWidget$Action */
        public static class Action {
            private Event event;
            private String label;
            private String tag;
            private String type;

            public String getType() {
                return this.type;
            }

            public Action setType(String type2) {
                this.type = type2;
                return this;
            }

            public String getLabel() {
                return this.label;
            }

            public Action setLabel(String label2) {
                this.label = label2;
                return this;
            }

            public String getTag() {
                return this.tag;
            }

            public Action setTag(String tag2) {
                this.tag = tag2;
                return this;
            }

            public Event getEvent() {
                return this.event;
            }

            public Action setEvent(Event event2) {
                this.event = event2;
                return this;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Action;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Action)) {
                    return false;
                }
                Action other = (Action) o;
                if (!other.canEqual(this)) {
                    return false;
                }
                String type2 = getType();
                Object other$type = other.getType();
                if (type2 != null ? !type2.equals(other$type) : other$type != null) {
                    return false;
                }
                String label2 = getLabel();
                Object other$label = other.getLabel();
                if (label2 != null ? !label2.equals(other$label) : other$label != null) {
                    return false;
                }
                String tag2 = getTag();
                Object other$tag = other.getTag();
                if (tag2 != null ? !tag2.equals(other$tag) : other$tag != null) {
                    return false;
                }
                Event event2 = getEvent();
                Object other$event = other.getEvent();
                if (event2 != null ? event2.equals(other$event) : other$event == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                String type2 = getType();
                int i = 43;
                int result = (1 * 59) + (type2 == null ? 43 : type2.hashCode());
                String label2 = getLabel();
                int result2 = (result * 59) + (label2 == null ? 43 : label2.hashCode());
                String tag2 = getTag();
                int result3 = (result2 * 59) + (tag2 == null ? 43 : tag2.hashCode());
                Event event2 = getEvent();
                int i2 = result3 * 59;
                if (event2 != null) {
                    i = event2.hashCode();
                }
                return i2 + i;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetStoreWidgets.WSWidget.Action(type=");
                sb.append(getType());
                sb.append(", label=");
                sb.append(getLabel());
                sb.append(", tag=");
                sb.append(getTag());
                sb.append(", event=");
                sb.append(getEvent());
                sb.append(")");
                return sb.toString();
            }
        }

        /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets$WSWidget$Data */
        public static class Data {
            private List<Categories> categories;
            private String icon;
            private Layout layout;
            private String message;
            private User user;

            /* renamed from: cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets$WSWidget$Data$Categories */
            public static class Categories {
                private int adsCount;
                private String graphic;
                private String icon;

                /* renamed from: id */
                private long f6088id;
                private String name;
                private String parentId;
                private String parentRefId;
                private String refId;

                public long getId() {
                    return this.f6088id;
                }

                public Categories setId(long id) {
                    this.f6088id = id;
                    return this;
                }

                public String getRefId() {
                    return this.refId;
                }

                public Categories setRefId(String refId2) {
                    this.refId = refId2;
                    return this;
                }

                public String getParentId() {
                    return this.parentId;
                }

                public Categories setParentId(String parentId2) {
                    this.parentId = parentId2;
                    return this;
                }

                public String getParentRefId() {
                    return this.parentRefId;
                }

                public Categories setParentRefId(String parentRefId2) {
                    this.parentRefId = parentRefId2;
                    return this;
                }

                public String getName() {
                    return this.name;
                }

                public Categories setName(String name2) {
                    this.name = name2;
                    return this;
                }

                public String getGraphic() {
                    return this.graphic;
                }

                public Categories setGraphic(String graphic2) {
                    this.graphic = graphic2;
                    return this;
                }

                public String getIcon() {
                    return this.icon;
                }

                public Categories setIcon(String icon2) {
                    this.icon = icon2;
                    return this;
                }

                public int getAdsCount() {
                    return this.adsCount;
                }

                public Categories setAdsCount(int adsCount2) {
                    this.adsCount = adsCount2;
                    return this;
                }

                /* access modifiers changed from: protected */
                public boolean canEqual(Object other) {
                    return other instanceof Categories;
                }

                public boolean equals(Object o) {
                    Object obj = o;
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof Categories)) {
                        return false;
                    }
                    Categories other = (Categories) obj;
                    if (!other.canEqual(this) || getId() != other.getId()) {
                        return false;
                    }
                    String refId2 = getRefId();
                    Object other$refId = other.getRefId();
                    if (refId2 != null ? !refId2.equals(other$refId) : other$refId != null) {
                        return false;
                    }
                    String parentId2 = getParentId();
                    Object other$parentId = other.getParentId();
                    if (parentId2 != null ? !parentId2.equals(other$parentId) : other$parentId != null) {
                        return false;
                    }
                    String parentRefId2 = getParentRefId();
                    Object other$parentRefId = other.getParentRefId();
                    if (parentRefId2 != null ? !parentRefId2.equals(other$parentRefId) : other$parentRefId != null) {
                        return false;
                    }
                    String name2 = getName();
                    Object other$name = other.getName();
                    if (name2 != null ? !name2.equals(other$name) : other$name != null) {
                        return false;
                    }
                    String graphic2 = getGraphic();
                    Object other$graphic = other.getGraphic();
                    if (graphic2 != null ? !graphic2.equals(other$graphic) : other$graphic != null) {
                        return false;
                    }
                    String icon2 = getIcon();
                    Object other$icon = other.getIcon();
                    if (icon2 != null ? !icon2.equals(other$icon) : other$icon != null) {
                        return false;
                    }
                    if (getAdsCount() != other.getAdsCount()) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    long $id = getId();
                    int result = (1 * 59) + ((int) (($id >>> 32) ^ $id));
                    String refId2 = getRefId();
                    int i = 43;
                    int result2 = (result * 59) + (refId2 == null ? 43 : refId2.hashCode());
                    String parentId2 = getParentId();
                    int result3 = (result2 * 59) + (parentId2 == null ? 43 : parentId2.hashCode());
                    String parentRefId2 = getParentRefId();
                    int result4 = (result3 * 59) + (parentRefId2 == null ? 43 : parentRefId2.hashCode());
                    String name2 = getName();
                    int result5 = (result4 * 59) + (name2 == null ? 43 : name2.hashCode());
                    String graphic2 = getGraphic();
                    int result6 = (result5 * 59) + (graphic2 == null ? 43 : graphic2.hashCode());
                    String icon2 = getIcon();
                    int i2 = result6 * 59;
                    if (icon2 != null) {
                        i = icon2.hashCode();
                    }
                    return ((i2 + i) * 59) + getAdsCount();
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GetStoreWidgets.WSWidget.Data.Categories(id=");
                    sb.append(getId());
                    sb.append(", refId=");
                    sb.append(getRefId());
                    sb.append(", parentId=");
                    sb.append(getParentId());
                    sb.append(", parentRefId=");
                    sb.append(getParentRefId());
                    sb.append(", name=");
                    sb.append(getName());
                    sb.append(", graphic=");
                    sb.append(getGraphic());
                    sb.append(", icon=");
                    sb.append(getIcon());
                    sb.append(", adsCount=");
                    sb.append(getAdsCount());
                    sb.append(")");
                    return sb.toString();
                }
            }

            public Layout getLayout() {
                return this.layout;
            }

            public Data setLayout(Layout layout2) {
                this.layout = layout2;
                return this;
            }

            public String getIcon() {
                return this.icon;
            }

            public Data setIcon(String icon2) {
                this.icon = icon2;
                return this;
            }

            public String getMessage() {
                return this.message;
            }

            public Data setMessage(String message2) {
                this.message = message2;
                return this;
            }

            public List<Categories> getCategories() {
                return this.categories;
            }

            public Data setCategories(List<Categories> categories2) {
                this.categories = categories2;
                return this;
            }

            public User getUser() {
                return this.user;
            }

            public Data setUser(User user2) {
                this.user = user2;
                return this;
            }

            /* access modifiers changed from: protected */
            public boolean canEqual(Object other) {
                return other instanceof Data;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Data)) {
                    return false;
                }
                Data other = (Data) o;
                if (!other.canEqual(this)) {
                    return false;
                }
                Layout layout2 = getLayout();
                Object other$layout = other.getLayout();
                if (layout2 != null ? !layout2.equals(other$layout) : other$layout != null) {
                    return false;
                }
                String icon2 = getIcon();
                Object other$icon = other.getIcon();
                if (icon2 != null ? !icon2.equals(other$icon) : other$icon != null) {
                    return false;
                }
                String message2 = getMessage();
                Object other$message = other.getMessage();
                if (message2 != null ? !message2.equals(other$message) : other$message != null) {
                    return false;
                }
                Object this$categories = getCategories();
                Object other$categories = other.getCategories();
                if (this$categories != null ? !this$categories.equals(other$categories) : other$categories != null) {
                    return false;
                }
                User user2 = getUser();
                Object other$user = other.getUser();
                if (user2 != null ? user2.equals(other$user) : other$user == null) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                Layout layout2 = getLayout();
                int i = 43;
                int result = (1 * 59) + (layout2 == null ? 43 : layout2.hashCode());
                String icon2 = getIcon();
                int result2 = (result * 59) + (icon2 == null ? 43 : icon2.hashCode());
                String message2 = getMessage();
                int result3 = (result2 * 59) + (message2 == null ? 43 : message2.hashCode());
                Object $categories = getCategories();
                int result4 = (result3 * 59) + ($categories == null ? 43 : $categories.hashCode());
                User user2 = getUser();
                int i2 = result4 * 59;
                if (user2 != null) {
                    i = user2.hashCode();
                }
                return i2 + i;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GetStoreWidgets.WSWidget.Data(layout=");
                sb.append(getLayout());
                sb.append(", icon=");
                sb.append(getIcon());
                sb.append(", message=");
                sb.append(getMessage());
                sb.append(", categories=");
                sb.append(getCategories());
                sb.append(", user=");
                sb.append(getUser());
                sb.append(")");
                return sb.toString();
            }
        }

        public boolean hasActions() {
            List<Action> list = this.actions;
            if (list == null || list.size() <= 0 || ((Action) this.actions.get(0)).getEvent().getName() == null) {
                return false;
            }
            return true;
        }

        public Type getType() {
            return this.type;
        }

        public WSWidget setType(Type type2) {
            this.type = type2;
            return this;
        }

        public String getTitle() {
            return this.title;
        }

        public WSWidget setTitle(String title2) {
            this.title = title2;
            return this;
        }

        public String getTag() {
            return this.tag;
        }

        public WSWidget setTag(String tag2) {
            this.tag = tag2;
            return this;
        }

        public String getView() {
            return this.view;
        }

        public WSWidget setView(String view2) {
            this.view = view2;
            return this;
        }

        public Object getViewObject() {
            return this.viewObject;
        }

        public WSWidget setViewObject(Object viewObject2) {
            this.viewObject = viewObject2;
            return this;
        }

        public List<Action> getActions() {
            return this.actions;
        }

        public WSWidget setActions(List<Action> actions2) {
            this.actions = actions2;
            return this;
        }

        public Data getData() {
            return this.data;
        }

        public WSWidget setData(Data data2) {
            this.data = data2;
            return this;
        }

        public int hashCode() {
            Type type2 = getType();
            int i = 43;
            int result = (1 * 59) + (type2 == null ? 43 : type2.hashCode());
            String title2 = getTitle();
            int result2 = (result * 59) + (title2 == null ? 43 : title2.hashCode());
            String tag2 = getTag();
            int result3 = (result2 * 59) + (tag2 == null ? 43 : tag2.hashCode());
            String view2 = getView();
            int result4 = (result3 * 59) + (view2 == null ? 43 : view2.hashCode());
            Object $viewObject = getViewObject();
            int result5 = (result4 * 59) + ($viewObject == null ? 43 : $viewObject.hashCode());
            Object $actions = getActions();
            int result6 = (result5 * 59) + ($actions == null ? 43 : $actions.hashCode());
            Data data2 = getData();
            int i2 = result6 * 59;
            if (data2 != null) {
                i = data2.hashCode();
            }
            return i2 + i;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof WSWidget;
        }

        public boolean equals(Object o) {
            Object obj = o;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WSWidget)) {
                return false;
            }
            WSWidget other = (WSWidget) obj;
            if (!other.canEqual(this)) {
                return false;
            }
            Type type2 = getType();
            Object other$type = other.getType();
            if (type2 != null ? !type2.equals(other$type) : other$type != null) {
                return false;
            }
            String title2 = getTitle();
            Object other$title = other.getTitle();
            if (title2 != null ? !title2.equals(other$title) : other$title != null) {
                return false;
            }
            String tag2 = getTag();
            Object other$tag = other.getTag();
            if (tag2 != null ? !tag2.equals(other$tag) : other$tag != null) {
                return false;
            }
            String view2 = getView();
            Object other$view = other.getView();
            if (view2 != null ? !view2.equals(other$view) : other$view != null) {
                return false;
            }
            Object this$viewObject = getViewObject();
            Object other$viewObject = other.getViewObject();
            if (this$viewObject != null ? !this$viewObject.equals(other$viewObject) : other$viewObject != null) {
                return false;
            }
            Object this$actions = getActions();
            Object other$actions = other.getActions();
            if (this$actions != null ? !this$actions.equals(other$actions) : other$actions != null) {
                return false;
            }
            Data data2 = getData();
            Object other$data = other.getData();
            if (data2 != null ? data2.equals(other$data) : other$data == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GetStoreWidgets.WSWidget(type=");
            sb.append(getType());
            sb.append(", title=");
            sb.append(getTitle());
            sb.append(", tag=");
            sb.append(getTag());
            sb.append(", view=");
            sb.append(getView());
            sb.append(", viewObject=");
            sb.append(getViewObject());
            sb.append(", actions=");
            sb.append(getActions());
            sb.append(", data=");
            sb.append(getData());
            sb.append(")");
            return sb.toString();
        }
    }

    public int hashCode() {
        return (1 * 59) + super.hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof GetStoreWidgets;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof GetStoreWidgets) && ((GetStoreWidgets) o).canEqual(this) && super.equals(o)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GetStoreWidgets()";
    }
}
