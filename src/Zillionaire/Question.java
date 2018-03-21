package Zillionaire;

import java.util.ArrayList;

/**
 * Created by u1756102 on 07/02/2018.
 */

public class Question {
    private String title;
    private String answer;
    private ArrayList<String> answers;
    private int complexity;
    private String category;


    public Question(String title, String answer, ArrayList <String> answers, int complexity, String cat) {
        this.title = title;
        this.answer = answer;
        this.answers = answers;
        this.complexity = complexity;
        this.category = cat;
    }

    public Question() {}


    public String getTitle() {
        return title;
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public String getCategory() {
        return category;
    }

    public int getComplexity() {
        return complexity;
    }
}
