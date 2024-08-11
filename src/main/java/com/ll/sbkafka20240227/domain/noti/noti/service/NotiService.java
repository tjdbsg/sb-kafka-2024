package com.ll.sbkafka20240227.domain.noti.noti.service;

import com.ll.sbkafka20240227.domain.member.member.entity.Member;
import com.ll.sbkafka20240227.domain.member.member.service.MemberService;
import com.ll.sbkafka20240227.domain.noti.noti.entity.Noti;
import com.ll.sbkafka20240227.domain.noti.noti.repository.NotiRepository;
import com.ll.sbkafka20240227.domain.post.post.entity.Post;
import com.ll.sbkafka20240227.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotiService {
    private final MemberService memberService;
    private final PostService postService;
    private final NotiRepository notiRepository;

    @Transactional
    public void postCreated(Post post) {
        Member actor = postService.of(post.getAuthor());

        List<Member> receivers = memberService
                .findAll()
                .stream()
                .filter(member -> !member.equals(actor))
                .toList();

        receivers.forEach(receiver -> {
                    Noti noti = Noti.builder()
                            .actor(actor)
                            .receiver(receiver)
                            .relTypeCode(post.getModelName())
                            .relId(post.getId())
                            .typeCode("POST")
                            .type2Code("CREATED")
                            .readStatus(false)
                            .build();

                    notiRepository.save(noti);
                }
        );
    }
}