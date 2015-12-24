
package com.capitalone.ease_qa.ui.atf.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.capitalone.ease_qa.ui.atf.driver.Impl.DefaultSessionFactory;

/**
 * @author gtg716
 * 
 * SessionManager for the testing framework. Uses a ThreadLocal so each thread
 * of test execution has its own manager instance.
 * 
 */

 public class SessionManager {

    private Map<String, ExtUiDriver> sessions = new HashMap<String, ExtUiDriver>();

    private final static String DEFAULT_SESSION = "default";

    private final static int MAX_RETRIES = 5;

    private String currentSessionId = DEFAULT_SESSION;
    private int nextCustomSessionId = 1;

    private boolean doCleanup = true;

    private SessionManager() {

    }

    private static ThreadLocal<SessionManager> sessionManager = new ThreadLocal<SessionManager>() {
        protected synchronized SessionManager initialValue() {
            return new SessionManager();
        }
    };
    
    private static ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal<SessionFactory>() {
        protected synchronized SessionFactory initialValue() {
            return new DefaultSessionFactory();
        }
    };


    /**
     * Obtain the ThreadLocal instance of SessionManager. Configures the
     * instance to use DefaultSessionFactory()
     * 
     * @return SessionManager, the ThreadLocal instance of SessionManager
     * 
     * @see setSessionFactory
     */

    public static SessionManager getInstance() {
    	return sessionManager.get();
    }

   
    public SessionManager setSessionFactory(SessionFactory impl) {
        sessionFactory.set(impl);
        return this;
    }

   
   
    public ExtUiDriver getCurrentSession(boolean createIfNotFound) {

        for (int i = 0; i < MAX_RETRIES; i++) {
            ExtUiDriver sel = sessions.get(currentSessionId);
            try {
                if ((sel == null) && (createIfNotFound)) {
                    sel = getNewSession();
                }
                return sel;
            } catch (Exception e) {
                // if the exception is of type UnreachableBrowserException, try
                // again
                if (!(e instanceof UnreachableBrowserException)) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

   

    public ExtUiDriver getCurrentSession() {
        return getCurrentSession(true);
    }

    

    public ExtUiDriver getSession(String sessionId) {
        return sessions.get(sessionId);
    }

  

    public Map<String, ExtUiDriver> getSessions() {
        return sessions;
    }

  
    public void switchToSession(String sessionId) {
        currentSessionId = sessionId;
    }

    

    public void switchToSession(ExtUiDriver ewd) {
        currentSessionId = ewd.getSessionId();
    }

    /**
     * Get the ID of the current ExtUiDriver session associated with this
     * SessionManager
     * 
     * @return
     */
    public String getCurrentSessionId() {
        return currentSessionId;
    }

 

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

  

    public void removeSession(ExtUiDriver session) {
        sessions.remove(session.getSessionId());
    }

  
    public ExtUiDriver getNewSession() throws Exception {
        return getNewSession(true);
    }

  
    public ExtUiDriver getNewSession(boolean setAsCurrent) throws Exception {
        Map<String, String> options = sessionFactory.get().createDefaultOptions();
        return getNewSessionDo(options, setAsCurrent);
    }

   

    public ExtUiDriver getNewSession(String key, String value) throws Exception {
        return getNewSession(key, value, true);
    }

   

    public ExtUiDriver getNewSession(String key, String value, boolean setAsCurrent)
            throws Exception {

        /**
         * This is where the clientPropertiesFile is parsed and key-value pairs
         * are added into the options map
         */
        Map<String, String> options = sessionFactory.get().createDefaultOptions();
        options.put(key, value);

        return getNewSessionDo(options, setAsCurrent);
    }

  

    public ExtUiDriver getNewSession(Map<String, String> override) throws Exception {
        return getNewSession(override, true);
    }

   

    public ExtUiDriver getNewSession(Map<String, String> override, boolean setAsCurrent)
            throws Exception {

        Map<String, String> options = sessionFactory.get().createDefaultOptions();

        for (Entry<String, String> opt : override.entrySet()) {
            options.put(opt.getKey(), opt.getValue());
        }

        return getNewSessionDo(options, setAsCurrent);
    }

    private ExtUiDriver getNewSessionDo(Map<String, String> options, boolean setAsCurrent)
            throws Exception {

        if (doCleanup) {
            sessionFactory.get().cleanup(options);
            doCleanup = false;
        }

        // Get capabilities
        DesiredCapabilities dc = sessionFactory.get().createCapabilities(options);

        // Get driver instance
    //   WebDriver innerDriver = sessionFactory.get().createInnerDriver(options, dc);

        // Inject as wrapped driver
       ExtUiDriver sel = sessionFactory.get().createNewSession(options, dc);

        String sessionId = getNextCustomSessionId();
        if (setAsCurrent) {
            currentSessionId = sessionId;
        }

        // Store the session in sessions Map
        sessions.put(sessionId, sel);

        // Pass ID to the EWD instance
        sel.setSessionId(sessionId);

        return sel;
    }

    /**
     * 
     * @return String of the next session Id
     */
    private String getNextCustomSessionId() {
        String id = "custom_" + nextCustomSessionId;
        nextCustomSessionId++;
        return id;
    }
}
