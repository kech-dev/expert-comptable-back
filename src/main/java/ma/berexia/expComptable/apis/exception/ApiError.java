package ma.berexia.expComptable.apis.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private String error;
    private String message;
}
