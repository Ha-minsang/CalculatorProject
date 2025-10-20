package myCalculator.core;

import java.util.ArrayList;
import java.util.List;

public class ResultManager<T> {
   private List<T> answersList = new ArrayList<T>();

    // 게터 기능
    public ArrayList<T> getAnswers(){
        return (ArrayList<T>) answersList;
    }

    // 저장 기능
    public void addAnswer(T result) {
        answersList.add(result);
    }

    // 삭제 기능
    public void removeAnswer(int index) {
        answersList.remove(index);
    }
}
