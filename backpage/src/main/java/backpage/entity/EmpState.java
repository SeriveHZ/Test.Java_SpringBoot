package backpage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("emp_state")
public class EmpState {

    @TableId(type = IdType.AUTO)
    private long stateId;

    @TableField("emp_id")
    private long empId;

    /*
    * 0：下班
    * 1：在班
    * 2：外出
    * 3：假期
    * 4：请假
    * */
    private int state;


    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
