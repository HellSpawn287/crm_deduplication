package hellspawn287.crm_account_deduplication_logic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Object with this id is already exists")
public class DuplicateIdNumberException extends RuntimeException {
}
