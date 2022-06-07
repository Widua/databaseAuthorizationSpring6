package me.widua.databaseauthorizationspring6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntityBody {

    private String message;
    private HttpStatus status;
    private Object optionalBody ;

    //Without optionalBody
    public ResponseEntityBody(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
