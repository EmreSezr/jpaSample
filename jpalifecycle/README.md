# JPA PrePersist Sample
Bu proje, Java Persistence API (JPA) kullanarak entitylerin yaşam döngüsüne etki eden listener'larını kullanarak örnek bir veritabanı işlemleri uygulamasıdır.

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
java -jar target/jpainherit-1.0-SNAPSHOT.jar
````

## Kullanım
Proje, entitylerin yaşam döngüsüne etki eden listener'ları kullanarak, örneğin bir entity kaydı oluşturulduğunda veya silindiğinde belirli bir işlemi gerçekleştirmek için tasarlanmıştır.

Person sınıfı için @PrePersist, @PostPersist, @PreUpdate, @PostUpdate, @PreRemove ve @PostRemove listener'ları tanımlanmıştır. Bu listener'lar, ilgili entity işlemlerinde belirli loglama işlemlerini gerçekleştirmektedir.

Main sınıfı, örnek bir çalıştırma senaryosunu göstermektedir. Bu senaryo, yeni bir kişi kaydı oluşturmayı ve bir kişiyi silmeyi içermektedir.
