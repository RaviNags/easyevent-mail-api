import com.easyevent.sendingemailmodule.model.EmailTemplate;
import com.easyevent.sendingemailmodule.service.SendEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.easyevent.sendingemailmodule.SendingemailApplication;


import java.io.IOException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SendingemailApplication.class)
public class SendEmailTest {

    @Autowired
    private SendEmailService sendEmailService;

    @Test
    public final void sendEmailtest() throws IOException {
        ArrayList<String> to = new ArrayList<String>();
        to.add("alex.rajamohan@hotmail.fr");
//        to.add("ravi.nag@easyevent.fr");

        Map<String, String> params = new HashMap<String, String>();
        params.put("recipientFirstName", "Nag's");
        params.put("recipientLastName", "Ravi");
        sendEmailService.sendTransactionalMail(to, EmailTemplate.REGISTER, params);
    }
}
