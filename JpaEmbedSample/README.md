# JPA Embed Sample
Bu proje, Java Persistence API (JPA) kullanarak bir veritabanı işlemleri örneği göstermektedir. Proje, bir şirket için personel yönetimi yapmak için kullanılan bir veritabanı şemasını tasarlamaktadır.

## Başlangıç
Projeyi kendi bilgisayarınızda çalıştırmak için aşağıdaki adımları takip edebilirsiniz:

## Önkoşullar
* Java Development Kit (JDK) 8 veya sonraki bir sürümü yüklü olmalıdır.
* Maven 3.6.0 veya sonraki bir sürümü yüklü olmalıdır.
* Veritabanı yönetim sistemi olarak MySQL kullanılacaktır.

## Kurulum
* Bu depoyu klonlayın veya ZIP dosyası olarak indirin.
* Terminal veya komut istemi açın ve proje klasörüne gidin.
* mvn clean install komutunu çalıştırarak projeyi derleyin ve paketleyin.
* Veritabanı bağlantısı için application.properties dosyasını düzenleyin.
* Main sınıfını çalıştırın.


````
mvn clean install
java -jar target/JpaSample-1.0-SNAPSHOT.jar
````

## Kullanım
Proje, bir şirketin personel yönetimi için bir veritabanı şemasını tasarlamaktadır. Veritabanında beş adet ana tablo yer almaktadır: employee, director, participant, project ve task. Her bir tablo, işlemleri gerçekleştirmek için tasarlanmış bir Repository sınıfı ile eşlenmektedir.

* Main sınıfı, örnek bir çalıştırma senaryosunu göstermektedir. Bu senaryo, yeni bir çalışan kaydı oluşturmayı, varolan bir çalışanın bilgilerini güncellemeyi ve bir çalışanı silmeyi içermektedir.
