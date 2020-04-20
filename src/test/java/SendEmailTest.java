import com.easyevent.sendingemailmodule.model.EmailTemplate;
import com.easyevent.sendingemailmodule.service.SendEmailService;
import com.squareup.okhttp.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.easyevent.sendingemailmodule.SendingemailApplication;


import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SendingemailApplication.class)
@Slf4j
public class SendEmailTest {

    @Autowired
    private SendEmailService sendEmailService;

    @Test
    @Ignore
    public final void sendEmailtest() throws IOException {
        ArrayList<String> to = new ArrayList<String>();
       // to.add("alex.rajamohan@hotmail.fr");
          to.add("ravi.nag@easyevent.fr");
        LocalDate date = LocalDate.now();
        Float currentBudget = 13100F;
        Float totalBudget = 25000F;
        DecimalFormat df = new DecimalFormat("#.#");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRANCE);
        DateTimeFormatter formatterNow = DateTimeFormatter.ofPattern("d MMMM", Locale.FRANCE);
        Map<String, Object> params = new HashMap<>();
        params.put("event_date", formatter.format(date));
        params.put("date_now", formatterNow.format(date));
        params.put("current_budget", df.format(currentBudget/1000));
        params.put("total_budget", df.format(totalBudget/1000));
        params.put("nb_todo_task", 19);
        params.put("nb_total_task", 38);
        params.put("nb_revive_family", 5);
        params.put("nb_total_family", 57);


        ResponseBody body = sendEmailService.sendTransactionalMail(to, EmailTemplate.HEBDO_SITUATION, params);
        log.error("Reponse reçu de sendinblue " + body.toString());
    }
}
