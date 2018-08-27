package connectfour.api.service.game;

import com.google.common.collect.ImmutableMap;
import connectfour.api.constant.C4Endpoint;
import connectfour.api.service.BaseConnectFourService;
import io.restassured.response.ExtractableResponse;

public class GameService extends BaseConnectFourService {

    public ExtractableResponse joinGame(String name) {
        return get(C4Endpoint.JOIN_GAME.getUrl(),
                ImmutableMap.of("playerName", name));
    }

    public ExtractableResponse retrieveGame(String uuid) {
        return get(C4Endpoint.RETRIEVE_GAME.getUrl(),
                ImmutableMap.of("playerId", uuid));
    }
}