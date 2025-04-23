package org.wildfly.elytron.site;

import java.util.List;

import io.quarkiverse.roq.data.runtime.annotations.DataMapping;
import io.quarkiverse.roq.frontmatter.runtime.model.Page;

@DataMapping(value = "navigationItems", parentArray = true)
public record NavigationItems(List<NavigationItem> list) {
    public record NavigationItem(String name, String link) {
        public String getCssClass(Page page) {
            String clazz = "";
            if (page.url().path().equals(link)) {
                clazz = "mdl-navigation__link mdl-navigation__link--current";
            } else if (page.url().path().equals("blog") && name.equals("Blog")) {
                clazz = "mdl-navigation__link mdl-navigation__link--current";
            } else if (page.url().path().equals("OSD") && name.equals("Open Source Day")) {
                clazz = "mdl-navigation__link mdl-navigation__link--current";
            } else if (page.url().path().equals("hacktoberfest") && name.equals("Hacktoberfest")) {
                clazz = "mdl-navigation__link mdl-navigation__link--current";
            } else {
                clazz = "mdl-navigation__link";
            }

            if (name.equals("Open Source Day")) {
                clazz = clazz + " highlight-button";
            }

            if (name.equals("Hacktoberfest")) {
                clazz = clazz + " highlight-button";

            }
            return clazz;
        }
    }
}
