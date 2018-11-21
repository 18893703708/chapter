//package com.huyun.utils;
//
//import com.fs.common.exception.FSException;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import java.util.Set;
//
///**
// * hibernate-validator校验工具类
// */
//public class ValidatorUtils {
//    private static Validator validator;
//
//    static {
//        validator = Validation.buildDefaultValidatorFactory().getValidator();
//    }
//
//    /**
//     * 校验对象
//     * @param object        待校验对象
//     * @param groups        待校验的组
//     * @throws FSException  校验不通过，FSException异常
//     */
//    public static void validate(Object object, Class<?>... groups)
//            throws FSException {
//        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
//        if (!constraintViolations.isEmpty()) {
//            StringBuilder msg = new StringBuilder();
//            for(ConstraintViolation<Object> constraint:  constraintViolations){
//                msg.append(constraint.getMessage()).append("<br>");
//            }
//            throw new FSException(msg.toString());
//        }
//    }
//}
