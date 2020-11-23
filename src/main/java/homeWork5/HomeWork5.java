package homeWork5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class HomeWork5 {
    public static List<String> getTextList(List<WebElement> articleList){
        List<String> articleNameList = new ArrayList<>();
        for (int i = 0; i < articleList.size(); i++) {
            articleNameList.add(articleList.get(i).getText());
        }
        return articleNameList;
    }

    public static <T> Collection<T> getAttributeList(List<WebElement> articleList, String attribute){
        List<String> attributeList = new ArrayList<>();
        for (int i = 0; i < articleList.size(); i++) {
            attributeList.add(articleList.get(i).getAttribute(attribute));
        }
        return new TreeSet<T>((Collection<? extends T>) attributeList) {
        };
    }

    public static void printFullNamesAndUrlsList(List<WebElement> articleList){
        removeSymbolsInSpan(getAttributeList(articleList, "innerHTML")).forEach(System.out::println);
        getAttributeList(articleList, "href").forEach(System.out::println);
    }

    public static List<String> removeSymbolsInSpan(Collection<String> collection){
        List<String> list = new ArrayList<>(collection);
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String removedSymbols = list.get(i).replaceAll("<span>.*</span>", "");
            newList.add(removedSymbols);
        }
        return newList;
    }
//public static List<String> removeSymbolsInSpan(Collection<String> collection){
//        List<String> newList = new ArrayList<>();
//    Iterator iterator = collection.iterator();
//    while(iterator.hasNext()){
//        String removedSymbols = iterator.next().replaceAll("<span>.*</span>", "");
//
//        //do something to object here...
//    }
//        for (int i = 0; i < collection.size(); i++) {
//            String removedSymbols = collection..replaceAll("<span>.*</span>", "");
//            newList.add(removedSymbols);
//        }
//        return newList;
//    }

}
