package com.bookmanage.boot.controller.utils;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class R {
    private boolean flag;
    private Object data;

    public R(boolean flag) {
        this.flag = flag;
    }

    public R(boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }

}
