package com.cheatbook.TodoApplicationApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheatbook.TodoApplicationApi.model.TodoInfo;

public interface TodoInfoRepository extends JpaRepository<TodoInfo, Long> {
}
