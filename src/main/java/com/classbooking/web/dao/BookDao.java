package com.classbooking.web.dao;


import com.classbooking.web.domain.BookInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

//    @Select("select student_name, comment_time, comment_star, comments from booking_info where class_id = #{classId}")
//    @Results({
//            @Result(column = "student_name", property = "studentName"),
//            @Result(column = "comment_time", property = "commentTime"),
//            @Result(column = "comment_star", property = "commentStar"),
//            @Result(column = "comments", property = "comments")
//    })
//    List<BookInfo> getComment(@Param("classId") Integer classId);

    @Select("select b.student_email , s.student_name, b.book_time from booking_info b left join student_info s " +
            " on b.student_email = s.student_email where class_id = #{classId}")
    @Results({
            @Result(column = "student_email", property = "studentEmail"),
            @Result(column = "student_name", property = "studentName"),
            @Result(column = "book_time", property = "bookTime")
    })
    List<BookInfo> getBookInfo(@Param("classId") Integer classId);


    @Select("select b.student_email , s.student_name, b.comment_time , b.comment_star , b.comments from booking_info b left join student_info s " +
            " on b.student_email = s.student_email where class_id = #{classId}")
    @Results({
            @Result(column = "student_email", property = "studentEmail"),
            @Result(column = "student_name", property = "studentName"),
            @Result(column = "comment_time", property = "commentTime"),
            @Result(column = "comment_star", property = "commentStar"),
            @Result(column = "comments", property = "comments")
    })
    List<BookInfo> getComments(@Param("classId") Integer classId);

    @Insert("insert into booking_info(student_email,teacher_email,class_id,book_time) values(#{studentEmail},#{teacherEmail},#{classId},#{bookTime}) ")
    Integer addBook(BookInfo bookInfo);

    @Update("update book_info set comments=#{comments},comment_time = #{commentTime},comment_star=#{commentStar} where class_id=#{classId} " +
            " and student_email=#{studentEmail} ")
    Integer addComments(BookInfo bookInfo);

    @Select("select id from booking_info where student_email=#{studentEmail} and teacher_email=#{teacherEmail} and class_id=#{classId}")
    List<Integer> checkRepeat(BookInfo bookInfo);


}
