package com.wai.domain.report;

import com.wai.domain.common.BaseEntity;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import lombok.*;

import javax.persistence.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"post", "reply"})
@Entity
public class Report extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id")
    private Reply reply;

    @Column(length = 100)
    private ReportStatus reportStatus;
    @Column(length = 4000)
    private String reason;
    @Column(length = 4000)
    private String answer;
}