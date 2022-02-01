package com.basic.boardUpgradeProject.service;

import com.basic.boardUpgradeProject.repository.BoardLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BoardLikeService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final BoardLikeRepository boardLikeRepository;
}
