package com.cheatbook.TodoApplicationApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheatbook.TodoApplicationApi.model.TodoStatusInfo;

public interface TodoStatusInfoRepository
        extends JpaRepository<TodoStatusInfo, Long> {
}
