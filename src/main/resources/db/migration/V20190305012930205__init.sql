CREATE TABLE digidex (
	id serial NOT NULL,
	"name" text NOT NULL,
	"attribute" text NOT NULL,
	image text NULL,
	"level" text NULL,
	"type" text NULL,
	CONSTRAINT digidex_pkey PRIMARY KEY (id)
);

CREATE TABLE digimon (
	"name" text NOT NULL,
	created_at date NOT NULL,
	weight float8 NOT NULL,
	digidex_id int4 NULL,
	CONSTRAINT digimon_pkey PRIMARY KEY (name),
	CONSTRAINT digimon_digidex_id_fkey FOREIGN KEY (digidex_id) REFERENCES digidex(id)
);

CREATE TABLE trainer (
	id serial NOT NULL,
	"name" text NOT NULL,
	created_at date NOT NULL,
	digimon_name text NULL,
	CONSTRAINT trainer_pkey PRIMARY KEY (id),
	CONSTRAINT trainer_digimon_name_fkey FOREIGN KEY (digimon_name) REFERENCES digimon(name)
);
