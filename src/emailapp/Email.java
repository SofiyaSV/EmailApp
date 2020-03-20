package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String  password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";


    // Конструктор для имени и фамилии
    public Email (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("EMAIL CREATED :" + this.firstName + " " + this.lastName );

        // Метод который возвращается запрашиваемый отдел
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        //Метод который возвращает рандомный пароль
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Комбинаци элементов для генерации электронной почты
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
        //System.out.println("Your email is: " + email);



    }

    //Спрашивает отдел
    private String setDepartment () {
        System.out.println("New worker :" + firstName + ". Department Codes: \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none \nEnter department codes: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return " "; }

    }
    //Генерация случайного пароля
    private String randomPassword (int length) {
        String passwordSet = "ABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789@#$%";
        char [] password = new char[length];
        for (int i = 0; i < length; i ++) {
         int rand = (int) (Math.random() * passwordSet.length());
         password [i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Установить емкость почтового ящика
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    //Установить альтернативный адрес электронной почты
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    //Сменить пароль
    public void changePassword (String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }

    public String getAlternateEmail() { return alternateEmail; }

    public String getPassword() { return password; }

    public String snowInfo () {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }


}
