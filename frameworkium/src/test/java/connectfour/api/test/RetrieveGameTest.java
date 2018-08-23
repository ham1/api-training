package connectfour.api.test;

import com.frameworkium.core.api.tests.BaseAPITest;
import connectfour.api.service.game.GameService;
import io.restassured.response.ExtractableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class RetrieveGameTest extends BaseAPITest {

    private GameService service;
    private String playerId;

    @BeforeSuite
    public void create_service() {
        service = new GameService();
    }

    @BeforeTest
    public void set_player_id() {
        playerId = service.joinGame("foo").asString();
    }

    @Test
    public void get_game_state() {
        ExtractableResponse resp = service.retrieveGame(playerId);
        assertThat(resp.statusCode()).isEqualTo(202);
        assertThat(resp.body().toString().length()).isEqualTo(0); // no body if no game has started
    }

}
