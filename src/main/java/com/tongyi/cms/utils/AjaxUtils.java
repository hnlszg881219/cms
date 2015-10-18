
package com.tongyi.cms.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.log4j.Logger;

/**
 * <p>ClassName: AjaxUtils</p>
 * <p>Description: AJAX相关处理工具类,主要包括各种AJAX输出渲染页面</p>
 * <p>Author: vincent</p>
 * <p>Date: 2014-11-26</p>
 */
public class AjaxUtils {

    /**
     * <p>
     * Field STATUS: 状态
     * </p>
     */
    public static final String STATUS = "status";
    /**
     * <p>
     * Field WARN: 警告
     * </p>
     */
    public static final String WARN = "warn";
    /**
     * <p>
     * Field SUCCESS: 成功
     * </p>
     */
    public static final String SUCCESS = "success";
    /**
     * <p>
     * Field ERROR: 错误
     * </p>
     */
    public static final String ERROR = "error";
    /**
     * <p>
     * Field MESSAGE: 消息
     * </p>
     */
    public static final String MESSAGE = "message";
    /**
     * <p>
     * Field CONTENT: 内容
     * </p>
     */
    public static final String CONTENT = "content";

    /**
     * <p>Field logger: 日志对象</p>
     */
    protected static Logger logger = Logger.getLogger(AjaxUtils.class);
    /**
     * <p>
     * Description: AJAX输出，返回null
     * </p>
     * 
     * @param response HttpServletResponse对象
     * @param content 内容
     * @param type contentType
     * @return null
     */
    public static String ajax(HttpServletResponse response, String content, String type) {
        try {
            response.setContentType(type + ";charset=UTF-8");
            response.setHeader("pragma", "no-cache");
            response.setHeader("cache-control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            logger.error("AJAX响应错误", e);
        }
        return null;
    }

    /**
     * <p>Description: AJAX输出文本，返回null</p>
     * @param response HttpServletResponse对象
     * @param text 文本内容
     * @return null
     */
    public static String ajaxText(HttpServletResponse response, String text) {
        return ajax(response, text, "text/plain");
    }

    /**
     * <p>Description: AJAX输出HTML，返回null</p>
     * @param response HttpServletResponse对象
     * @param html html内容
     * @return null
     */
    public static String ajaxHtml(HttpServletResponse response, String html) {
        return ajax(response, html, "text/html");
    }

    /**
     * <p>Description: AJAX输出XML，返回null</p>
     * @param response HttpServletResponse对象
     * @param xml xml内容
     * @return null
     */
    public static String ajaxXml(HttpServletResponse response, String xml) {
        return ajax(response, xml, "text/xml");
    }

    /**
     * <p>Description: 根据字符串输出JSON，返回null</p>
     * @param response HttpServletResponse对象
     * @param jsonString json�?
     * @return null
     */
    public static String ajaxJson(HttpServletResponse response, String jsonString) {
        return ajax(response, jsonString, "text/html");
    }

    /**
     * <p>Description: 根据Map输出JSON，返回null</p>
     * @param response HttpServletResponse对象
     * @param jsonMap json map对象
     * @return null
     */
    public static String ajaxJson(HttpServletResponse response, Map<String, String> jsonMap) {
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return ajax(response, jsonObject.toString(), "text/html");
    }

    /**
     * <p>Description: 输出JSON警告消息，返回null</p>
     * @param response HttpServletResponse对象
     * @param message 信息字符串
     * @return null
     */
    public static String ajaxJsonWarnMessage(HttpServletResponse response, String message) {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put(STATUS, WARN);
        jsonMap.put(MESSAGE, message);
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return ajax(response, jsonObject.toString(), "text/html");
    }

    /**
     * <p>Description: 输出JSON成功消息，返回null</p>
     * @param response HttpServletResponse对象
     * @param message 信息字符串
     * @return null
     */
    public static String ajaxJsonSuccessMessage(HttpServletResponse response, String message) {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put(STATUS, SUCCESS);
        jsonMap.put(MESSAGE, message);
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return ajax(response, jsonObject.toString(), "text/html");
    }

    /**
     * <p>Description: 返回JSON数据，返回null</p>
     * @param response HttpServletResponse对象
     * @param data 数据对象
     * @param config JsonConfig配置对象
     * @return null
     */
    public static String ajaxJson(HttpServletResponse response, Object data, JsonConfig config) {
        JsonConfig newConfig = config;
        if (newConfig == null) {
            newConfig = new JsonConfig();
        }
        newConfig.registerJsonValueProcessor(Boolean.class, new JsonValueProcessor() {
            public Object processArrayValue(Object v, JsonConfig config) {
                return null;
            }

            public Object processObjectValue(String k, Object v, JsonConfig config) {
                return v.toString();
            }
        });
        JSONObject jsonObject = JSONObject.fromObject(data, newConfig);
        return ajax(response, jsonObject.toString(), "text/html");
    }

    /**
     * <p>Description: 返回JSON数据，返回null</p>
     * @param response HttpServletResponse对象
     * @param data 数据对象
     * @return null
     */
    public static String ajaxJsonData(HttpServletResponse response, Object data) {
        String result = JSONObject.fromObject(data).toString();
        return ajax(response, result, "text/html");
    }

    /**
     * <p>Description: 返回JSON array数据，返回null</p>
     * @param response HttpServletResponse对象
     * @param data 数据对象
     * @return null
     */
    public static String ajaxJsonArray(HttpServletResponse response, Object data) {
        String result = JSONArray.fromObject(data).toString();
        return ajax(response, result, "text/html");
    }

    /**
     * <p>Description: 返回JSON数据，返回null</p>
     * @param response HttpServletResponse对象
     * @param jsonMap json map
     * @return null
     */
    public static String ajaxJsonSuccess(HttpServletResponse response, Map<String, Object> jsonMap) {
        jsonMap.put(STATUS, SUCCESS);
        JsonConfig jsonConfig = new JsonConfig();  
        JSONObject jsonObject = JSONObject.fromObject(jsonMap,jsonConfig);
        return ajax(response, jsonObject.toString(), "text/html");
    }

    /**
     * <p>Description: 返回JSON数据，返回null</p>
     * @param response HttpServletResponse对象
     * @param data 数据对象
     * @return null
     */
    public static String ajaxJsonSuccess(HttpServletResponse response, Object data) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(STATUS, SUCCESS);
        jsonMap.put("data", data);
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return ajax(response, jsonObject.toString(), "text/html");
    }

    /**
     * <p>Description: 返回JSON成功数据，返回null</p>
     * @param response HttpServletResponse对象
     * @param data 数据对象
     * @param config JsonConfig配置对象
     * @return null
     */
    public static String ajaxJsonSuccess(HttpServletResponse response, Object data, JsonConfig config) {
        return ajaxJsonSuccessMessage(response, data, config, null);
    }
    /**
     * <p>Description: 返回JSON成功数据，返回null</p>
     * @param response HttpServletResponse对象
     * @param data 数据对象
     * @param config JsonConfig配置对象
     * @param message 信息字符�?
     * @return null
     */
    public static String ajaxJsonSuccessMessage(HttpServletResponse response, Object data, JsonConfig config,
            String message) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(STATUS, SUCCESS);
        jsonMap.put(MESSAGE, message);
        jsonMap.put("data", data);
        JsonConfig newConfig = config;
        if (newConfig == null) {
            newConfig = new JsonConfig();
        }
        newConfig.registerJsonValueProcessor(Boolean.class, new JsonValueProcessor() {
            
        	public Object processArrayValue(Object v, JsonConfig config) {
                return null;
            }

            public Object processObjectValue(String k, Object v, JsonConfig config) {
                return v.toString();
            }
        });
        JSONObject jsonObject = JSONObject.fromObject(jsonMap, newConfig);
        return ajax(response, jsonObject.toString(), "text/html");
    }

    /**
     * <p>Description: 输出JSON错误消息，返回null</p>
     * @param response HttpServletResponse对象
     * @param message 信息字符串
     * @return null
     */
    public static String ajaxJsonErrorMessage(HttpServletResponse response, String message) {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put(STATUS, ERROR);
        jsonMap.put(MESSAGE, message);
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return ajax(response, jsonObject.toString(), "text/html");
    }

    /**
     * <p>Description: 设置页面不缓存/p>
     * @param response HttpServletResponse对象
     */
    public static void setResponseNoCache(HttpServletResponse response) {
        response.setHeader("progma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
    }
    
}
