package org.yupi.yuagent.demo.invoke;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DashScopeDemoTest {

    @Test
    @DisplayName("应能成功调用 DashScope 多模态 API 并返回非空结果")
    void shouldReturnNonEmptyResponse() throws Exception {
        String response = DashScopeDemo.call();

        assertNotNull(response, "返回内容不应为空");
        assertFalse(response.trim().isEmpty(), "返回内容不应为空字符串");

        System.out.println("DashScope response: " + response);
    }
}