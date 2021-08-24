# MuzeuFagaras

### run

Am facut o aplicatie spring boot sa fie mai usor. se impacheteaza ca jar si trebuie rulata java
-jar <jarfile>
Puteti sa rulati si din Intellij sau exlipse (gasiti pe google)

### DB

In DB sunt doua tabele:

- museum_rooms - detalii despre o camera
- media_files - fisierele pentru o camera (poze sau audio) (fisierul efectiv este tinut ca byte[] pe
  care trebuie sa il transformati inapoi in fisier)

### resources

in directorul resources am pus 2 scripturi sql care sa va ajute sa creati tabelele si sa populati
tabela cu camere

ordinea de executie este: tables.sql si apoi initial_load.sql Initial_load.sql

trebuie sa il completati voi astfel incat sa puneti datele voastre (e bine sa il aveti pe git odata
ce l-ati completat)

pentru descriere o sa fie ceva de genul: descriere_part1 placeholder_poza1 descriere_part2
placeholder_poza2

pentru a face initial load la fisiere, am creat un endpoint care sa ia din directoare si sa
introduca in baza de date. ierarhia directoarelor va fi: basedir -> 1,2,3 etc (numarul camerei din
tabela de mai sus) -> 1-fis1.png, 2-fis2.png, 3-fix3.mp3

REMARK; directorul din care pleaca acesta logica este pus de voi in application.properties ca
valoare pentru "files.import.path"

HINT: ar fi bine sa puneti o numetare in fata fisierului astfel incat in Android cand trebuie sa
puneti pozele in locul placeholderelor de poze din descriere sa stiti ce poza trebuie pusa

metoda initial load este MediaFilesController -> importFilesFrompath (Ep: GET / "
/files/initial-load") 
