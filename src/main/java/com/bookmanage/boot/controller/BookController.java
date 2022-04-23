package com.bookmanage.boot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bookmanage.boot.controller.utils.R;
import com.bookmanage.boot.pojo.Book;
import com.bookmanage.boot.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//Restful Style
@Slf4j
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bkService;

    /**
     * select all entities
     * @return
     */
    @GetMapping
    public R getAll(){
        return new R(true,bkService.list());
    }

    /**
     * select one by its id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bkService.getById(id));
    }

    /**
     * add function
     * @param book
     * @return
     */
    @PostMapping
    public R add(@RequestBody Book book){
        return new R(bkService.save(book));
    }

    /**
     * delete an entity by its id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public R del(@PathVariable Integer id){
        return new R(bkService.removeById(id));
    }

    /**
     * update a book
     * @param book
     * @return
     */
    @PutMapping
    public R updateById(@RequestBody Book book){
        return new R(bkService.updateById(book));
    }

    /**
     * 分页功能
     * @param current
     * @param size
     * @return
     */
    @GetMapping("{current}/{size}")
    public R selectByPage(@PathVariable Integer current,@PathVariable Integer size){
        log.warn(":::::????????????");
        log.warn(":::::????????????");
        IPage<Book> page = bkService.selectByPage(current,size);
        //解决最后一页的最后一个数据被删除时，页面依旧停留在本页的bug
        if(current > page.getPages()){
            page = bkService.selectByPage((int) page.getPages(),size);
        }
        return new R(true,page);
    }

    @GetMapping("/conditions/{current}/{size}")
    public R selectByConditions(@PathVariable Integer current,@PathVariable Integer size,Book book){
        IPage<Book> page = bkService.selectByConditions(current,size,book);
        //解决最后一页的最后一个数据被删除时，页面依旧停留在本页的bug
        if(current > page.getPages()){
            page = bkService.selectByConditions((int) page.getPages(),size,book);
        }
        return new R(true,page);
    }
}
