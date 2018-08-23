package connectfour.api.service.game;

import connectfour.api.constant.Endpoint;
import connectfour.api.service.BaseConnectFourService;
import io.restassured.response.ExtractableResponse;

import java.util.HashMap;
import java.util.Map;

public class GameService extends BaseConnectFourService {



    public ExtractableResponse joinGame(String name) {
        Map<String, String> params = new HashMap<>();
        params.put("playerName", name);
        return get(Endpoint.JOIN_GAME.getUrl(), params);
    }

    public ExtractableResponse retrieveGame(String uuid) {
        Map<String, String> params = new HashMap<>();
        params.put("playerId", uuid);
        return get(Endpoint.RETRIEVE_GAME.getUrl(), params);
    }
}