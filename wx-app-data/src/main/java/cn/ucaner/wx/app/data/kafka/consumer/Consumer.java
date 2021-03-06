package cn.ucaner.wx.app.data.kafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @ClassName：Consumer
 * @Description： <p> Consumer  </p>
 * @Author： - Jason
 * @CreatTime：2019/3/8 - 17:35
 * @Modify By：
 * @ModifyTime： 2019/3/8
 * @Modify marker：
 * @version V1.0
*/
@Component
public class Consumer {

    /**
     * 监听订阅主题
     * @param record  返回消息里面的记录
     */
    @KafkaListener(topics = {"DEMO"})
    public void listen(ConsumerRecord<?, ?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("Record IS :"+record);
            System.out.println("MEAASGE IS :"+message);
        }
    }
}
