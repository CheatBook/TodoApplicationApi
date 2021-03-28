package com.cheatbook.TodoApplicationApi.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cheatbook.TodoApplicationApi.model.TodoInfo;
import com.cheatbook.TodoApplicationApi.repository.TodoInfoRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoApiController {

    private final TodoInfoRepository repository;

    /**
     * 一覧画面表示
     * 
     * @param model
     * @return
     */
    @GetMapping("/list")
    public List<TodoInfo> showList(Model model) {
        return repository.findAll();
    }

    /**
     * 新規登録処理
     * 
     * @param todoInfo
     * @param result
     * @return
     */
    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@RequestBody TodoInfo todoInfo) {
        todoInfo.setRegistrationTime(LocalDateTime.now());
        repository.save(todoInfo);
    }

    /**
     * 編集画面表示
     * 
     * @param taskId
     * @param model
     * @return
     */
    @PutMapping("/edit/{taskId}")
    public TodoInfo editData(@PathVariable Long taskId) {
        return repository.findById(taskId).get();
    }

    /**
     * 削除処理
     * 
     * @param taskId
     * @return
     */
    @DeleteMapping(path = "{taskId}")
    public void deleteData(@PathVariable Long taskId) {
        repository.deleteById(taskId);
    }

}
