public class DataCorrectness {

    private String login;
    private String password;
    private String confirmPassword;

    public DataCorrectness() {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public static void data(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        try {
            verificationLogin(login);
        } catch (WrongLoginException e) {
            System.out.println("Произошла ошибка c логином");
        }

        try {
            verificationPassword(password);
        } catch (WrongPasswordException e) {
            System.out.println("Произошла ошибка с паролем");
        }

        if (password.equals(confirmPassword)) {
            System.out.println("Пароли совпадают");
        } else {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static void verificationLogin(String word) throws WrongLoginException {
        if (word.length() > 1 && word.length() < 20 && !word.isEmpty() && word != null) {
            char[] log = word.toCharArray();
            for (char symbol : log) {
                if (Character.isAlphabetic(symbol) || Character.isDigit(symbol) || symbol == '_') {
                    System.out.print(symbol);
                } else {
                    throw new WrongLoginException();
                }
            }
        } else {
            throw new WrongLoginException();
        }
        System.out.println();
    }

    public static void verificationPassword(String word) throws WrongPasswordException {
        if (word.length() > 1 && word.length() < 20 && !word.isEmpty() && word != null) {
            char[] log = word.toCharArray();
            for (char symbol : log) {
                if (Character.isAlphabetic(symbol) || Character.isDigit(symbol) || symbol == '_') {
                    System.out.print(symbol);
                } else {
                    throw new WrongPasswordException();
                }
            }
        } else {
            throw new WrongPasswordException();
        } System.out.println();
    }

}

