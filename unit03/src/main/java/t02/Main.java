package t02;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Katerina on 10.03.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Language language = new Language();

        chooseLanguage(language);

        Questions questions = new Questions();
        List<String> lst = Questions.getQuestions(language);

        printQuestionsList(lst);

        int answerNum = chooseQuestion(lst.size(), language);
        Answers answers = new Answers();

        System.out.println(answers.getAnswer(String.valueOf(answerNum)));
    }

    private static int chooseQuestion(int listSize, Language l) {
        Scanner input = new Scanner(System.in);
        int numOfQuestion = input.nextInt();
        while (numOfQuestion > listSize) {
            if (l.locale.getLanguage().equals("ru")) {
                System.out.println("Введите номер вопроса из представленных вам");
            }
            else{
                System.out.println("Please, enter one of the represented number of questions");
            }
            numOfQuestion = input.nextInt();
        }
        return numOfQuestion;
    }

    private static void printQuestionsList(List<String> lst) {
        int i = 1;
        for (String s : lst) {
            System.out.println(i + ":" + s);
            ++i;
        }
    }

    private static void chooseLanguage(Language language) {
        Scanner input = new Scanner(System.in);
        while (!Language.flag) {
            System.out.println("Select language, please");
            language.setLanguage(input.nextLine());
        }
    }


}
