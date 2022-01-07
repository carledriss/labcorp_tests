package org.example.labcorp.pages;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.example.core.Environment;
import org.openqa.selenium.By;

import org.example.core.ui.AbstractPage;

public class Home extends AbstractPage {

    private static final Map<String, String> MENU_ITEMS;
    static {
        MENU_ITEMS = new HashMap<>();
        MENU_ITEMS.put("Careers", "http://www.labcorpcareers.com");
        MENU_ITEMS.put("Investors", "http://phx.corporate-ir.net/phoenix.zhtml?c=84636&p=irol-irhome");
    }

    public Home() {
        driver.get(Environment.getInstance().getValue("url"));
    }

    public JobsLabCorp clickMenuItem(final String menuName) {
        action.jsClick(driver.findElement(By.cssSelector(String.format("a[href*='%s']", MENU_ITEMS.get(menuName)))));
        LinkedList<String> windows = new LinkedList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.getLast());
        return new JobsLabCorp();
    }

}
