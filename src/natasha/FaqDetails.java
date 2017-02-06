package natasha;

/**
 * Created by Natasha on 13/12/2016.
 */
public class FaqDetails {
    //Entity Class
    private String id = null;
    private String question = null;
    private String answer = null;
    private String category = null;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
