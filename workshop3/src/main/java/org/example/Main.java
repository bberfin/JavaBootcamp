package org.example;

/*
Bir firmada çalışanların yönetimi için bir yazılım geliştirmek istiyoruz.
Bu yazılım, farklı departmanlarda çalışanlar için farklı özellikleri içerecektir.
İlk olarak Employee isimli bir üst sınıf oluşturun ve bu sınıftan türetilmiş farklı işçi tipleri oluşturun:
Engineer, Manager ve Executive.

Ayrıca, her bir işçi tipi için farklı bir özellik ekleyeceğiz.
Engineer sınıfı için çalışanın iş tanımı olacaktır(job title).
Manager sınıfı için yönettiği projelerin bütçesi (project budget) ve
Executive sınıfı için hisse senedi opsiyonları(stock options) olacaktır.

Bir çalışan iş sınıfı oluşturun(EmployeeManager).
Bu sınıf Notification'a gevşek(loosely) olarak bağlı olacaktır.
Bu iş sınıfı içerisine bir çalışan ekleme metodu oluşturun ve her eklenen çalışan için sistem otomatik bildirim göndersin.
(sms veya email sadece birini göndersin ama istersek bir den fazla bildirim seçeneği de kullanabilmeliyiz -> sendNotify())
Ayrıca bulk insert de sisteme entegre edilmelidir ve bulk insert için hem sms hem de email ile bildirim sisteme gönderilebilmelidir.

Program, farklı çalışan tipleri ekleyebilmeli ve her çalışan tipi için farklı bilgileri kullanmalıdır.

Bu bilgilere göre örneği oluşturunuz ve Main sınıfı içerisinde simüle ediniz.
*/
public class Main {
    public static void main(String[] args) {
        Engineer engineer = new Engineer("Berfin", "IT", 20000, "full stack");
        Manager manager = new Manager("Burak", "IT", 17500, 1200000);
        Executive executive = new Executive("Engin", "IT", 50000, 10000);

        Notification[] notifications = {new EmailNotification(), new SmsNotification()};
        Employee[] employees = {engineer, manager, executive};

        EmployeeManager employeeManager = new EmployeeManager(notifications);

        employeeManager.addMultiple(employees);


    }
}