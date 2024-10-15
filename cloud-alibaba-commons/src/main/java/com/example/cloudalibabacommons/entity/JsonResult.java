package com.example.cloudalibabacommons.entity;/**
 * @Author:zhoayu
 * @Date:2024/9/24 12:58
 * @Description:com.example.cloudalibabacommons.entity
 * @version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName JsonResult
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/9/24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
    private Integer code;
    private T data;
}

 