package abiturient;


import java.util.Scanner;

public class Abiturient {
    private int id;
    private String LastName;
    private String FirstName;
    private String MiddleName;
    private String Address;
    private String PhoneNumber;
    private float AverageGrade;

    /** Конструктор без параметрів */
    public Abiturient(){}

    /** Конструктор з параметрами */
    public Abiturient(int id, String lastName, String firstName, String middleName, String address, String phoneNumber, float averageGrade){
        this.id = id;
        this.LastName = lastName;
        this.FirstName = firstName;
        this.MiddleName = middleName;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.AverageGrade = averageGrade;

    }

    /** Метод, який отримує ім'я абітурієнта за яким буде здійснюватись пошук */
    public static String InputName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведіть ім'я за яким бажаєте розпочати пошук: ");
        String Name = scan.nextLine();
        return Name;
    }

    /** Метод, який отримує бал абітурієнта за яким буде здійснюватись пошук */
    public static Float InputGrade() {
        Scanner scan = new Scanner(System.in);
        float grade = -1;
        do {
            System.out.print("\nВведіть середній бал: ");
            try {
                grade = scan.nextFloat();
            } catch (Exception e) {
                System.out.println("Помилка введення! Введіть бал в діапазоні від 0 до 100");
                scan.nextLine();
            }
        }while(grade < 0 || grade > 100);
        return grade;
    }

    /** Метод, який отримує число абітурієнтів яких потрібно буде вивести */
    public static Byte InputN() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведіть кількість абітурієнтів з найвищим балом яких потріно вивести: ");
        Byte N = scan.nextByte();
        return N;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }



    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }



    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }



    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }



    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }



    public float getAverageGrade() {
        return AverageGrade;
    }

    public void setAverageGrade(float averageGrade) {
        AverageGrade = averageGrade;
    }



    public String toString(){
        String result = String.format("id: %-3d Прізвище: %-10s Ім'я: %-8s По батькові: %-13s Номер телефону: %-15s Адреса: %-22s Середній бал: %f", id, LastName, FirstName, MiddleName, PhoneNumber, Address, AverageGrade);
        return result;
    }

}

