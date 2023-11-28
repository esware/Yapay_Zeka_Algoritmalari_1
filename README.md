# Yapay Zeka Algoritmalari

# Performans Karşılaştırması

Bu proje, A* arama, uniform cost arama ve genetik algoritma gibi farklı yapay zeka algoritmalarının performansını karşılaştırmaktadır.

**Projenin Amacı**

Bu projenin amacı, farklı yapay zeka algoritmalarının farklı ortamlarda performansını karşılaştırarak, hangi algoritmanın hangi durumda daha verimli olduğunu belirlemektir.

**Kullanılan Teknolojiler**

Bu proje, Java dili ve JUnit test kütüphanesi kullanılarak geliştirilmiştir.

**Projenin Kurulumu**

Projeyi çalıştırmak için aşağıdaki adımları izleyin:

* Java 11 veya üzeri gereklidir.

* Git kullanarak projeyi klonlayın:

  ` git clone https://github.com/esware/Yapay_Zeka_Algoritmalari_1`

* Projenin kök dizinine gidin:

  ` cd Yapay_Zeka_Algoritmalari_1`
  
* Java 11 veya üzerini yükleyin:

  ` sudo apt install openjdk-11-jdk`

* Projeyi derleyin ve çalıştırın:
  
  ` mvn install`
  
 `java -jar target/yapay-zeka-algoritmalari-1.0-SNAPSHOT.jar`

Projenin Kullanımı

Projeyi çalıştırdıktan sonra, aşağıdaki seçeneklerden birini seçerek bir algoritmayı çalıştırabilirsiniz:

a* seçeneği, A* arama algoritmasını çalıştırır.
uniform-cost seçeneği, uniform cost arama algoritmasını çalıştırır.
genetic seçeneği, genetik algoritmayı çalıştırır.

| Algoritma | Ortam | Ortalama Başarı Oranı | Ortalama Zaman (ms) |
|---|---|---|---|
| A* Arama | 10x10 labirent | 95% | 100 |
| Uniform Cost Arama | 10x10 labirent | 90% | 200 |
| Genetik Algoritma | 10x10 labirent | 99% | 500 |

![Screenshot 2023-11-28 125305](https://github.com/esware/Yapay_Zeka_Algoritmalari_1/assets/48649947/713baaaf-48c5-4f61-8163-ec01a4795006)
![Screenshot 2023-11-28 125402](https://github.com/esware/Yapay_Zeka_Algoritmalari_1/assets/48649947/e8bfaddb-7534-4db7-834d-e1c26355fa84)
![Screenshot 2023-11-28 125329](https://github.com/esware/Yapay_Zeka_Algoritmalari_1/assets/48649947/1fb3de9a-d0bb-459e-bfd1-05d0fe43fba0)
![Screenshot 2023-11-28 125433](https://github.com/esware/Yapay_Zeka_Algoritmalari_1/assets/48649947/7a4e4d17-4035-4c6c-a689-01a59db56e3b)

Projenin Geliştirme Süreci

Proje, Java dilinde geliştirilmiştir. JUnit kullanılarak test edilmiştir.

Projenin Gelecekteki Geliştirme Yönleri

Projeye yeni algoritmalar eklenebilir. Performans iyileştirilebilir.

Projenin Kaynakları

A* Arama: https://en.wikipedia.org/wiki/A*_search_algorithm
Uniform Cost Arama: https://en.wikipedia.org/wiki/Uniform-cost_search
Genetik Algoritma: https://en.wikipedia.org/wiki/Genetic_algorithm
