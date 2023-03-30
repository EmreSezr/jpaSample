# JPA Inheritance Sample
Bu proje, Java Persistence API (JPA) kullanarak kalıtım yapısını kullanarak veri tabanı işlemleri örneği göstermektedir. Proje, bir spor salonu için üyelerin kaydını ve aktivitelerini yönetmek için bir veritabanı şemasını tasarlamaktadır.

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
