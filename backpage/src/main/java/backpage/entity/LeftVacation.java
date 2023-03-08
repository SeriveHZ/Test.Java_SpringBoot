package backpage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("left_vacation")
public class LeftVacation {

    @TableId(type = IdType.AUTO)
    private long leftId;

    private long empId;

    private Integer leftYear;

    private Integer leftHunJia;

    private Integer leftChanJian;

    private Integer leftChanJia;

    private Integer leftBuRu;

    private Integer leftPeiChan;

    public long getLeftId() {
        return leftId;
    }

    public void setLeftId(long leftId) {
        this.leftId = leftId;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public Integer getLeftYear() {
        return leftYear;
    }

    public void setLeftYear(Integer leftYear) {
        this.leftYear = leftYear;
    }

    public Integer getLeftHunJia() {
        return leftHunJia;
    }

    public void setLeftHunJia(Integer leftHunJia) {
        this.leftHunJia = leftHunJia;
    }

    public Integer getLeftChanJian() {
        return leftChanJian;
    }

    public void setLeftChanJian(Integer leftChanJian) {
        this.leftChanJian = leftChanJian;
    }

    public Integer getLeftChanJia() {
        return leftChanJia;
    }

    public void setLeftChanJia(Integer leftChanJia) {
        this.leftChanJia = leftChanJia;
    }

    public Integer getLeftBuRu() {
        return leftBuRu;
    }

    public void setLeftBuRu(Integer leftBuRu) {
        this.leftBuRu = leftBuRu;
    }

    public Integer getLeftPeiChan() {
        return leftPeiChan;
    }

    public void setLeftPeiChan(Integer leftPeiChan) {
        this.leftPeiChan = leftPeiChan;
    }
}
