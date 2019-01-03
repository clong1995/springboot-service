package com.zoolon.issue.vo.param.danger;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateParam {
    private Integer id;
    @Size(min = 0, max = 20, message = "name 长度必须小于 {min} - {max} 之间")
    private String name;
    @Size(min = 0, max = 200, message = "video2 长度必须小于 {min} - {max} 之间")
    private String video;
}
