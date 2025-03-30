package com.bistu.exr.controller;

import com.bistu.exr.resultinfo.ResultInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")

public class ArticleController {
    @GetMapping("/list")
    public ResultInfo<String> list(){
        return ResultInfo.success("所有的文章数据...");
    }
}
