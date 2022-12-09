package com.gs.inmemory.manageusers.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private String fieldValue;


    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s searched with %s having value as %s not found in the database.", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return this.fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException resourceName(String resourceName) {
        setResourceName(resourceName);
        return this;
    }

    public ResourceNotFoundException fieldName(String fieldName) {
        setFieldName(fieldName);
        return this;
    }

    public ResourceNotFoundException fieldValue(String fieldValue) {
        setFieldValue(fieldValue);
        return this;
    }

}
