package com.zoolon.issue.vo.param.advert;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;


@Getter
@Setter
public class AddParam {
    private Integer id;
    @Size(min = 0, max = 20, message = "name 长度必须小于 {min} - {max} 之间")
    private String name;

    @Size(min = 1, max = 50, message = "position 长度必须在 {min} - {max} 之间")
    private String position;

    @Digits(integer = 2, fraction = 0, message = "building 必须是小于 {integer}位的整数")
    @Range(min = 1, max = 99, message = "building 必须在 {min} - {max} 之间")
    private Integer building;

    @Digits(integer = 2, fraction = 0, message = "floor 必须是小于 {integer}位的整数")
    @Range(min = 1, max = 99, message = "floor 必须在 {min} - {max} 之间")
    private Integer floor;

    @Digits(integer = 4, fraction = 0, message = "width 必须是小于 {integer}位的整数")
    @Range(min = 1, max = 9999, message = "width 必须在 {min} - {max} 之间")
    private Integer width;

    @Digits(integer = 4, fraction = 0, message = "height 必须是小于 {integer}位的整数")
    @Range(min = 1, max = 9999, message = "height 必须在 {min} - {max} 之间")
    private Integer height;

    @Size(min = 7, max = 15, message = "ip 长度必须是 {min} 位")
    private String ip;

    @Digits(integer = 2, fraction = 0, message = "devType 必须是小于 {integer}位的整数")
    @Range(min = 1, max = 99, message = "devType 必须在 {min} - {max} 之间")
    private Integer devType;

    @Size(min = 1, max = 20, message = "devName 长度必须在 {min} - {max} 之间")
    private String devName;

    @Size(min = 0, max = 200, message = "remark 长度必须小于 {min} - {max} 之间")
    private String remark;

    @Size(min = 17, max = 17, message = "mac 长度必须是 {max} 位")
    private String mac;
}
