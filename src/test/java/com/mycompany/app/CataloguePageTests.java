package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CataloguePageTests extends BaseTest {

    @Test (priority = 1)
    public void addNewServiceTest() {
        AddNewServiceCataloguePage addNewServiceCataloguePage = new AddNewServiceCataloguePage(driver);
        Assert.assertEquals(addNewServiceCataloguePage.addNewService(), "Service created");
   }

    @Test (priority = 2)
    public void editServiceTest() {
        EditServiceCataloguePage editServiceCataloguePage = new EditServiceCataloguePage(driver);
        Assert.assertEquals(editServiceCataloguePage.editService(), "Service updated");
    }

    @Test (priority = 3)
    public void deleteServiceTest() {
        DeleteServiceCataloguePage deleteServiceCataloguePage = new DeleteServiceCataloguePage(driver);
        Assert.assertEquals(deleteServiceCataloguePage.deleteService(), "Service deleted");
    }

    @Test (priority = 4)
    public void addVoucherTest() {
        AddVoucherCataloguePage addVoucherCataloguePage = new AddVoucherCataloguePage(driver);
        Assert.assertEquals(addVoucherCataloguePage.addVoucher(), "Voucher template has been created.");
    }

    @Test (priority = 5)
    public void deleteVoucherTest() {
        DeleteVoucherCataloguePage deleteVoucherCataloguePage = new DeleteVoucherCataloguePage(driver);
        Assert.assertEquals(deleteVoucherCataloguePage.deleteVoucher(), "Voucher template deleted");
    }

    @Test (priority = 6)
    public void createMembershipTest() {
        CreateMembershipCataloguePage createMembershipCataloguePage = new CreateMembershipCataloguePage(driver);
        Assert.assertEquals(createMembershipCataloguePage.createMembership(), "Membership created");
    }

    @Test (priority = 7)
    public void deleteMembershipTest() {
        DeleteMembershipCataloguePage deleteMembershipCataloguePage = new DeleteMembershipCataloguePage(driver);
        Assert.assertTrue(deleteMembershipCataloguePage.deleteMembership());
    }

    @Test (priority = 8)
    public void newStockOrderTest() {
        NewStockOrderCataloguePage newStockOrderCataloguePage = new NewStockOrderCataloguePage(driver);
        Assert.assertEquals(newStockOrderCataloguePage.NewStockOrder(), "Stock order is ready!");
    }

    @Test (priority = 9)
    public void addNewSupplierTest() {
        AddNewSupplierCataloguePage addNewSupplierCataloguePage = new AddNewSupplierCataloguePage(driver);
        Assert.assertEquals(addNewSupplierCataloguePage.addNewSupplier(), "Supplier created");
    }

    @Test (priority = 10)
    public void deleteSupplierTest() {
        DeleteSupplierCataloguePage deleteSupplierCataloguePage = new DeleteSupplierCataloguePage(driver);
        Assert.assertEquals(deleteSupplierCataloguePage.deleteSupplier(), "Supplier deleted");
    }

    @Test (priority = 11)
    public void addProductTest() {
        AddNewProductCataloguePage addNewProductCataloguePage = new AddNewProductCataloguePage(driver);
        Assert.assertEquals(addNewProductCataloguePage.addNewProduct(), "Product created");
    }
}
