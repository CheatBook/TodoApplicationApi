package com.cheatbook.TodoApplicationApi.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Immutable
public class TodoInfo {
    /** 登録番号 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    /** タスク名 */
    @NotBlank
    private String taskName;

    /** 作業区分(１回のみ、日次、週次、月次) */
    private String workingKubun;

    /** 優先度（1 ～ 5） */
    private int priority;

    /** 登録日時 */
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime registrationTime;

    /** 作業開始予定日時 */
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime workingStartPlanTime;

    /** 作業完了予定日時 */
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime workingCompletePlanTime;

    /** ステータス */
    @ManyToOne
    private TodoStatusInfo todoStatusInfo;

    /** 完了日時 */
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime completeTime;

    /** 備考 */
    private String note;

}
