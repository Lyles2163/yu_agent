package org.yupi.yuagent.demo.invoke;

import com.aliyun.ecs20140526.Client;
import com.aliyun.ecs20140526.models.DescribeInstanceTypeFamiliesRequest;
import com.aliyun.ecs20140526.models.DescribeInstanceTypeFamiliesResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import org.yupi.yuagent.demo.invoke.testKey;

public class Sample {
    public static void main(String[] args) {
        try {
            Config config = new Config()
                    .setAccessKeyId(testKey.ACCESS_KEY_ID)
                    .setAccessKeySecret(testKey.ACCESS_KEY_SECRET);
            config.endpoint = "ecs-cn-hangzhou.aliyuncs.com";
            Client client = new Client(config);
            DescribeInstanceTypeFamiliesRequest describeInstanceTypeFamiliesRequest = new DescribeInstanceTypeFamiliesRequest();
            describeInstanceTypeFamiliesRequest.setRegionId("cn-hangzhou");
            DescribeInstanceTypeFamiliesResponse describeInstanceTypeFamiliesResponse = client.describeInstanceTypeFamilies(describeInstanceTypeFamiliesRequest);
        } catch (TeaException teaException) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 打印错误码
            System.out.println(teaException.getCode());
            // 打印错误信息，错误信息中包含 RequestId
            System.out.println(teaException.getMessage());
            // 打印服务端返回的具体错误内容
            System.out.println(teaException.getData());
        } catch (Exception e) {
            TeaException error = new TeaException(e.getMessage(), e);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData() != null ? error.getData().get("Recommend") : null);
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
    }
}
              