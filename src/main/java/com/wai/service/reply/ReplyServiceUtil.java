package com.wai.service.reply;

import com.wai.domain.reply.Reply;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ReplyServiceUtil {


    public List<Reply> hierarchyOrderBy(List<Reply> replies) {
        List<Reply> result = new ArrayList<>();
        replies.forEach(reply -> {

            if(reply.getParentReplyId() != null) {

                int maxIndex = 0;
                int index = 0;
                for (Reply r : result) {
                    index++;
                    if (r.getReplyId().equals(reply.getParentReplyId()) ||
                            (r.getParentReplyId() != null && r.getParentReplyId().equals(reply.getParentReplyId()))) {
                        maxIndex = index;
                    }
                }
                result.add(maxIndex, reply);

            } else {
                result.add(reply);
            }
        });
        return result;
    }
}
