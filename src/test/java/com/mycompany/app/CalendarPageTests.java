package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarPageTests extends BasicTest {

    @Test (priority = 1, enabled = true)
    public void createAppointmentTest() {
        AddNewAppointmentCalendarPage newAppointmentCalendarPage = new AddNewAppointmentCalendarPage(driver);
        Assert.assertEquals(newAppointmentCalendarPage.createAppointment(), "Appointment created");
    }

    @Test (priority = 2, enabled = true)
    public void cancelAppointmentTest() {
        CancelAppointmentCalendarPage cancelAppointmentCalendarPage = new CancelAppointmentCalendarPage(driver);
        Assert.assertEquals(cancelAppointmentCalendarPage.cancelAppointment(),
                "Appointment cancellation successful");
    }

    @Test (priority = 3, enabled = true)
    public void addBlockedTimeTest() {
        AddBlockedTimeCalendarPage addBlockedTimeCalendarPage = new AddBlockedTimeCalendarPage(driver);
        Assert.assertEquals(addBlockedTimeCalendarPage.addBlockedTime(), "Blocked time created");
    }

    @Test (priority = 4, enabled = true)
    public void newSaleCheckOutTest() {
        NewSaleCheckOutCalendarPage newSaleCheckOutCalendarPage = new NewSaleCheckOutCalendarPage(driver);
        Assert.assertTrue(newSaleCheckOutCalendarPage.newSaleCheckOut());
    }
}
