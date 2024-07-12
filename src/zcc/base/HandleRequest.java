package zcc.base;

public abstract class HandleRequest {

    //声明上级领导
    public HandleRequest nextHandle;

    //设置上级领导对象
    public void  setHandleRequest(HandleRequest nextHandle) {
        this.nextHandle = nextHandle;
    }

    public HandleRequest getNextHandle() {
        return nextHandle;
    }

    //提交采购请求
    public abstract void handleLeaveRequest(LeaveRequest leaveRequest);
}

