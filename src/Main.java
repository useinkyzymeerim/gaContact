import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContactManager contactManager = new ContactManager();

        boolean program = true;

        while (program){
            System.out.println("\n********* Контакная книжка *********");
            System.out.println("""
                    1.Посмотерть контакты
                    2.Создать новый контакт
                    3.Обнавить контакт
                    4.Удалить контакт
                    5.Информация о контакте
                    6.Поиск контакта
                    7.Сохранить контакт в файле
                    8.Загрузит контак из файла
                    0.Выход
                    """);
            System.out.print("Выберете действие - ");
            int action = scanner.nextInt();

            switch (action){
                case 1:
                    contactManager.allContacts();
                    break;
                case 2:
                    contactManager.createContact();
                    break;
                case 3:
                    contactManager.upDateContact();
                    break;
                case 4:
                    contactManager.deleteContact();
                    break;
                case 5:
                    contactManager.readContact();
                    break;
                case 6:
                    contactManager.findContact();
                    break;
                case 7:
                    contactManager.fileContact();
                    break;
                case 8:
                    contactManager.LoadFromFile(0);
                    break;
                case 0:
                    program = false;
                default:
                    System.out.println("Ошибка! попробуйте еще раз");

            }
        }
    }

}