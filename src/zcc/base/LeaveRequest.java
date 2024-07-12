package zcc.base;

/** 
* @Description:
* @Param:
* @return:
* @Author: zcc 
* @Date: 17:35 2024/7/12 
*/ 
public class LeaveRequest {

    private double amount;

    public LeaveRequest(double amount) {
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}
