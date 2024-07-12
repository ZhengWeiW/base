package zcc.base;


public class Client {


    public static void main(String[] args) {

        //创建责任链
        GroupLeader groupLeader = new GroupLeader();
        Manage manage = new Manage();
        GeneralManager generalManager = new GeneralManager();

        //设置责任链关系
        groupLeader.setHandleRequest(manage);

        manage.setHandleRequest(generalManager);


        //发起采购请求
        LeaveRequest request1 = new LeaveRequest(1600);
        LeaveRequest request2 = new LeaveRequest(3800);
        LeaveRequest request3 = new LeaveRequest(6200);

        //处理采购请求
        System.out.println("------采购金额为1600的审核流程情况------");
        //groupLeader.handleLeaveRequest(request1);
        System.out.println("------采购金额为3800的审核流程情况------");
        //groupLeader.handleLeaveRequest(request2);
        System.out.println("------采购金额为6200的审核流程情况------");
        groupLeader.handleLeaveRequest(request3);


    }
}
