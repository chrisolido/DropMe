/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-05-19 20:48:09 UTC)
 * on 2016-05-28 at 13:55:46 UTC 
 * Modify at your own risk.
 */

package com.prasilabs.dropme.backend.dropMeApi;

/**
 * Service definition for DropMeApi (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link DropMeApiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class DropMeApi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.22.0 of the dropMeApi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myApplicationId.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "dropMeApi/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public DropMeApi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  DropMeApi(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "addVehicle".
   *
   * This request holds the parameters needed by the dropMeApi server.  After setting any optional
   * parameters, call the {@link AddVehicle#execute()} method to invoke the remote operation.
   *
   * @param hash
   * @param content the {@link com.prasilabs.dropme.backend.dropMeApi.model.VVehicle}
   * @return the request
   */
  public AddVehicle addVehicle(java.lang.String hash, com.prasilabs.dropme.backend.dropMeApi.model.VVehicle content) throws java.io.IOException {
    AddVehicle result = new AddVehicle(hash, content);
    initialize(result);
    return result;
  }

  public class AddVehicle extends DropMeApiRequest<com.prasilabs.dropme.backend.dropMeApi.model.ApiResponse> {

    private static final String REST_PATH = "addVehicle/{hash}";

    /**
     * Create a request for the method "addVehicle".
     *
     * This request holds the parameters needed by the the dropMeApi server.  After setting any
     * optional parameters, call the {@link AddVehicle#execute()} method to invoke the remote
     * operation. <p> {@link
     * AddVehicle#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param hash
     * @param content the {@link com.prasilabs.dropme.backend.dropMeApi.model.VVehicle}
     * @since 1.13
     */
    protected AddVehicle(java.lang.String hash, com.prasilabs.dropme.backend.dropMeApi.model.VVehicle content) {
      super(DropMeApi.this, "POST", REST_PATH, content, com.prasilabs.dropme.backend.dropMeApi.model.ApiResponse.class);
      this.hash = com.google.api.client.util.Preconditions.checkNotNull(hash, "Required parameter hash must be specified.");
    }

    @Override
    public AddVehicle setAlt(java.lang.String alt) {
      return (AddVehicle) super.setAlt(alt);
    }

    @Override
    public AddVehicle setFields(java.lang.String fields) {
      return (AddVehicle) super.setFields(fields);
    }

    @Override
    public AddVehicle setKey(java.lang.String key) {
      return (AddVehicle) super.setKey(key);
    }

    @Override
    public AddVehicle setOauthToken(java.lang.String oauthToken) {
      return (AddVehicle) super.setOauthToken(oauthToken);
    }

    @Override
    public AddVehicle setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (AddVehicle) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public AddVehicle setQuotaUser(java.lang.String quotaUser) {
      return (AddVehicle) super.setQuotaUser(quotaUser);
    }

    @Override
    public AddVehicle setUserIp(java.lang.String userIp) {
      return (AddVehicle) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String hash;

    /**

     */
    public java.lang.String getHash() {
      return hash;
    }

    public AddVehicle setHash(java.lang.String hash) {
      this.hash = hash;
      return this;
    }

    @Override
    public AddVehicle set(String parameterName, Object value) {
      return (AddVehicle) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getUserDetail".
   *
   * This request holds the parameters needed by the dropMeApi server.  After setting any optional
   * parameters, call the {@link GetUserDetail#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetUserDetail getUserDetail(java.lang.Long id) throws java.io.IOException {
    GetUserDetail result = new GetUserDetail(id);
    initialize(result);
    return result;
  }

  public class GetUserDetail extends DropMeApiRequest<com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser> {

    private static final String REST_PATH = "vdropmeuser/{id}";

    /**
     * Create a request for the method "getUserDetail".
     *
     * This request holds the parameters needed by the the dropMeApi server.  After setting any
     * optional parameters, call the {@link GetUserDetail#execute()} method to invoke the remote
     * operation. <p> {@link GetUserDetail#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetUserDetail(java.lang.Long id) {
      super(DropMeApi.this, "GET", REST_PATH, null, com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetUserDetail setAlt(java.lang.String alt) {
      return (GetUserDetail) super.setAlt(alt);
    }

    @Override
    public GetUserDetail setFields(java.lang.String fields) {
      return (GetUserDetail) super.setFields(fields);
    }

    @Override
    public GetUserDetail setKey(java.lang.String key) {
      return (GetUserDetail) super.setKey(key);
    }

    @Override
    public GetUserDetail setOauthToken(java.lang.String oauthToken) {
      return (GetUserDetail) super.setOauthToken(oauthToken);
    }

    @Override
    public GetUserDetail setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetUserDetail) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetUserDetail setQuotaUser(java.lang.String quotaUser) {
      return (GetUserDetail) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetUserDetail setUserIp(java.lang.String userIp) {
      return (GetUserDetail) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetUserDetail setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetUserDetail set(String parameterName, Object value) {
      return (GetUserDetail) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getVehicleDetail".
   *
   * This request holds the parameters needed by the dropMeApi server.  After setting any optional
   * parameters, call the {@link GetVehicleDetail#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetVehicleDetail getVehicleDetail(java.lang.Long id) throws java.io.IOException {
    GetVehicleDetail result = new GetVehicleDetail(id);
    initialize(result);
    return result;
  }

  public class GetVehicleDetail extends DropMeApiRequest<com.prasilabs.dropme.backend.dropMeApi.model.VVehicle> {

    private static final String REST_PATH = "vvehicle/{id}";

    /**
     * Create a request for the method "getVehicleDetail".
     *
     * This request holds the parameters needed by the the dropMeApi server.  After setting any
     * optional parameters, call the {@link GetVehicleDetail#execute()} method to invoke the remote
     * operation. <p> {@link GetVehicleDetail#initialize(com.google.api.client.googleapis.services.Abs
     * tractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetVehicleDetail(java.lang.Long id) {
      super(DropMeApi.this, "GET", REST_PATH, null, com.prasilabs.dropme.backend.dropMeApi.model.VVehicle.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetVehicleDetail setAlt(java.lang.String alt) {
      return (GetVehicleDetail) super.setAlt(alt);
    }

    @Override
    public GetVehicleDetail setFields(java.lang.String fields) {
      return (GetVehicleDetail) super.setFields(fields);
    }

    @Override
    public GetVehicleDetail setKey(java.lang.String key) {
      return (GetVehicleDetail) super.setKey(key);
    }

    @Override
    public GetVehicleDetail setOauthToken(java.lang.String oauthToken) {
      return (GetVehicleDetail) super.setOauthToken(oauthToken);
    }

    @Override
    public GetVehicleDetail setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetVehicleDetail) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetVehicleDetail setQuotaUser(java.lang.String quotaUser) {
      return (GetVehicleDetail) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetVehicleDetail setUserIp(java.lang.String userIp) {
      return (GetVehicleDetail) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetVehicleDetail setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetVehicleDetail set(String parameterName, Object value) {
      return (GetVehicleDetail) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "loginsignup".
   *
   * This request holds the parameters needed by the dropMeApi server.  After setting any optional
   * parameters, call the {@link Loginsignup#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser}
   * @return the request
   */
  public Loginsignup loginsignup(com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser content) throws java.io.IOException {
    Loginsignup result = new Loginsignup(content);
    initialize(result);
    return result;
  }

  public class Loginsignup extends DropMeApiRequest<com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser> {

    private static final String REST_PATH = "loginsignup";

    /**
     * Create a request for the method "loginsignup".
     *
     * This request holds the parameters needed by the the dropMeApi server.  After setting any
     * optional parameters, call the {@link Loginsignup#execute()} method to invoke the remote
     * operation. <p> {@link
     * Loginsignup#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser}
     * @since 1.13
     */
    protected Loginsignup(com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser content) {
      super(DropMeApi.this, "POST", REST_PATH, content, com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser.class);
    }

    @Override
    public Loginsignup setAlt(java.lang.String alt) {
      return (Loginsignup) super.setAlt(alt);
    }

    @Override
    public Loginsignup setFields(java.lang.String fields) {
      return (Loginsignup) super.setFields(fields);
    }

    @Override
    public Loginsignup setKey(java.lang.String key) {
      return (Loginsignup) super.setKey(key);
    }

    @Override
    public Loginsignup setOauthToken(java.lang.String oauthToken) {
      return (Loginsignup) super.setOauthToken(oauthToken);
    }

    @Override
    public Loginsignup setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Loginsignup) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Loginsignup setQuotaUser(java.lang.String quotaUser) {
      return (Loginsignup) super.setQuotaUser(quotaUser);
    }

    @Override
    public Loginsignup setUserIp(java.lang.String userIp) {
      return (Loginsignup) super.setUserIp(userIp);
    }

    @Override
    public Loginsignup set(String parameterName, Object value) {
      return (Loginsignup) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link DropMeApi}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link DropMeApi}. */
    @Override
    public DropMeApi build() {
      return new DropMeApi(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link DropMeApiRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setDropMeApiRequestInitializer(
        DropMeApiRequestInitializer dropmeapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(dropmeapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
