package com.zoolon.issue.vo.param.advert;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;

@Getter
@Setter
@Builder
public class RelationParam {
    @Digits(integer = 2, fraction = 0, message = "id 必须是小于 {integer}位的整数")
    @Range(min = 1, max = 32767, message = "id 必须在 {min} - {max} 之间")
    private Integer advert;
    @Digits(integer = 2, fraction = 0, message = "id 必须是小于 {integer}位的整数")
    @Range(min = 1, max = 32767, message = "id 必须在 {min} - {max} 之间")
    private Integer ad;
    @Digits(integer = 2, fraction = 0, message = "id 必须是小于 {integer}位的整数")
    @Range(min = 1, max = 32767, message = "id 必须在 {min} - {max} 之间")
    private Integer danger;
}