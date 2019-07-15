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
public class Bpo {

    public Bpo(Cpo cpo) {
        this.cpo = cpo;
    }

    private Cpo cpo;

    public Cpo getCpo() {
        return cpo;
    }

    public void setCpo(Cpo cpo) {
        this.cpo = cpo;
    }
}
