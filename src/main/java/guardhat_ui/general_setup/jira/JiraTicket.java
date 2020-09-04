package guardhat_ui.general_setup.jira;

import okhttp3.*;
import org.testng.ITestResult;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JiraTicket {

    private static final String JIRA_AUTHORIZATION = "Basic RGF2aXQuQXJ6dW1hbnlhbi1leHRAZ3VhcmRoYXQuY29tOkpiQmxjc3NBdG5zNlVPYmp4bTRVQjIyMA==";
    private static final String JIRA_COOKIE = "atlassian.xsrf.token=40f5c84b-4592-465d-ae2d-0183d1ae5d08_6671fa3d53ba8199e0f3d81a992c86458c40a6dd_lin";
    public static final String KEY = "GUAR";
    public static final String ISSUE_TYPE_BUG = "Bug";
    public static final String ISSUE_TYPE_TASK = "Task";
    public static final String ISSUE_TYPE_STORY = "Story";
    public static final String JIRA_URL = "https://sqaguardhat.atlassian.net/rest/api/2/issue/";

    public static String getCURRENT_DATE_TIME() {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        return dateTimeFormat.format(currentTime);
    }

    public static void createIssueJira(ITestResult result, String jiraURL, String key, String summary, String description, String environment, String issueType) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"fields\":{\"project\":{\"key\": \"" + key + "\"},\"summary\": \"" + summary + "\",\"description\": \"" + description + "\",\"environment\": \"" + environment + "\",\"issuetype\": {\"name\": \"" + issueType + "\"}}}");
        Request request = new Request.Builder()
                .url(jiraURL)
                .method("POST", body)
                .addHeader("Authorization", JIRA_AUTHORIZATION)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", JIRA_COOKIE)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
