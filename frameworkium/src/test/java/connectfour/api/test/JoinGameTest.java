package connectfour.api.test;

import com.frameworkium.core.api.tests.BaseAPITest;
import connectfour.api.service.game.GameService;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;


public class JoinGameTest extends BaseAPITest {

    private GameService service;

    @DataProvider(name = "playerNames")
    public String[][] createPlayerNames() {
        return new String[][] {
                {"ABC", "200"},
                {"123", "200"},
                {"!$%", "200"},
                {"", "200"},
        };
    }

    @BeforeSuite
    public void create_service() {
        service = new GameService();
    }

    @Test
    public void joining_game_with_valid_name() {
        assertThat(service.joinGame("foo").statusCode())
                .isEqualTo(200);
    }

    @Test(dataProvider = "playerNames")
    public void data_driven_join_game(String name, String expectedStatus) {
        assertThat(service.joinGame(name).statusCode())
                .isEqualTo(Integer.parseInt(expectedStatus));
    }

}
