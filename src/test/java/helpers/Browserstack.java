package helpers;

import static io.restassured.RestAssured.given;


public class Browserstack {
    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(System.getProperty("bs_user"), System.getProperty("bs_key"))
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
