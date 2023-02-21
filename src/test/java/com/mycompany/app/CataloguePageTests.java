package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CataloguePageTests extends BasicTest {

    @Test (priority = 1, enabled = true)
    public void addNewServiceTest() {
        AddNewServiceCataloguePage addNewServiceCataloguePage = new AddNewServiceCataloguePage(driver);
        Assert.assertTrue(addNewServiceCataloguePage.addNewService());
   }

    @Test (priority = 2, enabled = true)
    public void deleteServiceTest() {
        DeleteServiceCataloguePage deleteServiceCataloguePage = new DeleteServiceCataloguePage(driver);
        Assert.assertTrue(deleteServiceCataloguePage.deleteService());
    }

    @Test (priority = 3, enabled = true)
    public void addVoucherTest() {
        AddVoucherCataloguePage addVoucherCataloguePage = new AddVoucherCataloguePage(driver);
        Assert.assertTrue(addVoucherCataloguePage.addVoucher());
    }

    @Test (priority = 4, enabled = true)
    public void deleteVoucherTest() {
        DeleteVoucherCataloguePage deleteVoucherCataloguePage = new DeleteVoucherCataloguePage(driver);
        Assert.assertTrue(deleteVoucherCataloguePage.deleteVoucher());
    }

    @Test (priority = 5, enabled = true)
    public void createMembershipTest() {
        CreateMembershipCataloguePage createMembershipCataloguePage = new CreateMembershipCataloguePage(driver);
        Assert.assertTrue(createMembershipCataloguePage.createMembership());
    }
}
