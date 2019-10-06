package p005cm.aptoide.p006pt.permissions;

import java.util.ArrayList;
import java.util.List;

/* renamed from: cm.aptoide.pt.permissions.ApkPermissionGroup */
public class ApkPermissionGroup {
    private List<String> descriptions = new ArrayList();
    private String name;

    public ApkPermissionGroup(String name2, String description) {
        this.name = name2;
        this.descriptions.add(description);
    }

    public List<String> getDescriptions() {
        return this.descriptions;
    }

    public void setDescription(String description) {
        this.descriptions.add(description);
    }

    public boolean equals(Object o) {
        return (o instanceof ApkPermissionGroup) && getName().equals(((ApkPermissionGroup) o).getName()) && this.descriptions.size() == ((ApkPermissionGroup) o).descriptions.size();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }
}
