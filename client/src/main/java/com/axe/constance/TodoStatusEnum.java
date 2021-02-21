package com.axe.constance;

public enum TodoStatusEnum {
    /**
     * 待完成
     * 完成
     * */
    StatusTodo(1),
    StatusFinish(2),
    ;
    int status;

    TodoStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
