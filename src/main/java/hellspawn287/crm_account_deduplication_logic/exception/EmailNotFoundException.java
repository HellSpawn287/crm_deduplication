package hellspawn287.crm_account_deduplication_logic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Object with this email address does not exists")
public class EmailNotFoundException extends RuntimeException {
}
