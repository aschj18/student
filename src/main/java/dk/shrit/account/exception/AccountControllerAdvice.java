package dk.shrit.account.exception;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


/**
 * Performs the same exception handling as {@link ExceptionHandlingController}
 * but offers them globally. The exceptions below could be raised by any
 * controller and they would be handled here, if not handled in the controller
 * already.
 * 
 * @author Paul Chapman
 */
@ControllerAdvice
public class AccountControllerAdvice {

	protected Logger logger;

	public AccountControllerAdvice() {
		logger = LoggerFactory.getLogger(getClass());
	}

	  @ExceptionHandler(AccountNotFoundException.class) 
	  public void notFoundException(final AccountNotFoundException e) {
			logger.error("Request raised a DataIntegrityViolationException");
	    }	
	

	/**
	 * Convert a predefined exception to an HTTP Status code
	 */
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "NoSuchMethod")
	// 409
	@ExceptionHandler(NoSuchMethodException.class)
	public void noSuchMethod() {
		logger.error("Request raised a NoSuchMethod");
		// Nothing to do
	}	



}
