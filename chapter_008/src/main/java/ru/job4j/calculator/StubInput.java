package ru.job4j.calculator;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class StubInput implements Input {

    private String[] answers;

    private int position;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Симулятор поведения пользователя
     * @param question
     * @return
     */
    @Override
    public String askStr(String question) {
        return this.answers[position++];
    }
}
