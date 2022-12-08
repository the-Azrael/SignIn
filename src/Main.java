import java.util.Scanner;

public class Main {
    public static User[] getUsers() {
        User user1 = new User("jhon", "jhon@gmail.com", "pass1", 24);
        User user2 = new User("maria", "maria@gmail.com", "pass2", 20);
        User user3 = new User("alex", "alex@gmail.com", "pass3", 39);
        User user4 = new User("peter", "peter@gmail.com", "pass4", 45);
        User user5 = new User("lisa", "lisa@gmail.com", "pass5", 12);
        return new User[] { user1, user2, user3, user4, user5 };
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        User rightUser = null;
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                rightUser = user;
                break;
            }
        }
        if (rightUser == null) {
            throw new UserNotFoundException("User not found");
        } else {
            return rightUser;
        }
    }

    public static void validateUser(User user) throws AccessDenidedException {
        if (user.getAge() < 18) {
            throw new AccessDenidedException("Несовершеннолетний detected! Доступ закрыт!");
        }
    }

    public static void main(String[] args) throws UserNotFoundException, AccessDenidedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);
        System.out.println("Доступ предоставлен");
    }
}
