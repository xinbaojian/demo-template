package com.qitech.spring.utils;

import com.qitech.constant.GlobalConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author xin.bj
 * @program security-parent
 * @description ErrorUtils
 * @create 2019-01-11 14:44
 **/
@Slf4j
public class ErrorUtils {
    private ErrorUtils() {
    }

    public static String checkErrors(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 得到全部不合法的字段
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> log.info("error field is : {} ,message is : {}",
                    fieldError.getField(), fieldError.getDefaultMessage()));
            return String.format("字段: %s %s", fieldErrors.get(0).getField(), fieldErrors.get(0).getDefaultMessage());
        }
        return GlobalConstants.OK;
    }
}
