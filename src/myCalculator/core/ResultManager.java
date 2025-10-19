package myCalculator.core;

import java.util.ArrayList;

public class ResultManager<T> {
   private ArrayList<T> answers = new ArrayList<T>();

    // 게터 기능
    public ArrayList<T> getAnswers(){
        return answers;
    }

    // 세터 기능
    public void setAnswers(ArrayList<T> answers) {
        this.answers = answers;
    }

    // 저장 기능
    public void addAnswer(T result) {
        answers.add(result);
    }

    // 삭제 기능
    public void removeAnswer(T answer) {
        answers.remove(answer);
    }
}
