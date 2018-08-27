package connectfour.api.service;

import com.frameworkium.core.api.services.BaseService;
import connectfour.api.constant.C4Endpoint;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

/** Base Service for connect four specific services. */
public class BaseConnectFourService extends BaseService {

    /**
     * @return a Rest Assured {@link RequestSpecification} with the baseUri
     * (and anything else required by services).
     */
    @Override
    protected RequestSpecification getRequestSpec() {
        return RestAssured.given().baseUri(C4Endpoint.BASE_URI.getUrl());
    }

    /**
     * @return a Rest Assured {@link ResponseSpecification} with basic checks
     * (and anything else required by services).
     */
    @Override
    protected ResponseSpecification getResponseSpec() {
        return RestAssured.expect().response();
    }

    protected ExtractableResponse get(String url) {
        return request(url);
    }

    protected ExtractableResponse get(String url, Map<String, ?> params) {
        return request(params, url);
    }

}
