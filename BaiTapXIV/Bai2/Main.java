package BaiTapXIV.Bai2;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        //Viết chương trình để lấy ngày hiện tại của hệ thống và các nơi bao gồm :
        // Asia/Tokyo, Australia/Sydney ,America/Sao_Paulo
        ZoneId TIMEZONE_ET = ZoneId.of("America/New_York");
        LocalDate systemDay = LocalDate.now(TIMEZONE_ET);
        System.out.println(systemDay);
        //Viết chương trình để lấy thời gian hiện tại (giờ phút giây).
        LocalTime systemTime = LocalTime.now();
        System.out.println(systemTime);
//        //Viết chương trình để tính toán số ngày trong tháng hiện tại.
        int dayOfMonth = YearMonth.of(systemDay.getYear(),systemDay.getMonth()).lengthOfMonth();
        System.out.println("Day of Month" + dayOfMonth);
//        //Viết chương trình để chuyển đổi một chuỗi ngày sang một đối tượng LocalDate.
        String text = "25/14/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            System.out.println(LocalDate.parse(text,formatter));
        }catch(DateTimeException e){
            System.err.println(e);
        }
        //Viết chương trình để chuyển đổi một đối tượng LocalDateTime sang một chuỗi ngày(dd/MM/yyyy HH:mm:ss).
        LocalDateTime currentDateTime  = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime .format(formatter1);
        System.out.println(LocalDate.parse("Chuỗi ngày tháng được định dạng: " + formattedDateTime));
        //Viết chương trình để so sánh hai ngày LocalDate ( trả về int ).
        LocalDate date1 = LocalDate.of(2024, 6, 27);
        LocalDate date2 = LocalDate.of(2024, 1, 27);
        int comparison = date1.compareTo(date2);

//        LocalDate startDate = LocalDate.of(2020, 6, 27);
//        Period period = Period.of(2021,6,3);
//        LocalDate endDate = startDate.plus(period);
//        System.out.println("Ngày kết thúc sau khi thêm Period: " + endDate);
    }
}
