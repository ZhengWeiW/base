package zcc.base;

public class GroupLeader extends HandleRequest {

    @Override
    public void handleLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getAmount() < 2000) {
            System.out.println("采购流程审核结果：组长同意批准采购");
            System.out.println("采购流程审核结束");
        } else if (nextHandle != null) {
            System.out.println("审核第一步：组长同意批准采购, 等待上级领导审核中...");
            nextHandle.handleLeaveRequest(leaveRequest);
        }
    }

}
