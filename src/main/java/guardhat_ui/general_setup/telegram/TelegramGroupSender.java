package guardhat_ui.general_setup.telegram;



import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.log4j.Logger;
import org.testng.ITestResult;


import java.io.IOException;

public class TelegramGroupSender {

    private static final Logger LOGGER = Logger.getLogger("bot.TelegramGroupSender");
    private static final String bot_token = "";
    private static final String chat_id = "";
    private static final String text = "❌";

    public void sendMessageToTelegram(ITestResult result) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.telegram.org/bot" + bot_token + "/sendMessage?chat_id=" + chat_id + "&text=" + text +
                        result.getMethod().getMethodName() + "")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "43c46a5e-93c5-4b56-9c2c-8e2b43d754e4")
                .build();

        Response response;

        {
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
