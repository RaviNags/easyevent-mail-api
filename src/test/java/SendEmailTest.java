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
        String apiKey = "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";
        sendEmailService.sendTransactionalMail(to, 2, params, apiKey);
    }
}
