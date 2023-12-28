BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "drzava" (
	"id"	INTEGER,
	"naziv"	TEXT,
	"glavni_grad"	INTEGER,
	CONSTRAINT "drzava_pf" PRIMARY KEY("id"),
	FOREIGN KEY("glavni_grad") REFERENCES "grad"
);
CREATE TABLE IF NOT EXISTS "grad" (
	"id"	INTEGER,
	"naziv"	TEXT,
	"broj_stanovnika"	INTEGER,
	"drzava"	INTEGER,
	CONSTRAINT "grad_pk" PRIMARY KEY("id"),
	CONSTRAINT "drzava_fk" FOREIGN KEY("drzava") REFERENCES "drzava"("id")
);
INSERT INTO "drzava" VALUES (1,'Bosna i Hercegovina',1);
INSERT INTO "drzava" VALUES (2,'Turska',2);
INSERT INTO "drzava" VALUES (3,'Francuska',3);
INSERT INTO "drzava" VALUES (4,'Italija',4);
INSERT INTO "drzava" VALUES (5,'Njemačka',5);
INSERT INTO "drzava" VALUES (6,'Austrija',6);
INSERT INTO "drzava" VALUES (7,'Hrvatska',7);
INSERT INTO "drzava" VALUES (8,'Engleska',8);
INSERT INTO "drzava" VALUES (9,'Španija',9);
INSERT INTO "drzava" VALUES (10,' Egipat',10);
INSERT INTO "drzava" VALUES (11,'Japan',11);
INSERT INTO "drzava" VALUES (12,'Kina',12);
INSERT INTO "grad" VALUES (1,'Sarajevo',300000,1);
INSERT INTO "grad" VALUES (2,'Ankara',5500000,2);
INSERT INTO "grad" VALUES (3,'Pariz',2200000,3);
INSERT INTO "grad" VALUES (4,'Rim',2800000,4);
INSERT INTO "grad" VALUES (5,'Berlin',3700000,5);
INSERT INTO "grad" VALUES (6,'Beč',1900000,6);
INSERT INTO "grad" VALUES (7,'Zagreb',800000,7);
INSERT INTO "grad" VALUES (8,'London',14000000,8);
INSERT INTO "grad" VALUES (9,'Madrid',3300000,9);
INSERT INTO "grad" VALUES (10,'Kairo',20000000,10);
INSERT INTO "grad" VALUES (11,'Tokio',37000000,11);
INSERT INTO "grad" VALUES (12,'Peking',21000000,12);
COMMIT;
