package org.yupi.yuagent.app;

import cn.hutool.core.lang.UUID;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoveAppTest {
    @Resource LoveApp loveApp;

    @Test
    void testDoChat() {
       String chaId= UUID.randomUUID().toString();
       //第一轮测试
       String message="你好,我叫Leon";
       String answer= loveApp.doChat(message,chaId);
       //第二轮测试
        message="我的初恋是Ada";
        answer= loveApp.doChat(message,chaId);
//        Assertions.assertNotNull( answer);
        //第三轮测试
        message="我的初恋叫什么来着？回复我名字";
        answer= loveApp.doChat(message,chaId);
//        Assertions.assertNotNull( answer);

    }

    @Test
    void doChatWithReport() {
        String chaId= UUID.randomUUID().toString();
        String message="你好,我叫Leon,我想在大学找到一个女朋友，应该怎么做？";
        LoveApp.LoveReport loveReport= loveApp.doChatWithReport(message,chaId);
        Assertions.assertNotNull( loveReport);
    }
}
