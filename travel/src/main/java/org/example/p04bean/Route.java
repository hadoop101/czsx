package org.example.p04bean;

public class Route {
    private Long rid;//编号
    private String rname;//名称
    private Double price;
    private String introduce;
    private String rdate;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    @Override
    public String toString() {
        return "[" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", price=" + price +
                ", introduce='" + introduce + '\'' +
                ", rdate='" + rdate + '\'' +
                ']';
    }
}
