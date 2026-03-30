package net.javaguides.ems.Expection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.management.RuntimeErrorException;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExpection extends RuntimeException
{
    public ResourceNotFoundExpection(String message) {
        super(message);
    }
}
