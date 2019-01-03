package com.zoolon.issue.vo.param.ad;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateParam {
    private Integer id;
    @Size(min = 0, max = 20, message = "name 长度必须小于 {min} - {max} 之间")
    private String name;
    @Size(min = 0, max = 20, message = "title1 长度必须小于 {min} - {max} 之间")
    private String title1;
    @Size(min = 0, max = 20, message = "title2 长度必须小于 {min} - {max} 之间")
    private String title2;
    @Size(min = 0, max = 20, message = "title3 长度必须小于 {min} - {max} 之间")
    private String title3;
    @Size(min = 0, max = 200, message = "content1 长度必须小于 {min} - {max} 之间")
    private String content1;
    @Size(min = 0, max = 200, message = "content2 长度必须小于 {min} - {max} 之间")
    private String content2;
    @Size(min = 0, max = 200, message = "video1 长度必须小于 {min} - {max} 之间")
    private String video1;
    @Size(min = 0, max = 200, message = "video2 长度必须小于 {min} - {max} 之间")
    private String video2;
}
