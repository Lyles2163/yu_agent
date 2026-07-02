package org.yupi.yuagent.chatmemory;

import com.esotericsoftware.kryo.Kryo;
import org.objenesis.strategy.StdInstantiatorStrategy;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import java.io.File;
import java.util.List;

public class FileBaseChatMemory implements ChatMemory {

    private final String filePath;


    private static final Kryo kryo = new Kryo();

    static {
        kryo.setRegistrationRequired(false);
        // 设置实例化策略
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
    }

    // 指定文件路径
    public FileBaseChatMemory(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Override
    public void add(String conversationId, Message message) {
        ChatMemory.super.add(conversationId, message);
    }

    @Override
    public void add(String conversationId, List<Message> messages) {

    }

    @Override
    public List<Message> get(String conversationId) {
        return null;
    }

    @Override
    public void clear(String conversationId) {

    }
    /*
    * 获取会话文件
    * */
    private File getConversationFile(String conversationId) {
        return new File(filePath, conversationId + ".kryo");
    }
}
