Program nie jest gotowy - siedziałem nad nim tydzień, muszę dodać jakieś małe szczegóły typu detekcja błędów w niektórych miejscach i nie zdążyłem przypisać obiektów klasy ItemInfo do użytkownika - nie wiadomo co kto wypożyczył. 
Wyszukiwanie przedmiotow dziala średnio - nie sprawdza czy przedmiot jest np książka czy płytą - do poprawy (dwa obiekty różnych klas dziedziczących z ItemInfo o tym samym tytule powodują bład). Mam już pomysł jak to zrobić.
Umiem to wszystko zrobić, tylko brakło mi czasu. Postaram się podesłać gotowy program do końca tygodnia. :)

Krotki opis

Przedmioty sa znajdowane po id UUID albo po tytule
Book, mucial cd itp dziedzicza z ItemInfo
Inventory obsluguje baze przedmiotow
rentalrules magazynuje metody dotyczace wypozyczenia naliczania kar itp
userbase magazynuje userow, user nadaje podstawowe info i zmienne dotyczace uzytykownika

userbase dziala analogicznie do inventory