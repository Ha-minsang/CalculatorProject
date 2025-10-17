package myCalculator;

import java.util.ArrayList;

public class Calculator {
   private ArrayList<Integer> answers = new ArrayList<>();

    // 게터 기능
    public ArrayList<Integer> getAnswers(){
        return answers;
    }

    // 세터 기능
    public void setAnswers(ArrayList<Integer> answers) {
        this.answers = answers;
    }

    public void addAnswer(int result) {
        answers.add(result);
    }

    // 삭제 기능
    public void removeAnswer(int answer) {
        answers.remove(answer);
    }
}
