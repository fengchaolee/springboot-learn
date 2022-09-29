package cn.fengchaolee.springboot.learn.util;

import com.sun.istack.internal.NotNull;
import lombok.NonNull;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description DateTimeUtils
 * @Author lifengchao
 * @Date 2020/7/11
 */
public class DateTimeUtils {

    public static final DateTimeFormatter DATETIMEFORMATTER19 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATETIMEFORMATTER14 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter DATETIMEFORMATTER10 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATETIMEFORMATTER8 = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static void main(String[] args) {
        // System.out.println(getElapsedTimeDesc(5000L,9111115000L));
    }

    public static String date2Str(Date date, DateTimeFormatter dtf){
        LocalDateTime ldt = date2LocalDateTime(date);
        String dateStr = dtf.format(ldt);
        return dateStr;
    }

    public static String long2Str(Long l, DateTimeFormatter dtf){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(l),
                ZoneId.systemDefault());
        return dtf.format(localDateTime);
    }

    public static LocalDate date2LocalDate(Date date){
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime date2LocalDateTime(Date date){
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date localDate2Date(@NonNull LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateTime2Date(@NonNull LocalDateTime localDateTime){
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * @Description 由毫秒数计算耗时，并人性化输出字符串描述
     * @Params startTime 起始毫秒数  endTime 结束毫秒数
     * @Returns
     * @Author lifengchao
     * @Date 2020/7/11
     */
    public static String getElapsedTimeDesc(@NonNull long startTime,@NonNull long endTime){
        String returnStr;
        long elapsedSeconds=(endTime-startTime)/1000;
        long elapsedMinutes,elapseHours,elapseDays;
        long leftSercodes,leftMinuters;
        if (elapsedSeconds>59){
            elapsedMinutes=elapsedSeconds/60;
            if (elapsedMinutes>59){
                elapseHours=elapsedMinutes/60;
                if (elapseHours>23){
                    elapseDays=elapseHours/24;
                    elapseHours%=24;
                    leftSercodes=elapsedSeconds-elapseDays*24*60*60-elapseHours*60*60;
                    if (leftSercodes>59){
                        leftMinuters=leftSercodes/60;
                        leftSercodes%=60;
                        returnStr="，耗费"+elapseDays+"天"+elapseHours+"时"+leftMinuters+"分"+leftSercodes+"秒";
                    }else{
                        returnStr="，耗费"+elapseDays+"天"+elapseHours+"时0分"+leftSercodes+"秒";
                    }
                }else {
                    elapsedMinutes%=60;
                    leftSercodes=elapsedSeconds-elapseHours*60*60-elapsedMinutes*60;
                    returnStr="，耗费"+elapseHours+"时"+elapsedMinutes+"分"+leftSercodes+"秒";
                }
            }else {
                elapsedSeconds%=60;
                returnStr="，耗费"+elapsedMinutes+"分"+elapsedSeconds+"秒";
            }
        }else {
            returnStr="，耗费"+elapsedSeconds+"秒";
        }
        return returnStr;
    }
}