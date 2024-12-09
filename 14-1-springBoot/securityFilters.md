Spring Security provides a robust filtering chain that processes every request. Below is a list of filters provided by Spring Security, organized in their typical order of execution in the **filter chain**:

---

### **Core Filters**

1. **`WebAsyncManagerIntegrationFilter`**
   - Integrates with Spring's `WebAsyncManager` for handling asynchronous web requests.

2. **`SecurityContextPersistenceFilter`**
   - Restores the `SecurityContext` for the current thread using a `SecurityContextRepository`.

3. **`HeaderWriterFilter`**
   - Adds security-related HTTP response headers, such as `X-Content-Type-Options`, `X-Frame-Options`, `Strict-Transport-Security`, etc.

4. **`CorsFilter`**
   - Handles Cross-Origin Resource Sharing (CORS) policies.

5. **`CsrfFilter`**
   - Protects against Cross-Site Request Forgery (CSRF) attacks by checking CSRF tokens.

6. **`LogoutFilter`**
   - Processes logout requests and clears the authentication state.

7. **`OAuth2AuthorizationRequestRedirectFilter`**
   - Handles initiating the OAuth2 Authorization Code Grant flow.

8. **`OAuth2LoginAuthenticationFilter`**
   - Processes OAuth2 login responses and exchanges authorization codes for access tokens.

9. **`Saml2WebSsoAuthenticationFilter`**
   - Handles authentication using SAML 2.0 Web Single Sign-On (SSO).

10. **`UsernamePasswordAuthenticationFilter`**
    - Processes username and password-based authentication requests.

11. **`ConcurrentSessionFilter`**
    - Manages session concurrency to ensure a user is logged in from only a single session.

12. **`BearerTokenAuthenticationFilter`**
    - Processes authentication for Bearer tokens (e.g., in OAuth2 or JWT scenarios).

13. **`BasicAuthenticationFilter`**
    - Processes HTTP Basic authentication credentials.

14. **`RequestCacheAwareFilter`**
    - Restores the original request after successful authentication, if it was cached.

15. **`SecurityContextHolderAwareRequestFilter`**
    - Wraps the `HttpServletRequest` for providing SecurityContext-related convenience methods.

16. **`AnonymousAuthenticationFilter`**
    - Assigns an anonymous authentication token if no other authentication is present.

17. **`SessionManagementFilter`**
    - Handles session-related functionality like detecting expired sessions.

18. **`ExceptionTranslationFilter`**
    - Handles exceptions thrown during the security filter chain, such as `AccessDeniedException` or `AuthenticationException`.

19. **`FilterSecurityInterceptor`**
    - Performs access control checks against secured resources.

---

### **Custom/Additional Filters**

Depending on your configuration and custom requirements, you may include custom filters at specific points in the chain. Spring Security allows you to:
- Replace or override existing filters.
- Add your own filters using the `addFilterBefore` or `addFilterAfter` methods.

---

### **Order of Execution**

The filters are typically executed in the order mentioned above. However, the order can be customized if required. Filters like `UsernamePasswordAuthenticationFilter` or `BearerTokenAuthenticationFilter` can be replaced or augmented with custom implementations.

