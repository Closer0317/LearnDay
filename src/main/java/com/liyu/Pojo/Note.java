package com.liyu.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private String id;
    private String userId;
    private String title;
    private String subTitle;
    private String content;
    private String coverImage;
    private String createTime;
    private String updateTime;
}
