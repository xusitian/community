package com.xs.community.entity;

/**
 * 分页相关
 */
public class Page {
    private int current = 1; // 当前页
    private  int limit = 10; //显示上限
    private int rows; //用于计算总页数
    private String path; // 查询路径

    public int getCurrent() {
            return current;
    }

    public void setCurrent(int current) {
        if(current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >= 1 && limit <= 100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getOffset(){
        // current*limit-limit
        return current * limit - limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotal(){
        // rows/limit
        if(rows % limit == 0){
            return rows / limit;
        }else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取显示的起始页码
     * @return
     */
    public int getFrom(){
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取显示的终止页码
     * @return
     */
    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}



