package com.application.springazuredocker.shared.domain.validators;

public class ExistenceOfAttributes {
    /**
     *  Method for validate if the attribute is null or empty
     * @param attribute
     * @param message
     * @throws IllegalArgumentException
     * @return void
     * */
    public static void validate(String attribute, String message) {
        if (attribute == null || attribute.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Method for validate is number and positive
     * @param attribute
     * @param message
     * @throws IllegalArgumentException
     * @return void
     * */
    public static void validateIsNumberAndPositive(Integer attribute, String message) {
        if (attribute == null || attribute < 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
