package com.springproject.danhsachkhuyenmai.model;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PromotionDto {
    @NotEmpty(message = "Tiêu đề là bắt buộc")
    private String title;

    @NotNull(message = "Thời gian bắt đầu là bắt buộc")
    @FutureOrPresent(message = "Thời gian bắt đầu phải ở hiện tại hoặc tương lai")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date startTime;

    @NotNull(message = "Thời gian kết thúc là bắt buộc")
    @Future(message = "Thời điểm kết thúc phải ở trong tương lai")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endTime;

    @Min(value = 0, message = "Giảm giá không được nhỏ hơn 0")
    private int discountLevel;

    @Size(min = 10, message = "Chi tiết phải có ít nhất 10 ký tự")
    @Size(max = 2000, message = "Chi tiết không thể vượt quá 2000 ký tự")
    private String details;

    public @NotEmpty(message = "The title is required") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "The title is required") String title) {
        this.title = title;
    }

    public @NotNull(message = "The start time is required") @FutureOrPresent(message = "The start time must be in the present or future") Date getStartTime() {
        return startTime;
    }

    public void setStartTime(@NotNull(message = "The start time is required") @FutureOrPresent(message = "The start time must be in the present or future") Date startTime) {
        this.startTime = startTime;
    }

    public @NotNull(message = "The end time is required") @Future(message = "The end time must be in the future") Date getEndTime() {
        return endTime;
    }

    public void setEndTime(@NotNull(message = "The end time is required") @Future(message = "The end time must be in the future") Date endTime) {
        this.endTime = endTime;
    }

    public @Min(value = 0, message = "The discount level should not be less than 0") int getDiscountLevel() {
        return discountLevel;
    }

    public void setDiscountLevel(@Min(value = 0, message = "The discount level should not be less than 0") int discountLevel) {
        this.discountLevel = discountLevel;
    }

    public @Size(min = 10, message = "The details should be at least 10 characters") @Size(max = 2000, message = "The details cannot exceed 2000 characters") String getDetails() {
        return details;
    }

    public void setDetails(@Size(min = 10, message = "The details should be at least 10 characters") @Size(max = 2000, message = "The details cannot exceed 2000 characters") String details) {
        this.details = details;
    }
}
