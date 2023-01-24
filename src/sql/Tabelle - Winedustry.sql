-- create schema winedustry;
use winedustry;

CREATE TABLE utente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) UNIQUE NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL
);

CREATE TABLE informazioni (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    cognome VARCHAR(50),
    codice_fiscale VARCHAR(16) UNIQUE,
    data_nascita DATE,
    telefono VARCHAR(10),
    utente_id INT REFERENCES utente (id)
);

CREATE TABLE indirizzo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    via VARCHAR(50),
    civico VARCHAR(8),
    cap INT,
    citta VARCHAR(50),
    provincia VARCHAR(2),
    utente_id INT REFERENCES utente (id),
    corriere_id INT REFERENCES corriere (id)
);

CREATE TABLE pagamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    carta VARCHAR(19) NOT NULL,
    circuito VARCHAR(20) NOT NULL,
    proprietario VARCHAR(50) NOT NULL,
    data_scadenza DATE NOT NULL,
    cvv INT NOT NULL,
    utente_id INT NOT NULL REFERENCES utente (id)
);

CREATE TABLE prodotto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL DEFAULT 'Bevanda',
    nome VARCHAR(250) NOT NULL,
    produttore VARCHAR(50),
    formato DOUBLE,
    prezzo DOUBLE NOT NULL,
    valutazione INT,
    nazione VARCHAR(50),
    immagine VARCHAR(500) DEFAULT 'https://cdn-icons-png.flaticon.com/512/2309/2309443.png',
    descrizione VARCHAR(5000) DEFAULT 'Descrizione',
    gradazione INT,
    temp_servizio INT DEFAULT 0,
    temp_max_servizio INT DEFAULT 0,
    fermentazione VARCHAR(50),
    gusto VARCHAR(50),
    caratteristiche VARCHAR(50),
    varieta VARCHAR(50),
    categoria VARCHAR(50) NOT NULL,
    vitigno VARCHAR(50),
    denominazione VARCHAR(50),
    annata varchar(12) default 'Senza Annata',
    regione_id INT REFERENCES regione (id),
    affinamento VARCHAR(50),
    dosaggio VARCHAR(50),
    metodo VARCHAR(50)
);

CREATE TABLE regione (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    capoluogo VARCHAR(50),
    descrizione VARCHAR(5000) DEFAULT 'Descrizione',
    immagine VARCHAR(500)
);

CREATE TABLE carrello (
    id INT PRIMARY KEY AUTO_INCREMENT,
    utente_id INT REFERENCES utente (id)
);

CREATE TABLE carrello_item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantita INT NOT NULL,
    carrello_id INT NOT NULL REFERENCES carrello (id),
    prodotto_id INT NOT NULL REFERENCES prodotto (id)
);

CREATE TABLE ordine (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(12) UNIQUE NOT NULL,
    totale DOUBLE NOT NULL,
    utente_id INT NOT NULL REFERENCES carrello (utente_id),
    carrello_id INT NOT NULL REFERENCES carrello (id),
    spedizione_id INT REFERENCES spedizione (id)
);

CREATE TABLE corriere (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(12) UNIQUE NOT NULL,
    nome VARCHAR(50) NOT NULL,
    p_iva VARCHAR(11) UNIQUE NOT NULL,
    capitale DOUBLE
);

CREATE TABLE spedizione (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(12) UNIQUE NOT NULL,
    colli INT NOT NULL,
    peso INT NOT NULL
);