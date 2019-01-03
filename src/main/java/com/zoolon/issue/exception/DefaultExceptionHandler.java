package com.zoolon.issue.exception;

import com.zoolon.issue.result.ResultCode;
import com.zoolon.issue.result.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler {
    /**
     * 捕获自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResultJson handleCustomException(CustomException e) {
        e.printStackTrace();
        log.error(e.getResultJson().getMsg());
        return e.getResultJson();
    }

    /**
     * 主键冲突异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResultJson handleDuplicateKeyException(DuplicateKeyException e) {
        e.printStackTrace();
        String errMsg = e.getMessage();
        String errCode = "异常代号:" + new Date().getTime();
        log.error("\r\n>>>>>>> " + errCode + " <<<<<<<" + errMsg);
        return ResultJson.failure(ResultCode.DUPLICATE_KEY, errCode);
    }

    /**
     * 参数检验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultJson handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        String errMsg = e.getMessage();
        String errCode = "异常代号:" + new Date().getTime();
        log.error("\r\n>>>>>>> " + errCode + " <<<<<<<" + errMsg);
        return ResultJson.failure(ResultCode.PARAM_ERROR, errCode);
    }

}
