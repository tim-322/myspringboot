package com.bookmanage.boot.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bookmanage.boot.mapper.BookMapper;
import com.bookmanage.boot.pojo.Book;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bkMapper;

    @Override
    public boolean save(Book book) {
        return bkMapper.insert(book) > 0;
    }

    @Override
    public IPage<Book> selectByPage(Integer current,Integer size){
        IPage<Book> page = new Page<>(current,size);
        return  bkMapper.selectPage(page,null);
    }

    @Override
    public IPage<Book> selectByConditions(Integer current, Integer size, @RequestBody Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //使用 lambda表达式
        //模糊查询
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage<Book> page = new Page<>(current,size);
        return  bkMapper.selectPage(page,lqw);
    }
}
