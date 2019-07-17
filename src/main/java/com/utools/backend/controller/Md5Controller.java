package com.utools.backend.controller;

import com.utools.backend.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Devin Zhang
 * @className Md5Controller
 * @description TODO
 * @date 2019/7/17 20:04
 */

@Controller
@RequestMapping("/api/web/md5")
public class Md5Controller {

    @ResponseBody
    @RequestMapping("/encrypt")
    public String encrypt(String md5Str,int type){
        return Result.getSuccResult(null);
    }
}
