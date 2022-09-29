package cn.fengchaolee.springboot.learn.model;

import com.alibaba.fastjson.JSONObject;

/**
 * 操作消息提醒
 */
public class ResultJSON extends JSONObject {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 状态类型
     */
    public enum Type {
        /**
         * 成功
         */
        SUCCESS(200),
        /**
         * 错误
         */
        ERROR(500);


        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    /**
     * 初始化一个新创建的 JSONResult 对象，使其表示一个空消息。
     */
    public ResultJSON() {
    }

    /**
     * 初始化一个新创建的 JSONResult 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     */
    public ResultJSON(Type type, String msg) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    public ResultJSON(int type, String msg) {
        super.put(CODE_TAG, type);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 JSONResult 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     * @param data 数据对象
     */
    public ResultJSON(Type type, String msg, Object data) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        if (null != data) {
            super.put(DATA_TAG, data);
        }
    }

    public ResultJSON(int type, String msg, Object data) {
        super.put(CODE_TAG, type);
        super.put(MSG_TAG, msg);
        if (null != data) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResultJSON success() {
        return ResultJSON.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static ResultJSON success(Object data) {
        return ResultJSON.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResultJSON success(String msg) {
        return ResultJSON.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResultJSON success(String msg, Object data) {
        return new ResultJSON(Type.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static ResultJSON error() {
        return ResultJSON.error("服务器错误");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResultJSON error(String msg) {
        return ResultJSON.error(msg, null);
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static ResultJSON error(Object data) {
        return ResultJSON.error("服务器错误", data);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResultJSON error(String msg, Object data) {
        return new ResultJSON(Type.ERROR, msg, data);
    }
}
