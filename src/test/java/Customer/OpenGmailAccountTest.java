package Customer;

import com.mycompany.app.AddAppointmentCustomerAcc;
import com.mycompany.app.BasicTest;
import org.testng.annotations.Test;

public class OpenGmailAccountTest extends BasicTest {

    @Test(enabled = false)
    public void openGmailTest() {
        AddAppointmentCustomerAcc newAppointment = new AddAppointmentCustomerAcc(driver);
        newAppointment.openGmail();
    }
}
