package zcc.base;

public class GeneralManager extends HandleRequest{

    @Override
    public void handleLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getAmount() > 5000) {
            System.out.println("采购流程审核结果：总经理同意批准采购");
            System.out.println("采购流程审核结束");
        } else {
            System.out.println("不同意该采购申请");
        }
    }

}

