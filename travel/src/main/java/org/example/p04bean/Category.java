package org.example.p04bean;

//类的对象保存一条分类数据
public class Category {
    private Long cid;
    private String cname;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return cid+" "+cname;
    }
}
