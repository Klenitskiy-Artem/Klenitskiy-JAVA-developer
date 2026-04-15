package Lesson13;

public class Сonfidentially {

    public static boolean checСonfidentially(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        try {
            if (login.length() >= 20 || login.contains(" ")) {
                throw new WrongLoginException("Логин должен быть меньше 20 символов и не содержать пробелы.");
            }

            if (password.length() >= 20 || password.contains(" ")) {
                throw new WrongPasswordException("Пароль должен быть меньше 20 символов и не содержать пробелы.");
            }

            boolean hasDigit = false;
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigit = true;
                    break;
                }
            }

            if (!hasDigit) {
                throw new WrongPasswordException("Пароль должен содержать хотя бы одну цифру.");
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают.");
            }

        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
            throw e;
        }

        return true;
    }
}
