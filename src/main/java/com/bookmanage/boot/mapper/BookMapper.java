package com.bookmanage.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bookmanage.boot.pojo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    @Override
    @Insert("insert into tbl_book(type, name, description) values(#{book.type},#{book.name},#{book.description})")
    int insert(@Param("book") Book book);

}
