package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BusinessPageTests extends BaseTest {

    @Test(priority = 1)
    public void updateBusinessDetailsTest() {
        UpdateBusinessDetailsBusinessSettingsPage updateBusinessDetailsBusinessSettingsPage
                = new UpdateBusinessDetailsBusinessSettingsPage(driver);
        Assert.assertEquals(updateBusinessDetailsBusinessSettingsPage.updateBusinessDetails(),
                "Account settings updated");
    }

    @Test(priority = 2)
    public void addTeamMemberTest() {
        AddTeamMemberBusinessSettingsPage addTeamMemberBusinessSettingsPage = new AddTeamMemberBusinessSettingsPage(driver);
        Assert.assertEquals(addTeamMemberBusinessSettingsPage.addTeamMember(),
                "https://partners.fresha.com/staff/employees/add/confirmed");
    }
    @Test(priority = 3)
    public void deleteTeamMemberTest() {
        DeleteTeamMemberBusinessPage deleteTeamMemberBusinessPage = new DeleteTeamMemberBusinessPage(driver);
        Assert.assertEquals(deleteTeamMemberBusinessPage.deleteTeamMember(),"Team member deleted");
    }
}
