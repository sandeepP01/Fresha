package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientsPageTests extends BaseTest {

    @Test (priority = 1)
    public void addClientTest() {
        AddClientClientsPage addClientClientsPage = new AddClientClientsPage(driver);
        Assert.assertEquals(addClientClientsPage.addClient(), "Client created");
    }

    @Test (priority = 2)
    public void deleteClientTest() {
       DeleteClientClientsPage deleteClientClientsPage =new DeleteClientClientsPage(driver);
       Assert.assertEquals(deleteClientClientsPage.deleteClient(), "1 client deleted");
    }

    @Test (priority = 3)
    public void setupAutomatedMessageTest() {
       AutomatedMessagesClientsPage automatedMessagesClientsPage = new AutomatedMessagesClientsPage(driver);
       Assert.assertEquals(automatedMessagesClientsPage.setupAutomatedMessage(),
               "Your 72 hour appointment reminder automated message is set up");
    }
}




