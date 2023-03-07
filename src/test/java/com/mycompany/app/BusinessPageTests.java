package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BusinessPageTests extends BasicTest {

    @Test(priority = 1, enabled = true)
    public void updateBusinessDetailsTest() {
        UpdateBusinessDetailsBusinessSettingsPage updateBusinessDetailsBusinessSettingsPage
                = new UpdateBusinessDetailsBusinessSettingsPage(driver);
        Assert.assertEquals(updateBusinessDetailsBusinessSettingsPage.updateBusinessDetails(),
                "Account settings updated");
    }

    @Test(priority = 2, enabled = true)
    public void addTeamMemberTest() {
        AddTeamMemberBusinessSettingsPage addTeamMemberBusinessSettingsPage = new AddTeamMemberBusinessSettingsPage(driver);
        Assert.assertEquals(addTeamMemberBusinessSettingsPage.addTeamMember(),
                "https://partners.fresha.com/staff/employees/add/confirmed");
    }
}
