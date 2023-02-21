package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarPageTests extends BasicTest {

    @Test (priority = 1, enabled = true)
    public void createAppointmentTest() {
        AddNewAppointmentCalendarPage newAppointmentCalendarPage = new AddNewAppointmentCalendarPage(driver);
        Assert.assertTrue(newAppointmentCalendarPage.createAppointment());
    }

    @Test (priority = 2, enabled = true)
    public void cancelAppointmentTest() {
        CancelAppointmentCalendarPage cancelAppointmentCalendarPage = new CancelAppointmentCalendarPage(driver);
        Assert.assertTrue(cancelAppointmentCalendarPage.cancelAppointment());
    }

    @Test (priority = 3, enabled = true)
    public void addBlockedTimeTest() {
        AddBlockedTimeCalendarPage addBlockedTimeCalendarPage = new AddBlockedTimeCalendarPage(driver);
        addBlockedTimeCalendarPage.addBlockedTime();
    }

    @Test (priority = 4, enabled = true)
    public void newSaleCheckOutTest() {
        NewSaleCheckOutCalendarPage newSaleCheckOutCalendarPage = new NewSaleCheckOutCalendarPage(driver);
        Assert.assertTrue(newSaleCheckOutCalendarPage.newSaleCheckOut());
    }
}
