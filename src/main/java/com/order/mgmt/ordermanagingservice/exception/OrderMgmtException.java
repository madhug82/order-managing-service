package com.order.mgmt.ordermanagingservice.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class OrderMgmtException extends Exception  {

    private static final Logger logger = Logger.getLogger(OrderMgmtException.class.getName());

    private String errorKey = "";
    private String errorMessage = "";

    public OrderMgmtException(String errorKey, String errorMessage) {
        this.errorKey = errorKey;
        this.errorMessage = errorMessage;

    }

    public OrderMgmtException(String errorMessage, Throwable cause, boolean printStacktrace) {

        this.errorKey = errorKey;
        this.errorMessage = errorMessage;
        if (cause != null) {
            this.initCause(cause);
        }
        logger.error(errorKey + ":" + errorMessage, this);
    }


}
