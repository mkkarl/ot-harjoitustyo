# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla on tarkoitus tallentaa ja tarkastella sukututkimuksessa oleellisia tietoja henkilöistä.
Näitä ovat nimitiedot, syntymä- ja kuolinaika ja -paikka.

## Perusversion tarjoama toiminnallisuus

Sovelluksen käyttö ei vaadi kirjautumista, vaan se avatuu ilman erillistä kirjautumista.
Sovellus toimii paikallisesti omalla koneella, joten riski väärinkäytölle ei ole yhtä suuri verkossa olevalle tiedolle, etenkin, jos kone pidetään irti verkosta.

Tiedot tallennetaan tietokantaan. Graafisessa käyttöliittymässä voidaan
* luoda uusia henkilöitä
* muokata olemassa olevien henkilöiden tietoja
* tutkailla henkilöitä listattuina nappeina

## Jatkokehitysideoita

Koska ohjelmassa käsitellään henkilötietoja, niin siihen voisi tehdä mahdollisuuden tallentaa rekisteriselosteen.

**Ohjelmaan voisi toteuttaa seuraavat ominaisuudet:**
* Sukulaisuussuhteet
* Graafinen sukupuu 
* Henkilöille lisää tallennettavia tietoja, kuten esimerkiksi kuva ja elämäntarina.

Sovellukseen voisi lisätä myös käyttäjätunnukset eri rooleineen (pääkäyttäjä, tavallinen käyttäjä).
Käyttäjätunnuksia voisi hyödyntää tallennettujen tietojen lokitiedoissa.
