package org.yupi.yuagent.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 应用配置文件映射
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "")
public class AppConfig {

    private AliababaCloud alibabacloud;
    private DashScope dashscope;

    @Data
    public static class AliababaCloud {
        private String accessKeyId;
        private String accessKeySecret;
    }

    @Data
    public static class DashScope {
        private String baseUrl;
        private String apiKey;
    }
}