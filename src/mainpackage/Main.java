package mainpackage;
import abiturient.Abiturient;


import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        ArrayList <Abiturient> abiturients = DataArray();
        PrintArray(abiturients);
        String AbitName = Abiturient.InputName();
        ArrayList<Abiturient> res1 = SearchName(abiturients, AbitName);
        PrintArray(res1);
        Float Grade = Abiturient.InputGrade();
        ArrayList<Abiturient> res2 = HigherAvgGrade(abiturients, Grade);
        PrintArray(res2);
        Byte N = Abiturient.InputN();
        SearchAvgScore(abiturients, N);

    }

    /** Масив, який зберігає дані про абітурієнтів */
    static ArrayList <Abiturient> DataArray() {
        ArrayList<Abiturient> array = new ArrayList<>();
        array.add(new Abiturient(1, "Сакаль", "Марко", "Степанович", "50-річчя УПА 14", "+380668940011", 82.13f));
        array.add(new Abiturient(2, "Баран", "Ілона", "Антонівна", "Степана Гіги 11А", "+380668142170", 77.91f));
        array.add(new Abiturient(3, "Гарбузова", "Андріана", "Остапівна", "Тараса Шевченка 1А", "+380668997140", 97.11f));
        array.add(new Abiturient(4, "Ружевич", "Тетяна", "Василівна", "Степана Бандери 34", "+38099132170", 66.04f));
        array.add(new Abiturient(5, "Янко", "Ірина", "Богданівна", "Тараса Шевченка 23Б", "+38066023761", 54.09f));
        array.add(new Abiturient(6, "Плиса", "Яна", "Андріївна", "Дмитра Бережниці 43", "+380738111896", 55.12f));
        array.add(new Abiturient(7, "Попів", "Іван", "Петрович", "Лесі Українки 22В", "+380668022413", 67.12f));
        array.add(new Abiturient(8, "Бомко", "Степан", "Акакієвич", "Костя Левицького 76", "+380699762170", 90.35f));
        array.add(new Abiturient(9, "Моставчук", "Петро", "Олексійович", "Марусі Чурай 9Б", "+380736652179", 88.81f));
        array.add(new Abiturient(10, "Кличко", "Іван", "Дмитрович", "Степана Гіги 11А", "+380668009871", 99.19f));
        array.add(new Abiturient(11, "Василина", "Федір", "Максимович", "Степана Гіги 11А", "+380690123491", 78.43f));
        array.add(new Abiturient(12, "Лугова", "Олена", "Миронівна", "Івана Франка 4А", "+380731144267", 63.02f));
        array.add(new Abiturient(13, "Завозіна", "Марія", "Василівна", "50-річчя УПА 6", "+380990048871", 89.11f));
        array.add(new Abiturient(14, "Воєвода", "Галина", "Олегівна", "Григорія Малевича 43", "+380551002314", 81.23f));
        array.add(new Abiturient(15, "Приходько", "Олег", "Дмитрович", "Тараса Шевченка 101", "+380667788123", 66.89f));
        return array;
    }

    /** Метод, який здійснює пошук абітурієнтів по імені */
    static ArrayList<Abiturient> SearchName(ArrayList <Abiturient> abiturients, String AbitName) {

        ArrayList <Abiturient> AbitWithCertainName = new ArrayList<>();
        for (Abiturient el : abiturients)
            if (AbitName.equals(el.getFirstName())) {
                AbitWithCertainName.add(el);
            }
            return AbitWithCertainName;
    }
    /** Метод, який здійснює пошук абітурієнтів з вищим середнім балом */
    static ArrayList<Abiturient> HigherAvgGrade(ArrayList <Abiturient> abiturients, Float Grade) {
        ArrayList <Abiturient> AbitWithHigherGrade = new ArrayList<>();
        for (Abiturient el : abiturients)
            if (el.getAverageGrade() > Grade)
                AbitWithHigherGrade.add(el);
        return AbitWithHigherGrade;
    }

    /** Метод, який буде здійснювати пошук N найуспішніших абітурієнтів */
    static void SearchAvgScore(ArrayList<Abiturient> abiturients, Byte N)
    {
        int temp = 0, j = 0, k = 0;                  // temp - для записування кількості вже написаних абітурієнті; j та k - каунтери
        int[] idcollector = new int[15];          // масив у який записуємо айді вже виведених абітурієнтів Marko Sakal’, [20.10.2022 16:48]
        Abiturient HighestAvg = new Abiturient();    // об'єкт класу в який будемо записувати абітурієнта з найвищим балом
        while (temp < N) {
            HighestAvg = abiturients.get(j);           // записуємо 0 абітурієнта в HighestAvg
            for(j=0; abiturients.get(j).getId() < 15; j++)     // цикл для знаходження абітурієнта з найвищим айді
            {
                if (HighestAvg.getAverageGrade() <= abiturients.get(j).getAverageGrade()) // якщо HighestAvg менше за абітурієнта який виведений зараз, то міняємо місцями
                {
                    if (temp != 0)                              // якщо це перший вивід, то нічого не стається
                    {
                        k = 0;                              // занулюю каунтер
                        do
                        {
                            if (idcollector[k] == abiturients.get(j).getId())
                                break;
                            k++;
                        } while (k < temp);
                    }
                    if (idcollector[k] != abiturients.get(j).getId()) { // міняємо місцями
                        HighestAvg = abiturients.get(j);    // записую в HighestAvg нового абітурієнта
                    }
                }
            }
            idcollector[temp]= HighestAvg.getId();              // записую його в масив з Id
            System.out.println(HighestAvg.toString());           // виводжу на екран абітурієнта
            temp++;                                         // запам'ятовую, що ми записали ще одного Абітурієнта
        }
    }
    /** Метод, який виводить список відфільтрованих абітурієнтів */
    public static void PrintArray(ArrayList <Abiturient> abiturients){
        if(abiturients.isEmpty()) {
            System.out.println("Записів за вказаними даними не знайдено");
            return;
        }
        for (Abiturient el : abiturients)
            System.out.println(el);
    }
}




