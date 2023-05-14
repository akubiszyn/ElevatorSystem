# ElevatorSystem
System obsługi wind
Alicja Kubiszyn

Założenia systemu
-system powinien obsługiwać przywołania windy
-system powinien uaktualniać stan windy
-system powinien wykonać krok symulacji
-system powinien umożliwiać sprawdzenie stanu systemu (na którym piętrze windy są i do którego zmierzają)
1. Klasa ElevatorSystem - opis metod
- pickup - zgłoszenie windy - na podstawie piętra zgłoszenia i kierunku wybierana jest winda, która obsłuży klienta

- assignCustomers - jeśli winda przejeżdża przez piętro, na którym czeka klient i winda zmierza w tą samą stronę co zamierza klient, winda go zabierze

- step  - jeden krok w symulacji - windy przesuwają się o jedno piętro

- checkIfDstFloor - metoda sprawdzająca, czy winda jest na piętrze docelowym (które może być piętrem przywołania lub piętrem wybranym przez klienta)

- addNewCustomers - dodaje nowych klientów do wybranej windy

- pickupCustomer i getFloor- obsługa klienta, który wszedł do windy

- printMsg - metoda do wypisywania na ekran komunikatów

- status - zwraca stan każdej windy - na którym piętrze aktualnie dana winda jest oraz do którego piętra zmierza

2. Klasa Elevator 
Klasa posiada atrybuty: elevatorId, currentFloor, listę piętr: dstFloor, isFree oraz listę klientów: elCustomers
3. Klasa Customer
Klasa posiada atrybuty: customerId, srcFloor, direction, dstFloor

