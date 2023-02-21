package Customer;

import com.mycompany.app.AddAppointmentCustomerAcc;
import com.mycompany.app.BasicTest;
import org.testng.annotations.Test;

public class AddAppointmentCustomerAccTest extends BasicTest {

    @Test (enabled = false)
    public void testAddNewAppointmentCustomerAcc() {
       // driver.get("https://www.fresha.com/a/salon-montreal-montreal-botanical-garden-sherbrooke-street-east-montreal-4101-rue-sherbrooke-est-oc2k8lk3/booking");
        AddAppointmentCustomerAcc newAppointment = new AddAppointmentCustomerAcc(driver);
        newAppointment.addAppointmentByCustomer();
    }
}
