package com.utools.backend.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Devin Zhang
 * @className Result
 * @description Json结果返回标准对象
 * @date 2019/7/17 20:05
 */

public class Result {

    private final static int SUCC_STATE = 200;
    private final static int FAIL_STATE = 500;

    private final static int VERIFY_SUCC_CODE = 0;
    private final static int VERIFY_FAIL_CODE = 1;

    private static String getResult(int verifyCode, String msg, Object obj) {
        JSONObject json = new JSONObject();
        json.put("state", SUCC_STATE);
        json.put("msg", "操作成功");

        JSONObject data = new JSONObject();
        data.put("msg", msg);
        data.put("code", verifyCode);
        data.put("obj", obj);
        json.put("data", data);
        return json.toJSONString();
    }

    /**
     * 获取成功的返回值
     *
     * @param obj obj
     * @return String
     */
    public static String getSuccResult(Object obj) {
        return getResult(VERIFY_SUCC_CODE, "操作成功", obj);
    }

    /**
     * 获取校验失败的返回值
     *
     * @param msg msg
     */
    public static String getFailResult(String msg) {
        return getResult(VERIFY_FAIL_CODE, msg, null);
    }

    /**
     * 异常时调用获取返回值
     *
     * @return String
     */
    public static String getErrorResult(Exception e) {
        JSONObject json = new JSONObject();
        json.put("state", FAIL_STATE);
        json.put("msg", "操作失败" + e.getMessage());
        return json.toString();
    }

}
