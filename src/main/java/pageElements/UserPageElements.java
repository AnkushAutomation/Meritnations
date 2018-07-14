package pageElements;

import org.openqa.selenium.By;

public interface UserPageElements {
	By displayName = By.xpath("//span[contains(text(), 'Sunaina')]");
	By nameBtn = By.id("profilePic");
	By logoutBtn = By.xpath("//a[@href='/users/logout']");

}
