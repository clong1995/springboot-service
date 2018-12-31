package com.zoolon.issue.exception;

import com.zoolon.issue.result.ResultCode;
import com.zoolon.issue.result.ResultJson;
import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class CustomException extends RuntimeException {
    private ResultJson resultJson;
    public CustomException(ResultCode code, Object o) {
        this.resultJson = ResultJson.failure(code, o);
    }
}
