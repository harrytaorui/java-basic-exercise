import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String firstWordList = sc.nextLine().toUpperCase();
        String secondWordList = sc.nextLine().toUpperCase();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        if(firstWordList.contains(",,")||!firstWordList.matches("[a-zA-Z,]+")
        ||secondWordList.contains(",,") ||!secondWordList.matches("[a-zA-Z,]+")){
            throw new RuntimeException("input not valid");
        }
        String[] arr1 = firstWordList.toUpperCase().split(",");
        String[] arr2 = secondWordList.toUpperCase().split(",");
        //find distinct words in line 1
        Set<String> distinctSet = Arrays.asList(arr1).stream().collect(Collectors.toSet());
        //find common words in line 1 and 2
        List<String> commonSet = Arrays.asList(arr2).stream().distinct().filter(e -> distinctSet.contains(e)).collect(Collectors.toList());
        //convert to words with spaces
        List<String> result = commonSet.stream().map(e -> e.replace(""," ").trim()).collect(Collectors.toList());
        //sort in alphabetical order
        result.sort(String::compareTo);

        return result;
    }


}
