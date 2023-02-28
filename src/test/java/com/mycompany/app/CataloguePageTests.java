package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CataloguePageTests extends BasicTest {

    @Test (priority = 1, enabled = true)
    public void addNewServiceTest() {
        AddNewServiceCataloguePage addNewServiceCataloguePage = new AddNewServiceCataloguePage(driver);
        Assert.assertEquals(addNewServiceCataloguePage.addNewService(), "Service created");
   }

    @Test (priority = 2, enabled = true)
    public void editServiceTest() {
        EditServiceCataloguePage editServiceCataloguePage = new EditServiceCataloguePage(driver);
        Assert.assertEquals(editServiceCataloguePage.editService(), "Service updated");
    }

    @Test (priority = 3, enabled = true)
    public void deleteServiceTest() {
        DeleteServiceCataloguePage deleteServiceCataloguePage = new DeleteServiceCataloguePage(driver);
        Assert.assertEquals(deleteServiceCataloguePage.deleteService(), "Service deleted");
    }

    @Test (priority = 4, enabled = true)
    public void addVoucherTest() {
        AddVoucherCataloguePage addVoucherCataloguePage = new AddVoucherCataloguePage(driver);
        Assert.assertEquals(addVoucherCataloguePage.addVoucher(), "Voucher template has been created.");
    }

    @Test (priority = 5, enabled = true)
    public void deleteVoucherTest() {
        DeleteVoucherCataloguePage deleteVoucherCataloguePage = new DeleteVoucherCataloguePage(driver);
        Assert.assertEquals(deleteVoucherCataloguePage.deleteVoucher(), "Voucher template deleted");
    }

    @Test (priority = 6, enabled = true)
    public void createMembershipTest() {
        CreateMembershipCataloguePage createMembershipCataloguePage = new CreateMembershipCataloguePage(driver);
        Assert.assertEquals(createMembershipCataloguePage.createMembership(), "Membership created");
    }

    @Test (priority = 7, enabled = true)
    public void deleteMembershipTest() {
        DeleteMembershipCataloguePage deleteMembershipCataloguePage = new DeleteMembershipCataloguePage(driver);
        Assert.assertTrue(deleteMembershipCataloguePage.deleteMembership());
    }
}
