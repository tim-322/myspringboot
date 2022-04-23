package com.bookmanage.boot;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bookmanage.boot.mapper.BookMapper;
import com.bookmanage.boot.pojo.Book;
import com.bookmanage.boot.service.BookServiceImpl;
import com.bookmanage.boot.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
//
    @Autowired
    private BookMapper bkMapper;

    @Autowired
    private IBookService bookService;
//    @Test
//    void contextLoads() {
//        System.out.println(bkMapper.selectById(3));
//    }

    @Test
    public void testAdd(){
        Book book = new Book();
        book.setDescription("TEST");
        book.setType("TEST");
        book.setName("TEST");
        System.out.println(bookService.save(book));
    }


    @Test
    public void testPage(){
        IPage<Book> page = bkMapper.selectPage(new Page<Book>(1,5),null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
}
