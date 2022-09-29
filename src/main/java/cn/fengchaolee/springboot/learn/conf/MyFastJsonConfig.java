package cn.fengchaolee.springboot.learn.conf;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * MyFastJsonConfig
 *  fastjson配置  参考https://www.jianshu.com/p/4ff964d3d7fc
 * @author fengchaolee
 * @date : 2022/9/29
 */
@Configuration
public class MyFastJsonConfig {

    @Bean
    FastJsonHttpMessageConverter getFastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig jsonConfig = new FastJsonConfig();
        jsonConfig.setCharset(StandardCharsets.UTF_8);
        jsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonConfig.setSerializerFeatures(
                //输出类名
                // SerializerFeature.WriteClassName,
                //输出map中value为null的数据
                SerializerFeature.WriteMapNullValue,
                //json格式化
                SerializerFeature.PrettyFormat,
                //输出空list为[]，而不是null
                SerializerFeature.WriteNullListAsEmpty,
                //输出空string为""，而不是null
                SerializerFeature.WriteNullStringAsEmpty
        );
        converter.setFastJsonConfig(jsonConfig);
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        return converter;
    }
}
