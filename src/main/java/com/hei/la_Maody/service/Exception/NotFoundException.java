package com.hei.la_Maody.service.Exception;

import java.util.function.Supplier;

public class NotFoundException extends RuntimeException  {
    public NotFoundException(String message) {
        super( message);
    }

}
