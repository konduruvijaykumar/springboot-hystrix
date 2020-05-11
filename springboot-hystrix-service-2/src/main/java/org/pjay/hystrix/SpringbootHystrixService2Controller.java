/**
 * 
 */
package org.pjay.hystrix;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
@RestController
public class SpringbootHystrixService2Controller {
	
	@GetMapping(value = { "/", "/home", "/hello" })
	public ResponseEntity<Result> hello() {
		Result result = new Result();
		result.setMessage("Hi there from Springboot Hystrix Service2");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
