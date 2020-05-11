/**
 * 
 */
package org.pjay.hystrix;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
@RestController
public class SpringbootHystrixService2Controller {
	
	Random random = new Random();
	
	@GetMapping(value = { "/", "/home", "/hello" })
	public ResponseEntity<Result> hello() {
		Result result = new Result();
		result.setMessage("Hi there from Springboot Hystrix Service2");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("s2-hystrix-timeout-param/{timeOutMilliSec}")
	public ResponseEntity<Result> s2HystrixTimeoutParam(@PathVariable long timeOutMilliSec) throws InterruptedException {
		Result result = new Result();
		Thread.sleep(timeOutMilliSec);
		result.setMessage("Response from s2HystrixTimeoutParam("+timeOutMilliSec+") method");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("s2-hystrix-always-success")
	public ResponseEntity<Result> s2HystrixAlwaysSuccess() {
		Result result = new Result();
		result.setMessage("Response from s2HystrixAlwaysSuccess() method");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("s2-hystrix-always-failure")
	public ResponseEntity<Result> s2HystrixAlwaysFailure() throws InterruptedException {
		Result result = new Result();
		Thread.sleep(18000); // more value than defined in service1 for timeout
		result.setMessage("Response from s2HystrixAlwaysSuccess() method");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("s2-hystrix-random-success-failure")
	public ResponseEntity<Result> s2HystrixRandomSuccessFailure() throws InterruptedException {
		Result result = new Result();
		if(random.nextBoolean()) {
			Thread.sleep(18000); // more value than defined in service1 for timeout
			result.setMessage("Response from s2HystrixRandomSuccessFailure() method failed");
		}else {
			result.setMessage("Response from s2HystrixRandomSuccessFailure() method successful");
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("s2-hystrix-always-exception")
	public ResponseEntity<Result> s2HystrixAlwaysException() {
		Result result = new Result();
		result.setMessage("s2HystrixAlwaysException() method failed with exception");
		throw new RuntimeException("s2HystrixAlwaysException() method failed with exception");
	}
	
	@GetMapping("s2-hystrix-errorthresholdpercentage/{timeOutMilliSec}")
	public ResponseEntity<Result> s2HystrixErrorThresholdPercentage(@PathVariable long timeOutMilliSec) throws InterruptedException {
		Result result = new Result();
		Thread.sleep(timeOutMilliSec);
		result.setMessage("Response from s2HystrixErrorThresholdPercentage("+timeOutMilliSec+") method");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("s2-hystrix-requestvolumethreshold/{timeOutMilliSec}")
	public ResponseEntity<Result> s2HystrixRequestVolumeThreshold(@PathVariable long timeOutMilliSec) throws InterruptedException {
		Result result = new Result();
		Thread.sleep(timeOutMilliSec);
		result.setMessage("Response from s2HystrixRequestVolumeThreshold("+timeOutMilliSec+") method");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("s2-hystrix-command-prop/{timeOutMilliSec}")
	public ResponseEntity<Result> s2HystrixCommandProp(@PathVariable long timeOutMilliSec) throws InterruptedException {
		Result result = new Result();
		Thread.sleep(timeOutMilliSec);
		result.setMessage("Response from s2HystrixCommandProp("+timeOutMilliSec+") method");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
