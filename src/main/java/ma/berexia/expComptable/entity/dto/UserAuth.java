package ma.berexia.expComptable.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuth {
    private String jwt;
    private Date tokenExpirationDate;
}
