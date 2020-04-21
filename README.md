# Sukupuu-sovellus

Sukupuusovelluksen avulla käyttäjä voi hallita sukututkimuksessa kerättäviä tietoja.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/mkkarl/ot-harjoitustyo/blob/master/Sukupuusovellus/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/mkkarl/ot-harjoitustyo/blob/master/Sukupuusovellus/dokumentointi/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/mkkarl/ot-harjoitustyo/blob/master/Sukupuusovellus/dokumentointi/tuntikirjanpito.md)

## Releaset

[Viikko 5](https://github.com/mkkarl/ot-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot

### Testaus

Testit suoritetaat komennolla


```
mvn test
```

Testikattavuusraportti luodaan komennolla


```
mvn jacoco:report
```


Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html


### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon target suoritettavan jar-tiedoston Sukupuusovellus-1.0-SNAPSHOT.jar

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mkkarl/ot-harjoitustyo/blob/master/Sukupuusovellus/checkstyle.xml) määritellyt tarkistusḱset suoritetaan komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset viheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html
