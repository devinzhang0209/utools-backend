package com.utools.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.utools.backend.util.QrCodeUtil;
import com.utools.backend.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Devin Zhang
 * @className QrCodeController
 * @description TODO
 * @date 2019/7/17 20:50
 */

public class QrCodeController {

    @RequestMapping(value = "/getShareQrCode", method = RequestMethod.POST)
    @ResponseBody
    public String generateQrCode(String content) {
        try {
            String qrCodeContent = QrCodeUtil.generateQRcodeBase64(content);
            JSONObject json = new JSONObject();
            json.put("base64Image", qrCodeContent);
            return Result.getSuccResult(json);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.getErrorResult(e);
        }
    }
}
