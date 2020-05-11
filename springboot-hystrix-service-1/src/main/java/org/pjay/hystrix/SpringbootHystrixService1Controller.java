/**
 * 
 */
package org.pjay.hystrix;

import static org.pjay.hystrix.ApplicationConstants.URL_SERVICE2_ERRORTHRESHOLDPERCENTAGE;
import static org.pjay.hystrix.ApplicationConstants.URL_SERVICE2_EXCEPTION;
import static org.pjay.hystrix.ApplicationConstants.URL_SERVICE2_FAILURE;
import static org.pjay.hystrix.ApplicationConstants.URL_SERVICE2_HYSTRIXCOMMAND_PROP;
import static org.pjay.hystrix.ApplicationConstants.URL_SERVICE2_RANDOM_SUCCESS_FAILURE;
import static org.pjay.hystrix.ApplicationConstants.URL_SERVICE2_REQUESTVOLUMETHRESHOLD;
import static org.pjay.hystrix.ApplicationConstants.URL_SERVICE2_SUCCESS;
import static org.pjay.hystrix.ApplicationConstants.URL_SERVICE2_TIMEOUT;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author vijayk
 *
 */
@RestController
public class SpringbootHystrixService1Controller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = { "/", "/home", "/hello" })
	public ResponseEntity<Result> hello() {
		Result result = new Result();
		result.setMessage("Hi there from Springboot Hystrix Service1");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("s1-hystrix-timeout-param/{timeOutMilliSec}")
	public ResponseEntity<Result> s1HystrixTimeoutParam(@PathVariable long timeOutMilliSec) {
		Map<String, String> params = new HashMap<String, String>();
		if (timeOutMilliSec < 0) {
			throw new RuntimeException("Time out value should be positive number");
		}
		params.put("timeOutMilliSec", (new Long(timeOutMilliSec)).toString());
		return restTemplate.exchange(URL_SERVICE2_TIMEOUT, HttpMethod.GET, null,
				new ParameterizedTypeReference<Result>() {
				}, params);
	}
	
	@GetMapping("s1-hystrix-always-success")
	public ResponseEntity<Result> s1HystrixAlwaysSuccess() {
		return restTemplate.exchange(URL_SERVICE2_SUCCESS, HttpMethod.GET, null,
				new ParameterizedTypeReference<Result>() {
				});
	}
	
	@GetMapping("s1-hystrix-always-failure")
	public ResponseEntity<Result> s1HystrixAlwaysFailure() {
		return restTemplate.exchange(URL_SERVICE2_FAILURE, HttpMethod.GET, null,
				new ParameterizedTypeReference<Result>() {
				});
	}
	
	@GetMapping("s1-hystrix-random-success-failure")
	public ResponseEntity<Result> s1HystrixRandomSuccessFailure() {
		return restTemplate.exchange(URL_SERVICE2_RANDOM_SUCCESS_FAILURE, HttpMethod.GET, null,
				new ParameterizedTypeReference<Result>() {
				});
	}
	
	@GetMapping("s1-hystrix-always-exception")
	public ResponseEntity<Result> s1HystrixAlwaysException() {
		return restTemplate.exchange(URL_SERVICE2_EXCEPTION, HttpMethod.GET, null,
				new ParameterizedTypeReference<Result>() {
				});
	}
	
	@GetMapping("s1-hystrix-errorthresholdpercentage/{timeOutMilliSec}")
	public ResponseEntity<Result> s1HystrixErrorThresholdPercentage(@PathVariable long timeOutMilliSec) {
		Map<String, String> params = new HashMap<String, String>();
		if (timeOutMilliSec < 0) {
			throw new RuntimeException("Time out value should be positive number");
		}
		params.put("timeOutMilliSec", (new Long(timeOutMilliSec)).toString());
		return restTemplate.exchange(URL_SERVICE2_ERRORTHRESHOLDPERCENTAGE, HttpMethod.GET, null,
				new ParameterizedTypeReference<Result>() {
				}, params);
	}
	
	@GetMapping("s1-hystrix-requestvolumethreshold/{timeOutMilliSec}")
	public ResponseEntity<Result> s1HystrixRequestVolumeThreshold(@PathVariable long timeOutMilliSec) {
		Map<String, String> params = new HashMap<String, String>();
		if (timeOutMilliSec < 0) {
			throw new RuntimeException("Time out value should be positive number");
		}
		params.put("timeOutMilliSec", (new Long(timeOutMilliSec)).toString());
		return restTemplate.exchange(URL_SERVICE2_REQUESTVOLUMETHRESHOLD, HttpMethod.GET, null,
				new ParameterizedTypeReference<Result>() {
				}, params);
	}
	
	@GetMapping("s1-hystrix-command-prop/{timeOutMilliSec}")
	public ResponseEntity<Result> s1HystrixCommandProp(@PathVariable long timeOutMilliSec) {
		Map<String, String> params = new HashMap<String, String>();
		if (timeOutMilliSec < 0) {
			throw new RuntimeException("Time out value should be positive number");
		}
		params.put("timeOutMilliSec", (new Long(timeOutMilliSec)).toString());
		return restTemplate.exchange(URL_SERVICE2_HYSTRIXCOMMAND_PROP, HttpMethod.GET, null,
				new ParameterizedTypeReference<Result>() {
				}, params);
	}

}
