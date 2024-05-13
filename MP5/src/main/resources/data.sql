
insert into aircraft (id, brand) values (1, 'Boeing'), (2, 'Airbus');


insert into engine (id, type, aircraft_id) values (1, 'Jet', 1), (2, 'Jet', 1);
insert into engine (id, type, aircraft_id) values (3, 'Turbofan', 2), (4, 'Turbofan', 2);

insert into airport (id, airportname) values (1, 'WAW'), (2, 'IST');


insert into crew (id, role) values (1, 'Captain'), (2, 'Host');


insert into passenger (id, name) values (1, 'Abu'), (2, 'Buca');


insert into flights (idflights, flightsnumber, aircraft_id, departure_airport_id, arrival_airport_id) values
                                                                                                          (1, 'TK2222', 1, 1, 2),
                                                                                                          (2, 'TK2121', 2, 2, 1);

insert into flight_crew (flight_id, crew_id) values (1, 1), (2, 2);


insert into flight_passenger (flight_id, passenger_id) values (1, 1), (2, 2);
