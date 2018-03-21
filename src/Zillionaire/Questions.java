package Zillionaire;

/**
 * Created by u1756102 on 14/02/2018.
 */

import java.util.ArrayList;

public class Questions {
    private ArrayList <Question> questionStore;


    public Questions() {
        this.questionStore = new ArrayList<>();
    }


    public void addQuestion(String q, String a, String o1, String o2, String o3, String o4, int c, String cat) {
        ArrayList answers = new ArrayList();
        answers.add(o1);
        answers.add(o2);
        answers.add(o3);
        answers.add(o4);
        Question Q = new Question(q, a, answers, c, cat);
        this.questionStore.add(Q);
    }

    public Question getQuestion(int complexity, String category) {
        int index = 0;
        Question finalQ = null;

        while (true) {
            if (questionStore.get(index).getComplexity() == complexity && questionStore.get(index).getCategory() == category) {
                finalQ = questionStore.get(index);
                discardQuestion(index);
                break;
            } else {
                index++;
            }
        }

        return finalQ;
    }

    public void discardQuestion(int index) {
        this.questionStore.remove(index);
    }
}

