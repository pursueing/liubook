package com.classbooking.web.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo implements Serializable {

    private String studentName;
    private String bookTime;
    private String studentEmail;
    private String commentTime;
    private String comments;
    private Integer commentStar;
    private Integer classId;
    private String teacherEmail;
    private Integer bookId;

    @Override
    public String toString() {
        return "BookInfo{" +
                "studentName='" + studentName + '\'' +
                ", bookTime='" + bookTime + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", comments='" + comments + '\'' +
                ", commentStar=" + commentStar +
                ", classId=" + classId +
                ", teacherEmail='" + teacherEmail + '\'' +
                '}';
    }
}
