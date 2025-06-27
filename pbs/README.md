# pbs
personel bilgi sistemi 

uygulama dockerize edilmiştir
nasıl yapıldığı ile ilgili not paylaşımım aşağıdaki gibidir..

* öncelikle ana projeye Dockerfile adlı bi klasör oluşturuyoruz uzantı yazmıyoruz,dosyaadı Dockerfile olmalı
* projemizi mvn clean package veya mvn clean install yapıp bu şekilde build ederek target altına jar uzantısınız atmasını sağlıyoruz.
* Docker file içerik şu şekilde olmalı
	FROM openjdk:17-jdk-alpine // image oluşturulur
	COPY target/my-personel-app.jar app.jar  //target altına oluşmuş jar dosyamızı docker altına atar
	ENTRYPOINT ["java","-jar","/app.jar"]  // uygulamamızın ayağa kalkmasını sağlıyor

* şimdi yapmamız gereken docker komutu ile bu proje path altında image oluşturmak için tetikleme yapmaktır.
	docker build --tag=my personel app:v1.1 .
 -tag komutundan sonraki iki noktanın solu=container(repository) ismi,sağ tarafı versiyon olarak geçer 

* oluşturmuş oldumuz image den şimdi container oluşturup çalıştırabiliriz
	docker run -p 8085:8081 my-personel-app:v1.1

-p 8085:8080 şeklinde verilen parametrenin amacı, iki nokta üst üste ifadesinden sonra yazılan 8081 konteynerın iç portudur. 
	Yani bu uygulamayı Docker olmadan ayağa kaldırdığınızda bu port geçerlidir. 
  İki nokta üst üste ifadesinden önce yazılan port ise konteynerın dış portudur. 
	Yani uygulamaya Docker konteynerı üzerinden ulaşmaya çalıştığımızda kullanacağımız porttur.
