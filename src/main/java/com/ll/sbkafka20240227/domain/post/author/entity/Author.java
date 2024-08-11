package com.ll.sbkafka20240227.domain.post.author.entity;

import com.ll.sbkafka20240227.global.jpa.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Getter
@Setter
@Table(name = "MEMBER")
public class Author extends BaseTime {
    @Column(columnDefinition = "BIGINT default 0")
    @Setter(PRIVATE)
    private long postsCount;
    @Column(name = "nickname")
    private String writer;

    public void increasePostsCount() {
        postsCount++;
    }
}