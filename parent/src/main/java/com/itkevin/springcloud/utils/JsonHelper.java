package com.itkevin.springcloud.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class JsonHelper {
	
	private static final ObjectMapper objectMapper;
	private static XmlMapper xmlMapper = new XmlMapper();
	
	static {
		objectMapper = new ObjectMapper();
        //去掉默认的时间戳格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //设置为中国上海时区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        //设置输入:禁止把POJO中值为null的字段映射到json字符串中
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        //空值不序列化
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        //反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //序列化时，日期的统一格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //单引号处理
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
       //objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true); 
	}
	
	public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return null;
    }
	
	public static <T> String toJson(T entity) {
        try {
            return objectMapper.writeValueAsString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> toMap(String json) {
		if(json == null || json.length() == 0) return new HashMap<K, V>();
		
		try {
			return objectMapper.readValue(json, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new HashMap<K, V>();
	}
	
	public static <K, V> String toJson(Map<K, V> obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@SuppressWarnings("rawtypes")
	public static <T> T toObject(Map map, Class<T> clazz) {
		return objectMapper.convertValue(map, clazz);
	}
	
	public static <T> List<T> toList(String jsonArrayStr, Class<T> clazz) {
		List<T> result = new ArrayList<T>();
		try {
			List<Map<String, Object>> list = objectMapper.readValue(jsonArrayStr,new TypeReference<List<T>>() {});
			
			for (Map<String, Object> map : list) {
	            result.add(toObject(map, clazz));
	        }
			
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static String xml2json(String xml){
		StringWriter w = new StringWriter();
		JsonParser jp = null;
		JsonGenerator jg = null;
		try {
			jp = xmlMapper.getFactory().createParser(xml);
			jg = objectMapper.getFactory().createGenerator(w);
			while (jp.nextToken() != null) {
				jg.copyCurrentEvent(jp);
			}
			jp.close();
			jg.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(jp != null){
					jp.close();
				}
				if(jg != null){
					jg.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return w.toString();
	}

}
