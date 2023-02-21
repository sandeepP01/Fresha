package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientsPageTests extends BasicTest {

   @Test  (priority = 1, enabled = true)
    public void addClientTest() {
        AddClientClientsPage addClientClientsPage = new AddClientClientsPage(driver);
        Assert.assertFalse(addClientClientsPage.addClient());
    }

    @Test (priority = 2, enabled = true)
    public void deleteClientTest() {
       DeleteClientClientsPage deleteClientClientsPage =new DeleteClientClientsPage(driver);
        Assert.assertTrue(deleteClientClientsPage.deleteClient());
    }
}




