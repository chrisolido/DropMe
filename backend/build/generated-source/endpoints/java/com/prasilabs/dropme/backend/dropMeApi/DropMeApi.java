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
 * on 2016-05-26 at 12:09:16 UTC 
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
   * An accessor for creating requests from the DropMeEndPoint collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code DropMeApi dropMeApi = new DropMeApi(...);}
   *   {@code DropMeApi.DropMeEndPoint.List request = dropMeApi.dropMeEndPoint().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public DropMeEndPoint dropMeEndPoint() {
    return new DropMeEndPoint();
  }

  /**
   * The "dropMeEndPoint" collection of methods.
   */
  public class DropMeEndPoint {

    /**
     * Create a request for the method "dropMeEndPoint.login".
     *
     * This request holds the parameters needed by the dropMeApi server.  After setting any optional
     * parameters, call the {@link Login#execute()} method to invoke the remote operation.
     *
     * @return the request
     */
    public Login login() throws java.io.IOException {
      Login result = new Login();
      initialize(result);
      return result;
    }

    public class Login extends DropMeApiRequest<com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser> {

      private static final String REST_PATH = "login";

      /**
       * Create a request for the method "dropMeEndPoint.login".
       *
       * This request holds the parameters needed by the the dropMeApi server.  After setting any
       * optional parameters, call the {@link Login#execute()} method to invoke the remote operation.
       * <p> {@link
       * Login#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @since 1.13
       */
      protected Login() {
        super(DropMeApi.this, "POST", REST_PATH, null, com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser.class);
      }

      @Override
      public Login setAlt(java.lang.String alt) {
        return (Login) super.setAlt(alt);
      }

      @Override
      public Login setFields(java.lang.String fields) {
        return (Login) super.setFields(fields);
      }

      @Override
      public Login setKey(java.lang.String key) {
        return (Login) super.setKey(key);
      }

      @Override
      public Login setOauthToken(java.lang.String oauthToken) {
        return (Login) super.setOauthToken(oauthToken);
      }

      @Override
      public Login setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (Login) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Login setQuotaUser(java.lang.String quotaUser) {
        return (Login) super.setQuotaUser(quotaUser);
      }

      @Override
      public Login setUserIp(java.lang.String userIp) {
        return (Login) super.setUserIp(userIp);
      }

      @Override
      public Login set(String parameterName, Object value) {
        return (Login) super.set(parameterName, value);
      }
    }

  }

  /**
   * Create a request for the method "signup".
   *
   * This request holds the parameters needed by the dropMeApi server.  After setting any optional
   * parameters, call the {@link Signup#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser}
   * @return the request
   */
  public Signup signup(com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser content) throws java.io.IOException {
    Signup result = new Signup(content);
    initialize(result);
    return result;
  }

  public class Signup extends DropMeApiRequest<com.prasilabs.dropme.backend.dropMeApi.model.ApiResponse> {

    private static final String REST_PATH = "signup";

    /**
     * Create a request for the method "signup".
     *
     * This request holds the parameters needed by the the dropMeApi server.  After setting any
     * optional parameters, call the {@link Signup#execute()} method to invoke the remote operation.
     * <p> {@link
     * Signup#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
     * be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser}
     * @since 1.13
     */
    protected Signup(com.prasilabs.dropme.backend.dropMeApi.model.VDropMeUser content) {
      super(DropMeApi.this, "POST", REST_PATH, content, com.prasilabs.dropme.backend.dropMeApi.model.ApiResponse.class);
    }

    @Override
    public Signup setAlt(java.lang.String alt) {
      return (Signup) super.setAlt(alt);
    }

    @Override
    public Signup setFields(java.lang.String fields) {
      return (Signup) super.setFields(fields);
    }

    @Override
    public Signup setKey(java.lang.String key) {
      return (Signup) super.setKey(key);
    }

    @Override
    public Signup setOauthToken(java.lang.String oauthToken) {
      return (Signup) super.setOauthToken(oauthToken);
    }

    @Override
    public Signup setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Signup) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Signup setQuotaUser(java.lang.String quotaUser) {
      return (Signup) super.setQuotaUser(quotaUser);
    }

    @Override
    public Signup setUserIp(java.lang.String userIp) {
      return (Signup) super.setUserIp(userIp);
    }

    @Override
    public Signup set(String parameterName, Object value) {
      return (Signup) super.set(parameterName, value);
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