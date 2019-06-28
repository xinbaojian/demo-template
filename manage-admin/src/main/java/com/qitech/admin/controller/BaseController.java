package com.qitech.admin.controller;

import com.github.pagehelper.PageInfo;
import com.qitech.constant.GlobalConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author xin.bj
 */
@Slf4j
public class BaseController {


    /**
     * 获取当前Request
     *
     * @return
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    /**
     * 判断是否属于Ajax请求
     *
     * @return
     */
    protected Boolean isAjax() {
        String requestType = getRequest().getHeader("X-Requested-With");
        return GlobalConstants.XML_HTTP_REQUEST.equals(requestType);
    }

    /**
     * 获取zuul 请求中携带的用户名
     *
     * @return
     */
    protected String getUserName() {
        return getRequest().getHeader(GlobalConstants.HEADER_LOGIN_NAME);
    }

//    protected String getUserId() {
//        return getUser().getId();
//    }

    /**
     * 获取当前用户
     *
     * @return
     */
//    protected SysUser getUser() {
//        String userName = getUserName();
//        if (StringUtil.isNoneBlank(userName)) {
//            Optional<SysUser> userOptional = userAdminService.selectByLoginName(userName);
//            return userOptional.orElseGet(SysUser::new);
//        }
//        return new SysUser();
//    }
    protected ResponseEntity getFiledErrorResponseEntity(BindingResult bindingResult) {
        // 得到全部不合法的字段
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError ->
                log.info("error field is : {} ,message is : {}", fieldError.getField(), fieldError.getDefaultMessage())
        );
        return new ResponseEntity(String.format("字段: %s %s", fieldErrors.get(0).getField(), fieldErrors.get(0).getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity returnPageInfo(PageInfo pageInfo) {
        if (pageInfo == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(pageInfo, HttpStatus.OK);
    }

}
