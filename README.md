# Sukupuu-sovellus

Sukupuusovelluksen avulla käyttäjä voi hallita sukututkimuksessa kerättäviä tietoja.

## Käyttöohje

Kun sovellus käyynistetään, ensin joko luodaan uusi tietokanta (tiedostopääte .db) napista 'Istuta uusi sukupuu' tai avataan olemassa oleva tietokanta napista 'Avaa sukupuu'. Seuraavaksi aloitetaan puun tutkiminen napista 'Tutki puuta'.

Sukupuu-näkymässä joko avataan olemassa olevan henkilön tiedot henkilön napista tai luodaan uusi henkilö napista 'Luo uusi henkilö'.

Henkilötietonäkymässä annetaan tiedetyt henkilötiedot ja ne tallennetaan painamalla nappia 'Tallenna'. Sukupuu-näkymään palataan napista 'Palaa puuhun', joka ei tallenna annettuja tietoja.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/mkkarl/ot-harjoitustyo/blob/master/Sukupuusovellus/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/mkkarl/ot-harjoitustyo/blob/master/Sukupuusovellus/dokumentointi/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/mkkarl/ot-harjoitustyo/blob/master/Sukupuusovellus/dokumentointi/tuntikirjanpito.md)

## Releaset

[Viikko 5](https://github.com/mkkarl/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/mkkarl/ot-harjoitustyo/releases/tag/viikko6)

[Loppupalautus](https://github.com/mkkarl/ot-harjoitustyo/releases/tag/loppupalautus)

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
