package com.classbooking.web.serviceImp;

import com.classbooking.web.dao.BookDao;
import com.classbooking.web.dao.CourseDao;
import com.classbooking.web.domain.BookInfo;
import com.classbooking.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private CourseDao courseDao;
//    @Override
//    public List<BookInfo> getComment(Integer classId) {
//        return bookDao.getComment(classId);
//    }

    @Override
    public List<BookInfo> getBookInfo(Integer classId) {
        return bookDao.getBookInfo(classId);
    }

    @Override
    public List<BookInfo> getComments(Integer classId) {
        return bookDao.getComments(classId);
    }

    @Override
    public List<BookInfo> getCommentsByName(String className) {
        List<Integer> classIds = courseDao.getClassIdsByName(className);
        List<BookInfo> result = new LinkedList<>();
        classIds.stream().forEach(id->{
            List<BookInfo> temp = bookDao.getComments(id);
            temp.stream().forEach(bookInfo -> {
                if(bookInfo.getCommentTime() !=null && !bookInfo.getCommentTime().equals("")){
                    result.add(bookInfo);
                }
            });
        });
        return result;
    }

    @Override
    public boolean addBook(BookInfo bookInfo,String classStartTime,String className) {
        Integer classId = courseDao.getClassIdByStartTime(classStartTime,className);
        bookInfo.setClassId(classId);
        LocalDateTime localDateTime = LocalDateTime.now();
        String time = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        bookInfo.setBookTime(time);
        //避免重复预约
        if(!bookDao.checkRepeat(bookInfo).isEmpty()){
            return false;
        }
        return bookDao.addBook(bookInfo) ==1;
    }
}
