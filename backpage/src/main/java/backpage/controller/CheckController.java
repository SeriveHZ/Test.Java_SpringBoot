package backpage.controller;

import backpage.entity.PlatPunch;
import backpage.service.CheckInOutService;
import backpage.entity.LeftVacation;
import backpage.entity.vo.QueryCheckRecordResp;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckController {

    @Autowired
    private CheckInOutService checkInOutService;

    @PostMapping("/checkInOrOut/{empId}/{signType}")
    public boolean checkInOrOut(@PathVariable("empId") long empId ,@PathVariable("signType")  int signType,PlatPunch platPunch){
        if(!getPunch(platPunch)){
            return false;
        }
        return checkInOutService.signInOrOut(empId , signType);
    }

    @GetMapping("/queryAllRecords")
    public List<QueryCheckRecordResp> queryAllSignRecord(){
        return checkInOutService.queryAllSignRecord();
    }

    @GetMapping("/queryRecordsByActOrType")
    public List<QueryCheckRecordResp> queryRecordsByActOrType(String account, Integer type){
        return checkInOutService.querySignRecordByAccountOrType(account , type);
    }

    @GetMapping("/getLeftTimeById/{id}")
    public LeftVacation getLeftTimeById(@PathVariable("id") long empId){
        return checkInOutService.queryLeftTimeByEmpId(empId);
    }


    public boolean getPunch(PlatPunch platPunch){
        //1、设置目的地经度
        String longitudeS = "106.235321";
        //设置目的纬度
        String latitudeS = "37.432579";
        // 2、由前端传过来的用户所在位置 经纬度
        String longitudeT = platPunch.getLongitude();
        String latitudeT = platPunch.getLatitude();
        // 3、对比
        GlobalCoordinates source = new GlobalCoordinates(Double.parseDouble(latitudeS),Double.parseDouble(longitudeS));
        GlobalCoordinates target = new GlobalCoordinates(Double.parseDouble(latitudeT),Double.parseDouble(longitudeT));
        //这是两种坐标系计算方法，这是第一种坐标系计算方法（我们用的这种）
        double geoCurve = getDistanceMeter(source, target, Ellipsoid.Sphere);
        //这是两种坐标系计算方法，这是第二种坐标系计算方法
        double geoCurve2 = getDistanceMeter(source, target, Ellipsoid.WGS84);
        System.out.println(geoCurve+"----------"+geoCurve2);
        //如果用户和目的地位置想吃2千米，在不能打卡；
        if(geoCurve > 2000){
            return false;
            //反之，可以打卡
        }else {
            return true;
        }
    }/* 经纬度计算工具类*/
    public static double getDistanceMeter(GlobalCoordinates gpsFrom, GlobalCoordinates gpsTo, Ellipsoid ellipsoid)
    {
        //创建GeodeticCalculator，调用计算方法，传入坐标系、经纬度用于计算距离
        GeodeticCurve geoCurve = new GeodeticCalculator().calculateGeodeticCurve(ellipsoid, gpsFrom, gpsTo);
        return geoCurve.getEllipsoidalDistance();
    }


}
