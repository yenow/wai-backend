//package com.wai.domain.notice;
//
//import com.wai.domain.post.Post;
//import com.wai.domain.reply.Reply;
//import com.wai.domain.user.User;
//import lombok.*;
//
//import javax.annotation.Nullable;
//import javax.persistence.*;
//
//@Getter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class Notice {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long noticeId;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "recipient_user_id")
//    private User recipient;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "giver_user_id")
//    private User giver;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "target_post_id")
//    private Post targetPost;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "target_reply_id")
//    private Reply targetReply;
//
//    @Column(length = 4000)
//    private String content;
//    @Column
//    private Boolean isRead;
//}
