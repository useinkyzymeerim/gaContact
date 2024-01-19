import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ContactManager {
    private final Contact[] contacts = new Contact[100];
    private int size = 0;
    Scanner scanner = new Scanner(System.in);


    public void allContacts() {
        System.out.println("\n********* Все ваши контакты *********");
        if (size == 0 || contacts.length == 0 || contacts[0] == null) {
            System.out.println("\nВаш контак пуст!");
        }
        for (int i = 0; i < size; i++) {
            Contact contact = contacts[i];
            if (contacts[i] != null) {
                System.out.println((i + 1) + "." + contact.getFirstName());
            }
        }
    }

    public void createContact() {
        if (size < contacts.length) {
            System.out.println("\n********* Добавьте ваш контакт *********");
            System.out.print("Введите имя - ");
            String firstname = scanner.nextLine();
            System.out.print("Введите фомилию - ");
            String lastName = scanner.nextLine();
            System.out.print("Введите номер - ");
            String numberPhone = scanner.nextLine();
            System.out.print("Введите электронную почту - ");
            String email = scanner.nextLine();
            System.out.println("---------------------------------------");

            Contact newContact = new Contact(firstname, lastName, numberPhone, email);
            contacts[size] = newContact;
            size++;
            System.out.println("Контак успешно сохранено");
        } else {
            System.out.println("Контак заполнен!\nНевозможно создать контакт ");
        }

    }

    public void upDateContact() {
        if (size > 0) {
            System.out.println("\n********* Обновление контакта *********");

            allContacts();

            System.out.print("\nУкажите индекс контакта, который вы хотели бы обновить - ");
            int contactToUpDate = scanner.nextInt() - 1;

            if (contactToUpDate < size && contactToUpDate >= 0) {
                boolean upDating = true;
                int continueUpdating;

                while (upDating) {
                    System.out.println(
                            "\n1.Обнавить контакт по имени" +
                                    "\n2.Обнавить контакт по фамилии" +
                                    "\n3.Обнавить контакт по номеру" +
                                    "\n4.Обнавить контакт по электронной почты");
                    System.out.print("Выберети номер, которое вы хотели бы обновить - ");
                    int fieldToUpdate = scanner.nextInt();

                    switch (fieldToUpdate) {
                        case 1:
                            System.out.print("Введите новое имя контакта - ");
                            scanner.nextLine();
                            String newFullName = scanner.nextLine();
                            contacts[contactToUpDate].setFirstName(newFullName);

                            System.out.println("\nИмя контакта обнавлено: " + contacts[contactToUpDate].getFirstName());

                            System.out.println("\nХотите отнавить еще что то?");
                            System.out.println("1.Да\n2.Нет");
                            System.out.print("Введите номер для ответа - ");
                            continueUpdating = scanner.nextInt();

                            switch (continueUpdating) {
                                case 1:
                                    break;
                                case 2:
                                    upDating = false;
                                    break;
                                default:
                                    System.out.println("Вы не правельно ввели!\n");
                            }
                            break;

                        case 2:
                            System.out.print("Введите новую фамилию контакта - ");
                            scanner.nextLine();
                            String newLastName = scanner.nextLine();
                            contacts[contactToUpDate].setLastName(newLastName);

                            System.out.println("\nФамиля контакта обнавлено: " + contacts[contactToUpDate].getLastName());

                            System.out.println("\nХотите отнавить еще что то?");
                            System.out.println("1.Да\n2.Нет");
                            System.out.print("Введите номер для ответа - ");
                            continueUpdating = scanner.nextInt();
                            switch (continueUpdating) {
                                case 1:
                                    break;
                                case 2:
                                    upDating = false;
                                    break;
                                default:
                                    System.out.println("Вы не правельно ввели!\n");
                            }
                            break;

                        case 3:
                            System.out.print("Введите новый номер контакта - ");
                            scanner.nextLine();
                            String newPhoneNumber = scanner.nextLine();
                            contacts[contactToUpDate].setNumberPhone(newPhoneNumber);

                            System.out.println("\nНомер контакта обнавелно: " + contacts[contactToUpDate].getNumberPhone());

                            System.out.println("\nХотите отнавить еще что то?");
                            System.out.println("1.Да\n2.Нет");
                            System.out.print("Введите номер для ответа - ");
                            continueUpdating = scanner.nextInt();
                            switch (continueUpdating) {
                                case 1:
                                    break;
                                case 2:
                                    upDating = false;
                                    break;
                                default:
                                    System.out.println("Вы не правельно ввели!\n");
                            }
                            break;

                        case 4:
                            System.out.print("Введите новый электроный адркс контакта - ");
                            scanner.nextLine();
                            String newEmail = scanner.nextLine();
                            contacts[contactToUpDate].setEmail(newEmail);

                            System.out.println("\nЭлектроный адрес контакта обнавлено: " + contacts[contactToUpDate].getEmail());

                            System.out.println("\nХотите отнавить еще что то?");
                            System.out.println("1.Да\n2.Нет");
                            System.out.print("Введите номер для ответа - ");
                            continueUpdating = scanner.nextInt();
                            switch (continueUpdating) {
                                case 1:
                                    break;
                                case 2:
                                    upDating = false;
                                    break;
                                default:
                                    System.out.println("Вы не правельно ввели!");
                            }
                            break;

                        default:
                            System.out.println("\nОщибка! попробуйте еще!");
                    }
                }
            } else
                System.out.println("\nНеправельный индекс контакта!");

        } else
            System.out.println("\nКонтакт не доступный");
    }


    public void deleteContact() {
        if (size > 0) {
           try {
               System.out.println("\n********* Удаление контакта *********");
               allContacts();
               System.out.print("Введите индекс контакта, что бы удалить контакт - ");
               int deleteContact = scanner.nextInt() - 1;

               if (deleteContact < size && deleteContact >= 0) {
                   System.out.println("Вы точно хотите удалить контакт - " + contacts[deleteContact].getFirstName() + " ?");
                   System.out.println("1.Да\n2.Нет");
                   System.out.print("Введите номер для ответ - ");
                   int action = scanner.nextInt();

                   switch (action) {
                       case 1:
                           System.out.println("Контакт " + contacts[deleteContact].getFirstName() + " удален!");
                           contacts[deleteContact] = null;
                           break;
                       case 2:
                           System.out.println("Удаление контакта " + contacts[deleteContact].getFirstName() + " отменено");
                           break;
                       default:
                           System.out.println("Неправильный выбор. Отмена удадение");
                           break;
                   }
               } else {
                   System.out.println("Вы не правельно вели индекс контакта!\n");
               }
           }catch (NullPointerException n){
               System.out.println(n.getMessage());
           }
        } else {
            System.out.println("Нет контактов для удаления");
        }

    }

    public void readContact() {
        if (size > 0) {
            System.out.println("\n********* Вся информация о контактов *********");
            System.out.print("\nВведите имя контакта - ");
            String read = scanner.nextLine();

            boolean readContact = false;

            for (int i = 0; i < size; i++) {
                if (read.equalsIgnoreCase(contacts[i].getFirstName())){
                    System.out.println(contacts[i]);
                    readContact = true;
                }
            }

            if (!readContact)
                System.out.println("\nНет контакта с таким именем " + read);

        } else
            System.out.println("\nНет контактов!");
    }

    public void findContact() {
        System.out.println("\n******* Сохронение контакта в файле *******");
        try {
            System.out.print("Введите имя файла - ");
            String fileName = scanner.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Contact contact : contacts) {
                    if (contact != null) {
                        writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getNumberPhone() + "," + contact.getEmail());
                        writer.newLine();
                    }
                }
                System.out.println("Контакты успешно сохранены в файл: " + fileName);

            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении контактов в файл: " + e.getMessage());
        }
    }

    public void fileContact() {
            if (size > 0) {
                System.out.println("\n********* Сохронение контакта в файле *********");
                try {
                    System.out.print("Введите имя файла - ");
                    String file = scanner.nextLine();

                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                    for (int i = 0; i < size; i++) {
                        if (contacts[i] != null){
                            writer.write(contacts[i].getFirstName() + ", " + contacts[i].getLastName() + ", " +
                                    contacts[i].getNumberPhone() + ", " + contacts[i].getEmail());
                                    writer.newLine();
                        }
                    }
                    writer.close();

                    System.out.println("Контак успешно сохранено в файле: " + file);

                } catch (IOException ioException) {
                    System.out.println(ioException.getMessage());
                }
            } else System.out.println("Нет такого контакта!");
        }
    public void LoadFromFile(int start) {
        System.out.println("\n********* Загрузить контак из файла *********");
        System.out.print("Введите имя файла - ");
        String file = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int index = start;
            int arrayLength = contacts.length;
            while ((line = reader.readLine()) != null && index < arrayLength) {
                String[] contactInfo = line.split(",");
                if (contactInfo.length >= 4) {
                    String firstName = contactInfo[0];
                    String lastName = contactInfo[1];
                    String numberPhone = contactInfo[2];
                    String email = contactInfo[3];

                    Contact contact = new Contact(firstName, lastName, numberPhone, email);
                    contacts[index] = contact;
                    index++;
                } else {
                    System.out.println("Контакты успешно загружаны из файла!");
                }
            }
            System.out.println("Контакты успешно загружаны из файла!");
        }catch (IOException i){
            System.out.println("Ошибка при загрузке" + i.getMessage());
        }
    }
      }





