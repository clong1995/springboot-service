package com.zoolon.issue.vo.param.advert;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;

@Getter
@Setter
public class ByFloorIdParam {
    @Digits(integer = 2, fraction = 0, message = "building 必须是小于 {integer}位的整数")
    @Range(min = 1, max = 99, message = "building 必须在 {min} - {max} 之间")
    private Integer id;
}