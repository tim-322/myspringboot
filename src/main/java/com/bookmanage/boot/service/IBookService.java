package com.bookmanage.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bookmanage.boot.pojo.Book;

public interface IBookService extends IService<Book> {

    @Override
    boolean save(Book book);

    IPage<Book> selectByPage(Integer current,Integer size);

    IPage<Book> selectByConditions(Integer current,Integer size,Book book);
}
