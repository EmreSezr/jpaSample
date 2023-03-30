# JPA Örneği
Bu proje, Java Persistence API (JPA) kullanarak basit bir veritabanı işlemi gerçekleştiren bir Java projesidir. Proje, Employee sınıfını kullanarak veritabanında çalışanların kaydedilmesini, güncellenmesini ve silinmesini sağlar.

### Başlangıç
Projeyi kendi bilgisayarınızda çalıştırmak için aşağıdaki adımları takip edebilirsiniz:

### Önkoşullar
Java Development Kit (JDK) 8 veya sonraki bir sürümü yüklü olmalıdır.
Maven 3.6.0 veya sonraki bir sürümü yüklü olmalıdır.
Veritabanı yönetim sistemi olarak MySQL kullanılacaktır.

### Kurulum
* Bu depoyu klonlayın veya ZIP dosyası olarak indirin.
* Terminal veya komut istemi açın ve proje klasörüne gidin.
* mvn clean install komutunu çalıştırarak projeyi derleyin ve paketleyin.
* Veritabanı bağlantısı için application.properties dosyasını düzenleyin.
* Main sınıfını çalıştırın.
````
mvn clean install
java -jar target/jpabasics-1.0-SNAPSHOT.jar
````
### Kullanım
* EmployeeService sınıfı, veritabanı işlemlerinin gerçekleştirildiği ana bileşen olarak tasarlanmıştır. 
* Bu sınıf, veritabanına yeni bir çalışan eklemek, varolan bir çalışanın bilgilerini güncellemek veya bir çalışanı silmek gibi işlemleri yapabilmektedir.

Main sınıfı, örnek bir çalıştırma senaryosunu göstermektedir. Bu senaryo, yeni bir çalışan kaydetmeyi, var olan bir çalışanın bilgilerini güncellemeyi ve bir çalışanı silmeyi içermektedir.
