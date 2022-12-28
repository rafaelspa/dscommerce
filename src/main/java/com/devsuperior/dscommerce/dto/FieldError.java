package com.devsuperior.dscommerce.dto;

public class FieldError {

    private String fieldName;
    private String fieldMessage;

    public FieldError(String fieldName, String fieldMessage) {
        this.fieldName = fieldName;
        this.fieldMessage = fieldMessage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }
}
