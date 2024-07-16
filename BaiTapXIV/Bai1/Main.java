package BaiTapXIV.Bai1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        List<Integer> randomList = Stream.generate(() -> new Random().nextInt(50)).limit(10).toList();
        System.err.println(randomList);
//        //Sử dụng Stream API để duyệt qua mảng và phương thức max() để tìm số lớn nhất trong mảng
//        Optional<Integer> max = randomList.stream().max(Integer::compareTo);
//        System.out.println(max);
        //ifPresent nếu như nó tồn tại thì nó sẽ làm gì tiếp theo
        //Sử dụng Stream API và phương thức filter() để tìm số chẵn
        Stream<Integer> evenNumbers = randomList.stream().filter(num -> num % 2 == 0);
        evenNumbers.forEach(System.out::println);
        //Sử dụng Stream API và phương thức filter() để lọc các số lớn hơn một giá trị xác định mà người dùng nhập vào
//        Scanner sc=new Scanner(System.in);
//        System.out.println("nhap vao 1 so ngau nhien: ");
//        int number = sc.nextInt();
//        randomList.stream()
//                .filter(num -> num > number)
//                .forEach(num -> System.out.println("Số lớn hơn " + number + " là: " + num));
        //Sử dụng Stream API và phương thức reduce() để tính tổng của các số trong danh sách
//        int sumNumber=randomList.stream().reduce(0,Integer::sum);
//        System.out.println(sumNumber);
        //Sử dụng Stream API và phương thức anyMatch() để kiểm tra xem danh sách có chứa ít nhất một số chẵn hay không.
//        boolean check = randomList.stream().anyMatch(num -> num % 2 == 0);
//        System.out.println(check);
        //Sử dụng Stream API và phương thức range() để tạo danh sách các số từ x đến y.
//        IntStream.range(1,40).forEach(System.out::println);
        //Sử dụng Stream API và phương thức sorted() để sắp xếp danh sách theo thứ tự bảng chữ cái.
//        randomList.stream().sorted().forEach(System.out::println);//chưa ra kết quả vì mảng không có chữ cái nào
        //Sử dụng Stream API và phương thức map() để chuyển các chuỗi thành chữ in hoa.
//        randomList.stream().map(String::toUpperCase).forEach(System.out::println);//chưa ra kết quả vì mảng không có chữ cái nào



    }

    }
