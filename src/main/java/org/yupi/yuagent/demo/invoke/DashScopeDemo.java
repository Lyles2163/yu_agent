package org.yupi.yuagent.demo.invoke;

import java.util.Arrays;
import java.util.Collections;
import com.alibaba.dashscope.aigc.multimodalconversation.MultiModalConversation;
import com.alibaba.dashscope.aigc.multimodalconversation.MultiModalConversationParam;
import com.alibaba.dashscope.aigc.multimodalconversation.MultiModalConversationResult;
import com.alibaba.dashscope.common.MultiModalMessage;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.exception.UploadFileException;
import com.alibaba.dashscope.utils.Constants;

public class DashScopeDemo {

    static {
        Constants.baseHttpApiUrl = testKey.DASHSCOPE_BASE_URL;
    }

    public static String call() throws ApiException, NoApiKeyException, UploadFileException {
        MultiModalConversation conv = new MultiModalConversation();
        MultiModalMessage userMessage = MultiModalMessage.builder()
                .role(Role.USER.getValue())
                .content(Arrays.asList(
//                        Collections.singletonMap("image",
//                                "https://help-static-aliyun-doc.aliyuncs.com/file-manage-files/zh-CN/20241022/emyrja/dog_and_girl.jpeg"),
                        Collections.singletonMap("text", "你好，你是什么模型?")))
                .build();

        MultiModalConversationParam param = MultiModalConversationParam.builder()
                .apiKey(testKey.DASHSCOPE_API_KEY)
                .model("qwen3.6-flash")
                .messages(Arrays.asList(userMessage))
                .build();

        MultiModalConversationResult result = conv.call(param);
        return (String) result.getOutput()
                .getChoices().get(0)
                .getMessage()
                .getContent().get(0)
                .get("text");
    }

    public static void main(String[] args) {
        try {
            String reply = call();
            System.out.println("模型回复: " + reply);
        } catch (Exception e) {
            System.err.println("调用失败: " + e.getMessage());
        }
    }
}