package com.classbooking.web.service;

import com.classbooking.web.domain.BookInfo;
import com.classbooking.web.domain.CommentInfo;

import java.util.List;

public interface BookService {

    //List<BookInfo> getComment(Integer classId);

    List<BookInfo> getBookInfo(Integer classId);

    List<BookInfo> getComments(Integer classId);

    List<BookInfo> getCommentsByName(String className);

    boolean addBook(BookInfo bookInfo,String classStartTime,String className);

    boolean comment(Integer bookId,Integer commentStar,String comments);

    boolean cancelBook(Integer bookId);

    boolean checkTime(Integer classId);

    boolean checkCommentTime(Integer classId);

    List<CommentInfo> getBooksByEmail(String studentEmail);

    boolean HasComment(Integer classId);

    boolean checkNums(String classStartTime,String className);
}
