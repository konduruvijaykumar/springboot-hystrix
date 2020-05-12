/**
 * 
 */
package org.pjay.hystrix;

/**
 * @author vijayk
 *
 */
public class ApplicationConstants {
	
	public static final String API_HOST_URL = "http://localhost:8282/";
	public static final String URL_SERVICE2_TIMEOUT = API_HOST_URL + "s2-hystrix-timeout-param/{timeOutMilliSec}";
	public static final String URL_SERVICE2_SUCCESS = API_HOST_URL + "s2-hystrix-always-success";
	public static final String URL_SERVICE2_FAILURE = API_HOST_URL + "s2-hystrix-always-failure";
	public static final String URL_SERVICE2_RANDOM_SUCCESS_FAILURE = API_HOST_URL + "s2-hystrix-random-success-failure";
	public static final String URL_SERVICE2_EXCEPTION = API_HOST_URL + "s2-hystrix-always-exception";
	public static final String URL_SERVICE2_ERRORTHRESHOLDPERCENTAGE = API_HOST_URL + "s2-hystrix-errorthresholdpercentage/{timeOutMilliSec}";
	public static final String URL_SERVICE2_REQUESTVOLUMETHRESHOLD = API_HOST_URL + "s2-hystrix-requestvolumethreshold/{timeOutMilliSec}";
	public static final String URL_SERVICE2_HYSTRIXCOMMAND_PROP = API_HOST_URL + "s2-hystrix-command-prop/{timeOutMilliSec}";
	public static final String HYSTRIX_EXECUTION_TIMEOUT_IN_MILLISECONDS = "execution.isolation.thread.timeoutInMilliseconds";
	public static final String HYSTRIX_TIMEOUT_VALUE = "8000";
	
}
