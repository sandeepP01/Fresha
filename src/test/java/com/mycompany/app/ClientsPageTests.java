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

    @Test (priority = 3, enabled = true)
    public void setupAutomatedMessageTest() {
       AutomatedMessagesClientsPage automatedMessagesClientsPage = new AutomatedMessagesClientsPage(driver);
       Assert.assertEquals(automatedMessagesClientsPage.setupAutomatedMessage(),
               "Your 72 hour appointment reminder automated message is set up");
    }
}




