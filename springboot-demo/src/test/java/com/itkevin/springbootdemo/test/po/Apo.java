package com.itkevin.springbootdemo.test.po;

/**
 * @projectName: kevin-springboot
 * @className: Apo
 * @description: TODO push前删除这个TODO,并添加对应注释,如果liangxuekai忘了,拉出去弹小丁丁
 * @author: liangxuekai
 * @createDate: 2019-07-12 14:01
 * @updateUser: liangxuekai
 * @updateDate: 2019-07-12 14:01
 * @updateRemark: 修改内容
 * @version: 1.0
 */
public class Apo {
    public Apo() {
    }

    public Apo(Bpo bpo) {
        this.bpo = bpo;
    }

    private Bpo bpo;

    public Bpo getBpo() {
        return bpo;
    }

    public void setBpo(Bpo bpo) {
        this.bpo = bpo;
    }
}
