package connectfour.api.constant;

public enum Endpoint {

    BASE_URI("http://localhost:8080"),
    JOIN_GAME("/api/join"),
    START_GAME("/game"),
    RETRIEVE_GAME("/api/retrieveGame");

    private String url;

    Endpoint(String url) {
        this.url = url;
    }

    /**
     * Calls {@link String#format(String, Object...)} on the url.
     *
     * @param params Arguments referenced by the format specifiers in the url.
     * @return A formatted URL String
     */
    public String getUrl(Object... params) {
        return String.format(url, params);
    }

}
