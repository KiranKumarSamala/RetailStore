package com.retail.exception;

public class RetailException extends Exception {

    private static final long serialVersionUID = 4954608775220900946L;
    private String errorMsg;

    public RetailException(String errorMsg) {
        super();
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
