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
            verification(login);
        } catch (WrongLoginException e) {
            System.out.println("Произошла ошибка");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("");
        }

        try {
            verification(password);
        } catch (WrongPasswordException e) {
            System.out.println("Произошла ошибка");
            System.out.println(e.getMessage());
        }

        if (password.equals(confirmPassword)) {
            System.out.println("Пароли совпадают");
        } else {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static boolean verification(String word) {
        if (word.length() > 1 && word.length() < 20 && !word.isEmpty() && word != null) {

            char[] log = word.toCharArray();
            for (char symbol : log) {
                if (Character.isAlphabetic(symbol) && Character.isDigit(symbol) && symbol == '_') {
                    System.out.println(symbol);
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }


}

