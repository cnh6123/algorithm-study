import java.util.*;
//프로그래머스 코딩테스트 연습 <정렬> - '가장 큰 수' 문제
public class Programmers42746 {
    public static String solution(int[] numbers) {
        String answer = "";

        //int 배열을 String 배열로 변환
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            //Integer.toString()은 없다.
            //String.valueOf를 이용해서 int->String 변환
            arr[i] = (String.valueOf(numbers[i]));
        }

        //배열 정렬, 정렬 규칙으로는 2개를 더하여 더 큰 쪽이 우선순위가 있도록 정렬
        //compare()와 compareTo()의 차이
        //Arrays.sort() 두번째 매개변수 Comparator<> 이용법
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });

        //0000 처럼 0으로만 구성되어있으면 0 return
        if (arr[0].equals("0")) return "0";

        //그 외의 경우 순차적으로 연결하여 answer return
        for (int i = 0; i < arr.length; i++) {
            answer+=arr[i];
        }
        return answer;
    }
}